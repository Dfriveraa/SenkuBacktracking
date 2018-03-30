/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitario;

/**
 *
 * @author danie
 */
public class Posicion {

    boolean arriba, abajo, izquierda, derecha;
    int x,y;
    boolean viable;
    Salto saltoArriba;
    Salto saltoAbajo;
    Salto saltoDerecha;
    Salto saltoIzquierda;
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isViable() {
        return viable;
    }

    public void setViable(boolean viable) {
        this.viable = viable;
    }
    
    public Posicion(int x,int y) {
        this.arriba = false;
        this.abajo = false;
        this.izquierda = false;
        this.derecha = false;
        this.viable=false;
        this.x=x;
        this.y=y;
    }

   

    public boolean isArriba() {
        return arriba;
    }

    public void setArriba(boolean arriba) {
        this.arriba = arriba;
        this.saltoArriba=new Salto(x,y,x-2,y);
    }

    public boolean isAbajo() {
        return abajo;
    }

    public void setAbajo(boolean abajo) {
        this.abajo = abajo;
        this.saltoAbajo=new Salto(x,y,x+2,y);
    }

    public boolean isIzquierda() {
        return izquierda;
    }

    public void setIzquierda(boolean izquierda) {
        this.izquierda = izquierda;
        this.saltoIzquierda=new Salto(x,y,x,y-2);
    }

    public boolean isDerecha() {
        return derecha;
    }

    public void setDerecha(boolean derecha) {
        this.derecha = derecha;
        this.saltoDerecha=new Salto(x,y,x,y+2);
    }
    
}
