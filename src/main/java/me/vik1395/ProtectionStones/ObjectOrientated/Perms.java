/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vik1395.ProtectionStones.ObjectOrientated;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachmentInfo;

/*
File: Perms.java
Function: The Perms class contains enums of permission nodes and the functions
necessary for the rest of the plugin to check permissions of players.

Authors: Vik1395, Dragoboss
Project: ProtectionStones

Copyright 2015-2016

Licensed under Creative CommonsAttribution-ShareAlike 4.0 International Public License (the "License");
You may not use this file except in compliance with the License.

You may obtain a copy of the License at http://creativecommons.org/licenses/by-sa/4.0/legalcode

You may find an abridged version of the License at http://creativecommons.org/licenses/by-sa/4.0/
 */
public enum Perms {
    // ~~~~~~~~~~~~~~~~~~~~~~~~~ ENUMS ~~~~~~~~~~~~~~~~~~~~~~~~ //
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
        CREATE (new Permission("ProtectionStones.create")),
        DESTROY (new Permission("ProtectionStones.destroy")),
        VIEW (new Permission("ProtectionStones.view")),
        INFO (new Permission("ProtectionStones.info")),
        BUY (new Permission("ProtectionStones.buy")),
        HIDE (new Permission("ProtectionStones.hide")),
        UNHIDE (new Permission("ProtectionStones.unhide")),
        HOME (new Permission("ProtectionStones.home")),
        TP (new Permission("ProtectionStones.tp")),
        PRIORITY (new Permission("ProtectionStones.priority")),
        OWNERS (new Permission("ProtectionStones.owners")),
        MEMBERS (new Permission("ProtectionStones.members")),
        FLAGS (new Permission("ProtectionStones.flags")),
        TOGGLE (new Permission("ProtectionStones.toggle")),
        ADMIN (new Permission("ProtectionStones.admin"));
        private final Permission perm;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
    
    // Constructor
    private Perms(Permission perm) {
        this.perm = perm;
    }
    private Permission perm() { return perm; }
    
    public Permission getValue() {
        return this.perm;
    }
}