package com.reccos.admin.service;

import java.util.List;

import com.reccos.admin.dto.StadiumRequest;
import com.reccos.admin.dto.StadiumResponse;

public interface StadiumService {
    List<StadiumResponse> listAll();
    void deleteRefree(Long stadium_id);
    StadiumResponse StadiumById(Long stadium_id);
    StadiumResponse createRefree(StadiumRequest stadiumRequest);
    StadiumResponse createWithTeam(StadiumRequest stadiumRequest, Long team_id);
    StadiumResponse updateRefree(StadiumRequest stadiumRequest, Long stadium_id);
}
