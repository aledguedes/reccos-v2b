package com.reccos.admin.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "players")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)

public class Player extends Auditable {
    @Id
    @ToString.Include
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "status")
    private String status;

    @ToString.Include
    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "rg")
    private String rg;

    @Column(name = "birth_date")
    private LocalDateTime birth_date;

    @Column(name = "position")
    private String position;

    @Column(name = "picture_profile")
    private String picture_profile;

    @Column(name = "suspended")
    private Boolean suspended;
}
