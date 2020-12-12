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
	private DocenteServicio ser_docente;

	@RequestMapping("/verIndexDocente")
	public String verIndexDocente() {
		return "docente/indexDocente";
	}

	@RequestMapping("/verPageListarClase")
	public String verPageListarClase() {
		return "docente/pageListarClase";
	}

	@RequestMapping("/verPageListarAlumnos")
	public String verPageListarAlumnos(String idclase, HttpSession session) {
		session.setAttribute("claseSeleccionada", idclase);
		return "docente/pageListarAlumnos";
	}

	@RequestMapping("/verPageRegistrarNotas")
	public String verPageRegistrarNotas(String idalumno, HttpSession session) {
		session.setAttribute("alumnoSeleccionado", idalumno);
		return "docente/pageRegistrarNotas";
	}

	@RequestMapping("/registrarNotas")
	public String registrarNotas(Integer inTeo1, Integer inTeo2, Integer inPar, Integer inTeo3, Integer inFin,
			HttpSession session) {
		Integer idclase = Integer.parseInt((String) session.getAttribute("claseSeleccionada"));
		Integer idalumno = Integer.parseInt((String) session.getAttribute("alumnoSeleccionado"));
		Nota nota = ser_alumno.getNotaXAlumnoXClase(idalumno, idclase);
		nota.setE1(inTeo1);
		nota.setE2(inTeo2);
		nota.setEp(inPar);
		nota.setE3(inTeo3);
		nota.setEf(inFin);
		Integer no1 = (int) Math.ceil((inTeo1 + inTeo2 + inTeo3) * 45 / 300);
		Integer no2 = (int) Math.ceil((inPar) * 20 / 100);
		Integer no3 = (int) Math.ceil((inFin) * 25 / 100);
		Integer prom = no1 + no2 + no3;
		System.out.println(
				prom.toString() + "-------------------------------------------------------------------------------"
						+ no1 + "-" + no2 + "-" + no3);
		nota.setPromedio(prom);
		ser_alumno.insertNota(nota);
		return "docente/indexDocente";
	}

	@RequestMapping(value = "/getClasesXDocente", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Clase>> getClasesXDocente(HttpSession session) {
		Usuario u = (Usuario) session.getAttribute("objUsuario");
		Docente d = ser_docente.getDocenteXIdusuario(u.getIdusuario());
		List<Clase> tem = ser_docente.getClaseXDocente(d.getIddocente());
		return new ResponseEntity<>(tem, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAlumnosXClase", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<Alumno>> getAlumnosDocenteCurso(HttpSession session) {
		Integer idclase = Integer.parseInt((String) session.getAttribute("claseSeleccionada"));
		List<Alumno> tem = ser_alumno.getAlumnosXClase(idclase);
		return new ResponseEntity<>(tem, HttpStatus.OK);
	}

	@RequestMapping(value = "/getNotaXAlumnoXClase", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Nota> getNotaXAlumnoXClase(HttpSession session) {
		Integer idalumno = Integer.parseInt((String) session.getAttribute("alumnoSeleccionado"));
		Integer idclase = Integer.parseInt((String) session.getAttribute("claseSeleccionada"));
		Nota tem = ser_alumno.getNotaXAlumnoXClase(idalumno, idclase);
		return new ResponseEntity<Nota>(tem, HttpStatus.OK);
	}
}
