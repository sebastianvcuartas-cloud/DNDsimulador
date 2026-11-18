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
public class MagoTest {

    @Test
    public void testCalcularCirculoMaximo() {
        assertEquals("Conjuros de hasta Círculo 1", new Mago("M1", 10, 1, 1).calcularCirculoMaximo());
        assertEquals("Conjuros de hasta Círculo 2", new Mago("M3", 18, 1, 3).calcularCirculoMaximo());
        assertEquals("Conjuros de hasta Círculo 3", new Mago("M5", 26, 2, 5).calcularCirculoMaximo());
        assertEquals("Conjuros de hasta Círculo 9", new Mago("M17", 70, 3, 17).calcularCirculoMaximo());
        assertEquals("Conjuros de hasta Círculo 9", new Mago("M20", 85, 4, 20).calcularCirculoMaximo());
    }

    @Test
    public void testSimularCombate() {
        Mago m = new Mago("Merlín", 45, 3, 5);
        String resultado = m.simularCombate();
        assertTrue(resultado.contains("Merlín"));
        assertTrue(resultado.contains("Círculo 3"));
    }
}
