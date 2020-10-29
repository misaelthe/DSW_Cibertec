package com.dsw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dsw.entidad.Alumno;

public interface AlumnoRepositorio extends JpaRepository<Alumno, Integer>{

	@Query("Select a from Alumno a where a.nombre like :var_nombre")
	public abstract List<Alumno> traerAlumnoPorNombre(@Param("var_nombre")String nombre);
}
