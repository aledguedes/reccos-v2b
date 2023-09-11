package com.reccos.admin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reccos.admin.dto.PlayerRequest;
import com.reccos.admin.dto.PlayerResponse;
import com.reccos.admin.service.PlayerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/player")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public List<PlayerResponse> listAll() {
        return playerService.listAll();
    }

    @GetMapping(value = "/{player_id}")
    public PlayerResponse PlayerById(@PathVariable Long player_id) {
        return playerService.PlayerById(player_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerResponse createPlayer(@RequestBody @Valid PlayerRequest playerRequest) {
        return playerService.createPlayer(playerRequest);
    }

    @PutMapping(value = "/{player_id}")
    public PlayerResponse updatePlayer(@RequestBody @Valid PlayerRequest playerRequest, @PathVariable Long player_id) {
        return playerService.updatePlayer(playerRequest, player_id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{player_id}")
    public void deletePlayer(@PathVariable Long player_id) {
        playerService.deletePlayer(player_id);
    }

}
