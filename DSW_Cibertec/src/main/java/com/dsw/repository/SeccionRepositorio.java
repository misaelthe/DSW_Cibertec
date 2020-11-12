package com.dsw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Alumno_Clase;
import com.dsw.entidad.Curso;
import com.dsw.entidad.Nota;
import com.dsw.entidad.Seccion;

public interface SeccionRepositorio extends JpaRepository<Seccion, Integer>{
	
	@Query("Select s from Seccion s,Clase cl,Alumno_Clase ac where s.idseccion=cl.seccion.idseccion and cl.idclase = ac.clase.idclase and ac.alumno.idalumno = :idalum")
	public abstract List<Seccion> getSeccionXAlumno(@Param("idalum")Integer idalumno);

	@Query("Select s from Seccion s,Clase cl where s.idseccion=cl.seccion.idseccion and cl.docente.iddocente = :iddoc")
	public abstract List<Seccion> getSeccionXDocente(@Param("iddoc")Integer iddocente);
}
