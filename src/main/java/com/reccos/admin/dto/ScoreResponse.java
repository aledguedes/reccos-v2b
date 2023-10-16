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
public class ScoreResponse {

    private Long id;
    private Integer winner;
    private Integer draw;
    private Integer loser;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
