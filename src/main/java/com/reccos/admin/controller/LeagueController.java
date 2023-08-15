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

import com.reccos.admin.dto.LeagueRequest;
import com.reccos.admin.dto.LeagueResponse;
import com.reccos.admin.service.LeagueService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/league")
public class LeagueController {
    
    private final LeagueService leagueService;

    @GetMapping
    public List<LeagueResponse> listAll() {
        return leagueService.listAll();
    }

    @GetMapping(value = "/{league_id}")
    public LeagueResponse leagueById(@PathVariable Long league_id) {
        return leagueService.leagueById(league_id);
    }

    @PostMapping
	@ResponseStatus(HttpStatus.CREATED)
    public LeagueResponse createLeague(@RequestBody @Valid LeagueRequest leagueRequest) {
        return leagueService.createLeague(leagueRequest);
    }

    @PutMapping(value = "/{league_id}")
    public LeagueResponse updateLeague(@RequestBody @Valid LeagueRequest leagueRequest, @PathVariable Long league_id) {
        return leagueService.updateLeague(leagueRequest, league_id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{league_id}")
    public void deleteLeague(@PathVariable Long league_id) {
        leagueService.deleteLeague(league_id);
    }

    
}
