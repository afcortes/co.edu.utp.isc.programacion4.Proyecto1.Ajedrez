package co.edu.utp.isc.progra4.ajedrez.modelo;

import java.time.LocalTime;

public class Cronometro {
    private LocalTime[] tiempo;
    private int turno;

    public Cronometro() {
        tiempo = new LocalTime[2];
        turno = 0;
    }
    
    public void iniciar(){
        //TODO: Iniciar el cronometro para el jugador actual
    }
    
    public void cambio(){
        //TODO: Parar el cronometro para el jugador actual
        turno = (turno == 0 ? 1 : 0);
        //TODO: Iniciar el cronometro para el jugador actual
    }
    
    public void parar() {
        //TODO: Parar el cronometro 
        
    }
    
}
