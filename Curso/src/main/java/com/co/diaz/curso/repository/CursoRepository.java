package com.co.diaz.curso.repository;

import com.co.diaz.commonservice.models.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {
}
