/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockBaseMP;

public class ItemBlockEuropaSponge extends ItemBlockBaseMP
{
	public ItemBlockEuropaSponge(Block block)
	{
		super(block);
	}

	@Override
	protected String[] getBlockVariantsName()
	{
		return new String[] { "default", "wet" };
	}
}