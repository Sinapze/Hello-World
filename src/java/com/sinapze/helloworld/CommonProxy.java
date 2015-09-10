package com.sinapze.helloworld;

import com.sinapze.helloworld.block.BlockRecipes;
import com.sinapze.helloworld.block.ModBlocks;
import com.sinapze.helloworld.item.ModItems;
import com.sinapze.helloworld.item.equipment.ItemRecipes;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) 
    {
    	System.out.println("Proxy pre-Initialization Start");
    	ModItems.init();
    	ModBlocks.init();
    }

    public void init(FMLInitializationEvent event) 
    {
    	System.out.println("Proxy Initialization Start");
    	BlockRecipes.registerBlockRecipes();
    	ItemRecipes.registerItemRecipes();
    }

    public void postInit(FMLPostInitializationEvent event) 
    {
    	System.out.println("Proxy post-Initialization Start");
    }
}