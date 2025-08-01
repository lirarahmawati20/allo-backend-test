package com.allobank.allobackendtest.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Data Transfer Object for Dapil entity
 */
@Data
public class DapilDTO {
    private UUID id;
    private String namaDapil;
    private String provinsi;
    private List<WilayahDapilDTO> wilayahDapilList = new ArrayList<>();
    private int jumlahKursi;
}