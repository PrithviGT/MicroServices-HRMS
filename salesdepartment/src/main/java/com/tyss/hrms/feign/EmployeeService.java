package com.tyss.hrms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tyss.hrms.entity.HRMSEmployee;

@FeignClient("IT-DEPARTMENT")
public interface EmployeeService {

	@GetMapping("/itdepartment/hrmsemployee/{eid}")
	HRMSEmployee getEmployee(@PathVariable Integer eid);
}
