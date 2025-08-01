package com.allobank.allobackendtest.mapper;

import com.allobank.allobackendtest.dto.CalegDTO;
import com.allobank.allobackendtest.dto.DapilDTO;
import com.allobank.allobackendtest.dto.PartaiDTO;
import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.model.JenisKelamin;
import com.allobank.allobackendtest.model.Partai;
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
class CalegMapperTest {

    @Mock
    private DapilMapper dapilMapper;

    @Mock
    private PartaiMapper partaiMapper;

    @InjectMocks
    private CalegMapper calegMapper;

    @Test
    void toDto_shouldMapEntityToDto_whenEntityIsNotNull() {
        // Arrange
        UUID id = UUID.randomUUID();
        Caleg entity = new Caleg();
        entity.setId(id);
        entity.setNomorUrut(1);
        entity.setNama("Caleg Test");
        entity.setJenisKelamin(JenisKelamin.LAKILAKI);

        Dapil dapil = new Dapil();
        dapil.setId(UUID.randomUUID());
        entity.setDapil(dapil);

        Partai partai = new Partai();
        partai.setId(UUID.randomUUID());
        entity.setPartai(partai);

        DapilDTO dapilDTO = new DapilDTO();
        dapilDTO.setId(dapil.getId());
        when(dapilMapper.toDto(dapil)).thenReturn(dapilDTO);

        PartaiDTO partaiDTO = new PartaiDTO();
        partaiDTO.setId(partai.getId());
        when(partaiMapper.toDto(partai)).thenReturn(partaiDTO);

        // Act
        CalegDTO result = calegMapper.toDto(entity);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals(1, result.getNomorUrut());
        assertEquals("Caleg Test", result.getNama());
        assertEquals(JenisKelamin.LAKILAKI, result.getJenisKelamin());
        assertEquals(dapilDTO, result.getDapil());
        assertEquals(partaiDTO, result.getPartai());

        verify(dapilMapper).toDto(dapil);
        verify(partaiMapper).toDto(partai);
    }

    @Test
    void toDto_shouldReturnNull_whenEntityIsNull() {
        // Act
        CalegDTO result = calegMapper.toDto(null);

        // Assert
        assertNull(result);
        verifyNoInteractions(dapilMapper);
        verifyNoInteractions(partaiMapper);
    }

    @Test
    void toDto_shouldMapEntityWithoutDapil_whenDapilIsNull() {
        // Arrange
        UUID id = UUID.randomUUID();
        Caleg entity = new Caleg();
        entity.setId(id);
        entity.setNomorUrut(1);
        entity.setNama("Caleg Test");
        entity.setJenisKelamin(JenisKelamin.LAKILAKI);
        entity.setDapil(null);

        Partai partai = new Partai();
        partai.setId(UUID.randomUUID());
        entity.setPartai(partai);

        PartaiDTO partaiDTO = new PartaiDTO();
        partaiDTO.setId(partai.getId());
        when(partaiMapper.toDto(partai)).thenReturn(partaiDTO);

        // Act
        CalegDTO result = calegMapper.toDto(entity);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals(1, result.getNomorUrut());
        assertEquals("Caleg Test", result.getNama());
        assertEquals(JenisKelamin.LAKILAKI, result.getJenisKelamin());
        assertNull(result.getDapil());
        assertEquals(partaiDTO, result.getPartai());

        verifyNoInteractions(dapilMapper);
        verify(partaiMapper).toDto(partai);
    }

