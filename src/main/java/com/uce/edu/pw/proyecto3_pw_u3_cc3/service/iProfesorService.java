package com.uce.edu.pw.proyecto3_pw_u3_cc3.service;

import com.uce.edu.pw.proyecto3_pw_u3_cc3.modelo.Profesor;

public interface iProfesorService {
    void registrar(Profesor profesor);
	void actualizar(Profesor profesor);
	Profesor encontrar(Integer id);
	void borrar(Integer id);

    Profesor encontrarPorCedula(String cedula);
}
