package com.tyss.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.hrms.dto.ContactPersonDto;
import com.tyss.hrms.service.ContactPersonService;

@RestController
@RequestMapping("/salesdepartment/contactperson")
public class ContactPersonController {

	@Autowired
	private ContactPersonService contactPersonService;

	@PostMapping("/lead/{lid}")
	public ResponseEntity<ContactPersonDto> createContactPersonAndAssignToLeads(
			@RequestBody ContactPersonDto contactPersonDto, @PathVariable Integer lid) {
		ContactPersonDto createLeadContactPersonDeatils = this.contactPersonService
				.createLeadContactPersonDeatils(contactPersonDto, lid);
		return new ResponseEntity<ContactPersonDto>(createLeadContactPersonDeatils, HttpStatus.CREATED);
	}

	@PostMapping("/deal/{did}")
	public ResponseEntity<ContactPersonDto> createContactPersonAndAssignToDeals(
			@RequestBody ContactPersonDto contactPersonDto, @PathVariable Integer did) {
		ContactPersonDto createDealContactPersonDeatils = this.contactPersonService
				.createDealContactPersonDeatils(contactPersonDto, did);
		return new ResponseEntity<ContactPersonDto>(createDealContactPersonDeatils, HttpStatus.CREATED);
	}

}
