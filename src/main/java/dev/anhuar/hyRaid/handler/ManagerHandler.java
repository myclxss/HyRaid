package dev.anhuar.hyRaid.handler;

/*
 * ========================================================
 * HyRaid - ManagerHandler.java
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
import dev.anhuar.hyRaid.manager.EventManager;
import dev.anhuar.hyRaid.manager.RaidManager;
import dev.anhuar.hyRaid.manager.RewardManager;
import lombok.Getter;

@Getter
public class ManagerHandler {

    private final HyRaid plugin;

    private EventManager eventManager;
    private RaidManager raidManager;
    private RewardManager rewardManager;

    public ManagerHandler(HyRaid plugin) {
        this.plugin = plugin;
        registerManager();
    }

    public void registerManager() {
        this.eventManager = new EventManager();
        this.raidManager = new RaidManager();
        this.rewardManager = new RewardManager();
    }
}