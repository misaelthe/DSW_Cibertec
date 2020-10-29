package com.dsw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Usuario;
import com.dsw.repository.AlumnoRepositorio;
import com.dsw.repository.UsuarioRepositorio;


@Service
public class AlumnoServicioImpl implements AlumnoServicio{

	@Autowired
	private AlumnoRepositorio repositorio;
	
	@Override
	public List<Alumno> filtrarAlumnoPorNombre(String nombre) {
		return repositorio.traerAlumnoPorNombre(nombre);
	}

}
