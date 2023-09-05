package com.reccos.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reccos.admin.models.Federation;
import com.reccos.admin.models.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

	List<Team> findByFederation(Federation federation);

}
