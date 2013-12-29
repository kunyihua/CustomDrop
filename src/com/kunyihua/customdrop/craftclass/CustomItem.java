package com.kunyihua.customdrop.craftclass;

import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class CustomItem
{
	//物品名稱
	public String ItemName;
	//物品名稱
	public int UseOriginalName;
	// 物品說明
	public List<String> ItemLores;
	// 物品ID(原始ID)
	public int ItemID;
	// 顏色
	public byte Red;
	public byte Green;
	public byte Blue;
	// 物品附屬ID(原始ID)
	public byte ItemSubID;
	// 物品附魔
	public List<String> Enchants;
	// 得到的物品數量
	public int Quantity;
	// 掉落率
	public double Chance;
	// 限定地圖
	public String OnlyWorld;
	
	public CustomItem(String newItemName,
					   int newUseOriginalName,
					   List<String> newItemLores,
					   int newItemID,
					   byte newRed,
					   byte newGreen,
					   byte newBlue,
					   byte newItemSubID,
					   List<String> newEnchants,
					   int newQuantity,
					   double newChance,
					   String newOnlyWorld)
	{	    
		// 設定資料
		this.ItemName = newItemName;
		this.UseOriginalName = newUseOriginalName;
		this.ItemLores = newItemLores;
		this.ItemID = newItemID;
		this.Red = newRed;
		this.Green = newGreen;
		this.Blue = newBlue;
		this.ItemSubID = newItemSubID;
		this.Enchants = newEnchants;
		this.Quantity = newQuantity;
		this.Chance = newChance;
		this.OnlyWorld = newOnlyWorld;
	}
	
	@SuppressWarnings("deprecation")
	public ItemStack getResultItem()
	{
	    // 產生物品用
		ItemStack ResultItem;
	    ItemMeta newItemMeta;
	    LeatherArmorMeta LeatherArmorMeta;
		
		// 合成後得到的物品設定
		if (this.ItemSubID != 0)
		{ ResultItem = new ItemStack(Material.getMaterial(this.ItemID), 1, this.ItemSubID); }
		else
		{ ResultItem = new ItemStack(Material.getMaterial(this.ItemID)); }
		// 判斷是否要設定顏色
		if (this.ItemID == 298 || this.ItemID == 299|| this.ItemID == 300 || this.ItemID == 301)
		{
			LeatherArmorMeta = (LeatherArmorMeta)ResultItem.getItemMeta();
			LeatherArmorMeta.setColor(Color.fromRGB(this.Red, this.Green, this.Blue));
			ResultItem.setItemMeta(LeatherArmorMeta);
		}
		newItemMeta = ResultItem.getItemMeta();
		// 附魔
		for (int i = 0; i < this.Enchants.size(); i++)
		{
			String[] EnchantsParts = this.Enchants.get(i).split(":");
			int level = Integer.parseInt(EnchantsParts[1]);
			Enchantment enchantment = Enchantment.getByName(EnchantsParts[0]);
			newItemMeta.addEnchant(enchantment, level, true);
		}
		// 名稱
		if (this.UseOriginalName == 0)
		{
			newItemMeta.setDisplayName(this.ItemName);
		}
		// 說明
		if (this.ItemLores.size() > 0)
		{
			newItemMeta.setLore(this.ItemLores);
		}
		// 寫入資料
		ResultItem.setItemMeta(newItemMeta);
    	// 設定數量
		ResultItem.setAmount(this.Quantity);
	    // 設定耐久為最高
		ResultItem.setDurability((short)0);
		// 回傳
		return ResultItem;
	}
}