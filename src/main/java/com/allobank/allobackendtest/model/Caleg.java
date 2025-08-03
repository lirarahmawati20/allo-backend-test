package com.allobank.allobackendtest.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "caleg")
public class Caleg {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dapil_id", nullable = false)
    private Dapil dapil;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partai_id", nullable = false)
    private Partai partai;

    @Column(name = "nomor_urut", nullable = false)
    private Integer nomorUrut;

    @Column(nullable = false)
    private String nama;

    @Enumerated(EnumType.STRING)
    @Column(name = "jenis_kelamin", nullable = false)
    private JenisKelamin jenisKelamin;
}
