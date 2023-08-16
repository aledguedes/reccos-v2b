package com.reccos.admin.dto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

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
public class RefreeRequest {

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
    @Size(min = 3, max = 255)
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String status;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 25)
    @CPF(message = "cpf inválido")
    private String cpf;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 15)
    private String rg;

    @NotNull
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime birth_date;

    @NotNull
    private Long registered_federation;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String img_refree;
}
