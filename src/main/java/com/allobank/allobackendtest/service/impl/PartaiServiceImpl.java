package com.allobank.allobackendtest.service.impl;

import com.allobank.allobackendtest.dto.PartaiDTO;
import com.allobank.allobackendtest.mapper.PartaiMapper;
import com.allobank.allobackendtest.model.Partai;
import com.allobank.allobackendtest.repository.PartaiRepository;
import com.allobank.allobackendtest.service.PartaiService;
import com.allobank.allobackendtest.util.PartaiSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class PartaiServiceImpl implements PartaiService {

    private final PartaiRepository partaiRepository;
    private final PartaiMapper partaiMapper;

    @Autowired
    public PartaiServiceImpl(PartaiRepository partaiRepository, PartaiMapper partaiMapper) {
        this.partaiRepository = partaiRepository;
        this.partaiMapper = partaiMapper;
    }

    @Override
    public PartaiDTO getPartaiById(UUID id) {
        Partai partai = partaiRepository.findById(id).orElse(null);
        return partaiMapper.toDto(partai);
    }

    @Override
    public List<PartaiDTO> getPartaiWithFilters(
            UUID id,
            String namaPartai,
            Integer nomorUrut,
            String sortBy,
            Sort.Direction sortDirection) {

        // Start with a base specification that matches everything
        Specification<Partai> spec = Specification.where(null);

        // Add individual specifications only if the corresponding parameter is not null/empty
        if (id != null) {
            spec = spec.and(PartaiSpecification.hasId(id));
        }

        if (StringUtils.hasText(namaPartai)) {
            spec = spec.and(PartaiSpecification.hasNamaPartai(namaPartai));
        }

        if (nomorUrut != null) {
            spec = spec.and(PartaiSpecification.hasNomorUrut(nomorUrut));
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
        List<Partai> partaiList = partaiRepository.findAll(spec, sort);

        // Convert entities to DTOs
        return partaiMapper.toDtoList(partaiList);
    }
}
