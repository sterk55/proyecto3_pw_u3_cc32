package com.uce.edu.pw.proyecto3_pw_u3_cc3.repository;

import com.uce.edu.pw.proyecto3_pw_u3_cc3.modelo.Estudiante;

public interface iEstudianteRepository {
    public void insertar(Estudiante estudiante);

    public void actualizar(Estudiante estudiante);

    public Estudiante buscar(Integer id);

    public void eliminar(Integer id);
}
