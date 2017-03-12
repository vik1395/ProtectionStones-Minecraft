/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vik1395.ProtectionStones.ObjectOrientated;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.vik1395.ProtectionStones.ObjectOrientated.Perms.*;

/**
 *
 * @author Mirco Swaders
 */
public class PSCommands implements CommandExecutor {
    PSMessager msgr = new PSMessager();
    PSPerm perms = new PSPerm();
   
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (s instanceof Player) {
            Player p = (Player) s;
            if (cmd.getName().equals("protectionstones")) {
                if (args.length < 1) {
                    //displayHelp();
                } else {
                    String arg1 = null, arg2 = null, arg3 = null, arg4 = null;
                    if (args[1] != null) { arg1 = args[1]; }
                    if (args[2] != null) { arg2 = args[2]; }
                    if (args[3] != null) { arg3 = args[3]; }
                    if (args[4] != null) { arg4 = args[4]; }
                    if (args[0].equalsIgnoreCase("buy")) {
                        if (!(perms.has(p, Perms.BUY))) {
                            msgr.send(p, "NoAccess", false, null, "buy", null);
                        }
                        if (arg1 != null) {
                            Material type = null;
                            if (arg2 != null) {
                                type = Material.valueOf(arg2);
                            } else {
                                /*displayTypes();*/
                                return false;
                            }
                            int amount = 1;
                            if (arg3 != null) {
                                amount = Integer.valueOf(arg3);
                                if (!(amount == (int)amount)) {
                                    /*displayTypes();*/
                                    return false;
                                }
                            }
                            p.getPlayer().getInventory().addItem(new ItemStack(type, amount));
                            msgr.send(p, "PlayerBought", false, null, null, null);
                        } else { /*displayTypes();*/ }
                    }
                    if (args[0].equalsIgnoreCase("buy")) {}
                    if (args[0].equalsIgnoreCase("buy")) {}
                    if (args[0].equalsIgnoreCase("buy")) {}
                    if (args[0].equalsIgnoreCase("buy")) {}
                    if (args[0].equalsIgnoreCase("buy")) {}
                    if (args[0].equalsIgnoreCase("buy")) {}
                    if (args[0].equalsIgnoreCase("buy")) {}
                }
            } else if (cmd.getName().equals("protectionregion")) {
                //Command Handler for PS Region commands
            }
        } else {
            msgr.send(s, "NoConsole", false, null, null, null);
        }
        return true;
    }
    
}
