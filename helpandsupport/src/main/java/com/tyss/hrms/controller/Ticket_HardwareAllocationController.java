package com.tyss.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.hrms.dto.Ticket_HardwareAllocationDto;
import com.tyss.hrms.service.Ticket_HardwareService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/helpsupport/raiseticket")
@Slf4j
public class Ticket_HardwareAllocationController {

	@Autowired
	private Ticket_HardwareService ticket_HardwareService;

	@PostMapping
	public ResponseEntity<Ticket_HardwareAllocationDto> raiseTicket(
			@RequestBody Ticket_HardwareAllocationDto ticket_HardwareAllocationDto) {
		Ticket_HardwareAllocationDto raiseTicket = this.ticket_HardwareService
				.raiseTicket(ticket_HardwareAllocationDto);
		return new ResponseEntity<Ticket_HardwareAllocationDto>(raiseTicket, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Ticket_HardwareAllocationDto>> getAllTickets() {
		log.info("Here for Log");
		List<Ticket_HardwareAllocationDto> allTickets = this.ticket_HardwareService.getAllTickets();
		return new ResponseEntity<List<Ticket_HardwareAllocationDto>>(allTickets, HttpStatus.OK);
	}

	@GetMapping("/{ticketId}")
	public ResponseEntity<Ticket_HardwareAllocationDto> getSingleTicket(@PathVariable Integer ticketId) {
		Ticket_HardwareAllocationDto singleTicket = this.ticket_HardwareService.getSingleTicket(ticketId);
		return new ResponseEntity<Ticket_HardwareAllocationDto>(singleTicket, HttpStatus.OK);
	}

	@PostMapping("/accept/{status}/{acceptedby}/{ticketId}")
	public ResponseEntity<?> accept(@PathVariable String status, @PathVariable String acceptedby,
			@PathVariable Integer ticketId) {
		Ticket_HardwareAllocationDto acceptStatus = this.ticket_HardwareService.acceptStatus(status, acceptedby,
				ticketId);
//		if (acceptStatus != null) {
			return new ResponseEntity<Ticket_HardwareAllocationDto>(acceptStatus, HttpStatus.OK);
//		} else {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ticket is already accepted");
//		}
	}

	@PostMapping("/resolve/{status}/{action}/{ticketId}")
	public ResponseEntity<?> resolve(@PathVariable String status, @PathVariable String action,
			@PathVariable Integer ticketId) {
		Ticket_HardwareAllocationDto resolveStatus = this.ticket_HardwareService.resolveStatus(status, action,
				ticketId);
//		if (resolveStatus != null) {
			return new ResponseEntity<Ticket_HardwareAllocationDto>(resolveStatus, HttpStatus.OK);
//		} else {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ticket not accepted");
//		}
	}

	@PostMapping("/delegate/{status}/{department}/{ticketId}")
	public ResponseEntity<?> delegate(@PathVariable String status, @PathVariable String department,
			@PathVariable Integer ticketId) {
		Ticket_HardwareAllocationDto delegateStatus = this.ticket_HardwareService.delegateStatus(status, department,
				ticketId);
//		if (delegateStatus != null) {
			return new ResponseEntity<Ticket_HardwareAllocationDto>(delegateStatus, HttpStatus.OK);
//		} else {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ticket not accepted");
//		}

	}
	
	
	@PostMapping("/release/{status}/{action}/{ticketId}")
	public ResponseEntity<?> release(@PathVariable String status, @PathVariable String action,
			@PathVariable Integer ticketId) {
		Ticket_HardwareAllocationDto releaseStatus = this.ticket_HardwareService.releaseStatus(status, action, ticketId);
//		if (releaseStatus != null) {
			return new ResponseEntity<Ticket_HardwareAllocationDto>(releaseStatus, HttpStatus.OK);
//		} else {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ticket not accepted");
//		}
	}
	
	
}
