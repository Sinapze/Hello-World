package com.sinapze.helloworld.block;

import com.sinapze.helloworld.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;


//Holds the block related recipes



public class BlockRecipes {

	//We can continue with registerFurnaceRecipes, registerPulverizerRecipes, etc.
	
	//Adds shaped crafting recipes
	private static void registerShapedRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockTest), new Object[] {"XXX", "XXX", "XXX", 'X', ModItems.ingotTest});
	}
	
	//Adds shapeless crafting recipes
	private static void registerShapelessRecipes()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ingotTest, 9), new Object[] {ModBlocks.blockTest});
	}
	
	//Called by CommonProxy, calls the respective registries that need to be called
	public static void registerBlockRecipes()
	{
		registerShapedRecipes();
		registerShapelessRecipes();
	}
}
