package com.tyss.hrms.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Deals {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dealsId;
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
	
	@OneToMany(mappedBy = "deals")
	private List<ContactPerson> contactPerson;
	
	@OneToMany(mappedBy = "deals", cascade = CascadeType.ALL)
	private List<Projects> projects;
	
}
