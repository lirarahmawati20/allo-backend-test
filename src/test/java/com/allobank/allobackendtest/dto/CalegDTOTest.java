package com.allobank.allobackendtest.dto;

import com.allobank.allobackendtest.model.JenisKelamin;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CalegDTOTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        CalegDTO calegDTO = new CalegDTO();
        UUID id = UUID.randomUUID();
        DapilDTO dapil = new DapilDTO();
        PartaiDTO partai = new PartaiDTO();
        Integer nomorUrut = 1;
        String nama = "Test Caleg";
        JenisKelamin jenisKelamin = JenisKelamin.LAKILAKI;

        // Act
        calegDTO.setId(id);
        calegDTO.setDapil(dapil);
        calegDTO.setPartai(partai);
        calegDTO.setNomorUrut(nomorUrut);
        calegDTO.setNama(nama);
        calegDTO.setJenisKelamin(jenisKelamin);

        // Assert
        assertEquals(id, calegDTO.getId());
        assertEquals(dapil, calegDTO.getDapil());
        assertEquals(partai, calegDTO.getPartai());
        assertEquals(nomorUrut, calegDTO.getNomorUrut());
        assertEquals(nama, calegDTO.getNama());
        assertEquals(jenisKelamin, calegDTO.getJenisKelamin());
    }

    @Test
    void testEqualsAndHashCode() {
        // Arrange
        UUID id = UUID.randomUUID();
        DapilDTO dapil = new DapilDTO();
        PartaiDTO partai = new PartaiDTO();
        Integer nomorUrut = 1;
        String nama = "Test Caleg";
        JenisKelamin jenisKelamin = JenisKelamin.LAKILAKI;

        CalegDTO calegDTO1 = new CalegDTO();
        calegDTO1.setId(id);
        calegDTO1.setDapil(dapil);
        calegDTO1.setPartai(partai);
        calegDTO1.setNomorUrut(nomorUrut);
        calegDTO1.setNama(nama);
        calegDTO1.setJenisKelamin(jenisKelamin);

        CalegDTO calegDTO2 = new CalegDTO();
        calegDTO2.setId(id);
        calegDTO2.setDapil(dapil);
        calegDTO2.setPartai(partai);
        calegDTO2.setNomorUrut(nomorUrut);
        calegDTO2.setNama(nama);
        calegDTO2.setJenisKelamin(jenisKelamin);

        // Act & Assert
        assertEquals(calegDTO1, calegDTO2);
        assertEquals(calegDTO1.hashCode(), calegDTO2.hashCode());
    }

    @Test
    void testNotEquals() {
        // Arrange
        CalegDTO calegDTO1 = new CalegDTO();
        calegDTO1.setId(UUID.randomUUID());
        calegDTO1.setNama("Caleg 1");

        CalegDTO calegDTO2 = new CalegDTO();
        calegDTO2.setId(UUID.randomUUID());
        calegDTO2.setNama("Caleg 2");

        // Act & Assert
        assertNotEquals(calegDTO1, calegDTO2);
        assertNotEquals(calegDTO1.hashCode(), calegDTO2.hashCode());
    }

    @Test
    void testToString() {
        // Arrange
        CalegDTO calegDTO = new CalegDTO();
        UUID id = UUID.randomUUID();
        String nama = "Test Caleg";
        
        calegDTO.setId(id);
        calegDTO.setNama(nama);

        // Act
        String toString = calegDTO.toString();

        // Assert
        assertTrue(toString.contains(id.toString()));
        assertTrue(toString.contains(nama));
    }

    @Test
    void testEqualsWithNull() {
        // Arrange
        CalegDTO calegDTO = new CalegDTO();
        calegDTO.setId(UUID.randomUUID());

        // Act & Assert
        assertNotEquals(null, calegDTO);
    }

    @Test
    void testEqualsWithDifferentClass() {
        // Arrange
        CalegDTO calegDTO = new CalegDTO();
        calegDTO.setId(UUID.randomUUID());
        Object object = new Object();

        // Act & Assert
        assertNotEquals(calegDTO, object);
    }
}