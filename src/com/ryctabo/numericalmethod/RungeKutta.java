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
public class RungeKutta extends EulerMethod {

    public RungeKutta(double stepSize, double limit_inf, double limit_sup,
            double initialCondition) {
        
        super(stepSize, limit_inf, limit_sup, initialCondition);
    }

    public RungeKutta(int iterations, double limit_inf, double limit_sup,
            double initialCondition) {
        
        super(iterations, limit_inf, limit_sup, initialCondition);
    }
    
}
