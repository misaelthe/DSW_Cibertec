package com.dsw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Clase;
import com.dsw.entidad.Curso;
import com.dsw.entidad.Matricula;
import com.dsw.entidad.Nota;
import com.dsw.entidad.Seccion;
import com.dsw.entidad.Usuario;
import com.dsw.repository.AlumnoRepositorio;
import com.dsw.repository.ClaseRepositorio;
import com.dsw.repository.NotaRepositorio;
import com.dsw.repository.UsuarioRepositorio;


@Service
public class AlumnoServicioImpl implements AlumnoServicio{

	@Autowired
	private AlumnoRepositorio repositorio;
	@Autowired
	private NotaRepositorio repNota;
	@Autowired
	private ClaseRepositorio repClase;
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
	public Alumno getAlumnoXUsuario(Integer idusuario) {return repositorio.getAlumno(idusuario);}
	
	@Override
	public Nota getNotaXAlumnoXClase(Integer idalumno, Integer idclase) {return repNota.getNotaXAlumnoXClase(idalumno, idclase);}
	@Override
	public void insertNota(Nota nota) {repNota.save(nota);}
	@Override
	public List<Alumno> getAllAlumno() {return repositorio.traerAllAlumnos();}
	@Override
	public Alumno getAlumnoXIdalumno(Integer idalumno) {return repositorio.getAlumnoXIdalumno(idalumno);}
	
	@Override
	public List<Clase> getClasesXAlumnos(Integer idalumno) {return repositorio.getClasesXAlumno(idalumno);}

	@Override
	public List<Curso> getCursosXUsuario(Integer idusuario) {
		List<Matricula> tem=repositorio.getMatriculaXUsuario(idusuario);
		Matricula m=tem.get(tem.size()-1);
		return repositorio.getCursosXCiclo(m.getCiclo());
	}

	@Override
	public List<Seccion> getSeccionesXCicloXCarrera(Integer idusuario) {
		List<Matricula> tem=repositorio.getMatriculaXUsuario(idusuario);
		Matricula m=tem.get(tem.size()-1);
		return repositorio.getSeccionesXCicloXCarrera(m.getCiclo(),m.getCarrera().getIdcarrera());
	}

	@Override
	public List<Clase> getClasesXUsuario(Integer idusuario) {
		List<Matricula> tem=repositorio.getMatriculaXUsuario(idusuario);
		Matricula m=tem.get(tem.size()-1);
		return repositorio.getClasesXCicloXCarrera(m.getCiclo(),m.getCarrera().getIdcarrera());
	}

	@Override
	public Clase getClaseBy(Integer idclase) {return repClase.getClaseBy(idclase);}

}
