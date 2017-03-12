/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vik1395.ProtectionStones.ObjectOrientated;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.permissions.Permission;

/**
 *
 * @author Mirco Swaders
 */
public class PSPerm {
    public boolean has(Player p, Perms perm) {
        boolean has = false;
        
        if (p.hasPermission(perm.toString())) {
            has = true;
        }
        return has;
    }
    public int getLimit(Player p, Material block, String blockData) {
        int limit = -1;
        if (!(block == null)) {
            for(PermissionAttachmentInfo rawperm : p.getEffectivePermissions()) {
                String perms = rawperm.getPermission();
                String node = null;
                if (blockData != null) {
                    node = "protectionstones.limit." + block.name() + "-" + blockData;
                } else {
                    node = "protectionstones.limit." + block.name();
                }
                if(perms.startsWith(node)) {
                    try {
                        int allow = Integer.parseInt(perms.split("\\.")[3]);
                        if(allow>limit) {
                            if (!(has(p, Perms.ADMIN))) {
                                limit = allow;
                            } else {
                                limit = -1;
                            }
                        }
                    } catch (Exception er) {
                        limit = -1;
                    }
                }
            }
        } else {
            for(PermissionAttachmentInfo rawperm : p.getEffectivePermissions()) {
                String perms = rawperm.getPermission();
                if(perms.startsWith("protectionstones.limit")) {
                    try {
                        int allow = Integer.parseInt(perms.substring(23));
                        if(allow>limit) {
                            if (!(has(p, Perms.ADMIN))) {
                                limit = allow;
                            } else {
                                limit = -1;
                            }
                        }
                    } catch (Exception er) {
                        limit = -1;
                    }
                }
            }
        }
        return limit;
    }
}
