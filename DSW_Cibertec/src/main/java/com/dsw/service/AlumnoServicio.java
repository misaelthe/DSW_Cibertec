package com.dsw.service;

import java.util.List;

import com.dsw.entidad.Alumno;

public interface AlumnoServicio {

	public abstract List<Alumno> filtrarAlumnoPorNombre(String nombre);
	
	public abstract void actualizarAlumno(Alumno a);
	
	public abstract void registrarAlumno(Alumno a);
	
	public abstract void eliminarAlumno(Alumno a);
	
	public abstract List<Alumno> getAlumnosNoMatriculados();
	
	public abstract List<Alumno> getAlumnosXClase(Integer idclase);
}
