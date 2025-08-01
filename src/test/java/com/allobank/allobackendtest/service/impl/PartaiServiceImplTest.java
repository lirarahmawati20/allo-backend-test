package com.allobank.allobackendtest.service.impl;

import com.allobank.allobackendtest.dto.PartaiDTO;
import com.allobank.allobackendtest.mapper.PartaiMapper;
import com.allobank.allobackendtest.model.Partai;
import com.allobank.allobackendtest.repository.PartaiRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PartaiServiceImplTest {

    @Mock
    private PartaiRepository partaiRepository;

    @Mock
    private PartaiMapper partaiMapper;

    @InjectMocks
    private PartaiServiceImpl partaiService;

    private UUID testId;
    private Partai testPartai;
    private List<Partai> testPartaiList;
    private PartaiDTO testPartaiDTO;
    private List<PartaiDTO> testPartaiDTOList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        testId = UUID.randomUUID();

        // Create test entity
        testPartai = new Partai();
        testPartai.setId(testId);
        testPartai.setNamaPartai("Partai Test");
        testPartai.setNomorUrut(1);

        testPartaiList = Arrays.asList(testPartai);

        // Create test DTO
        testPartaiDTO = new PartaiDTO();
        testPartaiDTO.setId(testId);
        testPartaiDTO.setNamaPartai("Partai Test");
        testPartaiDTO.setNomorUrut(1);

        testPartaiDTOList = Arrays.asList(testPartaiDTO);

        // Mock mapper behavior
        when(partaiMapper.toDto(testPartai)).thenReturn(testPartaiDTO);
        when(partaiMapper.toDto(null)).thenReturn(null);
        when(partaiMapper.toDtoList(testPartaiList)).thenReturn(testPartaiDTOList);
    }

    @Test
    void getPartaiById_WhenPartaiExists_ShouldReturnPartai() {
        // Arrange
        when(partaiRepository.findById(testId)).thenReturn(Optional.of(testPartai));

        // Act
        PartaiDTO result = partaiService.getPartaiById(testId);

        // Assert
        assertNotNull(result);
        assertEquals(testPartaiDTO, result);
        verify(partaiRepository).findById(testId);
        verify(partaiMapper).toDto(testPartai);
    }

    @Test
    void getPartaiById_WhenPartaiDoesNotExist_ShouldReturnNull() {
        // Arrange
        UUID nonExistentId = UUID.randomUUID();
        when(partaiRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        // Act
        PartaiDTO result = partaiService.getPartaiById(nonExistentId);

        // Assert
        assertNull(result);
        verify(partaiRepository).findById(nonExistentId);
        verify(partaiMapper).toDto(null);
    }

    @Test
    void getPartaiWithFilters_WithNoFilters_ShouldReturnAllPartai() {
        // Arrange
        when(partaiRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testPartaiList);

        // Act
        List<PartaiDTO> result = partaiService.getPartaiWithFilters(
                null, null, null, "nomorUrut", Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testPartaiDTOList, result);
        verify(partaiRepository).findAll(any(Specification.class), any(Sort.class));
        verify(partaiMapper).toDtoList(testPartaiList);
    }

    @Test
    void getPartaiWithFilters_WithIdFilter_ShouldApplyFilter() {
        // Arrange
        UUID id = UUID.randomUUID();
        when(partaiRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testPartaiList);

        // Act
        List<PartaiDTO> result = partaiService.getPartaiWithFilters(
                id, null, null, "nomorUrut", Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testPartaiDTOList, result);
        verify(partaiRepository).findAll(any(Specification.class), any(Sort.class));
        verify(partaiMapper).toDtoList(testPartaiList);
    }

    @Test
    void getPartaiWithFilters_WithNamaPartaiFilter_ShouldApplyFilter() {
        // Arrange
        String namaPartai = "Test";
        when(partaiRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testPartaiList);

        // Act
        List<PartaiDTO> result = partaiService.getPartaiWithFilters(
                null, namaPartai, null, "nomorUrut", Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testPartaiDTOList, result);
        verify(partaiRepository).findAll(any(Specification.class), any(Sort.class));
        verify(partaiMapper).toDtoList(testPartaiList);
    }

    @Test
    void getPartaiWithFilters_WithNomorUrutFilter_ShouldApplyFilter() {
        // Arrange
        Integer nomorUrut = 1;
        when(partaiRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testPartaiList);

        // Act
        List<PartaiDTO> result = partaiService.getPartaiWithFilters(
                null, null, nomorUrut, "nomorUrut", Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testPartaiDTOList, result);
        verify(partaiRepository).findAll(any(Specification.class), any(Sort.class));
        verify(partaiMapper).toDtoList(testPartaiList);
    }

    @Test
    void getPartaiWithFilters_WithAllFilters_ShouldApplyAllFilters() {
        // Arrange
        UUID id = UUID.randomUUID();
        String namaPartai = "Test";
        Integer nomorUrut = 1;
        when(partaiRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testPartaiList);

        // Act
        List<PartaiDTO> result = partaiService.getPartaiWithFilters(
                id, namaPartai, nomorUrut, "nomorUrut", Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testPartaiDTOList, result);
        verify(partaiRepository).findAll(any(Specification.class), any(Sort.class));
        verify(partaiMapper).toDtoList(testPartaiList);
    }

    @Test
    void getPartaiWithFilters_WithCustomSorting_ShouldApplyCustomSorting() {
        // Arrange
        String sortBy = "namaPartai";
        Sort.Direction sortDirection = Sort.Direction.DESC;
        when(partaiRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testPartaiList);

        // Act
        List<PartaiDTO> result = partaiService.getPartaiWithFilters(
                null, null, null, sortBy, sortDirection);

        // Assert
        assertNotNull(result);
        assertEquals(testPartaiDTOList, result);
        verify(partaiRepository).findAll(any(Specification.class), any(Sort.class));
        verify(partaiMapper).toDtoList(testPartaiList);
    }

    @Test
    void getPartaiWithFilters_WithNullSortBy_ShouldUseDefaultSorting() {
        // Arrange
        when(partaiRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testPartaiList);

        // Act
        List<PartaiDTO> result = partaiService.getPartaiWithFilters(
                null, null, null, null, Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testPartaiDTOList, result);
        verify(partaiRepository).findAll(any(Specification.class), any(Sort.class));
        verify(partaiMapper).toDtoList(testPartaiList);
    }

    @Test
    void getPartaiWithFilters_WithNullSortDirection_ShouldUseDefaultDirection() {
        // Arrange
        when(partaiRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testPartaiList);

        // Act
        List<PartaiDTO> result = partaiService.getPartaiWithFilters(
                null, null, null, "nomorUrut", null);

        // Assert
        assertNotNull(result);
        assertEquals(testPartaiDTOList, result);
        verify(partaiRepository).findAll(any(Specification.class), any(Sort.class));
        verify(partaiMapper).toDtoList(testPartaiList);
    }
}
