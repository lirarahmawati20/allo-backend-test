-- Create tables for Caleg, Partai, and Dapil

-- Create Partai table
CREATE TABLE IF NOT EXISTS partai (
    id UUID PRIMARY KEY,
    nama_partai VARCHAR(255) NOT NULL,
    nomor_urut INT NOT NULL
);

-- Create Dapil table
CREATE TABLE IF NOT EXISTS dapil (
    id UUID PRIMARY KEY,
    nama_dapil VARCHAR(255) NOT NULL,
    provinsi VARCHAR(255) NOT NULL,
    jumlah_kursi INT NOT NULL
);

-- Create Wilayah Dapil table (for the list of areas in a district)
CREATE TABLE IF NOT EXISTS wilayah_dapil (
    id UUID PRIMARY KEY,
    dapil_id UUID NOT NULL,
    nama_wilayah VARCHAR(255) NOT NULL,
    FOREIGN KEY (dapil_id) REFERENCES dapil(id)
);

-- Create Caleg table
CREATE TABLE IF NOT EXISTS caleg (
    id UUID PRIMARY KEY,
    dapil_id UUID NOT NULL,
    partai_id UUID NOT NULL,
    nomor_urut INT NOT NULL,
    nama VARCHAR(255) NOT NULL,
    jenis_kelamin VARCHAR(20) NOT NULL,
    FOREIGN KEY (dapil_id) REFERENCES dapil(id),
    FOREIGN KEY (partai_id) REFERENCES partai(id)
);
