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
public class MixedCongruential extends Congruential {

    private int additive;

    public MixedCongruential(int additive, int multiplier, int module, int seed) {
        super(multiplier, module, seed);

        if (additive < 0)
            throw new PseudoRandomException("La constante aditiva tiene que ser mayor o igual a 0.");

        if (additive >= module)
            throw new PseudoRandomException("La constante aditiva tiene que ser menor que el modulo.");

        this.additive = additive;
    }

    @Override
    protected void generate() {
        this.next = (this.multiplier * this.next + this.additive) % this.module;
    }

    public int getAdditive() {
        return additive;
    }

    @Override
    public boolean isOptimum() {
        if (!super.isOptimum())
            return false;
        
//        if (!utilities.Math.isPrimeNumber(module))
//            return false;
        
        if (additive % 2 == 0 || !com.ryctabo.util.Math.isRelativelyPrime(additive, module))
            return false;

        if (additive % 8 != 5)
            return false;

        return true;
    }

    @Override
    public String getSuggestions() {
        if (isOptimum()) {
            return "<html>No hay sugerencias, los parametros son optimos.";
        } else {
            String suggestion = super.getSuggestions();

//            if (!utilities.Math.isPrimeNumber(module))
//                suggestion += "<li>El modulo[m] debe ser un número primo.</li>";

            if (additive % 2 == 0 || !com.ryctabo.util.Math.isRelativelyPrime(additive, module))
                suggestion += "<li>La constante aditiva[c] y el modulo[m] deben ser primos relativos</li>";

            if (additive % 8 != 5)
                suggestion += "<li>Se recomienda que la constante aditiva[c] su modulo con respecto a 8 sea 5;"
                        + "<br>c mod 8 = 5.</li>";

            return suggestion;
        }
    }

}
