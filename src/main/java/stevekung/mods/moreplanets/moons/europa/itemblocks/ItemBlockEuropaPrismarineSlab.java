/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockSlabMP;
import stevekung.mods.moreplanets.moons.europa.blocks.BlockDoubleEuropaPrismarineSlab;
import stevekung.mods.moreplanets.moons.europa.blocks.BlockEuropaPrismarineSlab;

public class ItemBlockEuropaPrismarineSlab extends ItemBlockSlabMP
{
	public ItemBlockEuropaPrismarineSlab(Block block, BlockEuropaPrismarineSlab singleSlab, BlockDoubleEuropaPrismarineSlab doubleSlab)
	{
		super(block, singleSlab, doubleSlab);
		this.setHasSubtypes(true);
	}

	@Override
	public String[] getBlockVariantsName()
	{
		return new String[] { "europa_prismarine", "europa_prismarine_brick", "dark_europa_prismarine" };
	}
}