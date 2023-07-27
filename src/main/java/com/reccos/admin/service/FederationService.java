package com.reccos.admin.service;

import java.util.List;

import com.reccos.admin.dto.FederationRequest;
import com.reccos.admin.dto.FederationResponse;

public interface FederationService {

	List<FederationResponse> listAll();
    FederationResponse federationById(Long federationId);
    FederationResponse createFederation(FederationRequest federationRequest);
    FederationResponse updateFederation(FederationRequest federationRequest, Long federation_id);
    void excluirProfessorLogado(Long federation_id);
}
