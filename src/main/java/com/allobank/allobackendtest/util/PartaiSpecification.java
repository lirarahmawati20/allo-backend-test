package com.allobank.allobackendtest.util;

import com.allobank.allobackendtest.model.Partai;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * Utility class for creating specifications to filter Partai entities
 */
public class PartaiSpecification {

    /**
     * Create a specification to filter by ID
     * @param id the partai ID
     * @return the specification
     */
    public static Specification<Partai> hasId(UUID id) {
        return (root, query, criteriaBuilder) -> {
            if (id == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("id"), id);
        };
    }

    /**
     * Create a specification to filter by name (partial match)
     * @param namaPartai the name to search for
     * @return the specification
     */
    public static Specification<Partai> hasNamaPartai(String namaPartai) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(namaPartai)) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(
                criteriaBuilder.lower(root.get("namaPartai")), 
                "%" + namaPartai.toLowerCase() + "%"
            );
        };
    }

    /**
     * Create a specification to filter by nomor urut
     * @param nomorUrut the sequence number
     * @return the specification
     */
    public static Specification<Partai> hasNomorUrut(Integer nomorUrut) {
        return (root, query, criteriaBuilder) -> {
            if (nomorUrut == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("nomorUrut"), nomorUrut);
        };
    }
}