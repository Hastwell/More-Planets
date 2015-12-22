/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.nibiru.world.gen;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import stevekung.mods.moreplanets.planets.nibiru.blocks.NibiruBlocks;

public class MapGenCavernNibiru extends MapGenBase
{
    protected int range = 12;

    @Override
    public void generate(IChunkProvider provider, World world, int chunkX, int chunkZ, ChunkPrimer chunk)
    {
        int var6 = this.range;
        long var7 = this.rand.nextLong();
        long var9 = this.rand.nextLong();

        for (int x = chunkX - var6; x <= chunkX + var6; ++x)
        {
            for (int z = chunkZ - var6; z <= chunkZ + var6; ++z)
            {
                long var13 = x * var7;
                long var15 = z * var9;
                this.rand.setSeed(var13 ^ var15 ^ world.getSeed());
                this.recursiveGenerate(world, x, z, chunkX, chunkZ, chunk);
            }
        }
    }

    @Override
    protected void recursiveGenerate(World world, int xChunkCoord, int zChunkCoord, int origXChunkCoord, int origZChunkCoord, ChunkPrimer chunk)
    {
        if (this.rand.nextInt(100) == 0)
        {
            double xPos = xChunkCoord * 16 + this.rand.nextInt(16);
            double yPos = 25;
            double zPos = zChunkCoord * 16 + this.rand.nextInt(16);
            this.generateLargeCaveNode(this.rand.nextLong(), origXChunkCoord, origZChunkCoord, chunk, xPos, yPos, zPos);
        }
    }

    protected void generateLargeCaveNode(long seed, int origXChunkCoord, int origZChunkCoord, ChunkPrimer chunk, double xPos, double yPos, double zPos)
    {
        this.generateCaveNode(seed, origXChunkCoord, origZChunkCoord, chunk, xPos, yPos, zPos, 1.0F + this.rand.nextFloat() * 6.0F, 10.0F, 10.0F, -1, -1, 0.2D);
    }

