package com.co.diaz.usuario.entity.usuarios.controller;

import com.co.diaz.usuario.entity.usuarios.entity.Alumno;
import com.co.diaz.usuario.entity.usuarios.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController {
    @Autowired
    AlumnoService service;

    @GetMapping
    public ResponseEntity<?> listarAlumnos() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/")
    public ResponseEntity<?> ver(@PathVariable Long id) {
        Optional<Alumno> ob = service.findById(id);
        if (ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(ob.get());
   }

   @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno){
        Alumno alumnoDb = service.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
   }

   @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id) {
        Optional<Alumno> ob = service.findById(id);
        if (ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Alumno alumnoDb = ob.get();
        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setEmail(alumno.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
   }

    @DeleteMapping("/{id}")
     public ResponseEntity<?> eliminar(@PathVariable Long id) {
          service.deleteById(id);
          return ResponseEntity.noContent().build();
    }
}
