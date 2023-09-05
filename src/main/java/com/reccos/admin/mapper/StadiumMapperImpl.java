package com.reccos.admin.mapper;

import org.springframework.stereotype.Component;

import com.reccos.admin.dto.StadiumRequest;
import com.reccos.admin.dto.StadiumResponse;
import com.reccos.admin.models.Stadium;

@Component
public class StadiumMapperImpl implements StadiumMapper {

    @Override
    public Stadium toStadium(StadiumRequest stadiumRequest) {

        if(stadiumRequest == null) {
            return null;
        }
        return Stadium.builder()
                .name(stadiumRequest.getName())
                .surname(stadiumRequest.getSurname())
                .status(stadiumRequest.getStatus())
                .picture_profile(stadiumRequest.getPicture_profile())
                .idd_fed(stadiumRequest.getIdd_fed())
                .build();
    }

    @Override
    public StadiumResponse toStadiumResponse(Stadium stadium) {
        if (stadium == null) {
            return null;
        }
        return StadiumResponse.builder()
        		.id(stadium.getId())
                .name(stadium.getName())
                .surname(stadium.getSurname())
                .status(stadium.getStatus())
                .picture_profile(stadium.getPicture_profile())
	            .createdAt(stadium.getCreatedAt())
	            .updatedAt(stadium.getUpdatedAt())
                .build();
    }
    
}
