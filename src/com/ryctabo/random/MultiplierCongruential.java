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
public class MultiplierCongruential extends Congruential {

    public MultiplierCongruential(int multiplier, int module, int seed) {
        super(multiplier, module, seed);
    }

    @Override
    protected void generate() {
        this.next = (this.multiplier * this.next) % this.module;
    }

}
