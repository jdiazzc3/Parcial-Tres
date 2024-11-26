package com.co.diaz.libreria.controller;

import com.co.diaz.libreria.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class CommonController<E, S extends CommonService<E>> {

    @Autowired
    protected S service;

    @Value("${config.balanceador.test}")
    protected String balanceadorTest;

    @GetMapping("/balanceador-test")
    public ResponseEntity<?> balanceadorTest() {
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("balanceador", balanceadorTest);
        response.put("alumnos", service.findAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarAlumnos() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {
        Optional<E> ob = service.findById(id);
        if (ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(ob.get());
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody E entity){
        E alumnoDb = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
