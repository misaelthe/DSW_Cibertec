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
@Table(name = "nota")
public class Nota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idnota")
	private Integer idnota;

	@Cascade(CascadeType.MERGE)
	@OneToOne
	@JoinColumn(name = "idclase", nullable = false)
	private Clase clase;

	@Cascade(CascadeType.MERGE)
	@OneToOne
	@JoinColumn(name = "idalumno", nullable = false)
	private Alumno alumno;
	
	@Column(name = "e1")
	private Integer e1;

	@Column(name = "e2")
	private Integer e2;
	
	@Column(name = "ep")
	private Integer ep;

	@Column(name = "e3")
	private Integer e3;
	
	@Column(name = "ef")
	private Integer ef;

	@Column(name = "promedio")
	private Integer promedio;
	

}
