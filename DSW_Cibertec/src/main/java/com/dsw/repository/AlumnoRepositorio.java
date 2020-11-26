package com.dsw.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.dsw.entidad.Alumno;
import com.dsw.entidad.Clase;

public interface AlumnoRepositorio extends JpaRepository<Alumno, Integer>{

	@Query("Select a from Alumno a where a.nombre like :var_nombre")
	public abstract List<Alumno> traerAlumnoPorNombre(@Param("var_nombre")String nombre);
	
	@Query("Select a from Alumno a")
	public abstract List<Alumno> traerAllAlumnos();
	
	@Query("Select a from Alumno a,Matricula m where a.idalumno != m.alumno.idalumno")
	public abstract List<Alumno> traerAlumnosNoMatriculados();
	
	@Query("Select a from Alumno a,Alumno_Clase ac where a.idalumno = ac.alumno.idalumno and ac.clase.idclase = :var_clase")
	public abstract List<Alumno> traerAlumnosXClase(@Param("var_clase")Integer clase);
	
	@Query("Select x from Clase x,Alumno_Clase ac where x.idclase = ac.clase.idclase and ac.alumno.idalumno = :idal")
	public abstract List<Clase> getClasesXAlumno(@Param("idal")Integer idalumno);
	
	@Query("Select a from Alumno a where a.usuario.idusuario = :idusu")
	public abstract Alumno getAlumno(@Param("idusu")Integer idusuario);
	
	@Query("Select a from Alumno a where a.idalumno = :idal")
	public abstract Alumno getAlumnoXIdalumno(@Param("idal")Integer idalumno);
	
	@Query("Select DISTINCT a from Alumno a,Alumno_Clase ac,Clase c where a.idalumno = ac.alumno.idalumno and ac.clase.idclase = c.idclase and c.docente.iddocente = :iddoc")
	public abstract List<Alumno> getAlumnosXDocente(@Param("iddoc")Integer iddocente);
	
	//@QueryHints(value = {@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH,value = "false")})
}

