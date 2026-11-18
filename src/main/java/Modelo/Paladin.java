/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Paladin extends Aventurero {
    private int puntosFuerza;

    public Paladin(String nombre, int puntosVida, int puntosFuerza, int nivel) {
        super(nombre, puntosVida);
        this.puntosFuerza = puntosFuerza;
        this.agregarClase("Paladín", nivel);
    }

 
    public String calcularPotenciaCastigo() {
        int nivelP = obtenerNivelDeClase("Paladín");
        int dados = Math.min(5, Math.max(1, nivelP));
        return dados + "d8 de daño radiante (Divine Smite PHB)";
    }

    @Override
    public String simularCombate() {
         String efectividad = TirarEfectividadDND();

        return "El Paladín " + nombre + " (Nivel Paladín: " + obtenerNivelDeClase("Paladín") + 
               ") ejecuta Castigo Divino con " + calcularPotenciaCastigo() + ". -> " + efectividad;
    }
    }
