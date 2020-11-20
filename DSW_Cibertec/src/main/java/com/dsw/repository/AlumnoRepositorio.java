package com.dsw.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Clase;
import com.dsw.entidad.Nota;

public interface AlumnoRepositorio extends JpaRepository<Alumno, Integer>{

	@Query("Select a from Alumno a where a.nombre like :var_nombre")
	public abstract List<Alumno> traerAlumnoPorNombre(@Param("var_nombre")String nombre);
	
	@Query("Select a from Alumno a")
	public abstract List<Alumno> traerAllAlumnos();
	
	@Query("Select a from Alumno a,Matricula m where a.idalumno != m.alumno.idalumno")
	public abstract List<Alumno> traerAlumnosNoMatriculados();
	
	@Query("Select a from Alumno a,Alumno_Clase ac where a.idalumno = ac.alumno.idalumno and ac.clase.idclase = :var_clase")
	public abstract List<Alumno> traerAlumnosXClase(@Param("var_clase")Integer clase);
	
	@Query("Select n from Nota n where n.alumno.idalumno = :var_idalumno and n.clase.idclase = :var_idclase")
	public abstract Nota traerNotaXAlumno(@Param("var_idalumno")Integer idalumno,@Param("var_idclase")Integer idclase);
	
	@Query("Select x from Clase x,Alumno_Clase ac,Alumno a where x.clase.idclase = ac.clase.idclase and ac.alumno.idalumno = :idal")
	public abstract List<Clase> getClasesXAlumno(@Param("idal")Integer idalumno);
	
	@Query("Select a from Alumno a where a.usuario.idusuario = :idusu")
	public abstract Alumno getAlumno(@Param("idusu")Integer idusuario);
	
	@Query("Select DISTINCT a from Alumno a,Alumno_Clase ac,Clase c where a.idalumno = ac.alumno.idalumno and ac.clase.idclase = c.idclase and c.docente.iddocente = :iddoc")
	//@QueryHints(value = {@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH,value = "false")})
	public abstract List<Alumno> getAlumnosXDocente(@Param("iddoc")Integer iddocente);
}
