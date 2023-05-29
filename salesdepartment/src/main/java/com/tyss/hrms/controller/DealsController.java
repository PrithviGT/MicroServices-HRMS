package com.tyss.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.hrms.dto.DealsDto;
import com.tyss.hrms.service.DealsService;

@RestController
@RequestMapping("/salesdepartment/deal")
public class DealsController {

	@Autowired
	private DealsService dealsService;

	@PutMapping("/{did}")
	public ResponseEntity<DealsDto> updateDeals(@RequestBody DealsDto dealsDto, @PathVariable Integer did) {
		DealsDto updateDeal = this.dealsService.updateDeal(dealsDto, did);
		return new ResponseEntity<DealsDto>(updateDeal, HttpStatus.CREATED);
	}

	@DeleteMapping("/{did}")
	public ResponseEntity<?> deleteDeals(@PathVariable Integer did) {
		this.dealsService.deleteDeal(did);
		return ResponseEntity.ok().body("Deal deleted with Id : " + did);
	}

	@GetMapping
	public ResponseEntity<List<DealsDto>> getAllDeals() {
		List<DealsDto> allDeals = this.dealsService.getAllDeals();
		return new ResponseEntity<List<DealsDto>>(allDeals, HttpStatus.OK);
	}

	@GetMapping("/{did}")
	public ResponseEntity<DealsDto> getDealById(@PathVariable Integer did) {
		DealsDto dealById = this.dealsService.getDealById(did);
		return new ResponseEntity<DealsDto>(dealById, HttpStatus.OK);
	}

}
