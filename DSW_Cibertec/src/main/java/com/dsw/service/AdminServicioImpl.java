package com.dsw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dsw.entidad.Constancia;
import com.dsw.entidad.Matricula;
import com.dsw.repository.ConstanciaRepositorio;
import com.dsw.repository.MatriculaRepositorio;

@Service
public class AdminServicioImpl implements AdminServicio{

	@Autowired
	private MatriculaRepositorio repMatricula;
	@Autowired
	private ConstanciaRepositorio repConstancia;
	
	@Override
	public void insertMatricula(Matricula matricula) {repMatricula.save(matricula);}
	@Override
	public void insertConstancia(Constancia constancia) {repConstancia.save(constancia);}
}
