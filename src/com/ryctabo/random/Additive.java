/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryctabo.random;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public abstract class Additive extends PseudoRandom {
    
    /**
     * Constructor.
     * 
     * @param module modulo
     * @param seed semilla
     */
    public Additive(int module, int seed) {
        super(module, seed);
    }
    
    /**
     * <p>Este metodo es el encargado de generar una serie de numeros aleatorios, 
     * el tipo de datos de esta serie va a ser entera.
     * 
     * <p>Los valores de esta serie van a estar comprendidas entre el rango 0 
     * hasta el modulo.
     * 
     * 
     * @param multiplier multiplicador
     * @param additive aditivo
     * @param isPar true, si y solo si se necesitan lista de numeros pares.
     * @return lista de numeros enteros.
     */
    protected int[] generateArray(int multiplier, int additive, boolean isPar) {
        MixedCongruential random = new MixedCongruential(additive, multiplier, module, seed);
        
        List<Integer> numbers = new ArrayList<>();
        
        do {
            int temp = random.next();

            if (!isPar && temp % 2 == 0)
                continue;
            
            if (isPar && temp % 2 != 0)
                continue;

            numbers.add(temp);
        } while (!random.isRepeat());
        
        
        int[] result = new int[numbers.size()];
        
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("generate: " + numbers.get(i)); //Esto es solo por motivos de prueba
            result[i] = numbers.get(i);
        }
        
        return result;
    }
    
}
