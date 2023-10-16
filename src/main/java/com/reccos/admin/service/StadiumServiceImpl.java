package com.reccos.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.reccos.admin.dto.StadiumRequest;
import com.reccos.admin.dto.StadiumResponse;
import com.reccos.admin.exceptions.core.FederationNotFoundException;
import com.reccos.admin.exceptions.core.StadiumNotFoundException;
import com.reccos.admin.mapper.StadiumMapper;
import com.reccos.admin.repository.FederationRepository;
import com.reccos.admin.repository.StadiumRepository;
import com.reccos.admin.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StadiumServiceImpl implements StadiumService {

	private final StadiumMapper stadiumMapper;
	private final TeamRepository teamRepository;
	private final StadiumRepository stadiumRepository;
	private final FederationRepository federationRepository;

	@Override
	public List<StadiumResponse> listAll() {
		return stadiumRepository.findAll().stream().map(stadiumMapper::toStadiumResponse).toList();
	}

	@Override
	public StadiumResponse StadiumById(Long stadium_id) {
		return stadiumRepository.findById(stadium_id).map(stadiumMapper::toStadiumResponse)
				.orElseThrow(StadiumNotFoundException::new);
	}

	@Override
	public StadiumResponse createRefree(StadiumRequest stadiumRequest) {
		var federation = federationRepository
                .findById(stadiumRequest.getIdd_fed())
                .orElseThrow(FederationNotFoundException::new);
		var stadium = stadiumMapper.toStadium(stadiumRequest);
        federation.getStadium().add(stadium);
		return stadiumMapper.toStadiumResponse(stadiumRepository.save(stadium));
	}

	@Override
	public StadiumResponse createWithTeam(StadiumRequest stadiumRequest, Long team_id) {
		var federation = federationRepository
                .findById(stadiumRequest.getIdd_fed())
                .orElseThrow(FederationNotFoundException::new);
		var team = teamRepository.findById(team_id).orElseThrow(StadiumNotFoundException::new);
		var stadium = stadiumMapper.toStadium(stadiumRequest);
		federation.getStadium().add(stadium);
		stadium.getTeams().add(team);
		var staduimCreated = stadiumRepository.save(stadium);
		return stadiumMapper.toStadiumResponse(staduimCreated);
	}

	@Override
	public StadiumResponse updateRefree(StadiumRequest stadiumRequest, Long stadium_id) {
		var stadium = stadiumRepository.findById(stadium_id).orElseThrow(StadiumNotFoundException::new);
		BeanUtils.copyProperties(stadiumRequest, stadium, "id", "createdAt", "updatedAt");
		var updatedstadium = stadiumRepository.save(stadium);
		return stadiumMapper.toStadiumResponse(updatedstadium);
	}

	@Override
	public void deleteRefree(Long stadium_id) {
		stadiumRepository.deleteById(stadium_id);
	}

	@Override
	public List<StadiumResponse> getStadiumByFederation(Long federation_id) {
		var federation = federationRepository
                .findById(federation_id)
                .orElseThrow(FederationNotFoundException::new);
		return stadiumRepository
				.findByFederation(federation)
				.stream()
				.map(stadiumMapper::toStadiumResponse)
				.toList();
	}

}
