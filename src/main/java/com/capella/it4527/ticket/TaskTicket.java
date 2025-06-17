package com.capella.it4527.ticket;

public class TaskTicket extends Ticket {
    private String task;

    // set type to "task"
    public TaskTickets(int id, String title, int priority, String status, String task) {
        super(id, title, "task", priority, status);
        this.task = task;
    }

    // Getters and Setters
    public String getTask() { return task; }
    public void setTask(String task) { this.task = task; }

    @Override
    public String toString() {
        return super.toString() + ", Task: " + task;
    }
}
