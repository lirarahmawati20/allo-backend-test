package com.allobank.allobackendtest.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PartaiTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        Partai partai = new Partai();
        UUID id = UUID.randomUUID();
        String namaPartai = "Test Partai";
        Integer nomorUrut = 1;

        // Act
        partai.setId(id);
        partai.setNamaPartai(namaPartai);
        partai.setNomorUrut(nomorUrut);

        // Assert
        assertEquals(id, partai.getId());
        assertEquals(namaPartai, partai.getNamaPartai());
        assertEquals(nomorUrut, partai.getNomorUrut());
    }

    @Test
    void testEqualsAndHashCode() {
        // Arrange
        UUID id = UUID.randomUUID();
        
        Partai partai1 = new Partai();
        partai1.setId(id);
        partai1.setNamaPartai("Test Partai");
        partai1.setNomorUrut(1);
        
        Partai partai2 = new Partai();
        partai2.setId(id);
        partai2.setNamaPartai("Test Partai");
        partai2.setNomorUrut(1);
        
        Partai partai3 = new Partai();
        partai3.setId(UUID.randomUUID());
        partai3.setNamaPartai("Test Partai");
        partai3.setNomorUrut(1);

        // Assert
        assertEquals(partai1, partai2);
        assertEquals(partai1.hashCode(), partai2.hashCode());
        assertNotEquals(partai1, partai3);
        assertNotEquals(partai1.hashCode(), partai3.hashCode());
    }

    @Test
    void testToString() {
        // Arrange
        Partai partai = new Partai();
        UUID id = UUID.randomUUID();
        partai.setId(id);
        partai.setNamaPartai("Test Partai");
        partai.setNomorUrut(1);

        // Act
        String toString = partai.toString();

        // Assert
        assertNotNull(toString);
        assertTrue(toString.contains(id.toString()));
        assertTrue(toString.contains("Test Partai"));
        assertTrue(toString.contains("1"));
    }

    @Test
    void testNullValues() {
        // Arrange
        Partai partai = new Partai();

        // Assert
        assertNull(partai.getId());
        assertNull(partai.getNamaPartai());
        assertNull(partai.getNomorUrut());
    }

    @Test
    void testWithDifferentNomorUrut() {
        // Arrange
        Partai partai1 = new Partai();
        partai1.setId(UUID.randomUUID());
        partai1.setNamaPartai("Test Partai");
        partai1.setNomorUrut(1);
        
        Partai partai2 = new Partai();
        partai2.setId(UUID.randomUUID());
        partai2.setNamaPartai("Test Partai");
        partai2.setNomorUrut(2);

        // Assert
        assertNotEquals(partai1, partai2);
        assertNotEquals(partai1.hashCode(), partai2.hashCode());
        assertNotEquals(partai1.getNomorUrut(), partai2.getNomorUrut());
    }
}