package com.co.diaz.microserviciocurso.services;

import com.co.diaz.libreria.service.CommonService;
import com.co.diaz.libreria.service.CommonServiceImpl;
import com.co.diaz.commonservice.models.entity.Curso;
import com.co.diaz.microserviciocurso.repository.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

}
