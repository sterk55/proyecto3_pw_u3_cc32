package com.uce.edu.pw.proyecto3_pw_u3_cc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.pw.proyecto3_pw_u3_cc3.modelo.Estudiante;
import com.uce.edu.pw.proyecto3_pw_u3_cc3.service.iEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

    @Autowired
    private iEstudianteService estudianteService;

    public void registrar(Estudiante estudiante) {
    }

    public void actualizar(Estudiante estudiante) {

    }

    @GetMapping(path = "/buscar/{id}")
    public Estudiante encontrar(@PathVariable("id") Integer id) {

        return this.estudianteService.encontrar(id);
    }

    public void borrar(Integer id) {

    }
}