/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.progra4.ajedrez.modelo;

import co.edu.utp.isc.progra4.ajedrez.controlador.Ajedrez;
import co.edu.utp.isc.progra4.ajedrez.controlador.Dibujable;

/**
 *
 * @author utp
 */
public abstract class Ficha extends Dibujable{

    private Casilla casilla;
    private final Color color;
    private Ajedrez ajedrez;
    private boolean primerMovimiento;

    public Ficha(Color color) {
        this.color = color;
        this.primerMovimiento = false;
    }

    public abstract boolean mover(String Inicial,String movimiento);

    public abstract boolean comer(String Inicial,String movimiento);

    public Casilla getCasilla() {
        return casilla;
    }
    
    public void setAjedrez(Ajedrez ajedrez){
        this.ajedrez = ajedrez;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    public Color getColor() {
        return this.color;
    }
    
    public Ajedrez getAjedrez(){
        return this.ajedrez;
    }
    
    public boolean isPrimerMovimiento(){
        return this.primerMovimiento;
    }
    
    public void setPrimerMovimiento(){
        this.primerMovimiento = true;
    }

    @Override
    public String toString() {
        String tipo = "";
        if (this instanceof Peon) {
            tipo = "P";
        } else if (this instanceof Torre) {
            tipo = "T";
        } else if (this instanceof Caballo) {
            tipo = "C";
        } else if (this instanceof Alfil) {
            tipo = "A";
        } else if (this instanceof Reina) {
            tipo = "Q";
        } else if (this instanceof Rey) {
            tipo = "R";
        }
        return tipo + (getColor() == Color.BLANCO ? "B" : "N");
    }

}
