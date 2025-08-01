package com.allobank.allobackendtest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "wilayah_dapil")
public class WilayahDapil {
    @Id
    private UUID id;
    
    @Column(name = "dapil_id", nullable = false)
    private UUID dapilId;
    
    @Column(name = "nama_wilayah", nullable = false)
    private String namaWilayah;
}