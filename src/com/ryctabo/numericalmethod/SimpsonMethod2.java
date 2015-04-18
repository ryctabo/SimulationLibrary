/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryctabo.numericalmethod;

/**
 *
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class SimpsonMethod2 implements NumericalMethodX {
    
    private final double[] values;
    
    private final double[] valuesOfX;
    
    private final double stepSize;
    
    private final double limit_inf;
    
    private final double limit_sup;
    
    private int nIterations;

    public SimpsonMethod2(double stepSize, double limit_inf, double limit_sup) {
        this.limit_inf = limit_inf;
        this.limit_sup = limit_sup;
        this.stepSize = stepSize;
        
        final int iterations = (int) ((limit_sup - limit_inf) / stepSize);
        
        if (iterations % 3 != 0)
            throw new NumericalMethodException("El numero de iteraciones se recomienda que sea multiplo de 3");
        
        this.values = new double[iterations + 1];
        this.valuesOfX = new double[iterations + 1];
        this.nIterations = 0;
    }
    
    public SimpsonMethod2(int iterations, double limit_inf, double limit_sup) {
        if (iterations % 3 != 0)
            throw new NumericalMethodException("El numero de iteraciones se recomienda que sea multiplo de 3");
        
        this.limit_inf = limit_inf;
        this.limit_sup = limit_sup;
        this.stepSize = (limit_sup - limit_inf) / iterations;
        
        this.values = new double[iterations + 1];
        this.valuesOfX = new double[iterations + 1];
        this.nIterations = 0;
    }

    @Override
    public void generateSolution(EquationX eq) {
        double sum1 = 0d, sum2 = 0d;

        int n = (int) ((this.limit_sup - this.limit_inf) / this.stepSize);

        for (int i = 1; i <= n - 1; i++) {
            if (i % 3 == 0) {
                sum1 += 2 * eq.equation(this.limit_inf + i * this.stepSize);
            } else {
                sum2 += 3 * eq.equation(this.limit_inf + i * this.stepSize);
            }
        }

        this.values[nIterations] = ((3 * this.stepSize) / 8) * (eq.equation(this.limit_inf) + sum1 + sum2 + eq.equation(this.limit_sup));
    }

    public double[] getValues() {
        return values;
    }

    public double[] getValuesOfX() {
        return valuesOfX;
    }

    public double getStepSize() {
        return stepSize;
    }

    public double getLimit_inf() {
        return limit_inf;
    }

    public double getLimit_sup() {
        return limit_sup;
    }

    public int getnIterations() {
        return nIterations;
    }
    
    public double getSolution() {
        return values[nIterations];
    }
}
