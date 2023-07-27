package com.reccos.admin.mapper;

import com.reccos.admin.dto.FederationRequest;
import com.reccos.admin.dto.FederationResponse;
import com.reccos.admin.models.Federation;

public interface FederationMapper {

	Federation toFederation(FederationRequest federationRequest);
    FederationResponse toFederationResponse(Federation federation);
}
