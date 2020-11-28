package com.dsw.service;

import com.dsw.entidad.Constancia;
import com.dsw.entidad.Matricula;

public interface AdminServicio {

	public abstract void insertMatricula(Matricula matricula);
	public abstract void insertConstancia(Constancia constancia);
}
