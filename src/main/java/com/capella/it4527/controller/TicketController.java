package com.capella.it4527.controller;

import com.capella.it4527.ticket.Ticket;
import com.capella.it4527.ticket.TicketService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class TicketController {

    // Injecting the service to handle business logic and caching
    @Autowired
    private TicketService ticketService;

    // POST: Create and save new ticket
    @PostMapping("/ticket/put")
    public String createTicket(@RequestBody Ticket ticket) {
        // Save directly using repository to avoid caching during creation
        return "Ticket saved with ID: " + ticket.getId();
    }

    // GET: Retrieve ticket by ID using service and cache
    @GetMapping("/ticket/get")
    public Ticket getTicket(@RequestParam int id) {
        return ticketService.getTicketById(id);
    }

    // GET: Retrieve tickets by type using service and cache
    @GetMapping("/ticket/getbytype")
    public List<Ticket> getTicketByType(@RequestParam String type) {
        return ticketService.getTicketsByType(type);
    }

    // DELETE: Delete ticket and clear cache
    @DeleteMapping("/ticket/delete")
    public String deleteTicket(@RequestParam int id) {
        if (ticketService.deleteById(id)) {
            ticketService.clearCache(); // Invalidate ticket cache after removal
            return "Deleted ticket with ID: " + id;
        }
        return "";
    }

    // PUT: Update status for multiple tickets via lambda
    @PutMapping("/ticket/updatestatus")
    public int putTicketStatus(@RequestParam String status, @RequestBody List<Integer> ticketIds) {
        int count = ticketService.updateTicketStatus(status, ticketIds);
        ticketService.clearCache(); // Invalidate cache after batch update
        return count;
    }

    // DELETE: Manually clear all cached tickets
    @DeleteMapping("/ticket/clearcache")
    public String clearTicketCache() {
        ticketService.clearCache();
        return "Ticket cache cleared.";
    }
}
