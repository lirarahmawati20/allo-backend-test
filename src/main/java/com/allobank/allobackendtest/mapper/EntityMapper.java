package com.allobank.allobackendtest.mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generic mapper interface for converting between entities and DTOs
 * @param <E> Entity type
 * @param <D> DTO type
 */
public interface EntityMapper<E, D> {
    
    /**
     * Convert entity to DTO
     * @param entity Entity to convert
     * @return Converted DTO
     */
    D toDto(E entity);
    
    /**
     * Convert DTO to entity
     * @param dto DTO to convert
     * @return Converted entity
     */
    E toEntity(D dto);
    
    /**
     * Convert list of entities to list of DTOs
     * @param entities List of entities to convert
     * @return List of converted DTOs
     */
    default List<D> toDtoList(List<E> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    
    /**
     * Convert list of DTOs to list of entities
     * @param dtos List of DTOs to convert
     * @return List of converted entities
     */
    default List<E> toEntityList(List<D> dtos) {
        if (dtos == null) {
            return null;
        }
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}