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
import com.dsw.entidad.Nota;
import com.dsw.entidad.Usuario;
import com.dsw.service.AlumnoServicio;
import com.dsw.service.UsuarioServicio;

@Controller
@RequestMapping(value = "/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoServicio ser_alumno;

	@RequestMapping("/verIndexAlumno")
	public String verIndexAlumno() {
		return "alumno/indexAlumno";
	}
	
	@RequestMapping(value="/verClasesDictadasPage")
	public String verClasesDictadasPage(HttpSession session) {
		return "alumno/pageClasesDictadas";
	}
	
	@RequestMapping(value="/getClasesAlumno",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Clase>> getClasesAlumno(HttpSession session) {
		Usuario u=(Usuario)session.getAttribute("objUsuario");
		Alumno a=ser_alumno.getAlumnoXUsuario(u.getIdusuario());
		List<Clase> tem=ser_alumno.getClasesXAlumnos(a.getIdalumno());
		return new ResponseEntity<>(tem, HttpStatus.OK);
	}
	
	@RequestMapping(value="/verNotasObtenidasPage")
	public String getNotasAlumno(String idclase,HttpSession session) {
		session.setAttribute("claseSeleccionada",idclase);
		return "alumno/indexAlumno";
	}
	
	@RequestMapping(value="/getNotasAlumno",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<Nota> getNotasAlumno(HttpSession session) {
		Integer idclase=(Integer)session.getAttribute("claseSeleccionada");
		Usuario u=(Usuario)session.getAttribute("objUsuario");
		Alumno a=ser_alumno.getAlumnoXUsuario(u.getIdusuario());
		Nota nota=ser_alumno.getNotaXAlumnos(a.getIdalumno(),idclase);
		return new ResponseEntity<>(nota, HttpStatus.OK);
	}
}
