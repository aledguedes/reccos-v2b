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
public class PlayerResponse {

    private Long id;
    private String name;
    private String email;
    private String status;
    private String surname;
    private String position;
    private Boolean suspended;
    private String picture_profile;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime birth_date;
}
