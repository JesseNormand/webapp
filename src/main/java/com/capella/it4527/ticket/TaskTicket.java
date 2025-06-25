package com.capella.it4527.ticket;

import jakarta.persistence.Entity;

@Entity

// This class extends the abstract Ticket base class
public class TaskTicket extends Ticket {
    private String task;

    // set type to "task"
    public TaskTicket(int id, String title, int priority, String status, String task) {
        super(id, title, "task", priority, status);
        this.task = task;
    }

    public TaskTicket() {
    super(0, "", "task", 0, "Open");
    this.task = "";
    }


    // Getters and Setters
    public String getTask() { return task; }
    public void setTask(String task) { this.task = task; }

    @Override
    public String toString() {
        return super.toString() + ", Task: " + task;
    }
}
