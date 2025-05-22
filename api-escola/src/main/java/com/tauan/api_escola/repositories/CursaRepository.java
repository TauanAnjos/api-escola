package com.tauan.api_escola.repositories;

import com.tauan.api_escola.models.CursaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursaRepository extends JpaRepository<CursaModel, CursaModel.CursaId> {
}
