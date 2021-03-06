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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "seccion")
public class Seccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idseccion")
	private Integer idseccion;

	@Column(name = "codigo")
	private String codigo;

	@Cascade(CascadeType.MERGE)
	@OneToOne
	@JoinColumn(name = "idcarrera", nullable = false)
	private Carrera carrera;
	
	@Column(name = "ciclo")
	private Integer ciclo;
}
