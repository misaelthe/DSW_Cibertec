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
}
