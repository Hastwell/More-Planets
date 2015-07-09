/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.blocks;

import stevekung.mods.moreplanets.common.blocks.BlockTreasureChestMP;
import stevekung.mods.moreplanets.common.tileentities.TileEntityTreasureChestMP;
import stevekung.mods.moreplanets.planets.venus.tileentities.TileEntityVenusTreasureChest;

public class BlockVenusTreasureChest extends BlockTreasureChestMP
{
	public BlockVenusTreasureChest(String name)
	{
		super();
		this.setUnlocalizedName(name);
	}

	@Override
	public TileEntityTreasureChestMP getTreasureChest()
	{
		return new TileEntityVenusTreasureChest();
	}
}