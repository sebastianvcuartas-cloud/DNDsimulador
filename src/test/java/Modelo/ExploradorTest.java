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
public class ExploradorTest {

    @Test
    public void testCalcularVentajaTerreno() {
        assertEquals("Explorador Natural en Bosque", new Explorador("E1", 12, "Bosque", 1).calcularVentajaTerreno());
        assertEquals("Explorador Natural en Montaña", new Explorador("E9", 65, "Montaña", 9).calcularVentajaTerreno());
        assertEquals("Maestría de rastreo en Pantano", new Explorador("E10", 75, "Pantano", 10).calcularVentajaTerreno());
    }

    @Test
    public void testSimularCombate() {
        Explorador e = new Explorador("Legolas", 55, "Bosque", 10);
        String resultado = e.simularCombate();
        assertTrue(resultado.contains("Legolas"));
        assertTrue(resultado.contains("Maestría de rastreo en Bosque"));
    }
}
