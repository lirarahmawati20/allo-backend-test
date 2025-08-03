package com.allobank.allobackendtest.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DapilTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        Dapil dapil = new Dapil();
        UUID id = UUID.randomUUID();
        String namaDapil = "Test Dapil";
        String provinsi = "Test Provinsi";
        List<WilayahDapil> wilayahDapilList = new ArrayList<>();
        WilayahDapil wilayahDapil = new WilayahDapil();
        wilayahDapil.setId(UUID.randomUUID());
        wilayahDapil.setNamaWilayah("Test Wilayah");
        wilayahDapilList.add(wilayahDapil);
        int jumlahKursi = 5;

        // Act
        dapil.setId(id);
        dapil.setNamaDapil(namaDapil);
        dapil.setProvinsi(provinsi);
        dapil.setWilayahDapilList(wilayahDapilList);
        dapil.setJumlahKursi(jumlahKursi);

        // Assert
        assertEquals(id, dapil.getId());
        assertEquals(namaDapil, dapil.getNamaDapil());
        assertEquals(provinsi, dapil.getProvinsi());
        assertEquals(wilayahDapilList, dapil.getWilayahDapilList());
        assertEquals(jumlahKursi, dapil.getJumlahKursi());
    }

    @Test
    void testEqualsAndHashCode() {
        // Arrange
        UUID id = UUID.randomUUID();
        
        Dapil dapil1 = new Dapil();
        dapil1.setId(id);
        dapil1.setNamaDapil("Test Dapil");
        dapil1.setProvinsi("Test Provinsi");
        dapil1.setJumlahKursi(5);
        
        Dapil dapil2 = new Dapil();
        dapil2.setId(id);
        dapil2.setNamaDapil("Test Dapil");
        dapil2.setProvinsi("Test Provinsi");
        dapil2.setJumlahKursi(5);
        
        Dapil dapil3 = new Dapil();
        dapil3.setId(UUID.randomUUID());
        dapil3.setNamaDapil("Test Dapil");
        dapil3.setProvinsi("Test Provinsi");
        dapil3.setJumlahKursi(5);

        // Assert
        assertEquals(dapil1, dapil2);
        assertEquals(dapil1.hashCode(), dapil2.hashCode());
        assertNotEquals(dapil1, dapil3);
        assertNotEquals(dapil1.hashCode(), dapil3.hashCode());
    }

    @Test
    void testToString() {
        // Arrange
        Dapil dapil = new Dapil();
        UUID id = UUID.randomUUID();
        dapil.setId(id);
        dapil.setNamaDapil("Test Dapil");
        dapil.setProvinsi("Test Provinsi");
        dapil.setJumlahKursi(5);

        // Act
        String toString = dapil.toString();

        // Assert
        assertNotNull(toString);
        assertTrue(toString.contains(id.toString()));
        assertTrue(toString.contains("Test Dapil"));
        assertTrue(toString.contains("Test Provinsi"));
        assertTrue(toString.contains("5"));
    }

    @Test
    void testWilayahDapilListInitialization() {
        // Arrange & Act
        Dapil dapil = new Dapil();

        // Assert
        assertNotNull(dapil.getWilayahDapilList());
        assertTrue(dapil.getWilayahDapilList().isEmpty());
    }

    @Test
    void testAddWilayahDapil() {
        // Arrange
        Dapil dapil = new Dapil();
        WilayahDapil wilayahDapil = new WilayahDapil();
        wilayahDapil.setId(UUID.randomUUID());
        wilayahDapil.setNamaWilayah("Test Wilayah");

        // Act
        dapil.getWilayahDapilList().add(wilayahDapil);

        // Assert
        assertEquals(1, dapil.getWilayahDapilList().size());
        assertEquals(wilayahDapil, dapil.getWilayahDapilList().get(0));
    }
}