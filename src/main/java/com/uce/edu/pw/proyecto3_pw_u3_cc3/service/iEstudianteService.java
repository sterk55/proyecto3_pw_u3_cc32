package com.uce.edu.pw.proyecto3_pw_u3_cc3.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.pw.proyecto3_pw_u3_cc3.modelo.Estudiante;

public interface iEstudianteService {
    public void registrar(Estudiante estudiante);

    public void actualizar(Estudiante estudiante);

    public Estudiante encontrar(Integer id);

    public List<Estudiante> buscarTodos();

    public Estudiante buscarSalario(BigDecimal salario);

    public void borrar(Integer id);
}
