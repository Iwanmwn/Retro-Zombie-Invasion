package com.myowndev.invasion.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.myowndev.invasion.helpers.Assets;
import com.myowndev.invasion.helpers.Config;

/**
 * Created by Iwan on 24.09.2015.
 */
public class MenuState {

    public static int btn1_survival_x = (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 2) - Assets.btn1_survival.getWidth() / 2;
    public static int btn1_survival_y = 20 + 3 * Assets.btn1_survival.getHeight();
    private static Rectangle btn1_survival = new Rectangle(btn1_survival_x, btn1_survival_y, btn1_survival_x + Assets.btn1_survival.getWidth(), btn1_survival_y + Assets.btn1_survival.getHeight());
    public static int btn2_scenario_x = (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 2) - Assets.btn2_scenario.getWidth() / 2;
    public static int btn2_scenario_y = 15 + 2 * Assets.btn2_scenario.getHeight();
    private static Rectangle btn2_scenario = new Rectangle(btn2_scenario_x, btn2_scenario_y,btn2_scenario_x + Assets.btn1_survival.getWidth(), btn2_scenario_y + Assets.btn1_survival.getHeight());
    public static int btn3_stats_x = (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 2) - Assets.btn3_stats.getWidth() / 2;
    public static int btn3_stats_y = 10 + 1 * Assets.btn3_stats.getHeight();
    private static Rectangle btn3_stats = new Rectangle(btn3_stats_x, btn3_stats_y, btn3_stats_x + Assets.btn1_survival.getWidth(), btn3_stats_y + Assets.btn1_survival.getHeight());
    public static int btn4_shop_x = (Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 2) - Assets.btn4_shop.getWidth() / 2;
    public static int btn4_shop_y = 5;
    private static Rectangle btn4_shop = new Rectangle(btn4_shop_x, btn4_shop_y, btn4_shop_x + Assets.btn1_survival.getWidth(), btn4_shop_y + Assets.btn1_survival.getHeight());
    public static int btn5_sound_x = Gdx.graphics.getWidth() - Assets.btn5_soundOn.getWidth() * 3 - 20;
    public static int btn5_sound_y = Assets.btn5_soundOn.getHeight() + 5;
    private static Rectangle btn5_sound = new Rectangle(btn5_sound_x, btn5_sound_y, btn5_sound_x + Assets.btn5_soundOn.getWidth(), btn5_sound_y + Assets.btn5_soundOn.getHeight());
    public static int btn6_music_x = Gdx.graphics.getWidth() - Assets.btn6_musicOn.getWidth() * 2 - 10;
    public static int btn6_music_y = Assets.btn6_musicOn.getHeight() + 5;
    private static Rectangle btn6_music = new Rectangle(btn6_music_x, btn6_music_y, btn6_music_x + Assets.btn5_soundOn.getWidth(), btn6_music_y + Assets.btn5_soundOn.getWidth());
    public static int btn7_lang_x = Gdx.graphics.getWidth() - Assets.btn7_lang_ru.getWidth();
    public static int btn7_lang_y = Assets.btn7_lang_ru.getHeight() + 5;
    private static Rectangle btn7_lang = new Rectangle(btn7_lang_x, btn7_lang_y, btn7_lang_x + Assets.btn5_soundOn.getWidth(), btn7_lang_y + Assets.btn5_soundOn.getWidth());

    public static void update() {
        if(Config.GAMESTATE == 1) {
            update_mainMenu();
        }
    }
    private static void update_mainMenu() {
        if (intersects(btn1_survival))
            Config.GAMESTATE = 2;
        if (intersects(btn2_scenario)) {

        }
        if (intersects(btn3_stats)) {

        }
        if (intersects(btn4_shop)) {

        }
        if (intersects(btn5_sound))
            if (Config.playSound) {
                Config.playSound = false;
                Assets.btn5_sound = Assets.btn5_soundOff;
            } else {
                Config.playSound = true;
                Assets.btn5_sound = Assets.btn5_soundOn;
            }
        if (intersects(btn6_music))
            if (Config.playMusic) {
                Config.playMusic = false;
                Assets.btn6_music = Assets.btn6_musicOff;
            } else {
                Config.playMusic = true;
                Assets.btn6_music = Assets.btn6_musicOn;
            }
        if (intersects(btn7_lang))
            switch (Config.lang) {
                case 0:
                    Config.lang = 1;
                    Assets.btn7_lang = Assets.btn7_lang_en;
                    break;
                case 1:
                    Config.lang = 0;
                    Assets.btn7_lang = Assets.btn7_lang_ru;
                    break;
            }
    }
    private static void update_statsMenu() {

    }
    private static void update_shopMenu() {

    }
    private static boolean intersects(Rectangle rec) {
        for (float x = rec.getX(); x < rec.getWidth(); x++)
            for (float y = rec.getY(); y < rec.getHeight(); y++)
                if (Gdx.input.justTouched())
                    if (Gdx.input.getX() == x && (Gdx.graphics.getHeight() - Gdx.input.getY()) == y)
                        return true;
        return false;
    }
}



















































































