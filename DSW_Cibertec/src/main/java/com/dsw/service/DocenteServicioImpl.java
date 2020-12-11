package com.dsw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Clase;
import com.dsw.entidad.Docente;
import com.dsw.entidad.Nota;
import com.dsw.entidad.Usuario;
import com.dsw.repository.AlumnoRepositorio;
import com.dsw.repository.ClaseRepositorio;
import com.dsw.repository.DocenteRepositorio;
import com.dsw.repository.UsuarioRepositorio;


@Service
public class DocenteServicioImpl implements DocenteServicio{

	@Autowired
	private DocenteRepositorio repositorio;
	@Autowired
	private ClaseRepositorio repClase;
	@Override
	public Docente getDocenteXIdusuario(Integer idusuario) {return repositorio.getDocente(idusuario);}
	@Override
	public List<Clase> getClaseXDocente(Integer iddocente) {return repClase.getClaseXDocente(iddocente);}
	
	@Override
	public List<Docente> getAllDocente() {return repositorio.findAll();}
	@Override
	public List<Docente> filtrarDocentePorNombre(String nombre) {return repositorio.traerDocentePorNombre(nombre);}
	@Override
	public void actualizarDocente(Docente a) {repositorio.save(a);}
	@Override
	public void registrarDocente(Docente a) {repositorio.save(a);}
	@Override
	public void eliminarDocente(Docente a) {repositorio.delete(a);}
}
