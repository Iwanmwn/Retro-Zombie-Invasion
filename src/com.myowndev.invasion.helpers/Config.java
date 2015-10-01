package com.myowndev.invasion.helpers;

/**
 * Created by Iwan on 19.09.2015.
 */
public class Config {

    public static int GAMESTATE = 0; // 0 for logo state, 1 for menu state, 2 for survival mode state
    public static boolean isOnline = false; // determinants online/offline game mode [needs for google.play statistics]
    public static boolean playSound = true;
    public static boolean playMusic = true;
    public static int lang = 0; // 0 - english, 1 - russian

    // Const global variables ???:
    public static int SILVERAMOUNT = 0;
    public static int GOLDAMOUNT = 0;

    // Statistics:
    // Local (для одной катки, текущей):
    public static int LOCAL_SCORE = 0;
    public static int LOCAL_CAUGHT = 0;
    public static int LOCAL_PASSED = 0;
    public static int LOCAL_FRAGS_TIER1 = 0; // posle osnovnix fich dobavit' etu statu
    public static int LOCAL_FRAGS_TIER2 = 0;
    public static int LOCAL_FRAGS_TIER3 = 0;
    public static int LOCAL_FRAGS_TIER4 = 0;
    public static int LOCAL_FRAGS_TIER5 = 0;
    // Global (для хранения в google.play stats): // парсить при каждом включении игры [if timeout, then proceed offline mode]
    public static int GLOBAL_SCORE = 0;
    public static int GLOBAL_CAUGHT = 0;
    public static int GLOBAL_PASSED = 0;
    public static int GLOBAL_FRAGS_TIER1 = 0;
    public static int GLOBAL_FRAGS_TIER2 = 0;
    public static int GLOBAL_FRAGS_TIER3 = 0;
    public static int GLOBAL_FRAGS_TIER4 = 0;
    public static int GLOBAL_FRAGS_TIER5 = 0;
}









































































