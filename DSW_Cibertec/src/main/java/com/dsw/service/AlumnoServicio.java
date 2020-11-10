package com.dsw.service;

import java.util.List;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Nota;

public interface AlumnoServicio {

	public abstract List<Alumno> getAllAlumno();
	
	public abstract List<Alumno> filtrarAlumnoPorNombre(String nombre);
	
	public abstract void actualizarAlumno(Alumno a);
	
	public abstract void registrarAlumno(Alumno a);
	
	public abstract void eliminarAlumno(Alumno a);
	
	public abstract List<Alumno> getAlumnosNoMatriculados();
	
	public abstract List<Alumno> getAlumnosXClase(Integer idclase);
	
	public abstract Nota getNotaXAlumnos(Integer idalumno,Integer idclase);
}
