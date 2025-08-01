package com.allobank.allobackendtest.service;

import com.allobank.allobackendtest.dto.PartaiDTO;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

public interface PartaiService {

    PartaiDTO getPartaiById(UUID id);

    List<PartaiDTO> getPartaiWithFilters(
        UUID id,
        String namaPartai,
        Integer nomorUrut,
        String sortBy,
        Sort.Direction sortDirection
    );
}
