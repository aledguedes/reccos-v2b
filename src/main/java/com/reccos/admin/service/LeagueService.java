package com.reccos.admin.service;

import java.util.List;

import com.reccos.admin.dto.LeagueRequest;
import com.reccos.admin.dto.LeagueResponse;

public interface LeagueService {
    
    List<LeagueResponse> listAll();
    LeagueResponse leagueById(Long league_id);
    LeagueResponse createLeague(LeagueRequest leagueRequest);
    LeagueResponse updateLeague(LeagueRequest leagueRequest, Long league_id);
    void deleteLeague(Long league_id);
}
