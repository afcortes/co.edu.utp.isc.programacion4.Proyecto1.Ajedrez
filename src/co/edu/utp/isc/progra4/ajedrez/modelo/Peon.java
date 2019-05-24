/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.progra4.ajedrez.modelo;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
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
               if(Integer.valueOf(movimiento.substring(1))==8){
                   this.rescatar(movimiento);
               }
               else if(Integer.valueOf(Inicial.substring(1))+1 == Integer.valueOf(movimiento.substring(1))){
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
                if(Integer.valueOf(movimiento.substring(1))==1){
                   this.rescatar(movimiento);
               }
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
                if(Integer.valueOf(movimiento.substring(1))==8){
                   this.rescatar(movimiento);
               }
                if((Inicial.charAt(0)+1==movimiento.charAt(0))||(Inicial.charAt(0)-1==movimiento.charAt(0))){
                    this.primerMovimiento = true;
                    return true;
                }
            }
        }
        if(this.getColor()==Color.NEGRO){
            if((Integer.valueOf(movimiento.substring(1))==Integer.valueOf(Inicial.substring(1))-1)){
                if(Integer.valueOf(movimiento.substring(1))==1){
                   this.rescatar(movimiento);
               }
                if((Inicial.charAt(0)+1==movimiento.charAt(0))||(Inicial.charAt(0)-1==movimiento.charAt(0))){
                    this.primerMovimiento = true;
                    return true;
                }
            }
        }
        return false;
    }
    
    private void rescatar(String movimiento){
        Ficha ficha = null;
        this.getAjedrez().getTablero().getCasilla(movimiento).setFicha(ficha);
        this.getCasilla().setFicha(null);
    }

    @Override
    public void draw(Graphics2D g, float x, float y) {
        GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 17);
        polyline.moveTo(x + 15, y + 45);
        polyline.lineTo(x + 35, y + 45);
        polyline.lineTo(x + 30, y + 40);
        polyline.lineTo(x + 30, y + 31);      
        polyline.lineTo(x + 20, y + 31);
        polyline.lineTo(x + 20, y + 40);
        polyline.lineTo(x + 15, y + 45);
        
        
        g.setPaint(new GradientPaint(x, y,
                getColor() == Color.BLANCO ? java.awt.Color.CYAN : java.awt.Color.BLACK,
                x + 100, y + 50,
                java.awt.Color.WHITE));
        g.fill(polyline);

        g.setColor(java.awt.Color.BLACK);
        g.draw(polyline);

        
        g.setPaint(new GradientPaint(x, y,
                getColor() == Color.NEGRO ? java.awt.Color.BLACK : java.awt.Color.CYAN,
                x + 50, y + 50,
                java.awt.Color.WHITE));
        
        g.fill(new Ellipse2D.Float(x + 17, y + 10, 16, 16));
        g.fill(new Ellipse2D.Float(x + 17, y + 26, 16, 5));
        g.setPaint(java.awt.Color.BLACK);
        g.draw(new Ellipse2D.Float(x + 17, y + 10, 16, 16));
        g.draw(new Ellipse2D.Float(x + 17, y + 26, 16, 5));

    }
    

}
