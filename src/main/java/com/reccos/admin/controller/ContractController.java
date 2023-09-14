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

import com.reccos.admin.dto.ContractRequest;
import com.reccos.admin.dto.ContractResponse;
import com.reccos.admin.service.ContractService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/contract")
public class ContractController {

    private final ContractService contractService;

    @GetMapping
    public List<ContractResponse> listAll() {
        return contractService.listAll();
    }

    @GetMapping(value = "/{contract_id}")
    public ContractResponse contractById(@PathVariable Long contract_id) {
        return contractService.contractById(contract_id);
    }

    @PostMapping(value = "created/{player_id}/{team_id}")
	@ResponseStatus(HttpStatus.CREATED)
    public ContractResponse createContract(
            @RequestBody @Valid ContractRequest contractRequest,
            @PathVariable Long player_id,
            @PathVariable Long team_id) {
        return contractService.createContract(contractRequest, player_id, team_id);
    }

    @PutMapping(value = "updated/{contract_id}/{player_id}/{team_id}")
    public ContractResponse updateContract(
            @RequestBody @Valid ContractRequest contractRequest,
            @PathVariable Long contract_id,
            @PathVariable Long player_id,
            @PathVariable Long team_id) {
        return contractService.updateContract(contractRequest, contract_id, player_id, team_id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{contract_id}")
    public void deleteContract(@PathVariable Long contract_id) {
        contractService.deleteContract(contract_id);
    }

}
