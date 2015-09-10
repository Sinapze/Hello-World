package com.sinapze.helloworld.item;

import com.sinapze.helloworld.Main;
import com.sinapze.helloworld.item.equipment.ItemModArmor;
import com.sinapze.helloworld.item.equipment.ItemModAxe;
import com.sinapze.helloworld.item.equipment.ItemModHoe;
import com.sinapze.helloworld.item.equipment.ItemModPick;
import com.sinapze.helloworld.item.equipment.ItemModShovel;
import com.sinapze.helloworld.item.equipment.ItemModSword;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {
	
	public static Item ingotTest;
	
	public static Item testSword;
	public static Item testAxe;
	public static Item testPick;
	public static Item testHoe;
	public static Item testShovel;
	
	public static Item testHelmet;
	public static Item testChestplate;
	public static Item testLeggings;
	public static Item testBoots;
	
	public static Item testFood;
	public static final void init()
	{
		ingotTest = new Item().setUnlocalizedName("ingotTest").setCreativeTab(CreativeTabs.tabMaterials).setTextureName(Main.MODID + ":ingotTest");
		GameRegistry.registerItem(ingotTest, "ingotTest");
		
		//creates sword and tools
		GameRegistry.registerItem(testSword = new ItemModSword("testSword", TEST), "testSword");
		GameRegistry.registerItem(testPick = new ItemModPick("testPick", TEST), "testPick");
		GameRegistry.registerItem(testAxe = new ItemModAxe("testAxe", TEST), "testAxe");
		GameRegistry.registerItem(testHoe = new ItemModHoe("testHoe", TEST), "testHoe");
		GameRegistry.registerItem(testShovel = new ItemModShovel("testShovel", TEST), "testShovel");
		
		//creates the armor out of material TEST_ARMOR. 0 is helmet, 1 is chest, 2 is leggings, 3 is boots
		GameRegistry.registerItem(testHelmet = new ItemModArmor("testHelmet", TEST_ARMOR, "test", 0), "testHelmet");
		GameRegistry.registerItem(testChestplate = new ItemModArmor("testChestplate", TEST_ARMOR, "test", 1), "testChestplate");
		GameRegistry.registerItem(testLeggings = new ItemModArmor("testLeggings", TEST_ARMOR, "test", 2), "testLeggings");
		GameRegistry.registerItem(testBoots = new ItemModArmor("testBoots", TEST_ARMOR, "test", 3), "testBoots");
		
		
		GameRegistry.registerItem(testFood = new ItemModFood("testFood", 10, 1.0f, true, true), "testFood");
	}
	
	//adds the tool material TEST, which has diamond (3) mining level, durability of 300, speed of 15 (diamond is 8), 4 damage (3 is diamond), and 30 enchantability (gold is 22)
	public static ToolMaterial TEST = EnumHelper.addToolMaterial("TEST", 3, 2999, 15F, 4F, 30);
	
	//adds the armor material TEST which has durability of 45 (diamond 33), has damage reduction of 22 (diamond 20) and enchantability of 30
	public static ArmorMaterial TEST_ARMOR = EnumHelper.addArmorMaterial("TEST_ARMOR", 45, new int[] {4, 8, 6, 4}, 30);

}
