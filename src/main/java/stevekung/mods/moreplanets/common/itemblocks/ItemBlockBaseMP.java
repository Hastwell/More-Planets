/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.itemblocks;

import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ItemBlockBaseMP extends ItemBlock
{
	public ItemBlockBaseMP(Block block)
	{
		super(block);
		this.setHasSubtypes(true);
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
	public String getUnlocalizedName(ItemStack itemStack)
	{
		int meta = itemStack.getItemDamage();

		if (meta < 0 || meta >= this.getBlockVariantsName().length)
		{
			meta = 0;
		}
		if (this.reverseName())
		{
			return "tile." + this.getBlockVariantsName()[meta] + "_" + super.getUnlocalizedName().replace("tile.", "");
		}
		return super.getUnlocalizedName() + "." + this.getBlockVariantsName()[meta];
	}

	protected abstract String[] getBlockVariantsName();

	protected boolean reverseName()
	{
		return false;
	}
}