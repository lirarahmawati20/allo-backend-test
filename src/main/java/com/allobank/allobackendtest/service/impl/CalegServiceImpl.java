package com.allobank.allobackendtest.service.impl;

import com.allobank.allobackendtest.dto.CalegDTO;
import com.allobank.allobackendtest.mapper.CalegMapper;
import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.JenisKelamin;
import com.allobank.allobackendtest.repository.CalegRepository;
import com.allobank.allobackendtest.service.CalegService;
import com.allobank.allobackendtest.util.CalegSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class CalegServiceImpl implements CalegService {

    private final CalegRepository calegRepository;
    private final CalegMapper calegMapper;

    @Autowired
    public CalegServiceImpl(CalegRepository calegRepository, CalegMapper calegMapper) {
        this.calegRepository = calegRepository;
        this.calegMapper = calegMapper;
    }

    @Override
    public CalegDTO getCalegById(UUID id) {
        Caleg caleg = calegRepository.findById(id).orElse(null);
        return calegMapper.toDto(caleg);
    }

    @Override
    public List<CalegDTO> getCalegWithFilters(
            UUID dapilId,
            UUID partaiId,
            String nama,
            JenisKelamin jenisKelamin,
            Integer nomorUrut,
            String sortBy,
            Sort.Direction sortDirection) {

        // Start with a base specification that matches everything
        Specification<Caleg> spec = Specification.where(null);

        // Add individual specifications only if the corresponding parameter is not null/empty
        if (dapilId != null) {
            spec = spec.and(CalegSpecification.hasDapil(dapilId));
        }

        if (partaiId != null) {
            spec = spec.and(CalegSpecification.hasPartai(partaiId));
        }

        if (StringUtils.hasText(nama)) {
            spec = spec.and(CalegSpecification.hasNama(nama));
        }

        if (jenisKelamin != null) {
            spec = spec.and(CalegSpecification.hasJenisKelamin(jenisKelamin));
        }

        if (nomorUrut != null) {
            spec = spec.and(CalegSpecification.hasNomorUrut(nomorUrut));
        }

        // Set default sort if not provided
        if (!StringUtils.hasText(sortBy)) {
            sortBy = "nomorUrut";
        }

        // Set default sort direction if not provided
        if (sortDirection == null) {
            sortDirection = Sort.Direction.ASC;
        }

        // Create sort object
        Sort sort = Sort.by(sortDirection, sortBy);

        // Execute query with specification and sort
        List<Caleg> calegList = calegRepository.findAll(spec, sort);

        // Convert entities to DTOs
        return calegMapper.toDtoList(calegList);
    }
}
