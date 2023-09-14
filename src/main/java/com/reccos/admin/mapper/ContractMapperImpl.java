package com.reccos.admin.mapper;

import org.springframework.stereotype.Component;

import com.reccos.admin.dto.ContractRequest;
import com.reccos.admin.dto.ContractResponse;
import com.reccos.admin.models.Contract;

@Component
public class ContractMapperImpl implements ContractMapper {

    @Override
    public Contract toContract(ContractRequest contractRequest) {
        if (contractRequest == null) {
            return null;
        }
        return Contract.builder()
                .dt_end(contractRequest.getDt_end())
                .dt_start(contractRequest.getDt_start())
                .status(contractRequest.getStatus())
                .dt_start(contractRequest.getDt_start())
                .build();
    }

    @Override
    public ContractResponse toContractResponse(Contract contract) {
        if (contract == null) {
            return null;
        }

        return ContractResponse.builder()
                .id(contract.getId())
                .teams(contract.getTeams())
                .status(contract.getStatus())
                .dt_end(contract.getDt_end())
                .players(contract.getPlayers())
                .dt_start(contract.getDt_start())
                .updatedAt(contract.getUpdatedAt())
                .createdAt(contract.getCreatedAt())
                .build();
    }

}
