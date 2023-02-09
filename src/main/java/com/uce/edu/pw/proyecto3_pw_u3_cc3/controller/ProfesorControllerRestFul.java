package com.uce.edu.pw.proyecto3_pw_u3_cc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.pw.proyecto3_pw_u3_cc3.modelo.Profesor;
import com.uce.edu.pw.proyecto3_pw_u3_cc3.service.iProfesorService;

@RestController
@RequestMapping("/profesores")
public class ProfesorControllerRestFul {
    @Autowired
    private iProfesorService profesorServi;

    @GetMapping(path = "/{id}")
	public Profesor encontrar(@PathVariable("id") Integer id) {
        return this.profesorServi.encontrar(id);
    }

    @GetMapping(path = "/cedula/{cedula}")
    public Profesor encontrarPorCedula(@PathVariable("cedula") String cedula) {
        return this.profesorServi.encontrarPorCedula(cedula);
    }

    @DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable("id") Integer id) {
        this.profesorServi.borrar(id);
    }

    @PostMapping
    public void registrar(@RequestBody Profesor profesor) {
		// TODO Auto-generated method stub
		this.profesorServi.registrar(profesor);
	}

    @PutMapping(path = "/{id}")
    public void actualizar(@PathVariable("id") Integer id , @RequestBody Profesor profesor) {
		// TODO Auto-generated method stub
		this.profesorServi.actualizar(profesor);
	}
}