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

    @Override
    public void draw(Graphics2D g, float x, float y) {
        GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 17);
        polyline.moveTo(x + 10, y + 45);
        polyline.lineTo(x + 40, y + 45);
        polyline.lineTo(x + 40, y + 38);
        
        
        
        polyline.lineTo(x + 10, y + 38);
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
        
        g.fill(new Ellipse2D.Float(x + 15, y + 20, 20, 8));
        g.setPaint(java.awt.Color.BLACK);
        g.draw(new Ellipse2D.Float(x + 15, y + 20, 20, 8));
    }

}
