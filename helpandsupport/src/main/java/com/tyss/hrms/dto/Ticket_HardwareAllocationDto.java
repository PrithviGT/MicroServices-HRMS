package com.tyss.hrms.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Ticket_HardwareAllocationDto {

//	@JsonIgnore
	private Integer ticketHardwareAllocationId;
	private String reportingManagerName;
	private String department;
	private String category;
	private	String subCategory;
	private String description;
	private Integer employeeID;
	private String employeeName;
	private String status;
	private String acceptedBy;
	private String action;
}
