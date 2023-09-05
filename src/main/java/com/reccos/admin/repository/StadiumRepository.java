package com.reccos.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reccos.admin.models.Federation;
import com.reccos.admin.models.Stadium;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {
    
	List<Stadium> findByFederation(Federation federation);
}
