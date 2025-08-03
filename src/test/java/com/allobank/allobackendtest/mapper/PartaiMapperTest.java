package com.allobank.allobackendtest.mapper;

import com.allobank.allobackendtest.dto.PartaiDTO;
import com.allobank.allobackendtest.model.Partai;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PartaiMapperTest {

    @InjectMocks
    private PartaiMapper partaiMapper;

    @Test
    void toDto_shouldMapEntityToDto_whenEntityIsNotNull() {
        // Arrange
        UUID id = UUID.randomUUID();
        Partai entity = new Partai();
        entity.setId(id);
        entity.setNamaPartai("Partai Test");
        entity.setNomorUrut(1);

        // Act
        PartaiDTO result = partaiMapper.toDto(entity);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Partai Test", result.getNamaPartai());
        assertEquals(1, result.getNomorUrut());
    }

    @Test
    void toDto_shouldReturnNull_whenEntityIsNull() {
        // Act
        PartaiDTO result = partaiMapper.toDto(null);

        // Assert
        assertNull(result);
    }

    @Test
    void toEntity_shouldMapDtoToEntity_whenDtoIsNotNull() {
        // Arrange
        UUID id = UUID.randomUUID();
        PartaiDTO dto = new PartaiDTO();
        dto.setId(id);
        dto.setNamaPartai("Partai Test");
        dto.setNomorUrut(1);

        // Act
        Partai result = partaiMapper.toEntity(dto);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Partai Test", result.getNamaPartai());
        assertEquals(1, result.getNomorUrut());
    }

    @Test
    void toEntity_shouldReturnNull_whenDtoIsNull() {
        // Act
        Partai result = partaiMapper.toEntity(null);

        // Assert
        assertNull(result);
    }

    @Test
    void toDtoList_shouldMapEntityListToDtoList_whenEntityListIsNotNull() {
        // Arrange
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        
        Partai entity1 = new Partai();
        entity1.setId(id1);
        entity1.setNamaPartai("Partai Test 1");
        entity1.setNomorUrut(1);
        
        Partai entity2 = new Partai();
        entity2.setId(id2);
        entity2.setNamaPartai("Partai Test 2");
        entity2.setNomorUrut(2);
        
        List<Partai> entityList = Arrays.asList(entity1, entity2);

        // Act
        List<PartaiDTO> result = partaiMapper.toDtoList(entityList);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        
        assertEquals(id1, result.get(0).getId());
        assertEquals("Partai Test 1", result.get(0).getNamaPartai());
        assertEquals(1, result.get(0).getNomorUrut());
        
        assertEquals(id2, result.get(1).getId());
        assertEquals("Partai Test 2", result.get(1).getNamaPartai());
        assertEquals(2, result.get(1).getNomorUrut());
    }

    @Test
    void toDtoList_shouldReturnNull_whenEntityListIsNull() {
        // Act
        List<PartaiDTO> result = partaiMapper.toDtoList(null);

        // Assert
        assertNull(result);
    }

    @Test
    void toEntityList_shouldMapDtoListToEntityList_whenDtoListIsNotNull() {
        // Arrange
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        
        PartaiDTO dto1 = new PartaiDTO();
        dto1.setId(id1);
        dto1.setNamaPartai("Partai Test 1");
        dto1.setNomorUrut(1);
        
        PartaiDTO dto2 = new PartaiDTO();
        dto2.setId(id2);
        dto2.setNamaPartai("Partai Test 2");
        dto2.setNomorUrut(2);
        
        List<PartaiDTO> dtoList = Arrays.asList(dto1, dto2);

        // Act
        List<Partai> result = partaiMapper.toEntityList(dtoList);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        
        assertEquals(id1, result.get(0).getId());
        assertEquals("Partai Test 1", result.get(0).getNamaPartai());
        assertEquals(1, result.get(0).getNomorUrut());
        
        assertEquals(id2, result.get(1).getId());
        assertEquals("Partai Test 2", result.get(1).getNamaPartai());
        assertEquals(2, result.get(1).getNomorUrut());
    }

    @Test
    void toEntityList_shouldReturnNull_whenDtoListIsNull() {
        // Act
        List<Partai> result = partaiMapper.toEntityList(null);

        // Assert
        assertNull(result);
    }
}