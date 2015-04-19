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
public class QuadraticCongruential extends Congruential {
    
    /**
     * the additive
     */
    private int additive;
    
    /**
     * the quadratic
     */
    private int quadratic;

    /**
     * Constructor.
     * 
     * @param additive la constante aditiva
     * @param quadratic la constante cuadratica
     * @param multiplier el multiplicador
     * @param module modulo
     * @param seed semilla
     */
    public QuadraticCongruential(int additive, int quadratic, int multiplier, int module, int seed) {
        super(multiplier, module, seed);

        if (additive < 0)
            throw new PseudoRandomException("La constante aditiva tiene que ser mayor o igual a 0.");

        if (quadratic < 0)
            throw new PseudoRandomException("El numero cuadratico debe ser mayor o igual a 0.");

        if (additive >= module)
            throw new PseudoRandomException("La constante aditiva tiene que ser menor que el modulo.");

        if (quadratic >= module)
            throw new PseudoRandomException("El numero cuadratico tiene que ser menor que el modulo.");

        this.additive = additive;
        this.quadratic = quadratic;
    }

    @Override
    protected void generate() {
        this.next = (this.quadratic * (int)Math.pow(next, 2) + this.multiplier * this.next + this.additive) % this.module;
    }

    /**
     * @return the additive
     */
    public int getAdditive() {
        return additive;
    }

    /**
     * @return the quadratic
     */
    public int getQuadratic() {
        return quadratic;
    }

    @Override
    public boolean isOptimum() {
        if (!super.isOptimum())
            return false;

        if (additive % 2 == 0 || !com.ryctabo.util.Math.isRelativelyPrime(additive, module))
            return false;

        if (additive % 8 != 5)
            return false;

        //hay que evaluar cuales son las mejores condiciones para el cuadratico

        return true;
    }

    @Override
    public String getSuggestions() {
        if (isOptimum()) {
            return "<html>No hay sugerencias, los parametros son optimos.";
        } else {
            String suggestion = super.getSuggestions();

            if (additive % 2 == 0 || !com.ryctabo.util.Math.isRelativelyPrime(additive, module))
                suggestion += "<li>La constante aditiva[c] y el modulo[m] deben ser primos relativos</li>";

            if (additive % 8 != 5)
                suggestion += "<li>Se recomienda que la constante aditiva[c] su modulo con respecto a 8 sea 5;"
                        + "<br>c mod 8 = 5.</li>";
            
            //hay que evaluar cuales son las mejores condiciones para el cuadratico

            return suggestion;
        }
    }

}
