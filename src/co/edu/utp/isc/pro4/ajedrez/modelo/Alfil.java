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
public class Alfil extends Ficha {

    public Alfil(Color color) {
        super(color);
    }

    @Override
    public boolean mover(String Inicial,String movimiento) {
        if(Math.abs((int)(Inicial.charAt(0)-movimiento.charAt(0))) == Math.abs(Integer.valueOf(Inicial.substring(1))-Integer.valueOf(movimiento.substring(1)))){
            int incremento1 = Inicial.charAt(0)>movimiento.charAt(0) ? -1 : 1;
            int incremento2 = Integer.valueOf(Inicial.substring(1))>Integer.valueOf(movimiento.substring(1)) ? -1 : 1;
            int i = Integer.valueOf(Inicial.substring(1))+ incremento2;
            char j = (char)(Inicial.charAt(0)+incremento1);
            while((i!=Integer.valueOf(movimiento.substring(1)))&&(j!=movimiento.charAt(0))){
                if(this.getAjedrez().getTablero().getCasilla(i, j).isOcupada()){
                    return false;
                }
                i+=incremento2;
                j = (char)(j+incremento1);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean comer(String Inicial,String movimiento) {
        return this.mover(Inicial, movimiento);
    }


}
