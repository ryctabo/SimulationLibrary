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

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public abstract class Mixture extends PseudoRandom {

    /**
     * serie de números aleatorios
     */
    protected int[] series;

    /**
     * Constructor.
     * 
     * @param series serie de números aleatorios
     * @param module modulo
     * @param seed semilla
     */
    public Mixture(int[] series, int module, int seed) {
        super(module, seed);
        this.series = series;
    }

    /**
     * Constructor.
     * 
     * @param module modulo
     * @param seed semilla
     * @param muliplier multiplicador
     * @param additive constante aditiva
     */
    public Mixture(int module, int seed, int muliplier, int additive) {
        super(module, seed);
        initialize(additive, muliplier, seed, module);
    }

    /**
     * Este metodo tiene como función generar una lista de números aleatorios
     * 
     * @param additive constante aditiva
     * @param multiplier multiplicador
     * @param seed semilla
     * @param module modulo
     * @return una cadena de números aleatorios
     */
    protected int[] generateArray(int additive, int multiplier, int seed, int module) {
        List<Integer> listRandom = new ArrayList<>();
        
        MixedCongruential random = new MixedCongruential(additive, multiplier, module, seed);
        
        do {
            listRandom.add(random.next());
        } while (!random.isRepeat());
        
        int[] result = new int[listRandom.size()];
        
        for (int i = 0; i < listRandom.size(); i++) {
            result[i] = listRandom.get(i);
        }
        
        return result;
    }

    /**
     * Este metodo tiene como función inicializar la serie principal del generador.
     * 
     * @param additive constante aditiva
     * @param muliplier multiplicador
     * @param seed semilla
     * @param module modulo
     */
    private void initialize(int additive, int muliplier, int seed, int module) {
        this.series = generateArray(additive, muliplier, seed, module);
    }

}
