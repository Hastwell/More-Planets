/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.io.items;

import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.moons.io.blocks.IoBlocks;

public class ItemLiquidBrownSulfurBucket extends ItemBucket
{
	public ItemLiquidBrownSulfurBucket(String name)
	{
		super(IoBlocks.liquid_brown_sulfur);
		this.setUnlocalizedName(name);
		this.setContainerItem(Items.bucket);
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return MorePlanetsCore.mpItemsTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemStack)
	{
		return ClientProxyCore.galacticraftItem;
	}
}