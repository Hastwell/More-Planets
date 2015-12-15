/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockSlabMP;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockDoubleFronosSandstoneSlab;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockFronosSandstoneSlab;

public class ItemBlockFronosSandstoneSlab extends ItemBlockSlabMP
{
    public ItemBlockFronosSandstoneSlab(Block block, BlockFronosSandstoneSlab singleSlab, BlockDoubleFronosSandstoneSlab doubleSlab)
    {
        super(block, singleSlab, doubleSlab);
    }

    @Override
    public String[] getBlockVariantsName()
    {
        return new String[] { "fronos_sandstone", "white_sandstone", "cheese_sandstone" };
    }
}