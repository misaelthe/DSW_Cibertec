package com.dsw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Alumno_Clase;
import com.dsw.entidad.Nota;

public interface NotaRepositorio extends JpaRepository<Nota, Integer>{
	
	@Query("Select n from Nota n,Clase c where n.clase.idclase = c.idclase and c.docente.iddocente = :iddoc")
	public abstract List<Nota> getNotasXDocente(@Param("iddoc")Integer iddocente);
	
	@Query("Select n from Nota n where n.alumno.idalumno = :idal")
	public abstract List<Nota> getNotasXAlumno(@Param("idal")Integer idalumno);
	
	@Query("Select n from Nota n where n.idnota = :idno")
	public abstract Nota getNotasBy(@Param("idno")Integer idnota);
	
	@Query("Select n from Nota n where n.alumno.idalumno = :idal and n.clase.idclase = :idcla")
	public abstract Nota getNotaXAlumnoXClase(@Param("idal")Integer idalumno,@Param("idcla")Integer idclase);
}
