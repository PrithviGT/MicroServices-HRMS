package com.tyss.hrms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.tyss.hrms.dto.Ticket_HardwareAllocationDto;
import com.tyss.hrms.entity.RaiseTicket_HardwareAllocation;
import com.tyss.hrms.exception.ResourceNotFoundException;
import com.tyss.hrms.repository.Ticket_HardwareAllocationRepo;
import com.tyss.hrms.service.Ticket_HardwareService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ticket_HardwareAllocationServiceImpl implements Ticket_HardwareService {

	@Autowired
	private Ticket_HardwareAllocationRepo ticket_HardwareAllocationRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Ticket_HardwareAllocationDto raiseTicket(Ticket_HardwareAllocationDto ticket_HardwareAllocationDto) {

		RaiseTicket_HardwareAllocation raiseTicket = this.modelMapper.map(ticket_HardwareAllocationDto,
				RaiseTicket_HardwareAllocation.class);

		raiseTicket.setStatus("CREATED");

		RaiseTicket_HardwareAllocation save = this.ticket_HardwareAllocationRepo.save(raiseTicket);

		return this.modelMapper.map(save, Ticket_HardwareAllocationDto.class);
	}

	@Override
	public List<Ticket_HardwareAllocationDto> getAllTickets() {
		List<RaiseTicket_HardwareAllocation> findAllTickets = this.ticket_HardwareAllocationRepo.findAll();
		return findAllTickets.stream().filter(e -> e.getDepartment().equalsIgnoreCase("IT"))
				.map(e -> this.modelMapper.map(e, Ticket_HardwareAllocationDto.class)).collect(Collectors.toList());
	}

	@Override
	public Ticket_HardwareAllocationDto getSingleTicket(Integer ticketId) {
		RaiseTicket_HardwareAllocation raiseTicket_HardwareAllocation = this.ticket_HardwareAllocationRepo
				.findById(ticketId).orElseThrow(()-> new ResourceNotFoundException("Invalid ticket Id"));
		
		return this.modelMapper.map(raiseTicket_HardwareAllocation, Ticket_HardwareAllocationDto.class);
	}

	@Override
	public Ticket_HardwareAllocationDto acceptStatus(String status, String acceptedBy, Integer ticketId) {
		RaiseTicket_HardwareAllocation raiseTicket_HardwareAllocation = this.ticket_HardwareAllocationRepo
				.findById(ticketId).orElseThrow(()-> new ResourceNotFoundException("Invalid ticket Id"));
		
		if (raiseTicket_HardwareAllocation.getStatus().equalsIgnoreCase("CREATED") || raiseTicket_HardwareAllocation.getStatus().equalsIgnoreCase("RELEASED")) {
		raiseTicket_HardwareAllocation.setStatus(status);
		raiseTicket_HardwareAllocation.setAcceptedBy(acceptedBy);

		RaiseTicket_HardwareAllocation saveStatus = this.ticket_HardwareAllocationRepo
				.save(raiseTicket_HardwareAllocation);

		return this.modelMapper.map(saveStatus, Ticket_HardwareAllocationDto.class);
		} else {
			return null;
		}
	}

	@Override
	public Ticket_HardwareAllocationDto resolveStatus(String status, String action, Integer ticketId) {
		RaiseTicket_HardwareAllocation raiseTicket_HardwareAllocation = this.ticket_HardwareAllocationRepo
				.findById(ticketId).orElseThrow(()-> new ResourceNotFoundException("Invalid ticket Id"));
		
		if (raiseTicket_HardwareAllocation.getStatus().equalsIgnoreCase("ACCEPTED")) {
		
		raiseTicket_HardwareAllocation.setStatus(status);
		raiseTicket_HardwareAllocation.setAction(action);

		RaiseTicket_HardwareAllocation save = this.ticket_HardwareAllocationRepo.save(raiseTicket_HardwareAllocation);

		return this.modelMapper.map(save, Ticket_HardwareAllocationDto.class);
		} else {
			return null;
		}
	}

	@Override
	public Ticket_HardwareAllocationDto delegateStatus(String status, String department, Integer ticketId) {
		RaiseTicket_HardwareAllocation raiseTicket_HardwareAllocation = this.ticket_HardwareAllocationRepo
				.findById(ticketId).orElseThrow(()-> new ResourceNotFoundException("Invalid ticket Id"));

		System.out.println(raiseTicket_HardwareAllocation.getStatus());

		if (raiseTicket_HardwareAllocation.getStatus().equalsIgnoreCase("ACCEPTED")) {

			log.info("Here");
			raiseTicket_HardwareAllocation.setStatus(status);
			raiseTicket_HardwareAllocation.setDepartment(department);

			RaiseTicket_HardwareAllocation save = this.ticket_HardwareAllocationRepo
					.save(raiseTicket_HardwareAllocation);

			return this.modelMapper.map(save, Ticket_HardwareAllocationDto.class);
		} else {
			return null;
		}
	}

	@Override
	public Ticket_HardwareAllocationDto releaseStatus(String status, String action, Integer ticketId) {
		RaiseTicket_HardwareAllocation raiseTicket_HardwareAllocation = this.ticket_HardwareAllocationRepo
				.findById(ticketId).orElseThrow(()-> new ResourceNotFoundException("Invalid ticket Id"));

		if (raiseTicket_HardwareAllocation.getStatus().equalsIgnoreCase("ACCEPTED")) {
			
			raiseTicket_HardwareAllocation.setStatus(status);
			raiseTicket_HardwareAllocation.setAction(action);

			RaiseTicket_HardwareAllocation save = this.ticket_HardwareAllocationRepo
					.save(raiseTicket_HardwareAllocation);

			return this.modelMapper.map(save, Ticket_HardwareAllocationDto.class);
		} else {
			return null;
		}
	}

}
