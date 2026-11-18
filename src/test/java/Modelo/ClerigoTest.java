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
public class ClerigoTest {

    @Test
    public void testCalcularUsosCanalizar() {
        assertEquals(0, new Clerigo("C1", 12, "Pelor", 1).calcularUsosCanalizar());
        assertEquals(1, new Clerigo("C2", 18, "Pelor", 2).calcularUsosCanalizar());
        assertEquals(1, new Clerigo("C5", 35, "Pelor", 5).calcularUsosCanalizar());
        assertEquals(2, new Clerigo("C6", 42, "Pelor", 6).calcularUsosCanalizar());
        assertEquals(2, new Clerigo("C17", 110, "Pelor", 17).calcularUsosCanalizar());
        assertEquals(3, new Clerigo("C18", 120, "Pelor", 18).calcularUsosCanalizar());
    }

    @Test
    public void testSimularCombate() {
        Clerigo c = new Clerigo("Uther", 50, "La Luz", 6);
        String resultado = c.simularCombate();
        assertTrue(resultado.contains("Uther"));
        assertTrue(resultado.contains("La Luz"));
        assertTrue(resultado.contains("2 usos oficiales PHB"));
    }
}
