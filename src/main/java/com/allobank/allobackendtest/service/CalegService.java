package com.allobank.allobackendtest.service;

import com.allobank.allobackendtest.dto.CalegDTO;
import com.allobank.allobackendtest.model.JenisKelamin;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

public interface CalegService {

    CalegDTO getCalegById(UUID id);

    List<CalegDTO> getCalegWithFilters(
        UUID dapilId,
        UUID partaiId,
        String nama,
        JenisKelamin jenisKelamin,
        Integer nomorUrut,
        String sortBy,
        Sort.Direction sortDirection
    );
}
