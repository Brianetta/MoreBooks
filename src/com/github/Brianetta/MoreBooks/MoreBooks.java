package com.github.Brianetta.MoreBooks;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;


/**
 * Copyright © Brian Ronald
 * 31/08/13
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

public class MoreBooks extends JavaPlugin {

    @Override
    public void onEnable ()
    {
        // No explicit startup code at this time
    }

    @Override
    public void onDisable ()
    {
        // Nothing to clean up yet
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (cmd.getName().equalsIgnoreCase("morebooks")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                ItemStack stackinhand = player.getItemInHand();
                if ((stackinhand == null) || (stackinhand.getType() != Material.WRITTEN_BOOK)) {
                    sender.sendMessage("You are not holding a signed book.");
                } else {
                    BookMeta bookinfo = (BookMeta)stackinhand.getItemMeta();
                    if (!(bookinfo.getAuthor().equals(player.getName()))) {
                        sender.sendMessage("You did not sign this book.");
                    } else {
                        stackinhand.setAmount(64);
                        sender.sendMessage("Your book has been duplicated.");
                    }
                }
            } else {
                // Console can't have an item in hand.
                sender.sendMessage("Player command only, sorry");
            }
            return true;
        }
        return false;
    }
}
