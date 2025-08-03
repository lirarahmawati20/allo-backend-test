package com.allobank.allobackendtest.mapper;

import com.allobank.allobackendtest.dto.DapilDTO;
import com.allobank.allobackendtest.model.Dapil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Mapper for converting between Dapil entities and DTOs
 */
@Component
public class DapilMapper implements EntityMapper<Dapil, DapilDTO> {
    
    private final WilayahDapilMapper wilayahDapilMapper;
    
    @Autowired
    public DapilMapper(WilayahDapilMapper wilayahDapilMapper) {
        this.wilayahDapilMapper = wilayahDapilMapper;
    }
    
    @Override
    public DapilDTO toDto(Dapil entity) {
        if (entity == null) {
            return null;
        }
        
        DapilDTO dto = new DapilDTO();
        dto.setId(entity.getId());
        dto.setNamaDapil(entity.getNamaDapil());
        dto.setProvinsi(entity.getProvinsi());
        dto.setJumlahKursi(entity.getJumlahKursi());
        
        if (entity.getWilayahDapilList() != null) {
            dto.setWilayahDapilList(wilayahDapilMapper.toDtoList(entity.getWilayahDapilList()));
        }
        
        return dto;
    }
    
    @Override
    public Dapil toEntity(DapilDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Dapil entity = new Dapil();
        entity.setId(dto.getId());
        entity.setNamaDapil(dto.getNamaDapil());
        entity.setProvinsi(dto.getProvinsi());
        entity.setJumlahKursi(dto.getJumlahKursi());
        
        if (dto.getWilayahDapilList() != null) {
            entity.setWilayahDapilList(wilayahDapilMapper.toEntityList(dto.getWilayahDapilList()));
        }
        
        return entity;
    }
}