    protected void generateCaveNode(long seed, int origXChunkCoord, int origZChunkCoord, ChunkPrimer chunk, double xPos, double yPos, double zPos, float par12, float par13, float par14, int par15, int par16, double heightMultiplier)
    {
        double var19 = origXChunkCoord * 16 + 8;
        double var21 = origZChunkCoord * 16 + 8;
        float var23 = 0.0F;
        float var24 = 0.0F;
        Random var25 = new Random(seed);

        if (par16 <= 0)
        {
            int var26 = this.range * 16 - 16;
            par16 = var26 - var25.nextInt(var26 / 4);
        }

        boolean var54 = false;

        if (par15 == -1)
        {
            par15 = par16 / 2;
            var54 = true;
        }

        int var27 = var25.nextInt(par16 / 2) + par16 / 4;

        for (boolean var28 = var25.nextInt(6) == 0; par15 < par16; ++par15)
        {
            double caveWidth = 40;
            double caveHeight = caveWidth * heightMultiplier;

            if (var28)
            {
                par14 *= 0.92F;
            }
            else
            {
                par14 *= 0.7F;
            }

            par14 += var24 * 0.1F;
            par13 += var23 * 0.1F;
            var24 *= 0.9F;
            var23 *= 0.75F;
            var24 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 2.0F;
            var23 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 4.0F;

            if (!var54 && par15 == var27 && par12 > 1.0F && par16 > 0)
            {
                return;
            }

            if (var54 || var25.nextInt(4) != 0)
            {
                double var35 = xPos - var19;
                double var37 = zPos - var21;
                double var39 = par16 - par15;
                double var41 = par12 + 2.0F + 16.0F;

                if (var35 * var35 + var37 * var37 - var39 * var39 > var41 * var41)
                {
                    return;
                }

                if (xPos >= var19 - 16.0D - caveWidth * 2.0D && zPos >= var21 - 16.0D - caveWidth * 2.0D && xPos <= var19 + 16.0D + caveWidth * 2.0D && zPos <= var21 + 16.0D + caveWidth * 2.0D) // CHECKED
                {
                    int caveMinX = MathHelper.floor_double(xPos - caveWidth) - origXChunkCoord * 16 - 1;
                    int caveMaxX = MathHelper.floor_double(xPos + caveWidth) - origXChunkCoord * 16 + 1;
                    int caveMinY = MathHelper.floor_double(yPos - caveHeight) - 1;
                    int caveMaxY = MathHelper.floor_double(yPos + caveHeight) + 1;
                    int caveMinZ = MathHelper.floor_double(zPos - caveWidth) - origZChunkCoord * 16 - 1;
                    int caveMaxZ = MathHelper.floor_double(zPos + caveWidth) - origZChunkCoord * 16 + 1;

                    if (caveMinX < 0)
                    {
                        caveMinX = 0;
                    }
                    if (caveMaxX > 16)
                    {
                        caveMaxX = 16;
                    }
                    if (caveMinY < 1)
                    {
                        caveMinY = 1;
                    }
                    if (caveMaxY > 65)
                    {
                        caveMaxY = 65;
                    }
                    if (caveMinZ < 0)
                    {
                        caveMinZ = 0;
                    }
                    if (caveMaxZ > 16)
                    {
                        caveMaxZ = 16;
                    }

                    boolean isBlockWater = false;
                    int var42;
                    int var45;

                    for (var42 = caveMinX; !isBlockWater && var42 < caveMaxX; ++var42)
                    {
                        for (int var43 = caveMinZ; !isBlockWater && var43 < caveMaxZ; ++var43)
                        {
                            for (int var44 = caveMaxY + 1; !isBlockWater && var44 >= caveMinY - 1; --var44)
                            {
                                var45 = (var42 * 16 + var43) * 128 + var44;

                                if (var44 >= 0 && var44 < 128)
                                {
                                    if (var44 != caveMinY - 1 && var42 != caveMinX && var42 != caveMaxX - 1 && var43 != caveMinZ && var43 != caveMaxZ - 1)
                                    {
                                        var44 = caveMinY;
                                    }
                                }
                            }
                        }
                    }

                    for (var42 = caveMinX; var42 < caveMaxX; ++var42)
                    {
                        double var59 = (var42 + origXChunkCoord * 16 + 0.5D - xPos) / caveWidth;

                        for (var45 = caveMinZ; var45 < caveMaxZ; ++var45)
                        {
                            double var46 = (var45 + origZChunkCoord * 16 + 0.5D - zPos) / caveWidth;

                            if (var59 * var59 + var46 * var46 < 1.0D)
                            {
                                for (int var50 = caveMaxY - 1; var50 >= caveMinY; --var50)
                                {
                                    double var51 = (var50 + 0.5D - yPos) / caveHeight;

                                    if (var59 * var59 + var51 * var51 + var46 * var46 < 1.0D)
                                    {
                                        if (var51 > -0.7D)
                                        {
                                            int coords = (var42 * 16 + var45) * 256 + var50;

                                            if (chunk.getBlockState(coords).getBlock() == NibiruBlocks.nibiru_block)
                                            {
                                                chunk.setBlockState(coords, Blocks.air.getDefaultState());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    for (var42 = caveMinX; var42 < caveMaxX; ++var42)
                    {
                        double var59 = (var42 + origXChunkCoord * 16 + 0.5D - xPos) / caveWidth;

                        for (var45 = caveMinZ; var45 < caveMaxZ; ++var45)
                        {
                            double var46 = (var45 + origZChunkCoord * 16 + 0.5D - zPos) / caveWidth;

                            if (var59 * var59 + var46 * var46 < 1.0D)
                            {
                                for (int var50 = caveMaxY - 1; var50 >= caveMinY; --var50)
                                {
                                    double var51 = (var50 + 0.5D - yPos) / caveHeight;

                                    if (var59 * var59 + var51 * var51 + var46 * var46 < 1.0D)
                                    {
                                        if (var51 > -0.7D)
                                        {
                                            int coords = (var42 * 16 + var45) * 256 + var50;
                                            int coordsAbove = (var42 * 16 + var45) * 256 + var50 + 1;
                                            int coordsBelow = (var42 * 16 + var45) * 256 + var50 - 1;

                                            if (Blocks.air.getDefaultState() == chunk.getBlockState(coords))
                                            {
                                                if (chunk.getBlockState(coordsAbove).getBlock() == NibiruBlocks.nibiru_block)
                                                {
                                                    if (this.rand.nextInt(2000) == 0)
                                                    {
                                                        int modifier = 0;

                                                        while (Blocks.air.getDefaultState() == chunk.getBlockState(coordsBelow))
                                                        {
                                                            chunk.setBlockState(coordsBelow, NibiruBlocks.infected_cavernous_vine.getDefaultState());
                                                            modifier--;
                                                            coordsBelow = (var42 * 16 + var45) * 256 + var50 - 1 + modifier;
                                                        }
                                                    }
                                                }
                                                else if (chunk.getBlockState(coordsBelow).getBlock() == NibiruBlocks.nibiru_block)
                                                {
                                                    if (this.rand.nextInt(1500) == 0)
                                                    {
                                                        chunk.setBlockState(coords, GCBlocks.crudeOil.getDefaultState());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}