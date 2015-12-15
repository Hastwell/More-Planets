/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.pluto.tileentities;

import stevekung.mods.moreplanets.common.tileentities.TileEntityTreasureChestMP;
import stevekung.mods.moreplanets.planets.pluto.blocks.PlutoBlocks;

public class TileEntityPlutoTreasureChest extends TileEntityTreasureChestMP
{
    public TileEntityPlutoTreasureChest()
    {
        super(5, "pluto", PlutoBlocks.pluto_treasure_chest);
    }
}