package com.allobank.allobackendtest.util;

import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.JenisKelamin;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * Utility class for creating specifications to filter Caleg entities
 */
public class    CalegSpecification {

    /**
     * Create a specification to filter by dapil ID
     * @param dapilId the dapil ID
     * @return the specification
     */
    public static Specification<Caleg> hasDapil(UUID dapilId) {
        return (root, query, criteriaBuilder) -> {
            if (dapilId == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("dapil").get("id"), dapilId);
        };
    }

    /**
     * Create a specification to filter by partai ID
     * @param partaiId the partai ID
     * @return the specification
     */
    public static Specification<Caleg> hasPartai(UUID partaiId) {
        return (root, query, criteriaBuilder) -> {
            if (partaiId == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("partai").get("id"), partaiId);
        };
    }

    /**
     * Create a specification to filter by name (partial match)
     * @param nama the name to search for
     * @return the specification
     */
    public static Specification<Caleg> hasNama(String nama) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(nama)) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(
                criteriaBuilder.lower(root.get("nama")), 
                "%" + nama.toLowerCase() + "%"
            );
        };
    }

    /**
     * Create a specification to filter by gender
     * @param jenisKelamin the gender
     * @return the specification
     */
    public static Specification<Caleg> hasJenisKelamin(JenisKelamin jenisKelamin) {
        return (root, query, criteriaBuilder) -> {
            if (jenisKelamin == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("jenisKelamin"), jenisKelamin);
        };
    }

    /**
     * Create a specification to filter by nomor urut
     * @param nomorUrut the sequence number
     * @return the specification
     */
    public static Specification<Caleg> hasNomorUrut(Integer nomorUrut) {
        return (root, query, criteriaBuilder) -> {
            if (nomorUrut == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("nomorUrut"), nomorUrut);
        };
    }
}