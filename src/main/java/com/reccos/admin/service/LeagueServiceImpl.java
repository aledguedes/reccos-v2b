package com.reccos.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.reccos.admin.dto.LeagueRequest;
import com.reccos.admin.dto.LeagueResponse;
import com.reccos.admin.exceptions.core.FederationNotFoundException;
import com.reccos.admin.exceptions.core.LeagueNotFoundException;
import com.reccos.admin.mapper.LeagueMapper;
import com.reccos.admin.models.Group;
import com.reccos.admin.models.League;
import com.reccos.admin.models.Score;
import com.reccos.admin.repository.FederationRepository;
import com.reccos.admin.repository.GroupRepository;
import com.reccos.admin.repository.LeagueRepository;
import com.reccos.admin.repository.ScoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeagueServiceImpl implements LeagueService {

	private final LeagueMapper leagueMapper;
	private final GroupRepository groupRepository;
	private final ScoreRepository scoreRepository;
	private final LeagueRepository leagueRepository;
	private final FederationRepository federationRepository;

	@Override
	public List<LeagueResponse> listAll() {
		return leagueRepository.findAll().stream().map(leagueMapper::toLeagueResponse).toList();
	}

	@Override
	public LeagueResponse leagueById(Long league_id) {
		return leagueRepository.findById(league_id).map(leagueMapper::toLeagueResponse)
				.orElseThrow(LeagueNotFoundException::new);
	}

	@Override
	public LeagueResponse createLeague(LeagueRequest leagueRequest) {
		var federation = federationRepository.findById(leagueRequest.getIdd_fed())
				.orElseThrow(FederationNotFoundException::new);

		var leagues = leagueMapper.toLeague(leagueRequest);

		var score = createScore();
		leagues.setScore(score);

		var createdLeague = leagueRepository.save(leagues);

		System.out.println("DEBUG SERVICE: " + leagueRequest.getScoreName());

		createdGroups(createdLeague, createdLeague.getQt_group());

		federation.getLeagues().add(leagues);
		federationRepository.save(federation);
		return leagueMapper.toLeagueResponse(createdLeague);
	}

	@Override
	public LeagueResponse updateLeague(LeagueRequest leagueRequest, Long league_id) {
		var league = leagueRepository.findById(league_id).orElseThrow(LeagueNotFoundException::new);
		BeanUtils.copyProperties(leagueRequest, league, "id", "idd_fed", "num_teams", "qt_group", "createdAt",
				"updatedAt");
		var updatedLeague = leagueRepository.save(league);
		return leagueMapper.toLeagueResponse(updatedLeague);
	}

	@Override
	public void deleteLeague(Long league_id) {
		leagueRepository.deleteById(league_id);
	}

	private void createdGroups(League createdLeague, long qtGrupos) {
		for (int i = 0; i < qtGrupos; i++) {
			var grupo = new Group();
			grupo.setName("Grupo " + (i + 1));
			grupo.setLeague(createdLeague);
			groupRepository.save(grupo);
		}
	}

	private Score createScore() {
		Score score = new Score();
		score.setWinner(3);
		score.setDraw(1);
		score.setLoser(0);
		return scoreRepository.save(score);
	}

}
