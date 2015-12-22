/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.world.gen;

import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import stevekung.mods.moreplanets.common.world.biome.BiomeDecoratorMP;
import stevekung.mods.moreplanets.common.world.gen.feature.WorldGenLiquidLakes;
import stevekung.mods.moreplanets.planets.venus.blocks.VenusBlocks;
import stevekung.mods.moreplanets.planets.venus.world.gen.feature.WorldGenSurfaceLava;

public class BiomeDecoratorVenus extends BiomeDecoratorMP
{
    private WorldGenerator dirtGen;
    private WorldGenerator ironGen;
    private WorldGenerator leadGen;
    private WorldGenerator sulfurGen;
    private WorldGenerator tinGen;
    private WorldGenerator copperGen;
    private WorldGenerator coalGen;
    private WorldGenerator goldGen;
    private WorldGenerator redstoneGen;
    private WorldGenerator sandGen;
    private WorldGenerator sandGen1;
    private WorldGenerator magmaGen;

    private int lavaLakePerChunk;

    public BiomeDecoratorVenus()
    {
        this.dirtGen = new WorldGenMinableMeta(VenusBlocks.venus_block, 32, 1, true, VenusBlocks.venus_block, 2);
        this.ironGen = new WorldGenMinableMeta(VenusBlocks.venus_block, 7, 9, true, VenusBlocks.venus_block, 2);
        this.sulfurGen = new WorldGenMinableMeta(VenusBlocks.venus_block, 7, 4, true, VenusBlocks.venus_block, 2);
        this.leadGen = new WorldGenMinableMeta(VenusBlocks.venus_block, 7, 5, true, VenusBlocks.venus_block, 2);
        this.tinGen = new WorldGenMinableMeta(VenusBlocks.venus_block, 7, 6, true, VenusBlocks.venus_block, 2);
        this.copperGen = new WorldGenMinableMeta(VenusBlocks.venus_block, 7, 7, true, VenusBlocks.venus_block, 2);
        this.coalGen = new WorldGenMinableMeta(VenusBlocks.venus_block, 16, 8, true, VenusBlocks.venus_block, 2);
        this.goldGen = new WorldGenMinableMeta(VenusBlocks.venus_block, 8, 10, true, VenusBlocks.venus_block, 2);
        this.redstoneGen = new WorldGenMinableMeta(VenusBlocks.venus_redstone_ore, 8, 0, true, VenusBlocks.venus_block, 2);
        this.sandGen = new WorldGenMinableMeta(VenusBlocks.venus_sand, 32, 0, true, VenusBlocks.venus_block, 0);
        this.sandGen1 = new WorldGenMinableMeta(VenusBlocks.venus_sand, 32, 0, true, VenusBlocks.venus_block, 1);
        this.magmaGen = new WorldGenMinableMeta(VenusBlocks.venus_magma_rock, 4, 0, true, VenusBlocks.venus_block, 2);

        this.lavaLakePerChunk = 8;
    }

    @Override
    protected void genDecorations(BiomeGenBase biome)
    {
        this.generateOre(20, this.dirtGen, 0, 256);
        this.generateOre(20, this.ironGen, 0, 64);
        this.generateOre(20, this.sulfurGen, 0, 64);
        this.generateOre(12, this.leadGen, 0, 48);
        this.generateOre(22, this.tinGen, 0, 60);
        this.generateOre(24, this.copperGen, 0, 75);
        this.generateOre(20, this.coalGen, 0, 256);
        this.generateOre(4, this.goldGen, 0, 32);
        this.generateOre(8, this.redstoneGen, 0, 16);
        this.generateOre(20, this.sandGen, 0, 256);
        this.generateOre(20, this.sandGen1, 0, 256);
        this.generateOre(20, this.magmaGen, 0, 128);

        for (int i = 0; i < this.lavaLakePerChunk; ++i)
        {
            if (this.randomGenerator.nextInt(20) == 0)
            {
                new WorldGenLiquidLakes(Blocks.lava, VenusBlocks.venus_block, 2).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(this.randomGenerator.nextInt(16) + 8, this.randomGenerator.nextInt(32 - 16) + 16, this.randomGenerator.nextInt(16) + 8));
            }
        }
        for (int i = 0; i < 16; ++i)
        {
            new WorldGenSurfaceLava().generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(this.randomGenerator.nextInt(16) + 8, this.randomGenerator.nextInt(256 - 16) + 16, this.randomGenerator.nextInt(16) + 8));
        }
    }
}