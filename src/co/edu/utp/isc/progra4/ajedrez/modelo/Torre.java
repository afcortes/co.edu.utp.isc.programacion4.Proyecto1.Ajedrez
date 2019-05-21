/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.progra4.ajedrez.modelo;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

/**
 *
 * @author utp
 */
public class Torre extends Ficha {

    private boolean primerMovimiento;
    
    public Torre(Color color) {
        super(color);
        primerMovimiento = false;
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
            this.setPrimerMovimiento();
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
            this.setPrimerMovimiento();
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
        polyline.moveTo(x + 5, y + 5);
        polyline.lineTo(x + 5, y + 15);
        polyline.lineTo(x + 10, y + 15);
        polyline.lineTo(x + 10, y + 45);
        polyline.lineTo(x + 40, y + 45);
        polyline.lineTo(x + 40, y + 15);
        polyline.lineTo(x + 45, y + 15);
        polyline.lineTo(x + 45, y + 5);
        polyline.lineTo(x + 37, y + 5);
        polyline.lineTo(x + 37, y + 10);
        polyline.lineTo(x + 29, y + 10);
        polyline.lineTo(x + 29, y + 5);
        polyline.lineTo(x + 21, y + 5);
        polyline.lineTo(x + 21, y + 10);
        polyline.lineTo(x + 13, y + 10);
        polyline.lineTo(x + 13, y + 5);
        polyline.lineTo(x + 5, y + 5);

        g.setPaint(new GradientPaint(x, y,
                getColor() == Color.BLANCO ? java.awt.Color.CYAN : java.awt.Color.BLACK,
                x + 100, y + 50,
                java.awt.Color.WHITE));
        g.fill(polyline);

        g.setColor(java.awt.Color.BLACK);
        g.draw(polyline);
    }

}
