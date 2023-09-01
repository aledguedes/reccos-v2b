package com.reccos.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.reccos.admin.dto.TeamRequest;
import com.reccos.admin.dto.TeamResponse;
import com.reccos.admin.exceptions.core.StadiumNotFoundException;
import com.reccos.admin.exceptions.core.TeamNotFoundException;
import com.reccos.admin.exceptions.core.UserNotFoundException;
import com.reccos.admin.mapper.TeamMapper;
import com.reccos.admin.repository.FederationRepository;
import com.reccos.admin.repository.StadiumRepository;
import com.reccos.admin.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamMapper teamMapper;
    private final TeamRepository teamRepository;
    private final StadiumRepository stadiumRepository;
    private final FederationRepository federationRepository;

    @Override
    public List<TeamResponse> listAll() {
        return teamRepository.findAll()
                .stream()
                .map(teamMapper::toTeamResponse)
                .toList();
    }

    @Override
    public TeamResponse TeamById(Long team_id) {
        return teamRepository.findById(team_id)
                .map(teamMapper::toTeamResponse)
                .orElseThrow(TeamNotFoundException::new);
    }

    @Override
    public TeamResponse createTeam(TeamRequest teamRequest) {
    	var federation = federationRepository
                .findById(teamRequest.getRegistered_federation())
                .orElseThrow(UserNotFoundException::new);
        var newTeam = teamMapper.toTeam(teamRequest);
        newTeam.setFederation(federation);
        var createdTeam = teamRepository.save(newTeam);
        return teamMapper.toTeamResponse(createdTeam);
    }

    @Override
    public TeamResponse updateTeam(TeamRequest teamRequest, Long team_id) {
        var refree = teamRepository.findById(team_id)
                .orElseThrow(TeamNotFoundException::new);
        BeanUtils.copyProperties(teamRequest, refree, "id", "email", "federation", "createdAt", "updatedAt");
        var updatedRefree = teamRepository.save(refree);
        return teamMapper.toTeamResponse(updatedRefree);
    }

    @Override
    public void deleteTeam(Long team_id) {
        teamRepository.deleteById(team_id);
    }

	@Override
	public TeamResponse linkStaduimTeam(Long team_id, Long stadium_id) {
		var stadium = stadiumRepository
                .findById(stadium_id)
                .orElseThrow(StadiumNotFoundException::new);

        var team = teamRepository
                .findById(team_id)
                .orElseThrow(StadiumNotFoundException::new);
        team.setStadium(stadium);
		return teamMapper.toTeamResponse(teamRepository.save(team));
	}

}
