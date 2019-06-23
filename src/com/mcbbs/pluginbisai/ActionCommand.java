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
				 sender.sendMessage("[��������] ��b��������һ�����!");
				 return true;
				 
			 }
			 
			 Player player = (Player) sender;
			 Damageable d = (Damageable) player;
			 
			 if (args.length == 0) {
				 sender.sendMessage("��6=====��7 [��9ActionAssistant��7] ��6=====");
				 sender.sendMessage("��b/Action blood  ��e �޸����Ѫ��Ϊ��ֵ    ");
				 sender.sendMessage("��b/Action bloodPlayer [�����]  ��e�ø���ҵ�Ѫ��Ϊ��ֵ    ");
				 sender.sendMessage("��b/Action WalkSpeed [�ٶ�ֵ]  ��e�޸����������ٶȣ��ٶ�ֵ��Χ: -1 �� 1    ");
				 sender.sendMessage("��b/Action FlySpeed [�ٶ�ֵ]  ��e�޸����ķ����ٶȣ��ٶ�ֵ��Χ: -1 �� 1    ");
				 sender.sendMessage("��6=====��7 [��9ActionAssistant��7] ��6=====");
				 
				 return true;
			 }
			 
			 if (args[0].equalsIgnoreCase("blood")) {
				 
				 if (!(d.hasPermission("Action.blood"))) {
					 d.sendMessage(getRuntime().getConfig().getString("Command.Permission"));
					 return true;
				 }
				 
				 if (d.hasPermission("Action.blood")) {
					 if (args.length != 1) {
						 player.sendMessage("��a[��������] ��c������������ȷ����ȷ�÷�����b/Action blood  ��e�޸����Ѫ��Ϊ��ֵ");
						 
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
					 player.sendMessage("��a[��������] ��c������������ȷ����ȷ�÷�����b/Action bloodPlayer [�����]  ��e�޸ĸ���ҵ�Ѫ��Ϊ��ֵ ");
					 
					 return true;
				 }
				 
				 Damageable target = Bukkit.getPlayer(args[1]);
				 if (target == null ) {
					 player.sendMessage(getRuntime().getConfig().getString("Command.PlayerNotOnline"));
					 return true;
				 }
				 target.setHealth(target.getMaxHealth());
				 player.sendMessage("��a��ҡ�e" + args[1] + "��a�Ѿ��ظ���Ѫ����");
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
 					 player.sendMessage("��a[��������] ��c������������ȷ����ȷ�÷�����b/Action WalkSpeed [�ٶ�ֵ]  ��e�޸����������ٶ� ");
 					 
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
  					 player.sendMessage("��a[��������] ��c������������ȷ����ȷ�÷�����b/Action FlySpeed [�ٶ�ֵ]  ��e�޸����ķ����ٶ� ");
  					 
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
