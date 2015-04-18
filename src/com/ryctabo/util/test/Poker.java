/*
 * To change this license headerf, choose License Headers in Project Properties.
 * To change this template filef, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ryctabo.util.test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class Poker implements ITest {

    private float alpha;
    
    private ArrayList<Type> types;

    public Poker() {
        this.alpha = 0.05f;
        this.types = new ArrayList<>();
        fillTypes();
    }

    public Poker(float alpha) {
        this.alpha = alpha;
        this.types = new ArrayList<>();
        fillTypes();
    }

    @Override
    public boolean test(double... values) {
        for (Double value : values) {
            byte[] bytes = new byte[5];
            char[] dec = value.toString().toCharArray();
            
            if (dec.length < 7) {
                char[] dec2 = new char[7];
                System.arraycopy(dec, 0, dec2, 0, dec.length);
                for (int i = dec.length; i < 7; i++) {
                    dec2[i] = '0';
                }
                dec = new char[7];
                System.arraycopy(dec2, 0, dec, 0, dec.length);
            }
            
            for (int i = 0; i < 5; i++) {
                bytes[i] = Byte.parseByte("" + dec[i + 2]);
            }
            
            Type type = getTypeByByte(bytes);
            this.types.get(type.ordinal()).cont++;
        }
        
        double result = 0d;
        
        for (Type item : this.types) {
            double fe = values.length * item.probability;
            result += Math.pow(item.cont - fe, 2) / fe;
        }
        
        double chi2 = Chi2.getInstance().getValue(alpha, 6);
        return result < chi2;
    }
    
    private Type getTypeByByte(byte[] bytes) {
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0;
        ArrayList<Byte> number = new ArrayList<>();
        
        for (int i = 0; i < bytes.length; i++) {
            if (number.contains(bytes[i])) continue;
            
            int cont = 0;
            
            for (int j = 0; j < bytes.length; j++) {
                if (i == j) continue;
                if (bytes[i] == bytes[j]) cont++;
            }
            
            number.add(bytes[i]);
            
            switch (cont) {
                case 0: c1++; break;
                case 1: c2++; break;
                case 2: c3++; break;
                case 3: c4++; break;
                case 4: c5++; break;
                default:
                    throw new AssertionError();
            }
        }
        
        if (c5 == 1)
            return Type.QUINTILE;
        else if (c4 == 1)
            return Type.POKER;
        else if (c3 == 1 && c2 == 1)
            return Type.FULL;
        else if (c3 == 1)
            return Type.TERCE;
        else if (c2 == 2)
            return Type.TWO_PAIR;
        else if (c2 == 1)
            return Type.PAIR;
        else if(c1 == 5)
            return Type.ALL_DIFERENT;
        else
            throw new TestException("Poker no valid");
    }

    private void fillTypes() {
        this.types.addAll(Arrays.asList(Type.values()));
        for (Type type : types) {
            type.cont = 0;
        }
    }
    
    private enum Type {
        ALL_DIFERENT(0.30240d), PAIR(0.50400d), TWO_PAIR(0.10800d), TERCE(0.07200),
        FULL(0.00900), POKER(0.00450), QUINTILE(0.00010);
        
        private int cont;
        
        private double probability;

        private Type(double probability) {
            this.cont = 0;
            this.probability = probability;
        }
    }
}
