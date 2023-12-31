package com.reccos.admin.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reccos.admin.models.Group;
import com.reccos.admin.models.Score;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeagueResponse {

	private Long id;
	private String name;
	private Score score;
	private Boolean turn;
	private String status;
	private String location;
	private String img_logo;
	private Integer num_teams;
	@JsonIgnoreProperties({ "stadium", "leagues", "federation", "league" })
	private List<Group> groups;
	private String league_mode;
	private String league_system;
	private LocalDateTime dt_start;
	private LocalDateTime dt_end;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime enrollment_end;
	private LocalDateTime enrollment_start;
}
