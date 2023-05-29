package com.tyss.hrms.service;

import java.util.List;

import com.tyss.hrms.dto.Ticket_HardwareAllocationDto;

public interface Ticket_HardwareService {

	Ticket_HardwareAllocationDto raiseTicket(Ticket_HardwareAllocationDto ticket_HardwareAllocationDto);
	
	List<Ticket_HardwareAllocationDto> getAllTickets();
	
	Ticket_HardwareAllocationDto getSingleTicket(Integer ticketId);
	
	Ticket_HardwareAllocationDto acceptStatus(String status,String acceptedBy,Integer ticketId);
	
	Ticket_HardwareAllocationDto resolveStatus(String status,String action, Integer ticketId);
	
	Ticket_HardwareAllocationDto delegateStatus(String status,String department,Integer ticketId);
	
	Ticket_HardwareAllocationDto releaseStatus(String status,String action,Integer ticketId);
	
}
