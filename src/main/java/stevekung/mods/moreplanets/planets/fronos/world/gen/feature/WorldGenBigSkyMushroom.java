package stevekung.mods.moreplanets.planets.fronos.world.gen.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;

public class WorldGenBigSkyMushroom extends WorldGenerator
{
	private int mushroomType = 0;

	public WorldGenBigSkyMushroom()
	{
		super(true);
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
		int i = rand.nextInt(2);

		if (this.mushroomType >= 0)
		{
			i = this.mushroomType;
		}

		int j = rand.nextInt(3) + 4;
		boolean flag = true;

		if (pos.getY() >= 1 && pos.getY() + j + 1 < 256)
		{
			int l;
			int i1;

			for (int k = pos.getY(); k <= pos.getY() + 1 + j; ++k)
			{
				byte b0 = 3;

				if (k <= pos.getY() + 3)
				{
					b0 = 0;
				}

				for (l = pos.getX() - b0; l <= pos.getX() + b0 && flag; ++l)
				{
					for (i1 = pos.getZ() - b0; i1 <= pos.getZ() + b0 && flag; ++i1)
					{
						if (k >= 0 && k < 256)
						{
							BlockPos pos1 = new BlockPos(l, k, i1);
							IBlockState state = world.getBlockState(pos1);

							if (!state.getBlock().isAir(world, pos1) && !state.getBlock().isLeaves(world, pos1))
							{
								flag = false;
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
				Block block1 = world.getBlockState(pos.down()).getBlock();

				if (block1 != FronosBlocks.fronos_block && block1 != FronosBlocks.jelly_ore && block1 != FronosBlocks.mossy_fronos_cobblestone)
				{
					return false;
				}
				else
				{
					int l1 = pos.getY() + j;

					if (i == 1)
					{
						l1 = pos.getY() + j - 3;
					}

					for (l = l1; l <= pos.getY() + j; ++l)
					{
						i1 = 1;

						if (l < pos.getY() + j)
						{
							++i1;
						}
						if (i == 0)
						{
							i1 = 3;
						}

						for (int i2 = pos.getX() - i1; i2 <= pos.getX() + i1; ++i2)
						{
							for (int j1 = pos.getZ() - i1; j1 <= pos.getZ() + i1; ++j1)
							{
								int k1 = 5;

								if (i2 == pos.getX() - i1)
								{
									--k1;
								}
								if (i2 == pos.getX() + i1)
								{
									++k1;
								}
								if (j1 == pos.getZ() - i1)
								{
									k1 -= 3;
								}
								if (j1 == pos.getZ() + i1)
								{
									k1 += 3;
								}

								if (i == 0 || l < pos.getY() + j)
								{
									if ((i2 == pos.getX() - i1 || i2 == pos.getX() + i1) && (j1 == pos.getZ() - i1 || j1 == pos.getZ() + i1))
									{
										continue;
									}
									if (i2 == pos.getX() - (i1 - 1) && j1 == pos.getZ() - i1)
									{
										k1 = 1;
									}
									if (i2 == pos.getX() - i1 && j1 == pos.getZ() - (i1 - 1))
									{
										k1 = 1;
									}
									if (i2 == pos.getX() + i1 - 1 && j1 == pos.getZ() - i1)
									{
										k1 = 3;
									}
									if (i2 == pos.getX() + i1 && j1 == pos.getZ() - (i1 - 1))
									{
										k1 = 3;
									}
									if (i2 == pos.getX() - (i1 - 1) && j1 == pos.getZ() + i1)
									{
										k1 = 7;
									}
									if (i2 == pos.getX() - i1 && j1 == pos.getZ() + i1 - 1)
									{
										k1 = 7;
									}
									if (i2 == pos.getX() + i1 - 1 && j1 == pos.getZ() + i1)
									{
										k1 = 9;
									}
									if (i2 == pos.getX() + i1 && j1 == pos.getZ() + i1 - 1)
									{
										k1 = 9;
									}
								}

								if (k1 == 5 && l < pos.getY() + j)
								{
									k1 = 0;
								}

								if (k1 != 0 || pos.getY() >= pos.getY() + j - 1)
								{
									BlockPos blockpos1 = new BlockPos(i2, l, j1);

									if (world.getBlockState(blockpos1).getBlock().canBeReplacedByLeaves(world, blockpos1))
									{
										this.func_175905_a(world, blockpos1, FronosBlocks.sky_mushroom_block, k1);
									}
								}
							}
						}
					}

					for (l = 0; l < j; ++l)
					{
						BlockPos upN = pos.up(l);
						IBlockState state = world.getBlockState(upN);

						if (state.getBlock().canBeReplacedByLeaves(world, upN))
						{
							this.func_175905_a(world, pos.up(l), FronosBlocks.sky_mushroom_block, 10);
						}
					}
					return true;
				}
			}
		}
		else
		{
			return false;
		}
	}
}