package com.dsw.service;

import java.util.List;
import com.dsw.entidad.Clase;
import com.dsw.entidad.Constancia;
import com.dsw.entidad.Curso;
import com.dsw.entidad.Docente;
import com.dsw.entidad.Matricula;
import com.dsw.entidad.Seccion;

public interface AdminServicio {

	public abstract void insertMatricula(Matricula matricula);
	public abstract void insertConstancia(Constancia constancia);
	public abstract List<Clase> getClaseByCurso(String nombre);
	public abstract List<Clase> getAllClase();
	public abstract List<Curso> getAllCurso();
	public abstract List<Seccion> getAllSeccion();
	public abstract List<Docente> getAllDocente();
}
