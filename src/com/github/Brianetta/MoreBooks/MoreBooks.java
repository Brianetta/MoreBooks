package com.github.Brianetta.MoreBooks;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


/**
 * Copyright © Brian Ronald
 * 31/08/13
 */
public class MoreBooks extends JavaPlugin {

    @Override
    public void onEnable ()
    {
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
                    stackinhand.setAmount(64);
                    sender.sendMessage("Your book has been duplicated.");
                }
            } else {
                // Console can't have an item in hand.
                sender.sendMessage("Player command only, sorry");
                return false;
            }
            return true;
        }
        return false;
    }
}
