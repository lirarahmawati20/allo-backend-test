-- Insert sample data for Partai
INSERT INTO partai (id, nama_partai, nomor_urut) VALUES 
('a1b2c3d4-e5f6-7890-a1b2-c3d4e5f67890', 'Partai Demokrasi Indonesia Perjuangan', 1),
('b2c3d4e5-f6a7-8901-b2c3-d4e5f6a78901', 'Partai Golkar', 2),
('c3d4e5f6-a7b8-9012-c3d4-e5f6a7b89012', 'Partai Gerindra', 3),
('d4e5f6a7-b8c9-0123-d4e5-f6a7b8c90123', 'Partai Nasdem', 4),
('e5f6a7b8-c9d0-1234-e5f6-a7b8c9d01234', 'Partai Kebangkitan Bangsa', 5)
ON CONFLICT (id) DO NOTHING;

-- Insert sample data for Dapil
INSERT INTO dapil (id, nama_dapil, provinsi, jumlah_kursi) VALUES 
('f6a7b8c9-d0e1-2345-f6a7-b8c9d0e12345', 'Jakarta I', 'DKI Jakarta', 6),
('a7b8c9d0-e1f2-3456-a7b8-c9d0e1f23456', 'Jakarta II', 'DKI Jakarta', 7),
('b8c9d0e1-f2a3-4567-b8c9-d0e1f2a34567', 'Jawa Barat I', 'Jawa Barat', 8),
('c9d0e1f2-a3b4-5678-c9d0-e1f2a3b45678', 'Jawa Barat II', 'Jawa Barat', 9),
('d0e1f2a3-b4c5-6789-d0e1-f2a3b4c56789', 'Jawa Tengah I', 'Jawa Tengah', 8)
ON CONFLICT (id) DO NOTHING;

-- Insert sample data for Wilayah Dapil
INSERT INTO wilayah_dapil (id, dapil_id, nama_wilayah) VALUES 
('e1f2a3b4-c5d6-7890-e1f2-a3b4c5d67890', 'f6a7b8c9-d0e1-2345-f6a7-b8c9d0e12345', 'Jakarta Pusat'),
('f2a3b4c5-d6e7-8901-f2a3-b4c5d6e78901', 'f6a7b8c9-d0e1-2345-f6a7-b8c9d0e12345', 'Jakarta Utara'),
('a3b4c5d6-e7f8-9012-a3b4-c5d6e7f89012', 'a7b8c9d0-e1f2-3456-a7b8-c9d0e1f23456', 'Jakarta Selatan'),
('b4c5d6e7-f8a9-0123-b4c5-d6e7f8a90123', 'a7b8c9d0-e1f2-3456-a7b8-c9d0e1f23456', 'Jakarta Timur'),
('c5d6e7f8-a9b0-1234-c5d6-e7f8a9b01234', 'b8c9d0e1-f2a3-4567-b8c9-d0e1f2a34567', 'Bandung'),
('d6e7f8a9-b0c1-2345-d6e7-f8a9b0c12345', 'b8c9d0e1-f2a3-4567-b8c9-d0e1f2a34567', 'Cimahi'),
('e7f8a9b0-c1d2-3456-e7f8-a9b0c1d23456', 'c9d0e1f2-a3b4-5678-c9d0-e1f2a3b45678', 'Bekasi'),
('f8a9b0c1-d2e3-4567-f8a9-b0c1d2e34567', 'c9d0e1f2-a3b4-5678-c9d0-e1f2a3b45678', 'Depok'),
('a9b0c1d2-e3f4-5678-a9b0-c1d2e3f45678', 'd0e1f2a3-b4c5-6789-d0e1-f2a3b4c56789', 'Semarang'),
('b0c1d2e3-f4a5-6789-b0c1-d2e3f4a56789', 'd0e1f2a3-b4c5-6789-d0e1-f2a3b4c56789', 'Solo')
ON CONFLICT (id) DO NOTHING;

-- Insert sample data for Caleg
INSERT INTO caleg (id, dapil_id, partai_id, nomor_urut, nama, jenis_kelamin) VALUES 
('c1d2e3f4-a5b6-7890-c1d2-e3f4a5b67890', 'f6a7b8c9-d0e1-2345-f6a7-b8c9d0e12345', 'a1b2c3d4-e5f6-7890-a1b2-c3d4e5f67890', 1, 'Budi Santoso', 'LAKILAKI'),
('d2e3f4a5-b6c7-8901-d2e3-f4a5b6c78901', 'f6a7b8c9-d0e1-2345-f6a7-b8c9d0e12345', 'a1b2c3d4-e5f6-7890-a1b2-c3d4e5f67890', 2, 'Siti Rahayu', 'PEREMPUAN'),
('e3f4a5b6-c7d8-9012-e3f4-a5b6c7d89012', 'f6a7b8c9-d0e1-2345-f6a7-b8c9d0e12345', 'b2c3d4e5-f6a7-8901-b2c3-d4e5f6a78901', 1, 'Ahmad Hidayat', 'LAKILAKI'),
('f4a5b6c7-d8e9-0123-f4a5-b6c7d8e90123', 'a7b8c9d0-e1f2-3456-a7b8-c9d0e1f23456', 'b2c3d4e5-f6a7-8901-b2c3-d4e5f6a78901', 2, 'Dewi Lestari', 'PEREMPUAN'),
('a5b6c7d8-e9f0-1234-a5b6-c7d8e9f01234', 'a7b8c9d0-e1f2-3456-a7b8-c9d0e1f23456', 'c3d4e5f6-a7b8-9012-c3d4-e5f6a7b89012', 1, 'Eko Prasetyo', 'LAKILAKI'),
('b6c7d8e9-f0a1-2345-b6c7-d8e9f0a12345', 'b8c9d0e1-f2a3-4567-b8c9-d0e1f2a34567', 'c3d4e5f6-a7b8-9012-c3d4-e5f6a7b89012', 2, 'Fitriani', 'PEREMPUAN'),
('c7d8e9f0-a1b2-3456-c7d8-e9f0a1b23456', 'b8c9d0e1-f2a3-4567-b8c9-d0e1f2a34567', 'd4e5f6a7-b8c9-0123-d4e5-f6a7b8c90123', 1, 'Gunawan', 'LAKILAKI'),
('d8e9f0a1-b2c3-4567-d8e9-f0a1b2c34567', 'c9d0e1f2-a3b4-5678-c9d0-e1f2a3b45678', 'd4e5f6a7-b8c9-0123-d4e5-f6a7b8c90123', 2, 'Hani Susanti', 'PEREMPUAN'),
('e9f0a1b2-c3d4-5678-e9f0-a1b2c3d45678', 'c9d0e1f2-a3b4-5678-c9d0-e1f2a3b45678', 'e5f6a7b8-c9d0-1234-e5f6-a7b8c9d01234', 1, 'Irfan Hakim', 'LAKILAKI'),
('f0a1b2c3-d4e5-6789-f0a1-b2c3d4e56789', 'd0e1f2a3-b4c5-6789-d0e1-f2a3b4c56789', 'e5f6a7b8-c9d0-1234-e5f6-a7b8c9d01234', 2, 'Juwita Sari', 'PEREMPUAN')
ON CONFLICT (id) DO NOTHING;
