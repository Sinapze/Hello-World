package com.sinapze.helloworld.item.equipment;

import com.sinapze.helloworld.Main;
import com.sinapze.helloworld.item.ModItems;

import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemModHoe extends ItemHoe{

	public ItemModHoe(String unlocalizedName, ToolMaterial material) 
	{
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Main.MODID + ":" + unlocalizedName);
	}

	public boolean getIsRepairable(ItemStack toRepair, ItemStack material)
	{
		return material.getItem() == ModItems.ingotTest;
	}
}