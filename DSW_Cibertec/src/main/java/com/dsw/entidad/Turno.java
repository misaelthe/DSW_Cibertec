package com.dsw.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "turno")
public class Turno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idturno")
	private Integer idturno;

	@Column(name = "turno")
	private String turno;
}
