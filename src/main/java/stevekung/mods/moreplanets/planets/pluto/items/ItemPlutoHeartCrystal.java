/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.pluto.items;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.items.ItemMorePlanets;

public class ItemPlutoHeartCrystal extends ItemMorePlanets
{
	public ItemPlutoHeartCrystal(String name)
	{
		super();
		this.setMaxStackSize(1);
		this.setUnlocalizedName(name);
		this.setMaxDamage(32);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelResourceLocation getModel(ItemStack itemStack, EntityPlayer player, int useRemaining)
	{
		if (itemStack != null)
		{
			if (itemStack.getItem() == PlutoItems.pluto_heart_crystal && itemStack.getItemDamage() >= 32)
			{
				return new ModelResourceLocation("moreplanets:broken_pluto_heart_crystal_item", "inventory");
			}
			if (itemStack.getItem() == PlutoItems.pluto_heart_crystal && itemStack.getItemDamage() >= 1 && itemStack.getItemDamage() <= 31)
			{
				return new ModelResourceLocation("moreplanets:damaged_pluto_heart_crystal_item", "inventory");
			}
		}
		return null;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		if (!(itemStack.getItemDamage() >= 32)/* && !(player.getAbsorptionAmount() >= 80.0F)*/)
		{
			player.setAbsorptionAmount(80.0F);
			itemStack.damageItem(1, player);
		}
		return itemStack;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		if (itemStack.getItemDamage() >= 32)
		{
			return "item.broken" + super.getUnlocalizedName(itemStack).replace("item.", "_");
		}
		else if (itemStack.getItemDamage() >= 1 && itemStack.getItemDamage() <= 31)
		{
			return "item.damaged" + super.getUnlocalizedName(itemStack).replace("item.", "_");
		}
		return super.getUnlocalizedName(itemStack);
	}
}