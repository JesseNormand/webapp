package com.capella.it4527.ticket;

public class BugTicket extends Ticket {
    private String description;
    private int error;

    // set ticket type to "bug"
    public BugTicket(int id, String title, int priority, String status, String description, int error) {
        super(id, title, "bug", priority, status);
        this.description = description;
        this.error = error;
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
