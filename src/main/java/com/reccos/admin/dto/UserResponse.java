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
	private String surname;
	private String email;
	private String status;
	private String img_perfil;
	private String role;
	private String phone;
	private Integer federation;
	private LocalDateTime birth_date;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
