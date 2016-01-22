/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.world.gen.biome;

import java.util.Random;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import stevekung.mods.moreplanets.common.world.biome.BiomeGenBaseMP;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.fronos.world.gen.BiomeDecoratorFronos;

public class BiomeGenBaseFronos extends BiomeGenBaseMP
{
    public static BiomeGenBase coconutForest = new BiomeGenCoconutForest().setBiomeName("Coconut Forest").setEnableSnow().setTemperatureRainfall(0.8F, 0.9F).setHeight(new Height(0.1F, 0.2F));
    public static BiomeGenBase goldenField = new BiomeGenGoldenField().setBiomeName("Golden Field").setEnableSnow().setTemperatureRainfall(0.95F, 0.9F).setHeight(new Height(0.125F, 0.05F));
    public static BiomeGenBase purpleMapleForest = new BiomeGenPurpleMapleForest().setBiomeName("Purple Maple Forest").setTemperatureRainfall(0.8F, 0.9F).setHeight(new Height(0.1F, 0.2F));
    public static BiomeGenBase mapleForest = new BiomeGenMapleForest().setBiomeName("Maple Forest").setTemperatureRainfall(0.8F, 0.9F).setHeight(new Height(0.1F, 0.2F));
    public static BiomeGenBase grassyPlains = new BiomeGenGrassyPlains().setBiomeName("Grassy Plains").setTemperatureRainfall(0.95F, 0.9F).setHeight(new Height(0.125F, 0.05F));
    public static BiomeGenBase candyLand = new BiomeGenCandyLand().setBiomeName("Candy Land").setTemperatureRainfall(0.95F, 0.9F).setHeight(new Height(0.125F, 0.05F));

    protected IBlockState stoneBlock;

    public BiomeGenBaseFronos(int id)
    {
        super(id);
        this.enableRain = true;
        this.enableSnow = true;
        this.topBlock = FronosBlocks.fronos_grass.getDefaultState();
        this.fillerBlock = FronosBlocks.fronos_dirt.getDefaultState();
        this.getBiomeDecorator().strawberryCloudPerChunk = 8;
        this.getBiomeDecorator().rainbowCloudPerChunk = 1;
        this.getBiomeDecorator().coralPerChunk = 36;
        this.getBiomeDecorator().dungeonSpawnerPerChunk = 32;
        this.getBiomeDecorator().spaceShellPerChunk = 128;
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.flowersPerChunk = -999;
        this.theBiomeDecorator.grassPerChunk = -999;
    }

    @Override
    public BiomeDecorator createBiomeDecorator()
    {
        return new BiomeDecoratorFronos();
    }

    protected BiomeDecoratorFronos getBiomeDecorator()
    {
        return (BiomeDecoratorFronos)this.theBiomeDecorator;
    }

    @Override
    public void genTerrainBlocks(World world, Random rand, ChunkPrimer chunk, int x, int z, double stoneNoise)
    {
        this.genFronosBiomeTerrain(rand, chunk, x, z, stoneNoise);
    }

    public void genFronosBiomeTerrain(Random rand, ChunkPrimer chunk, int x, int z, double stoneNoise)
    {
        IBlockState iblockstate = this.topBlock;
        IBlockState iblockstate1 = this.fillerBlock;
        int k = -1;
        int l = (int)(stoneNoise / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int i1 = x & 15;
        int j1 = z & 15;

        for (int k1 = 255; k1 >= 0; --k1)
        {
            if (k1 <= rand.nextInt(5))
            {
                chunk.setBlockState(j1, k1, i1, Blocks.bedrock.getDefaultState());
            }
            else
            {
                IBlockState iblockstate2 = chunk.getBlockState(j1, k1, i1);

                if (iblockstate2.getBlock().getMaterial() == Material.air)
                {
                    k = -1;
                }
                else if (iblockstate2.getBlock() == FronosBlocks.fronos_block)
                {
                    if (k == -1)
                    {
                        if (l <= 0)
                        {
                            iblockstate = null;
                            iblockstate1 = this.stoneBlock;
                        }
                        else if (k1 >= 59 && k1 <= 64)
                        {
                            iblockstate = this.topBlock;
                            iblockstate1 = this.fillerBlock;
                        }

                        if (k1 < 63 && (iblockstate == null || iblockstate.getBlock().getMaterial() == Material.air))
                        {
                            if (this.getFloatTemperature(new BlockPos(x, k1, z)) < 0.15F)
                            {
                                iblockstate = Blocks.ice.getDefaultState();
                            }
                            else
                            {
                                iblockstate = Blocks.water.getDefaultState();
                            }
                        }

                        k = l;

                        if (k1 >= 62)
                        {
                            chunk.setBlockState(j1, k1, i1, iblockstate);
                        }
                        else if (k1 < 56 - l)
                        {
                            iblockstate = null;
                            iblockstate1 = this.stoneBlock;
                            chunk.setBlockState(j1, k1, i1, Blocks.gravel.getDefaultState());
                        }
                        else
                        {
                            chunk.setBlockState(j1, k1, i1, iblockstate1);
                        }
                    }
                    else if (k > 0)
                    {
                        --k;
                        chunk.setBlockState(j1, k1, i1, iblockstate1);

                        if (k == 0 && iblockstate1.getBlock() == Blocks.sand)
                        {
                            k = rand.nextInt(4) + Math.max(0, k1 - 63);
                            iblockstate1 = iblockstate1.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND ? Blocks.red_sandstone.getDefaultState() : Blocks.sandstone.getDefaultState();
                        }
                    }
                }
            }
        }
    }
}