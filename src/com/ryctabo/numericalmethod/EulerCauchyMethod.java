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
public class EulerCauchyMethod implements NumericalMethodXY {
    
    private double k1;
    
    private double k2;
    
    private final double[] values;
    
    private final double[] valuesOfX;
    
    private final double[] error;
    
    private final double limit_inf;
    
    private final double limit_sup;
    
    private final double initialCondition;
    
    private final double stepSize;
    
    private int nIterations;

    public EulerCauchyMethod(double limit_inf, double limit_sup, double initialCondition, double stepSize) {
        this.limit_inf = limit_inf;
        this.limit_sup = limit_sup;
        this.initialCondition = initialCondition;
        this.stepSize = stepSize;

        final int iterations = (int) ((limit_sup - limit_inf) / stepSize);

        this.error = new double[iterations + 1];
        this.values = new double[iterations + 1];
        this.valuesOfX = new double[iterations + 1];

        this.k1 = 0;
        this.k2 = 0;

        this.nIterations = 0;
    }

    public EulerCauchyMethod(double limit_inf, double limit_sup, double initialCondition, int iterations) {
        this.limit_inf = limit_inf;
        this.limit_sup = limit_sup;
        this.initialCondition = initialCondition;
        this.stepSize = (limit_sup - limit_inf) / iterations;

        this.error = new double[iterations + 1];
        this.values = new double[iterations + 1];
        this.valuesOfX = new double[iterations + 1];

        this.k1 = 0;
        this.k2 = 0;

        this.nIterations = 0;
    }

    @Override
    public void generateSolution(EquationXY eq) {
        this.values[nIterations] = this.initialCondition;
        this.valuesOfX[nIterations] = this.limit_inf;

        for (double i = this.limit_inf + this.stepSize; i <= this.limit_sup; i += this.stepSize) {
            calculateK1(valuesOfX[nIterations], values[nIterations], eq);
            calculateK2(valuesOfX[nIterations], values[nIterations], eq);

            double sol = values[nIterations] + (k1 + k2) / 2;

            this.values[++nIterations] = sol;
            this.valuesOfX[nIterations] = i;
        }
    }

    private void calculateK1(double x, double y, EquationXY eq) {
        this.k1 = stepSize * eq.equation(x, y);
    }

    private void calculateK2(double x, double y, EquationXY eq) {
        this.k2 = stepSize * eq.equation(x + k1, y + stepSize);
    }

    public double getK1() {
        return k1;
    }

    public double getK2() {
        return k2;
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
