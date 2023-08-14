package com.reccos.admin.mapper;

import com.reccos.admin.dto.LeagueRequest;
import com.reccos.admin.dto.LeagueResponse;
import com.reccos.admin.models.League;

public interface LeagueMapper {
    
    League toLeague(LeagueRequest leagueRequest);
    LeagueResponse toLeagueResponse(League league);
}
