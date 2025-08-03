package com.allobank.allobackendtest.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JenisKelaminTest {

    @Test
    void testEnumValues() {
        // Assert
        assertEquals(2, JenisKelamin.values().length);
        assertEquals(JenisKelamin.LAKILAKI, JenisKelamin.valueOf("LAKILAKI"));
        assertEquals(JenisKelamin.PEREMPUAN, JenisKelamin.valueOf("PEREMPUAN"));
    }

    @Test
    void testEnumOrdinals() {
        // Assert
        assertEquals(0, JenisKelamin.LAKILAKI.ordinal());
        assertEquals(1, JenisKelamin.PEREMPUAN.ordinal());
    }

    @Test
    void testEnumToString() {
        // Assert
        assertEquals("LAKILAKI", JenisKelamin.LAKILAKI.toString());
        assertEquals("PEREMPUAN", JenisKelamin.PEREMPUAN.toString());
    }

    @Test
    void testEnumEquality() {
        // Assert
        assertSame(JenisKelamin.LAKILAKI, JenisKelamin.LAKILAKI);
        assertSame(JenisKelamin.PEREMPUAN, JenisKelamin.PEREMPUAN);
        assertNotSame(JenisKelamin.LAKILAKI, JenisKelamin.PEREMPUAN);
    }

    @Test
    void testValueOf() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> JenisKelamin.valueOf("INVALID_VALUE"));
    }
}