    @Test
    void toDto_shouldMapEntityWithoutPartai_whenPartaiIsNull() {
        // Arrange
        UUID id = UUID.randomUUID();
        Caleg entity = new Caleg();
        entity.setId(id);
        entity.setNomorUrut(1);
        entity.setNama("Caleg Test");
        entity.setJenisKelamin(JenisKelamin.LAKILAKI);

        Dapil dapil = new Dapil();
        dapil.setId(UUID.randomUUID());
        entity.setDapil(dapil);
        entity.setPartai(null);

        DapilDTO dapilDTO = new DapilDTO();
        dapilDTO.setId(dapil.getId());
        when(dapilMapper.toDto(dapil)).thenReturn(dapilDTO);

        // Act
        CalegDTO result = calegMapper.toDto(entity);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals(1, result.getNomorUrut());
        assertEquals("Caleg Test", result.getNama());
        assertEquals(JenisKelamin.LAKILAKI, result.getJenisKelamin());
        assertEquals(dapilDTO, result.getDapil());
        assertNull(result.getPartai());

        verify(dapilMapper).toDto(dapil);
        verifyNoInteractions(partaiMapper);
    }

    @Test
    void toEntity_shouldMapDtoToEntity_whenDtoIsNotNull() {
        // Arrange
        UUID id = UUID.randomUUID();
        CalegDTO dto = new CalegDTO();
        dto.setId(id);
        dto.setNomorUrut(1);
        dto.setNama("Caleg Test");
        dto.setJenisKelamin(JenisKelamin.LAKILAKI);

        DapilDTO dapilDTO = new DapilDTO();
        dapilDTO.setId(UUID.randomUUID());
        dto.setDapil(dapilDTO);

        PartaiDTO partaiDTO = new PartaiDTO();
        partaiDTO.setId(UUID.randomUUID());
        dto.setPartai(partaiDTO);

        Dapil dapil = new Dapil();
        dapil.setId(dapilDTO.getId());
        when(dapilMapper.toEntity(dapilDTO)).thenReturn(dapil);

        Partai partai = new Partai();
        partai.setId(partaiDTO.getId());
        when(partaiMapper.toEntity(partaiDTO)).thenReturn(partai);

        // Act
        Caleg result = calegMapper.toEntity(dto);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals(1, result.getNomorUrut());
        assertEquals("Caleg Test", result.getNama());
        assertEquals(JenisKelamin.LAKILAKI, result.getJenisKelamin());
        assertEquals(dapil, result.getDapil());
        assertEquals(partai, result.getPartai());

        verify(dapilMapper).toEntity(dapilDTO);
        verify(partaiMapper).toEntity(partaiDTO);
    }

    @Test
    void toEntity_shouldReturnNull_whenDtoIsNull() {
        // Act
        Caleg result = calegMapper.toEntity(null);

        // Assert
        assertNull(result);
        verifyNoInteractions(dapilMapper);
        verifyNoInteractions(partaiMapper);
    }

    @Test
    void toEntity_shouldMapDtoWithoutDapil_whenDapilIsNull() {
        // Arrange
        UUID id = UUID.randomUUID();
        CalegDTO dto = new CalegDTO();
        dto.setId(id);
        dto.setNomorUrut(1);
        dto.setNama("Caleg Test");
        dto.setJenisKelamin(JenisKelamin.LAKILAKI);
        dto.setDapil(null);

        PartaiDTO partaiDTO = new PartaiDTO();
        partaiDTO.setId(UUID.randomUUID());
        dto.setPartai(partaiDTO);

        Partai partai = new Partai();
        partai.setId(partaiDTO.getId());
        when(partaiMapper.toEntity(partaiDTO)).thenReturn(partai);

        // Act
        Caleg result = calegMapper.toEntity(dto);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals(1, result.getNomorUrut());
        assertEquals("Caleg Test", result.getNama());
        assertEquals(JenisKelamin.LAKILAKI, result.getJenisKelamin());
        assertNull(result.getDapil());
        assertEquals(partai, result.getPartai());

        verifyNoInteractions(dapilMapper);
        verify(partaiMapper).toEntity(partaiDTO);
    }

