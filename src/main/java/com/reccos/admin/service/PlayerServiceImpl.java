package com.reccos.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.reccos.admin.dto.PlayerRequest;
import com.reccos.admin.dto.PlayerResponse;
import com.reccos.admin.mapper.PlayerMapper;
import com.reccos.admin.repository.PlayerRepository;
import com.reccos.admin.exceptions.core.PlayerNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerMapper playerMapper;
    private final PlayerRepository playerRepository;

    @Override
    public List<PlayerResponse> listAll() {
        return playerRepository.findAll()
                .stream()
                .map(playerMapper::toPlayerResponse)
                .toList();
    }

    @Override
    public PlayerResponse PlayerById(Long player_id) {
        return playerRepository.findById(player_id)
                .map(playerMapper::toPlayerResponse)
                .orElseThrow(PlayerNotFoundException::new);
    }

    @Override
    public PlayerResponse createPlayer(PlayerRequest playerRequest) {
        var newPlayer = playerMapper.toPlayer(playerRequest);
        var createdPlayer = playerRepository.save(newPlayer);
        return playerMapper.toPlayerResponse(createdPlayer);
    }

    @Override
    public PlayerResponse updatePlayer(PlayerRequest playerRequest, Long player_id) {
        var player = playerRepository.findById(player_id)
                .orElseThrow(PlayerNotFoundException::new);
        BeanUtils.copyProperties(playerRequest, player, "id", "email", "rg", "cpf","createdAt", "updatedAt");
        var playerUpdate = playerRepository.save(player);
        return playerMapper.toPlayerResponse(playerUpdate);
    }

    @Override
    public void deletePlayer(Long player_id) {
        playerRepository.deleteById(player_id);
    }

}
