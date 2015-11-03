/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.blocks;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockFluidBaseMP extends BlockFluidClassic
{
	Fluid fluid;
	int adjacentSourceBlocks;

	public BlockFluidBaseMP(Fluid fluid)
	{
		super(fluid, Material.water);
		this.fluid = fluid;
	}

	public BlockFluidBaseMP(Fluid fluid, Material material)
	{
		super(fluid, material);
		this.fluid = fluid;
	}

	@Override
	public boolean canDisplace(IBlockAccess world, BlockPos pos)
	{
		if (world.getBlockState(pos).getBlock().getMaterial().isLiquid())
		{
			return false;
		}
		if (world.getBlockState(pos).getBlock().getMaterial() == Material.lava)
		{
			return false;
		}
		return super.canDisplace(world, pos);
	}

	@Override
	public boolean displaceIfPossible(World world, BlockPos pos)
	{
		if (world.getBlockState(pos).getBlock().getMaterial().isLiquid())
		{
			return false;
		}
		if (world.getBlockState(pos).getBlock().getMaterial() == Material.lava)
		{
			return false;
		}
		return super.displaceIfPossible(world, pos);
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		super.updateTick(world, pos, state, rand);

		if (this.blockMaterial == Material.water)
		{
			int i = ((Integer)state.getValue(LEVEL)).intValue();
			byte b0 = 1;

			int j = this.tickRate(world);
			int i1;

			if (i > 0)
			{
				int k = -100;
				this.adjacentSourceBlocks = 0;
				EnumFacing enumfacing;

				for (Iterator iterator = EnumFacing.Plane.HORIZONTAL.iterator(); iterator.hasNext(); k = this.checkAdjacentBlock(world, pos.offset(enumfacing), k))
				{
					enumfacing = (EnumFacing)iterator.next();
				}

				int l = k + b0;

				if (l >= 8 || k < 0)
				{
					l = -1;
				}

				if (this.getLevel(world, pos.up()) >= 0)
				{
					i1 = this.getLevel(world, pos.up());

					if (i1 >= 8)
					{
						l = i1;
					}
					else
					{
						l = i1 + 8;
					}
				}

				if (this.adjacentSourceBlocks >= 2)
				{
					IBlockState iblockstate2 = world.getBlockState(pos.down());

					if (iblockstate2.getBlock().getMaterial().isSolid())
					{
						l = 0;
					}
					else if (iblockstate2.getBlock().getMaterial() == this.blockMaterial && ((Integer)iblockstate2.getValue(LEVEL)).intValue() == 0)
					{
						l = 0;
					}
				}

				if (l == i)
				{
					this.placeStaticBlock(world, pos, state);
				}
				else
				{
					i = l;

					if (l < 0)
					{
						world.setBlockToAir(pos);
					}
					else
					{
						state = state.withProperty(LEVEL, Integer.valueOf(l));
						world.setBlockState(pos, state, 2);
						world.scheduleUpdate(pos, this, j);
						world.notifyNeighborsOfStateChange(pos, this);
					}
				}
			}
			else
			{
				this.placeStaticBlock(world, pos, state);
			}
		}
	}

	private void placeStaticBlock(World world, BlockPos pos, IBlockState state)
	{
		world.setBlockState(pos, this.getDefaultState().withProperty(LEVEL, state.getValue(LEVEL)), 2);
	}

	private int checkAdjacentBlock(World world, BlockPos pos, int level)
	{
		int j = this.getLevel(world, pos);

		if (j < 0)
		{
			return level;
		}
		else
		{
			if (j == 0)
			{
				++this.adjacentSourceBlocks;
			}
			if (j >= 8)
			{
				j = 0;
			}
			return level >= 0 && j >= level ? level : j;
		}
	}

	private int getLevel(IBlockAccess world, BlockPos pos)
	{
		return world.getBlockState(pos).getBlock().getMaterial() == this.blockMaterial ? ((Integer)world.getBlockState(pos).getValue(LEVEL)).intValue() : -1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess world, BlockPos pos, EnumFacing side)
	{
		if ((world.getBlockState(pos).getBlock() instanceof BlockFluidLavaBaseMP || world.getBlockState(pos).getBlock() instanceof BlockFluidBaseMP) && world.getBlockState(pos).getBlock() != this)
		{
			return true;
		}
		return super.shouldSideBeRendered(world, pos, side);
	}
}