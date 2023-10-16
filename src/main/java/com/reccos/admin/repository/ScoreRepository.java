package com.reccos.admin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reccos.admin.models.League;
import com.reccos.admin.models.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {

    Optional<League> findByName(String scoreName);
    
}
