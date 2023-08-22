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
public class StadiumResponse {

    private Long id;
    private String name;
    private String surname;
    private String status;
    private String picture_profile;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
