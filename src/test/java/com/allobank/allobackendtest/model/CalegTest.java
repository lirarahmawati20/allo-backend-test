package com.allobank.allobackendtest.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CalegTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        Caleg caleg = new Caleg();
        UUID id = UUID.randomUUID();
        Dapil dapil = new Dapil();
        Partai partai = new Partai();
        Integer nomorUrut = 1;
        String nama = "Test Caleg";
        JenisKelamin jenisKelamin = JenisKelamin.LAKILAKI;

        // Act
        caleg.setId(id);
        caleg.setDapil(dapil);
        caleg.setPartai(partai);
        caleg.setNomorUrut(nomorUrut);
        caleg.setNama(nama);
        caleg.setJenisKelamin(jenisKelamin);

        // Assert
        assertEquals(id, caleg.getId());
        assertEquals(dapil, caleg.getDapil());
        assertEquals(partai, caleg.getPartai());
        assertEquals(nomorUrut, caleg.getNomorUrut());
        assertEquals(nama, caleg.getNama());
        assertEquals(jenisKelamin, caleg.getJenisKelamin());
    }

    @Test
    void testEqualsAndHashCode() {
        // Arrange
        UUID id = UUID.randomUUID();
        
        Caleg caleg1 = new Caleg();
        caleg1.setId(id);
        caleg1.setNama("Test Caleg");
        caleg1.setNomorUrut(1);
        caleg1.setJenisKelamin(JenisKelamin.LAKILAKI);
        
        Caleg caleg2 = new Caleg();
        caleg2.setId(id);
        caleg2.setNama("Test Caleg");
        caleg2.setNomorUrut(1);
        caleg2.setJenisKelamin(JenisKelamin.LAKILAKI);
        
        Caleg caleg3 = new Caleg();
        caleg3.setId(UUID.randomUUID());
        caleg3.setNama("Test Caleg");
        caleg3.setNomorUrut(1);
        caleg3.setJenisKelamin(JenisKelamin.LAKILAKI);

        // Assert
        assertEquals(caleg1, caleg2);
        assertEquals(caleg1.hashCode(), caleg2.hashCode());
        assertNotEquals(caleg1, caleg3);
        assertNotEquals(caleg1.hashCode(), caleg3.hashCode());
    }

    @Test
    void testToString() {
        // Arrange
        Caleg caleg = new Caleg();
        UUID id = UUID.randomUUID();
        caleg.setId(id);
        caleg.setNama("Test Caleg");
        caleg.setNomorUrut(1);
        caleg.setJenisKelamin(JenisKelamin.LAKILAKI);

        // Act
        String toString = caleg.toString();

        // Assert
        assertNotNull(toString);
        assertTrue(toString.contains(id.toString()));
        assertTrue(toString.contains("Test Caleg"));
        assertTrue(toString.contains("1"));
        assertTrue(toString.contains("LAKILAKI"));
    }

    @Test
    void testBuilder() {
        // Arrange
        UUID id = UUID.randomUUID();
        Dapil dapil = new Dapil();
        Partai partai = new Partai();
        Integer nomorUrut = 1;
        String nama = "Test Caleg";
        JenisKelamin jenisKelamin = JenisKelamin.LAKILAKI;

        // Act
        Caleg caleg = new Caleg();
        caleg.setId(id);
        caleg.setDapil(dapil);
        caleg.setPartai(partai);
        caleg.setNomorUrut(nomorUrut);
        caleg.setNama(nama);
        caleg.setJenisKelamin(jenisKelamin);

        // Assert
        assertEquals(id, caleg.getId());
        assertEquals(dapil, caleg.getDapil());
        assertEquals(partai, caleg.getPartai());
        assertEquals(nomorUrut, caleg.getNomorUrut());
        assertEquals(nama, caleg.getNama());
        assertEquals(jenisKelamin, caleg.getJenisKelamin());
    }
}