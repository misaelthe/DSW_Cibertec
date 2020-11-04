package com.dsw.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "matricula")
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmatricula")
	private Integer idmatricula;

	@Cascade(CascadeType.MERGE)
	@ManyToOne
	@JoinColumn(name = "idalumno", nullable = false)
	private Alumno alumno;

	@Column(name = "periodo")
	private String periodo;
	
	@Column(name = "ciclo")
	private Integer ciclo;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@Cascade(CascadeType.MERGE)
	@OneToOne
	@JoinColumn(name = "idcarrera", nullable = false)
	private Carrera carrera;

	@Cascade(CascadeType.MERGE)
	@OneToOne
	@JoinColumn(name = "idturno", nullable = false)
	private Turno turno;
}
