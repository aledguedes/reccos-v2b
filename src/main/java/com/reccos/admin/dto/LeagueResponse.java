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
public class LeagueResponse {
    
    private String name;
    private String status;
    private String img_logo;
    private String league_mode;
    private String league_system;
    private Long qt_group;
    private Long idd_fed;
    private LocalDateTime dt_start;
    private LocalDateTime dt_end;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