    @Test
    void toEntity_shouldMapDtoWithoutPartai_whenPartaiIsNull() {
        // Arrange
        UUID id = UUID.randomUUID();
        CalegDTO dto = new CalegDTO();
        dto.setId(id);
        dto.setNomorUrut(1);
        dto.setNama("Caleg Test");
        dto.setJenisKelamin(JenisKelamin.LAKILAKI);

        DapilDTO dapilDTO = new DapilDTO();
        dapilDTO.setId(UUID.randomUUID());
        dto.setDapil(dapilDTO);
        dto.setPartai(null);

        Dapil dapil = new Dapil();
        dapil.setId(dapilDTO.getId());
        when(dapilMapper.toEntity(dapilDTO)).thenReturn(dapil);

        // Act
        Caleg result = calegMapper.toEntity(dto);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals(1, result.getNomorUrut());
        assertEquals("Caleg Test", result.getNama());
        assertEquals(JenisKelamin.LAKILAKI, result.getJenisKelamin());
        assertEquals(dapil, result.getDapil());
        assertNull(result.getPartai());

        verify(dapilMapper).toEntity(dapilDTO);
        verifyNoInteractions(partaiMapper);
    }

    @Test
    void toDtoList_shouldMapEntityListToDtoList_whenEntityListIsNotNull() {
        // Arrange
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        Caleg entity1 = new Caleg();
        entity1.setId(id1);
        entity1.setNomorUrut(1);
        entity1.setNama("Caleg Test 1");
        entity1.setJenisKelamin(JenisKelamin.LAKILAKI);

        Dapil dapil1 = new Dapil();
        dapil1.setId(UUID.randomUUID());
        entity1.setDapil(dapil1);

        Partai partai1 = new Partai();
        partai1.setId(UUID.randomUUID());
        entity1.setPartai(partai1);

        Caleg entity2 = new Caleg();
        entity2.setId(id2);
        entity2.setNomorUrut(2);
        entity2.setNama("Caleg Test 2");
        entity2.setJenisKelamin(JenisKelamin.PEREMPUAN);

        Dapil dapil2 = new Dapil();
        dapil2.setId(UUID.randomUUID());
        entity2.setDapil(dapil2);

        Partai partai2 = new Partai();
        partai2.setId(UUID.randomUUID());
        entity2.setPartai(partai2);

        List<Caleg> entityList = Arrays.asList(entity1, entity2);

        // Mock behavior for nested objects
        DapilDTO dapilDTO1 = new DapilDTO();
        dapilDTO1.setId(dapil1.getId());
        when(dapilMapper.toDto(dapil1)).thenReturn(dapilDTO1);

        DapilDTO dapilDTO2 = new DapilDTO();
        dapilDTO2.setId(dapil2.getId());
        when(dapilMapper.toDto(dapil2)).thenReturn(dapilDTO2);

        PartaiDTO partaiDTO1 = new PartaiDTO();
        partaiDTO1.setId(partai1.getId());
        when(partaiMapper.toDto(partai1)).thenReturn(partaiDTO1);

        PartaiDTO partaiDTO2 = new PartaiDTO();
        partaiDTO2.setId(partai2.getId());
        when(partaiMapper.toDto(partai2)).thenReturn(partaiDTO2);

        // Act
        List<CalegDTO> result = calegMapper.toDtoList(entityList);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());

        assertEquals(id1, result.get(0).getId());
        assertEquals(1, result.get(0).getNomorUrut());
        assertEquals("Caleg Test 1", result.get(0).getNama());
        assertEquals(JenisKelamin.LAKILAKI, result.get(0).getJenisKelamin());
        assertEquals(dapilDTO1, result.get(0).getDapil());
        assertEquals(partaiDTO1, result.get(0).getPartai());

        assertEquals(id2, result.get(1).getId());
        assertEquals(2, result.get(1).getNomorUrut());
        assertEquals("Caleg Test 2", result.get(1).getNama());
        assertEquals(JenisKelamin.PEREMPUAN, result.get(1).getJenisKelamin());
        assertEquals(dapilDTO2, result.get(1).getDapil());
        assertEquals(partaiDTO2, result.get(1).getPartai());

