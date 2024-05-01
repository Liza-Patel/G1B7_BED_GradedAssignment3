package com.greatlearning.TicketTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.TicketTracker.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	public List<Ticket> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title,
			String description);

}
