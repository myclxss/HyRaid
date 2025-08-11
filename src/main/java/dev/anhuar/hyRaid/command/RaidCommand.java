package dev.anhuar.hyRaid.command;

/*
 * ========================================================
 * HyRaid - RaidCommand.java
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
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.DefaultFor;

@Command("raid")
public class RaidCommand {

    private final HyRaid plugin = HyRaid.getInstance();

    @DefaultFor("raid")
    public void onDefaultCommand() {
    }
}