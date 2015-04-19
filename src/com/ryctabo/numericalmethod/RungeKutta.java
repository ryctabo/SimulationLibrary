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
