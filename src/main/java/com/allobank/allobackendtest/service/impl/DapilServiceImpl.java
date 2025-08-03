package com.allobank.allobackendtest.service.impl;

import com.allobank.allobackendtest.dto.DapilDTO;
import com.allobank.allobackendtest.mapper.DapilMapper;
import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.repository.DapilRepository;
import com.allobank.allobackendtest.service.DapilService;
import com.allobank.allobackendtest.util.DapilSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class DapilServiceImpl implements DapilService {

    private final DapilRepository dapilRepository;
    private final DapilMapper dapilMapper;

    @Autowired
    public DapilServiceImpl(DapilRepository dapilRepository, DapilMapper dapilMapper) {
        this.dapilRepository = dapilRepository;
        this.dapilMapper = dapilMapper;
    }

    @Override
    public DapilDTO getDapilById(UUID id) {
        Dapil dapil = dapilRepository.findById(id).orElse(null);
        return dapilMapper.toDto(dapil);
    }

    @Override
    public List<DapilDTO> getDapilWithFilters(
            String namaDapil,
            String provinsi,
            Integer jumlahKursi,
            String sortBy,
            Sort.Direction sortDirection) {

        // Start with a base specification that matches everything
        Specification<Dapil> spec = Specification.where(null);

        // Add individual specifications only if the corresponding parameter is not null/empty
        if (StringUtils.hasText(namaDapil)) {
            spec = spec.and(DapilSpecification.hasNamaDapil(namaDapil));
        }

        if (StringUtils.hasText(provinsi)) {
            spec = spec.and(DapilSpecification.hasProvinsi(provinsi));
        }

        if (jumlahKursi != null) {
            spec = spec.and(DapilSpecification.hasJumlahKursi(jumlahKursi));
        }

        // Set default sort if not provided
        if (!StringUtils.hasText(sortBy)) {
            sortBy = "namaDapil";
        }

        // Set default sort direction if not provided
        if (sortDirection == null) {
            sortDirection = Sort.Direction.ASC;
        }

        // Create sort object
        Sort sort = Sort.by(sortDirection, sortBy);

        // Execute query with specification and sort
        List<Dapil> dapilList = dapilRepository.findAll(spec, sort);

        // Convert entities to DTOs
        return dapilMapper.toDtoList(dapilList);
    }
}
