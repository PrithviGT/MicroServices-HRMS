package com.tyss.hrms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.hrms.entity.ContactPerson;

public interface ContactPersonRepo extends JpaRepository<ContactPerson, Integer>{

}
