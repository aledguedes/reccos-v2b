package com.reccos.admin.service;

import java.util.List;

import com.reccos.admin.dto.PlayerRequest;
import com.reccos.admin.dto.PlayerResponse;

public interface PlayerService {
    List<PlayerResponse> listAll();
    PlayerResponse PlayerById(Long player_id);
    PlayerResponse createPlayer(PlayerRequest playerRequest);
    PlayerResponse updatePlayer(PlayerRequest playerRequest, Long player_id);
    void deletePlayer(Long player_id);
}
