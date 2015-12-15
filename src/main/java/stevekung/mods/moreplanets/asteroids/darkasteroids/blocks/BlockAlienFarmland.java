/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.asteroids.darkasteroids.blocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.common.blocks.BlockFarmlandMP;
import stevekung.mods.stevecore.BlockStateHelper;

public class BlockAlienFarmland extends BlockFarmlandMP
{
    public BlockAlienFarmland(String name)
    {
        super();
        this.setDefaultState(this.getDefaultState().withProperty(BlockStateHelper.MOISTURE, Integer.valueOf(0)));
        this.setUnlocalizedName(name);
    }

    @Override
    public Block getDirtBlock()
    {
        return DarkAsteroidBlocks.alien_dirt;
    }
}