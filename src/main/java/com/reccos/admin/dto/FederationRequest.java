package com.reccos.admin.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class FederationRequest {
	
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 100)
	private String name;
	
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 100)
	private String surname;

	@NotNull
	private String status;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 225)
	private String img_logo;

}
