package com.tyss.hrms.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.hrms.dto.ProjectsDto;
import com.tyss.hrms.entity.Deals;
import com.tyss.hrms.entity.HRMSEmployee;
import com.tyss.hrms.entity.Projects;
import com.tyss.hrms.exception.ResourceNotFoundException;
import com.tyss.hrms.feign.EmployeeService;
import com.tyss.hrms.repo.DealsRepo;
import com.tyss.hrms.repo.ProjectsRepo;
import com.tyss.hrms.service.ProjectsService;

@Service
public class ProjectsServiceImpl implements ProjectsService {

	@Autowired
	private ProjectsRepo projectsRepo;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DealsRepo dealsRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProjectsDto createProjectsAndAssignToDeal(ProjectsDto projectsDto, Integer did, Integer eid) {
		Deals deals = this.dealsRepo.findById(did).orElseThrow(() -> new ResourceNotFoundException("Invalid deals Id"));
		
		HRMSEmployee employee = this.employeeService.getEmployee(eid);
		
		Projects projects = this.modelMapper.map(projectsDto, Projects.class);
		
		projects.setDeals(deals);
		projects.setClientName(deals.getCompanyName());
		projects.setReportingManager(employee.getName());
		projects.setProjectManager(employee.getName());
		
		Projects save = this.projectsRepo.save(projects);
		
		return this.modelMapper.map(save, ProjectsDto.class);
		
	}

	@Override
	public ProjectsDto updateProject(ProjectsDto projectsDto, Integer pid) {
		Projects projects = this.projectsRepo.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Invalid project Id"));
		
		projects.setDescription(projectsDto.getDescription());
		projects.setProjectName(projectsDto.getProjectName());
		projects.setProjectOwner(projectsDto.getProjectOwner());
		projects.setStartDate(projectsDto.getStartDate());
		
		Projects update = this.projectsRepo.save(projects);
		
		return this.modelMapper.map(update, ProjectsDto.class);
	}

	@Override
	public void deleteProject(Integer pid) {
		Projects projects = this.projectsRepo.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Invalid project Id"));
		projects.setDeals(null);
		this.projectsRepo.delete(projects);
	}
	
	
	
	
}
