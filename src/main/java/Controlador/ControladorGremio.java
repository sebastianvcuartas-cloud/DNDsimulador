/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author USUARIO
 */
import Modelo.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;

public class ControladorGremio {
    private List<Aventurero> listaAventureros;
    private static final String ARCHIVO_TXT = "registro_gremio.txt";

    public ControladorGremio() {
        this.listaAventureros = new ArrayList<>();
    }

   public boolean registrarAventurero(Aventurero av) {
    if (av == null) {
        return false;
    }

    String nombreNuevo = av.getNombre().trim();
    boolean personaExiste = false;
    int nivelesActualesPersona = 0;
    int clasesRegistradasPersona = 0;

  
    for (Aventurero a : listaAventureros) {
        if (a.getNombre().trim().equalsIgnoreCase(nombreNuevo)) {
            personaExiste = true;
            nivelesActualesPersona += a.getNivelTotal();
            clasesRegistradasPersona++; 
        }
    }

  
    if (personaExiste && clasesRegistradasPersona >= 4) {
        return false; 
    }

  
    if (nivelesActualesPersona + av.getNivelTotal() > 20) {
        return false; 
    }

   
    if (!personaExiste) {
        List<String> nombresUnicos = new ArrayList<>();

for (Aventurero a : listaAventureros) {
    String nombreProcesado = a.getNombre().trim().toLowerCase();
    
    
    if (!nombresUnicos.contains(nombreProcesado)) {
        nombresUnicos.add(nombreProcesado);
    }
}

long personasDistintas = nombresUnicos.size();
        
        if (personasDistintas >= 4) {
            return false; 
        }
    }

  
    listaAventureros.add(av);
    guardarEnArchivo("REGISTRO: " + av.getNombre() + " - Clase: " + av.getClass().getSimpleName() + " (Nivel: " + av.getNivelTotal() + ")");
    return true;
   }


    public String simularCombateGeneral() {
        if (listaAventureros.isEmpty()) {
        return "No hay aventureros registrados en el gremio para simular combate.\n";
    }

    String reporte = "\n--- INICIO DE SIMULACIÓN DE COMBATE (d20) ---\n";

    for (Aventurero av : listaAventureros) {
    String resultadoCombate = av.simularCombate();
    reporte += resultadoCombate + "\n";
    guardarEnArchivo("COMBATE: " + resultadoCombate);
}

    reporte += "----------------------------------------\n";
    return reporte;
    }

    public List<Aventurero> getListaAventureros() {
        return listaAventureros;
    }
public void guardarEnArchivo(String texto) {
 
    try (PrintWriter writer = new PrintWriter(new FileWriter("registro_gremio.txt", true))) {
        writer.println(texto);
    } catch (IOException e) {
        System.err.println("Error al guardar en el archivo: " + e.getMessage());
    }

 }
    public int getCantidadPersonasUnicas() {
    List<String> nombresUnicos = new ArrayList<>();
    
    for (Aventurero a : listaAventureros) {
        String nombreProcesado = a.getNombre().trim().toLowerCase();
        
      
        if (!nombresUnicos.contains(nombreProcesado)) {
            nombresUnicos.add(nombreProcesado);
        }
    }
    
    return nombresUnicos.size();
}

    public String procesarRegistro(String nombre, String pvStr, String claseSeleccionada, String extra, String nivelClaseStr) {
    try {
        if (nombre == null || nombre.trim().isEmpty()) {
            return "Error: El nombre no puede estar vacío.";
        }

        int pv = Integer.parseInt(pvStr);
        int nivelClase = Integer.parseInt(nivelClaseStr);

        Aventurero nuevoAventurero = null;

       
        if (claseSeleccionada.equalsIgnoreCase("Guerrero")) {
    boolean armaduraPesada = extra.equalsIgnoreCase("si") || extra.equalsIgnoreCase("true");
    nuevoAventurero = new Guerrero(nombre, pv, armaduraPesada, nivelClase);
    
    } else if (claseSeleccionada.equalsIgnoreCase("Mago")) {
    int libros = Integer.parseInt(extra);
    nuevoAventurero = new Mago(nombre, pv, libros, nivelClase);
    
    } else if (claseSeleccionada.equalsIgnoreCase("Clérigo")) {
    nuevoAventurero = new Clerigo(nombre, pv, extra, nivelClase);
    
    } else if (claseSeleccionada.equalsIgnoreCase("Monje")) {
    int ki = Integer.parseInt(extra);
    nuevoAventurero = new Monje(nombre, pv, ki, nivelClase);
    
    } else if (claseSeleccionada.equalsIgnoreCase("Paladín")) {
    int fuerza = Integer.parseInt(extra);
    nuevoAventurero = new Paladin(nombre, pv, fuerza, nivelClase);
    
    } else if (claseSeleccionada.equalsIgnoreCase("Explorador")) {
    nuevoAventurero = new Explorador(nombre, pv, extra, nivelClase);
    
    } else if (claseSeleccionada.equalsIgnoreCase("Pícaro")) {
    boolean ladron = extra.equalsIgnoreCase("si") || extra.equalsIgnoreCase("true");
    nuevoAventurero = new Picaro(nombre, pv, ladron, nivelClase);
    
    } else if (claseSeleccionada.equalsIgnoreCase("Bardo")) {
    nuevoAventurero = new Bardo(nombre, pv, extra, nivelClase);
    
    } else {
    return "Error: Clase no válida.";
}
       
        String nombreNuevo = nuevoAventurero.getNombre().trim();
        boolean personaExiste = false;
        int nivelesActualesPersona = 0;
        int clasesRegistradasPersona = 0;

        for (Aventurero a : listaAventureros) {
            if (a.getNombre().trim().equalsIgnoreCase(nombreNuevo)) {
                personaExiste = true;
                nivelesActualesPersona += a.getNivelTotal();
                clasesRegistradasPersona++;
            }
        }

        if (personaExiste && clasesRegistradasPersona >= 4) {
            return "Error: Este personaje ya tiene el máximo de 4 clases distintas.";
        }

        if (nivelesActualesPersona + nuevoAventurero.getNivelTotal() > 20) {
            return "Error: Se excede el límite de nivel 20 acumulado para este personaje.";
        }

        if (!personaExiste) {
            long personasDistintas = getCantidadPersonasUnicas();
            if (personasDistintas >= 4) {
                return "Error: El gremio ya está lleno (máximo 4 aventureros distintos).";
            }
        }

       
        listaAventureros.add(nuevoAventurero);
        guardarEnArchivo("REGISTRO: " + nuevoAventurero.getNombre() + " - Clase: " + claseSeleccionada + " (Nivel: " + nuevoAventurero.getNivelTotal() + ")");
        
        return "¡Éxito! Registrado: " + nuevoAventurero.getNombre() + " (" + claseSeleccionada + ", Nivel Total: " + nuevoAventurero.getNivelTotal() + "). Gremio: " + getCantidadPersonasUnicas() + "/4";

    } catch (NumberFormatException e) {
        return "Error de formato: Verifique que PV, Nivel y Atributo numérico sean válidos.";
}
}
}

     
