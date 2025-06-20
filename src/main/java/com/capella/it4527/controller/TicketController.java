package com.capella.it4527.controller;

import com.capella.it4527.ticket.Ticket;
import org.springframework.web.bind.annotation.*;
import com.capella.it4527.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


import java.util.List;


import java.io.FileWriter;
import java.io.IOException;

@RestController
public class TicketController {

    // ✅ Injecting the repository to access the database
    @Autowired
    private TicketRepository ticketRepository;

    // ✅ Changed from multiple @RequestParam to a single @RequestBody argument
    // Jackson will use polymorphic deserialization based on "type"
    // ✅ Saves the ticket to the database instead of a file
    @PostMapping("/ticket/put")
    public String createTicket(@RequestBody Ticket ticket) {
        ticketRepository.save(ticket);
        return "Ticket saved with ID: " + ticket.getId();
    }



     // ✅ Retrieves ticket by ID from the database
    @GetMapping("/ticket/get")
    public Ticket getTicket(@RequestParam int id) {
        Optional<Ticket> result = ticketRepository.findById(id);
        return result.orElse(null);
    }

    // ✅ Deletes ticket record from the database by ID
    @DeleteMapping("/ticket/delete")
    public String deleteTicket(@RequestParam int id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
            return "Deleted ticket with ID: " + id;
        }
        return "";
    }


     // ✅ New method: Retrieves all tickets by type
    @GetMapping("/ticket/getbytype")
    public List<Ticket> getTicketByType(@RequestParam String type) {
        return ticketRepository.findByType(type);
    }

}
