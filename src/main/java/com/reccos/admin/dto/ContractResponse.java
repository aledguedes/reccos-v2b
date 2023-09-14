package com.reccos.admin.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reccos.admin.models.Player;
import com.reccos.admin.models.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractResponse {

    private Long id;
    private String status;
    private LocalDateTime dt_end;
    private LocalDateTime dt_start;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	@JsonIgnoreProperties({ "stadium", "federation", "contracts" })
    private Team teams;
	@JsonIgnoreProperties({ "contracts", "rg", "cpf" })
    private Player players;
}
