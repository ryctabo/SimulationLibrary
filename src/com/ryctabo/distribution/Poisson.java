/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryctabo.distribution;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class Poisson {
    
    private double landa;
    
    private final List<RankPoisson> ranks;

    public Poisson(double landa) {
        this.landa = landa;
        this.ranks = new ArrayList<>();
        createRanks();
    }

    public double getLanda() {
        return landa;
    }

    public void setLanda(double landa) {
        this.landa = landa;
    }
    
    /**
     * Este método crea los rangos para la poisson
     */
    private void createRanks() {
        int rank = (int) (this.landa * 3) + 1;
        
        double min = 0d, max = 0d;
        
        for (int x = 0; x < rank; x++) {
            max += (Math.exp(-this.landa) * Math.pow(this.landa, x)) / com.ryctabo.util.Math.fact(x);
            this.ranks.add(new RankPoisson(max, min));
            min = max;
        }
    }
    
    /**
     * Este método te dice la variable aleatoria dada por el valor dado
     * 
     * @param value valor aleatorio
     * @return variable aleatria
     */
    public int getRank(double value) {
        for (int index = 0; index < ranks.size(); index++)
            if (this.ranks.get(index).belong(value))
                return index;
        return -1;
    }
}
