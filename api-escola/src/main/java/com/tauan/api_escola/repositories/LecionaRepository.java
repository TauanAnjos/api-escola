package com.tauan.api_escola.repositories;

import com.tauan.api_escola.models.LecionaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecionaRepository extends JpaRepository<LecionaModel, LecionaModel.LecionaId> {
}
