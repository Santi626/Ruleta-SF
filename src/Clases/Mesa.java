/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author santi
 */
public class Mesa {

    private static Resultado[] ruleta;

    public static void armarMesa() {
        //Rellena los datos de la mesa de ruleta
        int[] numNegros = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
        int[] numRojos = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        int numVerdes = 1;

        setRuleta(new Resultado[numNegros.length + numRojos.length + numVerdes]);
//        setRand(new Random());

        //Rellena el verde
        getRuleta()[0] = new Resultado(0, Color.GREEN, 0, 0, 0, 0);
        //Rellena el resto
        for (int i = 1; i < getRuleta().length; i++) {
            //Crea un resultado con el numero y el boolean de la primera mitad
            Resultado resultado = new Resultado(i);
            //Comprueba y hace setters
            //Primeros 18
            if (i <= 18) {
                resultado.setBajo1Alto2(1);
            } else {
                resultado.setBajo1Alto2(2);
            }
            //Color
            boolean rojo = false;
            for (int numRojo : numRojos) {
                if (i == numRojo) {
                    rojo = true;
                }
            }
            if (rojo) {
                resultado.setColor(Color.RED);
            } else {
                resultado.setColor(Color.BLACK);
            }
            //Par
            if (i % 2 == 0) {
                resultado.setPar(1);
            } else {
                resultado.setPar(2);
            }
            //Fila
            if (i % 3 == 0) {
                resultado.setFila(3);
            } else if (i % 3 == 2) {
                resultado.setFila(2);
            } else {
                resultado.setFila(1);
            }
            //Docena
            if (i >= 25) {
                resultado.setDocena(3);
            } else if (i >= 13) {
                resultado.setDocena(2);
            } else {
                resultado.setDocena(1);
            }
            
            //Añade
            getRuleta()[i] = resultado;
            
        }
    }

    public static int getNumCasillas() {
        return getRuleta().length;
    }

    //OUTDATED
    public static void imprimirRuleta() {
        for (int i = 0; i < getRuleta().length; i++) {
            ruleta[i].imprimir();
        }
    }

    public static Resultado getResultado(int num) {
        //Devuelve un Resultado segun el número
        return getRuleta()[num];
    }

    /**
     * @return the ruleta
     */
    public static Resultado[] getRuleta() {
        return ruleta;
    }

    /**
     * @param aRuleta the ruleta to set
     */
    public static void setRuleta(Resultado[] aRuleta) {
        ruleta = aRuleta;
    }
    
}
