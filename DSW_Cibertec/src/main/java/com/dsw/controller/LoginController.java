package com.dsw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dsw.entidad.Usuario;
import com.dsw.service.UsuarioServicio;

@Controller
public class LoginController {

	@Autowired
	private UsuarioServicio ser_usuario;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/enviarlogin")
	public String enviarlogin(Usuario u,HttpSession session) {
		Usuario obj = ser_usuario.login(u);
		if(obj == null) {
			session.setAttribute("mensaje", "El usuario no existe");
			return "redirect:login";	
		}
		else {
			if(obj.getCredencial()==1) {return "redirect:administrador/verIndexAdmin";}
			else if(obj.getCredencial()==2) {return "redirect:docente/verIndexDocente";}
			else {return "redirect:docente/verIndexAlumno";}
		}
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.invalidate();
		response.setHeader("Cache-control", "no-cache");
		response.setHeader("Expires", "0");
		response.setHeader("Pragma", "no-cache");
		request.setAttribute("mensaje", "El usuario salió de sesión");
		return "login";
	}
}
