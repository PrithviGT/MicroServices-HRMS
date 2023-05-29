package com.tyss.hrms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.hrms.entity.Projects;

public interface ProjectsRepo extends JpaRepository<Projects, Integer> {

}
