package com.reccos.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.reccos.admin.dto.LeagueRequest;
import com.reccos.admin.dto.LeagueResponse;
import com.reccos.admin.exceptions.core.FederationNotFoundException;
import com.reccos.admin.exceptions.core.UserNotFoundException;
import com.reccos.admin.mapper.LeagueMapper;
import com.reccos.admin.repository.FederationRepository;
import com.reccos.admin.repository.LeagueRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeagueServiceImpl implements LeagueService {

    private final LeagueMapper leagueMapper;
    private final LeagueRepository leagueRepository;
    private final FederationRepository federationRepository;

    @Override
    public List<LeagueResponse> listAll() {
        return leagueRepository.findAll()
                .stream()
                .map(leagueMapper::toLeagueResponse)
                .toList();
    }

    @Override
    public LeagueResponse federationById(Long league_id) {
        return leagueRepository
                .findById(league_id)
                .map(leagueMapper::toLeagueResponse)
                .orElseThrow(FederationNotFoundException::new);
    }

    @Override
    public LeagueResponse createFederation(LeagueRequest leagueRequest) {
        var federation = federationRepository
                .findById(leagueRequest.getIdd_fed())
                .orElseThrow(UserNotFoundException::new);
        var leagues = leagueMapper.toLeague(leagueRequest);
        federation.getLeagues().add(leagues);
        federationRepository.save(federation);
        return leagueMapper.toLeagueResponse(leagues);
    }

    @Override
    public LeagueResponse updateFederation(LeagueRequest leagueRequest, Long league_id) {
        var league = leagueRepository
                .findById(league_id)
                .orElseThrow(UserNotFoundException::new);
        BeanUtils.copyProperties(leagueRequest, league, "id", "id_federation", "qt_group", "createdAt", "updatedAt");
        return leagueMapper.toLeagueResponse(league);
    }

    @Override
    public void excluirProfessorLogado(Long league_id) {
        leagueRepository.deleteById(league_id);
    }

}
