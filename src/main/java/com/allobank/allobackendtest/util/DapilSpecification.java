package com.allobank.allobackendtest.util;

import com.allobank.allobackendtest.model.Dapil;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;


/**
 * Utility class for creating specifications to filter Dapil entities
 */
public class DapilSpecification {

    /**
     * Create a specification to filter by namaDapil (partial match)
     * @param namaDapil the name to search for
     * @return the specification
     */
    public static Specification<Dapil> hasNamaDapil(String namaDapil) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(namaDapil)) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(
                criteriaBuilder.lower(root.get("namaDapil")), 
                "%" + namaDapil.toLowerCase() + "%"
            );
        };
    }

    /**
     * Create a specification to filter by provinsi (partial match)
     * @param provinsi the province to search for
     * @return the specification
     */
    public static Specification<Dapil> hasProvinsi(String provinsi) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(provinsi)) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(
                criteriaBuilder.lower(root.get("provinsi")), 
                "%" + provinsi.toLowerCase() + "%"
            );
        };
    }

    /**
     * Create a specification to filter by jumlahKursi
     * @param jumlahKursi the number of seats
     * @return the specification
     */
    public static Specification<Dapil> hasJumlahKursi(Integer jumlahKursi) {
        return (root, query, criteriaBuilder) -> {
            if (jumlahKursi == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("jumlahKursi"), jumlahKursi);
        };
    }
}