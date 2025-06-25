package com.capella.it4527.ticket;

import jakarta.persistence.Entity;

// marks them as database-mapped entity tables
@Entity

public class BugTicket extends Ticket {
    private String description;
    private int error;

    // set ticket type to "bug"
    public BugTicket(int id, String title, int priority, String status, String description, int error) {
        super(id, title, "bug", priority, status);
        this.description = description;
        this.error = error;
    }

    public BugTicket() {
    super(0, "", "bug", 0, "Open");
    this.description = "";
    this.error = 0;
    }


    // Getters and Setters
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getError() { return error; }
    public void setError(int error) { this.error = error; }

    @Override
    public String toString() {
        return super.toString() + ", Description: " + description + ", Error Code: " + error;
    }
}
