package com.tauan.api_escola.repositories;

import com.tauan.api_escola.models.TituloModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TituloRepository extends JpaRepository<TituloModel, Long> {
}
