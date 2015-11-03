/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.blocks.BlockDoubleStoneSlab2MP;
import stevekung.mods.moreplanets.common.blocks.BlockStoneSlab2MP;

public class ItemBlockStoneSlab2MP extends ItemBlockSlabMP
{
	public ItemBlockStoneSlab2MP(Block block, BlockStoneSlab2MP singleSlab, BlockDoubleStoneSlab2MP doubleSlab)
	{
		super(block, singleSlab, doubleSlab);
	}

	@Override
	public String[] getBlockVariantsName()
	{
		return new String[] { "fronos_cobblestone", "fronos_stone_brick", "cracked_fronos_stone_brick", "kapteyn_b_cracked_ice", "sirius_b_carbon_cobblestone", "mercury_cobblestone" };
	}
}