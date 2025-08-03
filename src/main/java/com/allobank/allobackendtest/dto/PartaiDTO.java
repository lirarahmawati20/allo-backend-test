package com.allobank.allobackendtest.dto;

import lombok.Data;

import java.util.UUID;

/**
 * Data Transfer Object for Partai entity
 */
@Data
public class PartaiDTO {
    private UUID id;
    private String namaPartai;
    private Integer nomorUrut;
}