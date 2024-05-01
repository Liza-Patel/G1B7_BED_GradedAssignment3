package com.greatlearning.TicketTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.TicketTracker.entity.Ticket;
import com.greatlearning.TicketTracker.service.TicketServiceImpl;

@Controller
public class TicketController {

	@Autowired
	TicketServiceImpl ticketService;

	@GetMapping("/tickets")
	public String listOftickets(Model model) {
		List<Ticket> ticketList = ticketService.getAllTickets();
		model.addAttribute("tickets", ticketList);
		return "tickets";

	}

	@GetMapping("/tickets/new")
	public String createTicket(Model model) {
		Ticket ticket = new Ticket();

		model.addAttribute("ticket", ticket);
		return "create-ticket";

	}

	@GetMapping("/search")
	public String getByTitleandDescription(@RequestParam String query, Model model) {
		List<Ticket> ticketList = ticketService.getByTitleOrDescription(query);
		model.addAttribute("searchTickets", ticketList);
		return "search-result";

	}

	@GetMapping("/tickets/edit/{id}")
	public String editTicket(@PathVariable int id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute(ticket);
		return "edit-ticket";

	}

	@GetMapping("/tickets/{id}")
	public String deleteTicket(@PathVariable int id) {
		ticketService.deleteTicketById(id);
		return "redirect:/tickets";
	}

	@GetMapping("/view/{id}")
	public String viewTicket(@PathVariable int id, Model model) {

		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute(ticket);
		return "view-ticket";
	}

	@PostMapping("/tickets/new")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {

		ticket.setDate(ticketService.formattedDate());
		ticketService.saveTicket(ticket);
		return "redirect:/tickets";

	}

	@PostMapping("/tickets/{id}")
	public String editTicket(@PathVariable int id, @ModelAttribute("ticket") Ticket newTicket) {
		Ticket ticket = ticketService.getTicketById(id);
		ticket.setTitle(newTicket.getTitle());
		ticket.setDescription(newTicket.getDescription());
		ticket.setDate(ticketService.formattedDate());
		ticket.setContent(newTicket.getContent());
		ticketService.updateTicket(ticket);
		return "redirect:/tickets";
	}

}
