package com.reccos.admin.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reccos.admin.models.Federation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponse {

    private Long id;
    private String name;
    private String status;
    private String acronym;
    private String surname;
    private LocalDateTime birth_date;
    private Long registered_federation;
    private String picture_profile;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
	@JsonIgnoreProperties({"owner", "leagues"})
    private Federation federation;
}
