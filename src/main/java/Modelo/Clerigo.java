/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Clerigo extends Aventurero {
    private String diosVenerado;

    public Clerigo(String nombre, int puntosVida, String diosVenerado, int nivel) {
        super(nombre, puntosVida);
        this.diosVenerado = diosVenerado;
        this.agregarClase("Clérigo", nivel);
    }

   
    public int calcularUsosCanalizar() {
        int nivelC = obtenerNivelDeClase("Clérigo");
        if (nivelC >= 18) return 3;
        if (nivelC >= 6) return 2;
        if (nivelC >= 2) return 1;
        return 0;
    }

    @Override
    public String simularCombate() {
        String efectividad = TirarEfectividadDND();

        return "El Clérigo " + nombre + " de " + diosVenerado + " (Nivel Clérigo: " + obtenerNivelDeClase("Clérigo") + 
               ") usa Canalizar Divinidad (" + calcularUsosCanalizar() + " usos oficiales PHB). -> " + efectividad;
    }
    }
