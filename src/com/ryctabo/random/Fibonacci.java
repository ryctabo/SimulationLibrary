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
