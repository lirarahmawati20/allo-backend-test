package com.allobank.allobackendtest.mapper;

import com.allobank.allobackendtest.dto.WilayahDapilDTO;
import com.allobank.allobackendtest.model.WilayahDapil;
import org.springframework.stereotype.Component;

/**
 * Mapper for converting between WilayahDapil entities and DTOs
 */
@Component
public class WilayahDapilMapper implements EntityMapper<WilayahDapil, WilayahDapilDTO> {
    
    @Override
    public WilayahDapilDTO toDto(WilayahDapil entity) {
        if (entity == null) {
            return null;
        }
        
        WilayahDapilDTO dto = new WilayahDapilDTO();
        dto.setId(entity.getId());
        dto.setDapilId(entity.getDapilId());
        dto.setNamaWilayah(entity.getNamaWilayah());
        
        return dto;
    }
    
    @Override
    public WilayahDapil toEntity(WilayahDapilDTO dto) {
        if (dto == null) {
            return null;
        }
        
        WilayahDapil entity = new WilayahDapil();
        entity.setId(dto.getId());
        entity.setDapilId(dto.getDapilId());
        entity.setNamaWilayah(dto.getNamaWilayah());
        
        return entity;
    }
}