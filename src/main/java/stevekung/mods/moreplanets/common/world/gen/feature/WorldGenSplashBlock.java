/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.world.gen.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSplashBlock extends WorldGenerator
{
    private Block blockToGen;
    private int metaToGen;
    private Block block;
    private int meta;
    private IBlockState state;
    private IBlockState stateToGen;
    private boolean useBlockState;

    public WorldGenSplashBlock(Block block, int meta, Block blockToGen, int metaToGen)
    {
        super();
        this.block = block;
        this.meta = meta;
        this.blockToGen = blockToGen;
        this.metaToGen = metaToGen;
    }

    public WorldGenSplashBlock(IBlockState state, IBlockState stateToGen, boolean useBlockState)
    {
        super();
        this.state = state;
        this.stateToGen = stateToGen;
        this.useBlockState = useBlockState;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        for (int i = 0; i < 64; i++)
        {
            pos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (this.useBlockState)
            {
                if (world.getBlockState(pos.down()) == this.stateToGen)
                {
                    world.setBlockState(pos.down(), this.state, 2);
                }
            }
            else
            {
                if (world.getBlockState(pos.down()) == this.blockToGen.getStateFromMeta(this.metaToGen))
                {
                    world.setBlockState(pos.down(), this.block.getStateFromMeta(this.meta), 2);
                }
            }
        }
        return true;
    }
}