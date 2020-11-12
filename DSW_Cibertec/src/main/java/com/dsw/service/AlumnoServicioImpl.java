package com.dsw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Nota;
import com.dsw.entidad.Usuario;
import com.dsw.repository.AlumnoRepositorio;
import com.dsw.repository.UsuarioRepositorio;


@Service
public class AlumnoServicioImpl implements AlumnoServicio{

	@Autowired
	private AlumnoRepositorio repositorio;
	
	@Override
	public List<Alumno> filtrarAlumnoPorNombre(String nombre) {return repositorio.traerAlumnoPorNombre(nombre);}

	@Override
	public void actualizarAlumno(Alumno a) {repositorio.save(a);}

	@Override
	public void registrarAlumno(Alumno a) {repositorio.save(a);}

	@Override
	public void eliminarAlumno(Alumno a) {repositorio.delete(a);}

	@Override
	public List<Alumno> getAlumnosNoMatriculados() {return repositorio.traerAlumnosNoMatriculados();}

	@Override
	public List<Alumno> getAlumnosXClase(Integer idclase) {return repositorio.traerAlumnosXClase(idclase);}

	@Override
	public Nota getNotaXAlumnos(Integer idalumno, Integer idclase) {return repositorio.traerNotaXAlumno(idalumno, idclase);}

	@Override
	public List<Alumno> getAllAlumno() {return repositorio.traerAllAlumnos();}

}
