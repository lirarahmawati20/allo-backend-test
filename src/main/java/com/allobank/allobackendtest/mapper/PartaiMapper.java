package com.allobank.allobackendtest.mapper;

import com.allobank.allobackendtest.dto.PartaiDTO;
import com.allobank.allobackendtest.model.Partai;
import org.springframework.stereotype.Component;

/**
 * Mapper for converting between Partai entities and DTOs
 */
@Component
public class PartaiMapper implements EntityMapper<Partai, PartaiDTO> {
    
    @Override
    public PartaiDTO toDto(Partai entity) {
        if (entity == null) {
            return null;
        }
        
        PartaiDTO dto = new PartaiDTO();
        dto.setId(entity.getId());
        dto.setNamaPartai(entity.getNamaPartai());
        dto.setNomorUrut(entity.getNomorUrut());
        
        return dto;
    }
    
    @Override
    public Partai toEntity(PartaiDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Partai entity = new Partai();
        entity.setId(dto.getId());
        entity.setNamaPartai(dto.getNamaPartai());
        entity.setNomorUrut(dto.getNomorUrut());
        
        return entity;
    }
}