package com.reccos.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reccos.admin.models.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
    
}
