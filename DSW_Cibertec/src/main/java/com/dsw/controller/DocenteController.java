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
import com.dsw.entidad.Nota;
import com.dsw.entidad.Usuario;
import com.dsw.service.AlumnoServicio;
import com.dsw.service.UsuarioServicio;

@Controller
public class DocenteController {

	@Autowired
	private AlumnoServicio ser_alumno;
	@Autowired
	private UsuarioServicio ser_usuario;


	@RequestMapping(value="/getAlumnosDocenteCurso",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Alumno>> getAlumnosNoMatriculados() {
		List<Alumno> tem=ser_alumno.getAlumnosNoMatriculados();
		return new ResponseEntity<>(tem, HttpStatus.OK);
	}
	
	@RequestMapping("/interfazNotas")
	public String interfazNotas() {	
		return "registrarNota";
	}
	@RequestMapping(value="/getNotaAlumno",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<Nota> getNotaAlumno(HttpServletRequest request) {
		Integer idalumno=(Integer)request.getSession().getAttribute("idalumno");
		Integer idclase=(Integer)request.getSession().getAttribute("idclase");
		Nota tem=ser_alumno.getNotaXAlumnos(idalumno, idclase);
		return new ResponseEntity<Nota>(tem, HttpStatus.OK);
	}
	
	@RequestMapping("/salidaAlumno")
	public String salidaCrudAlumno(HttpSession session) {
		return "crudAlumno";
	}


}
