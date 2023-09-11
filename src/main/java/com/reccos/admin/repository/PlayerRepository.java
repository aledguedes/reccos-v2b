package com.reccos.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reccos.admin.models.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    
}
