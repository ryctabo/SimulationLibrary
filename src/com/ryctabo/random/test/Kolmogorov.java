/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryctabo.random.test;

import java.util.Arrays;

/**
 *
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class Kolmogorov implements ITest {
    
    private float alpha;

    public Kolmogorov() {
        this.alpha = 0.05f;
    }

    public Kolmogorov(float alpha) {
        this.alpha = alpha;
    }

    @Override
    public boolean test(double... values) {
        Arrays.sort(values);

        double[] D = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            double da = i / values.length;
            double d = da - values[i];
            D[i] = Math.abs(d);
        }

        Arrays.sort(D);

        double value = KolmogorovTable.getInstance().getValue(alpha, values.length);

        return D[D.length - 1] < value;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }
}
