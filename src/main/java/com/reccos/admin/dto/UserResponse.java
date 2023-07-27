package com.reccos.admin.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

	private Long id;
	private String name;
	private String email;
	private Boolean status;
	private String img_perfil;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
