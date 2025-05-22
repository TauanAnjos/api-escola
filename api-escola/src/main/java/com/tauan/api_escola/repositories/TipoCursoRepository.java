package com.tauan.api_escola.repositories;

import com.tauan.api_escola.models.TipoCursoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCursoRepository extends JpaRepository<TipoCursoModel, Long> {
}
