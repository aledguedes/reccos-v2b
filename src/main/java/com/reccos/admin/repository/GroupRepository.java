package com.reccos.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reccos.admin.models.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
    
}
