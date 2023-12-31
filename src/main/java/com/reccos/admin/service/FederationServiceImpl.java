package com.reccos.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.reccos.admin.dto.FederationRequest;
import com.reccos.admin.dto.FederationResponse;
import com.reccos.admin.exceptions.core.FederationNotFoundException;
import com.reccos.admin.exceptions.core.UserNotFoundException;
import com.reccos.admin.mapper.FederationMapper;
import com.reccos.admin.repository.FederationRepository;
import com.reccos.admin.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FederationServiceImpl implements FederationService {

    private final FederationMapper federationMapper;
    private final FederationRepository federationRepository;
    private final UserRepository userRepository;

    @Override
    public List<FederationResponse> listAll() {
        return federationRepository.findAll()
                .stream()
                .map(federationMapper::toFederationResponse)
                .toList();
    }

    @Override
    public FederationResponse federationById(Long federationId) {
        return federationRepository.findById(federationId)
                .map(federationMapper::toFederationResponse)
                .orElseThrow(FederationNotFoundException::new);
    }

    @Override
    public FederationResponse createFederation(FederationRequest federationRequest, Long user_id) {
    	var user = userRepository.findById(user_id)
                .orElseThrow(UserNotFoundException::new);
        var newFederation = federationMapper.toFederation(federationRequest);
        newFederation.setOwner(user);
        var createdFederation = federationRepository.save(newFederation);
        user.setFederation(createdFederation.getId().intValue());
        userRepository.save(user);
        return federationMapper.toFederationResponse(createdFederation);
    }

    @Override
    public FederationResponse updateFederation(FederationRequest federationRequest, Long federation_id) {
    	var federation = federationRepository.findById(federation_id)
                .orElseThrow(FederationNotFoundException::new);
        BeanUtils.copyProperties(federationRequest, federation, "id", "email", "createdAt", "updatedAt");
        var federacaoAtualizada = federationRepository.save(federation);
        return federationMapper.toFederationResponse(federacaoAtualizada);
    }

    @Override
    public void excluirProfessorLogado(Long federation_id) {
        federationRepository.deleteById(federation_id);
    }
}