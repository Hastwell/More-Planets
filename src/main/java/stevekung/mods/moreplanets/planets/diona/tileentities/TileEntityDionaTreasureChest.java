/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.tileentities;

import stevekung.mods.moreplanets.common.tileentities.TileEntityTreasureChestMP;
import stevekung.mods.moreplanets.planets.diona.blocks.DionaBlocks;

public class TileEntityDionaTreasureChest extends TileEntityTreasureChestMP
{
	public TileEntityDionaTreasureChest()
	{
		super(4, "diona", DionaBlocks.diona_treasure_chest);
	}
}