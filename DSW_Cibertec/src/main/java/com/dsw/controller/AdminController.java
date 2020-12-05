package com.dsw.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dsw.entidad.Alumno;
import com.dsw.entidad.Carrera;
import com.dsw.entidad.Clase;
import com.dsw.entidad.Constancia;
import com.dsw.entidad.Curso;
import com.dsw.entidad.Docente;
import com.dsw.entidad.Matricula;
import com.dsw.entidad.Seccion;
import com.dsw.entidad.Turno;
import com.dsw.service.AdminServicio;
import com.dsw.service.AlumnoServicio;
import com.dsw.service.RestServicio;

@Controller
@RequestMapping(value = "/administrador")
public class AdminController {

	@Autowired
	private AlumnoServicio ser_alumno;
	@Autowired
	private AdminServicio serAdmin;
	@Autowired
	private RestServicio ser_rest;
	
	@RequestMapping("/verIndexAdmin")
	public String verIndex() {
		return "admin/indexAdmin";
	}	
	@RequestMapping("/verCrudAlumno")
	public String verCrudAlumno() {
		return "admin/crudAlumno";
	}
	@RequestMapping("/filtrarAlumno")
	public String filtrarAlumno(String nom_alumno,HttpSession session) {
		List<Alumno> data=ser_alumno.filtrarAlumnoPorNombre(nom_alumno+"%");
		session.setAttribute("alumnos", data);
		return "redirect:verCrudAlumno";
	}
	@RequestMapping(value="/getAllAlumno",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Alumno>> getAllAlumno() {
		List<Alumno> data=ser_alumno.getAllAlumno();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	@RequestMapping("/registrarAlumno")
	public String registrarAlumno(Alumno a,HttpSession session) {		
		a.getUsuario().setPassword(a.getDni());
		a.getUsuario().setCredencial(1);
		a.getUsuario().setUsuario(a.getDni());
		a.getUsuario().setIdusuario(1);
		ser_alumno.registrarAlumno(a);
		return "redirect:salidaAlumno";
	}
	@RequestMapping("/actualizarAlumno")
	public String actualizarAlumno(Alumno a,HttpSession session) {
		ser_alumno.actualizarAlumno(a);
		return "redirect:salidaAlumno";
	}
	@RequestMapping("/eliminarAlumno")
	public String eliminarAlumno(Alumno a,HttpSession session) {
		ser_alumno.eliminarAlumno(a);
		return "redirect:salidaAlumno";
	}
	@RequestMapping("/salidaAlumno")
	public String salidaCrudAlumno(HttpSession session) {
		List<Alumno> data=ser_alumno.getAllAlumno();
		session.setAttribute("alumnos", data);
		return "admin/crudAlumno";
	}	
	//CRUD DE CLASE
	@RequestMapping("/verCrudClase")
	public String verCrudClase() {
		return "admin/crudClase";
	}
	@RequestMapping("/filtrarCurso")
	public String filtrarCurso(String curso,HttpSession session) {
		List<Clase> data=serAdmin.getClaseByCurso(curso+"%");
		session.setAttribute("clases", data);
		return "redirect:verCrudClase";
	}
	@RequestMapping("/salidaClase")
	public String salidaClase(HttpSession session) {
		List<Clase> data=serAdmin.getAllClase();
		session.setAttribute("clases", data);
		return "admin/crudClase";
	}	
	@RequestMapping(value="/getAllClase",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Clase>> getAllClase() {
		List<Clase> data=serAdmin.getAllClase();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	@RequestMapping(value="/getAllSeccion",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Seccion>> getAllSeccion() {
		List<Seccion> data=serAdmin.getAllSeccion();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	@RequestMapping(value="/getAllCurso",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Curso>> getAllCurso() {
		List<Curso> data=serAdmin.getAllCurso();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	@RequestMapping(value="/getAllDocente",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Docente>> getAllDocente() {
		List<Docente> data=serAdmin.getAllDocente();
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	@RequestMapping("/registrarClase")
	public String registrarClase(Integer idseccion,Integer idcurso,Integer iddocente,Integer alum_ins,HttpSession session) {	
		Clase cla=new Clase();
		Seccion s=new Seccion();
		Curso cu=new Curso();
		Docente d=new Docente();
		
		s.setIdseccion(idseccion);
		cu.setIdcurso(idcurso);
		d.setIddocente(iddocente);
		
		cla.setIdclase(null);
		cla.setCurso(cu);
		cla.setDocente(d);
		cla.setSeccion(s);
		cla.setAlum_ins(alum_ins);
		serAdmin.insertClase(cla);
		return "redirect:salidaClase";
	}
	@RequestMapping("/actualizarClase")
	public String actualizarClase(Integer idclase,Integer idseccion,Integer idcurso,Integer iddocente,Integer alum_ins,HttpSession session) {
		Clase cla=new Clase();
		Seccion s=new Seccion();
		Curso cu=new Curso();
		Docente d=new Docente();
		
		s.setIdseccion(idseccion);
		cu.setIdcurso(idcurso);
		d.setIddocente(iddocente);
		
		cla.setIdclase(idclase);
		cla.setCurso(cu);
		cla.setDocente(d);
		cla.setSeccion(s);
		cla.setAlum_ins(alum_ins);
		serAdmin.insertClase(cla);
		return "redirect:salidaAlumno";
	}
	@RequestMapping("/eliminarClase")
	public String eliminarClase(Integer idclase,HttpSession session) {
		serAdmin.deleteClase(idclase);
		return "redirect:salidaAlumno";
	}
	//MATRICULA
	@RequestMapping("/verMatricula")
	public String verMatricula() {
		return "admin/matricula";
	}
	@GetMapping(value="/getAlumnosNoMatriculados",produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Alumno>> getAlumnosNoMatriculados() {
		List<Alumno> tem=ser_alumno.getAlumnosNoMatriculados();
		return new ResponseEntity<>(tem, HttpStatus.OK);
	}
	@GetMapping(value="/getCarreras",produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Carrera>> getCarreras() {
		List<Carrera> tem=ser_rest.getCarreras();
		return new ResponseEntity<>(tem, HttpStatus.OK);
	}
	@RequestMapping("/registrarMatricula")
	public String registrarMatricula(String idalumno,String periodo,String idturno,String idcarrera,String nombreColegio,String codModular,String finColegio,String archivo) {
		Matricula ma=new Matricula();
		Constancia c=new Constancia();
		Turno t=new Turno();
		Carrera ca=new Carrera();
		Date d=new Date();
		
		Alumno a=ser_alumno.getAlumnoXIdalumno(Integer.parseInt(idalumno));
		t.setIdturno(Integer.parseInt(idturno));		
		ca.setIdcarrera(Integer.parseInt(idcarrera));
		ma.setAlumno(a);
		ma.setCiclo(1);
		ma.setIdmatricula(null);
		ma.setPeriodo(periodo);
		ma.setTurno(t);
		ma.setFecha(d);
		ma.setCarrera(ca);
		
		c.setAlumno(a);
		c.setColegio(nombreColegio);
		c.setFin_colegio(finColegio);
		c.setCodigo_mod_colegio(codModular);
		c.setIdconstancia(null);
		c.setConstancia("C:\\\\Cibertec\\Constancias\\"+archivo);
		
		serAdmin.insertMatricula(ma);
		serAdmin.insertConstancia(c);
		return "admin/indexAdmin";
	}

	
	/*
spring.datasource.url=jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10379803?serverTimezone=UTC
spring.datasource.username=sql10379803
spring.datasource.password=Ysg5Lv8iIN
spring.datasource.url=jdbc:mysql://localhost:3306/cibertec?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=mysql*/
}