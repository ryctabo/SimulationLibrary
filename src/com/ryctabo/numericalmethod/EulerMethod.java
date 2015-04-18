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
public class EulerMethod implements NumericalMethodXY {
    
    private final double[] error;
    
    private final double[] values;
    
    private final double[] valuesOfX;
    
    private final double stepSize;
    
    private final double limit_inf;
    
    private final double limit_sup;
    
    private final double initialCondition;
    
    private int nIterations;

    /**
     * 
     * @param stepSize
     * @param limit_inf
     * @param limit_sup
     * @param initialCondition 
     */
    public EulerMethod(double stepSize, double limit_inf, double limit_sup,
            double initialCondition) {
        
        this.limit_inf = limit_inf;
        this.limit_sup = limit_sup;
        this.stepSize = stepSize;
        
        final int iterations = (int) ((limit_sup - limit_inf) / stepSize);
        
        this.error = new double[iterations + 1];
        this.values = new double[iterations + 1];
        this.valuesOfX = new double[iterations + 1];
        this.nIterations = 0;
        this.initialCondition = initialCondition;
    }

    /**
     * 
     * @param iterations
     * @param limit_inf
     * @param limit_sup
     * @param initialCondition 
     */
    public EulerMethod(int iterations, double limit_inf, double limit_sup,
            double initialCondition) {
        
        this.limit_inf = limit_inf;
        this.limit_sup = limit_sup;
        this.stepSize = (limit_sup - limit_inf) / iterations;
        this.error = new double[iterations + 1];
        this.values = new double[iterations + 1];
        this.valuesOfX = new double[iterations + 1];
        this.nIterations = 0;
        this.initialCondition = initialCondition;
    }
    
    @Override
    public void generateSolution(EquationXY eq) {
        this.values[nIterations] = this.initialCondition;
        this.valuesOfX[nIterations] = this.limit_inf;
        
        for (double i = this.limit_inf + this.stepSize; i <= this.limit_sup; i += this.stepSize) {
            double sol = values[nIterations] + this.stepSize * eq.equation(valuesOfX[nIterations], values[nIterations]);
            this.values[++nIterations] = sol;
            this.valuesOfX[nIterations] = i;
        }
        
        //FALTARIA EL ERROR
    }

    public double[] getError() {
        return error;
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

    public double getInitialCondition() {
        return initialCondition;
    }

    public int getnIterations() {
        return nIterations;
    }
    
    public double getSolution() {
        return values[nIterations];
    }
}
