package com.reccos.admin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reccos.admin.dto.FederationRequest;
import com.reccos.admin.dto.FederationResponse;
import com.reccos.admin.service.FederationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/federation")
public class FederationController {

	private final FederationService federationService;

	@GetMapping
	public List<FederationResponse> listAll() {
		return federationService.listAll();
	}

	@GetMapping(value = "/{federation_id}")
	public FederationResponse federationById(@PathVariable Long federation_id) {
		return federationService.federationById(federation_id);
	}

	@PostMapping(value = "/{user_id}")
	@ResponseStatus(HttpStatus.CREATED)
	public FederationResponse createFederation(
			@RequestBody @Valid FederationRequest federationRequest,
			@PathVariable Long user_id
		) {
		return federationService.createFederation(federationRequest, user_id);
	}

	@PutMapping(value = "/{federation_id}")
	public FederationResponse updateFederation(@RequestBody @Valid FederationRequest federationRequest,
			@PathVariable Long federation_id) {
		return federationService.updateFederation(federationRequest, federation_id);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{federation_id}")
	public void excluirProfessorLogado(@PathVariable Long federation_id) {
		federationService.excluirProfessorLogado(federation_id);
	}

}
