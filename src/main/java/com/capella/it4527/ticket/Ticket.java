package com.capella.it4527.ticket;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Id;




// Annotation added to enable polymorphic deserialization based on the "type" field
@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = TaskTicket.class, name = "task"),
    @JsonSubTypes.Type(value = BugTicket.class, name = "bug")
})

// Adding annotation for interface with JPA

@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

// Change class to abstract so it can't be directly instantiated
public abstract class Ticket {
    @Id
    protected int id;
    protected String title;
    protected String type;
    protected int priority;
    protected String status;



    // Constructor
    public Ticket(int id, String title, String type, int priority, String status) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.priority = priority;
        this.status = status;
    }

    protected Ticket() {
    // Required by JPA
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

