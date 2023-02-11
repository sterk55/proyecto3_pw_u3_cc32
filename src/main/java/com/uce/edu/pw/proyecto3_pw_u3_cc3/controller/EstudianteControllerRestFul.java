package com.uce.edu.pw.proyecto3_pw_u3_cc3.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    public void registrar(@RequestBody Estudiante estudiante) {
        this.estudianteService.registrar(estudiante);
    }

    @GetMapping(path = "/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Estudiante> encontrarR(@PathVariable("id") Integer id) {
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("detalleMensaje", "Estudiante econtrado correctamente");

        Estudiante est = this.estudianteService.encontrar(id);

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(est);
    }

    @PutMapping(path = "/{id}", consumes = (MediaType.APPLICATION_JSON_VALUE), produces = (MediaType.APPLICATION_XML_VALUE))
    public ResponseEntity<Estudiante> actualizar(@PathVariable("id") Integer id, @RequestBody Estudiante estudiante) {
        estudiante.setId(id);
        this.estudianteService.actualizar(estudiante);
        Estudiante est = this.estudianteService.encontrar(id);
        return ResponseEntity.status(HttpStatus.OK).body(est);

    }

    @GetMapping(path = "/buscar/{id}", produces = (MediaType.APPLICATION_XML_VALUE))
    public Estudiante encontrar(@PathVariable("id") Integer id) {

        return this.estudianteService.encontrar(id);
    }

    @GetMapping(path = "/buscar")
    public ResponseEntity<List<Estudiante>> buscarTodos() {
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("detalleMensaje", "Estudiante econtrado correctamente");
        cabeceras.add("ValoraCalculado", "100");
        List<Estudiante> est = this.estudianteService.buscarTodos();
        return new ResponseEntity<>(est, cabeceras, 230);
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