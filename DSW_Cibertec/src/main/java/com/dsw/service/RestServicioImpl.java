package com.dsw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Alumno_Clase;
import com.dsw.entidad.Carrera;
import com.dsw.entidad.Clase;
import com.dsw.entidad.Curso;
import com.dsw.entidad.Docente;
import com.dsw.entidad.Nota;
import com.dsw.entidad.Seccion;
import com.dsw.entidad.Usuario;
import com.dsw.repository.AlumnoRepositorio;
import com.dsw.repository.Alumno_ClaseRepositorio;
import com.dsw.repository.CarreraRepositorio;
import com.dsw.repository.ClaseRepositorio;
import com.dsw.repository.CursoRepositorio;
import com.dsw.repository.DocenteRepositorio;
import com.dsw.repository.NotaRepositorio;
import com.dsw.repository.SeccionRepositorio;
import com.dsw.repository.UsuarioRepositorio;


@Service
public class RestServicioImpl implements RestServicio{

	@Autowired
	private SeccionRepositorio repSeccion;
	@Autowired
	private Alumno_ClaseRepositorio repAlumno_Clase;
	@Autowired
	private ClaseRepositorio repClase;
	@Autowired
	private CursoRepositorio repCurso;
	@Autowired
	private AlumnoRepositorio repAlumno;
	@Autowired
	private DocenteRepositorio repDocente;
	@Autowired
	private NotaRepositorio repNota;
	@Autowired
	private UsuarioRepositorio repUsuario;
	@Autowired
	private CarreraRepositorio repCarrera;
	//SECCION
	@Override
	public List<Seccion> getSeccionesXAlumno(Integer idalumno) {return repSeccion.getSeccionesXAlumno(idalumno);}
	@Override
	public List<Seccion> getSeccionesXDocente(Integer iddocente) {return repSeccion.getSeccionesXDocente(iddocente);}
	//ALUMNO_CLASE
	@Override
	public List<Alumno_Clase> getAlumno_Clase(Integer idalumno) {return repAlumno_Clase.getAlumno_Clase(idalumno);}
	@Override
	public List<Alumno_Clase> getAlumnoClaseXDocente(Integer iddocente) {return repAlumno_Clase.getAlumnoClaseXDocente(iddocente);}
	//CLASE
	@Override
	public List<Clase> getClaseXAlumno(Integer idalumno) {return repClase.getClaseXAlumno(idalumno);}
	@Override
	public List<Clase> getClaseXDocente(Integer iddocente) {return repClase.getClaseXDocente(iddocente);}
	//CURSO
	@Override
	public List<Curso> getCursoXAlumno(Integer idalumno) {return repCurso.getCursoXAlumno(idalumno);}
	@Override
	public List<Curso> getCursoXDocente(Integer iddocente) {return repCurso.getCursoXDocente(iddocente);}
	//ALUMNO
	@Override
	public Alumno getAlumno(Integer idusuario) {return repAlumno.getAlumno(idusuario);}
	@Override
	public List<Alumno> getAlumnosXDocente(Integer iddocente) {return repAlumno.getAlumnosXDocente(iddocente);}
	//DOCENTE
	@Override
	public Docente getDocente(Integer idusuario) {return repDocente.getDocente(idusuario);}
	//NOTA
	@Override
	public List<Nota> getNotasXDocente(Integer iddocente) {return repNota.getNotasXDocente(iddocente);}
	@Override
	public List<Nota> getNotasXAlumno(Integer idalumno) {return repNota.getNotasXAlumno(idalumno);}
	@Override
	public Nota getNotasBy(Integer idnota) {return repNota.getNotasBy(idnota);}
	//USUARIO
	@Override
	public Usuario getUsuario(String usuario, String password) {return repUsuario.getUsuario(usuario, password);}
	@Override
	public void insertNota(Nota nota) {repNota.save(nota);}
	//CARRERA
	public List<Carrera> getCarreras() {return repCarrera.findAll();}
}
