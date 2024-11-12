package com.co.diaz.libreria.service;

import com.co.diaz.usuario.entity.usuarios.entity.Alumno;

import java.util.Optional;

public interface CommonService<E> {
    public Iterable<E> findAll();
    public Optional<E> findById(Long id);
    public E save(E alumno);
    public void deleteById(Long id);
}
