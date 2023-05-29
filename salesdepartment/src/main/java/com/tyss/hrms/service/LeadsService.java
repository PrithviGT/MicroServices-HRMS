package com.tyss.hrms.service;

import java.util.List;

import com.tyss.hrms.dto.LeadsDto;

public interface LeadsService {

	LeadsDto createLead(LeadsDto leadsDto);
	
	LeadsDto updateLead(LeadsDto leadsDto,Integer lid);
	
	void deleteLead(Integer lid);
	
	List<LeadsDto> getAllLeads();
	
	LeadsDto getSingleLead(Integer lid);
}
