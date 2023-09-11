package com.reccos.admin.mapper;

import org.springframework.stereotype.Component;

import com.reccos.admin.dto.PlayerRequest;
import com.reccos.admin.dto.PlayerResponse;
import com.reccos.admin.models.Player;

@Component
public class PlayerMapperImpl implements PlayerMapper {

    @Override
    public Player toPlayer(PlayerRequest playerRequest) {
        if (playerRequest == null) {
            return null;
        }
        return Player.builder()
                .name(playerRequest.getName())
                .surname(playerRequest.getSurname())
                .birth_date(playerRequest.getBirth_date())
                .status(playerRequest.getStatus())
                .email(playerRequest.getEmail())
                .picture_profile(playerRequest.getPicture_profile())
                .cpf(playerRequest.getCpf())
                .rg(playerRequest.getRg())
                .suspended(playerRequest.getSuspended())
                .position(playerRequest.getPosition())
                .build();
    }

    @Override
    public PlayerResponse toPlayerResponse(Player player) {
        if (player == null) {
            return null;
        }
        return PlayerResponse.builder()
        		.id(player.getId())
                .name(player.getName())
                .email(player.getEmail())
                .status(player.getStatus())
                .surname(player.getSurname())
                .position(player.getPosition())
	            .createdAt(player.getCreatedAt())
	            .updatedAt(player.getUpdatedAt())
                .suspended(player.getSuspended())
                .birth_date(player.getBirth_date())
                .picture_profile(player.getPicture_profile())
                .build();
    }
    
}
