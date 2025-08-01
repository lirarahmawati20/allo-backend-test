package com.allobank.allobackendtest.dto;

import com.allobank.allobackendtest.model.JenisKelamin;
import lombok.Data;

import java.util.UUID;

/**
 * Data Transfer Object for Caleg entity
 */
@Data
public class CalegDTO {
    private UUID id;
    private DapilDTO dapil;
    private PartaiDTO partai;
    private Integer nomorUrut;
    private String nama;
    private JenisKelamin jenisKelamin;
}