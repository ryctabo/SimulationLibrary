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
package com.ryctabo.random.test;

import java.util.ArrayList;

/**
 *
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class RunUpBelow implements ITest {
    
    private float alpha;
    
    private ArrayList<RunUpBelow.Longitude> list;

    public RunUpBelow() {
        this.alpha = 0.05f;
        this.list = new ArrayList<>();
    }

    public RunUpBelow(float alpha) {
        this.alpha = alpha;
        this.list = new ArrayList<>();
    }

    @Override
    public boolean test(double... values) {
        byte[] binary = new byte[values.length];
        
        for (int i = 0; i < values.length; i++) {
            if (values[i] < 0.5)
                binary[i] = 0;
            else 
                binary[i] = 1;
        }
        
        byte actualBinary = binary[0];
        int index = 1;
        do {
            int cont = 1;
            for (int i = index; i < values.length; i++) {
                index++;
                if (binary[i] != actualBinary) {
                    actualBinary = binary[i];
                    break;
                }
                cont++;
            }
            
            if (belong(cont)) {
                final int position = getIndexListForLongitude(cont);
                if (position != -1) {
                    this.list.get(position).add();
                }
            } else {
                this.list.add(new RunUpBelow.Longitude(cont));
            }
        } while (index < values.length);
        
        double x0 = 0d;
        
        for (RunUpBelow.Longitude item : this.list) {
            double fe;
            
//            if (!item.equals(this.list.get(this.list.size() - 1))) {
                double i = item.longitude;
                fe = 2d * ((double) ((Math.pow(i, 2) + 3 * i + 1) * values.length - (Math.pow(i, 3) + 3 * Math.pow(i, 2) - i - 4)) / (double) com.ryctabo.util.Math.fact((int) i + 3));
//            } else {
//                fe = 2d / (double) utilities.Math.fact(values.length);
//            }
            
            x0 += Math.pow(item.cont - fe, 2) / fe;
        }
        
        double chi2 = Chi2.getInstance().getValue(alpha, this.list.size() * 1);
        
        return x0 < chi2;
    }
    
    public boolean belong(int longitude) {
        for (RunUpBelow.Longitude item : list) {
            if (item.getLongitude() == longitude) {
                return true;
            }
        }
        return false;
    }
    
    public int getIndexListForLongitude(int longitude) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getLongitude() == longitude) {
                return i;
            }
        }
        return -1;
    }
    
    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }
    
    private class Longitude {
        
        private int longitude;
        
        protected int cont;

        public Longitude(int longitude) {
            this.longitude = longitude;
            this.cont = 1;
        }
        
        public void add() {
            this.cont++;
        }

        public int getLongitude() {
            return longitude;
        }

        public void setLongitude(int longitude) {
            this.longitude = longitude;
        }

        public int getCont() {
            return cont;
        }

        public void setCont(int cont) {
            this.cont = cont;
        }
        
    }
    
}
