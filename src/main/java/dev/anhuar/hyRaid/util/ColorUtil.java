package dev.anhuar.hyRaid.util;

/*
 * ========================================================
 * HyRaid - ColorUtil.java
 *
 * @author Anhuar Ruiz | Anhuar Dev | myclass
 * @web https://anhuar.dev
 * @date 10/08/2025
 *
 * License: MIT License - See LICENSE file for details.
 * Copyright (c) 2025 Anhuar Dev. All rights reserved.
 * ========================================================
 */

import lombok.experimental.UtilityClass;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class ColorUtil {
    private static final Pattern HEX_PATTERN = Pattern.compile("&#([A-Fa-f0-9]{6})");
    private static final Pattern LEGACY_HEX_PATTERN = Pattern.compile("§x(§[A-Fa-f0-9]){6}");
    private static final MiniMessage minimessage = MiniMessage.miniMessage();

    // Mapeo de códigos legacy a MiniMessage
    private static final Map<String, String> COLORS_MAPPINGS = Map.ofEntries(
            Map.entry("0", "black"), Map.entry("1", "dark_blue"), Map.entry("2", "dark_green"), Map.entry("3", "dark_aqua"),
            Map.entry("4", "dark_red"), Map.entry("5", "dark_purple"), Map.entry("6", "gold"), Map.entry("7", "gray"),
            Map.entry("8", "dark_gray"), Map.entry("9", "blue"), Map.entry("a", "green"), Map.entry("b", "aqua"),
            Map.entry("c", "red"), Map.entry("d", "light_purple"), Map.entry("e", "yellow"), Map.entry("f", "white"),
            Map.entry("k", "obfuscated"), Map.entry("l", "bold"), Map.entry("m", "strikethrough"),
            Map.entry("n", "underlined"), Map.entry("o", "italic"), Map.entry("r", "reset")
    );

    public String translateToString(String message) {
        Component component = translate(message);
        return MiniMessage.miniMessage().serialize(component);
    }

    public Component translate(String message) {
        // Procesar códigos hex primero
        String processedMessage = processHexColors(message);

        // Convertir códigos legacy a MiniMessage
        processedMessage = convertLegacyToMiniMessage(processedMessage);

        return minimessage.deserialize(processedMessage)
                .decoration(TextDecoration.ITALIC, false);
    }

    private String processHexColors(String message) {
        // Procesar &#RRGGBB format
        Matcher hexMatcher = HEX_PATTERN.matcher(message);
        StringBuilder result = new StringBuilder();

        while (hexMatcher.find()) {
            String hexColor = hexMatcher.group(1);
            hexMatcher.appendReplacement(result, "<#" + hexColor + ">");
        }
        hexMatcher.appendTail(result);

        // Procesar §x§R§R§G§G§B§B format (legacy hex)
        Matcher legacyHexMatcher = LEGACY_HEX_PATTERN.matcher(result.toString());
        StringBuilder finalResult = new StringBuilder();

        while (legacyHexMatcher.find()) {
            String legacyHex = legacyHexMatcher.group();
            String hexColor = extractHexFromLegacy(legacyHex);
            legacyHexMatcher.appendReplacement(finalResult, "<#" + hexColor + ">");
        }
        legacyHexMatcher.appendTail(finalResult);

        return finalResult.toString();
    }

    private String extractHexFromLegacy(String legacyHex) {
        // Extraer los caracteres hex de §x§R§R§G§G§B§B
        StringBuilder hex = new StringBuilder();
        for (int i = 2; i < legacyHex.length(); i += 2) {
            if (i + 1 < legacyHex.length()) {
                hex.append(legacyHex.charAt(i + 1));
            }
        }
        return hex.toString().toUpperCase();
    }

    private String convertLegacyToMiniMessage(String message) {
        StringBuilder result = new StringBuilder(message.length());

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if ((c == '&' || c == '\u00A7') && i + 1 < message.length()) {
                char nextChar = Character.toLowerCase(message.charAt(i + 1));
                String replacement = COLORS_MAPPINGS.get(String.valueOf(nextChar));
                if (replacement != null) {
                    result.append('<').append(replacement).append('>');
                    i++;
                    continue;
                }
            }
            result.append(c);
        }

        return result.toString();
    }
}