        verify(dapilMapper).toDto(dapil1);
        verify(dapilMapper).toDto(dapil2);
        verify(partaiMapper).toDto(partai1);
        verify(partaiMapper).toDto(partai2);
    }

    @Test
    void toDtoList_shouldReturnNull_whenEntityListIsNull() {
        // Act
        List<CalegDTO> result = calegMapper.toDtoList(null);

        // Assert
        assertNull(result);
        verifyNoInteractions(dapilMapper);
        verifyNoInteractions(partaiMapper);
    }

    @Test
    void toEntityList_shouldMapDtoListToEntityList_whenDtoListIsNotNull() {
        // Arrange
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        CalegDTO dto1 = new CalegDTO();
        dto1.setId(id1);
        dto1.setNomorUrut(1);
        dto1.setNama("Caleg Test 1");
        dto1.setJenisKelamin(JenisKelamin.LAKILAKI);

        DapilDTO dapilDTO1 = new DapilDTO();
        dapilDTO1.setId(UUID.randomUUID());
        dto1.setDapil(dapilDTO1);

        PartaiDTO partaiDTO1 = new PartaiDTO();
        partaiDTO1.setId(UUID.randomUUID());
        dto1.setPartai(partaiDTO1);

        CalegDTO dto2 = new CalegDTO();
        dto2.setId(id2);
        dto2.setNomorUrut(2);
        dto2.setNama("Caleg Test 2");
        dto2.setJenisKelamin(JenisKelamin.PEREMPUAN);

        DapilDTO dapilDTO2 = new DapilDTO();
        dapilDTO2.setId(UUID.randomUUID());
        dto2.setDapil(dapilDTO2);

        PartaiDTO partaiDTO2 = new PartaiDTO();
        partaiDTO2.setId(UUID.randomUUID());
        dto2.setPartai(partaiDTO2);

        List<CalegDTO> dtoList = Arrays.asList(dto1, dto2);

        // Mock behavior for nested objects
        Dapil dapil1 = new Dapil();
        dapil1.setId(dapilDTO1.getId());
        when(dapilMapper.toEntity(dapilDTO1)).thenReturn(dapil1);

        Dapil dapil2 = new Dapil();
        dapil2.setId(dapilDTO2.getId());
        when(dapilMapper.toEntity(dapilDTO2)).thenReturn(dapil2);

        Partai partai1 = new Partai();
        partai1.setId(partaiDTO1.getId());
        when(partaiMapper.toEntity(partaiDTO1)).thenReturn(partai1);

        Partai partai2 = new Partai();
        partai2.setId(partaiDTO2.getId());
        when(partaiMapper.toEntity(partaiDTO2)).thenReturn(partai2);

        // Act
        List<Caleg> result = calegMapper.toEntityList(dtoList);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());

        assertEquals(id1, result.get(0).getId());
        assertEquals(1, result.get(0).getNomorUrut());
        assertEquals("Caleg Test 1", result.get(0).getNama());
        assertEquals(JenisKelamin.LAKILAKI, result.get(0).getJenisKelamin());
        assertEquals(dapil1, result.get(0).getDapil());
        assertEquals(partai1, result.get(0).getPartai());

        assertEquals(id2, result.get(1).getId());
        assertEquals(2, result.get(1).getNomorUrut());
        assertEquals("Caleg Test 2", result.get(1).getNama());
        assertEquals(JenisKelamin.PEREMPUAN, result.get(1).getJenisKelamin());
        assertEquals(dapil2, result.get(1).getDapil());
        assertEquals(partai2, result.get(1).getPartai());

        verify(dapilMapper).toEntity(dapilDTO1);
        verify(dapilMapper).toEntity(dapilDTO2);
        verify(partaiMapper).toEntity(partaiDTO1);
        verify(partaiMapper).toEntity(partaiDTO2);
    }

    @Test
    void toEntityList_shouldReturnNull_whenDtoListIsNull() {
        // Act
        List<Caleg> result = calegMapper.toEntityList(null);

        // Assert
        assertNull(result);
        verifyNoInteractions(dapilMapper);
        verifyNoInteractions(partaiMapper);
    }
}
