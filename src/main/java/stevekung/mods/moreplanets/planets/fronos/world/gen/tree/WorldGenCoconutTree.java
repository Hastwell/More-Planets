/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.world.gen.tree;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import stevekung.mods.moreplanets.common.blocks.IFronosGrass;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;

public class WorldGenCoconutTree extends WorldGenAbstractTree
{
	private int strengthRand;
	private int bMax;
	private double offset;

	public WorldGenCoconutTree(int strengthRand, int bMax, double offset)
	{
		super(false);
		this.strengthRand = strengthRand;
		this.bMax = bMax;
		this.offset = offset;
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
		int y = pos.getY();

		while (world.isAirBlock(pos) && y > 2)
		{
			--y;
		}

		Block block = world.getBlockState(pos).getBlock();

		if (block != Blocks.grass && block != Blocks.dirt && !(block instanceof IFronosGrass) && block != FronosBlocks.fronos_dirt)
		{
			return false;
		}
		else
		{
			for (int var7 = -2; var7 <= 2; ++var7)
			{
				for (int var8 = -2; var8 <= 2; ++var8)
				{
					if (world.isAirBlock(pos.add(pos.getX() + var7, y - 1, pos.getZ() + var8)) && world.isAirBlock(pos.add(pos.getX() + var7, y - 2, pos.getZ() + var8)) && !world.isAirBlock(pos.add(pos.getX() + var7, y, pos.getZ() + var8)))
					{
						return false;
					}
				}
			}

			double strength = rand.nextInt(this.strengthRand) / 100D;
			double xoff = 0;
			double yoff = 0;
			int r = rand.nextInt(4);
			if(r == 0) { xoff = strength; }
			else if(r == 1) { xoff = -strength; }
			else if(r == 2) { yoff = strength; }
			else { yoff = -strength; }

			int h = 1;
			this.buildBlock(world, pos.getX(), y, pos.getZ(), FronosBlocks.fronos_dirt.getDefaultState());

			for (int b = 0; b < this.bMax; b++)
			{
				this.buildBlock(world, pos.getX() + (int) Math.floor(xoff), y + h, pos.getZ() + (int) Math.floor(yoff), FronosBlocks.fronos_log.getDefaultState());

				if (b == this.bMax - 1)
				{
					this.generateTop(world, pos.getX() + (int) Math.floor(xoff), y + h, pos.getZ() + (int) Math.floor(yoff));
				}
				else
				{
					h++;
					xoff *= this.offset;
					yoff *= this.offset;
				}
			}
			return true;
		}
	}

	public void generateTop(World world, int x, int y, int z)
	{
		this.buildBlock(world, x + 2, y - 1, z, FronosBlocks.fronos_colorized_leaves.getDefaultState());
		this.buildBlock(world, x - 2, y - 1, z, FronosBlocks.fronos_colorized_leaves.getDefaultState());
		this.buildBlock(world, x, y - 1, z + 2, FronosBlocks.fronos_colorized_leaves.getDefaultState());
		this.buildBlock(world, x, y - 1, z - 2, FronosBlocks.fronos_colorized_leaves.getDefaultState());

		this.buildBlock(world, x + 1, y, z, FronosBlocks.fronos_colorized_leaves.getDefaultState());
		this.buildBlock(world, x - 1, y, z, FronosBlocks.fronos_colorized_leaves.getDefaultState());
		this.buildBlock(world, x, y, z + 1, FronosBlocks.fronos_colorized_leaves.getDefaultState());
		this.buildBlock(world, x, y, z - 1, FronosBlocks.fronos_colorized_leaves.getDefaultState());
		this.buildBlock(world, x + 2, y, z + 2, FronosBlocks.fronos_colorized_leaves.getDefaultState());
		this.buildBlock(world, x - 2, y, z - 2, FronosBlocks.fronos_colorized_leaves.getDefaultState());
		this.buildBlock(world, x + 2, y, z - 2, FronosBlocks.fronos_colorized_leaves.getDefaultState());
		this.buildBlock(world, x - 2, y, z + 2, FronosBlocks.fronos_colorized_leaves.getDefaultState());

		this.buildBlock(world, x + 1, y + 1, z - 1, FronosBlocks.fronos_colorized_leaves.getDefaultState());
		this.buildBlock(world, x - 1, y + 1, z + 1, FronosBlocks.fronos_colorized_leaves.getDefaultState());
		this.buildBlock(world, x + 1, y + 1, z + 1, FronosBlocks.fronos_colorized_leaves.getDefaultState());
		this.buildBlock(world, x - 1, y + 1, z - 1, FronosBlocks.fronos_colorized_leaves.getDefaultState());
		this.buildBlock(world, x, y + 1, z, FronosBlocks.fronos_colorized_leaves.getDefaultState());

		this.buildBlock(world, x + 2, y + 2, z, FronosBlocks.fronos_colorized_leaves.getDefaultState());
		this.buildBlock(world, x - 2, y + 2, z, FronosBlocks.fronos_colorized_leaves.getDefaultState());
		this.buildBlock(world, x, y + 2, z + 2, FronosBlocks.fronos_colorized_leaves.getDefaultState());
		this.buildBlock(world, x, y + 2, z - 2, FronosBlocks.fronos_colorized_leaves.getDefaultState());
	}

	public void buildBlock(World world, int x, int y, int z, IBlockState state)
	{
		BlockPos pos = new BlockPos(x, y, z);

		if (world.isAirBlock(pos) || world.getBlockState(pos).getBlock().isLeaves(world, pos))
		{
			world.setBlockState(pos, state, 2);
		}
	}
}