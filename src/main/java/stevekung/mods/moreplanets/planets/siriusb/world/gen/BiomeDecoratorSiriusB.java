/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.world.gen;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import stevekung.mods.moreplanets.common.world.biome.BiomeDecoratorMP;
import stevekung.mods.moreplanets.common.world.gen.feature.WorldGenLiquidLakes;
import stevekung.mods.moreplanets.planets.siriusb.blocks.SiriusBBlocks;

public class BiomeDecoratorSiriusB extends BiomeDecoratorMP
{
	private WorldGenerator dirtGen;
	private WorldGenerator cobblestoneGen;
	private WorldGenerator diamondGen;
	private WorldGenerator sulfurGen;
	private WorldGenerator glowstoneGen;

	private int lavaLakePerChunk;

	public BiomeDecoratorSiriusB()
	{
		this.dirtGen = new WorldGenMinableMeta(SiriusBBlocks.sirius_b_block, 32, 1, true, SiriusBBlocks.sirius_b_block, 2);
		this.cobblestoneGen = new WorldGenMinableMeta(SiriusBBlocks.sirius_b_block, 4, 3, true, SiriusBBlocks.sirius_b_block, 2);
		this.sulfurGen = new WorldGenMinableMeta(SiriusBBlocks.sirius_b_block, 8, 4, true, SiriusBBlocks.sirius_b_block, 2);
		this.diamondGen = new WorldGenMinableMeta(SiriusBBlocks.sirius_b_block, 8, 5, true, SiriusBBlocks.sirius_b_block, 2);
		this.glowstoneGen = new WorldGenMinableMeta(SiriusBBlocks.sirius_b_block, 4, 6, true, SiriusBBlocks.sirius_b_block, 2);

		this.lavaLakePerChunk = 8;
	}

	@Override
	public void decorate(World world, Random rand, BiomeGenBase biome, BlockPos pos)
	{
		this.generateOre(32, this.dirtGen, 0, 255);
		this.generateOre(10, this.cobblestoneGen, 0, 128);
		this.generateOre(12, this.sulfurGen, 0, 48);
		this.generateOre(16, this.diamondGen, 0, 16);
		this.generateOre(16, this.glowstoneGen, 0, 255);

		int i;
		int x;
		int y;
		int z;

		for (i = 0; i < this.lavaLakePerChunk; ++i)
		{
			if (this.randomGenerator.nextInt(20) == 0)
			{
				x = this.randomGenerator.nextInt(16) + 8;
				y = this.randomGenerator.nextInt(32 - 16) + 16;
				z = this.randomGenerator.nextInt(16) + 8;
				new WorldGenLiquidLakes(SiriusBBlocks.sirius_lava).generate(this.currentWorld, this.randomGenerator, new BlockPos(x, y, z));
			}
		}
	}
}