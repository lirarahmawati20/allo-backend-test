package com.allobank.allobackendtest.controller;

import com.allobank.allobackendtest.dto.DapilDTO;
import com.allobank.allobackendtest.service.DapilService;
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

class DapilControllerTest {

    @Mock
    private DapilService dapilService;

    @InjectMocks
    private DapilController dapilController;

    private UUID testId;
    private DapilDTO testDapil;
    private List<DapilDTO> testDapilList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        testId = UUID.randomUUID();

        testDapil = new DapilDTO();
        testDapil.setId(testId);
        testDapil.setNamaDapil("Dapil Test");
        testDapil.setProvinsi("Provinsi Test");
        testDapil.setJumlahKursi(10);

        testDapilList = Arrays.asList(testDapil);
    }

    @Test
    void getDapil_ShouldReturnDapilList() {
        // Arrange
        String namaDapil = "Test";
        String provinsi = "Provinsi";
        Integer jumlahKursi = 10;
        String sortBy = "namaDapil";
        Sort.Direction sortDirection = Sort.Direction.ASC;

        when(dapilService.getDapilWithFilters(namaDapil, provinsi, jumlahKursi, sortBy, sortDirection))
                .thenReturn(testDapilList);

        // Act
        ResponseEntity<List<DapilDTO>> response = dapilController.getDapil(
                namaDapil, provinsi, jumlahKursi, sortBy, sortDirection);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testDapilList, response.getBody());
        verify(dapilService).getDapilWithFilters(namaDapil, provinsi, jumlahKursi, sortBy, sortDirection);
    }

    @Test
    void getDapilById_WhenDapilExists_ShouldReturnDapil() {
        // Arrange
        when(dapilService.getDapilById(testId)).thenReturn(testDapil);

        // Act
        ResponseEntity<DapilDTO> response = dapilController.getDapilById(testId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testDapil, response.getBody());
        verify(dapilService).getDapilById(testId);
    }

    @Test
    void getDapilById_WhenDapilDoesNotExist_ShouldReturnNotFound() {
        // Arrange
        UUID nonExistentId = UUID.randomUUID();
        when(dapilService.getDapilById(nonExistentId)).thenReturn(null);

        // Act
        ResponseEntity<DapilDTO> response = dapilController.getDapilById(nonExistentId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(dapilService).getDapilById(nonExistentId);
    }
}
