package com.myowndev.invasion.helpers;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Iwan on 19.09.2015.
 */
public class Assets {

    public static Texture logo;
    public static Texture background1_grass;
    public static Texture background2_coldgrass;
    public static Texture enemy1;
    public static Texture enemy2;
    public static Texture enemy3;
    public static Texture enemy4;
    public static Texture enemy5;

    public static Texture btn1_survival;
    public static Texture btn2_scenario;
    public static Texture btn3_stats;
    public static Texture btn4_shop;
    public static Texture btn5_soundOn;
    public static Texture btn5_soundOff;
    public static Texture btn5_sound;
    public static Texture btn6_musicOn;
    public static Texture btn6_musicOff;
    public static Texture btn6_music;
    public static Texture btn7_lang_ru;
    public static Texture btn7_lang_en;
    public static Texture btn7_lang;
    public static Texture menu_logo;

    public static Texture blood1;
    public static Texture blood2;
    public static Texture blood3;
    public static Texture blood4;
    public static Texture blood5;
    public static Texture blood6;

    public static Texture tapShadow;

    public static Music bgm;

    private void init() {
        logo = new Texture("myowndev.jpg");
        background1_grass = new Texture("textures/backgrounds/background1_grass.png");
        background2_coldgrass = new Texture("textures/backgrounds/background2_coldgrass.png");
        enemy1 = new Texture("textures/enemies/enemy1.png");
        enemy2 = new Texture("textures/enemies/enemy2.png");
        enemy3 = new Texture("textures/enemies/enemy3.png");
        enemy4 = new Texture("textures/enemies/enemy4.png");
        enemy5 = new Texture("textures/enemies/enemy5.png");

        btn1_survival = new Texture("textures/menu/btn1_survival.png");
        btn2_scenario = new Texture("textures/menu/btn2_scenario.png");
        btn3_stats = new Texture("textures/menu/btn3_stats.png");
        btn4_shop = new Texture("textures/menu/btn4_shop.png");
        btn5_soundOn = new Texture("textures/menu/btn5_soundOn.png");
        btn5_soundOff = new Texture("textures/menu/btn5_soundOff.png");
        btn6_musicOn = new Texture("textures/menu/btn6_musicOn.png");
        btn6_musicOff = new Texture("textures/menu/btn6_musicOff.png");
        btn7_lang_ru = new Texture("textures/menu/btn7_lang_ru.png");
        btn7_lang_en = new Texture("textures/menu/btn7_lang_en.png");
        menu_logo = new Texture("textures/menu/logo.png");
        if (Config.playSound) btn5_sound = btn5_soundOn;
        if (!Config.playSound) btn5_sound = btn5_soundOff;
        if (Config.playMusic) btn6_music = btn6_musicOn;
        if (!Config.playMusic) btn6_music = btn6_musicOff;
        if (Config.lang == 0) btn7_lang = btn7_lang_ru;
        if (Config.lang == 1) btn7_lang = btn7_lang_en;

        blood1 = new Texture("textures/bloodphases/blood1.png");
        blood2 = new Texture("textures/bloodphases/blood2.png");
        blood3 = new Texture("textures/bloodphases/blood3.png");
        blood4 = new Texture("textures/bloodphases/blood4.png");
        blood5 = new Texture("textures/bloodphases/blood5.png");
        blood6 = new Texture("textures/bloodphases/blood6.png");

        tapShadow = new Texture("textures/effects/tapShadow.png");
    }
    public Assets() {
        init();
    }
}






























































































































