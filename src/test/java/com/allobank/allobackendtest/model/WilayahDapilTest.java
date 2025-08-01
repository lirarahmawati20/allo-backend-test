package com.allobank.allobackendtest.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class WilayahDapilTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        WilayahDapil wilayahDapil = new WilayahDapil();
        UUID id = UUID.randomUUID();
        UUID dapilId = UUID.randomUUID();
        String namaWilayah = "Test Wilayah";

        // Act
        wilayahDapil.setId(id);
        wilayahDapil.setDapilId(dapilId);
        wilayahDapil.setNamaWilayah(namaWilayah);

        // Assert
        assertEquals(id, wilayahDapil.getId());
        assertEquals(dapilId, wilayahDapil.getDapilId());
        assertEquals(namaWilayah, wilayahDapil.getNamaWilayah());
    }

    @Test
    void testEqualsAndHashCode() {
        // Arrange
        UUID id = UUID.randomUUID();
        UUID dapilId = UUID.randomUUID();
        
        WilayahDapil wilayahDapil1 = new WilayahDapil();
        wilayahDapil1.setId(id);
        wilayahDapil1.setDapilId(dapilId);
        wilayahDapil1.setNamaWilayah("Test Wilayah");
        
        WilayahDapil wilayahDapil2 = new WilayahDapil();
        wilayahDapil2.setId(id);
        wilayahDapil2.setDapilId(dapilId);
        wilayahDapil2.setNamaWilayah("Test Wilayah");
        
        WilayahDapil wilayahDapil3 = new WilayahDapil();
        wilayahDapil3.setId(UUID.randomUUID());
        wilayahDapil3.setDapilId(dapilId);
        wilayahDapil3.setNamaWilayah("Test Wilayah");

        // Assert
        assertEquals(wilayahDapil1, wilayahDapil2);
        assertEquals(wilayahDapil1.hashCode(), wilayahDapil2.hashCode());
        assertNotEquals(wilayahDapil1, wilayahDapil3);
        assertNotEquals(wilayahDapil1.hashCode(), wilayahDapil3.hashCode());
    }

    @Test
    void testToString() {
        // Arrange
        WilayahDapil wilayahDapil = new WilayahDapil();
        UUID id = UUID.randomUUID();
        UUID dapilId = UUID.randomUUID();
        wilayahDapil.setId(id);
        wilayahDapil.setDapilId(dapilId);
        wilayahDapil.setNamaWilayah("Test Wilayah");

        // Act
        String toString = wilayahDapil.toString();

        // Assert
        assertNotNull(toString);
        assertTrue(toString.contains(id.toString()));
        assertTrue(toString.contains(dapilId.toString()));
        assertTrue(toString.contains("Test Wilayah"));
    }

    @Test
    void testNullValues() {
        // Arrange
        WilayahDapil wilayahDapil = new WilayahDapil();

        // Assert
        assertNull(wilayahDapil.getId());
        assertNull(wilayahDapil.getDapilId());
        assertNull(wilayahDapil.getNamaWilayah());
    }

    @Test
    void testWithDifferentDapilId() {
        // Arrange
        UUID id1 = UUID.randomUUID();
        UUID dapilId1 = UUID.randomUUID();
        UUID dapilId2 = UUID.randomUUID();
        
        WilayahDapil wilayahDapil1 = new WilayahDapil();
        wilayahDapil1.setId(id1);
        wilayahDapil1.setDapilId(dapilId1);
        wilayahDapil1.setNamaWilayah("Test Wilayah");
        
        WilayahDapil wilayahDapil2 = new WilayahDapil();
        wilayahDapil2.setId(id1);
        wilayahDapil2.setDapilId(dapilId2);
        wilayahDapil2.setNamaWilayah("Test Wilayah");

        // Assert
        assertNotEquals(wilayahDapil1.getDapilId(), wilayahDapil2.getDapilId());
    }
}