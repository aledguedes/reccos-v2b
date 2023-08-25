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
@Table(name = "leagues")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class League extends Auditable {
    
    @Id
	@ToString.Include
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "dt_start")
	private LocalDateTime dt_start;

	@Column(name = "dt_end")
	private LocalDateTime dt_end;

	@Column(name = "img_logo")
	private String img_logo;
	
	@Column(name = "location")
	private String location;

	@Column(name = "league_system")
	private String league_system;

	@Column(name = "league_mode")
	private String league_mode;

	@Column(name = "qt_group")
	private Long qt_group;

	@Column(name = "idd_fed")
    private long idd_fed;

	@Column(name = "status")
	private String status;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "federations_id")
	// @JsonIgnore
	// private Federation federation;
}
