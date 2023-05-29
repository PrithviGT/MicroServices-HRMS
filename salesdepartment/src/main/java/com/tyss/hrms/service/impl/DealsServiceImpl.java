package com.tyss.hrms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.hrms.dto.DealsDto;
import com.tyss.hrms.entity.ContactPerson;
import com.tyss.hrms.entity.Deals;
import com.tyss.hrms.exception.ResourceNotFoundException;
import com.tyss.hrms.repo.ContactPersonRepo;
import com.tyss.hrms.repo.DealsRepo;
import com.tyss.hrms.service.DealsService;

@Service
public class DealsServiceImpl implements DealsService {

	@Autowired
	private DealsRepo dealsRepo;
	
	@Autowired
	private ContactPersonRepo contactPersonRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DealsDto updateDeal(DealsDto dealsDto, Integer did) {
		Deals deals = this.dealsRepo.findById(did).orElseThrow(() -> new ResourceNotFoundException("Invalid deals Id"));

		deals.setAddress(dealsDto.getAddress());
		deals.setAnnualRevenue(dealsDto.getAnnualRevenue());
		deals.setCity(dealsDto.getCity());
		deals.setCompanyName(dealsDto.getCompanyName());

		deals.setCountry(dealsDto.getCountry());
		deals.setDescription(dealsDto.getDescription());
		deals.setDesignation(dealsDto.getDesignation());
		deals.setEmailId(dealsDto.getEmailId());
		deals.setFax(dealsDto.getFax());
		deals.setFirstName(dealsDto.getFirstName());
		deals.setIndustry(dealsDto.getIndustry());
		deals.setLastName(dealsDto.getLastName());
		deals.setLeadOwner(dealsDto.getLeadOwner());
		deals.setLeadOwner(dealsDto.getLeadOwner());
		deals.setLeadSource(dealsDto.getLeadSource());
		deals.setLeadStatus(dealsDto.getLeadStatus());
		deals.setMobileNo(dealsDto.getMobileNo());
		deals.setNoOfEmployees(dealsDto.getNoOfEmployees());
		deals.setPincode(dealsDto.getPincode());
		deals.setSecondaryEmailId(dealsDto.getSecondaryEmailId());
		deals.setSkypeId(dealsDto.getSkypeId());
		deals.setState(dealsDto.getState());
		deals.setTwitterId(dealsDto.getTwitterId());
		deals.setWebsite(dealsDto.getWebsite());

		Deals update = this.dealsRepo.save(deals);

		return this.modelMapper.map(update, DealsDto.class);
	}

	@Override
	public void deleteDeal(Integer did) {
		Deals deals = this.dealsRepo.findById(did).orElseThrow(() -> new ResourceNotFoundException("Invalid deals Id"));
		List<ContactPerson> contactPerson = deals.getContactPerson();
		
		for(ContactPerson c : contactPerson) {
			c.setDeals(null);
		}
		this.contactPersonRepo.deleteAll(contactPerson);
		
		this.dealsRepo.delete(deals);

	}

	@Override
	public List<DealsDto> getAllDeals() {
		List<Deals> findAll = this.dealsRepo.findAll();
		return findAll.stream().map(e -> this.modelMapper.map(e, DealsDto.class)).collect(Collectors.toList());
	}

	@Override
	public DealsDto getDealById(Integer did) {
		Deals deals = this.dealsRepo.findById(did).orElseThrow(() -> new ResourceNotFoundException("Invalid deals Id"));

		return this.modelMapper.map(deals, DealsDto.class);
	}

}
