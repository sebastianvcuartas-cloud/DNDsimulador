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
public class GuerreroTest {

    @Test
    public void testCalcularAtaquesPorAccion() {
        assertEquals(1, new Guerrero("G1", 30, true, 1).calcularAtaquesPorAccion());
        assertEquals(1, new Guerrero("G4", 40, true, 4).calcularAtaquesPorAccion());
        assertEquals(2, new Guerrero("G5", 50, true, 5).calcularAtaquesPorAccion());
        assertEquals(3, new Guerrero("G11", 90, false, 11).calcularAtaquesPorAccion());
        assertEquals(4, new Guerrero("G20", 160, true, 20).calcularAtaquesPorAccion());
    }

    @Test
    public void testSimularCombate() {
        Guerrero g = new Guerrero("Leonidas", 80, true, 5);
        String resultado = g.simularCombate();
        assertTrue(resultado.contains("Leonidas"));
        assertTrue(resultado.contains("con Armadura Pesada"));
        assertTrue(resultado.contains("2 ataques físicos"));
    }
}
