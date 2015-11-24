/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.blocks;

import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.moons.europa.world.gen.feature.WorldGenEuropaTree;
import stevekung.mods.moreplanets.moons.europa.world.gen.feature.WorldGenEuropaTree1;

public class BlockEuropaSapling extends BlockBush implements IGrowable
{
	public static PropertyBool UP = PropertyBool.create("up");

	public BlockEuropaSapling(String name)
	{
		super(Material.water);
		this.setHardness(0.0F);
		this.setUnlocalizedName(name);
		this.setStepSound(soundTypeGrass);
		this.setTickRandomly(true);
		this.setDefaultState(this.getDefaultState().withProperty(UP, false));
		this.setBlockBounds(0.099999994F, 0.0F, 0.099999994F, 0.9F, 0.8F, 0.9F);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, BlockPos pos)
	{
		int meta = this.getMetaFromState(world.getBlockState(pos));

		if (meta == 0)
		{
			this.setBlockBounds(0.099999994F, 0.0F, 0.099999994F, 0.9F, 0.8F, 0.9F);
		}
		else if (meta == 1)
		{
			this.setBlockBounds(0.099999994F, 0.2F, 0.099999994F, 0.9F, 1.0F, 0.9F);
		}
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

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		return state.withProperty(UP, world.getBlockState(pos.up()).getBlock() == EuropaBlocks.europa_ice);
	}

	@Override
	protected void checkAndDropBlock(World world, BlockPos pos, IBlockState state)
	{
		if (!this.canBlockStay(world, pos, state))
		{
			this.dropBlockAsItem(world, pos, state, 0);
			world.setBlockToAir(pos);
		}
	}

	@Override
	public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		if (side == EnumFacing.DOWN)
		{
			return this.getStateFromMeta(1);
		}
		return this.getStateFromMeta(0);
	}

	@Override
	public boolean canReplace(World world, BlockPos pos, EnumFacing side, ItemStack itemStack)
	{
		if (side == EnumFacing.DOWN)
		{
			return world.getBlockState(pos.up()).getBlock() == EuropaBlocks.europa_ice && world.getBlockState(pos.down()).getBlock() == EuropaBlocks.europa_water;
		}
		return this.canBlockStay(world, pos, world.getBlockState(pos));
	}

	@Override
	public boolean canBlockStay(World world, BlockPos pos, IBlockState state)
	{
		if (world.getBlockState(pos.down()).getBlock() == EuropaBlocks.europa_ice_slush && world.getBlockState(pos.up()).getBlock() == EuropaBlocks.europa_water)
		{
			return true;
		}
		else if (this.getMetaFromState(state) == 1)
		{
			if (world.getBlockState(pos.up()).getBlock() == EuropaBlocks.europa_ice && world.getBlockState(pos.down()).getBlock() == EuropaBlocks.europa_water)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos)
	{
		if (world.getBlockState(pos.down()).getBlock() == EuropaBlocks.europa_ice_slush && world.getBlockState(pos.up()).getBlock() == EuropaBlocks.europa_water)
		{
			return true;
		}
		else if (this.getMetaFromState(world.getBlockState(pos)) == 1)
		{
			if (world.getBlockState(pos.up()) == EuropaBlocks.europa_ice && world.getBlockState(pos.down()).getBlock() == EuropaBlocks.europa_water)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		if (!world.isRemote)
		{
			super.updateTick(world, pos, state, rand);

			if (world.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
			{
				this.grow(world, rand, pos, state);
			}
		}
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, BlockPos pos, IBlockState state)
	{
		world.setBlockState(pos, EuropaBlocks.europa_water.getDefaultState());
	}

	@Override
	public void grow(World world, Random rand, BlockPos pos, IBlockState state)
	{
		Object obj = null;

		if (obj == null)
		{
			if (this.getMetaFromState(state) == 0)
			{
				obj = new WorldGenEuropaTree();
			}
			else if (this.getMetaFromState(state) == 1)
			{
				obj = new WorldGenEuropaTree1();
			}
		}
		if (obj != null)
		{
			world.setBlockToAir(pos);

			if (!((WorldGenerator)obj).generate(world, rand, pos))
			{
				world.setBlockState(pos, state, 2);
			}
		}
	}

	@Override
	public boolean isReplaceable(World world, BlockPos pos)
	{
		return false;
	}

	@Override
	public boolean canGrow(World world, BlockPos pos, IBlockState state, boolean isClient)
	{
		return true;
	}

	@Override
	public boolean canUseBonemeal(World world, Random rand, BlockPos pos, IBlockState state)
	{
		return world.rand.nextFloat() < 0.45D;
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { BlockLiquid.LEVEL, UP });
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		if (meta == 0)
		{
			return this.getDefaultState().withProperty(UP, false);
		}
		else
		{
			return this.getDefaultState().withProperty(UP, true);
		}
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		if (state == this.getDefaultState().withProperty(UP, false))
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
}