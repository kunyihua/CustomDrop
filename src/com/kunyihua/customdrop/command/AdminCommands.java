package com.kunyihua.customdrop.command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kunyihua.customdrop.craftclass.CustomItem;
import com.kunyihua.customdrop.GlobalVar;

public class AdminCommands implements CommandExecutor
{    
    public AdminCommands()
    {
    	
	}
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		// 判斷是否為玩家的指令
		if (sender instanceof Player)
		{
			// 判斷指令長度
			if (args.length == 0)
			{
				// 顯示說明
				sender.sendMessage("§9==========§dCustomDrop§9==========");
				sender.sendMessage("§a/cdrop reload §f- §e重讀設定檔");
				sender.sendMessage("§a/cdrop list §f- §e列出所有生物的掉落資訊");
				return true;
			}
			else
			{
				if (args[0].equals("reload"))
				{
					// 清除合成表
					GlobalVar.server.resetRecipes();
					// 清除對照表
					GlobalVar.CustomItemMap.clear();
					// 重讀
					GlobalVar.loadConfig.ReloadConfig();
					sender.sendMessage(ChatColor.YELLOW +"設定檔讀取完成");
					return true;
				}
				else if (args[0].equals("list"))
				{
					// 迴圈顯示
					List<CustomItem> lstCustomItem = new ArrayList<CustomItem>();
					sender.sendMessage("§9==================================");
					for (String key : GlobalVar.CustomItemMap.keySet())
					{
						sender.sendMessage("§a「" + GlobalVar.GetEntityName(key) + "」");
						lstCustomItem = GlobalVar.CustomItemMap.get(key);
						for (CustomItem customItem : lstCustomItem)
						{
							if (customItem.OnlyWorld.equals(""))
							{
								sender.sendMessage("§a" + customItem.ItemName + "§a(§f" + customItem.Chance + "%§a掉落§f" + customItem.Quantity + "§a個)");
							}
							else
							{
								sender.sendMessage("§a" + customItem.ItemName + "§a(§f" + customItem.Chance + "%§a掉落§f" + customItem.Quantity + "§a個) - 限定在§f" + customItem.OnlyWorld);
							}
						}
			        }
					sender.sendMessage("§9==================================");
					return true;
				}
			}
	    }
		else
		{
	    	sender.sendMessage("此指令不支援控制台模式!");
	    	return false;
	    }
		return false;
	}
}