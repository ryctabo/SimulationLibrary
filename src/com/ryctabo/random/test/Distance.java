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
public class Distance implements ITest {
    
    private double limit_inf;
    
    private double limit_sup;
    
    private int max;
    
    private float alpha;
    
    private double[] cont;

    public Distance() {
        this.limit_inf = 0.3d;
        this.limit_sup = 0.5d;
        this.max = 5;
        this.alpha = 0.05f;
        this.cont = new double[max + 1];
        
        for (int i = 0; i < max + 1; i++) {
            this.cont[i] = 0;
        }
    }
    
    public Distance(double alpha, double beta, int max, float alphaChi2) {
        if (alpha < 0 || alpha >= 1)
            throw new TestException("Alpha tiene que estar dentro de 0 y 1. (0, 1]");
        
        if (beta < 0 || beta >= 1)
            throw new TestException("Beta tiene que estar dentro de 0 y 1. (0, 1]");
        
        if (beta <= alpha)
            throw new TestException("Alpha tiene que ser menor que Beta");
        
        this.limit_inf = alpha;
        this.limit_sup = beta;
        this.max = max;
        this.alpha = alphaChi2;
        this.cont = new double[max + 1];
        
        for (int i = 0; i < max + 1; i++) {
            this.cont[i] = 0;
        }
    }

    @Override
    public boolean test(double... values) {
        int index = 0;
        
        do {
            int distance = 0;
            
            for (int i = index; i < values.length; i++) {
                index++;
                
                if (values[i] >= this.limit_inf && values[i] < this.limit_sup) 
                    break;
                
                distance++;
            }
            
            if (distance > this.max) {
                this.cont[max]++;
            } else {
                this.cont[distance]++;
            }
        } while (index < values.length);
        
        double teta = this.limit_sup - this.limit_inf;
        
        double[] frecuency = new double[max + 1];
        
        double sum = 0d;
        for (int i = 0; i < cont.length; i++) {
            sum += cont[i];
        }
        
        for (int i = 0; i < max + 1; i++) {
            frecuency[i] = sum * teta * Math.pow(1 - teta, i);
        }
        
        double result = 0d;
        for (int i = 0; i < max + 1; i++) {
            result += (cont[i] - frecuency[i]) / frecuency[i];
        }
        
        double chi2 = Chi2.getInstance().getValue(alpha, max - 1);
        
        return result < chi2;
    }

    public double getAlpha() {
        return limit_inf;
    }

    public double getBeta() {
        return limit_sup;
    }

    public void setAlpha(double alpha) {
        this.limit_inf = alpha;
    }

    public void setBeta(double beta) {
        this.limit_sup = beta;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public float getAlphaChi2() {
        return alpha;
    }

    public void setAlphaChi2(float alpha) {
        this.alpha = alpha;
    }
}
