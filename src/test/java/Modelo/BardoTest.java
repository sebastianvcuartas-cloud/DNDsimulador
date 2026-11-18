/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BardoTest {

    @Test
    public void testCalcularDadoInspiracionBardica() {
        assertEquals("d6", new Bardo("B1", 10, "Laúd", 1).calcularDadoInspiracionBardica());
        assertEquals("d8", new Bardo("B5", 32, "Flauta", 5).calcularDadoInspiracionBardica());
        assertEquals("d10", new Bardo("B10", 60, "Arpa", 10).calcularDadoInspiracionBardica());
        assertEquals("d12", new Bardo("B15", 90, "Violín", 15).calcularDadoInspiracionBardica());
    }

    @Test
    public void testSimularCombate() {
        Bardo b = new Bardo("Scanlan", 48, "Laúd", 10);
        String resultado = b.simularCombate();
        assertTrue(resultado.contains("Scanlan"));
        assertTrue(resultado.contains("Laúd"));
        assertTrue(resultado.contains("d10 PHB"));
    }
}