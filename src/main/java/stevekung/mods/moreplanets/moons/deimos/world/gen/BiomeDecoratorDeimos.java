/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.deimos.world.gen;

import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.gen.feature.WorldGenerator;
import stevekung.mods.moreplanets.common.world.biome.BiomeDecoratorMP;
import stevekung.mods.moreplanets.core.init.MPBlocks;
import stevekung.mods.moreplanets.moons.deimos.blocks.DeimosBlocks;

public class BiomeDecoratorDeimos extends BiomeDecoratorMP
{
	private WorldGenerator dirtGen;
	private WorldGenerator deshGen;
	private WorldGenerator ironGen;
	private WorldGenerator chondriteGen;
	private WorldGenerator tinGen;
	private WorldGenerator copperGen;

	public BiomeDecoratorDeimos()
	{
		this.dirtGen = new WorldGenMinableMeta(DeimosBlocks.deimos_block, 32, 1, true, DeimosBlocks.deimos_block, 2);
		this.deshGen = new WorldGenMinableMeta(DeimosBlocks.deimos_block, 6, 7, true, DeimosBlocks.deimos_block, 2);
		this.ironGen = new WorldGenMinableMeta(DeimosBlocks.deimos_block, 7, 6, true, DeimosBlocks.deimos_block, 2);
		this.tinGen = new WorldGenMinableMeta(DeimosBlocks.deimos_block, 7, 4, true, DeimosBlocks.deimos_block, 2);
		this.copperGen = new WorldGenMinableMeta(DeimosBlocks.deimos_block, 7, 5, true, DeimosBlocks.deimos_block, 2);
		this.chondriteGen = new WorldGenMinableMeta(MPBlocks.chondrite_rock, 32, 0, true, DeimosBlocks.deimos_block, 2);
	}

	@Override
	protected void generateOres()
	{
		this.generateOre(20, this.ironGen, 0, 64);
		this.generateOre(16, this.chondriteGen, 0, 256);
		this.generateOre(22, this.tinGen, 0, 60);
		this.generateOre(24, this.copperGen, 0, 75);
		this.generateOre(16, this.deshGen, 20, 64);
		this.generateOre(20, this.dirtGen, 0, 256);
	}
}