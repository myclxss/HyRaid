package dev.anhuar.hyRaid;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class HyRaid extends JavaPlugin {

    @Getter
    private static HyRaid instance;

    @Override
    public void onEnable() {

        instance = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
