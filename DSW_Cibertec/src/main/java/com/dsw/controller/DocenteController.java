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
import com.dsw.entidad.Usuario;
import com.dsw.service.AlumnoServicio;
import com.dsw.service.UsuarioServicio;

@Controller
public class DocenteController {

	@Autowired
	private AlumnoServicio ser_alumno;
	@Autowired
	private UsuarioServicio ser_usuario;

	/*METODOS DEL CRUD ALUMNO*/
	@RequestMapping("/verCrudAlumno")
	public String verCrudAlumno() {
		return "crudAlumno";
	}
	@RequestMapping("/filtrarAlumno")
	public String filtrarAlumno(String nom_alumno,HttpSession session) {
		List<Alumno> data=ser_alumno.filtrarAlumnoPorNombre(nom_alumno+"%");
		session.setAttribute("alumnos", data);
		return "crudAlumno";
	}
	@RequestMapping(value="/getAlumnosDocenteCurso",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Alumno>> getAlumnosNoMatriculados() {
		List<Alumno> tem=ser_alumno.getAlumnosNoMatriculados();
		return new ResponseEntity<>(tem, HttpStatus.OK);
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
		return "crudAlumno";
	}


}
