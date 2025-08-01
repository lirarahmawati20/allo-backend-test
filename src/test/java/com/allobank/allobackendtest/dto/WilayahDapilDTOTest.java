package com.allobank.allobackendtest.dto;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class WilayahDapilDTOTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        WilayahDapilDTO wilayahDapilDTO = new WilayahDapilDTO();
        UUID id = UUID.randomUUID();
        UUID dapilId = UUID.randomUUID();
        String namaWilayah = "Test Wilayah";

        // Act
        wilayahDapilDTO.setId(id);
        wilayahDapilDTO.setDapilId(dapilId);
        wilayahDapilDTO.setNamaWilayah(namaWilayah);

        // Assert
        assertEquals(id, wilayahDapilDTO.getId());
        assertEquals(dapilId, wilayahDapilDTO.getDapilId());
        assertEquals(namaWilayah, wilayahDapilDTO.getNamaWilayah());
    }

    @Test
    void testEqualsAndHashCode() {
        // Arrange
        UUID id = UUID.randomUUID();
        UUID dapilId = UUID.randomUUID();
        String namaWilayah = "Test Wilayah";

        WilayahDapilDTO wilayahDapilDTO1 = new WilayahDapilDTO();
        wilayahDapilDTO1.setId(id);
        wilayahDapilDTO1.setDapilId(dapilId);
        wilayahDapilDTO1.setNamaWilayah(namaWilayah);

        WilayahDapilDTO wilayahDapilDTO2 = new WilayahDapilDTO();
        wilayahDapilDTO2.setId(id);
        wilayahDapilDTO2.setDapilId(dapilId);
        wilayahDapilDTO2.setNamaWilayah(namaWilayah);

        // Act & Assert
        assertEquals(wilayahDapilDTO1, wilayahDapilDTO2);
        assertEquals(wilayahDapilDTO1.hashCode(), wilayahDapilDTO2.hashCode());
    }

    @Test
    void testNotEquals() {
        // Arrange
        WilayahDapilDTO wilayahDapilDTO1 = new WilayahDapilDTO();
        wilayahDapilDTO1.setId(UUID.randomUUID());
        wilayahDapilDTO1.setDapilId(UUID.randomUUID());
        wilayahDapilDTO1.setNamaWilayah("Wilayah 1");

        WilayahDapilDTO wilayahDapilDTO2 = new WilayahDapilDTO();
        wilayahDapilDTO2.setId(UUID.randomUUID());
        wilayahDapilDTO2.setDapilId(UUID.randomUUID());
        wilayahDapilDTO2.setNamaWilayah("Wilayah 2");

        // Act & Assert
        assertNotEquals(wilayahDapilDTO1, wilayahDapilDTO2);
        assertNotEquals(wilayahDapilDTO1.hashCode(), wilayahDapilDTO2.hashCode());
    }

    @Test
    void testToString() {
        // Arrange
        WilayahDapilDTO wilayahDapilDTO = new WilayahDapilDTO();
        UUID id = UUID.randomUUID();
        UUID dapilId = UUID.randomUUID();
        String namaWilayah = "Test Wilayah";
        
        wilayahDapilDTO.setId(id);
        wilayahDapilDTO.setDapilId(dapilId);
        wilayahDapilDTO.setNamaWilayah(namaWilayah);

        // Act
        String toString = wilayahDapilDTO.toString();

        // Assert
        assertTrue(toString.contains(id.toString()));
        assertTrue(toString.contains(dapilId.toString()));
        assertTrue(toString.contains(namaWilayah));
    }

    @Test
    void testEqualsWithNull() {
        // Arrange
        WilayahDapilDTO wilayahDapilDTO = new WilayahDapilDTO();
        wilayahDapilDTO.setId(UUID.randomUUID());

        // Act & Assert
        assertNotEquals(null, wilayahDapilDTO);
    }

    @Test
    void testEqualsWithDifferentClass() {
        // Arrange
        WilayahDapilDTO wilayahDapilDTO = new WilayahDapilDTO();
        wilayahDapilDTO.setId(UUID.randomUUID());
        Object object = new Object();

        // Act & Assert
        assertNotEquals(wilayahDapilDTO, object);
    }
}