package com.allobank.allobackendtest.service.impl;

import com.allobank.allobackendtest.dto.DapilDTO;
import com.allobank.allobackendtest.mapper.DapilMapper;
import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.repository.DapilRepository;
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

class DapilServiceImplTest {

    @Mock
    private DapilRepository dapilRepository;

    @Mock
    private DapilMapper dapilMapper;

    @InjectMocks
    private DapilServiceImpl dapilService;

    private UUID testId;
    private Dapil testDapil;
    private DapilDTO testDapilDTO;
    private List<Dapil> testDapilList;
    private List<DapilDTO> testDapilDTOList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        testId = UUID.randomUUID();

        testDapil = new Dapil();
        testDapil.setId(testId);
        testDapil.setNamaDapil("Dapil Test");
        testDapil.setProvinsi("Provinsi Test");
        testDapil.setJumlahKursi(10);

        testDapilList = Arrays.asList(testDapil);

        testDapilDTO = new DapilDTO();
        testDapilDTO.setId(testId);
        testDapilDTO.setNamaDapil("Dapil Test");
        testDapilDTO.setProvinsi("Provinsi Test");
        testDapilDTO.setJumlahKursi(10);

        testDapilDTOList = Arrays.asList(testDapilDTO);

        // Setup mapper mock
        when(dapilMapper.toDto(testDapil)).thenReturn(testDapilDTO);
        when(dapilMapper.toDtoList(testDapilList)).thenReturn(testDapilDTOList);
    }

    @Test
    void getDapilById_WhenDapilExists_ShouldReturnDapil() {
        // Arrange
        when(dapilRepository.findById(testId)).thenReturn(Optional.of(testDapil));

        // Act
        DapilDTO result = dapilService.getDapilById(testId);

        // Assert
        assertNotNull(result);
        assertEquals(testDapilDTO, result);
        verify(dapilRepository).findById(testId);
        verify(dapilMapper).toDto(testDapil);
    }

    @Test
    void getDapilById_WhenDapilDoesNotExist_ShouldReturnNull() {
        // Arrange
        UUID nonExistentId = UUID.randomUUID();
        when(dapilRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        // Act
        DapilDTO result = dapilService.getDapilById(nonExistentId);

        // Assert
        assertNull(result);
        verify(dapilRepository).findById(nonExistentId);
    }

    @Test
    void getDapilWithFilters_WithNoFilters_ShouldReturnAllDapil() {
        // Arrange
        when(dapilRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testDapilList);

        // Act
        List<DapilDTO> result = dapilService.getDapilWithFilters(
                null, null, null, "namaDapil", Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testDapilDTOList, result);
        verify(dapilRepository).findAll(any(Specification.class), any(Sort.class));
        verify(dapilMapper).toDtoList(testDapilList);
    }

    @Test
    void getDapilWithFilters_WithNamaDapilFilter_ShouldApplyFilter() {
        // Arrange
        String namaDapil = "Test";
        when(dapilRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testDapilList);

        // Act
        List<DapilDTO> result = dapilService.getDapilWithFilters(
                namaDapil, null, null, "namaDapil", Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testDapilDTOList, result);
        verify(dapilRepository).findAll(any(Specification.class), any(Sort.class));
        verify(dapilMapper).toDtoList(testDapilList);
    }

    @Test
    void getDapilWithFilters_WithProvinsiFilter_ShouldApplyFilter() {
        // Arrange
        String provinsi = "Provinsi";
        when(dapilRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testDapilList);

        // Act
        List<DapilDTO> result = dapilService.getDapilWithFilters(
                null, provinsi, null, "namaDapil", Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testDapilDTOList, result);
        verify(dapilRepository).findAll(any(Specification.class), any(Sort.class));
        verify(dapilMapper).toDtoList(testDapilList);
    }

    @Test
    void getDapilWithFilters_WithJumlahKursiFilter_ShouldApplyFilter() {
        // Arrange
        Integer jumlahKursi = 10;
        when(dapilRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testDapilList);

        // Act
        List<DapilDTO> result = dapilService.getDapilWithFilters(
                null, null, jumlahKursi, "namaDapil", Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testDapilDTOList, result);
        verify(dapilRepository).findAll(any(Specification.class), any(Sort.class));
        verify(dapilMapper).toDtoList(testDapilList);
    }

    @Test
    void getDapilWithFilters_WithAllFilters_ShouldApplyAllFilters() {
        // Arrange
        String namaDapil = "Test";
        String provinsi = "Provinsi";
        Integer jumlahKursi = 10;
        when(dapilRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testDapilList);

        // Act
        List<DapilDTO> result = dapilService.getDapilWithFilters(
                namaDapil, provinsi, jumlahKursi, "namaDapil", Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testDapilDTOList, result);
        verify(dapilRepository).findAll(any(Specification.class), any(Sort.class));
        verify(dapilMapper).toDtoList(testDapilList);
    }

    @Test
    void getDapilWithFilters_WithCustomSorting_ShouldApplyCustomSorting() {
        // Arrange
        String sortBy = "provinsi";
        Sort.Direction sortDirection = Sort.Direction.DESC;
        when(dapilRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testDapilList);

        // Act
        List<DapilDTO> result = dapilService.getDapilWithFilters(
                null, null, null, sortBy, sortDirection);

        // Assert
        assertNotNull(result);
        assertEquals(testDapilDTOList, result);
        verify(dapilRepository).findAll(any(Specification.class), any(Sort.class));
        verify(dapilMapper).toDtoList(testDapilList);
    }

    @Test
    void getDapilWithFilters_WithNullSortBy_ShouldUseDefaultSorting() {
        // Arrange
        when(dapilRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testDapilList);

        // Act
        List<DapilDTO> result = dapilService.getDapilWithFilters(
                null, null, null, null, Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testDapilDTOList, result);
        verify(dapilRepository).findAll(any(Specification.class), any(Sort.class));
        verify(dapilMapper).toDtoList(testDapilList);
    }

    @Test
    void getDapilWithFilters_WithNullSortDirection_ShouldUseDefaultDirection() {
        // Arrange
        when(dapilRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testDapilList);

        // Act
        List<DapilDTO> result = dapilService.getDapilWithFilters(
                null, null, null, "namaDapil", null);

        // Assert
        assertNotNull(result);
        assertEquals(testDapilDTOList, result);
        verify(dapilRepository).findAll(any(Specification.class), any(Sort.class));
        verify(dapilMapper).toDtoList(testDapilList);
    }
}
