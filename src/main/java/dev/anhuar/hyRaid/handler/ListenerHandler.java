package dev.anhuar.hyRaid.handler;

/*
 * ========================================================
 * HyRaid - ListenerHandler.java
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
import dev.anhuar.hyRaid.listener.PlayerListener;
import dev.anhuar.hyRaid.listener.WorldListener;
import org.bukkit.event.Listener;

import java.util.Arrays;
import java.util.List;

public class ListenerHandler {

    private final HyRaid plugin;

    public ListenerHandler(HyRaid plugin) {
        this.plugin = plugin;
        registerListeners();
    }

    private void registerListeners() {
        List<Listener> listeners = Arrays.asList(
                new PlayerListener(),
                new WorldListener()
        );

        for (Listener listener : listeners) {
            plugin.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }
}