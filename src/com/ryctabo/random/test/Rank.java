/*
 *                    GNU GENERAL PUBLIC LICENSE
 *                       Version 2, June 1991
 *
 * Copyright (C) 1989, 1991 Free Software Foundation, Inc., <http://fsf.org/>
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package com.ryctabo.random.test;

/**
 *
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class Rank {
    
    /**
     * 
     */
    private double min;
    
    /**
     * 
     */
    private double max;

    /**
     * 
     * @param max
     * @param min 
     */
    public Rank(double min, double max) {
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

    /**
     * @param max 
     */
    public void setMax(double max) {
        this.max = max;
    }

    /**
     * @param min 
     */
    public void setMin(double min) {
        this.min = min;
    }
    
    /**
     * @return 
     */
    public double getMax() {
        return max;
    }

    /**
     * @return 
     */
    public double getMin() {
        return min;
    }
}
