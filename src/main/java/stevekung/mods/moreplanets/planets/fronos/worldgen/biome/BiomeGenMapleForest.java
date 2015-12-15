/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.worldgen.biome;

import java.util.Random;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import stevekung.mods.moreplanets.core.config.ConfigManagerMP;
import stevekung.mods.moreplanets.core.worldgen.feature.WorldGenTreeMP;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;

public class BiomeGenMapleForest extends BiomeGenBaseFronos
{
    public BiomeGenMapleForest()
    {
        super(ConfigManagerMP.idMapleForestBiome);
        this.enableRain = true;
		this.rainfall = 0.5F;
		this.temperature = 0.5F;
        this.topBlock = FronosBlocks.pink_grass;
        this.topMeta = 0;
        this.fillerBlock = FronosBlocks.fronos_dirt;
        this.fillerMeta = 0;
        this.stoneBlock = FronosBlocks.fronos_block;
        this.stoneMeta = 0;
        this.getBiomeDecorator().pinkTallGrassPerChunk = 200;
        this.getBiomeDecorator().deadBushPerChunk = 1;
        this.getBiomeDecorator().reedsPerChunk = 200;
        this.getBiomeDecorator().normalSandPerChunk = 3;
        this.getBiomeDecorator().fronosSandPerChunk = 2;
        this.getBiomeDecorator().whiteSandPerChunk = 2;
        this.getBiomeDecorator().cheeseSandPerChunk = 1;
        this.getBiomeDecorator().gravelPerChunk = 1;
        this.getBiomeDecorator().clayPerChunk = 1;
        this.getBiomeDecorator().lakesPerChunk = 1;
        this.getBiomeDecorator().littleSunFlowerPerChunk = 2;
        this.getBiomeDecorator().dandelionPerChunk = 12;
        this.getBiomeDecorator().poppyPerChunk = 12;
        this.getBiomeDecorator().redMapleTreePerChunk = 10;
        this.getBiomeDecorator().yellowMapleTreePerChunk = 4;
        this.getBiomeDecorator().purpleMapleTreePerChunk = 2;
        this.getBiomeDecorator().mapleIvyPerChunk = 8;
        this.getBiomeDecorator().bluePoisonMushroomPerChunk = 4;
        this.getBiomeDecorator().purpleSpikeFlowerPerChunk = 4;
    }

    @Override
    public WorldGenAbstractTree func_150567_a(Random rand)
    {
        WorldGenTreeMP red = new WorldGenTreeMP(FronosBlocks.fronos_log, FronosBlocks.fronos_leaves, 1, 0, false, 5, 4, false);
        WorldGenTreeMP yellow = new WorldGenTreeMP(FronosBlocks.fronos_log, FronosBlocks.fronos_leaves, 1, 1, false, 5, 4, false);
        WorldGenTreeMP purple = new WorldGenTreeMP(FronosBlocks.fronos_log, FronosBlocks.fronos_leaves, 1, 2, false, 5, 4, false);
        return rand.nextInt(10) == 0 ? purple : rand.nextInt(6) == 0 ? yellow : rand.nextInt(4) == 0 ? red : null;
    }
}