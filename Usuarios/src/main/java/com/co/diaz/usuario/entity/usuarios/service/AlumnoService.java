package com.co.diaz.usuario.entity.usuarios.service;

import com.co.diaz.usuario.entity.usuarios.entity.Alumno;

import java.util.Optional;

public interface AlumnoService {
    public Iterable<Alumno> findAll();
    public Optional<Alumno> findById(Long id);
    public Alumno save(Alumno alumno);
    public void deleteById(Long id);
}
