package com.capella.it4527.controller;

import com.capella.it4527.ticket.Ticket;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;

@RestController
public class TicketController {

    // ✅ Changed from multiple @RequestParam to a single @RequestBody argument
    // Jackson will use polymorphic deserialization based on "type"
    @PostMapping("/ticket/put")
    public String createTicket(@RequestBody Ticket ticket) {
        try (FileWriter writer = new FileWriter(ticket.getId() + ".txt")) {
            writer.write(ticket.toString());
        } catch (IOException e) {
            return "Failed to save ticket.";
        }

        return "Ticket saved as: " + ticket.getId() + ".txt";
    }

    @GetMapping("/ticket/get")
    public String getTicket(@RequestParam int id) {
        try (var reader = new java.io.BufferedReader(new java.io.FileReader(id + ".txt"))) {
            return reader.readLine();
        } catch (IOException e) {
            return "Failed to load ticket.";
        }
    }

    @DeleteMapping("/ticket/delete")
    public String deleteTicket(@RequestParam int id) {
        var file = new java.io.File(id + ".txt");
        if (file.exists() && file.delete()) {
            return id + ".txt";
        } else {
            return "";
        }
    }
}
