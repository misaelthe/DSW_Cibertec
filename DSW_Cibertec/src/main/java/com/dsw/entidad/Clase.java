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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "clase")
public class Clase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idclase")
	private Integer idclase;
	
	@Cascade(CascadeType.MERGE)
	@OneToOne
	@JoinColumn(name = "idseccion", nullable = false)
	private Seccion seccion;
	
	@Cascade(CascadeType.MERGE)
	@ManyToOne
	@JoinColumn(name = "idcurso", nullable = false)
	private Curso curso;
	
	@Cascade(CascadeType.MERGE)
	@ManyToOne
	@JoinColumn(name = "iddocente", nullable = false)
	private Docente docente;
	
	@Column(name = "alum_ins")
	private Integer alum_ins;
}
