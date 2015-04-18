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
public class RungeKutta4 implements NumericalMethodXY {
    
    private double k1;
    
    private double k2;
    
    private double k3;
    
    private double k4;
    
    private final double[] values;
    
    private final double[] valuesOfX;
    
    private final double[] error;
    
    private final double limit_inf;
    
    private final double limit_sup;
    
    private final double initialCondition;
    
    private final double stepSize;
    
    private int nIterations;

    public RungeKutta4(double limit_inf, double limit_sup, double initialCondition, double stepSize) {
        this.limit_inf = limit_inf;
        this.limit_sup = limit_sup;
        this.initialCondition = initialCondition;
        this.stepSize =  stepSize;
        
        final int iterations = (int) ((limit_sup - limit_inf) / stepSize);
        
        this.error = new double[iterations + 1];
        this.values = new double[iterations + 1];
        this.valuesOfX = new double[iterations + 1];
        
        this.k1 = 0;
        this.k2 = 0;
        this.k3 = 0;
        this.k4 = 0;
        
        this.nIterations = 0;
    }
    
    public RungeKutta4(double limit_inf, double limit_sup, double initialCondition, int iterations) {
        this.limit_inf = limit_inf;
        this.limit_sup = limit_sup;
        this.initialCondition = initialCondition;
        this.stepSize =  (limit_sup - limit_inf) / iterations;
        
        this.error = new double[iterations + 1];
        this.values = new double[iterations + 1];
        this.valuesOfX = new double[iterations + 1];
        
        this.k1 = 0;
        this.k2 = 0;
        this.k3 = 0;
        this.k4 = 0;
        
        this.nIterations = 0;
    }
    
    @Override
    public void generateSolution(EquationXY eq) {
        this.values[nIterations] = this.initialCondition;
        this.valuesOfX[nIterations] = this.limit_inf;
        
        for (double i = this.limit_inf + this.stepSize; i <= this.limit_sup; i += this.stepSize) {
            calculateK1(valuesOfX[nIterations], values[nIterations], eq);
            calculateK2(valuesOfX[nIterations], values[nIterations], eq);
            calculateK3(valuesOfX[nIterations], values[nIterations], eq);
            calculateK4(valuesOfX[nIterations], values[nIterations], eq);
            
            double sol = values[nIterations] + ((k1 + 2 * k2 + 2 * k3 + k4) * stepSize) / 6;
            
            this.values[++nIterations] = sol;
            this.valuesOfX[nIterations] = i;
        }
    }
    
    private void calculateK1(double x, double y, EquationXY eq) {
        this.k1 = eq.equation(x, y);
    }
    
    private void calculateK2(double x, double y, EquationXY eq) {
        this.k2 = eq.equation(x + .5 * stepSize, y + .5 * k1 * stepSize);
    }
    
    private void calculateK3(double x, double y, EquationXY eq) {
        this.k3 = eq.equation(x + .5 * stepSize, y + .5 * k2 * stepSize);
    }
    
    private void calculateK4(double x, double y, EquationXY eq) {
        this.k4 = eq.equation(x + stepSize, y + k3 * stepSize);
    }

    public double getK1() {
        return k1;
    }

    public double getK2() {
        return k2;
    }

    public double getK3() {
        return k3;
    }

    public double getK4() {
        return k4;
    }

    public double[] getValues() {
        return values;
    }

    public double[] getValuesOfX() {
        return valuesOfX;
    }

    public double[] getError() {
        return error;
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

    public double getStepSize() {
        return stepSize;
    }

    public int getnIterations() {
        return nIterations;
    }

    public double getSolution() {
        return this.values[nIterations];
    }
    
}
