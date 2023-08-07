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
@Table(name = "users")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class User extends Auditable {
	
	@Id
	@ToString.Include
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@ToString.Include
	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "status")
	private String status;
	
	@Column(name = "birth_date")
	private LocalDateTime birth_date;

	@Column(name = "img_perfil")
	private String img_perfil;

    @Column(name = "password")
    private String password;

	@Column(name = "role")
    private String role;

	@Column(name = "federation")
    private Integer federation;

}
