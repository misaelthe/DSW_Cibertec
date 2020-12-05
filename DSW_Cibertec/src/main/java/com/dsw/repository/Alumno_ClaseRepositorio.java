package com.dsw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Alumno_Clase;
import com.dsw.entidad.Nota;

public interface Alumno_ClaseRepositorio extends JpaRepository<Alumno_Clase, Integer>{
	
	@Query("Select ac from Alumno_Clase ac where ac.alumno.idalumno = :idalum")
	public abstract List<Alumno_Clase> getAlumno_Clase(@Param("idalum")Integer idalumno);

	@Query("Select ac from Alumno_Clase ac where ac.alumno.idalumno = :idalum and ac.clase.idclase = :idcla")
	public abstract Alumno_Clase getAlumno_ClaseXAlumnoXClase(@Param("idalum")Integer idalumno,@Param("idcla")Integer idclase);
	
	@Query("Select ac from Alumno_Clase ac,Clase c where ac.clase.idclase = c.idclase and c.docente.iddocente = :iddoc")
	public abstract List<Alumno_Clase> getAlumnoClaseXDocente(@Param("iddoc")Integer iddocente);
}
