/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author USUARIO
 */
public class ControladorGremioTest {
 private ControladorGremio controlador;

    @Before
    public void setUp() {
      
        controlador = new ControladorGremio();
    }

    @Test
    public void testRegistroExitosoYLimiteGremio() {
        
        String resultado = controlador.procesarRegistro("Sebas", "12", "Guerrero", "si", "3");
        
      
        assertTrue(resultado.contains("¡Éxito!"));
        
   
        assertEquals(1, controlador.getCantidadPersonasUnicas());
    }

    @Test
    public void testValidacionLimiteNivel20() {
      
        controlador.procesarRegistro("Carlos", "15", "Mago", "2", "18");
        
      
        String resultadoExceso = controlador.procesarRegistro("Carlos", "10", "Guerrero", "no", "5");
        
        assertTrue(resultadoExceso.contains("Error: Se excede el límite de nivel 20"));
    }

    @Test
    public void testSimulacionCombateVacia() {
      
        String simulacion = controlador.simularCombateGeneral();
        
        assertTrue(simulacion.contains("No hay aventureros registrados"));
    }
}   

