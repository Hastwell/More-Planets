/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.world.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import micdoodle8.mods.galacticraft.core.perlin.NoiseModule;
import micdoodle8.mods.galacticraft.core.perlin.generator.Gradient;
import micdoodle8.mods.galacticraft.core.world.gen.EnumCraterSize;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkProviderGenerate;
import stevekung.mods.moreplanets.planets.diona.entities.EntityEvolvedEnderman;

public abstract class ChunkProviderHillsBaseMP extends ChunkProviderGenerate
{
    protected World worldObj;
    protected Random rand;
    private Gradient noiseGen1;
    private Gradient noiseGen2;
    private Gradient noiseGen3;
    private Gradient noiseGen4;
    private Gradient noiseGen5;
    private Gradient noiseGen6;
    private Gradient noiseGen7;
    private NoiseModule noiseCraterGen;
    private int CHUNK_SIZE_X = 16;
    private int CHUNK_SIZE_Y = 256;
    private int CHUNK_SIZE_Z = 16;

    public ChunkProviderHillsBaseMP(World world, long seed, boolean genFeature)
    {
        super(world, seed, genFeature, "");
        this.worldObj = world;
        this.rand = new Random(seed);
        this.noiseGen1 = new Gradient(this.rand.nextLong(), 4, 0.25F);
        this.noiseGen2 = new Gradient(this.rand.nextLong(), 4, 0.25F);
        this.noiseGen3 = new Gradient(this.rand.nextLong(), 4, 0.25F);
        this.noiseGen4 = new Gradient(this.rand.nextLong(), 2, 0.25F);
        this.noiseGen5 = new Gradient(this.rand.nextLong(), 1, 0.25F);
        this.noiseGen6 = new Gradient(this.rand.nextLong(), 1, 0.25F);
        this.noiseGen7 = new Gradient(this.rand.nextLong(), 1, 0.25F);
        this.noiseCraterGen = new Gradient(this.rand.nextLong(), 1, 0.25F);
    }

    public void generateTerrain(int chunkX, int chunkZ, ChunkPrimer chunk)
    {
        this.noiseGen1.setFrequency(0.0125F);
        this.noiseGen2.setFrequency(0.015F);
        this.noiseGen3.setFrequency(0.01F);
        this.noiseGen4.setFrequency(0.02F);
        this.noiseGen5.setFrequency(0.01F);
        this.noiseGen6.setFrequency(0.001F);
        this.noiseGen7.setFrequency(0.005F);
        this.noiseCraterGen.setFrequency(0.02F);

        for (int x = 0; x < this.CHUNK_SIZE_X; x++)
        {
            for (int z = 0; z < this.CHUNK_SIZE_Z; z++)
            {
                double baseHeight = this.noiseGen1.getNoise(chunkX * 16 + x, chunkZ * 16 + z) * this.getMountainHeightList()[0];
                double smallHillHeight = this.noiseGen2.getNoise(chunkX * 16 + x, chunkZ * 16 + z) * this.getMountainHeightList()[1];
                double mountainHeight = Math.abs(this.noiseGen3.getNoise(chunkX * 16 + x, chunkZ * 16 + z));
                double valleyHeight = Math.abs(this.noiseGen4.getNoise(chunkX * 16 + x, chunkZ * 16 + z));
                double featureFilter = this.noiseGen5.getNoise(chunkX * 16 + x, chunkZ * 16 + z) * this.getMountainHeightList()[4];
                double largeFilter = this.noiseGen6.getNoise(chunkX * 16 + x, chunkZ * 16 + z) * this.getMountainHeightList()[6];
                double smallFilter = this.noiseGen7.getNoise(chunkX * 16 + x, chunkZ * 16 + z) * this.getMountainHeightList()[5] - 0.5;
                mountainHeight = this.lerp(smallHillHeight, mountainHeight * this.getMountainHeightList()[2], this.fade(this.clamp(mountainHeight * 2, 0, 1)));
                valleyHeight = this.lerp(smallHillHeight, valleyHeight * this.getMountainHeightList()[3] - this.getMountainHeightList()[3] + 9, this.fade(this.clamp((valleyHeight + 2) * 4, 0, 1)));
                double yDev = this.lerp(valleyHeight, mountainHeight, this.fade(largeFilter));
                yDev = this.lerp(smallHillHeight, yDev, smallFilter);
                yDev = this.lerp(baseHeight, yDev, featureFilter);

                for (int y = 0; y < this.CHUNK_SIZE_Y; y++)
                {
                    if (y < this.getTerrainHeight() + yDev)
                    {
                        chunk.setBlockState(this.getIndex(x, y, z), this.getBaseBlock().getStateFromMeta(this.getBlockMetadata()[2]));
                    }
                }
            }
        }
    }

