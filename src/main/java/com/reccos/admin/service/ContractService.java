package com.reccos.admin.service;

import java.util.List;

import com.reccos.admin.dto.ContractRequest;
import com.reccos.admin.dto.ContractResponse;

public interface ContractService {
    List<ContractResponse> listAll();
    ContractResponse contractById(Long contract_id);
    ContractResponse createContract(ContractRequest contractRequest, Long player_id, Long team_id);
    ContractResponse updateContract(ContractRequest contractRequest, Long contract_id, Long player_id, Long team_id);
    void deleteContract(Long contract_id);
}
