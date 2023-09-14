package com.reccos.admin.mapper;

import com.reccos.admin.dto.ContractRequest;
import com.reccos.admin.dto.ContractResponse;
import com.reccos.admin.models.Contract;

public interface ContractMapper {
    
    Contract toContract(ContractRequest contractRequest);
    ContractResponse toContractResponse(Contract contract);
}
