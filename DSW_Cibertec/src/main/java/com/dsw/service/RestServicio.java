package com.dsw.service;

import java.util.List;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Alumno_Clase;
import com.dsw.entidad.Carrera;
import com.dsw.entidad.Clase;
import com.dsw.entidad.Curso;
import com.dsw.entidad.Docente;
import com.dsw.entidad.Nota;
import com.dsw.entidad.Seccion;
import com.dsw.entidad.Usuario;

public interface RestServicio {
	
	//ALUMNO_CLASE
	public abstract List<Alumno_Clase> getAlumno_Clase(Integer idalumno);
	public abstract List<Alumno_Clase> getAlumnoClaseXDocente(Integer iddocente);
	//CLASE
	public abstract List<Clase> getClaseXAlumno(Integer idalumno);	
	public abstract List<Clase> getClaseXDocente(Integer iddocente);
	//CURSO
	public abstract List<Curso> getCursoXAlumno(Integer idalumno);
	public abstract List<Curso> getCursoXDocente(Integer iddocente);
	//ALUMNO
	public abstract Alumno getAlumno(Integer idusuario);
	public abstract List<Alumno> getAlumnosXDocente(Integer iddocente);
	//DOCENTE
	public abstract Docente getDocente(Integer idusuario);
	//NOTA
	public abstract List<Nota> getNotasXDocente(Integer iddocente);
	public abstract List<Nota> getNotasXAlumno(Integer idalumno);
	//SECCION
	public abstract List<Seccion> getSeccionesXDocente(Integer iddocente);
	public abstract List<Seccion> getSeccionesXAlumno(Integer idalumno);
	//USUARIO
	public abstract Usuario getUsuario(String usuario,String password);
	
	public abstract void insertNota(Nota nota);
	//CARRERA
	public abstract List<Carrera> getCarreras();
}
