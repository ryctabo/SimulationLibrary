/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryctabo.random;

/**
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public abstract class PseudoRandom implements OptimalGenerator {
    
    /**
     * modulo con el cual se calculan los numeros pseudo aleatorios
     */
    protected final int module;
    
    /**
     * semilla con la cual se inician los numeros pseudo aleatorios
     */
    protected final int seed;
    
    /**
     * siguiente numero pseudo aleatorio generado
     */
    protected int next;
    
    /**
     * Constructor.
     * 
     * @param module modulo
     * @param seed semilla
     * @throws PseudoRandomException Lanza la excepción si y solo si alguno de 
     * los parametros obtenidos no cumple con las reglas o requisitos minimos 
     * para el funcionamiento del generador.
     */
    public PseudoRandom(int module, int seed) {
        if (module < 0)
            throw new PseudoRandomException("El modulo debe ser mayor a 0");
        
        
        if (seed < 0)
            throw new PseudoRandomException("La semilla debe ser mayor a 0");
        
        
        if (seed >= module)
            throw new PseudoRandomException(
                    PseudoRandomException.ErrorTypes.GENERAL,
                    "El modulo tiene que ser mayor a la semilla");
        
        
        this.module = module;
        this.seed = seed;
        this.next = seed;
    }
    
    /**
     * @return true, si el ciclo comenzo a repetirse.
     */
    public boolean isRepeat() {
        return this.seed == next;
    }
    
    /**
     * Este metodo es el encargado de generar los numeros pseudo aleatorios.
     */
    protected abstract void generate();
    
    /**
     * Obtiene un numero aleatorio.
     * @return numero aleatorio.
     */
    public int next() {
        this.generate();
        return this.next;
    }

    /**
     * Obtiene un numero aleatorio entre 0 y 1.
     * @return numero aleatorio.
     */
    public float nextFloat() {
        this.generate();
        return (float)this.next / (float)this.module;
    }

    /**
     * Obtiene un numero aleatorio entre 0 y 1.
     * @return numero aleatorio.
     */
    public double nextDouble() {
        this.generate();
        return (double)this.next / (double)this.module;
    }

    /**
     * @return the module
     */
    public int getModule() {
        return module;
    }

    /**
     * @return the seed
     */
    public int getSeed() {
        return seed;
    }

    @Override
    public boolean isOptimum() {
        return true;
    }

    @Override
    public String getSuggestions() {
        if (isOptimum()) {
            return "<html>No hay sugerencias, los parametros son optimos.";
        } else {
            String suggestion = "<html>Las sugerencias son las siguientes:<br><ul>";
            
            return suggestion;
        }
    }

}
