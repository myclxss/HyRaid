package dev.anhuar.hyRaid.command;

/*
 * ========================================================
 * HyRaid - HyRaidCommand.java
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
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.AutoComplete;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.DefaultFor;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;

@Command("hyraid")
@CommandPermission("hyraid.admin")
@AutoComplete("setup event reward")
public class HyRaidCommand {

    private final HyRaid plugin = HyRaid.getInstance();

    @DefaultFor("hyraid")
    public void onDefaultCommand() {

    }

    @Subcommand("setup")
    @AutoComplete("nucleo region")
    public void onSetupCommand(String subCommand, Player player) {

        switch (subCommand.toLowerCase()) {
            case "nucleo" -> {
                player.sendMessage("§aNucleo setup command executed.");
            }
            case "region" -> {
                player.sendMessage("§aRegion setup command executed.");
            }
            default -> {
                player.sendMessage("§cUnknown setup command. Use /hyraid setup nucleo or /hyraid setup region.");
            }
        }
    }

    @Subcommand("event")
    @AutoComplete("start stop forcestart forcestop")
    public void onEventCommand(String subCommand, Player player) {

        switch (subCommand.toLowerCase()) {
            case "start" -> {
                player.sendMessage("§aEvent start command executed.");
            }
            case "stop" -> {
                player.sendMessage("§aEvent stop command executed.");
            }
            case "forcestart" -> {
                player.sendMessage("§aEvent force start command executed.");
            }
            case "forcestop" -> {
                player.sendMessage("§aEvent force stop command executed.");
            }
            default -> {
                player.sendMessage("§cUnknown event command. Use /hyraid event start, stop, forcestart, or forcestop.");
            }
        }
    }

    @Subcommand("reward")
    @AutoComplete("give add remove giveall")
    public void onRewardCommand(String subCommand, Player player) {

        switch (subCommand.toLowerCase()) {
            case "add" -> {
                player.sendMessage("§aReward add command executed.");
            }
            case "remove" -> {
                player.sendMessage("§aReward remove command executed.");
            }
            case "give" -> {
                player.sendMessage("§aReward give command executed.");
            }
            case "giveall" -> {
                player.sendMessage("§aReward giveall command executed.");
            }
            default -> {
                player.sendMessage("§cUnknown reward command. Use /hyraid reward give, add, remove, or giveall.");
            }
        }

    }
}