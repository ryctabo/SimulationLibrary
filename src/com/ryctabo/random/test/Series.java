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
public class Series implements ITest {

    private int intervals;
    
    private float alpha;
    
    private ArrayList<Rank> ranks;
    
    private int[][] result;

    public Series() {
        this.alpha = 0.05f;
        this.intervals = 5;
        this.ranks = new ArrayList<>();
        this.result = new int[intervals][intervals];
        createRanks();
    }

    public Series(int intervals, float alpha) {
        this.intervals = intervals;
        this.alpha = alpha;
        this.ranks = new ArrayList<>();
        this.result = new int[intervals][intervals];
        createRanks();
    }
    
    @Override
    public boolean test(double... values) {
        for (int i = 0; i < values.length - 1; i++) {
            int x = -1, y = -1;
            for (int j = 0; j < intervals; j++) {
                if (this.ranks.get(j).belong(values[i])) {
                    x = j;
                }
                if (this.ranks.get(j).belong(values[i + 1])) {
                    y = j;
                }
            }
            this.result[x][y]++;
        }
        
        double value = (values.length - 1) / Math.pow(intervals, 2);
        
        double sum = 0;
        for (int i = 0; i < intervals; i++) {
            for (int j = 0; j < intervals; j++) {
                sum += Math.pow(result[i][j] - value, 2) * Math.pow(intervals, 2) / (values.length - 1);
            }
        }
        
        double chi2 = Chi2.getInstance().getValue(alpha, (int) Math.pow(intervals, 2)- 1);
        
        return sum < chi2;
    }

    private void createRanks() {
        double h = 1d / (double) intervals;
        for (int i = 0; i < intervals; i++) {
            this.ranks.add(new Rank(h * i, h * (i + 1)));
            for (int j = 0; j < intervals; j++) {
                this.result[i][j] = 0;
            }
        }
    }
    
}
