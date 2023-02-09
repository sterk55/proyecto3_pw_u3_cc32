package com.uce.edu.pw.proyecto3_pw_u3_cc3.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.pw.proyecto3_pw_u3_cc3.modelo.Estudiante;
import com.uce.edu.pw.proyecto3_pw_u3_cc3.service.iEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

    @Autowired
    private iEstudianteService estudianteService;

    @PostMapping
    public void registrar(Estudiante estudiante) {
        this.estudianteService.registrar(estudiante);
    }

    @PutMapping(path = "/{id}")
    public void actualizar(@PathVariable("id") Integer id, @RequestBody Estudiante estudiante) {
        estudiante.setId(id);
        this.estudianteService.actualizar(estudiante);

    }

    @GetMapping(path = "/buscar/{id}")
    public Estudiante encontrar(@PathVariable("id") Integer id) {

        return this.estudianteService.encontrar(id);
    }

    @GetMapping(path = "/buscar")
    public List<Estudiante> buscarTodos() {

        return this.estudianteService.buscarTodos();
    }

    @DeleteMapping(path = "/{id}")
    public void borrar(Integer id) {
        this.estudianteService.borrar(id);

    }

    @DeleteMapping(path = "/borrar/{id}")
    public void borrarTemp(@PathVariable("id") Integer id) {
        this.estudianteService.borrar(id);

    }

    @GetMapping(path = "/salario")
    public Estudiante buscarSalario(@RequestParam("salario") BigDecimal salario) {
        return this.estudianteService.buscarSalario(salario);
    }

}