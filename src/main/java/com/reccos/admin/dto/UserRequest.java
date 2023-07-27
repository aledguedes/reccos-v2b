package com.reccos.admin.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
// import com.reccos.admin.validators.FieldsAreEquals;
import com.reccos.admin.validators.user.UserEmailIsUnique;

import jakarta.validation.constraints.Email;
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

	@Email
	@NotNull
	@NotEmpty
	@UserEmailIsUnique
	@Size(min = 3, max = 255)
	private String email;

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 225)
	private String img_perfil;

	@NotNull
	private Boolean status;

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
