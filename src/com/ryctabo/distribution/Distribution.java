/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryctabo.distribution;

/**
 *
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class Distribution {
    
    /**
     * Este método se encarga de devolver la variable aleatoria de un número 
     * pseudo-aleatorio generado.
     * 
     * @param media media
     * @param value valor pseudo-aleatorio
     * @return variable aleatoria
     */
    public static double exponential(int media, double value) {
        return - media * java.lang.Math.log(value);
    }
    
    /**
     * Este método se encarga de devolver la variable aleatoria de un número 
     * pseudo-aleatorio generado.
     * 
     * @param landa landa =  1 / media
     * @param value valor pseudo-aleatorio
     * @return variable aleatoria
     */
    public static double exponential(double landa, double value) {
        return - (1d / landa) * java.lang.Math.log(value);
    }
    
    /**
     * Este metodo se encarga de devolver una variable aleatoria no uniforme de
     * un número pseudo-aleatorio generado.
     * 
     * @param min valor minimo con el que sigue la distribución
     * @param max valor máximo con el que sigue la distribución
     * @param value valor aleatorio
     * @return valor dado entre el rango [minimo, máximo)
     */
    public static double uniform(double min, double max, double value) {
        return min + (max - min) * value;
    }
    
    /**
     * Este metodo se encarga de devolver una variable aleatoria no uniforme de
     * un número pseudo-aleatorio generado.
     * 
     * @param min valor minimo con el que sigue la distribución
     * @param max valor máximo con el que sigue la distribución
     * @param value valor aleatorio
     * @return valor dado entre el rango [minimo, máximo)
     */
    public static int uniform(int min, int max, double value) {
        return (int) (min + (max - min) * value);
    }
    
}
