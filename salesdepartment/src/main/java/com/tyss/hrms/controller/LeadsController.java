package com.tyss.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.hrms.dto.LeadsDto;
import com.tyss.hrms.service.LeadsService;

@RestController
@RequestMapping("/salesdepartment/lead")
public class LeadsController {

	@Autowired
	private LeadsService leadsService;

	@PostMapping
	public ResponseEntity<LeadsDto> createLeads(@RequestBody LeadsDto leadsDto) {
		LeadsDto createLead = this.leadsService.createLead(leadsDto);
		return new ResponseEntity<LeadsDto>(createLead, HttpStatus.CREATED);
	}

	@PutMapping("/{lid}")
	public ResponseEntity<?> updateLeads(@RequestBody LeadsDto leadsDto, @PathVariable Integer lid) {
		LeadsDto updateLead = this.leadsService.updateLead(leadsDto, lid);
		if (updateLead != null) {
			return new ResponseEntity<LeadsDto>(updateLead, HttpStatus.CREATED);
		} else {
			return ResponseEntity.ok().body("Lead moved to deals");
		}

	}

	@DeleteMapping("/{lid}")
	public ResponseEntity<?> deleteLead(@PathVariable Integer lid) {
		this.leadsService.deleteLead(lid);
		return ResponseEntity.ok().body("Lead deleted with Id : " + lid);
	}

	@GetMapping
	public ResponseEntity<?> getAllLeads() {
		List<LeadsDto> allLeads = this.leadsService.getAllLeads();
		return new ResponseEntity<>(allLeads, HttpStatus.OK);
	}

	@GetMapping("/{lid}")
	public ResponseEntity<LeadsDto> getLeadById(@PathVariable Integer lid) {
		LeadsDto singleLead = this.leadsService.getSingleLead(lid);
		return new ResponseEntity<LeadsDto>(singleLead, HttpStatus.OK);
	}

}
