package com.capella.it4527.controller;

import com.capella.it4527.ticket.Ticket;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@RestController
public class TicketController {

    // Save a basic ticket
    @RequestMapping("/ticket/put")
    public String createTicket(@RequestParam int id, @RequestParam String title) {
        Ticket ticket = new Ticket(id, title, "basic", 1, "Open");

        try (FileWriter writer = new FileWriter(id + ".txt")) {
            writer.write(ticket.toString());
        } catch (IOException e) {
            return "Failed to save ticket.";
        }

        return "Ticket saved as: " + id + ".txt";
    }

    // Retrieve ticket text from a file
    @RequestMapping("/ticket/get")
    public String getTicket(@RequestParam int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(id + ".txt"))) {
            return reader.readLine(); // return just the first line of the file
        } catch (IOException e) {
            return "Failed to load ticket.";
        }
    }
}
