package com.reccos.admin.mapper;

import com.reccos.admin.dto.PlayerRequest;
import com.reccos.admin.dto.PlayerResponse;
import com.reccos.admin.models.Player;

public interface PlayerMapper {
    
    Player toPlayer(PlayerRequest playerRequest);
    PlayerResponse toPlayerResponse(Player player);
}
