package com.reccos.admin.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.Future;
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
public class LeagueRequest {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 150)
    private String location;

    @Future
    @NotNull
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime dt_start;

    @Future
    @NotNull
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime dt_end;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String league_system;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String league_mode;

    @NotNull
    private Long qt_group;

    @NotNull
    private Long idd_fed;

    @NotNull
    private String status;
    
    @NotNull
    private Boolean turn;
    
    @NotNull
	private Integer num_teams;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 225)
    private String img_logo;

    private String scoreName;
}
