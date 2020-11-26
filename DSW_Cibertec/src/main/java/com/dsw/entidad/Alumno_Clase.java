package com.dsw.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alumno_clase")
public class Alumno_Clase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idalumno_clase")
	private Integer idalumno_clase;
	
	@Cascade(CascadeType.MERGE)
	@ManyToOne
	@JoinColumn(name = "idalumno", nullable = false)
	private Alumno alumno;
	
	@Cascade(CascadeType.MERGE)
	@ManyToOne
	@JoinColumn(name = "idclase", nullable = false)
	private Clase clase;
}
