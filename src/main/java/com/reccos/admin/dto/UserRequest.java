package com.reccos.admin.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.Future;
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
// @FieldsAreEquals(field = "password", fieldMatch = "passwordConfirmation")
public class UserRequest {

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 100)
	private String name;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 100)
	private String surname;

	@Email
	@NotNull
	@NotEmpty
//	@UserEmailIsUnique
	@Size(min = 3, max = 255)
	private String email;

	@NotNull
	@NotEmpty
	@Size(min = 8, max = 12)
	private String phone;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 225)
	private String img_perfil;

	@NotNull
	private String status;
	
	// @Future
    @NotNull
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime birth_date;

	@NotNull
	@NotEmpty
	private String role;

	private Integer federation;

	@NotNull
	@NotEmpty
	@Size(min = 6, max = 255)
	private String password;

	@Size(min = 6, max = 255)
	private String passwordConfirmation;

}
