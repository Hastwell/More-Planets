/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.items;

import java.util.List;

import micdoodle8.mods.galacticraft.api.item.IItemThermal;
import micdoodle8.mods.galacticraft.planets.asteroids.items.ItemThermalPadding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.core.MorePlanetsCore;

public class ItemTier3ThermalPadding extends ItemBaseMP implements IItemThermal
{
	public ItemTier3ThermalPadding(String name)
	{
		super();
		this.setMaxStackSize(1);
		this.setUnlocalizedName(name);
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return MorePlanetsCore.mpArmorTab;
	}

	@Override
	protected String[] getItemVariantsName()
	{
		return new String[] { "tier_3_thermal_helmet", "tier_3_thermal_chestplate", "tier_3_thermal_leggings", "tier_3_thermal_boots" };
	}

	@Override
	public String getItemStackDisplayName(ItemStack itemStack)
	{
		return StatCollector.translateToLocal("item." + ItemThermalPadding.names[itemStack.getItemDamage()] + ".name");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced)
	{
		if (player.worldObj.isRemote)
		{
			list.add(StatCollector.translateToLocal("item.tier3.desc"));
			list.add("Ability : Immune to Infected Gas and Icy Poison");
		}
	}

	@Override
	public int getThermalStrength()
	{
		return 6;
	}

	@Override
	public boolean isValidForSlot(ItemStack itemStack, int armorSlot)
	{
		return itemStack.getItemDamage() == armorSlot;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int layer)
	{
		return layer == 0 ? super.getColorFromItemStack(itemStack, layer) : 0;//TODO
	}
}