package com.tyss.hrms.service;

import java.util.List;

import com.tyss.hrms.dto.DealsDto;

public interface DealsService {

	DealsDto updateDeal(DealsDto dealsDto, Integer did);
	
	void deleteDeal(Integer did);
	
	List<DealsDto> getAllDeals();
	
	DealsDto getDealById(Integer did);
}
