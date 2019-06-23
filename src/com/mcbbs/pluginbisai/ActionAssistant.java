package com.mcbbs.pluginbisai;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import static com.mcbbs.pluginbisai.Main.*;

public class ActionAssistant implements Listener {
	
	@EventHandler
	public void onBucket1(PlayerBucketFillEvent e){
		e.getPlayer().sendMessage(getRuntime().getConfig().getString("BucketFull"));
		
	}
	@EventHandler
	public void onBucket2(PlayerBucketEmptyEvent e1){
		e1.getPlayer().sendMessage(getRuntime().getConfig().getString("BucketFinish"));
		
	}
	@EventHandler
	public void onItem(PlayerItemBreakEvent e2){
		e2.getPlayer().sendMessage(getRuntime().getConfig().getString("ItemBreak"));
		
	}
	@EventHandler
	public void onLevel(PlayerLevelChangeEvent e3){
		e3.getPlayer().sendMessage(getRuntime().getConfig().getString("LevelChange") + " ¡ìc" + e3.getNewLevel() + "¼¶");
		
	}
	@EventHandler
	public void onfish(PlayerFishEvent e4){
		e4.getPlayer().sendMessage(getRuntime().getConfig().getString("Fish"));
		
	}
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e5){
		e5.getPlayer().sendMessage(getRuntime().getConfig().getString("Respawn"));
		
	}
	@EventHandler
	public void onEnchant(EnchantItemEvent e6){
		e6.getEnchanter().sendMessage(getRuntime().getConfig().getString("Enchant"));
		
	}
	@EventHandler
	public void onRonglu(FurnaceExtractEvent e7){
		e7.getPlayer().sendMessage(getRuntime().getConfig().getString("Ronglu"));
		
	}
	@EventHandler
	public void onSignChange(SignChangeEvent e10){
		e10.getPlayer().sendMessage(getRuntime().getConfig().getString("SignChange"));
	}
	
}
