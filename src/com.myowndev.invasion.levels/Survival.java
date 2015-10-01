package com.myowndev.invasion.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.utils.Array;
import com.myowndev.invasion.helpers.Config;
import com.myowndev.invasion.states.GameState;
import com.myowndev.invasion.entity.Enemy;
import com.myowndev.invasion.entity.enemies.*;
import com.myowndev.invasion.helpers.Assets;

/**
 * Created by Iwan on 22.09.2015.
 */
public class Survival extends GameState {

    private static RandomXS128 random = new RandomXS128();
    private static int randomTemp;
    public static Array<Tier1> enemies_tier1 = new Array<Tier1>();
    public static Array<Tier2> enemies_tier2 = new Array<Tier2>();
    public static Array<Tier3> enemies_tier3 = new Array<Tier3>();
    public static Array<Tier4> enemies_tier4 = new Array<Tier4>();
    public static Array<Tier5> enemies_tier5 = new Array<Tier5>();

    private static Sound tapSound = Gdx.audio.newSound(Gdx.files.internal("sounds/tap.ogg"));// for temp

    public static void update() {
        if(Config.playMusic == true) {
            randomTemp = random.nextInt(1);
            if (Assets.bgm != null)
                Assets.bgm.stop();
            Config.playMusic = false;
            switch (randomTemp) {
                case 0:
                    Assets.bgm = Gdx.audio.newMusic(Gdx.files.internal("music/bgm1.ogg"));
                    Assets.bgm.play();
                    break;
                case 1:
                    Assets.bgm = Gdx.audio.newMusic(Gdx.files.internal("music/bgm2.ogg"));
                    Assets.bgm.play();
                    break;
            }
        }
        if(Gdx.input.justTouched()) {
            touch_x = Gdx.input.getX();
            touch_y = (Gdx.graphics.getHeight() + 0) - Gdx.input.getY();
            pastTime = System.currentTimeMillis();
            GameState.tapped = true;
            if (Config.playSound) tapSound.play();
        }
        if (System.currentTimeMillis() > pastTime + 100) {
            touch_x = 10000;
            touch_y = 10000;
            GameState.tapped = false;
        }
        updateTier1();
        updateTier2();
        updateTier3();
        updateTier4();
        updateTier5();
        if (Config.LOCAL_SCORE == -10) { // условие проигрыша
            Config.GAMESTATE = 4;
            Config.LOCAL_SCORE = 0;
            Config.LOCAL_PASSED = 0;
            Config.LOCAL_CAUGHT = 0;
            for (int i = 0; i < enemies_tier1.size; i++)
                enemies_tier1.removeIndex(i);
            for (int i = 0; i < enemies_tier2.size; i++)
                enemies_tier2.removeIndex(i);
            for (int i = 0; i < enemies_tier3.size; i++)
                enemies_tier3.removeIndex(i);
            for (int i = 0; i < enemies_tier4.size; i++)
                enemies_tier4.removeIndex(i);
            for (int i = 0; i < enemies_tier5.size; i++)
                enemies_tier5.removeIndex(i);
        }
    }
    /*private void enemyUpdate(Object str, Array enemies, int size) {
        enemies =
        if (enemies.size < size) {
            enemies.add(new (
                    random.nextInt(Gdx.graphics.getWidth() - (Assets.enemy1.getWidth() * Enemy.scale)) + 40,
                    Gdx.graphics.getHeight()));
        }
    }*/
    private static void updateTier1() {
        if (enemies_tier1.size < 4) {
            enemies_tier1.add(new Tier1(
                    random.nextInt(Gdx.graphics.getWidth() - (Assets.enemy1.getWidth() * Enemy.scale)) + 40,
                    Gdx.graphics.getHeight()));
        }
        for (int i = 0; i < enemies_tier1.size; i++) {
            enemies_tier1.get(i).update();
            if (enemies_tier1.size != 0 && enemies_tier1.get(i).y < (0 - Assets.enemy1.getHeight())) {
                enemies_tier1.get(i).passed();
                enemies_tier1.removeIndex(i);
            }
            if (enemies_tier1.size != 0 && enemies_tier1.get(i).remove == true) {
                enemies_tier1.get(i).caught();
                enemies_tier1.get(i).remove = false;
                enemies_tier1.removeIndex(i);
            }
        }
    }
    private static void updateTier2() {
        if (enemies_tier2.size < 3) {
            enemies_tier2.add(new Tier2(
                    random.nextInt(Gdx.graphics.getWidth() - (Assets.enemy2.getWidth() * Enemy.scale)) + 40,
                    Gdx.graphics.getHeight()));
        }
        for (int i = 0; i < enemies_tier2.size; i++) {
            enemies_tier2.get(i).update();
            if (enemies_tier2.size != 0 && enemies_tier2.get(i).y < (0 - Assets.enemy2.getHeight())) {
                enemies_tier2.get(i).passed();
                enemies_tier2.removeIndex(i);
            }
            if (enemies_tier2.size != 0 && enemies_tier2.get(i).remove == true) {
                enemies_tier2.get(i).caught();
                enemies_tier2.get(i).remove = false;
                enemies_tier2.removeIndex(i);
            }
        }
    }
    private static void updateTier3() {
        if (enemies_tier3.size < 2) {
            enemies_tier3.add(new Tier3(
                    random.nextInt(Gdx.graphics.getWidth() - (Assets.enemy3.getWidth() * Enemy.scale)) + 40,
                    Gdx.graphics.getHeight()));
        }
        for (int i = 0; i < enemies_tier3.size; i++) {
            enemies_tier3.get(i).update();
            if (enemies_tier3.size != 0 && enemies_tier3.get(i).y < (0 - Assets.enemy3.getHeight())) {
                enemies_tier3.get(i).passed();
                enemies_tier3.removeIndex(i);
            }
            if (enemies_tier3.size != 0 && enemies_tier3.get(i).remove == true) {
                enemies_tier3.get(i).caught();
                enemies_tier3.get(i).remove = false;
                enemies_tier3.removeIndex(i);
            }
        }
    }
    private static void updateTier4() {
        if (enemies_tier4.size < 1) {
            enemies_tier4.add(new Tier4(
                    random.nextInt(Gdx.graphics.getWidth() - (Assets.enemy4.getWidth() * Enemy.scale)) + 40,
                    Gdx.graphics.getHeight()));
        }
        for (int i = 0; i < enemies_tier4.size; i++) {
            if (enemies_tier4.size != 0) {
                enemies_tier4.get(i).update();
            }
            if (enemies_tier4.size != 0 && enemies_tier4.get(i).y < (0 - Assets.enemy4.getHeight())) {
                enemies_tier4.get(i).passed();
                enemies_tier4.removeIndex(i);
            }
            if (enemies_tier4.size != 0 && enemies_tier4.get(i).remove == true) {
                enemies_tier4.get(i).remove = false;
                enemies_tier4.get(i).caught();
                enemies_tier4.removeIndex(i);
            }
        }
    }
    private static void updateTier5() {
        if (enemies_tier5.size < 1) {
            enemies_tier5.add(new Tier5(
                    random.nextInt(Gdx.graphics.getWidth() - (Assets.enemy5.getWidth() * Enemy.scale)) + 40,
                    Gdx.graphics.getHeight()));
        }
        for (int i = 0; i < enemies_tier5.size; i++) {
            enemies_tier5.get(i).update();
            if (enemies_tier5.size != 0 && enemies_tier5.get(i).y < (0 - Assets.enemy5.getHeight())) {
                enemies_tier5.get(i).passed();
                enemies_tier5.removeIndex(i);
            }
            if (enemies_tier5.size != 0 && enemies_tier5.get(i).remove == true) {
                enemies_tier5.get(i).caught();
                enemies_tier5.get(i).remove = false;
                enemies_tier5.removeIndex(i);
            }
        }
    }
}













































































