package me.cyh2.solarbossbar.runnable;

import me.cyh2.solarbossbar.Variable;
import org.bukkit.boss.BarColor;
import org.bukkit.scheduler.BukkitRunnable;

import static me.cyh2.solarbossbar.SolarBossBar.*;
import static me.cyh2.solarmc.api.utils.MinecraftTextUtils.ReColor;

public class BossBarRunnable extends Variable {
    private static int runTicks = 0;
    public static void start () {
        new BukkitRunnable() {
            @Override
            public void run() {
                runTicks ++;
                if (runTicks >= BossBars.size()) {
                    runTicks = 0;
                }
                PublicBossBar.setTitle(ReColor(config.getString("BossBars." + BossBars.get(runTicks) + ".title")));
                PublicBossBar.setColor(BarColor.valueOf(config.getString("BossBars." + BossBars.get(runTicks) + ".color")));
            }
        }.runTaskTimer(plugin, 0L, config.getLong("SwitchingSpeed"));
    }
}
