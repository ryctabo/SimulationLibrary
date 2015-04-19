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
public class MitchellMoree extends Additive {
    
    private int[] array;
    
    private int j;
    
    private int k;

    public MitchellMoree(int[] array, int module, int seed) {
        super(module, seed);
        this.array = array;
        this.j = 23;
        this.k = 54;
    }

    public MitchellMoree(int module, int seed, int multiplier, int additive) {
        super(module, seed);
        this.array = generateArray(multiplier, additive, false);
        this.j = 23;
        this.k = 54;
    }

    @Override
    protected void generate() {
        this.array[k] = (array[j] + array[k]) % module;
        
        this.next = array[k];
        
        k = k-- == 0 ? 54 : k;
        j = j-- == 0 ? 54 : j;
    }

}
