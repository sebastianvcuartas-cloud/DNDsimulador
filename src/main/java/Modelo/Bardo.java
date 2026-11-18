/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Bardo extends Aventurero {
    private String instrumentoMusical;

    public Bardo(String nombre, int puntosVida, String instrumentoMusical, int nivel) {
        super(nombre, puntosVida);
        this.instrumentoMusical = instrumentoMusical;
        this.agregarClase("Bardo", nivel);
    }

   
    public String calcularDadoInspiracionBardica() {
        int nivelB = obtenerNivelDeClase("Bardo");
        if (nivelB >= 15) return "d12";
        if (nivelB >= 10) return "d10";
        if (nivelB >= 5) return "d8";
        return "d6";
    }

    @Override
    public String simularCombate() {
       String efectividad = TirarEfectividadDND();


        return "El Bardo " + nombre + " toca su " + instrumentoMusical + " (Nivel Bardo: " + obtenerNivelDeClase("Bardo") + 
               ") otorgando Inspiración Bárdica (" + calcularDadoInspiracionBardica() + " PHB). -> " + efectividad;
    }
}