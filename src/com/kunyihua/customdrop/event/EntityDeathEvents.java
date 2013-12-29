package com.kunyihua.customdrop.event;

import java.lang.Math;
import java.util.List;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import com.kunyihua.customdrop.GlobalVar;
import com.kunyihua.customdrop.craftclass.CustomItem;

public class EntityDeathEvents implements Listener
{
    public EntityDeathEvents()
    {
    	
	}
    
	@SuppressWarnings("deprecation")
	@EventHandler
    public void onEntityDeathEvents(EntityDeathEvent event)
    {
    	// 取得死掉的生物實體
    	LivingEntity entityDeth = event.getEntity();
    	// 判斷是否為玩家殺死的
    	if (entityDeth.getKiller() != null &&
    		entityDeth.getKiller() instanceof Player)
    	{
    		Player killBy = entityDeth.getKiller();
    		String sEntitlyName = "";
    		sEntitlyName = entityDeth.getType().getName().toUpperCase();
    		// 判斷是否有掉落物清單
    		if (GlobalVar.CustomItemMap.containsKey(sEntitlyName))
    		{
    			// 取得掉落物清單
    			List<CustomItem> dropItems = GlobalVar.CustomItemMap.get(sEntitlyName);
    			CustomItem customItem;
    			// 迴圈判斷是否掉落物品
    			for (int i = 0; i < dropItems.size(); i++)
    			{
    				customItem = dropItems.get(i);
    				// 判斷世界是否正確
    				if (customItem.OnlyWorld.equals("") || customItem.OnlyWorld.toUpperCase().equals(entityDeth.getWorld().getName().toUpperCase()))
    				{
    					// 取得基數(從1~10000中抽一個號碼)
        				int iChance = (int)(Math.random() * 10000 + 1);
        				// 判斷物品掉落機率(乘以100後)是否小於基數
        				if (iChance <= (customItem.Chance * 100))
        				{
        					// 判定掉落
        					entityDeth.getWorld().dropItemNaturally(entityDeth.getLocation(), customItem.getResultItem());
        					// 顯示掉落訊息
        					killBy.sendMessage(GlobalVar.GetEntityName(sEntitlyName) + "§6掉落了§f" + customItem.ItemName);
        				}
    				}
    			}
    		}
    	}
    }
}