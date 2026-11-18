/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Picaro extends Aventurero {
    private boolean tieneHerramientasLadron;

    public Picaro(String nombre, int puntosVida, boolean tieneHerramientasLadron, int nivel) {
        super(nombre, puntosVida);
        this.tieneHerramientasLadron = tieneHerramientasLadron;
        this.agregarClase("Pícaro", nivel);
    }

    public String calcularDadoAtaqueFurtivoDND() {
        int nivelPi = obtenerNivelDeClase("Pícaro");
        int dados = (nivelPi + 1) / 2;
        if (dados < 1) dados = 1;
        return dados + "d6 (Sneak Attack PHB)";
    }

    @Override
    public String simularCombate() {
        String efectividad = TirarEfectividadDND();

        

        return "El Pícaro " + nombre + " (Nivel Pícaro: " + obtenerNivelDeClase("Pícaro") + 
               ") asesta Ataque Furtivo de " + calcularDadoAtaqueFurtivoDND() + " y se reposiciona. -> " + efectividad;
    }
}