/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.core.MorePlanetsCore;

public abstract class BlockFlowerMP extends BlockBaseMP implements IPlantable
{
	public BlockFlowerMP()
	{
		super(Material.plants);
		this.setHardness(0.0F);
		this.setStepSound(soundTypeGrass);
		this.setTickRandomly(true);
	}

	public BlockFlowerMP(Material material)
	{
		super(material);
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return MorePlanetsCore.mpBlocksTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumOffsetType getOffsetType()
	{
		return EnumOffsetType.XZ;
	}

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos)
	{
		return this.canBlockStay(world, pos, world.getBlockState(pos));
	}

	@Override
	public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block neighborBlock)
	{
		super.onNeighborBlockChange(world, pos, state, neighborBlock);
		this.checkAndDropBlock(world, pos, state);
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		this.checkAndDropBlock(world, pos, state);
	}

	protected void checkAndDropBlock(World world, BlockPos pos, IBlockState state)
	{
		if (!this.canBlockStay(world, pos, state))
		{
			this.dropBlockAsItem(world, pos, state, 0);
			world.setBlockState(pos, Blocks.air.getDefaultState(), 3);
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World world, BlockPos pos, IBlockState state)
	{
		return null;
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
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}

	public abstract boolean canBlockStay(World world, BlockPos pos, IBlockState state);
}