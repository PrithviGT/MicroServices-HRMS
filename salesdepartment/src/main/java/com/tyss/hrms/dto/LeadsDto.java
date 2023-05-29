package com.tyss.hrms.dto;

import java.util.List;

import com.tyss.hrms.entity.ContactPerson;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LeadsDto {

	private int leadsId;
	private String leadOwner;
	private String companyName;
	private String firstName;
	private String lastName;
	private String designation;
	private String emailId;
	private String mobileNo;
	private String fax;
	private String website;
	private String leadSource;
	private List<String> industry;
	private int noOfEmployees;
	private double annualRevenue;
	private String secondaryEmailId;
	private String twitterId;
	private String skypeId;
	private String leadStatus;
	
	private String address;
	private String city;
	private String state;
	private String country;
	private String pincode;
	private String description;
	
	private List<ContactPersonDto> contactPerson;
}
