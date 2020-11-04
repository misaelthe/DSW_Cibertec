package com.dsw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsw.entidad.Usuario;
import com.dsw.repository.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

	@Autowired
	private UsuarioRepositorio repositorio;
	
	@Override
	public Usuario login(Usuario bean) {return repositorio.login(bean);}

	@Override
	public Usuario getLastIdUsuario() {return repositorio.getLastIdUsuario();}

}
