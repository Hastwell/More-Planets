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
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockFronosSand;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.stevecore.BlockStateHelper;

public class WorldGenSpaceOyster extends WorldGenerator
{
	private IBlockState block;

	public WorldGenSpaceOyster(IBlockState block)
	{
		this.block = block;
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
		Block block = world.getBlockState(pos.down()).getBlock();

		if (!(block == FronosBlocks.golden_grass || block == Blocks.sand || block == FronosBlocks.fronos_sand && world.getBlockState(pos.down()) == world.getBlockState(pos.down()).withProperty(BlockFronosSand.VARIANT, BlockFronosSand.BlockType.white_sand)))
		{
			return false;
		}
		else
		{
			world.setBlockState(pos, this.block.withProperty(BlockStateHelper.FACING, EnumFacing.getFront(((EnumFacing)world.getBlockState(pos).getValue(BlockStateHelper.FACING)).getIndex())), 2);
			return true;
		}
	}
}