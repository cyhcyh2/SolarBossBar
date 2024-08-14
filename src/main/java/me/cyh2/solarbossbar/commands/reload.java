package me.cyh2.solarbossbar.commands;

import me.cyh2.solarbossbar.Variable;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.cyh2.solarbossbar.SolarBossBar.*;
import static me.cyh2.solarmc.api.ConfigAPI.LOAD;
import static me.cyh2.solarmc.api.utils.MinecraftTextUtils.ReColor;

public class reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender.hasPermission("SolarBossBar.reload")) {
            commandSender.sendMessage(ReColor(MessagePrefix + " &7正在重载插件……"));
            commandSender.sendMessage(ReColor(MessagePrefix + " &7Reloading……"));
            config = LOAD("config.yml", DataFolder);
            Variable.unregister();
            Variable.register();
            commandSender.sendMessage(ReColor(MessagePrefix + " &7重载完成！"));
            commandSender.sendMessage(ReColor(MessagePrefix + " &7Reloaded!"));
        }
        return false;
    }
}
