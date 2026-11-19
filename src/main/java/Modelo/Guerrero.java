/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author USUARIO
 */
public class Guerrero extends Aventurero {
    private boolean armaduraPesada;
    
    public Guerrero(String nombre, int puntosVida, boolean armaduraPesada) {
        super(nombre, puntosVida);
        this.armaduraPesada = armaduraPesada;
        this.agregarClase("Guerrero", 1);
    }

    public Guerrero(String nombre, int puntosVida, boolean armaduraPesada, int nivel) {
        super(nombre, puntosVida);
        this.armaduraPesada = armaduraPesada;
        this.agregarClase("Guerrero", nivel);
    }

    
    public int calcularAtaquesPorAccion() {
        int nivelG = obtenerNivelDeClase("Guerrero");
        if (nivelG >= 20) return 4;
        if (nivelG >= 11) return 3;
        if (nivelG >= 5) return 2;
        return 1;
    }

    @Override
    public String simularCombate() {
        
        int ataques = calcularAtaquesPorAccion();
        String efectividad = TirarEfectividadDND();
        String proteccion = armaduraPesada ? "con Armadura Pesada" : "con Armadura Ligera";
        return "El Guerrero " + nombre + " (" + proteccion + ", Nivel Guerrero: " + obtenerNivelDeClase("Guerrero") + 
               ") usa Oleada de Acción para ejecutar " + ataques + " ataques físicos. -> "+ efectividad;
    }
}
    

