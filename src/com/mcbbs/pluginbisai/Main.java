package com.mcbbs.pluginbisai;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.mcbbs.pluginbisai.ActionHints;
	
	public class Main extends JavaPlugin{

		private static JavaPlugin plugin;
		public void onEnable() {
			plugin = this;
			saveDefaultConfig();
			getServer().getConsoleSender().sendMessage("[ActionHints] ������ʾ����Ѿ����أ������ע����Ŷ!");
			Bukkit.getPluginManager().registerEvents(new ActionHints(), this);
			reloadConfig();
		}
		
		public static JavaPlugin getRuntime(){
	        if(plugin!=null){
	            return plugin;
	        }else {
	            throw new IllegalStateException();
	        }
	    }
		
		public void onDisable() {
			
			getServer().getConsoleSender().sendMessage("[ActionHints] ������ʾ����Ѿ��رգ������ע����Ŷ!");
		}
	}
