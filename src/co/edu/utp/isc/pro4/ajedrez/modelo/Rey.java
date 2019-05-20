/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.pro4.ajedrez.modelo;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

/**
 *
 * @author utp
 */
public class Rey extends Ficha {

    public Rey(Color color) {
        super(color);
    }

    @Override
    public boolean mover(String Inicial,String movimiento) {
        if((Math.abs(Integer.valueOf(Inicial.substring(1))-Integer.valueOf(movimiento.substring(1)))<=1)&&(Math.abs(Inicial.charAt(0)-movimiento.charAt(0))<=1)){
            if(!this.getAjedrez().getTablero().isAmenazada(this.getColor(),this.getAjedrez().getTablero().getCasilla(movimiento))){
                this.setPrimerMovimiento();
                return true;
            }  
        }
        if(!this.getAjedrez().getTablero().isAmenazada(this.getColor(),this.getCasilla())){
            if(this.getColor()==Color.BLANCO){
                if(movimiento.equalsIgnoreCase("G1")){
                    for(int i = this.getCasilla().getColumna()+1;i<='G';i++){
                        if((this.getAjedrez().getTablero().getCasilla(1,((char)(i))).isOcupada())||(this.getAjedrez().getTablero().isAmenazada(this.getColor(), this.getAjedrez().getTablero().getCasilla(1,((char)(i)))))){
                            return false;
                        }
                    }
                    if(this.getAjedrez().getTablero().getCasilla("H1").getFicha() instanceof Torre ){
                        if(!this.isPrimerMovimiento()&&!this.getAjedrez().getTablero().getCasilla("H1").getFicha().isPrimerMovimiento()){
                            this.enroque("H1","F1");
                            return true;
                        }
                    }        
                }
                else if(movimiento.equalsIgnoreCase("C1")){
                    for(int i = this.getCasilla().getColumna()-1;i>='C';i--){
                        if((this.getAjedrez().getTablero().getCasilla(1,((char)(i))).isOcupada())||(this.getAjedrez().getTablero().isAmenazada(this.getColor(), this.getAjedrez().getTablero().getCasilla(1,((char)(i)))))){
                            return false;
                        }
                    }
                    if(!this.getAjedrez().getTablero().getCasilla("B1").isOcupada())
                        if(this.getAjedrez().getTablero().getCasilla("A1").getFicha() instanceof Torre ){
                            if(!this.isPrimerMovimiento()&&!this.getAjedrez().getTablero().getCasilla("A1").getFicha().isPrimerMovimiento()){
                                this.enroque("A1","D1");
                                return true;
                            }
                        } 

                }
            }
            else if(this.getColor()==Color.NEGRO){
                if(movimiento.equalsIgnoreCase("G8")){
                    for(int i = this.getCasilla().getColumna()+1;i<='G';i++){
                        if((this.getAjedrez().getTablero().getCasilla(1,((char)(i))).isOcupada())||(this.getAjedrez().getTablero().isAmenazada(this.getColor(), this.getAjedrez().getTablero().getCasilla(1,((char)(i)))))){
                            return false;
                        }
                    }
                    if(this.getAjedrez().getTablero().getCasilla("H8").getFicha() instanceof Torre ){
                        if(!this.isPrimerMovimiento()&&!this.getAjedrez().getTablero().getCasilla("H8").getFicha().isPrimerMovimiento()){
                            this.enroque("H8","F8");
                            return true;
                        }
                    }        
                }
                else if(movimiento.equalsIgnoreCase("C8")){
                    for(int i = this.getCasilla().getColumna()-1;i>='C';i--){
                        if((this.getAjedrez().getTablero().getCasilla(1,((char)(i))).isOcupada())||(this.getAjedrez().getTablero().isAmenazada(this.getColor(), this.getAjedrez().getTablero().getCasilla(1,((char)(i)))))){
                            return false;
                        }
                    }
                    if(!this.getAjedrez().getTablero().getCasilla("B8").isOcupada())
                        if(this.getAjedrez().getTablero().getCasilla("A8").getFicha() instanceof Torre ){
                            if(!this.isPrimerMovimiento()&&!this.getAjedrez().getTablero().getCasilla("A8").getFicha().isPrimerMovimiento()){
                                this.enroque("A8","D8");
                                return true;
                            }
                        } 

                }
            }
        }
        return false;
    }

    @Override
    public boolean comer(String Inicial,String movimiento) {
        if((Math.abs(Integer.valueOf(Inicial.substring(1))-Integer.valueOf(movimiento.substring(1)))<=1)&&(Math.abs(Inicial.charAt(0)-movimiento.charAt(0))<=1)){
            if(!this.getAjedrez().getTablero().isAmenazada(this.getColor(),this.getAjedrez().getTablero().getCasilla(movimiento))){
                this.setPrimerMovimiento();
                return true;
            }  
        }
        return false;
    }
    
    public void enroque(String inicial,String movimiento){
        Casilla c1 = this.getAjedrez().getTablero().getCasilla(inicial);
        Casilla c2 = this.getAjedrez().getTablero().getCasilla(movimiento);
        Ficha f = c1.getFicha();
        c1.setFicha(null);
        c2.setFicha(f);
    }

    @Override
    public void draw(Graphics2D g, float x, float y) {
        GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 17);
        polyline.moveTo(x + 10, y + 45);
        polyline.lineTo(x + 40, y + 45);
        polyline.lineTo(x + 30, y + 40);
        polyline.lineTo(x + 30, y + 24);
        polyline.lineTo(x + 35, y + 15);
        
        polyline.lineTo(x + 27, y + 15);
        polyline.lineTo(x + 27, y + 11);
        polyline.lineTo(x + 31, y + 11);
        polyline.lineTo(x + 31, y + 8);
        polyline.lineTo(x + 27, y + 8);
        polyline.lineTo(x + 27, y + 5);
        polyline.lineTo(x + 23, y + 5);
        polyline.lineTo(x + 23, y + 8);
        polyline.lineTo(x + 19, y + 8);
        polyline.lineTo(x + 19, y + 11);
        polyline.lineTo(x + 23, y + 11);
        polyline.lineTo(x + 23, y + 15);
        polyline.lineTo(x + 15, y + 15);
        polyline.lineTo(x + 20, y + 24);
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
        
        g.fill(new Ellipse2D.Float(x + 15, y + 26, 20, 5));
        g.fill(new Ellipse2D.Float(x + 20, y + 24, 10, 2));
        g.setPaint(java.awt.Color.BLACK);
        g.draw(new Ellipse2D.Float(x + 15, y + 26, 20, 5));
        g.draw(new Ellipse2D.Float(x + 20, y + 24, 10, 2));
    }


}
