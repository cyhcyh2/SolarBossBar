package me.cyh2.solarbossbar;

import java.util.List;

import static me.cyh2.solarbossbar.SolarBossBar.config;
import static me.cyh2.solarbossbar.utils.ConfigAPI.getConfigList;

public class Variable {
    public static List<String> BossBars;
    public static void register () {
        BossBars = getConfigList(config, "BossBars");
    }
    public static void unregister () {
        BossBars.clear();
    }
}
