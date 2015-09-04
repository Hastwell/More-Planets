/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.pluto.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.blocks.BlockBaseMP;
import stevekung.mods.moreplanets.planets.pluto.items.PlutoItems;

public class BlockPlutoHeartCrystal extends BlockBaseMP /*implements IDetectableResource*/
{
	public BlockPlutoHeartCrystal(String name)
	{
		super(Material.glass);
		this.setUnlocalizedName(name);
		this.setHardness(0.55F);
		this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.975F, 0.9F);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return PlutoItems.pluto_heart_crystal;
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return 0;
	}

	/*@Override
	public boolean isValueable(int metadata)
	{
		return true;
	}*/

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

	@Override
	public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block block)
	{
		if (!this.canPlaceBlockAt(world, pos))
		{
			Block.spawnAsEntity(world, pos, new ItemStack(this, 1, 0));
			world.setBlockToAir(pos);
		}
	}

	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		return true;
	}

	@Override
	public boolean isFullCube()
	{
		return false;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition moving, World world, BlockPos pos, EntityPlayer player)
	{
		return new ItemStack(this, 1, 0);
	}
}