package com.dsw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	/*@Autowired
	private UsuarioServicio servicio;*/
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
	/*@RequestMapping(value = "/transferirDinero",method = RequestMethod.POST)
	}*/


}
