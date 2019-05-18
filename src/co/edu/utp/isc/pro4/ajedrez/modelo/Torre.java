/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.pro4.ajedrez.modelo;

import java.util.Objects;

/**
 *
 * @author utp
 */
public class Torre extends Ficha {

    public Torre(Color color) {
        super(color);
    }

    @Override
    public boolean mover(String Inicial,String movimiento){
        if(Integer.valueOf(Inicial.substring(1))==Integer.valueOf(movimiento.substring(1))){
            int inicio = Integer.min((int)Inicial.charAt(0),(int)movimiento.charAt(0));
            int fin = Integer.max((int)Inicial.charAt(0),(int)movimiento.charAt(0));
            for (int i = (inicio+1); i <= fin-1; i++){
                if(this.getAjedrez().getTablero().getCasilla(Integer.valueOf(movimiento.substring(1)),(char)(i)).isOcupada()){
                    return false;
                }
            }
            return true;
        }
        else if(Inicial.charAt(0)==(movimiento.charAt(0))){
            int inicio = Integer.min(Integer.valueOf(Inicial.substring(1)), Integer.valueOf(movimiento.substring(1)));
            int fin = Integer.max(Integer.valueOf(Inicial.substring(1)), Integer.valueOf(movimiento.substring(1)));
            System.out.println(inicio);
            System.out.println(fin);
            for (int i = inicio+1; i <= fin-1; i++) {
                if(this.getAjedrez().getTablero().getCasilla(i,movimiento.charAt(0)).isOcupada()){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean comer(String Inicial,String movimiento) {
        System.out.println("Comer");
        return this.mover(Inicial, movimiento);
    }

    
}
