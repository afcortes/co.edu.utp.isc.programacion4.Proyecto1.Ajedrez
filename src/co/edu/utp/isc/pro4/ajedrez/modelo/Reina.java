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
public class Reina extends Ficha {

    public Reina(Color color) {
        super(color);
    }

    @Override
    public boolean mover(String Inicial,String movimiento) {
        if(Integer.valueOf(Inicial.substring(1))==Integer.valueOf(movimiento.substring(1))){
            int inicio = Integer.min((int)Inicial.charAt(0),(int)movimiento.charAt(0));
            int fin = Integer.max((int)Inicial.charAt(0),(int)movimiento.charAt(0));
            for (int i = (inicio+1); i <= fin-1; i++){
                System.out.println("Pregunto");
                if(this.getAjedrez().getTablero().getCasilla(Integer.valueOf(movimiento.substring(1)),(char)(i)).isOcupada()){
                    System.out.println(i+" Esta ocupado");
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
        else if(Math.abs((int)(Inicial.charAt(0)-movimiento.charAt(0))) == Math.abs(Integer.valueOf(Inicial.substring(1))-Integer.valueOf(movimiento.substring(1)))){
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
