package com.tyss.hrms.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tyss.hrms.entity.Deals;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProjectsDto {

	private int projectId;
	private String projectOwner;
	private String projectName;
	private String clientName;
	
	private LocalDate startDate;
	private String description;
	
	private String projectManager;
	private String reportingManager;
	
	@JsonIgnore
	private Deals deals;
}
