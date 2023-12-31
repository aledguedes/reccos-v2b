package com.reccos.admin.service;

import java.util.List;

import com.reccos.admin.dto.TeamRequest;
import com.reccos.admin.dto.TeamResponse;

public interface TeamService {

	List<TeamResponse> listAll();
    void deleteTeam(Long team_id);
    TeamResponse TeamById(Long team_id);
    TeamResponse linkStaduimTeam(Long team_id, Long stadium_id);
    TeamResponse createTeam(TeamRequest teamRequest);
    TeamResponse updateTeam(TeamRequest teamRequest, Long team_id);
	List<TeamResponse> getTeamsByFederation(Long federation_id);
}
