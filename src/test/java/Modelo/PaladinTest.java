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
public class PaladinTest {

    @Test
    public void testCalcularPotenciaCastigo() {
        assertEquals("1d8 de daño radiante (Divine Smite PHB)", new Paladin("P1", 14, 16, 1).calcularPotenciaCastigo());
        assertEquals("3d8 de daño radiante (Divine Smite PHB)", new Paladin("P3", 28, 16, 3).calcularPotenciaCastigo());
        assertEquals("5d8 de daño radiante (Divine Smite PHB)", new Paladin("P5", 45, 18, 5).calcularPotenciaCastigo());
        assertEquals("5d8 de daño radiante (Divine Smite PHB)", new Paladin("P12", 100, 20, 12).calcularPotenciaCastigo());
    }

    @Test
    public void testSimularCombate() {
        Paladin p = new Paladin("Arthas", 60, 18, 4);
        String resultado = p.simularCombate();
        assertTrue(resultado.contains("Arthas"));
        assertTrue(resultado.contains("4d8 de daño radiante"));
    }
}
