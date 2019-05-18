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
public class Peon extends Ficha {

    private boolean primerMovimiento;
    
    public Peon(Color color) {
        super(color);
        primerMovimiento = false;
    }

    @Override
    public boolean mover(String Inicial,String movimiento) {
        if(this.getColor() == Color.BLANCO){
            if(Inicial.charAt(0)==movimiento.charAt(0)){
               if(Integer.valueOf(Inicial.substring(1))+1 == Integer.valueOf(movimiento.substring(1))){
                   return true;
               }
               else if((Integer.valueOf(Inicial.substring(1))+2 == Integer.valueOf(movimiento.substring(1)))&&this.primerMovimiento==false){
                   if(!this.getAjedrez().getTablero().getCasilla((Integer.valueOf(Inicial.substring(1))+1),Inicial.charAt(0)).isOcupada()){
                       this.primerMovimiento = true;
                       return true;
                   }  
               }
            }
        }
        else if(this.getColor() == Color.NEGRO){
            if(Inicial.charAt(0)==movimiento.charAt(0)){
               if(Integer.valueOf(Inicial.substring(1))-1 == Integer.valueOf(movimiento.substring(1))){
                   return true;
               }
               else if((Integer.valueOf(Inicial.substring(1))-2 == Integer.valueOf(movimiento.substring(1)))&&this.primerMovimiento==false){
                   if(!this.getAjedrez().getTablero().getCasilla((Integer.valueOf(Inicial.substring(1))-1),Inicial.charAt(0)).isOcupada()){
                       this.primerMovimiento = true;
                       return true;
                   }  
               }
            }
        }
        return false;
    }

    @Override
    public boolean comer(String Inicial,String movimiento) {
        if(this.getColor()==Color.BLANCO){
            if((Integer.valueOf(movimiento.substring(1))==Integer.valueOf(Inicial.substring(1))+1)){
                if((Inicial.charAt(0)+1==movimiento.charAt(0))||(Inicial.charAt(0)-1==movimiento.charAt(0))){
                    return true;
                }
            }
        }
        if(this.getColor()==Color.NEGRO){
            if((Integer.valueOf(movimiento.substring(1))==Integer.valueOf(Inicial.substring(1))-1)){
                if((Inicial.charAt(0)+1==movimiento.charAt(0))||(Inicial.charAt(0)-1==movimiento.charAt(0))){
                    return true;
                }
            }
        }
        return false;
    }
    

}
