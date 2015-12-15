/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.itemblocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.blocks.other.BlockDoubleStoneSlab2;
import stevekung.mods.moreplanets.common.blocks.other.BlockStoneSlab2;

public class ItemBlockStoneSlab2MP extends ItemBlockSlabMP
{
    public ItemBlockStoneSlab2MP(Block block, BlockStoneSlab2 singleSlab, BlockDoubleStoneSlab2 doubleSlab)
    {
        super(block, singleSlab, doubleSlab);
    }

    @Override
    public String[] getBlockVariantsName()
    {
        return new String[] { "fronos_cobblestone", "fronos_stone_brick", "cracked_fronos_stone_brick", "kapteyn_b_cracked_ice", "sirius_b_carbon_cobblestone", "mercury_cobblestone" };
    }
}