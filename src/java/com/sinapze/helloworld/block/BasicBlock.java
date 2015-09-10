package com.sinapze.helloworld.block;

import com.sinapze.helloworld.Main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;

@SuppressWarnings("unused")
public class BasicBlock extends Block{

	protected BasicBlock(String unlocalizedName, Material material) 
	{
		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(15);
		this.setResistance(1000);
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(soundTypeMetal);
	}
	
	//Sets these blocks to be usable as beacon bases
	//public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) 
	//{
		//return true;
	//}
}
