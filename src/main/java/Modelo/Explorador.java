/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Explorador extends Aventurero {
    private String terrenoFavorecido;

    public Explorador(String nombre, int puntosVida, String terrenoFavorecido, int nivel) {
        super(nombre, puntosVida);
        this.terrenoFavorecido = terrenoFavorecido;
        this.agregarClase("Explorador", nivel);
    }

    // Regla oficial D&D 5e: Explorador Natural y bonificadores por hito de nivel
    public String calcularVentajaTerreno() {
        int nivelE = obtenerNivelDeClase("Explorador");
        if (nivelE >= 10) return "Maestría de rastreo en " + terrenoFavorecido;
        return "Explorador Natural en " + terrenoFavorecido;
    }

    @Override
    public String simularCombate() {
        String efectividad = TirarEfectividadDND();

        return "El Explorador " + nombre + " (Nivel Explorador: " + obtenerNivelDeClase("Explorador") + 
               ") aplica Marca del Cazador (" + calcularVentajaTerreno() + "). -> " + efectividad;
    }
    }
