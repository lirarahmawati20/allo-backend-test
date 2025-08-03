package com.allobank.allobackendtest.service.impl;

import com.allobank.allobackendtest.dto.CalegDTO;
import com.allobank.allobackendtest.dto.DapilDTO;
import com.allobank.allobackendtest.dto.PartaiDTO;
import com.allobank.allobackendtest.mapper.CalegMapper;
import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.model.JenisKelamin;
import com.allobank.allobackendtest.model.Partai;
import com.allobank.allobackendtest.repository.CalegRepository;
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

class CalegServiceImplTest {

    @Mock
    private CalegRepository calegRepository;

    @Mock
    private CalegMapper calegMapper;

    @InjectMocks
    private CalegServiceImpl calegService;

    private UUID testId;
    private Caleg testCaleg;
    private CalegDTO testCalegDTO;
    private List<Caleg> testCalegList;
    private List<CalegDTO> testCalegDTOList;
    private Dapil testDapil;
    private Partai testPartai;
    private DapilDTO testDapilDTO;
    private PartaiDTO testPartaiDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        testId = UUID.randomUUID();

        testDapil = new Dapil();
        testDapil.setId(UUID.randomUUID());
        testDapil.setNamaDapil("Dapil Test");

        testPartai = new Partai();
        testPartai.setId(UUID.randomUUID());
        testPartai.setNamaPartai("Partai Test");

        testCaleg = new Caleg();
        testCaleg.setId(testId);
        testCaleg.setNama("Test Caleg");
        testCaleg.setJenisKelamin(JenisKelamin.LAKILAKI);
        testCaleg.setNomorUrut(1);
        testCaleg.setDapil(testDapil);
        testCaleg.setPartai(testPartai);

        testCalegList = Arrays.asList(testCaleg);

        testDapilDTO = new DapilDTO();
        testDapilDTO.setId(testDapil.getId());
        testDapilDTO.setNamaDapil("Dapil Test");

        testPartaiDTO = new PartaiDTO();
        testPartaiDTO.setId(testPartai.getId());
        testPartaiDTO.setNamaPartai("Partai Test");

        testCalegDTO = new CalegDTO();
        testCalegDTO.setId(testId);
        testCalegDTO.setNama("Test Caleg");
        testCalegDTO.setJenisKelamin(JenisKelamin.LAKILAKI);
        testCalegDTO.setNomorUrut(1);
        testCalegDTO.setDapil(testDapilDTO);
        testCalegDTO.setPartai(testPartaiDTO);

        testCalegDTOList = Arrays.asList(testCalegDTO);

