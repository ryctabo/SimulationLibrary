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
