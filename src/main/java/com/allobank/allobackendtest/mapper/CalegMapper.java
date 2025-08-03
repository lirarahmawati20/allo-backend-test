package com.allobank.allobackendtest.mapper;

import com.allobank.allobackendtest.dto.CalegDTO;
import com.allobank.allobackendtest.model.Caleg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Mapper for converting between Caleg entities and DTOs
 */
@Component
public class CalegMapper implements EntityMapper<Caleg, CalegDTO> {
    
    private final DapilMapper dapilMapper;
    private final PartaiMapper partaiMapper;
    
    @Autowired
    public CalegMapper(DapilMapper dapilMapper, PartaiMapper partaiMapper) {
        this.dapilMapper = dapilMapper;
        this.partaiMapper = partaiMapper;
    }
    
    @Override
    public CalegDTO toDto(Caleg entity) {
        if (entity == null) {
            return null;
        }
        
        CalegDTO dto = new CalegDTO();
        dto.setId(entity.getId());
        dto.setNomorUrut(entity.getNomorUrut());
        dto.setNama(entity.getNama());
        dto.setJenisKelamin(entity.getJenisKelamin());
        
        if (entity.getDapil() != null) {
            dto.setDapil(dapilMapper.toDto(entity.getDapil()));
        }
        
        if (entity.getPartai() != null) {
            dto.setPartai(partaiMapper.toDto(entity.getPartai()));
        }
        
        return dto;
    }
    
    @Override
    public Caleg toEntity(CalegDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Caleg entity = new Caleg();
        entity.setId(dto.getId());
        entity.setNomorUrut(dto.getNomorUrut());
        entity.setNama(dto.getNama());
        entity.setJenisKelamin(dto.getJenisKelamin());
        
        if (dto.getDapil() != null) {
            entity.setDapil(dapilMapper.toEntity(dto.getDapil()));
        }
        
        if (dto.getPartai() != null) {
            entity.setPartai(partaiMapper.toEntity(dto.getPartai()));
        }
        
        return entity;
    }
}