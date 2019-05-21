package co.edu.utp.isc.progra4.ajedrez.controlador;

import co.edu.utp.isc.progra4.ajedrez.modelo.Alfil;
import co.edu.utp.isc.progra4.ajedrez.modelo.Caballo;
import co.edu.utp.isc.progra4.ajedrez.modelo.Casilla;
import co.edu.utp.isc.progra4.ajedrez.modelo.Color;
import co.edu.utp.isc.progra4.ajedrez.modelo.Cronometro;
import co.edu.utp.isc.progra4.ajedrez.modelo.Ficha;
import co.edu.utp.isc.progra4.ajedrez.modelo.Jugador;
import co.edu.utp.isc.progra4.ajedrez.modelo.Peon;
import co.edu.utp.isc.progra4.ajedrez.modelo.Reina;
import co.edu.utp.isc.progra4.ajedrez.modelo.Rey;
import co.edu.utp.isc.progra4.ajedrez.modelo.Tablero;
import co.edu.utp.isc.progra4.ajedrez.modelo.Torre;
import co.edu.utp.isc.pro4gra.ajedrez.ui.PnlTablero;
import co.edu.utp.isc.pro4gra.ajedrez.ui.FrmAjedrez;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Ajedrez {

    private FrmAjedrez frmAjedrez;
    private PnlTablero pnlTablero;
    private Jugador[] jugadores;
    private Tablero tablero;
    private Cronometro cronometro;

    private int turno;

    public Ajedrez() {
        jugadores = new Jugador[2];
        tablero = new Tablero();
        cronometro = new Cronometro();
        turno = 0;

    }

    public Ajedrez(Jugador jugador1, Jugador jugador2) {
        this();
        this.jugadores[0] = jugador1;
        this.jugadores[1] = jugador2;
    }


    public void jugar(String[] jugada) {
            System.out.println(jugadores[turno].getColor() == Color.BLANCO ? "Turno blanco" : "Turno negro");
            if(jugadores[turno].jugar(jugada)){
                // Validar si hay Jaque Mate y terminar
                this.frmAjedrez.setTextMovimientos(jugada);
                if (this.frmAjedrez.isTerminado()) {
                    turno = (turno == 0 ? 1 : 0);
                } else if (validarJaque()) {
                    if(validarJaqueMate()){
                        this.frmAjedrez.setTerminado();
                        this.terminarJuego();
                    }
                    System.out.println("Jaque");
                } else if (validarTablas()) {
                    this.terminarJuego();
                }
                this.mostrarTablero();
                // Sino, cambiar turno
                cambioTurno();
                this.frmAjedrez.setTextLblJugador(this.jugadores[turno].getNombre());
            }
    }

    public void cambioTurno() {
        turno = (turno == 0 ? 1 : 0);
        cronometro.cambio();
    }

    public void setPnlTablero(PnlTablero pnlTablero) {
        this.pnlTablero = pnlTablero;
        pnlTablero.setTablero(tablero);
    }
    
    public void setFrmAjedrez(FrmAjedrez frmAjedrez){
        this.frmAjedrez = frmAjedrez;
    }
    
    private boolean validarJaqueMate() {
        int jaqueMate = this.turno == 1 ? 0 : 1;
        return this.tablero.validarJaqueMate(this.jugadores[jaqueMate].getColor(),this.jugadores[jaqueMate].getRey());
    }

    private boolean validarTablas() {
        //TODO: Validar si los jugadores se han quedado sin posibilidad de ganar
        return false;
    }

    public void rendirse() {
        this.frmAjedrez.setTerminado();
    }

    private void ubicarFichasTablero() {
        asociarFichaTablero(tablero.getCasilla("A1"), new Torre(Color.BLANCO));
        asociarFichaTablero(tablero.getCasilla("B1"), new Caballo(Color.BLANCO));
        asociarFichaTablero(tablero.getCasilla("C1"), new Alfil(Color.BLANCO));
        asociarFichaTablero(tablero.getCasilla("D1"), new Reina(Color.BLANCO));
        asociarFichaTablero(tablero.getCasilla("E1"), new Rey(Color.BLANCO));
        asociarFichaTablero(tablero.getCasilla("F1"), new Alfil(Color.BLANCO));
        asociarFichaTablero(tablero.getCasilla("G1"), new Caballo(Color.BLANCO));
        asociarFichaTablero(tablero.getCasilla("H1"), new Torre(Color.BLANCO));

        asociarFichaTablero(tablero.getCasilla("A8"), new Torre(Color.NEGRO));
        asociarFichaTablero(tablero.getCasilla("B8"), new Caballo(Color.NEGRO));
        asociarFichaTablero(tablero.getCasilla("C8"), new Alfil(Color.NEGRO));
        asociarFichaTablero(tablero.getCasilla("D8"), new Reina(Color.NEGRO));
        asociarFichaTablero(tablero.getCasilla("E8"), new Rey(Color.NEGRO));
        asociarFichaTablero(tablero.getCasilla("F8"), new Alfil(Color.NEGRO));
        asociarFichaTablero(tablero.getCasilla("G8"), new Caballo(Color.NEGRO));
        asociarFichaTablero(tablero.getCasilla("H8"), new Torre(Color.NEGRO));

        for (int i = 0; i < 8; i++) {
            asociarFichaTablero(tablero.getCasilla(1, i), new Peon(Color.BLANCO));
            asociarFichaTablero(tablero.getCasilla(6, i), new Peon(Color.NEGRO));
        }

    }

    private void asociarFichaTablero(Casilla c, Ficha f) {
        f.setCasilla(c);
        c.setFicha(f);
        f.setAjedrez(this);
    }

    public Tablero getTablero() {
        return tablero;
    }
    
    

    private void mostrarTablero() {
        pnlTablero.updateUI();
        System.out.println("  \tA \tB \tC \tD \tE \tF \tG \tH");
        for (int i = 0; i < 8; i++) {
            System.out.print((i + 1));
            for (int j = 0; j < 8; j++) {
                System.out.print("\t" + tablero.getCasilla(i, j));
            }
            System.out.println();
        }
    }

    private boolean validarJaque() {
        int jaque = this.turno == 1 ? 0 : 1;
        return this.tablero.validarJaque(this.jugadores[jaque].getColor(),this.jugadores[jaque].getRey());
    }

    public void IniciarJuego() {
        jugadores[0].setAjedrez(this);
        jugadores[1].setAjedrez(this);
        jugadores[0].setRey();
        jugadores[1].setRey();

        this.ubicarFichasTablero();
        this.mostrarTablero();
        this.frmAjedrez.setTextLblJugador(this.jugadores[turno].getNombre());

        cronometro.iniciar();    
    }
    
    public void terminarJuego(){
        cronometro.parar();

        //TODO: Cambiarlo de lugar
        if (this.frmAjedrez.isTerminado()) {
            System.out.println("El Jugador "
                    + jugadores[turno].getNombre() + " ha ganado");
        } else {
            System.out.println("Los jugadores han quedado en tablas");
        }
    }

}
