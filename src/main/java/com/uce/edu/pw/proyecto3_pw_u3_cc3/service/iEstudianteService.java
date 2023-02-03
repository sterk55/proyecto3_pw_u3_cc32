package com.uce.edu.pw.proyecto3_pw_u3_cc3.service;

import com.uce.edu.pw.proyecto3_pw_u3_cc3.modelo.Estudiante;

public interface iEstudianteService {
    public void registrar(Estudiante estudiante);

    public void actualizar(Estudiante estudiante);

    public Estudiante encontrar(Integer id);

    public void borrar(Integer id);
}
