package com.myowndev.invasion.entity;

import com.myowndev.invasion.states.GameState;
import com.myowndev.invasion.helpers.Assets;
import com.myowndev.invasion.helpers.Config;

/**
 * Created by Iwan on 17.09.2015.
 */
public class Enemy {
    public final static int scale = 2; // also hitbox_multiplier
    public int[] hitbox_x;
    public int[] hitbox_y;
    public static int scoreGain;
    public static int scoreLoss;
    public boolean remove;
    public boolean invulnerable;

    public static long invulTime = 110;

    public int speed;
    public int hp;
    public int silverGain;

    public int x;
    public int y;

    private void init() {
        invulnerable = false;
        remove = false;
        hitbox_x = new int[Assets.enemy1.getWidth() * scale];
        hitbox_y = new int[Assets.enemy1.getHeight() * scale];
    }
    public void update() {
        y = (y - (1 * speed));
        for (int rx = 0; rx < (Assets.enemy1.getWidth() * scale); rx++) {
            hitbox_x[rx] = ((x + rx) -20);
            for(int ry = 0; ry < (Assets.enemy1.getHeight() * scale); ry++) {
                hitbox_y[ry] = ((y + ry) - 20);
                if (GameState.touch_x == hitbox_x[rx] && GameState.touch_y == hitbox_y[ry]) {
                    hp = hp - 1;
                    invulnerable = true;
                    if (hp == 0)
                        remove = true;
                }
            }
        }
        if (invulnerable == true && System.currentTimeMillis() == (GameState.pastTime + invulTime))
            invulnerable = false;
    }
    public void passed() {
        Config.LOCAL_SCORE = Config.LOCAL_SCORE - Enemy.scoreLoss;
        Config.LOCAL_PASSED = Config.LOCAL_PASSED + 1;
        Config.GLOBAL_PASSED = Config.GLOBAL_PASSED + 1;
    }
    public void caught() {
        Config.LOCAL_SCORE = Config.LOCAL_SCORE + Enemy.scoreGain;
        Config.GLOBAL_SCORE = Config.GLOBAL_SCORE - Enemy.scoreGain;
        Config.LOCAL_CAUGHT = Config.LOCAL_CAUGHT + 1;
        Config.GLOBAL_CAUGHT = Config.GLOBAL_CAUGHT + 1;
        Config.SILVERAMOUNT = Config.SILVERAMOUNT + silverGain;
    }
    public Enemy(int start_x, int start_y) {
        x = start_x;
        y = start_y;
        init();
    }
}



















































































