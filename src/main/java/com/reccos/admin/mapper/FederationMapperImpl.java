package com.reccos.admin.mapper;

import org.springframework.stereotype.Component;

import com.reccos.admin.dto.FederationRequest;
import com.reccos.admin.dto.FederationResponse;
import com.reccos.admin.models.Federation;

@Component
public class FederationMapperImpl implements FederationMapper {

	@Override
	public Federation toFederation(FederationRequest federationRequest) {
		if (federationRequest == null) {
            return null;
        }
		return Federation.builder()
	            .name(federationRequest.getName())
	            .surname(federationRequest.getSurname())
	            .status(federationRequest.getStatus())
	            .img_logo(federationRequest.getImg_logo())
	            .build();
	}

	@Override
	public FederationResponse toFederationResponse(Federation federation) {
		if (federation == null) {
            return null;
        }
		
        return FederationResponse.builder()
            .id(federation.getId())
            .name(federation.getName())
            .surname(federation.getSurname())
            .status(federation.getStatus())
            .img_logo(federation.getImg_logo())
            .createdAt(federation.getCreatedAt())
            .updatedAt(federation.getUpdatedAt())
            .owner(federation.getOwner())
            .build();
	}

}
