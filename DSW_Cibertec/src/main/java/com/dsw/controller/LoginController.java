package com.dsw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsw.entidad.Alumno;
import com.dsw.entidad.Usuario;
import com.dsw.service.AlumnoServicio;
import com.dsw.service.UsuarioServicio;

@Controller
public class LoginController {

	@Autowired
	private AlumnoServicio ser_alumno;
	@Autowired
	private UsuarioServicio ser_usuario;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/enviarlogin")
	public String enviarlogin(Usuario u,HttpServletRequest request) {
		Usuario obj = ser_usuario.login(u);
		if(obj == null) {
			request.setAttribute("mensaje", "El usuario no existe");
			return "redirect:login";	
		}
		else {
			//evalua segun las credenciales,
			//if obj.credencial=1 entonces lo redirijes a la pagina del administrador q esta en la carpeta admin
			//if obj.credencial=2 entonces lo redirijes a la pagina del docente
			//if obj.credencial=3 entonces lo redirijes a la pagina del alumno
			//las paginas de cada uno estan en las carpetas respectivas
			return "redirect:home";
		}
	}
	@RequestMapping("/verIndex")
	public String verIndex() {
		/*List<Pais> tem= pa_serv.listarTodosPaises();
		model.addAttribute("objPais", tem);*/
		return "index";
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
