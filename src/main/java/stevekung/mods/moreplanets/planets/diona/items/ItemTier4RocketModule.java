/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.items.ItemBaseMP;

public class ItemTier4RocketModule extends ItemBaseMP
{
	public ItemTier4RocketModule(String name)
	{
		super();
		this.setUnlocalizedName(name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
	{
		if (player.worldObj.isRemote)
		{
			if (itemStack.getItemDamage() == 1)
			{
				list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("desc.tier4.name"));
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
	{
		for (int i = 0; i < this.getItemVariantsName().length; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	protected String[] getItemVariantsName()
	{
		return new String[] { "tier_4_nose_cone", "tier_4_heavy_duty_plate", "tier_4_rocket_engine", "tier_4_booster", "tier_5_rocket_engine", "tier_5_booster" };
	}

	public static enum Tier4ItemType
	{
		NOSE_CONE(0),
		T4_PLATE(1),
		T4_ENGINE(2),
		T4_BOOSTER(3),
		T5_ENGINE(4),
		T5_BOOSTER(5);

		private int meta;

		private Tier4ItemType(int meta)
		{
			this.meta = meta;
		}

		public ItemStack getItemStack()
		{
			return new ItemStack(DionaItems.tier_4_rocket_module, 1, this.meta);
		}
	}
}