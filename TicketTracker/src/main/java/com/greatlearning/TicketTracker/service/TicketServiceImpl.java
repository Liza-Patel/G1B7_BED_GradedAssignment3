package com.greatlearning.TicketTracker.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.TicketTracker.entity.Ticket;
import com.greatlearning.TicketTracker.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepo;

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepo.findAll();
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	@Override
	public Ticket getTicketById(int id) {
		return ticketRepo.findById(id).get();
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	@Override
	public void deleteTicketById(int id) {
		ticketRepo.deleteById(id);

	}

	@Override
	public String formattedDate() {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = dateFormat.format(currentDate);
		return formattedDate;
	}

	@Override
	public List<Ticket> getByTitleOrDescription(String query) {
		return ticketRepo.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
	}

	@Override
	public Optional<Ticket> viewTickectById(int id) {

		return ticketRepo.findById(id);
	}

}
