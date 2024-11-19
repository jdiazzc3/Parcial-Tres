package com.co.diaz.curso.controller;

import com.co.diaz.commonservice.models.entity.Alumno;
import com.co.diaz.curso.models.entity.Curso;
import com.co.diaz.curso.services.CursoService;
import com.co.diaz.libreria.controller.CommonController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {

    @Value("${config.balanceador.test}")
    private String balanceadorTest;

    @GetMapping("/balanceador-test")
    public ResponseEntity<?> balanceadorTest() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>editar(@RequestBody Curso curso, @PathVariable Long id) {
        Optional<Curso> ob = service.findById(id);
        if (ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Curso cursoDb = ob.get();
        cursoDb.setNombre(curso.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
    }

    @PutMapping("/{id}/asignar-alumnos")
    public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumno, @PathVariable Long id) {
        Optional<Curso> ob = service.findById(id);
        if (ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Curso cursoDb = ob.get();
        alumno.forEach(cursoDb::addAlumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
    }

    @PutMapping("/{id}/eliminar-alumno")
    public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id) {
        Optional<Curso> ob = service.findById(id);
        if (ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Curso cursoDb = ob.get();
        cursoDb.removeAlumno(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
    }
}
