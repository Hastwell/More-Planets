/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.world.gen.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import stevekung.mods.moreplanets.moons.europa.blocks.EuropaBlocks;

public class WorldGenEuropaTree1 extends WorldGenAbstractTree
{
	public WorldGenEuropaTree1()
	{
		super(true);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
		int i = rand.nextInt(4) + 6;
		int j = 1 + rand.nextInt(2);
		int k = i - j;
		int l = 2 + rand.nextInt(2);
		boolean flag = true;

		if (pos.getY() >= 1 && pos.getY() + i + 1 <= 256)
		{
			int j1;
			int i3;

			for (int i1 = pos.getY(); i1 <= pos.getY() + 1 + i && flag; ++i1)
			{
				if (i1 - pos.getY() < j)
				{
					i3 = 0;
				}
				else
				{
					i3 = l;
				}

				for (j1 = pos.getX() - i3; j1 <= pos.getX() + i3 && flag; ++j1)
				{
					for (int k1 = pos.getZ() - i3; k1 <= pos.getZ() + i3 && flag; ++k1)
					{
						if (i1 >= 0 && i1 < 256)
						{
							BlockPos off = new BlockPos(j1, i1, k1);
							Block block = world.getBlockState(off).getBlock();

							if (!block.getMaterial().isSolid())
							{
								flag = true;
							}
						}
						else
						{
							flag = false;
						}
					}
				}
			}

			if (!flag)
			{
				return false;
			}
			else
			{
				Block block1 = world.getBlockState(pos.up()).getBlock();

				if (block1 == EuropaBlocks.europa_ice && pos.getY() < 256 - i - 1)
				{
					i3 = rand.nextInt(2);
					j1 = 1;
					byte b0 = 0;
					int l1;
					int j3;

					for (j3 = 0; j3 <= k; ++j3)
					{
						l1 = pos.getY() - i + j3;

						for (int i2 = pos.getX() - i3; i2 <= pos.getX() + i3; ++i2)
						{
							int j2 = i2 - pos.getX();

							for (int k2 = pos.getZ() - i3; k2 <= pos.getZ() + i3; ++k2)
							{
								int l2 = k2 - pos.getZ();
								BlockPos blockpos = new BlockPos(i2, l1, k2);

								if (Math.abs(j2) != i3 || Math.abs(l2) != i3 || i3 <= 0)
								{
									if (!World.doesBlockHaveSolidTopSurface(world, blockpos))
									{
										this.func_175905_a(world, blockpos, EuropaBlocks.europa_leaves, 0);
									}
								}
							}
						}

						if (i3 >= j1)
						{
							i3 = b0;
							b0 = 1;
							++j1;

							if (j1 > l)
							{
								j1 = l;
							}
						}
						else
						{
							++i3;
						}
					}

					j3 = rand.nextInt(3);

					for (l1 = 0; l1 < i - j3; ++l1)
					{
						if (!World.doesBlockHaveSolidTopSurface(world, pos.down(l1)))
						{
							this.func_175905_a(world, pos.down(l1), EuropaBlocks.europa_log, 0);
						}
					}
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		else
		{
			return false;
		}
	}
}