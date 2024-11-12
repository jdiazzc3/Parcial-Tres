package com.co.diaz.libreria.service;

import com.co.diaz.usuario.entity.usuarios.entity.Alumno;
import com.co.diaz.usuario.entity.usuarios.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class CommonServiceImpl<E, R extends CrudRepository<E, Long>> implements CommonService{

    @Autowired
    private R dao;

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional
    public E save(E entity) {
        return dao.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        dao.deleteById(id);
    }
}