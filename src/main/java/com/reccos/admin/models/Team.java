package com.reccos.admin.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "teams")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Team extends Auditable {

	@Id
	@ToString.Include
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "acronym")
	private String acronym;

	@Column(name = "status")
	private String status;

	@Column(name = "birth_date")
	private LocalDateTime birth_date;

	@Column(name = "registered_federation")
	private Long registered_federation;

	@Column(name = "picture_profile")
	private String picture_profile;

	@ManyToOne
	@JoinColumn(name = "federations_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Federation federation;

	@ManyToOne
	@JoinColumn(name = "stadium_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Stadium stadium;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "teams")
	@JsonIgnore
	@Builder.Default
	private Set<Group> groups = new HashSet<>();
}
