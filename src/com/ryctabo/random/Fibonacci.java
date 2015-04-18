/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryctabo.random;

/**
 *
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class Fibonacci extends Additive {

    private int previous;

    public Fibonacci(int previous, int module, int seed) {
        super(module, seed);
        this.previous = previous;
    }

    @Override
    protected void generate() {
        final int temp = (this.next + this.previous) % this.module;
        this.next = this.previous;
        this.previous = temp;
    }

    public int getPrevious() {
        return previous;
    }
    
}
