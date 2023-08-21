package com.reccos.admin.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
public class TeamRequest {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String surname;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 15)
    private String acronym;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String status;

    @NotNull
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime birth_date;

    @NotNull
    private Long registered_federation;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String picture_profile;
}
