package com.tyss.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.hrms.dto.ProjectsDto;
import com.tyss.hrms.service.ProjectsService;

@RestController
@RequestMapping("/salesdepartment/projects")
public class ProjectsController {

	@Autowired
	private ProjectsService projectsService;

	@PostMapping("/{did}/{eid}")
	public ResponseEntity<ProjectsDto> createProject(@RequestBody ProjectsDto projectsDto, @PathVariable Integer did,
			@PathVariable Integer eid) {
		ProjectsDto createProjectsAndAssignToDeal = this.projectsService.createProjectsAndAssignToDeal(projectsDto, did,
				eid);
		return new ResponseEntity<ProjectsDto>(createProjectsAndAssignToDeal, HttpStatus.CREATED);
	}

	@PutMapping("/{pid}")
	public ResponseEntity<ProjectsDto> updateProject(@RequestBody ProjectsDto projectsDto, @PathVariable Integer pid) {
		ProjectsDto updateProject = this.projectsService.updateProject(projectsDto, pid);
		return new ResponseEntity<ProjectsDto>(updateProject, HttpStatus.OK);
	}

	@DeleteMapping("/{pid}")
	public ResponseEntity<?> deleteProject(@PathVariable Integer pid) {
		this.projectsService.deleteProject(pid);
		return ResponseEntity.ok().body("Project deleted with Id : " + pid);
	}

}
