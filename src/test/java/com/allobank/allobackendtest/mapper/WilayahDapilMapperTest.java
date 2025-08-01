package com.allobank.allobackendtest.mapper;

import com.allobank.allobackendtest.dto.WilayahDapilDTO;
import com.allobank.allobackendtest.model.WilayahDapil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WilayahDapilMapperTest {

    @InjectMocks
    private WilayahDapilMapper wilayahDapilMapper;

    @Test
    void toDto_shouldMapEntityToDto_whenEntityIsNotNull() {
        // Arrange
        UUID id = UUID.randomUUID();
        UUID dapilId = UUID.randomUUID();
        WilayahDapil entity = new WilayahDapil();
        entity.setId(id);
        entity.setDapilId(dapilId);
        entity.setNamaWilayah("Wilayah Test");

        // Act
        WilayahDapilDTO result = wilayahDapilMapper.toDto(entity);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals(dapilId, result.getDapilId());
        assertEquals("Wilayah Test", result.getNamaWilayah());
    }

    @Test
    void toDto_shouldReturnNull_whenEntityIsNull() {
        // Act
        WilayahDapilDTO result = wilayahDapilMapper.toDto(null);

        // Assert
        assertNull(result);
    }

    @Test
    void toEntity_shouldMapDtoToEntity_whenDtoIsNotNull() {
        // Arrange
        UUID id = UUID.randomUUID();
        UUID dapilId = UUID.randomUUID();
        WilayahDapilDTO dto = new WilayahDapilDTO();
        dto.setId(id);
        dto.setDapilId(dapilId);
        dto.setNamaWilayah("Wilayah Test");

        // Act
        WilayahDapil result = wilayahDapilMapper.toEntity(dto);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals(dapilId, result.getDapilId());
        assertEquals("Wilayah Test", result.getNamaWilayah());
    }

    @Test
    void toEntity_shouldReturnNull_whenDtoIsNull() {
        // Act
        WilayahDapil result = wilayahDapilMapper.toEntity(null);

        // Assert
        assertNull(result);
    }

    @Test
    void toDtoList_shouldMapEntityListToDtoList_whenEntityListIsNotNull() {
        // Arrange
        UUID id1 = UUID.randomUUID();
        UUID dapilId1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID dapilId2 = UUID.randomUUID();
        
        WilayahDapil entity1 = new WilayahDapil();
        entity1.setId(id1);
        entity1.setDapilId(dapilId1);
        entity1.setNamaWilayah("Wilayah Test 1");
        
        WilayahDapil entity2 = new WilayahDapil();
        entity2.setId(id2);
        entity2.setDapilId(dapilId2);
        entity2.setNamaWilayah("Wilayah Test 2");
        
        List<WilayahDapil> entityList = Arrays.asList(entity1, entity2);

        // Act
        List<WilayahDapilDTO> result = wilayahDapilMapper.toDtoList(entityList);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        
        assertEquals(id1, result.get(0).getId());
        assertEquals(dapilId1, result.get(0).getDapilId());
        assertEquals("Wilayah Test 1", result.get(0).getNamaWilayah());
        
        assertEquals(id2, result.get(1).getId());
        assertEquals(dapilId2, result.get(1).getDapilId());
        assertEquals("Wilayah Test 2", result.get(1).getNamaWilayah());
    }

    @Test
    void toDtoList_shouldReturnNull_whenEntityListIsNull() {
        // Act
        List<WilayahDapilDTO> result = wilayahDapilMapper.toDtoList(null);

        // Assert
        assertNull(result);
    }

    @Test
    void toEntityList_shouldMapDtoListToEntityList_whenDtoListIsNotNull() {
        // Arrange
        UUID id1 = UUID.randomUUID();
        UUID dapilId1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID dapilId2 = UUID.randomUUID();
        
        WilayahDapilDTO dto1 = new WilayahDapilDTO();
        dto1.setId(id1);
        dto1.setDapilId(dapilId1);
        dto1.setNamaWilayah("Wilayah Test 1");
        
        WilayahDapilDTO dto2 = new WilayahDapilDTO();
        dto2.setId(id2);
        dto2.setDapilId(dapilId2);
        dto2.setNamaWilayah("Wilayah Test 2");
        
        List<WilayahDapilDTO> dtoList = Arrays.asList(dto1, dto2);

        // Act
        List<WilayahDapil> result = wilayahDapilMapper.toEntityList(dtoList);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        
        assertEquals(id1, result.get(0).getId());
        assertEquals(dapilId1, result.get(0).getDapilId());
        assertEquals("Wilayah Test 1", result.get(0).getNamaWilayah());
        
        assertEquals(id2, result.get(1).getId());
        assertEquals(dapilId2, result.get(1).getDapilId());
        assertEquals("Wilayah Test 2", result.get(1).getNamaWilayah());
    }

    @Test
    void toEntityList_shouldReturnNull_whenDtoListIsNull() {
        // Act
        List<WilayahDapil> result = wilayahDapilMapper.toEntityList(null);

        // Assert
        assertNull(result);
    }
}