package com.tyss.hrms.service;


import com.tyss.hrms.dto.ContactPersonDto;

public interface ContactPersonService {

	ContactPersonDto createLeadContactPersonDeatils(ContactPersonDto contactPersonDto, Integer lid);
	
	ContactPersonDto createDealContactPersonDeatils(ContactPersonDto contactPersonDto, Integer did);
	
	
}
