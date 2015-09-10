package com.sinapze.helloworld.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public final class ModBlocks {

	public static Block blockTest;
	
	public static final void init()
	{
		GameRegistry.registerBlock(blockTest = new BasicBlock("blockTest", Material.iron), "blockTest");
	}
	
}
