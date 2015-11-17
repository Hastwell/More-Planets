/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.deimos.world.gen;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import stevekung.mods.moreplanets.core.init.MPBlocks;
import stevekung.mods.moreplanets.moons.deimos.blocks.DeimosBlocks;

public class BiomeDecoratorDeimos extends BiomeDecorator
{
	private WorldGenerator dirtGen;
	private WorldGenerator deshGen;
	private WorldGenerator ironGen;
	private WorldGenerator chondriteGen;
	private WorldGenerator tinGen;
	private WorldGenerator copperGen;

	public BiomeDecoratorDeimos()
	{
		// Block,NumberOfBlock,Meta,IsMeta,FillBlock,FillMeta
		this.dirtGen = new WorldGenMinableMeta(DeimosBlocks.deimos_block, 32, 1, true, DeimosBlocks.deimos_block, 2);
		this.deshGen = new WorldGenMinableMeta(DeimosBlocks.deimos_block, 8, 7, true, DeimosBlocks.deimos_block, 2);
		this.ironGen = new WorldGenMinableMeta(DeimosBlocks.deimos_block, 8, 6, true, DeimosBlocks.deimos_block, 2);
		this.tinGen = new WorldGenMinableMeta(DeimosBlocks.deimos_block, 8, 4, true, DeimosBlocks.deimos_block, 2);
		this.copperGen = new WorldGenMinableMeta(DeimosBlocks.deimos_block, 8, 5, true, DeimosBlocks.deimos_block, 2);
		this.chondriteGen = new WorldGenMinableMeta(MPBlocks.chondrite_rock, 32, 0, true, DeimosBlocks.deimos_block, 2);
	}

	@Override
	public void decorate(World world, Random rand, BiomeGenBase biome, BlockPos pos)
	{
		this.currentWorld = world;
		this.randomGenerator = rand;
		this.field_180294_c = pos;
		this.generateOres();
		this.currentWorld = null;
		this.randomGenerator = null;
	}

	protected void generateOres()
	{
		this.generateOre(16, this.ironGen, 0, 64);
		this.generateOre(16, this.chondriteGen, 0, 128);
		this.generateOre(16, this.tinGen, 0, 64);
		this.generateOre(16, this.copperGen, 0, 64);
		this.generateOre(16, this.deshGen, 20, 48);
		this.generateOre(32, this.dirtGen, 0, 255);
	}

	protected void generateOre(int amount, WorldGenerator worldGen, int minY, int maxY)
	{
		int i;

		if (maxY < minY)
		{
			i = minY;
			minY = maxY;
			maxY = i;
		}
		else if (maxY == minY)
		{
			if (minY < 255)
			{
				++maxY;
			}
			else
			{
				--minY;
			}
		}

		for (i = 0; i < amount; ++i)
		{
			BlockPos blockpos = this.field_180294_c.add(this.randomGenerator.nextInt(16), this.randomGenerator.nextInt(maxY - minY) + minY, this.randomGenerator.nextInt(16));
			worldGen.generate(this.currentWorld, this.randomGenerator, blockpos);
		}
	}
}