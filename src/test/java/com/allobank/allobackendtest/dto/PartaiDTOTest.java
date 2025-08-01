package com.allobank.allobackendtest.dto;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PartaiDTOTest {

    @Test
    void testGettersAndSetters() {
        // Arrange
        PartaiDTO partaiDTO = new PartaiDTO();
        UUID id = UUID.randomUUID();
        String namaPartai = "Test Partai";
        Integer nomorUrut = 1;

        // Act
        partaiDTO.setId(id);
        partaiDTO.setNamaPartai(namaPartai);
        partaiDTO.setNomorUrut(nomorUrut);

        // Assert
        assertEquals(id, partaiDTO.getId());
        assertEquals(namaPartai, partaiDTO.getNamaPartai());
        assertEquals(nomorUrut, partaiDTO.getNomorUrut());
    }

    @Test
    void testEqualsAndHashCode() {
        // Arrange
        UUID id = UUID.randomUUID();
        String namaPartai = "Test Partai";
        Integer nomorUrut = 1;

        PartaiDTO partaiDTO1 = new PartaiDTO();
        partaiDTO1.setId(id);
        partaiDTO1.setNamaPartai(namaPartai);
        partaiDTO1.setNomorUrut(nomorUrut);

        PartaiDTO partaiDTO2 = new PartaiDTO();
        partaiDTO2.setId(id);
        partaiDTO2.setNamaPartai(namaPartai);
        partaiDTO2.setNomorUrut(nomorUrut);

        // Act & Assert
        assertEquals(partaiDTO1, partaiDTO2);
        assertEquals(partaiDTO1.hashCode(), partaiDTO2.hashCode());
    }

    @Test
    void testNotEquals() {
        // Arrange
        PartaiDTO partaiDTO1 = new PartaiDTO();
        partaiDTO1.setId(UUID.randomUUID());
        partaiDTO1.setNamaPartai("Partai 1");
        partaiDTO1.setNomorUrut(1);

        PartaiDTO partaiDTO2 = new PartaiDTO();
        partaiDTO2.setId(UUID.randomUUID());
        partaiDTO2.setNamaPartai("Partai 2");
        partaiDTO2.setNomorUrut(2);

        // Act & Assert
        assertNotEquals(partaiDTO1, partaiDTO2);
        assertNotEquals(partaiDTO1.hashCode(), partaiDTO2.hashCode());
    }

    @Test
    void testToString() {
        // Arrange
        PartaiDTO partaiDTO = new PartaiDTO();
        UUID id = UUID.randomUUID();
        String namaPartai = "Test Partai";
        Integer nomorUrut = 1;
        
        partaiDTO.setId(id);
        partaiDTO.setNamaPartai(namaPartai);
        partaiDTO.setNomorUrut(nomorUrut);

        // Act
        String toString = partaiDTO.toString();

        // Assert
        assertTrue(toString.contains(id.toString()));
        assertTrue(toString.contains(namaPartai));
        assertTrue(toString.contains(nomorUrut.toString()));
    }

    @Test
    void testEqualsWithNull() {
        // Arrange
        PartaiDTO partaiDTO = new PartaiDTO();
        partaiDTO.setId(UUID.randomUUID());

        // Act & Assert
        assertNotEquals(null, partaiDTO);
    }

    @Test
    void testEqualsWithDifferentClass() {
        // Arrange
        PartaiDTO partaiDTO = new PartaiDTO();
        partaiDTO.setId(UUID.randomUUID());
        Object object = new Object();

        // Act & Assert
        assertNotEquals(partaiDTO, object);
    }
}