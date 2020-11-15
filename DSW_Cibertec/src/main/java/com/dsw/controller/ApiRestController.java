package com.dsw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Alumno_Clase;
import com.dsw.entidad.Clase;
import com.dsw.entidad.Curso;
import com.dsw.entidad.Docente;
import com.dsw.entidad.Nota;
import com.dsw.entidad.Usuario;
import com.dsw.service.AlumnoServicio;
import com.dsw.service.DocenteServicio;
import com.dsw.service.RestServicio;
import com.dsw.service.UsuarioServicio;

@RestController
@RequestMapping(value = "/rest")
public class ApiRestController {


	/////////////////////////////////////////////////////////
	@Autowired
	private RestServicio restService;
	
	@GetMapping(path = "/getUsuario",produces = "application/json")
	@ResponseBody
	public Usuario getUsuario(@RequestParam("usuario") String usuario,@RequestParam("password") String password){
		return restService.getUsuario(usuario, password);
	}
	
	@GetMapping(path = "/getAlumno",produces = "application/json")
	@ResponseBody
	public Alumno getAlumno(@RequestParam("idusuario") Integer idusuario){
		return restService.getAlumno(idusuario);
	}	
	@GetMapping(path = "/getClaseXAlumno",produces = "application/json")
	@ResponseBody
	public List<Clase> getClaseXAlumno(@RequestParam("idalumno") Integer idalumno){
		return restService.getClaseXAlumno(idalumno);
	}	
	@GetMapping(path = "/getCursoXAlumno",produces = "application/json")
	@ResponseBody
	public List<Curso> getCursoXAlumno(@RequestParam("idalumno") Integer idalumno){
		return restService.getCursoXAlumno(idalumno);
	}
	@GetMapping(path = "/getAlumnoClaseXAlumno",produces = "application/json")
	@ResponseBody
	public List<Alumno_Clase> getAlumnoClase(@RequestParam("idalumno") Integer idalumno){
		return restService.getAlumno_Clase(idalumno);
	}
	///////////////////////////////METODOS DEL DOCENTE
	@GetMapping(path = "/getDocente",produces = "application/json")
	@ResponseBody
	public Docente getDocente(@RequestParam("idusuario") Integer idusuario){
		return restService.getDocente(idusuario);
	}	
	@GetMapping(path = "/getClaseXDocente",produces = "application/json")
	@ResponseBody
	public List<Clase> getClaseXDocente(@RequestParam("iddocente") Integer iddocente){
		return restService.getClaseXDocente(iddocente);
	}
	
	@GetMapping(path = "/getCursoXDocente",produces = "application/json")
	@ResponseBody
	public List<Curso> getCursoXDocente(@RequestParam("iddocente") Integer iddocente){
		return restService.getCursoXDocente(iddocente);
	}
	@GetMapping(path = "/getAlumnoClaseXClase",produces = "application/json")
	@ResponseBody
	public List<Alumno_Clase> getAlumnoClaseXClase(@RequestParam("idclase") Integer idclase){
		return restService.getAlumnoClaseXClase(idclase);
	}
	@GetMapping(path = "/getAlumnosXClase",produces = "application/json")
	@ResponseBody
	public List<Alumno> getAlumnosXClase(@RequestParam("idclase") Integer idclase){
		return restService.getAlumnosXClase(idclase);
	}
	///////////////////////////////METODOS EN COMUN
	
	@GetMapping(path = "/getNotaXClaseXAlumno",produces = "application/json")
	@ResponseBody
	public Nota getNotaXClaseXAlumno(@RequestParam("idclase") Integer idclase,@RequestParam("idalumno") Integer idalumno){
		return restService.getNotaXClaseXAlumno(idclase,idalumno);
	}
		
}
