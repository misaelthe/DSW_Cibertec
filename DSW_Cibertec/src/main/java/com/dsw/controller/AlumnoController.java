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
public class AlumnoController {

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
		return "crudAlumno";
	}
	/*FIN METODOS DEL CRUD ALUMNO*/

	/*@RequestMapping(value = "/transferirDinero",method = RequestMethod.POST)
	}*/


}
