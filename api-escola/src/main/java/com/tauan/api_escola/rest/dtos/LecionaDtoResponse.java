package com.tauan.api_escola.rest.dtos;

import com.tauan.api_escola.models.LecionaModel;
import com.tauan.api_escola.models.LecionaModel.LecionaId;
import java.time.LocalDate;

public record LecionaDtoResponse(
        LecionaId id
) {}
