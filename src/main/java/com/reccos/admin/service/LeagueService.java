package com.reccos.admin.service;

import java.util.List;

import com.reccos.admin.dto.LeagueRequest;
import com.reccos.admin.dto.LeagueResponse;

public interface LeagueService {
    
    List<LeagueResponse> listAll();
    LeagueResponse federationById(Long league_id);
    LeagueResponse createFederation(LeagueRequest leagueRequest);
    LeagueResponse updateFederation(LeagueRequest leagueRequest, Long league_id);
    void excluirProfessorLogado(Long league_id);
}
