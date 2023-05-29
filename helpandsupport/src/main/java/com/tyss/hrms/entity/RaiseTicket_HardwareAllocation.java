package com.tyss.hrms.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "Ticket_Hardware_Allocation")
public class RaiseTicket_HardwareAllocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_Id")
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
