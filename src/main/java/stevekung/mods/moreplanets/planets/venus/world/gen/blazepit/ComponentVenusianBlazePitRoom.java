/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.world.gen.blazepit;

import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.core.world.gen.StructureComponentGC;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import stevekung.mods.moreplanets.planets.venus.blocks.BlockVenus;
import stevekung.mods.moreplanets.planets.venus.blocks.VenusBlocks;

public class ComponentVenusianBlazePitRoom extends StructureComponentGC
{
	public int corridorCount;
	public int originalFourCorridorLength;
	public int bossEntryCorridor;
	public int bossEntryCount;
	private int averageGroundLevel = -1;
	private int height;
	private int width;

	public ComponentVenusianBlazePitRoom(int type, int x, int y, int z, int height, int width, EnumFacing cbm)
	{
		super(type);
		this.coordBaseMode = cbm;
		this.height = height;
		this.width = width;
		this.boundingBox = StructureComponentGC.getComponentToAddBoundingBox(x, 78 - this.height, z, 0, 0, 0, 7, this.height, 7, cbm);
	}

	@Override
	public void buildComponent(StructureComponent component, List list, Random rand)
	{
		int var4;

		for (var4 = 0; var4 < 4; ++var4)
		{
			int[] var5 = this.getValidOpening(var4);
			this.makeCorridor(list, 1, var5[0], var5[1], var5[2], this.width, 7);
		}
	}

	public int[] getValidOpening(int var2)
	{
		if (var2 == 0)
		{
			return new int[] {this.width - 1, 0, 1};
		}
		else if (var2 == 1)
		{
			return new int[] {1, 0, this.width - 1};
		}
		else if (var2 == 2)
		{
			return new int[] {0, 0, 1};
		}
		else if (var2 == 3)
		{
			return new int[] {1, 0, 0};
		}
		return new int[] {0, 0, 0};
	}

	public boolean makeCorridor(List list, int type, int x, int y, int z, int width, int height)
	{
		int var10 = SwitchEnumFacing.field_176064_a[this.coordBaseMode.ordinal()] % 4;
		this.offsetCorridorCoords(x, y, z, width, var10);
		return true;
	}

	protected int[] offsetCorridorCoords(int x, int y, int z, int width, int cbm)
	{
		int var6 = this.getXWithOffset(x, z);
		int var7 = this.getYWithOffset(y);
		int var8 = this.getZWithOffset(x, z);
		return cbm == 0 ? new int[] {var6 + 1, var7 - 1, var8 - width / 2}: cbm == 1 ? new int[] {var6 + width / 2, var7 - 1, var8 + 1}: cbm == 2 ? new int[] {var6 - 1, var7 - 1, var8 + width / 2}: cbm == 3 ? new int[] {var6 - width / 2, var7 - 1, var8 - 1}: new int[] {x, y, z};
	}

