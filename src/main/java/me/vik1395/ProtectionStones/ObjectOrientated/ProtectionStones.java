/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vik1395.ProtectionStones.ObjectOrientated;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.vik1395.ProtectionStones.ObjectOrientated.PSCommands;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import java.util.ArrayList;
import java.util.List;

/*

Authors: Dragoboss
Project: ProtectionStones

Copyright 2015

Licensed under Creative CommonsAttribution-ShareAlike 4.0 International Public License (the "License");
You may not use this file except in compliance with the License.

You may obtain a copy of the License at http://creativecommons.org/licenses/by-sa/4.0/legalcode

You may find an abridged version of the License at http://creativecommons.org/licenses/by-sa/4.0/
 */
public class ProtectionStones extends JavaPlugin {
    PSMessager msgr = new PSMessager();
    PSCommands cmds = new PSCommands();
    public static Plugin wgd;
    List<String> PSAliases = new ArrayList<>();
    List<String> PRAliases = new ArrayList<>();
    
    public ProtectionStones instance() {
        return this;
    }
    
    @Override
    public void onEnable() {
        this.getCommand("protectionstones").setExecutor(cmds);
        this.getCommand("protectionregion").setExecutor(cmds);
        
        if(getServer().getPluginManager().getPlugin("WorldGuard").isEnabled() && getServer().getPluginManager().getPlugin("WorldGuard").isEnabled()) {
            wgd = getServer().getPluginManager().getPlugin("WorldGuard");
        } else {
            getLogger().info("WorldGuard is not enabled! Disabling ProtectionStones...");
            getServer().getPluginManager().disablePlugin(this);
        }
    }
    
    @Override
    public void onDisable() {
    }

    public static Object getFlagValue(Flag<?> flag, Object value) {
        if (value == null) return null;

        String valueString = value.toString().trim();

        if ((flag instanceof StateFlag)) {
            if (valueString.equalsIgnoreCase("allow")) return StateFlag.State.ALLOW;
            if (valueString.equalsIgnoreCase("deny")) return StateFlag.State.DENY;
            return null;
        }
        return null;
    }
}