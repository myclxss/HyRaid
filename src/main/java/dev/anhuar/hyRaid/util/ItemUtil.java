package dev.anhuar.hyRaid.util;

/*
 * ========================================================
 * HyRaid - ItemUtil.java
 *
 * @author Anhuar Ruiz | Anhuar Dev | myclass
 * @web https://anhuar.dev
 * @date 10/08/2025
 *
 * License: MIT License - See LICENSE file for details.
 * Copyright (c) 2025 Anhuar Dev. All rights reserved.
 * ========================================================
 */

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import dev.anhuar.hyRaid.HyRaid;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ItemUtil {

    private final ItemStack item;
    private final MiniMessage miniMessage = MiniMessage.miniMessage();

    public ItemUtil(Material material) {
        this.item = ItemStack.of(material);
    }

    public ItemUtil setName(String name) {
        item.editMeta(itemMeta -> itemMeta.displayName(miniMessage.deserialize(name).decoration(TextDecoration.ITALIC, false)));
        return this;
    }

    public ItemUtil setName(Component name) {
        item.editMeta(itemMeta -> itemMeta.displayName(name.decoration(TextDecoration.ITALIC, false)));
        return this;
    }

    public ItemUtil setLore(String... lore) {
        item.editMeta(itemMeta -> itemMeta.lore(Arrays.stream(lore).map(s -> miniMessage.deserialize(s).decoration(TextDecoration.ITALIC, false)).collect(Collectors.toList())));

        return this;
    }

    public ItemUtil setLore(List<String> lore) {
        item.editMeta(itemMeta -> itemMeta.lore(lore.stream().map(s -> miniMessage.deserialize(s).decoration(TextDecoration.ITALIC, false)).collect(Collectors.toList())));

        return this;
    }

    public ItemUtil addLoreLine(String line) {
        item.editMeta(itemMeta -> {
            List<Component> lore = itemMeta.lore();
            if (lore != null) {
                lore.add(miniMessage.deserialize(line).decoration(TextDecoration.ITALIC, false));
                itemMeta.lore(lore);
            }
        });
        return this;
    }

    public ItemUtil setAmount(int amount) {
        item.setAmount(amount);
        return this;
    }

    public ItemUtil setCustomModelData(int data) {
        item.editMeta(itemMeta -> itemMeta.setCustomModelData(data));
        return this;
    }

    public ItemUtil setBase64(String value) {
        if (value.isEmpty()) return this;

        PlayerProfile playerProfile = Bukkit.createProfile(UUID.randomUUID());
        playerProfile.setProperty(new ProfileProperty("textures", value));

        item.editMeta(SkullMeta.class, skullMeta -> {
            skullMeta.setPlayerProfile(playerProfile);
        });

        return this;
    }

    public ItemUtil setUnbreakable(boolean unbreakable) {
        item.editMeta(itemMeta -> itemMeta.setUnbreakable(unbreakable));
        return this;
    }

    public ItemUtil hideTooltip(boolean hide) {
        item.editMeta(itemMeta -> itemMeta.setHideTooltip(hide));
        return this;
    }

    public ItemUtil addItemFlag(ItemFlag itemFlag) {
        item.editMeta(itemMeta -> itemMeta.addItemFlags(itemFlag));
        return this;
    }

    public ItemUtil addItemFlags(ItemFlag... itemFlags) {
        item.editMeta(itemMeta -> itemMeta.addItemFlags(itemFlags));
        return this;
    }


    public ItemUtil setTag(NamespacedKey namespacedKey, String value) {
        item.editMeta(itemMeta -> itemMeta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.STRING, value));
        return this;
    }

    public ItemUtil setStringTag(String key, String value) {
        item.editMeta(itemMeta -> itemMeta.getPersistentDataContainer().set(new NamespacedKey(HyRaid.getInstance(), key), PersistentDataType.STRING, value));
        return this;
    }

    public ItemUtil setIntTag(String key, int value) {
        item.editMeta(itemMeta -> itemMeta.getPersistentDataContainer().set(new NamespacedKey(HyRaid.getInstance(), key), PersistentDataType.INTEGER, value));
        return this;
    }

    public ItemUtil setBooleanTag(String key, boolean value) {
        item.editMeta(itemMeta -> itemMeta.getPersistentDataContainer().set(new NamespacedKey(HyRaid.getInstance(), key), PersistentDataType.BYTE, (byte) (value ? 1 : 0)));
        return this;
    }

    public ItemStack build() {
        return item;
    }
}