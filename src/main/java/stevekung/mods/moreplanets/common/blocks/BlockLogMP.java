/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.blocks;

import java.util.Iterator;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockLogMP extends BlockBaseMP
{
	public static PropertyEnum AXIS = PropertyEnum.create("axis", EnumAxis.class);

	public BlockLogMP()
	{
		super(Material.wood);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeWood);
	}

	public BlockLogMP(Material material)
	{
		super(material);
	}

	@Override
	public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return super.onBlockPlaced(world, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(AXIS, EnumAxis.fromFacingAxis(facing.getAxis()));
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		if (this.getBlockState().getBlock().getMaterial() == Material.wood)
		{
			byte b0 = 4;
			int i = b0 + 1;

			if (world.isAreaLoaded(pos.add(-i, -i, -i), pos.add(i, i, i)))
			{
				Iterator iterator = BlockPos.getAllInBox(pos.add(-b0, -b0, -b0), pos.add(b0, b0, b0)).iterator();

				while (iterator.hasNext())
				{
					BlockPos blockpos1 = (BlockPos)iterator.next();
					IBlockState iblockstate1 = world.getBlockState(blockpos1);

					if (iblockstate1.getBlock().isLeaves(world, blockpos1))
					{
						iblockstate1.getBlock().beginLeavesDecay(world, blockpos1);
					}
				}
			}
		}
	}

	@Override
	public boolean canSustainLeaves(IBlockAccess world, BlockPos pos)
	{
		return this.getBlockState().getBlock().getMaterial() == Material.wood ? true : false;
	}

	@Override
	public boolean isWood(IBlockAccess world, BlockPos pos)
	{
		return this.getBlockState().getBlock().getMaterial() == Material.wood ? true : false;
	}

	public static enum EnumAxis implements IStringSerializable
	{
		X("x"),
		Y("y"),
		Z("z"),
		NONE("none");
		private String name;

		private EnumAxis(String name)
		{
			this.name = name;
		}

		@Override
		public String toString()
		{
			return this.name;
		}

		public static EnumAxis fromFacingAxis(Axis axis)
		{
			switch (SwitchAxis.AXIS_LOOKUP[axis.ordinal()])
			{
			case 1:
				return X;
			case 2:
				return Y;
			case 3:
				return Z;
			default:
				return NONE;
			}
		}

		@Override
		public String getName()
		{
			return this.name;
		}
	}

	static class SwitchAxis
	{
		static int[] AXIS_LOOKUP = new int[Axis.values().length];

		static
		{
			try
			{
				AXIS_LOOKUP[Axis.X.ordinal()] = 1;
			}
			catch (NoSuchFieldError var3)
			{
			}

			try
			{
				AXIS_LOOKUP[Axis.Y.ordinal()] = 2;
			}
			catch (NoSuchFieldError var2)
			{
			}

			try
			{
				AXIS_LOOKUP[Axis.Z.ordinal()] = 3;
			}
			catch (NoSuchFieldError var1)
			{
			}
		}
	}

	protected static class SwitchEnumAxis
	{
		public static int[] AXIS_LOOKUP = new int[EnumAxis.values().length];

		static
		{
			try
			{
				AXIS_LOOKUP[EnumAxis.X.ordinal()] = 1;
			}
			catch (NoSuchFieldError var3)
			{
			}

			try
			{
				AXIS_LOOKUP[EnumAxis.Z.ordinal()] = 2;
			}
			catch (NoSuchFieldError var2)
			{
			}

			try
			{
				AXIS_LOOKUP[EnumAxis.NONE.ordinal()] = 3;
			}
			catch (NoSuchFieldError var1)
			{
			}
		}
	}
}