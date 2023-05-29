package com.tyss.hrms.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class ContactPersonDto {

	
	private int contactId;
	private String firstName;
	private String lastName;
	private String designation;
	private String emailId;
	private String mobileNo;


}
