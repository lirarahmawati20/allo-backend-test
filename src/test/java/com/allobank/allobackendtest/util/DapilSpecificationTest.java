package com.allobank.allobackendtest.util;

import com.allobank.allobackendtest.model.Dapil;
import jakarta.persistence.criteria.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DapilSpecificationTest {

    @Mock
    private Root<Dapil> root;

    @Mock
    private CriteriaQuery<?> query;

    @Mock
    private CriteriaBuilder criteriaBuilder;

    @Mock
    private Path<Object> path;

    @Mock
    private Predicate predicate;

    @Mock
    private Expression<String> stringExpression;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void hasNamaDapil_ShouldReturnSpecification() {
        // Arrange
        String namaDapil = "Test Dapil";
        when(root.get("namaDapil")).thenReturn(path);
        when(criteriaBuilder.lower(any(Expression.class))).thenReturn(stringExpression);
        when(criteriaBuilder.like(stringExpression, "%" + namaDapil.toLowerCase() + "%")).thenReturn(predicate);

        // Act
        Specification<Dapil> spec = DapilSpecification.hasNamaDapil(namaDapil);
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).like(stringExpression, "%" + namaDapil.toLowerCase() + "%");
    }

    @Test
    void hasNamaDapil_WithNullName_ShouldReturnConjunction() {
        // Arrange
        when(criteriaBuilder.conjunction()).thenReturn(predicate);

        // Act
        Specification<Dapil> spec = DapilSpecification.hasNamaDapil(null);
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).conjunction();
        verify(root, never()).get(anyString());
    }

    @Test
    void hasNamaDapil_WithEmptyName_ShouldReturnConjunction() {
        // Arrange
        when(criteriaBuilder.conjunction()).thenReturn(predicate);

        // Act
        Specification<Dapil> spec = DapilSpecification.hasNamaDapil("");
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).conjunction();
        verify(root, never()).get(anyString());
    }

    @Test
    void hasProvinsi_ShouldReturnSpecification() {
        // Arrange
        String provinsi = "Test Provinsi";
        when(root.get("provinsi")).thenReturn(path);
        when(criteriaBuilder.lower(any(Expression.class))).thenReturn(stringExpression);
        when(criteriaBuilder.like(stringExpression, "%" + provinsi.toLowerCase() + "%")).thenReturn(predicate);

        // Act
        Specification<Dapil> spec = DapilSpecification.hasProvinsi(provinsi);
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).like(stringExpression, "%" + provinsi.toLowerCase() + "%");
    }

    @Test
    void hasProvinsi_WithNullName_ShouldReturnConjunction() {
        // Arrange
        when(criteriaBuilder.conjunction()).thenReturn(predicate);

        // Act
        Specification<Dapil> spec = DapilSpecification.hasProvinsi(null);
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).conjunction();
        verify(root, never()).get(anyString());
    }

    @Test
    void hasProvinsi_WithEmptyName_ShouldReturnConjunction() {
        // Arrange
        when(criteriaBuilder.conjunction()).thenReturn(predicate);

        // Act
        Specification<Dapil> spec = DapilSpecification.hasProvinsi("");
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).conjunction();
        verify(root, never()).get(anyString());
    }

    @Test
    void hasJumlahKursi_ShouldReturnSpecification() {
        // Arrange
        Integer jumlahKursi = 10;
        when(root.get("jumlahKursi")).thenReturn(path);
        when(criteriaBuilder.equal(path, jumlahKursi)).thenReturn(predicate);

        // Act
        Specification<Dapil> spec = DapilSpecification.hasJumlahKursi(jumlahKursi);
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).equal(path, jumlahKursi);
    }

    @Test
    void hasJumlahKursi_WithNullValue_ShouldReturnConjunction() {
        // Arrange
        when(criteriaBuilder.conjunction()).thenReturn(predicate);

        // Act
        Specification<Dapil> spec = DapilSpecification.hasJumlahKursi(null);
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).conjunction();
        verify(root, never()).get(anyString());
    }
}
