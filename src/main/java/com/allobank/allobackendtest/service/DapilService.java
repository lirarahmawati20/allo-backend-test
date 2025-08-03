package com.allobank.allobackendtest.service;

import com.allobank.allobackendtest.dto.DapilDTO;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

public interface DapilService {

    DapilDTO getDapilById(UUID id);

    List<DapilDTO> getDapilWithFilters(
        String namaDapil,
        String provinsi,
        Integer jumlahKursi,
        String sortBy,
        Sort.Direction sortDirection
    );
}
