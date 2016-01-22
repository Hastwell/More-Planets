/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.blocks.other.BlockDoubleWoodenSlab1;
import stevekung.mods.moreplanets.common.blocks.other.BlockWoodenSlab1;

public class ItemBlockWoodenSlab1MP extends ItemBlockSlabMP
{
    public ItemBlockWoodenSlab1MP(Block block, BlockWoodenSlab1 singleSlab, BlockDoubleWoodenSlab1 doubleSlab)
    {
        super(block, singleSlab, doubleSlab);
    }

    @Override
    public String[] getBlockVariantsName()
    {
        return new String[] { "ancient_dark_wood", "orange_wood", "crystal_wood", "coconut_wood", "maple_wood", "europa_wood", "alien_wood" };
    }
}