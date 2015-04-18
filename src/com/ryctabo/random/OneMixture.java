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
public class OneMixture extends Mixture {

    private final int[] series2;
    
    private final int[] result;
    
    private final int module2;
    
    private final int k;
    
    private int j;
    
    private int x;

    /**
     * 
     * @param series2
     * @param module2
     * @param series
     * @param module
     * @param seed
     * @param limit
     */
    public OneMixture(int[] series2, int module2, int[] series, int module, int seed, int limit) {

        super(series, module, seed);
        this.series2 = series2;
        this.module2 = module2;
        this.k = limit;
        this.result = new int[limit];

        validate();

        System.arraycopy(series, 0, result, 0, limit);
        this.j = limit;
        this.x = 0;
    }

    /**
     *
     * @param multiplier1
     * @param additive1
     * @param seed1
     * @param module1
     * @param multiplier2
     * @param additive2
     * @param seed2
     * @param module2
     * @param limit 
     */
    public OneMixture(int multiplier1, int additive1, int seed1, int module1,
            int multiplier2, int additive2, int seed2, int module2, int limit) {
  
        super(module1, seed1, multiplier1, additive1);
        this.series2 = generateArray(additive2, multiplier2, seed2, module2);
        this.module2 = module2;
        this.k = limit;
        this.result = new int[limit];

        validate();

        System.arraycopy(this.series, 0, this.result, 0, limit);
        this.j = limit;
        this.x = 0;
    }

    @Override
    protected void generate() {
        int h = (int) (getLimit() * getSeries2()[x] / getModule2());
        
        if (h < 0 || h >= result.length) {
                throw new PseudoRandomException(
                        PseudoRandomException.ErrorTypes.INDEX_OUT_OF_RANGE,
                        "El indice utilizado o generado para sacar el numero pseudo aleatorio esta fuera del rango.");
        }
        
        this.next = this.result[h];
        this.result[h] = series[j];
        this.j = ++j >= series.length ? 0 : j;
        this.x = ++x >= getSeries2().length ? 0 : x;
    }

    /**
     * 
     * @throws PseudoRandomException Lanza la excepción si y solo si alguno de 
     * los parametros obtenidos no cumple con las reglas o requisitos minimos 
     * para el funcionamiento del generador.
     */
    private void validate() {
        if (getLimit() >= this.series.length) {
            throw new PseudoRandomException(
                    PseudoRandomException.ErrorTypes.LIMIT_EXCEEDED,
                    "El limite debe ser menor o igual al tamaño de la primera serie generada");
        }
    }

    /**
     * @return the series2
     */
    public int[] getSeries2() {
        return series2;
    }

    /**
     * @return the module2
     */
    public int getModule2() {
        return module2;
    }

    /**
     * @return the limit of pseudo random series
     */
    public int getLimit() {
        return k;
    }

}
