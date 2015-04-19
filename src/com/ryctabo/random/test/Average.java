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

/**
 *
 * @author Gustavo Pacheco Gómez
 * @version 1.0
 */
public class Average implements ITest{
    
    private float alpha;

    public Average() {
        this.alpha = 0.05f;
    }

    public Average(float alpha) {
        this.alpha = alpha;
    }

    @Override
    public boolean test(double... values) {
        double average = com.ryctabo.util.Math.prom(values);
        double z0 = (average - 0.5d) * Math.sqrt(values.length) / Math.sqrt(1 / 12);
        return z0 < 1.96d;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }
}
