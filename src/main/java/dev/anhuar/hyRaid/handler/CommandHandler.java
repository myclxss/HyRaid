package dev.anhuar.hyRaid.handler;

/*
 * ========================================================
 * HyRaid - CommandHandler.java
 *
 * @author Anhuar Ruiz | Anhuar Dev | myclass
 * @web https://anhuar.dev
 * @date 10/08/2025
 *
 * License: MIT License - See LICENSE file for details.
 * Copyright (c) 2025 Anhuar Dev. All rights reserved.
 * ========================================================
 */

import dev.anhuar.hyRaid.HyRaid;
import dev.anhuar.hyRaid.command.HyRaidCommand;
import dev.anhuar.hyRaid.command.RaidCommand;
import revxrsal.commands.bukkit.BukkitCommandHandler;

public class CommandHandler {

    private final BukkitCommandHandler commandHandler;

    public CommandHandler(HyRaid plugin) {
        this.commandHandler = BukkitCommandHandler.create(plugin);
        commandHandler.registerDependency(HyRaid.class, plugin);

        registerCommands();
    }

    private void registerCommands() {

        commandHandler.register(new HyRaidCommand());
        commandHandler.register(new RaidCommand());

    }
}