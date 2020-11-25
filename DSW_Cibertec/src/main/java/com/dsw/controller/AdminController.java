package com.dsw.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.dsw.entidad.Alumno;
import com.dsw.entidad.Carrera;
import com.dsw.entidad.Constancia;
import com.dsw.entidad.Matricula;
import com.dsw.entidad.Turno;
import com.dsw.service.AlumnoServicio;
import com.dsw.service.RestServicio;
import com.dsw.service.UsuarioServicio;

@Controller
@RequestMapping(value = "/administrador")
public class AdminController {

	@Autowired
	private AlumnoServicio ser_alumno;
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
		return "redirect:salidaAlumno";
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
		Matricula ma=new Matricula();System.out.println(archivo+"------------------------------------------------------------------");
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
		
		c.setAlumno(a);
		c.setColegio(nombreColegio);
		c.setFin_colegio(finColegio);
		c.setIdconstancia(null);
		c.setConstancia("C:\\\\Cibertec\\Constancias\\"+archivo);
		return "admin/indexAdmin";
	}

	
	/*
spring.datasource.url=jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10378393?serverTimezone=UTC
spring.datasource.username=sql10378393
spring.datasource.password=AQRhHkByuV
spring.datasource.url=jdbc:mysql://localhost:3306/cibertec?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=mysql*/
}
