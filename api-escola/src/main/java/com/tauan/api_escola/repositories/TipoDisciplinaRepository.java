package com.tauan.api_escola.repositories;

import com.tauan.api_escola.models.TipoDisciplinaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDisciplinaRepository extends JpaRepository<TipoDisciplinaModel, Long> {
}
