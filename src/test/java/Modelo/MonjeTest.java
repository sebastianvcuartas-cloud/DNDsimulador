/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author USUARIO
 */
public class MonjeTest {

    @Test
    public void testCalcularPuntosKiTotales() {
        assertEquals(0, new Monje("Mo1", 10, 0, 1).calcularPuntosKiTotales());
        assertEquals(2, new Monje("Mo2", 16, 0, 2).calcularPuntosKiTotales());
        assertEquals(10, new Monje("Mo10", 65, 0, 10).calcularPuntosKiTotales());
    }

    @Test
    public void testCalcularDadoArtesMarciales() {
        assertEquals("1d4", new Monje("Mo1", 10, 0, 1).calcularDadoArtesMarciales());
        assertEquals("1d6", new Monje("Mo5", 35, 0, 5).calcularDadoArtesMarciales());
        assertEquals("1d8", new Monje("Mo11", 70, 0, 11).calcularDadoArtesMarciales());
        assertEquals("1d10", new Monje("Mo17", 110, 0, 17).calcularDadoArtesMarciales());
    }

    @Test
    public void testSimularCombate() {
        Monje mo = new Monje("Lee", 40, 0, 5);
        String resultado = mo.simularCombate();
        assertTrue(resultado.contains("Lee"));
        assertTrue(resultado.contains("5 pts de Ki"));
        assertTrue(resultado.contains("1d6"));
    }
}