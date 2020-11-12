package com.dsw.service;

import java.util.List;

import com.dsw.entidad.Usuario;

public interface UsuarioServicio {

	public abstract Usuario login(Usuario bean);
	
	public abstract Usuario getLastIdUsuario();
	
}
