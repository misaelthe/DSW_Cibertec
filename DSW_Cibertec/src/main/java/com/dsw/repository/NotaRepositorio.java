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
	
	@Query("Select n from Nota n,Alumno_Clase ac where n.clase.idclase = ac.clase.idclase and ac.alumno.idalumno = :idal")
	public abstract List<Nota> getNotasXAlumno(@Param("idal")Integer idalumno);
}
