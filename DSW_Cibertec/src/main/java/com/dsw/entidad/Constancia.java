package com.dsw.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "constancia")
public class Constancia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idconstancia")
	private Integer idconstancia;
	
	@Cascade(CascadeType.MERGE)
	@OneToOne
	@JoinColumn(name = "idalumno", nullable = false)
	private Alumno alumno;

	@Column(name = "colegio")
	private String colegio;

	@Column(name = "fin_colegio")
	private String fin_colegio;

	@Column(name = "constancia")
	private String constancia;
}
