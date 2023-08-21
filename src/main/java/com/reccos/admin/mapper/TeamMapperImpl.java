package com.reccos.admin.mapper;

import org.springframework.stereotype.Component;

import com.reccos.admin.dto.TeamRequest;
import com.reccos.admin.dto.TeamResponse;
import com.reccos.admin.models.Team;

@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public Team toTeam(TeamRequest teamRequest) {
        if (teamRequest == null) {
            return null;
        }
        return Team.builder()
                .name(teamRequest.getName())
                .surname(teamRequest.getSurname())
                .birth_date(teamRequest.getBirth_date())
                .status(teamRequest.getStatus())
                .acronym(teamRequest.getAcronym())
                .picture_profile(teamRequest.getPicture_profile())
                .registered_federation(teamRequest.getRegistered_federation())
                .build();
    }

    @Override
    public TeamResponse toTeamResponse(Team team) {
        if (team == null) {
            return null;
        }
        return TeamResponse.builder()
        		.id(team.getId())
                .name(team.getName())
                .surname(team.getSurname())
                .acronym(team.getAcronym())
                .birth_date(team.getBirth_date())
                .status(team.getStatus())
                .picture_profile(team.getPicture_profile())
                .registered_federation(team.getRegistered_federation())
                .federation(team.getFederation())
	            .createdAt(team.getCreatedAt())
	            .updatedAt(team.getUpdatedAt())
                .build();
    }

}
