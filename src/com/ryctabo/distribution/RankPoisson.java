/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryctabo.distribution;

/**
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class RankPoisson {
    
    private double max;
    
    private double min;

    public RankPoisson(double max, double min) {
        this.max = max;
        this.min = min;
    }
    
    /**
     * Este método se encarga de verificar si un valor dado esta o no esta dentro
     * del rango.
     * 
     * @param value valor a verificar
     * @return true, si esta dentro del rango
     */
    public boolean belong(double value) {
        return value >= min && value < max;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }
}
