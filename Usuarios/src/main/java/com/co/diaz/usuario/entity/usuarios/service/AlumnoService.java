package com.co.diaz.usuario.entity.usuarios.service;

import com.co.diaz.libreria.service.CommonService;
import com.co.diaz.commonservice.models.entity.Alumno;

import java.util.Optional;

public interface AlumnoService extends CommonService<Alumno> {
    public Alumno save(Alumno alumno);
    public void deleteById(Long id);
}
