package com.dsw.entidad;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class Alumno_ClasePK implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idalumno;
	private Integer idclase;	
}
