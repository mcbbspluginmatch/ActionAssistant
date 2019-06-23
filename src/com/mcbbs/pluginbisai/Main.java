package com.mcbbs.pluginbisai;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import com.mcbbs.pluginbisai.ActionCommand;
import com.mcbbs.pluginbisai.ActionAssistant;
	
	public class Main extends JavaPlugin{

		private static JavaPlugin plugin;
		public void onEnable() {
			plugin = this;
			saveDefaultConfig();
			getServer().getConsoleSender().sendMessage("[ActionAssistant] ������ʾ����Ѿ����أ������ע����Ŷ!");
			Bukkit.getPluginCommand("Action").setExecutor((CommandExecutor) new ActionCommand());
			Bukkit.getPluginManager().registerEvents(new ActionAssistant(), this);
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
			
			getServer().getConsoleSender().sendMessage("[ActionAssistant] ������ʾ����Ѿ��رգ������ע����Ŷ!");
		}
	}
