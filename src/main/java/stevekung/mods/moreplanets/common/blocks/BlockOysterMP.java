/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public abstract class BlockOysterMP extends BlockBaseMP
{
	public static PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public BlockOysterMP()
	{
		super(Material.plants);
		this.setHardness(0.6F);
		this.setBlockBounds(0.225F, 0.0F, 0.225F, 0.775F, 0.275F, 0.775F);
		this.setTickRandomly(true);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean isFullCube()
	{
		return false;
	}

	@Override
	public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block block)
	{
		this.checkForDrop(world, pos, state);
	}

	private boolean checkForDrop(World world, BlockPos pos, IBlockState state)
	{
		if (!this.canBlockStay(world, pos))
		{
			this.dropBlockAsItem(world, pos, state, 0);
			world.setBlockToAir(pos);
			return false;
		}
		else
		{
			return true;
		}
	}

	private boolean canBlockStay(World world, BlockPos pos)
	{
		return !world.isAirBlock(pos.down());
	}

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos)
	{
		Block block = world.getBlockState(pos.down()).getBlock();

		if (block == null)
		{
			return false;
		}
		if (!block.isLeaves(world, pos.down()) && !block.isOpaqueCube())
		{
			return false;
		}
		return world.getBlockState(pos.down()).getBlock().getMaterial().blocksMovement();
	}
}