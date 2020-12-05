package com.dsw.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dsw.entidad.Clase;
import com.dsw.entidad.Constancia;
import com.dsw.entidad.Curso;
import com.dsw.entidad.Docente;
import com.dsw.entidad.Matricula;
import com.dsw.entidad.Seccion;
import com.dsw.repository.ClaseRepositorio;
import com.dsw.repository.ConstanciaRepositorio;
import com.dsw.repository.CursoRepositorio;
import com.dsw.repository.DocenteRepositorio;
import com.dsw.repository.MatriculaRepositorio;
import com.dsw.repository.SeccionRepositorio;

@Service
public class AdminServicioImpl implements AdminServicio{

	@Autowired
	private MatriculaRepositorio repMatricula;
	@Autowired
	private ConstanciaRepositorio repConstancia;
	@Autowired
	private ClaseRepositorio repClase;
	@Autowired
	private CursoRepositorio repCurso;
	@Autowired
	private DocenteRepositorio repDocente;
	@Autowired
	private SeccionRepositorio repSeccion;
	
	@Override
	public void insertMatricula(Matricula matricula) {repMatricula.save(matricula);}
	@Override
	public void insertConstancia(Constancia constancia) {repConstancia.save(constancia);}
	@Override
	public List<Clase> getClaseByCurso(String nombre) {return repClase.getClaseByCurso(nombre);}
	@Override
	public List<Clase> getAllClase() {return repClase.findAll();}
	@Override
	public List<Curso> getAllCurso() {return repCurso.findAll();}
	@Override
	public List<Docente> getAllDocente() {return repDocente.findAll();}
	@Override
	public List<Seccion> getAllSeccion() {return repSeccion.findAll();}
	@Override
	public void insertClase(Clase clase) {repClase.save(clase);}
	@Override
	public void deleteClase(Integer idclase) {repClase.deleteById(idclase);}
}
