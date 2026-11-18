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
public class PicaroTest {

    @Test
    public void testCalcularDadoAtaqueFurtivoDND() {
        assertEquals("1d6 (Sneak Attack PHB)", new Picaro("Pi1", 10, true, 1).calcularDadoAtaqueFurtivoDND());
        assertEquals("2d6 (Sneak Attack PHB)", new Picaro("Pi3", 22, true, 3).calcularDadoAtaqueFurtivoDND());
        assertEquals("3d6 (Sneak Attack PHB)", new Picaro("Pi5", 34, true, 5).calcularDadoAtaqueFurtivoDND());
        assertEquals("10d6 (Sneak Attack PHB)", new Picaro("Pi19", 110, true, 19).calcularDadoAtaqueFurtivoDND());
    }

    @Test
    public void testSimularCombate() {
        Picaro pi = new Picaro("Vax", 45, true, 5);
        String resultado = pi.simularCombate();
        assertTrue(resultado.contains("Vax"));
        assertTrue(resultado.contains("3d6 (Sneak Attack PHB)"));
    }
}