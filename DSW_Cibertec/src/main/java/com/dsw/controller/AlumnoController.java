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
import com.dsw.entidad.Curso;
import com.dsw.entidad.Docente;
import com.dsw.entidad.Nota;
import com.dsw.entidad.Seccion;
import com.dsw.entidad.Usuario;
import com.dsw.service.AlumnoServicio;
import com.dsw.service.UsuarioServicio;

@Controller
@RequestMapping(value = "/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoServicio serAlumno;

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
		Alumno a=serAlumno.getAlumnoXUsuario(u.getIdusuario());
		List<Clase> tem=serAlumno.getClasesXAlumnos(a.getIdalumno());
		return new ResponseEntity<>(tem, HttpStatus.OK);
	}
	
	@RequestMapping(value="/verNotasObtenidasPage")
	public String getNotasAlumno(Integer idclase,HttpSession session) {
		session.setAttribute("claseSeleccionada",idclase);
		return "alumno/pageNotasObtenidas";
	}
	
	@RequestMapping(value="/getNotasAlumno",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<Nota> getNotasAlumno(HttpSession session) {
		Integer idclase=(Integer)session.getAttribute("claseSeleccionada");
		Usuario u=(Usuario)session.getAttribute("objUsuario");
		Alumno a=serAlumno.getAlumnoXUsuario(u.getIdusuario());
		Nota nota=serAlumno.getNotaXAlumnoXClase(a.getIdalumno(),idclase);
		return new ResponseEntity<>(nota, HttpStatus.OK);
	}
	//MATRICULA DE CURSO
	@RequestMapping("/verMatriculaXCursos")
	public String verMatriculaXCursos() {
		return "alumno/matriculaXCursos";
	}
	@RequestMapping(value="/buscarClases",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Clase>> buscarClases(HttpSession session) {
		Usuario u=(Usuario)session.getAttribute("objUsuario");
		List<Clase> data=serAlumno.getClasesXUsuario(u.getIdusuario());
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	@RequestMapping(value="/buscarClaseXidclase",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public ResponseEntity<Clase> buscarClaseXidclase(Integer idclase,HttpSession session) {
		Clase data=serAlumno.getClaseBy(idclase);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	/*@RequestMapping("/salidaClase")
	public String salidaClase(HttpSession session) {
		List<Clase> data=serAdmin.getAllClase();
		session.setAttribute("clases", data);
		return "admin/crudClase";
	}	
	@RequestMapping("/registrarClase")
	public String registrarClase(Integer idseccion,Integer idcurso,Integer iddocente,Integer ins,HttpSession session) {	
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
		cla.setAlum_ins(ins);
		serAdmin.insertClase(cla);
		return "redirect:salidaClase";
	}
	@RequestMapping("/eliminarClase")
	public String eliminarClase(Integer idclase,HttpSession session) {
		serAdmin.deleteClase(idclase);
		return "redirect:salidaClase";
	}*/
}
