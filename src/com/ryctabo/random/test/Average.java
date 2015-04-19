/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryctabo.random.test;

/**
 *
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class Average implements ITest{
    
    private float alpha;

    public Average() {
        this.alpha = 0.05f;
    }

    public Average(float alpha) {
        this.alpha = alpha;
    }

    @Override
    public boolean test(double... values) {
        double average = com.ryctabo.util.Math.prom(values);
        double z0 = (average - 0.5d) * Math.sqrt(values.length) / Math.sqrt(1 / 12);
        return z0 < 1.96d;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }
}