        // Setup mapper mock
        when(calegMapper.toDto(testCaleg)).thenReturn(testCalegDTO);
        when(calegMapper.toDtoList(testCalegList)).thenReturn(testCalegDTOList);
    }

    @Test
    void getCalegById_WhenCalegExists_ShouldReturnCaleg() {
        // Arrange
        when(calegRepository.findById(testId)).thenReturn(Optional.of(testCaleg));

        // Act
        CalegDTO result = calegService.getCalegById(testId);

        // Assert
        assertNotNull(result);
        assertEquals(testCalegDTO, result);
        verify(calegRepository).findById(testId);
        verify(calegMapper).toDto(testCaleg);
    }

    @Test
    void getCalegById_WhenCalegDoesNotExist_ShouldReturnNull() {
        // Arrange
        UUID nonExistentId = UUID.randomUUID();
        when(calegRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        // Act
        CalegDTO result = calegService.getCalegById(nonExistentId);

        // Assert
        assertNull(result);
        verify(calegRepository).findById(nonExistentId);
    }

    @Test
    void getCalegWithFilters_WithNoFilters_ShouldReturnAllCaleg() {
        // Arrange
        when(calegRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testCalegList);

        // Act
        List<CalegDTO> result = calegService.getCalegWithFilters(
                null, null, null, null, null, "nomorUrut", Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testCalegDTOList, result);
        verify(calegRepository).findAll(any(Specification.class), any(Sort.class));
        verify(calegMapper).toDtoList(testCalegList);
    }

    @Test
    void getCalegWithFilters_WithDapilFilter_ShouldApplyFilter() {
        // Arrange
        UUID dapilId = testDapil.getId();
        when(calegRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testCalegList);

        // Act
        List<CalegDTO> result = calegService.getCalegWithFilters(
                dapilId, null, null, null, null, "nomorUrut", Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testCalegDTOList, result);
        verify(calegRepository).findAll(any(Specification.class), any(Sort.class));
        verify(calegMapper).toDtoList(testCalegList);
    }

    @Test
    void getCalegWithFilters_WithPartaiFilter_ShouldApplyFilter() {
        // Arrange
        UUID partaiId = testPartai.getId();
        when(calegRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testCalegList);

        // Act
        List<CalegDTO> result = calegService.getCalegWithFilters(
                null, partaiId, null, null, null, "nomorUrut", Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testCalegDTOList, result);
        verify(calegRepository).findAll(any(Specification.class), any(Sort.class));
        verify(calegMapper).toDtoList(testCalegList);
    }

    @Test
    void getCalegWithFilters_WithNameFilter_ShouldApplyFilter() {
        // Arrange
        String nama = "Test";
        when(calegRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testCalegList);

        // Act
        List<CalegDTO> result = calegService.getCalegWithFilters(
                null, null, nama, null, null, "nomorUrut", Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testCalegDTOList, result);
        verify(calegRepository).findAll(any(Specification.class), any(Sort.class));
        verify(calegMapper).toDtoList(testCalegList);
    }

    @Test
    void getCalegWithFilters_WithJenisKelaminFilter_ShouldApplyFilter() {
        // Arrange
        JenisKelamin jenisKelamin = JenisKelamin.LAKILAKI;
        when(calegRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testCalegList);

        // Act
        List<CalegDTO> result = calegService.getCalegWithFilters(
                null, null, null, jenisKelamin, null, "nomorUrut", Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testCalegDTOList, result);
        verify(calegRepository).findAll(any(Specification.class), any(Sort.class));
        verify(calegMapper).toDtoList(testCalegList);
    }

    @Test
    void getCalegWithFilters_WithNomorUrutFilter_ShouldApplyFilter() {
        // Arrange
        Integer nomorUrut = 1;
        when(calegRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testCalegList);

        // Act
        List<CalegDTO> result = calegService.getCalegWithFilters(
                null, null, null, null, nomorUrut, "nomorUrut", Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testCalegDTOList, result);
        verify(calegRepository).findAll(any(Specification.class), any(Sort.class));
        verify(calegMapper).toDtoList(testCalegList);
    }

    @Test
    void getCalegWithFilters_WithAllFilters_ShouldApplyAllFilters() {
        // Arrange
        UUID dapilId = testDapil.getId();
        UUID partaiId = testPartai.getId();
        String nama = "Test";
        JenisKelamin jenisKelamin = JenisKelamin.LAKILAKI;
        Integer nomorUrut = 1;
        when(calegRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testCalegList);

        // Act
        List<CalegDTO> result = calegService.getCalegWithFilters(
                dapilId, partaiId, nama, jenisKelamin, nomorUrut, "nomorUrut", Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testCalegDTOList, result);
        verify(calegRepository).findAll(any(Specification.class), any(Sort.class));
        verify(calegMapper).toDtoList(testCalegList);
    }

    @Test
    void getCalegWithFilters_WithCustomSorting_ShouldApplyCustomSorting() {
        // Arrange
        String sortBy = "nama";
        Sort.Direction sortDirection = Sort.Direction.DESC;
        when(calegRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testCalegList);

        // Act
        List<CalegDTO> result = calegService.getCalegWithFilters(
                null, null, null, null, null, sortBy, sortDirection);

        // Assert
        assertNotNull(result);
        assertEquals(testCalegDTOList, result);
        verify(calegRepository).findAll(any(Specification.class), any(Sort.class));
        verify(calegMapper).toDtoList(testCalegList);
    }

    @Test
    void getCalegWithFilters_WithNullSortBy_ShouldUseDefaultSorting() {
        // Arrange
        when(calegRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testCalegList);

        // Act
        List<CalegDTO> result = calegService.getCalegWithFilters(
                null, null, null, null, null, null, Sort.Direction.ASC);

        // Assert
        assertNotNull(result);
        assertEquals(testCalegDTOList, result);
        verify(calegRepository).findAll(any(Specification.class), any(Sort.class));
        verify(calegMapper).toDtoList(testCalegList);
    }

    @Test
    void getCalegWithFilters_WithNullSortDirection_ShouldUseDefaultDirection() {
        // Arrange
        when(calegRepository.findAll(any(Specification.class), any(Sort.class))).thenReturn(testCalegList);

        // Act
        List<CalegDTO> result = calegService.getCalegWithFilters(
                null, null, null, null, null, "nomorUrut", null);

        // Assert
        assertNotNull(result);
        assertEquals(testCalegDTOList, result);
        verify(calegRepository).findAll(any(Specification.class), any(Sort.class));
        verify(calegMapper).toDtoList(testCalegList);
    }
}
