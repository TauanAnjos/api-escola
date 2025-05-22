package com.tauan.api_escola.repositories;

import com.tauan.api_escola.models.InstituicaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoRepository extends JpaRepository<InstituicaoModel, Long> {
}
