/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.Random;
/**
 *
 * @author USUARIO
 */
  public abstract class Aventurero implements IAccionCombate {
    protected String nombre;
    protected int puntosVida;
    
    protected String[] clases;
    protected int[] nivelesClases;
    protected int contadorClases;

    public Aventurero(String nombre, int puntosVida) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.clases = new String[4];
        this.nivelesClases = new int[4];
        this.contadorClases = 0;
    }

    public boolean agregarClase(String nombreClase, int nivelClase) {
        if (nivelClase < 1 || nivelClase > 20) {
            return false;
        }

        for (int i = 0; i < contadorClases; i++) {
            if (clases[i] != null && clases[i].equalsIgnoreCase(nombreClase)) {
                int nivelTotalSinEsta = getNivelTotal() - nivelesClases[i];
                if (nivelTotalSinEsta + nivelClase > 20) {
                    return false;
                }
                nivelesClases[i] = nivelClase;
                return true;
            }
        }

        if (contadorClases >= 4) {
            return false;
        }

        if (getNivelTotal() + nivelClase > 20) {
            return false;
        }

        clases[contadorClases] = nombreClase;
        nivelesClases[contadorClases] = nivelClase;
        contadorClases++;
        return true;
    }

    public int getNivelTotal() {
        int sumaTotal = 0;
        for (int i = 0; i < contadorClases; i++) {
            sumaTotal += nivelesClases[i];
        }
        return sumaTotal;
    }

    public int obtenerNivelDeClase(String nombreClase) {
        for (int i = 0; i < contadorClases; i++) {
            if (clases[i] != null && clases[i].equalsIgnoreCase(nombreClase)) {
                return nivelesClases[i];
            }
        }
        return 0;
    }

    public String getNombre() { return nombre; }
    public int getPuntosVida() { return puntosVida; }
    public String TirarEfectividadDND() {
    Random rand = new Random();
    int d20 = rand.nextInt(20) + 1; 
    
    if (d20 == 20) {
        return "¡CRÍTICO NATURAL! (20) ¡Golpe devastador con doble de efectividad!";
    } else if (d20 == 1) {
        return "¡FALLO CRÍTICO! (1) ¡Fallo catastrófico!";
    } else if (d20 >= 12) {
        return "¡Impacto exitoso! (Tirada del d20: " + d20 + ")";
    } else {
        return "El ataque falla. (Tirada del d20: " + d20 + ")";
    }
}
}
    
