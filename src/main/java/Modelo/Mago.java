/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Mago extends Aventurero {
    private int cantidadLibrosHechizos;

    public Mago(String nombre, int puntosVida, int cantidadLibrosHechizos, int nivel) {
        super(nombre, puntosVida);
        this.cantidadLibrosHechizos = cantidadLibrosHechizos;
        this.agregarClase("Mago", nivel);
    }

 
    public String calcularCirculoMaximo() {
        int nivelM = obtenerNivelDeClase("Mago");
        int circulo = Math.min(9, (nivelM + 1) / 2);
        return "Conjuros de hasta Círculo " + circulo;
    }

    @Override
    public String simularCombate() {
                String efectividad = TirarEfectividadDND();
        return "El Mago " + nombre + " (Nivel Mago: " + obtenerNivelDeClase("Mago") + 
               ") gasta un espacio de conjuro para lanzar Bola de Fuego [" + calcularCirculoMaximo() + "]. -> " + efectividad;
    }
    }
