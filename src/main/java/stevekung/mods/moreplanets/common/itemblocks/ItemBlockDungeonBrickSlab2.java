/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.blocks.other.BlockDoubleDungeonBrickSlab2;
import stevekung.mods.moreplanets.common.blocks.other.BlockDungeonBrickSlab2;

public class ItemBlockDungeonBrickSlab2 extends ItemBlockSlabMP
{
    public ItemBlockDungeonBrickSlab2(Block block, BlockDungeonBrickSlab2 singleSlab, BlockDoubleDungeonBrickSlab2 doubleSlab)
    {
        super(block, singleSlab, doubleSlab);
    }

    @Override
    public String[] getBlockVariantsName()
    {
        return new String[] { "venus_dungeon_brick", "pluto_dungeon_brick" };
    }
}