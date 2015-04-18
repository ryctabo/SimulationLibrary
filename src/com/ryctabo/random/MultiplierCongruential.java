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
public class MultiplierCongruential extends Congruential {

    public MultiplierCongruential(int multiplier, int module, int seed) {
        super(multiplier, module, seed);
    }

    @Override
    protected void generate() {
        this.next = (this.multiplier * this.next) % this.module;
    }

}
