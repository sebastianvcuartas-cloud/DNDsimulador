/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Monje extends Aventurero {
    private int puntosKiBase;

    public Monje(String nombre, int puntosVida, int puntosKiBase, int nivel) {
        super(nombre, puntosVida);
        this.puntosKiBase = puntosKiBase;
        this.agregarClase("Monje", nivel);
    }

   
    public int calcularPuntosKiTotales() {
        int nivelM = obtenerNivelDeClase("Monje");
        return (nivelM >= 2) ? nivelM : puntosKiBase;
    }

   
    public String calcularDadoArtesMarciales() {
        int nivelM = obtenerNivelDeClase("Monje");
        if (nivelM >= 17) return "1d10";
        if (nivelM >= 11) return "1d8";
        if (nivelM >= 5) return "1d6";
        return "1d4";
    }

    @Override
    public String simularCombate() {
        String efectividad = TirarEfectividadDND();


        return "El Monje " + nombre + " (Nivel Monje: " + obtenerNivelDeClase("Monje") + 
               ") gasta " + calcularPuntosKiTotales() + " pts de Ki (Ráfaga de Golpes con " + calcularDadoArtesMarciales() + "). -> " + efectividad;
    }
    }
