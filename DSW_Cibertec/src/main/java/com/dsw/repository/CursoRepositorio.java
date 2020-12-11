package com.dsw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Alumno_Clase;
import com.dsw.entidad.Curso;
import com.dsw.entidad.Nota;

public interface CursoRepositorio extends JpaRepository<Curso, Integer>{
	
	@Query("Select cu from Curso cu,Clase cl,Alumno_Clase ac where cu.idcurso=cl.curso.idcurso and cl.idclase = ac.clase.idclase and ac.alumno.idalumno = :idalum")
	public abstract List<Curso> getCursoXAlumno(@Param("idalum")Integer idalumno);

	@Query("Select cu from Curso cu,Clase cl where cu.idcurso=cl.curso.idcurso and cl.docente.iddocente = :iddoc")
	public abstract List<Curso> getCursoXDocente(@Param("iddoc")Integer iddocente);
	
	@Query("Select cu from Curso cu where cu.nombre like :nom")
	public abstract List<Curso> getCursosBy(@Param("nom")String nombre);
}
