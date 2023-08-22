package com.reccos.admin.mapper;

import com.reccos.admin.dto.StadiumRequest;
import com.reccos.admin.dto.StadiumResponse;
import com.reccos.admin.models.Stadium;

public interface StadiumMapper {
    
    Stadium toStadium(StadiumRequest stadiumRequest);
    StadiumResponse toStadiumResponse(Stadium stadium);
}
