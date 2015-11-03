/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockBaseMP;

public class ItemBlockFronosTallGrass extends ItemBlockBaseMP
{
	public ItemBlockFronosTallGrass(Block block)
	{
		super(block);
	}

	@Override
	public String[] getBlockVariantsName()
	{
		return new String[] { "short_grass", "medium_grass", "tall_grass", "short_pink_grass", "medium_pink_grass", "tall_pink_grass", "short_purple_grass", "medium_purple_grass", "tall_purple_grass", "short_plains_grass", "medium_plains_grass", "tall_plains_grass", "short_golden_grass", "medium_golden_grass", "tall_golden_grass" };
	}
}