package com.reccos.admin.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.reccos.admin.models.League;
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
	private User owner;
	private List<League> leagues;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
