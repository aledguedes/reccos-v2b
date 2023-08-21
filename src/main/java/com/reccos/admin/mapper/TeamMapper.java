package com.reccos.admin.mapper;

import com.reccos.admin.dto.TeamRequest;
import com.reccos.admin.dto.TeamResponse;
import com.reccos.admin.models.Team;

public interface TeamMapper {
    Team toTeam(TeamRequest refreeRequest);
    TeamResponse toTeamResponse(Team refree);
}
