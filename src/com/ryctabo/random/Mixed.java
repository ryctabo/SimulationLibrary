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

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class Mixed extends PseudoRandom {
    
    private final int[] series1;

    private final int[] series2;

    private int[] result;

    private int i;

    private int j;
    
    private int index;

    public Mixed(int[] series1, int[] series2, int module, int seed) {
        super(module, seed);
        this.series1 = series1;
        this.series2 = series2;
        
        this.index = 0;
        this.i = 0;
        this.j = 0;
        
        this.result = new int[series1.length * series2.length];
    }

    @Override
    protected void generate() {
        try {
            if(index >= result.length)
                throw new PseudoRandomException("");
            
            this.result[index] = (this.series1[i] + this.series2[j]) % module;
            this.next = result[index];
            
            if (index++ >= result.length)
                throw new PseudoRandomException("");
            
            j = (j++ == series2.length) ? 0 : j;
            
            if (j == 0)
                i++;
        } catch (PseudoRandomException ex) {
            Logger.getLogger(Mixed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
