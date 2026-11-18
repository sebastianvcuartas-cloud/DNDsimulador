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
public class AventureroTest {

    @Test
    public void testAgregarClaseYNivelTotal() {
        Guerrero av = new Guerrero("Aragorn", 50, true, 5);
        assertEquals(5, av.getNivelTotal());
        assertEquals(5, av.obtenerNivelDeClase("Guerrero"));

     
        assertTrue(av.agregarClase("Explorador", 3));
        assertEquals(8, av.getNivelTotal());
        assertEquals(3, av.obtenerNivelDeClase("Explorador"));
    }

    @Test
    public void testActualizarNivelClaseExistente() {
        Mago av = new Mago("Gandalf", 40, 2, 4);
        assertTrue(av.agregarClase("Mago", 10));
        assertEquals(10, av.obtenerNivelDeClase("Mago"));
        assertEquals(10, av.getNivelTotal());
    }

    @Test
    public void testValidacionesLimiteNivelYClases() {
        Guerrero av = new Guerrero("Gimli", 60, true, 15);

        
        assertFalse(av.agregarClase("Bardo", 0));
        assertFalse(av.agregarClase("Bardo", 21));

     
        assertFalse(av.agregarClase("Clérigo", 6));
        assertEquals(15, av.getNivelTotal());

     
        assertTrue(av.agregarClase("Clérigo", 1));
        assertTrue(av.agregarClase("Monje", 1));
        assertTrue(av.agregarClase("Pícaro", 1));
        assertFalse(av.agregarClase("Bardo", 1)); 
    }

    @Test
    public void testObtenerClaseInexistente() {
        Bardo av = new Bardo("Jaskier", 25, "Laúd", 3);
        assertEquals(0, av.obtenerNivelDeClase("Paladín"));
    }
}
