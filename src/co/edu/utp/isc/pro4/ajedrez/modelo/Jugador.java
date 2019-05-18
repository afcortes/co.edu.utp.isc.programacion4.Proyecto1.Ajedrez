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
public class Jugador {

    private Ajedrez ajedrez;
    private String nombre;
    private Color color;

    public Jugador(String nombre,Color color) {
        this.nombre = nombre;
        this.color = color;
    }

    public boolean jugar(String[] movimiento) {
        if(this.ajedrez.getTablero().getCasilla(movimiento[0]).isOcupada())
        {
            if(this.ajedrez.getTablero().getCasilla(movimiento[0]).getFicha().getColor()==this.color)
            {
                if(!this.ajedrez.getTablero().getCasilla(movimiento[1]).isOcupada())
                {
                    if(this.ajedrez.getTablero().getCasilla(movimiento[0]).getFicha().mover(movimiento[0],movimiento[1])){
                        Casilla c1 = this.ajedrez.getTablero().getCasilla(movimiento[0]);
                        Casilla c2 = this.ajedrez.getTablero().getCasilla(movimiento[1]);
                        c2.setFicha(c1.getFicha());
                        c1.setFicha(null);
                        return true;
                    }
                }
                
                else if(this.ajedrez.getTablero().getCasilla(movimiento[1]).getFicha().getColor()!=this.color){
                    if(this.ajedrez.getTablero().getCasilla(movimiento[0]).getFicha() instanceof Torre){
                        System.out.println("como con torre");
                    }
                        if(this.ajedrez.getTablero().getCasilla(movimiento[0]).getFicha().comer(movimiento[0],movimiento[1])){
                            Casilla c1 = this.ajedrez.getTablero().getCasilla(movimiento[0]);
                            Casilla c2 = this.ajedrez.getTablero().getCasilla(movimiento[1]);
                            c2.setFicha(c1.getFicha());
                            c1.setFicha(null);
                            return true;
                        } 
                }

            }
        }
        return false;
    }

    public void setAjedrez(Ajedrez ajedrez) {
        this.ajedrez = ajedrez;
    }

    public String getNombre() {
        return this.nombre;
    }

    private void rendirse() {
        // No me gusta pero los estudiantes lo pidieron
        ajedrez.rendirse();
    }
    
    public Color getColor(){
        return this.color;
    }

}
