/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockSlabMP;
import stevekung.mods.moreplanets.planets.venus.blocks.BlockDoubleVenusSandstoneSlab;
import stevekung.mods.moreplanets.planets.venus.blocks.BlockVenusSandstoneSlab;

public class ItemBlockVenusSandstoneSlab extends ItemBlockSlabMP
{
	public ItemBlockVenusSandstoneSlab(Block block, BlockVenusSandstoneSlab singleSlab, BlockDoubleVenusSandstoneSlab doubleSlab)
	{
		super(block, singleSlab, doubleSlab);
		this.setHasSubtypes(false);
	}

	@Override
	public String[] getBlockVariantsName()
	{
		return new String[] { "venus_sandstone" };
	}
}