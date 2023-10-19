package com.reccos.admin.service;

import java.util.List;

import com.reccos.admin.dto.StadiumRequest;
import com.reccos.admin.dto.StadiumResponse;

public interface StadiumService {
    List<StadiumResponse> listAll();
    void deleteStadium(Long stadium_id);
    StadiumResponse StadiumById(Long stadium_id);
    StadiumResponse createStadium(StadiumRequest stadiumRequest);
    StadiumResponse createWithTeam(StadiumRequest stadiumRequest, Long team_id);
    StadiumResponse updateStadium(StadiumRequest stadiumRequest, Long stadium_id);
	List<StadiumResponse> getStadiumByFederation(Long federation_id);
}
