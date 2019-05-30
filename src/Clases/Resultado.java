/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;

/**
 *
 * @author santi
 */
public class Resultado {
    
    private int num;
    private Color color;
    private int par;
    private int bajo1alto2;
    private int docena;
    private int fila;

    public Resultado(int num, Color color, int par, int primeraMitad1a18, int docena, int fila) {
        this.num = num;
        this.color = color;
        this.par = par;
        this.bajo1alto2 = primeraMitad1a18;
        this.docena = docena;
        this.fila = fila;
    }

    public Resultado() {
    }
    
    public Resultado(int num) {
        this.num = num;
    }
    
    public void imprimir() {
        //Imprime por pantalla el resultado
        System.out.println("" + getNum() + getColor() + " Par:" + getPar() + " primeraMitad:" + getBajo1Alto2() +
                getDocena() + getFila());
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the par
     */
    public int getPar() {
        return par;
    }

    /**
     * @param par the par to set
     */
    public void setPar(int par) {
        this.par = par;
    }

    /**
     * @return the bajo1Alto2
     */
    public int getBajo1Alto2() {
        return bajo1alto2;
    }

    /**
     * @param bajo1Alto2 the primeraMitad1a18 to set
     */
    public void setBajo1Alto2(int primeraMitad1a18) {
        this.bajo1alto2 = primeraMitad1a18;
    }

    /**
     * @return the docena
     */
    public int getDocena() {
        return docena;
    }

    /**
     * @param docena the docena to set
     */
    public void setDocena(int docena) {
        this.docena = docena;
    }

    /**
     * @return the fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(int fila) {
        this.fila = fila;
    }
    
}
