package co.edu.utp.isc.pro4.ajedrez.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics2D;

/**
 *
 * @author utp
 */
public abstract class Dibujable {
    
    public abstract void draw(Graphics2D g, float x, float y);
}