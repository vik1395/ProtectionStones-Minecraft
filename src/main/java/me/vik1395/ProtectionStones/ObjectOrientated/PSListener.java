/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.vik1395.ProtectionStones.ObjectOrientated;

import java.util.List;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;

/**
 *
 * @author Mirco Swaders
 */
public class PSListener {
    ProtectionStones instance = new ProtectionStones().instance();
    PSRegionSettings rgs = new PSRegionSettings();
    
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        
        Block b = e.getBlock();
        Material m = b.getType();
        Class<? extends MaterialData> d = m.getData();
        List<MetadataValue> meta = b.getMetadata("PS");
        if (instance.useMeta) {
            if (meta.isEmpty() || meta.get(0).asBoolean() == false) {
                e.setCancelled(false);
            }
        } else if (!instance.blocks.contains(m)) {
            e.setCancelled(false);
        } else if (!rgs.getTypes(m).contains(d)) {
            e.setCancelled(false);
        }
        
        
    }
}
