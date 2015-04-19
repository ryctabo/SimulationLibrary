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
public class Green extends Additive {
    
    private int[] array;
    
    private int n;
    
    private int k;

    public Green(int module, int multiplier, int additive, int seed, int k) {
        super(module, seed);
        this.k = k;
        this.array = generateArray(multiplier, additive, true);
        this.n = this.array.length - 1;
    }
    
    public Green(int module, int seed, int[] array, int k) {
        super(module, seed);
        this.array = array;
        this.k = k;
        this.n = this.array.length - 1;
    }

    @Override
    protected void generate() {
        int sub = n - k;
        
        if (sub < 0) {
            sub = array.length + sub;
        }
        
        this.array[n] = (array[n] + array[sub]) % module;
        this.next = array[n];
        
        this.n = n-- == 0 ? array.length - 1 : n;
    }

}
