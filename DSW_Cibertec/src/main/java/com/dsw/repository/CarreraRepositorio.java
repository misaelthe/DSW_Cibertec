package com.dsw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Alumno_Clase;
import com.dsw.entidad.Carrera;
import com.dsw.entidad.Curso;
import com.dsw.entidad.Nota;

public interface CarreraRepositorio extends JpaRepository<Carrera, Integer>{
	

}
