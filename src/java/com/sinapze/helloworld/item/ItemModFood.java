package com.sinapze.helloworld.item;

import com.sinapze.helloworld.Main;

import net.minecraft.item.ItemFood;

public class ItemModFood extends ItemFood{

	public ItemModFood(String unlocalizedName, int healAmount, float saturationModifier, boolean wolvesFavorite, boolean eatWhenFull)
	{
		super(healAmount, saturationModifier, wolvesFavorite);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Main.MODID + ":" + unlocalizedName);
		if (eatWhenFull)
			this.setAlwaysEdible();
	}
	
}
