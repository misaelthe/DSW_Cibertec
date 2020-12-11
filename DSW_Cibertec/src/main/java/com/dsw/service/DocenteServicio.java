package com.dsw.service;

import java.util.List;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Clase;
import com.dsw.entidad.Docente;
import com.dsw.entidad.Nota;
import com.dsw.entidad.Usuario;

public interface DocenteServicio {
	public abstract Docente getDocenteXIdusuario(Integer idusuario);
	public abstract List<Clase> getClaseXDocente(Integer iddocente);
	
	public abstract List<Docente> getAllDocente();
	public abstract List<Docente> filtrarDocentePorNombre(String nombre);
	public abstract void actualizarDocente(Docente a);
	public abstract void registrarDocente(Docente a);
	public abstract void eliminarDocente(Docente a);
}
