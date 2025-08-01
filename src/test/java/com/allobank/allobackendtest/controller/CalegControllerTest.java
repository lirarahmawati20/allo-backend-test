package com.allobank.allobackendtest.controller;

import com.allobank.allobackendtest.dto.CalegDTO;
import com.allobank.allobackendtest.dto.DapilDTO;
import com.allobank.allobackendtest.dto.PartaiDTO;
import com.allobank.allobackendtest.model.JenisKelamin;
import com.allobank.allobackendtest.service.CalegService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalegControllerTest {

    @Mock
    private CalegService calegService;

    @InjectMocks
    private CalegController calegController;

    private UUID testId;
    private CalegDTO testCaleg;
    private List<CalegDTO> testCalegList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        testId = UUID.randomUUID();

        DapilDTO dapil = new DapilDTO();
        dapil.setId(UUID.randomUUID());
        dapil.setNamaDapil("Dapil Test");

        PartaiDTO partai = new PartaiDTO();
        partai.setId(UUID.randomUUID());
        partai.setNamaPartai("Partai Test");

        testCaleg = new CalegDTO();
        testCaleg.setId(testId);
        testCaleg.setNama("Test Caleg");
        testCaleg.setJenisKelamin(JenisKelamin.LAKILAKI);
        testCaleg.setNomorUrut(1);
        testCaleg.setDapil(dapil);
        testCaleg.setPartai(partai);

        testCalegList = Arrays.asList(testCaleg);
    }

    @Test
    void getCaleg_ShouldReturnCalegList() {
        // Arrange
        UUID dapilId = UUID.randomUUID();
        UUID partaiId = UUID.randomUUID();
        String nama = "Test";
        JenisKelamin jenisKelamin = JenisKelamin.LAKILAKI;
        Integer nomorUrut = 1;
        String sortBy = "nomorUrut";
        Sort.Direction sortDirection = Sort.Direction.ASC;

        when(calegService.getCalegWithFilters(dapilId, partaiId, nama, jenisKelamin, nomorUrut, sortBy, sortDirection))
                .thenReturn(testCalegList);

        // Act
        ResponseEntity<List<CalegDTO>> response = calegController.getCaleg(
                dapilId, partaiId, nama, jenisKelamin, nomorUrut, sortBy, sortDirection);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testCalegList, response.getBody());
        verify(calegService).getCalegWithFilters(dapilId, partaiId, nama, jenisKelamin, nomorUrut, sortBy, sortDirection);
    }

    @Test
    void getCalegById_WhenCalegExists_ShouldReturnCaleg() {
        // Arrange
        when(calegService.getCalegById(testId)).thenReturn(testCaleg);

        // Act
        ResponseEntity<CalegDTO> response = calegController.getCalegById(testId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testCaleg, response.getBody());
        verify(calegService).getCalegById(testId);
    }

    @Test
    void getCalegById_WhenCalegDoesNotExist_ShouldReturnNotFound() {
        // Arrange
        UUID nonExistentId = UUID.randomUUID();
        when(calegService.getCalegById(nonExistentId)).thenReturn(null);

        // Act
        ResponseEntity<CalegDTO> response = calegController.getCalegById(nonExistentId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(calegService).getCalegById(nonExistentId);
    }
}
