/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.pro4.ajedrez.modelo;

/**
 *
 * @author utp
 */
public class Caballo extends Ficha {

    public Caballo(Color color) {
        super(color);
    }

    @Override
    public boolean mover(String Inicial,String movimiento) {
        if((Math.abs(Inicial.charAt(0)-movimiento.charAt(0))==2)&&(Math.abs(Integer.valueOf(Inicial.substring(1))-Integer.valueOf(movimiento.substring(1)))==1)){
            return true;
        }
        else if((Math.abs(Inicial.charAt(0)-movimiento.charAt(0))==1)&&(Math.abs(Integer.valueOf(Inicial.substring(1))-Integer.valueOf(movimiento.substring(1)))==2)){
            return true;
        }
        return false;
    }

    @Override
    public boolean comer(String Inicial,String movimiento) {
        return this.mover(Inicial, movimiento);
    }

}
