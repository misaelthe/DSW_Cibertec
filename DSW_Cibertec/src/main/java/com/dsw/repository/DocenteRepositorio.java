package com.dsw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Docente;
import com.dsw.entidad.Nota;

public interface DocenteRepositorio extends JpaRepository<Docente, Integer>{

	@Query("Select d from Docente d where d.usuario.idusuario = :idusu")
	public abstract Docente getDocente(@Param("idusu")Integer idusuario);
	
	@Query("Select a from Docente a where a.nombre like :var_nombre")
	public abstract List<Docente> traerDocentePorNombre(@Param("var_nombre")String nombre);
	
}
