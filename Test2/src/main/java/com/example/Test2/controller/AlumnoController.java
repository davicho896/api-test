package com.example.Test2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Test2.modelo.Alumno;
import com.example.Test2.service.AlumnoService;



@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {
	
	@Autowired
    AlumnoService personaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Alumno>> listarProductos() {
        return new ResponseEntity<>(personaService.findByAll(), 
                HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Alumno> crearProducto(
            @RequestBody Alumno p) {
        return new ResponseEntity<>(personaService.save(p), 
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Alumno> actualizarProducto(@PathVariable Long id, @RequestBody Alumno p) {
    	Alumno personaENcontrada = personaService.findById(id);
        if (personaENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                personaENcontrada.setNombre(p.getNombre());
                personaENcontrada.setApellido(p.getApellido());
                personaENcontrada.setDireccion(p.getDireccion());
                return new ResponseEntity<>(personaService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Alumno> eliminarProducto(@PathVariable Long id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
