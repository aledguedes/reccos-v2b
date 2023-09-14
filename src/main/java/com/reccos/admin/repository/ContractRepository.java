package com.reccos.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reccos.admin.models.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    
}
