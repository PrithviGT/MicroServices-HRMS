package com.tyss.hrms.service;

import com.tyss.hrms.dto.ProjectsDto;

public interface ProjectsService {

	ProjectsDto createProjectsAndAssignToDeal(ProjectsDto projectsDto, Integer did, Integer eid);

	ProjectsDto updateProject(ProjectsDto projectsDto, Integer pid);

	void deleteProject(Integer pid);
}
