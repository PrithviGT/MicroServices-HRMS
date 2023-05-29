package com.tyss.hrms.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.hrms.dto.ContactPersonDto;
import com.tyss.hrms.entity.ContactPerson;
import com.tyss.hrms.entity.Deals;
import com.tyss.hrms.entity.Leads;
import com.tyss.hrms.exception.ResourceNotFoundException;
import com.tyss.hrms.repo.ContactPersonRepo;
import com.tyss.hrms.repo.DealsRepo;
import com.tyss.hrms.repo.LeadsRepo;
import com.tyss.hrms.service.ContactPersonService;

@Service
public class ContactPersonServiceImpl implements ContactPersonService {

	@Autowired
	private ContactPersonRepo contactPersonRepo;

	@Autowired
	private LeadsRepo leadsRepo;

	@Autowired
	private DealsRepo dealsRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ContactPersonDto createLeadContactPersonDeatils(ContactPersonDto contactPersonDto, Integer lid) {
		Leads lead = this.leadsRepo.findById(lid).orElseThrow(() -> new ResourceNotFoundException("Invalid lead Id"));

		ContactPerson contactPerson = this.modelMapper.map(contactPersonDto, ContactPerson.class);

		contactPerson.setLeads(lead);

		ContactPerson save = this.contactPersonRepo.save(contactPerson);

		return this.modelMapper.map(save, ContactPersonDto.class);
	}

	@Override
	public ContactPersonDto createDealContactPersonDeatils(ContactPersonDto contactPersonDto, Integer did) {
		Deals deal = this.dealsRepo.findById(did).orElseThrow(() -> new ResourceNotFoundException("Invalid deal Id"));

		ContactPerson contactPerson = this.modelMapper.map(contactPersonDto, ContactPerson.class);

		contactPerson.setDeals(deal);

		ContactPerson save = this.contactPersonRepo.save(contactPerson);

		return this.modelMapper.map(save, ContactPersonDto.class);

	}

}
