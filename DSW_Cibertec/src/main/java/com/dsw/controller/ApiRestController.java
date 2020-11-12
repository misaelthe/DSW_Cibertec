package com.dsw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsw.entidad.Usuario;
import com.dsw.service.AlumnoServicio;
import com.dsw.service.DocenteServicio;
import com.dsw.service.UsuarioServicio;

@RestController
@RequestMapping(value = "/rest")
public class ApiRestController {
	
	@Autowired
	private UsuarioServicio usuarioService;
	@Autowired
	private AlumnoServicio alumnoService;
	@Autowired
	private DocenteServicio docenteService;
	
	
	
	@GetMapping(path = "/getUsuario",produces = "application/json")
	@ResponseBody
	public Usuario getUsuario(@RequestParam("usuario") String usuario,@RequestParam("contraseña") String contraseña){
		return usuarioService.getUsuario(usuario, contraseña);
	}
	
	/*@GetMapping(path = "/getAlumno",produces = "application/json")
	@ResponseBody
	public Usuario getAlumno(@RequestParam("idalumno") Integer idalumno){
		return usuarioService.getUsuario(usuario, contraseña);
	}*/
	
	/*@GetMapping(path = "/getDocente",produces = "application/json")
	@ResponseBody
	public Usuario getDocente(@RequestParam("iddocente") Integer iddocente){
		return usuarioService.getUsuario(usuario, contraseña);
	}*/
}
