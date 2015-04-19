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
package com.ryctabo.numericalmethod;

/**
 *
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class TrapezeMethod implements NumericalMethodX {

    private final double stepSize;
    
    private final int n;
    
    private int iteration;
    
    private final double limit_inf;
    
    private final double limit_sup;
    
    private double value;

    public TrapezeMethod(double stepSize, double limit_inf, double limit_sup) {
        this.stepSize = stepSize;
        this.n = (int) ((limit_sup - limit_inf) / stepSize);
        this.iteration = 0;
        this.limit_inf = limit_inf;
        this.limit_sup = limit_sup;
        this.value = 0;
    }

    public TrapezeMethod(int iterations, double limit_inf, double limit_sup) {
        this.stepSize = (limit_sup - limit_inf) / (double)iterations;
        this.n = iterations;
        this.iteration = 0;
        this.limit_inf = limit_inf;
        this.limit_sup = limit_sup;
        this.value = 0;
    }
    
    @Override
    public void generateSolution(EquationX eq) {
        double sum = 0d;
        
        for (int i = 1; i <= n -1; i++) {
            sum += 2 * eq.equation(this.limit_inf + i * this.stepSize);
        }
        
        this.value = (this.stepSize / 2) * (eq.equation(this.limit_inf) + sum + eq.equation(this.limit_sup));
    }

    public double getStepSize() {
        return stepSize;
    }

    public double getN() {
        return n;
    }

    public double getIteration() {
        return iteration;
    }

    public double getLimit_inf() {
        return limit_inf;
    }

    public double getLimit_sup() {
        return limit_sup;
    }

    public double getSolution() {
        return value;
    }
}
