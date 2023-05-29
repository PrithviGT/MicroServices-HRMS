package com.tyss.hrms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.hrms.dto.LeadsDto;
import com.tyss.hrms.entity.ContactPerson;
import com.tyss.hrms.entity.Deals;
import com.tyss.hrms.entity.Leads;
import com.tyss.hrms.exception.ResourceNotFoundException;
import com.tyss.hrms.repo.ContactPersonRepo;
import com.tyss.hrms.repo.DealsRepo;
import com.tyss.hrms.repo.LeadsRepo;
import com.tyss.hrms.service.LeadsService;

@Service
public class LeadsServiceImpl implements LeadsService {

	@Autowired
	private LeadsRepo leadsRepo;

	@Autowired
	private DealsRepo dealsRepo;
	
	@Autowired
	private ContactPersonRepo contactPersonRepo;

	@Autowired
	private ModelMapper modelMapper;

	public LeadsDto createLead(LeadsDto leadsDto) {
		Leads leads = this.modelMapper.map(leadsDto, Leads.class);
		Leads save = this.leadsRepo.save(leads);
		return this.modelMapper.map(save, LeadsDto.class);
	}

	public LeadsDto updateLead(LeadsDto leadsDto, Integer lid) {

		if (leadsDto.getLeadStatus().equalsIgnoreCase("ACCEPTED")) {

			Leads leads = this.leadsRepo.findById(lid)
					.orElseThrow(() -> new ResourceNotFoundException("Invalid Lead Id"));
			Deals deals = new Deals();

			deals.setDealsId(leads.getLeadsId());
			deals.setAddress(leadsDto.getAddress());
			deals.setAnnualRevenue(leadsDto.getAnnualRevenue());
			deals.setCity(leadsDto.getCity());
			deals.setCompanyName(leadsDto.getCompanyName());

			deals.setCountry(leadsDto.getCountry());
			deals.setDescription(leadsDto.getDescription());
			deals.setDesignation(leadsDto.getDesignation());
			deals.setEmailId(leadsDto.getEmailId());
			deals.setFax(leadsDto.getFax());
			deals.setFirstName(leadsDto.getFirstName());
			deals.setIndustry(leadsDto.getIndustry());
			deals.setLastName(leadsDto.getLastName());
			deals.setLeadOwner(leadsDto.getLeadOwner());
			deals.setLeadOwner(leadsDto.getLeadOwner());
			deals.setLeadSource(leadsDto.getLeadSource());
			deals.setLeadStatus(leadsDto.getLeadStatus());
			deals.setMobileNo(leadsDto.getMobileNo());
			deals.setNoOfEmployees(leadsDto.getNoOfEmployees());
			deals.setPincode(leadsDto.getPincode());
			deals.setSecondaryEmailId(leadsDto.getSecondaryEmailId());
			deals.setSkypeId(leadsDto.getSkypeId());
			deals.setState(leadsDto.getState());
			deals.setTwitterId(leadsDto.getTwitterId());
			deals.setWebsite(leadsDto.getWebsite());

			Deals saveDeals = this.dealsRepo.save(deals);
			
			List<ContactPerson> contactPerson = leads.getContactPerson();
			for(ContactPerson c : contactPerson) {
				c.setLeads(null);
			}
			
			contactPerson.stream().forEach(e->e.setDeals(saveDeals));
			
			List<ContactPerson> saveAll = this.contactPersonRepo.saveAll(contactPerson);
			
			deals.setContactPerson(saveAll);
			
			Deals saveDeals2 = this.dealsRepo.save(deals);

			this.leadsRepo.delete(leads);

			return null;
		} 
		
		else {

			Leads leads = this.leadsRepo.findById(lid)
					.orElseThrow(() -> new ResourceNotFoundException("Invalid Lead Id"));

			leads.setAddress(leadsDto.getAddress());
			leads.setAnnualRevenue(leadsDto.getAnnualRevenue());
			leads.setCity(leadsDto.getCity());
			leads.setCompanyName(leadsDto.getCompanyName());

			leads.setCountry(leadsDto.getCountry());
			leads.setDescription(leadsDto.getDescription());
			leads.setDesignation(leadsDto.getDesignation());
			leads.setEmailId(leadsDto.getEmailId());
			leads.setFax(leadsDto.getFax());
			leads.setFirstName(leadsDto.getFirstName());
			leads.setIndustry(leadsDto.getIndustry());
			leads.setLastName(leadsDto.getLastName());
			leads.setLeadOwner(leadsDto.getLeadOwner());
			leads.setLeadSource(leadsDto.getLeadSource());
			leads.setLeadStatus(leadsDto.getLeadStatus());
			leads.setMobileNo(leadsDto.getMobileNo());
			leads.setNoOfEmployees(leadsDto.getNoOfEmployees());
			leads.setPincode(leadsDto.getPincode());
			leads.setSecondaryEmailId(leadsDto.getSecondaryEmailId());
			leads.setSkypeId(leadsDto.getSkypeId());
			leads.setState(leadsDto.getState());
			leads.setTwitterId(leadsDto.getTwitterId());
			leads.setWebsite(leadsDto.getWebsite());

			Leads update = this.leadsRepo.save(leads);

			return this.modelMapper.map(update, LeadsDto.class);

		}
	}

	@Override
	public void deleteLead(Integer lid) {
		Leads leads = this.leadsRepo.findById(lid).orElseThrow(() -> new ResourceNotFoundException("Invalid Lead Id"));
		List<ContactPerson> contactPerson = leads.getContactPerson();
		for(ContactPerson c : contactPerson) {
			c.setLeads(null);
		}
		this.contactPersonRepo.deleteAll(contactPerson);
		this.leadsRepo.delete(leads);
	}

	@Override
	public LeadsDto getSingleLead(Integer lid) {
		Leads leads = this.leadsRepo.findById(lid).orElseThrow(() -> new ResourceNotFoundException("Invalid Lead Id"));
		return this.modelMapper.map(leads, LeadsDto.class);
	}

	@Override
	public List<LeadsDto> getAllLeads() {
		List<Leads> findAll = this.leadsRepo.findAll();
		return findAll.stream().map(e->this.modelMapper.map(e,LeadsDto.class)).collect(Collectors.toList());
	}

}
