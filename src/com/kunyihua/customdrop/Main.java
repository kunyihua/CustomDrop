package com.kunyihua.customdrop;

import org.bukkit.plugin.java.JavaPlugin;

import com.kunyihua.customdrop.command.AdminCommands;
//import com.kunyihua.crafte.scoreboard.Scoreboard;
import com.kunyihua.customdrop.config.LoadConfig;
import com.kunyihua.customdrop.event.EntityDeathEvents;

public class Main extends JavaPlugin
{
	// 載入
	public void onEnable()
	{
		// 註冊
		getServer().getPluginManager().registerEvents(new EntityDeathEvents(), this);
		getCommand("cdrop").setExecutor(new AdminCommands());
		// 設定主插件
		GlobalVar.main = this;
		// 設定伺服器
		GlobalVar.server = this.getServer();
		// 讀取設定檔
		GlobalVar.loadConfig = new LoadConfig();
		GlobalVar.loadConfig.ReloadConfig();
		// 訊息
		GlobalVar.Print("CustomDrop is enabled!");
	}
	
	// 載出
	public void onDisable()
	{
		// 清除合成表
		GlobalVar.server.resetRecipes();
		// 清除對照表
		GlobalVar.CustomItemMap.clear();
		// 訊息
		GlobalVar.Print("CustomDrop is disable!");
	}
}