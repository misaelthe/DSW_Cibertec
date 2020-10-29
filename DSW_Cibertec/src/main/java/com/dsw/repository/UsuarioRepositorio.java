package com.dsw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dsw.entidad.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{

	@Query("Select x from Usuario x where x.usuario = :#{#usu.usuario}")
	public abstract Usuario login(@Param(value = "usu") Usuario usu);
}
