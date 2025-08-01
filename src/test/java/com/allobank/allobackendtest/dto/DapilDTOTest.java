package com.allobank.allobackendtest.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DapilDTOTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        DapilDTO dapilDTO = new DapilDTO();
        UUID id = UUID.randomUUID();
        String namaDapil = "Test Dapil";
        String provinsi = "Test Provinsi";
        List<WilayahDapilDTO> wilayahDapilList = new ArrayList<>();
        WilayahDapilDTO wilayahDapil = new WilayahDapilDTO();
        wilayahDapil.setId(UUID.randomUUID());
        wilayahDapil.setNamaWilayah("Test Wilayah");
        wilayahDapilList.add(wilayahDapil);
        int jumlahKursi = 5;

        // Act
        dapilDTO.setId(id);
        dapilDTO.setNamaDapil(namaDapil);
        dapilDTO.setProvinsi(provinsi);
        dapilDTO.setWilayahDapilList(wilayahDapilList);
        dapilDTO.setJumlahKursi(jumlahKursi);

        // Assert
        assertEquals(id, dapilDTO.getId());
        assertEquals(namaDapil, dapilDTO.getNamaDapil());
        assertEquals(provinsi, dapilDTO.getProvinsi());
        assertEquals(wilayahDapilList, dapilDTO.getWilayahDapilList());
        assertEquals(jumlahKursi, dapilDTO.getJumlahKursi());
    }

    @Test
    void testDefaultWilayahDapilList() {
        // Arrange
        DapilDTO dapilDTO = new DapilDTO();

        // Act & Assert
        assertNotNull(dapilDTO.getWilayahDapilList());
        assertTrue(dapilDTO.getWilayahDapilList().isEmpty());
    }

    @Test
    void testAddWilayahDapil() {
        // Arrange
        DapilDTO dapilDTO = new DapilDTO();
        WilayahDapilDTO wilayahDapil = new WilayahDapilDTO();
        wilayahDapil.setId(UUID.randomUUID());
        wilayahDapil.setNamaWilayah("Test Wilayah");

        // Act
        dapilDTO.getWilayahDapilList().add(wilayahDapil);

        // Assert
        assertEquals(1, dapilDTO.getWilayahDapilList().size());
        assertEquals(wilayahDapil, dapilDTO.getWilayahDapilList().get(0));
    }

    @Test
    void testEqualsAndHashCode() {
        // Arrange
        UUID id = UUID.randomUUID();
        String namaDapil = "Test Dapil";
        String provinsi = "Test Provinsi";
        int jumlahKursi = 5;

        DapilDTO dapilDTO1 = new DapilDTO();
        dapilDTO1.setId(id);
        dapilDTO1.setNamaDapil(namaDapil);
        dapilDTO1.setProvinsi(provinsi);
        dapilDTO1.setJumlahKursi(jumlahKursi);

        DapilDTO dapilDTO2 = new DapilDTO();
        dapilDTO2.setId(id);
        dapilDTO2.setNamaDapil(namaDapil);
        dapilDTO2.setProvinsi(provinsi);
        dapilDTO2.setJumlahKursi(jumlahKursi);

        // Act & Assert
        assertEquals(dapilDTO1, dapilDTO2);
        assertEquals(dapilDTO1.hashCode(), dapilDTO2.hashCode());
    }

    @Test
    void testNotEquals() {
        // Arrange
        DapilDTO dapilDTO1 = new DapilDTO();
        dapilDTO1.setId(UUID.randomUUID());
        dapilDTO1.setNamaDapil("Dapil 1");

        DapilDTO dapilDTO2 = new DapilDTO();
        dapilDTO2.setId(UUID.randomUUID());
        dapilDTO2.setNamaDapil("Dapil 2");

        // Act & Assert
        assertNotEquals(dapilDTO1, dapilDTO2);
        assertNotEquals(dapilDTO1.hashCode(), dapilDTO2.hashCode());
    }

    @Test
    void testToString() {
        // Arrange
        DapilDTO dapilDTO = new DapilDTO();
        UUID id = UUID.randomUUID();
        String namaDapil = "Test Dapil";
        
        dapilDTO.setId(id);
        dapilDTO.setNamaDapil(namaDapil);

        // Act
        String toString = dapilDTO.toString();

        // Assert
        assertTrue(toString.contains(id.toString()));
        assertTrue(toString.contains(namaDapil));
    }

    @Test
    void testEqualsWithNull() {
        // Arrange
        DapilDTO dapilDTO = new DapilDTO();
        dapilDTO.setId(UUID.randomUUID());

        // Act & Assert
        assertNotEquals(null, dapilDTO);
    }

    @Test
    void testEqualsWithDifferentClass() {
        // Arrange
        DapilDTO dapilDTO = new DapilDTO();
        dapilDTO.setId(UUID.randomUUID());
        Object object = new Object();

        // Act & Assert
        assertNotEquals(dapilDTO, object);
    }
}