	@Override
	public boolean addComponentParts(World world, Random rand, StructureBoundingBox box)
	{
		if (this.averageGroundLevel < 0)
		{
			this.averageGroundLevel = this.getAverageGroundLevel(world, box);

			if (this.averageGroundLevel < 0)
			{
				return true;
			}
			this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + 3, 0);
		}
		this.makeWallsDown(world);
		this.makePlatforms(world, rand);
		this.makeWallsFlat(world);
		return true;
	}

	public void makeWallsDown(World world)
	{
		for (int y = 0; y < this.height; y++)
		{
			for (int x = 0; x < 7; x++)
			{
				for (int z = 0; z < 7; z++)
				{
					if ((x == 0 || x == 6 || z == 0 || z == 6) && (y == 0 || y > 0))
					{
						this.func_175808_b(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.venus_dungeon_brick), x, y, z, this.getBoundingBox());
					}
					else
					{
						this.func_175808_b(world, Blocks.air.getDefaultState(), x, y, z, this.getBoundingBox());
					}
				}
			}
		}
	}

	public void makeWallsFlat(World world)
	{
		for (int y = 0; y > -1; y--)
		{
			for (int x = 0; x < 1; x++)
			{
				for (int z = 0; z < 1; z++)
				{
					for (int i = -2; i < 7; i++)
					{
						for (int j = -2; j < 7; j++)
						{
							if (world.getBlockState(new BlockPos(this.getBoundingBox().minX + x + i, this.getBoundingBox().minY + y, this.getBoundingBox().minZ + z + j)) == Blocks.air.getDefaultState())
							{
								this.func_175808_b(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.venus_dungeon_brick), x + i, y, z + j, this.getBoundingBox());
							}
						}
					}
				}
			}
		}
	}

	public void makePlatforms(World world, Random rand)
	{
		for (int y = this.height - 1; y > 0; y--)
		{
			for (int x = 0; x < this.width; x++)
			{
				for (int z = 0; z < this.width; z++)
				{
					if (y % 4 == 0 && rand.nextInt(20) == 0)
					{
						for (int i = -2; i < 2; i++)
						{
							for (int j = -2; j < 2; j++)
							{
								if (world.getBlockState(new BlockPos(this.getBoundingBox().minX + x + i, this.getBoundingBox().minY + y, this.getBoundingBox().minZ + z + j)) == Blocks.air.getDefaultState())
								{
									this.func_175808_b(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.venus_dungeon_brick), x + i, y, z + j, this.getBoundingBox());
								}

								if (y > 0)
								{
									this.func_175808_b(world, Blocks.air.getDefaultState(), x - 2, y, z - 2, this.getBoundingBox());
									this.func_175808_b(world, Blocks.air.getDefaultState(), x + 1, y, z - 2, this.getBoundingBox());
									this.func_175808_b(world, Blocks.air.getDefaultState(), x - 2, y, z + 1, this.getBoundingBox());
									this.func_175808_b(world, Blocks.air.getDefaultState(), x + 1, y, z + 1, this.getBoundingBox());
								}

								if (rand.nextInt(5) == 0 && world.getBlockState(new BlockPos(this.getBoundingBox().minX + x + i, this.getBoundingBox().minY + y + 1, this.getBoundingBox().minZ + z + j)) == Blocks.air.getDefaultState() && world.getBlockState(new BlockPos(this.getBoundingBox().minX + x + i, this.getBoundingBox().minY + y, this.getBoundingBox().minZ + z + j)) == VenusBlocks.venus_block.getDefaultState())
								{
									this.func_175808_b(world, VenusBlocks.venusian_blaze_egg.getDefaultState(), x + i, y + 1, z + j, this.getBoundingBox());
								}
							}
						}

						if (rand.nextInt(10) == 0)
						{
							if (x > 0 && x < 7 && z > 0 && z < 7)
							{
								if (world.getBlockState(new BlockPos(this.getBoundingBox().minX + x, this.getBoundingBox().minY + y + 1, this.getBoundingBox().minZ + z)) == Blocks.air.getDefaultState())
								{
									this.func_175808_b(world, VenusBlocks.venusian_blaze_egg.getDefaultState(), x, y + 2, z, this.getBoundingBox());
								}
							}
						}
					}
				}
			}
		}
	}

	protected int getAverageGroundLevel(World world, StructureBoundingBox box)
	{
		int var3 = 0;
		int var4 = 0;

		for (int var5 = this.boundingBox.minZ; var5 <= this.boundingBox.maxZ; ++var5)
		{
			for (int var6 = this.boundingBox.minX; var6 <= this.boundingBox.maxX; ++var6)
			{
				if (box.func_175898_b(new BlockPos(var6, 64, var5)))
				{
					var3 += Math.max(world.getTopSolidOrLiquidBlock(new BlockPos(var6, 64, var5)).getY(), world.provider.getAverageGroundLevel());
					++var4;
				}
			}
		}

		if (var4 == 0)
		{
			return -1;
		}
		else
		{
			return var3 / var4;
		}
	}

	@Override
	protected void writeStructureToNBT(NBTTagCompound nbt) {}

	@Override
	protected void readStructureFromNBT(NBTTagCompound nbt) {}

	protected static class SwitchEnumFacing
	{
		protected static int[] field_176064_a = new int[EnumFacing.values().length];

		static
		{
			try
			{
				field_176064_a[EnumFacing.NORTH.ordinal()] = 1;
			}
			catch (NoSuchFieldError var4)
			{
			}

			try
			{
				field_176064_a[EnumFacing.SOUTH.ordinal()] = 2;
			}
			catch (NoSuchFieldError var3)
			{
			}

			try
			{
				field_176064_a[EnumFacing.WEST.ordinal()] = 3;
			}
			catch (NoSuchFieldError var2)
			{
			}

			try
			{
				field_176064_a[EnumFacing.EAST.ordinal()] = 4;
			}
			catch (NoSuchFieldError var1)
			{
			}
		}
	}
}