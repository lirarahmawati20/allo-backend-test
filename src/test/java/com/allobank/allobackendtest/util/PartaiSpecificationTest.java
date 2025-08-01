package com.allobank.allobackendtest.util;

import com.allobank.allobackendtest.model.Partai;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PartaiSpecificationTest {

    @Test
    void hasId_ShouldReturnSpecification() {
        // Arrange
        UUID id = UUID.randomUUID();

        // Act
        Specification<Partai> spec = PartaiSpecification.hasId(id);

        // Assert
        assertNotNull(spec);
    }

    @Test
    void hasId_WithNullId_ShouldReturnSpecification() {
        // Act
        Specification<Partai> spec = PartaiSpecification.hasId(null);

        // Assert
        assertNotNull(spec);
    }

    @Test
    void hasId_WithRandomUUID_ShouldReturnSpecification() {
        // Arrange
        UUID randomUUID = UUID.randomUUID();

        // Act
        Specification<Partai> spec = PartaiSpecification.hasId(randomUUID);

        // Assert
        assertNotNull(spec);
    }

    @Test
    void hasId_WithNamedUUID_ShouldReturnSpecification() {
        // Arrange
        UUID namedUUID = UUID.nameUUIDFromBytes("test".getBytes());

        // Act
        Specification<Partai> spec = PartaiSpecification.hasId(namedUUID);

        // Assert
        assertNotNull(spec);
    }

    @Test
    void hasNamaPartai_ShouldReturnSpecification() {
        // Arrange
        String namaPartai = "Test Partai";

        // Act
        Specification<Partai> spec = PartaiSpecification.hasNamaPartai(namaPartai);

        // Assert
        assertNotNull(spec);
    }

    @Test
    void hasNamaPartai_WithNullName_ShouldReturnSpecification() {
        // Act
        Specification<Partai> spec = PartaiSpecification.hasNamaPartai(null);

        // Assert
        assertNotNull(spec);
    }

    @Test
    void hasNamaPartai_WithEmptyName_ShouldReturnSpecification() {
        // Act
        Specification<Partai> spec = PartaiSpecification.hasNamaPartai("");

        // Assert
        assertNotNull(spec);
    }

    @Test
    void hasNamaPartai_WithBlankName_ShouldReturnSpecification() {
        // Act
        Specification<Partai> spec = PartaiSpecification.hasNamaPartai("   ");

        // Assert
        assertNotNull(spec);
    }

    @Test
    void hasNamaPartai_WithSpecialCharacters_ShouldReturnSpecification() {
        // Act
        Specification<Partai> spec = PartaiSpecification.hasNamaPartai("!@#$%^&*()");

        // Assert
        assertNotNull(spec);
    }

    @Test
    void hasNamaPartai_WithLongName_ShouldReturnSpecification() {
        // Arrange
        StringBuilder longName = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            longName.append("Test");
        }

        // Act
        Specification<Partai> spec = PartaiSpecification.hasNamaPartai(longName.toString());

        // Assert
        assertNotNull(spec);
    }

    @Test
    void hasNomorUrut_ShouldReturnSpecification() {
        // Arrange
        Integer nomorUrut = 1;

        // Act
        Specification<Partai> spec = PartaiSpecification.hasNomorUrut(nomorUrut);

        // Assert
        assertNotNull(spec);
    }

    @Test
    void hasNomorUrut_WithNullValue_ShouldReturnSpecification() {
        // Act
        Specification<Partai> spec = PartaiSpecification.hasNomorUrut(null);

        // Assert
        assertNotNull(spec);
    }

    @Test
    void hasNomorUrut_WithZeroValue_ShouldReturnSpecification() {
        // Act
        Specification<Partai> spec = PartaiSpecification.hasNomorUrut(0);

        // Assert
        assertNotNull(spec);
    }

    @Test
    void hasNomorUrut_WithNegativeValue_ShouldReturnSpecification() {
        // Act
        Specification<Partai> spec = PartaiSpecification.hasNomorUrut(-1);

        // Assert
        assertNotNull(spec);
    }

    @Test
    void combineSpecifications_ShouldReturnCombinedSpecification() {
        // Arrange
        UUID id = UUID.randomUUID();
        String namaPartai = "Test Partai";
        Integer nomorUrut = 1;

        // Act
        Specification<Partai> idSpec = PartaiSpecification.hasId(id);
        Specification<Partai> namaSpec = PartaiSpecification.hasNamaPartai(namaPartai);
        Specification<Partai> nomorSpec = PartaiSpecification.hasNomorUrut(nomorUrut);

        Specification<Partai> combinedSpec = Specification.where(idSpec)
            .and(namaSpec)
            .and(nomorSpec);

        // Assert
        assertNotNull(combinedSpec);
    }

    @Test
    void combineSpecifications_WithNullValues_ShouldReturnSpecification() {
        // Act
        Specification<Partai> idSpec = PartaiSpecification.hasId(null);
        Specification<Partai> namaSpec = PartaiSpecification.hasNamaPartai(null);
        Specification<Partai> nomorSpec = PartaiSpecification.hasNomorUrut(null);

        Specification<Partai> combinedSpec = Specification.where(idSpec)
            .and(namaSpec)
            .and(nomorSpec);

        // Assert
        assertNotNull(combinedSpec);
    }

    @Test
    void combineSpecifications_WithOR_ShouldReturnSpecification() {
        // Arrange
        UUID id = UUID.randomUUID();
        String namaPartai = "Test Partai";
        Integer nomorUrut = 1;

        // Act
        Specification<Partai> idSpec = PartaiSpecification.hasId(id);
        Specification<Partai> namaSpec = PartaiSpecification.hasNamaPartai(namaPartai);
        Specification<Partai> nomorSpec = PartaiSpecification.hasNomorUrut(nomorUrut);

        Specification<Partai> combinedSpec = Specification.where(idSpec)
            .or(namaSpec)
            .or(nomorSpec);

        // Assert
        assertNotNull(combinedSpec);
    }

    @Test
    void combineSpecifications_WithMixedOperators_ShouldReturnSpecification() {
        // Arrange
        UUID id = UUID.randomUUID();
        String namaPartai = "Test Partai";
        Integer nomorUrut = 1;

        // Act
        Specification<Partai> idSpec = PartaiSpecification.hasId(id);
        Specification<Partai> namaSpec = PartaiSpecification.hasNamaPartai(namaPartai);
        Specification<Partai> nomorSpec = PartaiSpecification.hasNomorUrut(nomorUrut);

        Specification<Partai> combinedSpec = Specification.where(idSpec)
            .and(namaSpec)
            .or(nomorSpec);

        // Assert
        assertNotNull(combinedSpec);
    }

    @Test
    void combineSpecifications_WithNot_ShouldReturnSpecification() {
        // Arrange
        UUID id = UUID.randomUUID();

        // Act
        Specification<Partai> idSpec = PartaiSpecification.hasId(id);
        Specification<Partai> notIdSpec = Specification.not(idSpec);

        // Assert
        assertNotNull(notIdSpec);
    }

    @Test
    void chainMultipleSpecifications_ShouldReturnSpecification() {
        // Arrange
        UUID id = UUID.randomUUID();
        String namaPartai = "Test Partai";
        Integer nomorUrut = 1;

        // Act
        Specification<Partai> spec = PartaiSpecification.hasId(id)
            .and(PartaiSpecification.hasNamaPartai(namaPartai))
            .and(PartaiSpecification.hasNomorUrut(nomorUrut));

        // Assert
        assertNotNull(spec);
    }
}
