package com.allobank.allobackendtest.dto;

import lombok.Data;

import java.util.UUID;

/**
 * Data Transfer Object for WilayahDapil entity
 */
@Data
public class WilayahDapilDTO {
    private UUID id;
    private UUID dapilId;
    private String namaWilayah;
}