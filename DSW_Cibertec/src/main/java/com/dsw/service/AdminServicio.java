package com.dsw.service;

import java.util.List;

import com.dsw.entidad.Carrera;
import com.dsw.entidad.Clase;
import com.dsw.entidad.Constancia;
import com.dsw.entidad.Curso;
import com.dsw.entidad.Docente;
import com.dsw.entidad.Matricula;
import com.dsw.entidad.Seccion;
import com.dsw.entidad.Usuario;

public interface AdminServicio {

	public abstract void insertMatricula(Matricula matricula);
	public abstract void insertConstancia(Constancia constancia);
	public abstract void insertClase(Clase clase);
	public abstract void insertCurso(Curso curso);
	public abstract void insertUsuario(Usuario usuario);
	public abstract void deleteClase(Integer idclase);
	public abstract void deleteDocente(Integer iddocente);
	public abstract List<Clase> getClaseByCurso(String nombre);
	public abstract List<Curso> getCursosBy(String nombre);
	public abstract List<Clase> getAllClase();
	public abstract List<Curso> getAllCurso();
	public abstract List<Seccion> getAllSeccion();
	public abstract List<Docente> getAllDocente();
	public abstract List<Carrera> getAllCarrera();
	public abstract List<Matricula> getAllMatricula();
	public abstract Usuario getLastUsuario();
	public abstract Docente getDocenteBy(Integer iddocente);
	public abstract Curso getCursoBy(Integer idcurso);
}
