package com.myowndev.invasion.entity.enemies;

import com.myowndev.invasion.entity.Enemy;

/**
 * Created by Iwan on 22.09.2015.
 */
public class Tier5 extends Enemy {
    public Tier5(int start_x, int start_y) {
        super(start_x, start_y);
        speed = 1;
        scoreGain = 2;
        scoreLoss = 5;
        hp = 10;
        silverGain = 2;
    }
}































































































