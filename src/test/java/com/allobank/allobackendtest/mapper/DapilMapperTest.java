package com.allobank.allobackendtest.mapper;

import com.allobank.allobackendtest.dto.DapilDTO;
import com.allobank.allobackendtest.dto.WilayahDapilDTO;
import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.model.WilayahDapil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DapilMapperTest {

    @Mock
    private WilayahDapilMapper wilayahDapilMapper;

    @InjectMocks
    private DapilMapper dapilMapper;

    @Test
    void toDto_shouldMapEntityToDto_whenEntityIsNotNull() {
        // Arrange
        UUID id = UUID.randomUUID();
        Dapil entity = new Dapil();
        entity.setId(id);
        entity.setNamaDapil("Dapil Test");
        entity.setProvinsi("Provinsi Test");
        entity.setJumlahKursi(5);

        List<WilayahDapil> wilayahList = Arrays.asList(new WilayahDapil(), new WilayahDapil());
        entity.setWilayahDapilList(wilayahList);

        List<WilayahDapilDTO> wilayahDtoList = Arrays.asList(new WilayahDapilDTO(), new WilayahDapilDTO());
        when(wilayahDapilMapper.toDtoList(wilayahList)).thenReturn(wilayahDtoList);

        // Act
        DapilDTO result = dapilMapper.toDto(entity);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Dapil Test", result.getNamaDapil());
        assertEquals("Provinsi Test", result.getProvinsi());
        assertEquals(5, result.getJumlahKursi());
        assertEquals(wilayahDtoList, result.getWilayahDapilList());

        verify(wilayahDapilMapper).toDtoList(wilayahList);
    }

    @Test
    void toDto_shouldReturnNull_whenEntityIsNull() {
        // Act
        DapilDTO result = dapilMapper.toDto(null);

        // Assert
        assertNull(result);
        verifyNoInteractions(wilayahDapilMapper);
    }

    @Test
    void toDto_shouldMapEntityWithoutWilayahList_whenWilayahListIsNull() {
        // Arrange
        UUID id = UUID.randomUUID();
        Dapil entity = new Dapil();
        entity.setId(id);
        entity.setNamaDapil("Dapil Test");
        entity.setProvinsi("Provinsi Test");
        entity.setJumlahKursi(5);
        entity.setWilayahDapilList(null);

        // Act
        DapilDTO result = dapilMapper.toDto(entity);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Dapil Test", result.getNamaDapil());
        assertEquals("Provinsi Test", result.getProvinsi());
        assertEquals(5, result.getJumlahKursi());
        assertTrue(result.getWilayahDapilList() != null && result.getWilayahDapilList().isEmpty());

        verifyNoInteractions(wilayahDapilMapper);
    }

    @Test
    void toEntity_shouldMapDtoToEntity_whenDtoIsNotNull() {
        // Arrange
        UUID id = UUID.randomUUID();
        DapilDTO dto = new DapilDTO();
        dto.setId(id);
        dto.setNamaDapil("Dapil Test");
        dto.setProvinsi("Provinsi Test");
        dto.setJumlahKursi(5);

        List<WilayahDapilDTO> wilayahDtoList = Arrays.asList(new WilayahDapilDTO(), new WilayahDapilDTO());
        dto.setWilayahDapilList(wilayahDtoList);

        List<WilayahDapil> wilayahList = Arrays.asList(new WilayahDapil(), new WilayahDapil());
        when(wilayahDapilMapper.toEntityList(wilayahDtoList)).thenReturn(wilayahList);

        // Act
        Dapil result = dapilMapper.toEntity(dto);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Dapil Test", result.getNamaDapil());
        assertEquals("Provinsi Test", result.getProvinsi());
        assertEquals(5, result.getJumlahKursi());
        assertEquals(wilayahList, result.getWilayahDapilList());

        verify(wilayahDapilMapper).toEntityList(wilayahDtoList);
    }

    @Test
    void toEntity_shouldReturnNull_whenDtoIsNull() {
        // Act
        Dapil result = dapilMapper.toEntity(null);

        // Assert
        assertNull(result);
        verifyNoInteractions(wilayahDapilMapper);
    }

    @Test
    void toEntity_shouldMapDtoWithoutWilayahList_whenWilayahListIsNull() {
        // Arrange
        UUID id = UUID.randomUUID();
        DapilDTO dto = new DapilDTO();
        dto.setId(id);
        dto.setNamaDapil("Dapil Test");
        dto.setProvinsi("Provinsi Test");
        dto.setJumlahKursi(5);
        dto.setWilayahDapilList(null);

        // Act
        Dapil result = dapilMapper.toEntity(dto);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Dapil Test", result.getNamaDapil());
        assertEquals("Provinsi Test", result.getProvinsi());
        assertEquals(5, result.getJumlahKursi());
        assertTrue(result.getWilayahDapilList() != null && result.getWilayahDapilList().isEmpty());

        verifyNoInteractions(wilayahDapilMapper);
    }

    @Test
    void toDtoList_shouldMapEntityListToDtoList_whenEntityListIsNotNull() {
        // Arrange
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        Dapil entity1 = new Dapil();
        entity1.setId(id1);
        entity1.setNamaDapil("Dapil Test 1");
        entity1.setProvinsi("Provinsi Test 1");
        entity1.setJumlahKursi(5);

        Dapil entity2 = new Dapil();
        entity2.setId(id2);
        entity2.setNamaDapil("Dapil Test 2");
        entity2.setProvinsi("Provinsi Test 2");
        entity2.setJumlahKursi(10);

        List<Dapil> entityList = Arrays.asList(entity1, entity2);

        // Mock behavior for nested objects
        when(wilayahDapilMapper.toDtoList(any())).thenReturn(null);

        // Act
        List<DapilDTO> result = dapilMapper.toDtoList(entityList);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());

        assertEquals(id1, result.get(0).getId());
        assertEquals("Dapil Test 1", result.get(0).getNamaDapil());
        assertEquals("Provinsi Test 1", result.get(0).getProvinsi());
        assertEquals(5, result.get(0).getJumlahKursi());

        assertEquals(id2, result.get(1).getId());
        assertEquals("Dapil Test 2", result.get(1).getNamaDapil());
        assertEquals("Provinsi Test 2", result.get(1).getProvinsi());
        assertEquals(10, result.get(1).getJumlahKursi());
    }

    @Test
    void toDtoList_shouldReturnNull_whenEntityListIsNull() {
        // Act
        List<DapilDTO> result = dapilMapper.toDtoList(null);

        // Assert
        assertNull(result);
        verifyNoInteractions(wilayahDapilMapper);
    }

    @Test
    void toEntityList_shouldMapDtoListToEntityList_whenDtoListIsNotNull() {
        // Arrange
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        DapilDTO dto1 = new DapilDTO();
        dto1.setId(id1);
        dto1.setNamaDapil("Dapil Test 1");
        dto1.setProvinsi("Provinsi Test 1");
        dto1.setJumlahKursi(5);

        DapilDTO dto2 = new DapilDTO();
        dto2.setId(id2);
        dto2.setNamaDapil("Dapil Test 2");
        dto2.setProvinsi("Provinsi Test 2");
        dto2.setJumlahKursi(10);

        List<DapilDTO> dtoList = Arrays.asList(dto1, dto2);

        // Mock behavior for nested objects
        when(wilayahDapilMapper.toEntityList(any())).thenReturn(null);

        // Act
        List<Dapil> result = dapilMapper.toEntityList(dtoList);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());

        assertEquals(id1, result.get(0).getId());
        assertEquals("Dapil Test 1", result.get(0).getNamaDapil());
        assertEquals("Provinsi Test 1", result.get(0).getProvinsi());
        assertEquals(5, result.get(0).getJumlahKursi());

        assertEquals(id2, result.get(1).getId());
        assertEquals("Dapil Test 2", result.get(1).getNamaDapil());
        assertEquals("Provinsi Test 2", result.get(1).getProvinsi());
        assertEquals(10, result.get(1).getJumlahKursi());
    }

    @Test
    void toEntityList_shouldReturnNull_whenDtoListIsNull() {
        // Act
        List<Dapil> result = dapilMapper.toEntityList(null);

        // Assert
        assertNull(result);
        verifyNoInteractions(wilayahDapilMapper);
    }
}