    private double lerp(double d1, double d2, double t)
    {
        if (t < 0.0)
        {
            return d1;
        }
        else if (t > 1.0)
        {
            return d2;
        }
        else
        {
            return d1 + (d2 - d1) * t;
        }
    }

    private double fade(double n)
    {
        return n * n * n * (n * (n * 6 - 15) + 10);
    }

    private double clamp(double x, double min, double max)
    {
        if (x < min)
        {
            return min;
        }
        if (x > max)
        {
            return max;
        }
        return x;
    }

    @Override
    public void replaceBlocksForBiome(int x, int z, ChunkPrimer chunk, BiomeGenBase[] biomeGen)
    {
        int var5 = 20;
        float var6 = 0.03125F;
        this.noiseGen4.setFrequency(var6 * 2);

        for (int var8 = 0; var8 < 16; ++var8)
        {
            for (int var9 = 0; var9 < 16; ++var9)
            {
                int var12 = (int) (this.noiseGen4.getNoise(x * 16 + var8, z * 16 + var9) / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
                int var13 = -1;
                Block topBlock = this.getBaseBlock();
                int topBlockMeta = this.getBlockMetadata()[0];
                Block fillBlock = this.getBaseBlock();
                int fillBlockMeta = this.getBlockMetadata()[1];

                for (int var16 = this.CHUNK_SIZE_Y - 1; var16 >= 0; --var16)
                {
                    int index = this.getIndex(var8, var16, var9);

                    if (var16 <= 0 + this.rand.nextInt(5))
                    {
                        chunk.setBlockState(index, Blocks.bedrock.getDefaultState());
                    }
                    else
                    {
                        Block block = chunk.getBlockState(index).getBlock();

                        if (Blocks.air == block)
                        {
                            var13 = -1;
                        }
                        else if (block == this.getBaseBlock())
                        {
                            if (var13 == -1)
                            {
                                if (var12 <= 0)
                                {
                                    topBlock = Blocks.air;
                                    topBlockMeta = 0;
                                    fillBlock = this.getBaseBlock();
                                    fillBlockMeta = this.getBlockMetadata()[1];
                                }
                                else if (var16 >= var5 - -16 && var16 <= var5 + 1)
                                {
                                    topBlock = this.getBaseBlock();
                                    topBlockMeta = this.getBlockMetadata()[0];
                                    topBlock = this.getBaseBlock();
                                    topBlockMeta = this.getBlockMetadata()[1];
                                }

                                var13 = var12;

                                if (var16 >= var5 - 1)
                                {
                                    chunk.setBlockState(index, topBlock.getStateFromMeta(topBlockMeta));
                                }
                                else if (var16 < var5 - 1 && var16 >= var5 - 2)
                                {
                                    chunk.setBlockState(index, fillBlock.getStateFromMeta(fillBlockMeta));
                                }
                            }
                            else if (var13 > 0)
                            {
                                --var13;
                                chunk.setBlockState(index, fillBlock.getStateFromMeta(fillBlockMeta));
                            }
                        }
                    }
                }
            }
        }
    }

    public void createCraters(int chunkX, int chunkZ, ChunkPrimer chunk)
    {
        for (int cx = chunkX - 2; cx <= chunkX + 2; cx++)
        {
            for (int cz = chunkZ - 2; cz <= chunkZ + 2; cz++)
            {
                for (int x = 0; x < this.CHUNK_SIZE_X; x++)
                {
                    for (int z = 0; z < this.CHUNK_SIZE_Z; z++)
                    {
                        if (Math.abs(this.randFromPoint(cx * 16 + x, (cz * 16 + z) * 1000)) < this.noiseCraterGen.getNoise(x * this.CHUNK_SIZE_X + x, cz * this.CHUNK_SIZE_Z + z) / this.getCraterChance())
                        {
                            Random random = new Random(cx * 16 + x + (cz * 16 + z) * 5000);
                            EnumCraterSize cSize = EnumCraterSize.sizeArray[random.nextInt(EnumCraterSize.sizeArray.length)];
                            int size = random.nextInt(cSize.MAX_SIZE - cSize.MIN_SIZE) + cSize.MIN_SIZE;
                            this.makeCrater(cx * 16 + x, cz * 16 + z, chunkX * 16, chunkZ * 16, size, chunk);
                        }
                    }
                }
            }
        }
    }

    public void makeCrater(int craterX, int craterZ, int chunkX, int chunkZ, int size, ChunkPrimer chunk)
    {
        for (int x = 0; x < this.CHUNK_SIZE_X; x++)
        {
            for (int z = 0; z < this.CHUNK_SIZE_Z; z++)
            {
                double xDev = craterX - (chunkX + x);
                double zDev = craterZ - (chunkZ + z);

                if (xDev * xDev + zDev * zDev < size * size)
                {
                    xDev /= size;
                    zDev /= size;
                    double sqrtY = xDev * xDev + zDev * zDev;
                    double yDev = sqrtY * sqrtY * 6;
                    yDev = 5 - yDev;
                    int helper = 0;

                    for (int y = 127; y > 0; y--)
                    {
                        if (Blocks.air != chunk.getBlockState(this.getIndex(x, y, z)).getBlock() && helper <= yDev)
                        {
                            chunk.setBlockState(this.getIndex(x, y, z), Blocks.air.getDefaultState());
                            helper++;
                        }
                        if (helper > yDev)
                        {
                            break;
                        }
                    }
                }
            }
        }
    }

    private int getIndex(int x, int y, int z)
    {
        return (x * 16 + z) * 256 + y;
    }

    private double randFromPoint(int x, int z)
    {
        int n;
        n = x + z * 57;
        n = n << 13 ^ n;
        return 1.0 - (n * (n * n * 15731 + 789221) + 1376312589 & 0x7fffffff) / 1073741824.0;
    }

    @Override
    public boolean chunkExists(int x, int z)
    {
        return true;
    }

    @Override
    public boolean saveChunks(boolean save, IProgressUpdate update)
    {
        return true;
    }

    @Override
    public boolean canSave()
    {
        return true;
    }

    @Override
    public String makeString()
    {
        return this.getName() + "LevelSource";
    }

    @Override
    public List getPossibleCreatures(EnumCreatureType type, BlockPos pos)
    {
        if (type == EnumCreatureType.MONSTER)
        {
            List monsters = new ArrayList();
            monsters.add(new SpawnListEntry(EntityEvolvedZombie.class, 100, 4, 4));
            monsters.add(new SpawnListEntry(EntityEvolvedSpider.class, 100, 4, 4));
            monsters.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 100, 4, 4));
            monsters.add(new SpawnListEntry(EntityEvolvedCreeper.class, 100, 4, 4));
            monsters.add(new SpawnListEntry(EntityEvolvedEnderman.class, 10, 1, 4));
            return monsters;
        }
        return null;
    }

    protected int getCraterChance()
    {
        return 2000;
    }

    protected int getTerrainHeight()
    {
        return 86;
    }

    /**
     * 
     * @param 0: TERRAIN_HEIGHT_MOD
     * @param 1: SMALL_FEATURE_HEIGHT_MOD
     * @param 2: MOUNTAIN_HEIGHT_MOD
     * @param 3: VALLEY_HEIGHT_MOD
     * @param 4: MAIN_FEATURE_FILTER_MOD
     * @param 5: SMALL_FEATURE_FILTER_MOD
     * @param 6: LARGE_FEATURE_FILTER_MOD
     * 
     */
    protected double[] getMountainHeightList()
    {
        return new double[] { 18, 26, 95, 50, 4, 8, 8 };
    }

    protected abstract String getName();
    protected abstract Block getBaseBlock();
    protected abstract int[] getBlockMetadata();
}