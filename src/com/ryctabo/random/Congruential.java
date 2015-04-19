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
public abstract class Congruential extends PseudoRandom {

    protected final int multiplier;

    public Congruential(int multiplier, int module, int seed) {
        super(module, seed);

        if (multiplier < 0)
            throw new PseudoRandomException("El multiplicador debe ser mayor o igual a 0.");

        if (multiplier >= module)
            throw new PseudoRandomException("El multiplicador debe ser menor al modulo.");

        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }

    @Override
    public boolean isOptimum() {
        if (!super.isOptimum())
            return false;
        
        int[] primeModule = com.ryctabo.util.Math.getPrimeFactors(module);
        for (int i = 0; i < primeModule.length - 1; i++)
            if ((multiplier - 1) % primeModule[i] != 0)
                return false;

        return !(module % 4 == 0 & (multiplier - 1) % 4 != 0);
    }

    @Override
    public String getSuggestions() {
        if (isOptimum()) {
            return "<html>No hay sugerencias, los parametros son optimos.";
        } else {
            String suggestion = super.getSuggestions();

            int[] primeModule = com.ryctabo.util.Math.getPrimeFactors(module);
            for (int i = 0; i < primeModule.length - 1; i++)
                if ((multiplier - 1) % primeModule[i] != 0) {
                    System.out.println("" + primeModule[i]);
                    suggestion += "<li>El multiplicador[a] sea múltiplo de los factores primos del modulo[m];"
                            + "<br>a-1=k(P1*P2 *....*Pr), siendo Pi factor primo del modulo[m].</li>";
                    break;
                }

            if (module % 4 == 0 & (multiplier - 1) % 4 != 0)
                suggestion += "<li>Si el modulo[m] es múltiplo de 4, El multiplicador menos uno [a-1]"
                        + "<br>también debe serlo (si m=k4 => a-1=k’4).</li>";

            return suggestion;
        }
    }
}
