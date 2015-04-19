/*
 * To change this license headerf, choose License Headers in Project Properties.
 * To change this template filef, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryctabo.random.test;

import java.util.ArrayList;

/**
 *
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class Frecuency implements ITest {
    
    private int intervals;
    
    private float alpha;
    
    private ArrayList<Rank> list;
    
    private int[] cont;

    public Frecuency() {
        this.intervals = 5;
        this.list = new ArrayList<>();
        this.cont = new int[intervals];
        this.alpha = 0.05f;
        createIntervals();
    }
    
    public Frecuency(int intervals, float alpha) {
        this.intervals = intervals;
        this.list = new ArrayList<>();
        this.cont = new int[intervals];
        this.alpha = alpha;
        createIntervals();
    }
    
    @Override
    public boolean test(double... values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < this.intervals; j++) {
                if (this.list.get(j).belong(values[i])) {
                    cont[j]++;
                }
            }
        }
        
        double ve = values.length / intervals;
        double acum = 0d;
        
        for (int vo : this.cont) {
            acum += Math.pow(vo - ve, 2) / ve;
        }

        double chi2 = Chi2.getInstance().getValue(alpha, intervals - 1);

        return acum < chi2;
    }

    private void createIntervals() {
        double h = 1d / (double) intervals;
        for (int i = 0; i < intervals; i++) {
            this.list.add(new Rank(h * i, h * (i + 1)));
            this.cont[i] = 0;
        }
    }

    public int getIntervals() {
        return intervals;
    }

    public void setIntervals(int intervals) {
        this.intervals = intervals;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }
}
