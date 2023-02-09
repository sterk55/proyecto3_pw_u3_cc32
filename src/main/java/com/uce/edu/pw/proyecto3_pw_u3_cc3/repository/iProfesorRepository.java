package com.uce.edu.pw.proyecto3_pw_u3_cc3.repository;

import com.uce.edu.pw.proyecto3_pw_u3_cc3.modelo.Profesor;

public interface iProfesorRepository {
    void insertarProfesor(Profesor profesor);
	void actualizarProfesor(Profesor profesor);
	Profesor consultarProfesor(Integer id);
	void eliminarProfesor(Integer id);

    Profesor consultaProfesorPorCedula(String cedula);
}
