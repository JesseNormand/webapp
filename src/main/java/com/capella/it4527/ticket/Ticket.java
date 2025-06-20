package com.capella.it4527.ticket;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

// Annotation added to enable polymorphic deserialization based on the "type" field
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = TaskTicket.class, name = "task"),
    @JsonSubTypes.Type(value = BugTicket.class, name = "bug")
})

// Change class to abstract so it can't be directly instantiated
public abstract class Ticket {
    private int id;
    private String title;
    private String type;
    private int priority;
    private String status;



    // Constructor
    public Ticket(int id, String title, String type, int priority, String status) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.priority = priority;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Convert Ticket to a string 
    @Override
    public String toString() {
        return "Ticket [id=" + id + ", title=" + title + ", type=" + type + 
               ", priority=" + priority + ", status=" + status + "]";
    }
}

