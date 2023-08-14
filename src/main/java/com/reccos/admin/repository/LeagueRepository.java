package com.reccos.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reccos.admin.models.League;

public interface LeagueRepository extends JpaRepository<League, Long> {
    
}
