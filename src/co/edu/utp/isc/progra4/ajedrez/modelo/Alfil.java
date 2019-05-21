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

    @Override
    public void draw(Graphics2D g, float x, float y) {
        GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 17);
        polyline.moveTo(x + 10, y + 45);
        polyline.lineTo(x + 40, y + 45);
        polyline.lineTo(x + 30, y + 40);
        polyline.lineTo(x + 30, y + 31);      
        polyline.lineTo(x + 20, y + 31);
        polyline.lineTo(x + 20, y + 40);
        polyline.lineTo(x + 10, y + 45);
        
        
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
        
        g.fill(new Ellipse2D.Float(x + 21, y + 5, 8, 5));
        g.fill(new Ellipse2D.Float(x + 17, y + 10, 16, 16));
        g.fill(new Ellipse2D.Float(x + 15, y + 26, 20, 5));
        g.setPaint(java.awt.Color.BLACK);
        g.draw(new Ellipse2D.Float(x + 21, y + 5, 8, 5));
        g.draw(new Ellipse2D.Float(x + 17, y + 10, 16, 16));
        g.draw(new Ellipse2D.Float(x + 15, y + 26, 20, 5));
        
    }


}
