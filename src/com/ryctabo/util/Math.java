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
package com.ryctabo.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class Math {
    
    /**
     * Este método se encarga de obtener los factores primos de un valor en 
     * especifico.
     * 
     * @param value valor al cual se le van a sacar los factores primos
     * @return lista de números primos de el valor ingresado
     */
    public static List<Integer> getPrimeFactorsList(int value) {
        List<Integer> primes = new ArrayList<>();
        primes.add(1);

        int temp = value;
        int div = 2;

        while (temp != 1)
            if (temp % div == 0) {
                if (!primes.contains(div))
                    primes.add(div);
                temp /= div;
            } else
                div++;

        if (!primes.contains(value))
            primes.add(value);

        return primes;
    }
    
    /**
     * Este método se encarga de obtener los factores primos de un valor en 
     * especifico.
     * 
     * @param value valor al cual se le van a sacar los factores primos
     * @return lista de números primos de el valor ingresado
     */
    public static List<Long> getPrimeFactorsList(long value) {
        List<Long> primes = new ArrayList<>();
        primes.add(1L);

        long temp = value;
        long div = 2L;

        while (temp != 1)
            if (temp % div == 0) {
                if (!primes.contains(div))
                    primes.add(div);
                temp /= div;
            } else
                div++;

        if (!primes.contains(value))
            primes.add(value);

        return primes;
    }
    
    /**
     * Este método se encarga de obtener los factores primos de un valor en 
     * especifico.
     * 
     * @param value valor al cual se le van a sacar los factores primos
     * @return vector de números primos de el valor ingresado
     */
    public static int[] getPrimeFactors(int value) {
        List<Integer> result = getPrimeFactorsList(value);
        int[] primes = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++)
            primes[i] = result.get(i);
        
        return primes;
    }
    
    /**
     * Este método se encarga de obtener los factores primos de un valor en 
     * especifico.
     * 
     * @param value valor al cual se le van a sacar los factores primos
     * @return vector de números primos de el valor ingresado
     */
    public static long[] getPrimeFactors(long value) {
        List<Long> result = getPrimeFactorsList(value);
        long[] primes = new long[result.size()];
        
        for (int i = 0; i < result.size(); i++)
            primes[i] = result.get(i);
        
        return primes;
    }
    
    /**
     * Este método se encarga de decir si dos números son primos relativos o no
     * 
     * @param value1 número cualquiera
     * @param value2 número cualquiera
     * @return true, si los dos números ingresados al método son primos relativos
     */
    public static boolean isRelativelyPrime(int value1, int value2) {
        List<Integer> primes1, primes2;
        
        primes1 = getPrimeFactorsList(value1);
        primes2 = getPrimeFactorsList(value2);
        
        primes1.remove(primes1.size() - 1);
        primes2.remove(primes2.size() - 1);
        
        int cont = 0;
        
        for (Integer item : primes1)
            for (Integer item2 : primes2)
                if (item == item2)
                    cont++;
        
        return cont == 1;
    }
    
    /**
     * Este método se encarga de decir si el valor digitado es un número primo.
     * 
     * @param value valor al cual se le quiere saber si es un número primo.
     * @return true, si el valor digitado es un número primo.
     */
    public static boolean isPrimeNumber(int value) {
        List number = getPrimeFactorsList(value);
        return number.size() == 2;
    }
    
    /**
     * Este método se encarga de decir si el valor digitado es un número primo.
     * 
     * @param value valor al cual se le quiere saber si es un número primo.
     * @return true, si el valor digitado es un número primo.
     */
    public static boolean isPrimeNumber(long value) {
        List number = getPrimeFactorsList(value);
        return number.size() == 2;
    }
    
    /**
     * Devuelve el factorial de un número
     * 
     * @param value número al cual se le va a sacar el factorial
     * @return factorial del número
     */
    public static int fact(int value) {
        int i = 1, fact = 1;
        while (i - 1 != value) {
            fact *= i++;
        }
        return fact;
    }
    
    /**
     * Este método te devuelve el promedio de los parametros dados.
     * 
     * @param values lista de valores dados.
     * @return -1 si hubo algún problema dentro de la operación.
     */
    public static double prom(double... values) {
        if (values != null) {
            double sum = sum(values);
            double prom = sum / values.length;
            return prom;
        }
        return -1d;
    }
    
    /**
     * Este método te devuelve la suma de los parametros dados.
     * 
     * @param values lista de parametros
     * @return -1, si hubo algún problema dentro de la operación
     */
    public static double sum(double... values) {
        if (values != null) {
            double sum = 0;
            for (double item : values) {
                sum+=item;
            }
            return sum;
        }
        return -1d;
    }
    
}