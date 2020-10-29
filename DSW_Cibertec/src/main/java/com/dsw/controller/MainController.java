package com.dsw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsw.entidad.Alumno;
import com.dsw.service.AlumnoServicio;

@Controller
public class MainController {

	@Autowired
	private AlumnoServicio ser_alumno;
	
	@RequestMapping("/verloginUsuario")
	public String login() {
		return "loginUsuario";
	}
	@RequestMapping("/enviarloginUsuario")
	public String enviarlogin() {
		return "loginUsuario";
	}
	@RequestMapping("/verIndex")
	public String verIndex() {
		/*List<Pais> tem= pa_serv.listarTodosPaises();
		model.addAttribute("objPais", tem);*/
		return "index";
	}
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
	@RequestMapping("/salida")
	public String listarTodos(HttpSession session) {
		return "crudAlumno";
	}
	/*@RequestMapping(value = "/transferirDinero",method = RequestMethod.POST)
	}*/


}
