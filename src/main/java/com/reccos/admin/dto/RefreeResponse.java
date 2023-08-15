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
public class RefreeResponse {

    private Long id;
    private String name;
    private String rg;
    private String cpf;
    private String email;
    private String status;
    private String surname;
    private LocalDateTime birth_date;
    private Long registered_federation;
    private String img_refree;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
