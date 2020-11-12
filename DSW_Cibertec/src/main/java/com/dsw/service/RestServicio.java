package com.dsw.service;

import java.util.List;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Alumno_Clase;
import com.dsw.entidad.Clase;
import com.dsw.entidad.Curso;
import com.dsw.entidad.Docente;
import com.dsw.entidad.Nota;
import com.dsw.entidad.Seccion;
import com.dsw.entidad.Usuario;

public interface RestServicio {
	
	//SECCION
	public abstract List<Seccion> getSeccionXAlumno(Integer idalumno);	
	public abstract List<Seccion> getSeccionXDocente(Integer iddocente);
	//ALUMNO_CLASE
	public abstract List<Alumno_Clase> getAlumno_Clase(Integer idalumno);
	//CLASE
	public abstract List<Clase> getClaseXAlumno(Integer idalumno);	
	public abstract List<Clase> getClaseXDocente(Integer iddocente);
	//CURSO
	public abstract List<Curso> getCursoXAlumno(Integer idalumno);
	public abstract List<Curso> getCursoXDocente(Integer iddocente);
	//ALUMNO
	public abstract Alumno getAlumno(Integer idusuario);
	//DOCENTE
	public abstract Docente getDocente(Integer idusuario);
	//NOTA
	public abstract List<Nota> getNotaXAlumno(Integer idalumno);
	//USUARIO
	public abstract Usuario getUsuario(String usuario,String password);
}
