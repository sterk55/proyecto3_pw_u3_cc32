package com.uce.edu.pw.proyecto3_pw_u3_cc3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

//    @GetMapping(path = "/{id}")
//	public Profesor encontrar(@PathVariable("id") Integer id) {
//        return this.profesorServi.encontrar(id);
//    }
//
//    @GetMapping(path = "/cedula/{cedula}")
//    public Profesor encontrarPorCedula(@PathVariable("cedula") String cedula) {
//        return this.profesorServi.encontrarPorCedula(cedula);
//    }
//
//    @DeleteMapping(path = "/{id}")
//	public void borrar(@PathVariable("id") Integer id) {
//        this.profesorServi.borrar(id);
//    }

    // Capacidad que reciba un Media Type application/json 
    @PutMapping(path = "/recibir/json", consumes = (MediaType.APPLICATION_JSON_VALUE)) 
    public void putMediaTypeJson(@RequestBody Profesor profesor){
        this.profesorServi.registrar(profesor);
    }
    // Capacidad de retorne un Media Type application/json 
    @GetMapping(path = "/publicar/json/{id}", produces = (MediaType.APPLICATION_JSON_VALUE)) 
    public ResponseEntity<Profesor> getMediaTypeJson(@PathVariable("id") Integer id){
        Profesor profesor = this.profesorServi.encontrar(id);
        return ResponseEntity.status(HttpStatus.OK).body(profesor);
    }
    // Capacidad que reciba un Media Type application/xml 
    @PutMapping(path = "/recibir/xml", consumes = (MediaType.APPLICATION_XML_VALUE)) 
    public void putMediaTypeXml(@RequestBody Profesor profesor){
        this.profesorServi.registrar(profesor);
    }
    // Capacidad de retorne un Media Type application/xml 
    @GetMapping(path = "/publicar/xml/{id}", produces = (MediaType.APPLICATION_XML_VALUE)) 
    public ResponseEntity<Profesor> getMediaTypeXlm(@PathVariable("id") Integer id){
        Profesor profesor = this.profesorServi.encontrar(id);
        return ResponseEntity.status(HttpStatus.OK).body(profesor);
    }
    // Capacidad que reciba y retorne un Media Type application/json 
    @PostMapping(path = "/recibir/publicar/json/{id}", consumes = (MediaType.APPLICATION_JSON_VALUE), produces = (MediaType.APPLICATION_JSON_VALUE)) 
    public ResponseEntity<Profesor> putAndGetMediaTypeJson(@PathVariable("id") Integer id , @RequestBody Profesor profesor) {
		profesor.setId(id);
		this.profesorServi.actualizar(profesor);
		Profesor prof = this.profesorServi.encontrar(id);
		return ResponseEntity.status(HttpStatus.OK).body(prof); 
	}
    // Capacidad que reciba y retorne un Media Type application/xml 
    @PostMapping(path = "/recibir/publicar/xml/{id}", consumes = (MediaType.APPLICATION_XML_VALUE), produces = (MediaType.APPLICATION_XML_VALUE)) 
    public ResponseEntity<Profesor> putAndGetMediaTypeXml(@PathVariable("id") Integer id , @RequestBody Profesor profesor) {
		profesor.setId(id);
		this.profesorServi.actualizar(profesor);
		Profesor prof = this.profesorServi.encontrar(id);
		return ResponseEntity.status(HttpStatus.OK).body(prof); 
	}
}
