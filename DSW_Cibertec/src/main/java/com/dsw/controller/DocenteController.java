package com.dsw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Clase;
import com.dsw.entidad.Docente;
import com.dsw.entidad.Nota;
import com.dsw.entidad.Usuario;
import com.dsw.service.AlumnoServicio;
import com.dsw.service.DocenteServicio;
import com.dsw.service.RestServicio;
import com.dsw.service.UsuarioServicio;

@Controller
@RequestMapping(value = "/docente")
public class DocenteController {

	@Autowired
	private AlumnoServicio ser_alumno;
	@Autowired
	private UsuarioServicio ser_usuario;
	@Autowired
	private DocenteServicio ser_docente;
	@Autowired
	private RestServicio serRest;
	
	@RequestMapping("/verIndexDocente")
	public String verIndexDocente() {
		return "docente/indexDocente";
	}
	@RequestMapping("/verPageListarClase")
	public String verPageListarClase() {
		return "docente/pageListarClase";
	}
	@RequestMapping("/verPageListarAlumnos")
	public String verPageListarAlumnos(String idclase,HttpSession session) {
		session.setAttribute("claseSeleccionada",idclase);
		return "docente/pageListarAlumnos";
	}
	@RequestMapping("/verPageRegistrarNotas")
	public String verPageRegistrarNotas() {
		return "docente/pageRegistrarNotas";
	}
	@RequestMapping("/verPageRegistrarNota")
	public String verPageRegistrarNota(String idalumno,HttpSession session) {	
		return "registrarNota";
	}
	@RequestMapping(value="/getClasesXDocente",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Clase>> getClasesXDocente(HttpSession session) {
		Usuario u=(Usuario)session.getAttribute("objUsuario");
		Docente d=ser_docente.getDocenteXIdusuario(u.getIdusuario());
		List<Clase> tem=ser_docente.getClaseXDocente(d.getIddocente());
		return new ResponseEntity<>(tem, HttpStatus.OK);
	}
	@RequestMapping(value="/getAlumnosXClase",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Alumno>> getAlumnosDocenteCurso(HttpSession session) {
		Integer idclase=Integer.parseInt((String)session.getAttribute("claseSeleccionada"));
		List<Alumno> tem=ser_alumno.getAlumnosXClase(idclase);
		return new ResponseEntity<>(tem, HttpStatus.OK);
	}
	@RequestMapping(value="/getNotaAlumno",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<Nota> getNotaAlumno(HttpServletRequest request) {
		Integer idalumno=(Integer)request.getSession().getAttribute("idalumno");
		Integer idclase=(Integer)request.getSession().getAttribute("idclase");
		Nota tem=ser_alumno.getNotaXAlumnos(idalumno, idclase);
		return new ResponseEntity<Nota>(tem, HttpStatus.OK);
	}
}
