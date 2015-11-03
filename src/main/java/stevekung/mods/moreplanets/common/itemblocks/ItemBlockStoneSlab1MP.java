/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.blocks.BlockDoubleStoneSlab1MP;
import stevekung.mods.moreplanets.common.blocks.BlockStoneSlab1MP;

public class ItemBlockStoneSlab1MP extends ItemBlockSlabMP
{
	public ItemBlockStoneSlab1MP(Block block, BlockStoneSlab1MP singleSlab, BlockDoubleStoneSlab1MP doubleSlab)
	{
		super(block, singleSlab, doubleSlab);
	}

	@Override
	public String[] getBlockVariantsName()
	{
		return new String[] { "diona_cobblestone", "quontonium_brick", "chiseled_quontonium", "polongnius_cobblestone", "nibiru_cobblestone", "koentus_cobblestone", "koentus_ancient_stone", "koentus_ancient_stone_brick" };
	}
}