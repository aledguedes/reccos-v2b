package com.reccos.admin.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.reccos.admin.dto.ContractRequest;
import com.reccos.admin.dto.ContractResponse;
import com.reccos.admin.exceptions.core.ContractNotFoundException;
import com.reccos.admin.exceptions.core.PlayerNotFoundException;
import com.reccos.admin.exceptions.core.TeamNotFoundException;
import com.reccos.admin.mapper.ContractMapper;
import com.reccos.admin.repository.ContractRepository;
import com.reccos.admin.repository.PlayerRepository;
import com.reccos.admin.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final TeamRepository teamRepository;
    private final ContractMapper contractMapper;
    private final PlayerRepository playerRepository;
    private final ContractRepository contractRepository;

    @Override
    public List<ContractResponse> listAll() {
        return contractRepository.findAll()
                .stream()
                .map(contractMapper::toContractResponse)
                .toList();
    }

    @Override
    public ContractResponse contractById(Long contract_id) {
        return contractRepository.findById(contract_id)
                .map(contractMapper::toContractResponse)
                .orElseThrow(ContractNotFoundException::new);
    }

    @Override
    public ContractResponse createContract(ContractRequest contractRequest, Long player_id, Long team_id) {
        var player = playerRepository
                .findById(player_id)
                .orElseThrow(PlayerNotFoundException::new);
        var team = teamRepository
                .findById(team_id)
                .orElseThrow(TeamNotFoundException::new);
        var contract = contractMapper.toContract(contractRequest);
        contract.setTeams(team);
        contract.setPlayers(player);
        var createdContract = contractRepository.save(contract);
        return contractMapper.toContractResponse(createdContract);
    }

    @Override
    public ContractResponse updateContract(
            ContractRequest contractRequest,
            Long contract_id,
            Long player_id,
            Long team_id) {
        var player = playerRepository
                .findById(player_id)
                .orElseThrow(PlayerNotFoundException::new);
        var team = teamRepository
                .findById(team_id)
                .orElseThrow(TeamNotFoundException::new);
        var contract = contractRepository.findById(contract_id)
                .orElseThrow(PlayerNotFoundException::new);
        contract.setTeams(team);
        contract.setPlayers(player);
        BeanUtils.copyProperties(contractRequest, contract, "id", "createdAt", "updatedAt");
        var contractUpdate = contractRepository.save(contract);
        return contractMapper.toContractResponse(contractUpdate);
    }

    @Override
    public void deleteContract(Long contract_id) {
        contractRepository.deleteById(contract_id);
    }

}
