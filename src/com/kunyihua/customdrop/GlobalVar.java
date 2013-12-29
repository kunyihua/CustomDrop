package com.kunyihua.customdrop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.LinkedList;

import org.bukkit.Server;

//import com.herocraftonline.heroes.Heroes;
import com.kunyihua.customdrop.config.LoadConfig;
//import com.kunyihua.genie.crafte.scoreboard.Scoreboard;
import com.kunyihua.customdrop.craftclass.CustomItem;

public class GlobalVar
{
	// 主插件
	public static Main main;
	
	// 設定檔
	public static LoadConfig loadConfig;
	
	// 伺服器
	public static Server server;
	
	// 插件標題
	public static String detailStr = "[CustomDrop]";
	
	// 插件目錄
	public static String pluginMainDir = "./plugins/CustomDrop/";

	// 掉落物品清單
	public static Map<String, List<CustomItem>> CustomItemMap = new HashMap<String, List<CustomItem>>();

	// 顯示訊息
	public static void Print(String msg)
	{
		System.out.print(detailStr + msg);
	}
	
	// 取得生物名稱(中文)
	public static String GetEntityName(String entityId)
	{
		if (entityId.equals("CREEPER")) { return "苦力怕"; }
		else if (entityId.equals("SKELETON")) { return "骷髏"; }
		else if (entityId.equals("SPIDER")) { return "蜘蛛"; }
		else if (entityId.equals("GIANT")) { return "巨人"; }
		else if (entityId.equals("ZOMBIE")) { return "殭屍"; }
		else if (entityId.equals("SLIME")) { return "史萊姆"; }
		else if (entityId.equals("GHAST")) { return "幽靈水母"; }
		else if (entityId.equals("PIGZOMBIE")) { return "殭屍豬人"; }
		else if (entityId.equals("ENDERMAN")) { return "終界使者"; }
		else if (entityId.equals("CAVESPIDER")) { return "洞穴蜘蛛"; }
		else if (entityId.equals("SILVERFISH")) { return "石頭蟲"; }
		else if (entityId.equals("BLAZE")) { return "烈焰使者"; }
		else if (entityId.equals("LAVASLIME")) { return "烈焰史萊姆"; }
		else if (entityId.equals("ENDERDRAGON")) { return "終界龍"; }
		else if (entityId.equals("WITHERBOSS")) { return "凋零怪"; }
		else if (entityId.equals("WITCH")) { return "巫婆"; }
		else if (entityId.equals("BAT")) { return "蝙蝠"; }
		else if (entityId.equals("PIG")) { return "豬"; }
		else if (entityId.equals("SHEEP")) { return "羊"; }
		else if (entityId.equals("COW")) { return "牛"; }
		else if (entityId.equals("CHICKEN")) { return "雞"; }
		else if (entityId.equals("SQUID")) { return "章魚"; }
		else if (entityId.equals("WOLF")) { return "狼"; }
		else if (entityId.equals("MUSHROOMCOW")) { return "蘑菇牛"; }
		else if (entityId.equals("SNOWMAN")) { return "雪人"; }
		else if (entityId.equals("OZELOT")) { return "貓"; }
		else if (entityId.equals("VILLAGERGOLEM")) { return "鐵人"; }
		else if (entityId.equals("ENTITYHORSE")) { return "馬"; }
		else if (entityId.equals("VILLAGER")) { return "村民"; }
		return entityId;
	}
}