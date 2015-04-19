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

import java.util.Arrays;

/**
 *
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class Kolmogorov implements ITest {
    
    private float alpha;

    public Kolmogorov() {
        this.alpha = 0.05f;
    }

    public Kolmogorov(float alpha) {
        this.alpha = alpha;
    }

    @Override
    public boolean test(double... values) {
        Arrays.sort(values);

        double[] D = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            double da = i / values.length;
            double d = da - values[i];
            D[i] = Math.abs(d);
        }

        Arrays.sort(D);

        double value = KolmogorovTable.getInstance().getValue(alpha, values.length);

        return D[D.length - 1] < value;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }
}
