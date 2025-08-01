package com.allobank.allobackendtest.util;

import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.JenisKelamin;
import jakarta.persistence.criteria.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalegSpecificationTest {

    @Mock
    private Root<Caleg> root;

    @Mock
    private CriteriaQuery<?> query;

    @Mock
    private CriteriaBuilder criteriaBuilder;

    @Mock
    private Path<Object> path;

    @Mock
    private Path<Object> nestedPath;

    @Mock
    private Predicate predicate;

    @Mock
    private Expression<String> stringExpression;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void hasDapil_ShouldReturnSpecification() {
        // Arrange
        UUID dapilId = UUID.randomUUID();
        when(root.get("dapil")).thenReturn(path);
        when(path.get("id")).thenReturn(nestedPath);
        when(criteriaBuilder.equal(nestedPath, dapilId)).thenReturn(predicate);

        // Act
        Specification<Caleg> spec = CalegSpecification.hasDapil(dapilId);
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).equal(nestedPath, dapilId);
    }

    @Test
    void hasDapil_WithNullId_ShouldReturnConjunction() {
        // Arrange
        when(criteriaBuilder.conjunction()).thenReturn(predicate);

        // Act
        Specification<Caleg> spec = CalegSpecification.hasDapil(null);
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).conjunction();
        verify(root, never()).get(anyString());
    }

    @Test
    void hasPartai_ShouldReturnSpecification() {
        // Arrange
        UUID partaiId = UUID.randomUUID();
        when(root.get("partai")).thenReturn(path);
        when(path.get("id")).thenReturn(nestedPath);
        when(criteriaBuilder.equal(nestedPath, partaiId)).thenReturn(predicate);

        // Act
        Specification<Caleg> spec = CalegSpecification.hasPartai(partaiId);
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).equal(nestedPath, partaiId);
    }

    @Test
    void hasPartai_WithNullId_ShouldReturnConjunction() {
        // Arrange
        when(criteriaBuilder.conjunction()).thenReturn(predicate);

        // Act
        Specification<Caleg> spec = CalegSpecification.hasPartai(null);
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).conjunction();
        verify(root, never()).get(anyString());
    }


    @Test
    void hasNama_WithNullName_ShouldReturnConjunction() {
        // Arrange
        when(criteriaBuilder.conjunction()).thenReturn(predicate);

        // Act
        Specification<Caleg> spec = CalegSpecification.hasNama(null);
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).conjunction();
        verify(root, never()).get(anyString());
    }

    @Test
    void hasNama_WithEmptyName_ShouldReturnConjunction() {
        // Arrange
        when(criteriaBuilder.conjunction()).thenReturn(predicate);

        // Act
        Specification<Caleg> spec = CalegSpecification.hasNama("");
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).conjunction();
        verify(root, never()).get(anyString());
    }

    @Test
    void hasJenisKelamin_ShouldReturnSpecification() {
        // Arrange
        JenisKelamin jenisKelamin = JenisKelamin.LAKILAKI;
        when(root.get("jenisKelamin")).thenReturn(path);
        when(criteriaBuilder.equal(path, jenisKelamin)).thenReturn(predicate);

        // Act
        Specification<Caleg> spec = CalegSpecification.hasJenisKelamin(jenisKelamin);
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).equal(path, jenisKelamin);
    }

    @Test
    void hasJenisKelamin_WithNullValue_ShouldReturnConjunction() {
        // Arrange
        when(criteriaBuilder.conjunction()).thenReturn(predicate);

        // Act
        Specification<Caleg> spec = CalegSpecification.hasJenisKelamin(null);
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).conjunction();
        verify(root, never()).get(anyString());
    }

    @Test
    void hasNomorUrut_ShouldReturnSpecification() {
        // Arrange
        Integer nomorUrut = 1;
        when(root.get("nomorUrut")).thenReturn(path);
        when(criteriaBuilder.equal(path, nomorUrut)).thenReturn(predicate);

        // Act
        Specification<Caleg> spec = CalegSpecification.hasNomorUrut(nomorUrut);
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).equal(path, nomorUrut);
    }

    @Test
    void hasNomorUrut_WithNullValue_ShouldReturnConjunction() {
        // Arrange
        when(criteriaBuilder.conjunction()).thenReturn(predicate);

        // Act
        Specification<Caleg> spec = CalegSpecification.hasNomorUrut(null);
        Predicate result = spec.toPredicate(root, query, criteriaBuilder);

        // Assert
        assertNotNull(spec);
        assertEquals(predicate, result);
        verify(criteriaBuilder).conjunction();
        verify(root, never()).get(anyString());
    }
}
