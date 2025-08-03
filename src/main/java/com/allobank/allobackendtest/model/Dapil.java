package com.allobank.allobackendtest.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "dapil")
public class Dapil {
    @Id
    private UUID id;

    @Column(name = "nama_dapil", nullable = false)
    private String namaDapil;

    @Column(nullable = false)
    private String provinsi;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "dapil_id")
    private List<WilayahDapil> wilayahDapilList = new ArrayList<>();

    @Column(name = "jumlah_kursi", nullable = false)
    private int jumlahKursi;
}
