/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.world.gen.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockFronosTallGrass;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;

public class WorldGenFronosTallGrass extends WorldGenerator
{
	private IBlockState flower;

	public WorldGenFronosTallGrass(BlockFronosTallGrass.BlockType flower)
	{
		this.flower = FronosBlocks.fronos_tall_grass.getDefaultState().withProperty(BlockFronosTallGrass.VARIANT, flower);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
		Block block;

		do
		{
			block = world.getBlockState(pos).getBlock();

			if (!block.isAir(world, pos) && !block.isLeaves(world, pos))
			{
				break;
			}
			pos = pos.down();
		}
		while (pos.getY() > 0);

		for (int i = 0; i < 128; ++i)
		{
			BlockPos blockpos1 = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

			if (world.isAirBlock(blockpos1) && FronosBlocks.fronos_tall_grass.canBlockStay(world, blockpos1, world.getBlockState(blockpos1)))
			{
				world.setBlockState(blockpos1, this.flower, 2);
			}
		}
		return true;
	}
}