package com.reccos.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.reccos.admin.dto.LeagueRequest;
import com.reccos.admin.dto.LeagueResponse;
import com.reccos.admin.exceptions.core.LeagueNotFoundException;
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
    public LeagueResponse leagueById(Long league_id) {
        return leagueRepository
                .findById(league_id)
                .map(leagueMapper::toLeagueResponse)
                .orElseThrow(LeagueNotFoundException::new);
    }

    @Override
    public LeagueResponse createLeague(LeagueRequest leagueRequest) {
        var federation = federationRepository
                .findById(leagueRequest.getIdd_fed())
                .orElseThrow(UserNotFoundException::new);
        var leagues = leagueMapper.toLeague(leagueRequest);
        federation.getLeagues().add(leagues);
        federationRepository.save(federation);
        return leagueMapper.toLeagueResponse(leagues);
    }

    @Override
    public LeagueResponse updateLeague(LeagueRequest leagueRequest, Long league_id) {
        var league = leagueRepository
                .findById(league_id)
                .orElseThrow(LeagueNotFoundException::new);
        BeanUtils.copyProperties(leagueRequest, league, "id", "idd_fed", "qt_group", "createdAt", "updatedAt");
        var updatedLeague = leagueRepository.save(league);
        return leagueMapper.toLeagueResponse(updatedLeague);
    }

    @Override
    public void deleteLeague(Long league_id) {
        leagueRepository.deleteById(league_id);
    }

}
