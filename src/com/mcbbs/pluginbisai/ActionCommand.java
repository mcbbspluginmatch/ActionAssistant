package com.mcbbs.pluginbisai;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;

import static com.mcbbs.pluginbisai.Main.*;

public class ActionCommand implements CommandExecutor {

	@SuppressWarnings({ "deprecation", })
	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		
		if (command.getName().equalsIgnoreCase("Action")) {
			 
			 if (!(sender instanceof Player)) {
				 sender.sendMessage("[动作助手] §b您必须是一名玩家!");
				 return true;
				 
			 }
			 
			 Player player = (Player) sender;
			 Damageable d = (Damageable) player;
			 
			 if (args.length == 0) {
				 sender.sendMessage("§6=====§7 [§9ActionAssistant§7] §6=====");
				 sender.sendMessage("§b/Action blood  §e 修改你的血量为满值    ");
				 sender.sendMessage("§b/Action bloodPlayer [玩家名]  §e让该玩家的血量为满值    ");
				 sender.sendMessage("§b/Action WalkSpeed [速度值]  §e修改您的行走速度，速度值范围: -1 到 1    ");
				 sender.sendMessage("§b/Action FlySpeed [速度值]  §e修改您的飞行速度，速度值范围: -1 到 1    ");
				 sender.sendMessage("§6=====§7 [§9ActionAssistant§7] §6=====");
				 
				 return true;
			 }
			 
			 if (args[0].equalsIgnoreCase("blood")) {
				 
				 if (!(d.hasPermission("Action.blood"))) {
					 d.sendMessage(getRuntime().getConfig().getString("Command.Permission"));
					 return true;
				 }
				 
				 if (d.hasPermission("Action.blood")) {
					 if (args.length != 1) {
						 player.sendMessage("§a[动作助手] §c您输入的命令不正确！正确用法：§b/Action blood  §e修改你的血量为满值");
						 
						 return true;
					 }
					 
				     d.setHealth(d.getMaxHealth());
				     player.sendMessage(getRuntime().getConfig().getString("Command.Bloodself"));
				     return true;
				 } 
			 }
			 
			 if (args[0].equalsIgnoreCase("bloodPlayer")) {
				 
				 if (!(d.hasPermission("Action.bloodPlayer"))) {
					 d.sendMessage(getRuntime().getConfig().getString("Command.Permission"));
					 return true;
				 }
				 
				 if (d.hasPermission("Action.blood")) {
				    if (args.length != 2) {
					 player.sendMessage("§a[动作助手] §c您输入的命令不正确！正确用法：§b/Action bloodPlayer [玩家名]  §e修改该玩家的血量为满值 ");
					 
					 return true;
				 }
				 
				 Damageable target = Bukkit.getPlayer(args[1]);
				 if (target == null ) {
					 player.sendMessage(getRuntime().getConfig().getString("Command.PlayerNotOnline"));
					 return true;
				 }
				 target.setHealth(target.getMaxHealth());
				 player.sendMessage("§a玩家§e" + args[1] + "§a已经回复好血量！");
				 ((CommandSender) target).sendMessage(getRuntime().getConfig().getString("Command.BloodFinish"));
				 return true;
			   }
			 }
			 
              if (args[0].equalsIgnoreCase("WalkSpeed")) {
				 
				 if (!(d.hasPermission("Action.WalkSpeed"))) {
					 d.sendMessage(getRuntime().getConfig().getString("Command.Permission"));
					 return true;
				 }
              
                 if (d.hasPermission("Action.WalkSpeed")) {
            	   if (args.length != 2) {
 					 player.sendMessage("§a[动作助手] §c您输入的命令不正确！正确用法：§b/Action WalkSpeed [速度值]  §e修改您的行走速度 ");
 					 
 					 return true;
 				    }          
					
            	   float Walkspeed = player.getWalkSpeed();
                   try {
                           Walkspeed = Float.parseFloat(args[1]);
                   }
                   catch (NumberFormatException exception) {
                           player.sendMessage(getRuntime().getConfig().getString("Command.WalkSpeed"));
                           return true;
                   }
                   player.setWalkSpeed(Walkspeed);
                   player.sendMessage(getRuntime().getConfig().getString("Command.WalkMessage"));
                   return true;
            	   
				}
                 
             }
              
              if (args[0].equalsIgnoreCase("FlySpeed")) {
 				 
 				 if (!(d.hasPermission("Action.FlySpeed"))) {
 					 d.sendMessage(getRuntime().getConfig().getString("Command.Permission"));
 					 return true;
 				 }
               
                  if (d.hasPermission("Action.FlySpeed")) {
             	   if (args.length != 2) {
  					 player.sendMessage("§a[动作助手] §c您输入的命令不正确！正确用法：§b/Action FlySpeed [速度值]  §e修改您的飞行速度 ");
  					 
  					 return true;
  				    }          
 					
             	  float flyspeed = player.getFlySpeed();
                  try {
                          flyspeed = Float.parseFloat(args[1]);
                  }
                  catch(NumberFormatException exception) {
                          player.sendMessage(getRuntime().getConfig().getString("Command.FlySpeed"));
                          return true;
                  }
                  player.setFlySpeed(flyspeed);
                  player.sendMessage(getRuntime().getConfig().getString("Command.FlyMessage"));
                  return true;
             	   
 				}
                  
              }
               
              
            }
		return false;
   }
}
