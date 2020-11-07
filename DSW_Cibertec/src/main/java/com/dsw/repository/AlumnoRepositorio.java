package com.dsw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dsw.entidad.Alumno;

public interface AlumnoRepositorio extends JpaRepository<Alumno, Integer>{

	@Query("Select a from Alumno a where a.nombre like :var_nombre")
	public abstract List<Alumno> traerAlumnoPorNombre(@Param("var_nombre")String nombre);
	
	@Query("Select a from Alumno a,Matricula m where a.idalumno != m.alumno.idalumno")
	public abstract List<Alumno> traerAlumnosNoMatriculados();
	
	@Query("Select a from Alumno a,Alumno_Clase ac where a.idalumno=ac.alumno.idalumno and ac.clase.idclase= :var_clase")
	public abstract List<Alumno> traerAlumnosXClase(@Param("var_clase")Integer clase);
}
