package com.co.diaz.curso.services;

import com.co.diaz.commonservice.models.entity.Curso;
import com.co.diaz.curso.repository.CursoRepository;
import com.co.diaz.libreria.service.CommonService;
import com.co.diaz.libreria.service.CommonServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CommonService<Curso> {

}
