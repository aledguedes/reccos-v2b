package com.reccos.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reccos.admin.models.Stadium;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {
    
}
