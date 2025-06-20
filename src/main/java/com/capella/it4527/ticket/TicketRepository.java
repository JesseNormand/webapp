package com.capella.it4527.ticket;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends ListCrudRepository<Ticket, Integer> {
    
    List<Ticket> findByType(String type);
    
} 
