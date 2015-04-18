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
public class TwoMixture extends Mixture {
    
    private final int[] result;
    
    private final int k;
    
    private int temp;
    
    private int index;

    public TwoMixture(int[] series, int module, int seed, int limit) {
        super(series, module, seed);
        this.k = limit;
        this.result = new int[limit];

        validate();

        this.temp = this.series[limit];
        System.arraycopy(series, 0, this.result, 0, limit);
        this.index = limit;
    }

    public TwoMixture(int module, int seed, int muliplier, int additive, int limit) {
        super(module, seed, muliplier, additive);
        this.k = limit;
        this.result = new int[limit];

        validate();

        this.temp = this.series[limit];
        System.arraycopy(series, 0, this.result, 0, limit);
        this.index = limit;
    }

    /**
     * @throws Lanza la excepción si y solo si alguno de 
     * los parametros obtenidos no cumple con las reglas o requisitos minimos 
     * para el funcionamiento del generador.
     */
    @Override
    protected void generate() {
        int h = (int) (k * temp / module);

        if (h < 0 || h >= result.length) {
            throw new PseudoRandomException(
                    PseudoRandomException.ErrorTypes.INDEX_OUT_OF_RANGE,
                    "El indice utilizado o generado para sacar el numero pseudo aleatorio esta fuera del rango.");
        }

        this.temp = result[h];
        this.next = result[h];
        
        this.result[h] = this.series[index];
        
        this.index = ++index >= this.series.length ? 0 : index;
    }

    /**
     * 
     * @throws PseudoRandomException Lanza la excepción si y solo si alguno de 
     * los parametros obtenidos no cumple con las reglas o requisitos minimos 
     * para el funcionamiento del generador.
     */
    private void validate() {
        if (this.k >= this.series.length) {
            throw new PseudoRandomException(
                    PseudoRandomException.ErrorTypes.LIMIT_EXCEEDED,
                    "El limite debe ser menor o igual al tamaño de la primera serie generada");
        }
    }
    
}