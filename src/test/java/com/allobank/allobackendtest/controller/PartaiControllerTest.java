package com.allobank.allobackendtest.controller;

import com.allobank.allobackendtest.dto.PartaiDTO;
import com.allobank.allobackendtest.service.PartaiService;
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

class PartaiControllerTest {

    @Mock
    private PartaiService partaiService;

    @InjectMocks
    private PartaiController partaiController;

    private UUID testId;
    private PartaiDTO testPartai;
    private List<PartaiDTO> testPartaiList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        testId = UUID.randomUUID();

        testPartai = new PartaiDTO();
        testPartai.setId(testId);
        testPartai.setNamaPartai("Partai Test");
        testPartai.setNomorUrut(1);

        testPartaiList = Arrays.asList(testPartai);
    }

    @Test
    void getPartai_ShouldReturnPartaiList() {
        // Arrange
        UUID id = UUID.randomUUID();
        String namaPartai = "Test";
        Integer nomorUrut = 1;
        String sortBy = "nomorUrut";
        Sort.Direction sortDirection = Sort.Direction.ASC;

        when(partaiService.getPartaiWithFilters(id, namaPartai, nomorUrut, sortBy, sortDirection))
                .thenReturn(testPartaiList);

        // Act
        ResponseEntity<List<PartaiDTO>> response = partaiController.getPartai(
                id, namaPartai, nomorUrut, sortBy, sortDirection);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testPartaiList, response.getBody());
        verify(partaiService).getPartaiWithFilters(id, namaPartai, nomorUrut, sortBy, sortDirection);
    }

    @Test
    void getPartaiById_WhenPartaiExists_ShouldReturnPartai() {
        // Arrange
        when(partaiService.getPartaiById(testId)).thenReturn(testPartai);

        // Act
        ResponseEntity<PartaiDTO> response = partaiController.getPartaiById(testId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testPartai, response.getBody());
        verify(partaiService).getPartaiById(testId);
    }

    @Test
    void getPartaiById_WhenPartaiDoesNotExist_ShouldReturnNotFound() {
        // Arrange
        UUID nonExistentId = UUID.randomUUID();
        when(partaiService.getPartaiById(nonExistentId)).thenReturn(null);

        // Act
        ResponseEntity<PartaiDTO> response = partaiController.getPartaiById(nonExistentId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(partaiService).getPartaiById(nonExistentId);
    }
}
