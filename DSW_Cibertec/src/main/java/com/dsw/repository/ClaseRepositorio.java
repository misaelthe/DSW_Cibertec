package com.dsw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Alumno_Clase;
import com.dsw.entidad.Clase;
import com.dsw.entidad.Nota;

public interface ClaseRepositorio extends JpaRepository<Clase, Integer>{
	
	@Query("Select a from Clase a,Alumno_Clase ac where a.idclase = ac.clase.idclase and ac.alumno.idalumno = :idalum")
	public abstract List<Clase> getClaseXAlumno(@Param("idalum")Integer idalumno);

	@Query("Select a from Clase a where a.docente.iddocente = :iddoc")
	public abstract List<Clase> getClaseXDocente(@Param("iddoc")Integer iddocente);
	
	@Query("Select a from Clase a,Curso c where a.curso.idcurso=c.idcurso and c.nombre like :cur")
	public abstract List<Clase> getClaseByCurso(@Param("cur")String curso);
	
	@Query("Select a from Clase a where a.idclase = :cla")
	public abstract Clase getClaseBy(@Param("cla")Integer idclase);
}
