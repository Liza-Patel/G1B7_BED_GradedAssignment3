package com.greatlearning.TicketTracker.service;

import java.util.List;
import java.util.Optional;

import com.greatlearning.TicketTracker.entity.Ticket;

public interface TicketService {

	List<Ticket> getAllTickets();

	Optional<Ticket> viewTickectById(int id);

	Ticket saveTicket(Ticket ticket);

	Ticket getTicketById(int id);

	List<Ticket> getByTitleOrDescription(String query);

	Ticket updateTicket(Ticket ticket);

	void deleteTicketById(int id);

	String formattedDate();

}
