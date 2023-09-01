package com.reccos.admin.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reccos.admin.models.League;
import com.reccos.admin.models.Team;
import com.reccos.admin.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FederationResponse {

	private Long id;
	private String name;
	private String surname;
	private String status;
	private String img_logo;
	@JsonIgnoreProperties({"password"})
	private User owner;
	@JsonIgnoreProperties({"federation", "stadium"})
	private List<Team> teams;
	private List<League> leagues;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
