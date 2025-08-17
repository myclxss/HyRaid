package dev.anhuar.hyRaid;

import dev.anhuar.hyRaid.handler.CommandHandler;
import dev.anhuar.hyRaid.handler.ListenerHandler;
import dev.anhuar.hyRaid.handler.ManagerHandler;
import dev.anhuar.hyRaid.util.ConfigUtil;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class HyRaid extends JavaPlugin {

    @Getter
    private static HyRaid instance;

    private ConfigUtil setting, message, raid;

    private CommandHandler commandHandler;
    private ListenerHandler listenerHandler;
    private ManagerHandler managerHandler;

    @Override
    public void onEnable() {

        instance = this;

        setting = new ConfigUtil(this, "setting.yml");
        message = new ConfigUtil(this, "message.yml");
        raid = new ConfigUtil(this, "raid.yml");

        commandHandler = new CommandHandler(this);
        listenerHandler = new ListenerHandler(this);
        managerHandler = new ManagerHandler(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
