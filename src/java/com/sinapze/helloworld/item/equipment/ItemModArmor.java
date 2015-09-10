package com.sinapze.helloworld.item.equipment;

import java.util.Collection;
import java.util.UUID;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.sinapze.helloworld.Main;
import com.sinapze.helloworld.item.ModItems;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;

@SuppressWarnings("unused")
public class ItemModArmor extends ItemArmor{

	public String textureName;
	
	public ItemModArmor(String unlocalizedName, ArmorMaterial material, String textureName, int type) 
	{
		super(material, 0, type);
		this.textureName = textureName;
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Main.MODID + ":/armor/" + unlocalizedName);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return Main.MODID + ":textures/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}
	
	//allows the armor to be repairable. tests if the item trying to be used is equal to ModItems.ingotTest
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material)
	{
		return material.getItem() == ModItems.ingotTest;
	}
	
	public float knockbackResist = 0.0f;
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		player.getEntityData();
		PotionEffect speedEffect = new PotionEffect(Potion.moveSpeed.id, 1, 0, true);
		if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(ModItems.testBoots) && player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(ModItems.testLeggings) && player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(ModItems.testChestplate) && player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(ModItems.testHelmet))
		{
			knockbackResist = 0.25f;
			itemStack.stackTagCompound = new NBTTagCompound();
			itemStack.stackTagCompound.setBoolean("Full Set", true);
		}
		else
		{
			knockbackResist = 0.0f;
			itemStack.stackTagCompound = new NBTTagCompound();
			itemStack.stackTagCompound.setBoolean("Full Set", false);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Multimap getAttributeModifiers(ItemStack stack)
	{
		Multimap<String, AttributeModifier> map = HashMultimap.create();
		map.put(SharedMonsterAttributes.maxHealth.getAttributeUnlocalizedName(), new AttributeModifier(new UUID(895132 /*Random number */, armorType), "Health Modifier" + armorType, 5.0f, 0));
		map.put(SharedMonsterAttributes.knockbackResistance.getAttributeUnlocalizedName(), new AttributeModifier(new UUID(654654 /*Random number */, armorType), "Knockback resistance" + armorType, knockbackResist, 0));
		map.put(SharedMonsterAttributes.movementSpeed.getAttributeUnlocalizedName(), new AttributeModifier(new UUID(375352 /*Random number */, armorType), "Speed Modifier" + armorType, 0.05f, 1));
		return map;
	}
		
	/*@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage,
			int slot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		// TODO Auto-generated method stub
		
	}*/
}
