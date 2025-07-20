package com.capella.it4527.ticket;

import com.capella.it4527.ticket.Ticket;
import com.capella.it4527.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Cacheable("tickets")
    public Ticket getTicketById(int id) {
        System.out.println("getTicketById() called for ID: " + id);
        Optional<Ticket> result = ticketRepository.findById(id);
        return result.orElse(null);
    }

    @Cacheable("tickets")
    public List<Ticket> getTicketsByType(String type) {
        System.out.println("getTicketsByType() called for type: " + type);
        return ticketRepository.findByType(type);
    }

    @CacheEvict(value = "tickets", allEntries = true)
    public void clearCache() {
        System.out.println("clearCache() called — ticket cache cleared.");
    }

    public boolean deleteById(int id) {
    if (ticketRepository.existsById(id)) {
        ticketRepository.deleteById(id);
        System.out.println("deleteById() called — deleted ticket with ID: " + id);
        return true;
    }
    System.out.println("deleteById() called — ticket ID not found: " + id);
    return false;
    }

    public int updateTicketStatus(String status, List<Integer> ticketIds) {
    List<Ticket> tickets = (List<Ticket>) ticketRepository.findAllById(ticketIds);
    System.out.println("updateTicketStatus() called — updating " + tickets.size() + " tickets to status: " + status);

    tickets.forEach(ticket -> ticket.setStatus(status)); // lambda function
    ticketRepository.saveAll(tickets);

    return tickets.size();
    }


}

