package com.dsw.service;

import java.util.List;

import com.dsw.entidad.Alumno;

public interface AlumnoServicio {

	public abstract List<Alumno> filtrarAlumnoPorNombre(String nombre);
	
}
