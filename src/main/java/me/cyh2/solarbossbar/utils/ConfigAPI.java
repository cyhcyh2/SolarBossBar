package me.cyh2.solarbossbar.utils;

import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConfigAPI {
    public static List<String> getConfigList (YamlConfiguration config, String key) {
        if (config.contains(key)) {
            Map<String, Object> bossBars = config.getConfigurationSection(key).getValues(false);
            List<String> re = new ArrayList<>();
            for (Map.Entry<String, Object> entry : bossBars.entrySet()) {
                String key1 = entry.getKey();
                re.add(key1);
            }
            return re;
        }
        return new ArrayList<>();
    }
}
