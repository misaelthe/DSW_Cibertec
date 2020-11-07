package com.dsw.entidad;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alumno_clase")
public class Alumno_Clase {
	@EmbeddedId
	private Alumno_ClasePK alumnoClasePK;

	@ManyToOne
	@JoinColumn(name = "idalumno", nullable = false,insertable = false,updatable = false)
	private Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name = "idclase", nullable = false,insertable = false,updatable = false)
	private Clase clase;
}
