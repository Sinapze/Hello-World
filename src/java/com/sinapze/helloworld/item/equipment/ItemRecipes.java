package com.sinapze.helloworld.item.equipment;

import com.sinapze.helloworld.item.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ItemRecipes {
	
		//We can continue with registerFurnaceRecipes, registerPulverizerRecipes, etc.
	
		//Adds shaped crafting recipes
		private static void registerShapedRecipes()
		{
			GameRegistry.addRecipe(new ItemStack(ModItems.testSword), new Object[] {" Y ", " X ", " X ", 'X', ModItems.ingotTest, 'Y', Items.stick});
		}
		
		//Adds shapeless crafting recipes
		private static void registerShapelessRecipes()
		{
			
		}
		
		//Called by CommonProxy, calls the respective registries that need to be called
		public static void registerItemRecipes()
		{
			registerShapedRecipes();
			registerShapelessRecipes();
		}
}
