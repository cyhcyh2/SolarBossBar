package me.cyh2.solarbossbar;

import me.cyh2.solarbossbar.commands.reload;
import me.cyh2.solarbossbar.event.OnPlayerJoin;
import me.cyh2.solarbossbar.runnable.BossBarRunnable;
import me.cyh2.solarmc.api.ColourLogger;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.time.Instant;
import java.util.logging.Logger;

import static me.cyh2.solarmc.api.ConfigAPI.LOAD;
import static me.cyh2.solarmc.api.utils.MinecraftTextUtils.ReColor;

public final class SolarBossBar extends JavaPlugin {
    public static Server server;
    public static Plugin plugin;
    public static Logger logger;
    public static ColourLogger clogger;
    public static PluginManager pluginManager;
    public static File DataFolder;
    public static YamlConfiguration config;
    public static String Developer;
    public static String DevTeam;
    public static String PluginName;
    public static String MessagePrefix;
    public static BossBar PublicBossBar;
    @Override
    public void onEnable() {
        long start = Instant.now().toEpochMilli();
        saveResource("config.yml", false);
        DataFolder = getDataFolder();
        config = LOAD("config.yml", DataFolder);
        Developer = "cyh2";
        DevTeam = "SolarMC";
        PluginName = ReColor("&7[&bSolar&fBossBar&7]");
        MessagePrefix = ReColor(config.getString("MessagePrefix"));
        server = getServer();
        plugin = getPlugin(getClass());
        logger = getLogger();
        clogger = new ColourLogger(PluginName);
        pluginManager = server.getPluginManager();
        PublicBossBar = Bukkit.createBossBar(ReColor(PluginName), BarColor.BLUE, BarStyle.SEGMENTED_6);
        BossBarRunnable.start();
        Variable.register();
        pluginManager.registerEvents(new OnPlayerJoin(), plugin);
        getCommand("solar-boss-bar-reload").setExecutor(new reload());
        logger.info("基础部分加载完成！");
        clogger.info("&bSolar&fBossBar&f启动成功了哦~");
        clogger.info("本次启动耗时：&b" + ( Instant.now().toEpochMilli() - start ) + "ms&r");
    }

    @Override
    public void onDisable() {
        long stop = Instant.now().toEpochMilli();
        Variable.unregister();
        logger.info("主要部分卸载完成！");
        clogger.info("&bSolar&fBossBar&f卸载成功了哦~");
        clogger.info("本次关闭耗时：&b" + ( Instant.now().toEpochMilli() - stop ) + "ms&r");
    }
}
