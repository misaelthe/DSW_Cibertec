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
@Table(name = "docente")
public class Docente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddocente")
	private Integer iddocente;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "dni")
	private String dni;
	
	@Cascade(CascadeType.MERGE)
	@OneToOne
	@JoinColumn(name = "idusuario", nullable = false)
	private Usuario usuario;

	@Cascade(CascadeType.MERGE)
	@OneToOne
	@JoinColumn(name = "idcarrera", nullable = false)
	private Carrera carrera;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "correo")
	private String correo;

	@Column(name = "direccion")
	private String direccion;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecnac;

}
