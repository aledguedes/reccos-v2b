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

import com.reccos.admin.dto.TeamRequest;
import com.reccos.admin.dto.TeamResponse;
import com.reccos.admin.service.TeamService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/team")
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public List<TeamResponse> listAll() {
        return teamService.listAll();
    }

    @GetMapping(value = "/{team_id}")
    public TeamResponse TeamById(@PathVariable Long team_id) {
        return teamService.TeamById(team_id);
    }

    @GetMapping(value = "/{team_id}/link_stadium/{stadium_id}")
    public TeamResponse linkStaduimTeam(@PathVariable Long team_id, @PathVariable Long stadium_id) {
        return teamService.linkStaduimTeam(team_id, stadium_id);
    }
    
    @GetMapping(value = "find/by-federation/{federation_id}")
    public List<TeamResponse> teamsByFederation(@PathVariable Long federation_id) {
        return teamService.getTeamsByFederation(federation_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamResponse createTeam(@RequestBody @Valid TeamRequest teamRequest) {
        return teamService.createTeam(teamRequest);
    }

    @PutMapping(value = "/{team_id}")
    public TeamResponse updateTeam(@RequestBody @Valid TeamRequest teamRequest, @PathVariable Long team_id) {
        return teamService.updateTeam(teamRequest, team_id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{team_id}")
    public void deleteTeam(@PathVariable Long team_id) {
        teamService.deleteTeam(team_id);
    }

}
