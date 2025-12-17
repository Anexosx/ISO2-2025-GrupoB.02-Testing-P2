package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class Problema2Test {

    /* =====================
       IF 1: edad < 18 && numeroVuelos >= 6
       ===================== */
    @Test
    public void testPajarilloCumple() {
        String res = Problema2.calcularTarifa(17, 6, false, "turista", 0,
                false, false, 0, "Europa", false, 0, 100.0, 1);
        assertTrue(res.startsWith("Pajarillo"));
    }

    @Test
    public void testPajarilloNoCumplePorVuelos() {
        String res = Problema2.calcularTarifa(17, 3, false, "turista", 0,
                false, false, 0, "Europa", false, 0, 100.0, 1);
        assertTrue(res.startsWith("Sin tarifa"));
    }

    /* =====================
       IF 2: Gorrión
       ===================== */
    @Test
    public void testGorrionCumple() {
        String res = Problema2.calcularTarifa(18, 3, true, "turista", 1,
                false, false, 20000, "Otro", false, 0, 100.0, 1);
        assertTrue(res.startsWith("Gorrión"));
    }

    @Test
    public void testGorrionNoCumplePorClase() {
        String res = Problema2.calcularTarifa(18, 3, true, "business", 1,
                false, false, 20000, "Otro", false, 0, 100.0, 1);
        assertTrue(res.startsWith("Sin tarifa"));
    }

    /* =====================
       IF 3: Viaja ahora / Atreviéndose a saltar del Nido
       ===================== */
    @Test
    public void testViajaAhoraQuePuedes() {
        String res = Problema2.calcularTarifa(20, 3, false, "turista", 1,
                true, true, 20000, "Europa", false, 0, 100.0, 1);
        assertTrue(res.startsWith("Viaja ahora que puedes"));
    }

    @Test
    public void testAtreviendoseASaltarDelNido() {
        String res = Problema2.calcularTarifa(20, 3, false, "turista", 1,
                true, false, 20000, "Europa", false, 0, 100.0, 1);
        assertTrue(res.startsWith("Atreviéndose a saltar del Nido"));
    }

    /* =====================
       IF 4: Conoce Europa
       ===================== */
    @Test
    public void testConoceEuropaSinNinos() {
        String res = Problema2.calcularTarifa(30, 6, false, "turista", 0,
                false, false, 30000, "Europa", false, 0, 100.0, 1);
        assertTrue(res.startsWith("Conoce Europa"));
    }

    @Test
    public void testConoceEuropaConNinos() {
        String res = Problema2.calcularTarifa(30, 6, false, "turista", 0,
                false, false, 30000, "Europa", true, 5, 100.0, 1);
        assertTrue(res.startsWith("Conoce Europa con tus peques"));
    }

    /* =====================
       IF 5: Conoce el Mundo
       ===================== */
    @Test
    public void testConoceElMundoSinNinos() {
        String res = Problema2.calcularTarifa(30, 6, false, "business", 0,
                false, false, 40000, "Asia", false, 0, 100.0, 1);
        assertTrue(res.startsWith("Conoce el Mundo"));
    }

    @Test
    public void testConoceElMundoConNinos() {
        String res = Problema2.calcularTarifa(30, 6, false, "business", 0,
                false, false, 40000, "America", true, 8, 100.0, 1);
        assertTrue(res.startsWith("Conoce el Mundo con tus peques"));
    }
}

