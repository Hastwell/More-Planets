/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core.worldgen.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import stevekung.mods.moreplanets.asteroids.darkasteroids.dimension.WorldProviderDarkAsteroids;
import stevekung.mods.moreplanets.moons.io.blocks.IoBlocks;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.fronos.dimension.WorldProviderFronos;
import stevekung.mods.moreplanets.planets.siriusb.blocks.SiriusBBlocks;
import stevekung.mods.moreplanets.planets.siriusb.dimension.WorldProviderSiriusB;
import stevekung.mods.moreplanets.planets.venus.blocks.VenusBlocks;
import stevekung.mods.moreplanets.planets.venus.dimension.WorldProviderVenus;

public class WorldGenLiquidLakes extends WorldGenerator
{
    private Block block;

    public WorldGenLiquidLakes(Block block)
    {
        this.block = block;
    }

    @Override
    public boolean generate(World world, Random rand, int x, int y, int z)
    {
        x -= 8;

        for (z -= 8; y > 5 && world.isAirBlock(x, y, z); --y)
        {
        }

        if (y <= 4)
        {
            return false;
        }
        else
        {
            y -= 4;
            boolean[] aboolean = new boolean[2048];
            int l = rand.nextInt(4) + 4;
            int i1;

            for (i1 = 0; i1 < l; ++i1)
            {
                double d0 = rand.nextDouble() * 6.0D + 3.0D;
                double d1 = rand.nextDouble() * 4.0D + 2.0D;
                double d2 = rand.nextDouble() * 6.0D + 3.0D;
                double d3 = rand.nextDouble() * (16.0D - d0 - 2.0D) + 1.0D + d0 / 2.0D;
                double d4 = rand.nextDouble() * (8.0D - d1 - 4.0D) + 2.0D + d1 / 2.0D;
                double d5 = rand.nextDouble() * (16.0D - d2 - 2.0D) + 1.0D + d2 / 2.0D;

                for (int k1 = 1; k1 < 15; ++k1)
                {
                    for (int l1 = 1; l1 < 15; ++l1)
                    {
                        for (int i2 = 1; i2 < 7; ++i2)
                        {
                            double d6 = (k1 - d3) / (d0 / 2.0D);
                            double d7 = (i2 - d4) / (d1 / 2.0D);
                            double d8 = (l1 - d5) / (d2 / 2.0D);
                            double d9 = d6 * d6 + d7 * d7 + d8 * d8;

                            if (d9 < 1.0D)
                            {
                                aboolean[(k1 * 16 + l1) * 8 + i2] = true;
                            }
                        }
                    }
                }
            }

            int j1;
            int j2;
            boolean flag;

            for (i1 = 0; i1 < 16; ++i1)
            {
                for (j2 = 0; j2 < 16; ++j2)
                {
                    for (j1 = 0; j1 < 8; ++j1)
                    {
                        flag = !aboolean[(i1 * 16 + j2) * 8 + j1] && (i1 < 15 && aboolean[((i1 + 1) * 16 + j2) * 8 + j1] || i1 > 0 && aboolean[((i1 - 1) * 16 + j2) * 8 + j1] || j2 < 15 && aboolean[(i1 * 16 + j2 + 1) * 8 + j1] || j2 > 0 && aboolean[(i1 * 16 + j2 - 1) * 8 + j1] || j1 < 7 && aboolean[(i1 * 16 + j2) * 8 + j1 + 1] || j1 > 0 && aboolean[(i1 * 16 + j2) * 8 + j1 - 1]);

                        if (flag)
                        {
                            Material material = world.getBlock(x + i1, y + j1, z + j2).getMaterial();

                            if (j1 >= 4 && material.isLiquid())
                            {
                                return false;
                            }

                            if (j1 < 4 && !material.isSolid() && world.getBlock(x + i1, y + j1, z + j2) != this.block)
                            {
                                return false;
                            }
                        }
                    }
                }
            }

            for (i1 = 0; i1 < 16; ++i1)
            {
                for (j2 = 0; j2 < 16; ++j2)
                {
                    for (j1 = 0; j1 < 8; ++j1)
                    {
                        if (aboolean[(i1 * 16 + j2) * 8 + j1])
                        {
                            world.setBlock(x + i1, y + j1, z + j2, j1 >= 4 ? Blocks.air : this.block, 0, 2);
                        }
                    }
                }
            }

            for (i1 = 0; i1 < 16; ++i1)
            {
                for (j2 = 0; j2 < 16; ++j2)
                {
                    for (j1 = 4; j1 < 8; ++j1)
                    {
                        if (aboolean[(i1 * 16 + j2) * 8 + j1] && world.getBlock(x + i1, y + j1 - 1, z + j2) == Blocks.dirt && world.getSavedLightValue(EnumSkyBlock.Sky, x + i1, y + j1, z + j2) > 0)
                        {
                            BiomeGenBase biomegenbase = world.getBiomeGenForCoords(x + i1, z + j2);

                            if (biomegenbase.topBlock == Blocks.mycelium)
                            {
                                world.setBlock(x + i1, y + j1 - 1, z + j2, Blocks.mycelium, 0, 2);
                            }
                            else
                            {
                                world.setBlock(x + i1, y + j1 - 1, z + j2, Blocks.grass, 0, 2);
                            }
                        }
                    }
                }
            }

            if (this.block.getMaterial() == Material.lava)
            {
                for (i1 = 0; i1 < 16; ++i1)
                {
                    for (j2 = 0; j2 < 16; ++j2)
                    {
                        for (j1 = 0; j1 < 8; ++j1)
                        {
                            flag = !aboolean[(i1 * 16 + j2) * 8 + j1] && (i1 < 15 && aboolean[((i1 + 1) * 16 + j2) * 8 + j1] || i1 > 0 && aboolean[((i1 - 1) * 16 + j2) * 8 + j1] || j2 < 15 && aboolean[(i1 * 16 + j2 + 1) * 8 + j1] || j2 > 0 && aboolean[(i1 * 16 + j2 - 1) * 8 + j1] || j1 < 7 && aboolean[(i1 * 16 + j2) * 8 + j1 + 1] || j1 > 0 && aboolean[(i1 * 16 + j2) * 8 + j1 - 1]);

                            if (flag && (j1 < 4 || rand.nextInt(2) != 0) && world.getBlock(x + i1, y + j1, z + j2).getMaterial().isSolid())
                            {
                                if (world.provider instanceof WorldProviderSiriusB)
                                {
                                    world.setBlock(x + i1, y + j1, z + j2, SiriusBBlocks.sirius_b_block, 2, 2);
                                }
                                else if (world.provider instanceof WorldProviderFronos)
                                {
                                    world.setBlock(x + i1, y + j1, z + j2, FronosBlocks.fronos_block, 0, 2);
                                }
                                else if (world.provider instanceof WorldProviderVenus)
                                {
                                    world.setBlock(x + i1, y + j1, z + j2, VenusBlocks.venus_block, 2, 2);
                                }
                                else if (world.provider instanceof WorldProviderDarkAsteroids)
                                {
                                    world.setBlock(x + i1, y + j1, z + j2, IoBlocks.io_block, 5, 2);
                                }
                                else
                                {
                                    world.setBlock(x + i1, y + j1, z + j2, Blocks.stone, 0, 2);
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
}