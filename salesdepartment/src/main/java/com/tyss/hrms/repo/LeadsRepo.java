package com.tyss.hrms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.hrms.entity.Leads;

public interface LeadsRepo extends JpaRepository<Leads, Integer> {

}
