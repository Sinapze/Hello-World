package com.sinapze.helloworld.item.equipment;

import java.util.List;
import java.util.UUID;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.sinapze.helloworld.Main;
import com.sinapze.helloworld.item.ModItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

@SuppressWarnings("unused")
public class ItemModSword extends ItemSword{

	public float baseDamage;
	public static UUID DAMAGE = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
	
	public ItemModSword(String unlocalizedName, ToolMaterial material) 
	{
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Main.MODID + ":" + unlocalizedName);
		baseDamage = 4.0f + material.getDamageVsEntity();
	}
	
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material)
	{
		return material.getItem() == ModItems.ingotTest;
	}

	public void onCreated(ItemStack itemStack, World world, EntityPlayer player)
	{
		itemStack.stackTagCompound = new NBTTagCompound();
		itemStack.stackTagCompound.setString("owner", player.getDisplayName());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	{
		if (itemStack.stackTagCompound != null)
		{
			boolean fullSet = player.getCurrentArmor(0).stackTagCompound.getBoolean("Full Set");
			String owner = itemStack.stackTagCompound.getString("owner");
			if (owner.equals(player.getDisplayName()) && fullSet)
			{
				list.add(EnumChatFormatting.GREEN + "owner: " + owner);
				list.add(EnumChatFormatting.GREEN + "Effective!");
			}
			else if (owner.equals(player.getDisplayName()))
			{
				list.add(EnumChatFormatting.GREEN + "owner: " + owner);
				list.add(EnumChatFormatting.RED + "Innefective! Put the armor on!");
			}
			else
			{
				list.add(EnumChatFormatting.RED + "owner: " + owner);
				list.add(EnumChatFormatting.RED + "Innefective!");
			}
		}	
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Multimap getAttributeModifiers(ItemStack stack)
	{
		
		if (stack.stackTagCompound != null)
		{
			if (stack.stackTagCompound.getString("owner").equals("Sinapze") && stack.stackTagCompound.getBoolean("Full Set"))
			{
				
				Multimap<String, AttributeModifier> map = HashMultimap.create();
				map.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(DAMAGE, "Damage Modifier", +15.0f, 0));
				return map;
			}
			else if (stack.stackTagCompound.getString("owner").equals("Sinapze"))
			{
				Multimap<String, AttributeModifier> map = HashMultimap.create();
				map.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(DAMAGE, "Damage Modifier", +5.0f, 0));
				return map;
			}
			else
			{
				Multimap<String, AttributeModifier> map = HashMultimap.create();
				map.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(DAMAGE, "Damage Modifier", -5.0f, 0));
				return map;
			}
		}
		Multimap<String, AttributeModifier> map = HashMultimap.create();
		return map;
		//map.put(SharedMonsterAttributes.maxHealth.getAttributeUnlocalizedName(), new AttributeModifier(new UUID(895132 /*Random number */, getDamage(stack)), "Health Modifier", 5.0f, 0));
		//map.put(SharedMonsterAttributes.knockbackResistance.getAttributeUnlocalizedName(), new AttributeModifier(new UUID(654654 /*Random number */, getDamage(stack)), "Knockback resistance" , .5, 0));
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int number, boolean flag)
	{
	
	}
	
	private static NBTTagCompound writeAttributeModifierToNBT(IAttribute attribute, AttributeModifier modifier) {
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		nbttagcompound.setString("AttributeName", attribute.getAttributeUnlocalizedName());
		nbttagcompound.setString("Name", modifier.getName());
		nbttagcompound.setDouble("Amount", modifier.getAmount());
		nbttagcompound.setInteger("Operation", modifier.getOperation());
		nbttagcompound.setLong("UUIDMost", modifier.getID().getMostSignificantBits());
		nbttagcompound.setLong("UUIDLeast", modifier.getID().getLeastSignificantBits());
		return nbttagcompound;
	}
}
