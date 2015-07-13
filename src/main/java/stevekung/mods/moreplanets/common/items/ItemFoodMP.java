/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.items;

import java.util.List;

import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.core.MorePlanetsCore;

public abstract class ItemFoodMP extends ItemFood
{
	public ItemFoodMP()
	{
		super(0, false);
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return MorePlanetsCore.mpItemsTab;
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemStack)
	{
		return ClientProxyCore.galacticraftItem;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
	{
		if (this.getItemVariantsName() == null)
		{
			return;
		}
		for (int i = 0; i < this.getItemVariantsName().length; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		if (this.reverseName())
		{
			return "item." + this.getItemVariantsName()[itemStack.getItemDamage()] + "." + super.getUnlocalizedName(itemStack).replace("item.", "");
		}
		if (this.getItemVariantsName() == null)
		{
			return super.getUnlocalizedName(itemStack);
		}
		return super.getUnlocalizedName(itemStack) + "." + this.getItemVariantsName()[itemStack.getItemDamage()];
	}

	protected abstract String[] getItemVariantsName();

	protected boolean reverseName()
	{
		return false;
	}
}