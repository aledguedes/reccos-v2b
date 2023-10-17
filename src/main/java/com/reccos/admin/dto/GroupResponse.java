package com.reccos.admin.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reccos.admin.models.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupResponse {

	private Long id;
	private String name;
	@JsonIgnoreProperties({ "federation", "stadium" })
	private Set<Team> teams;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}