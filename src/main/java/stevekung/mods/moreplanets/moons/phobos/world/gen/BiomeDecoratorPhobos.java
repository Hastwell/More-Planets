/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.phobos.world.gen;

import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.gen.feature.WorldGenerator;
import stevekung.mods.moreplanets.common.world.biome.BiomeDecoratorMP;
import stevekung.mods.moreplanets.core.init.MPBlocks;
import stevekung.mods.moreplanets.moons.deimos.blocks.DeimosBlocks;

public class BiomeDecoratorPhobos extends BiomeDecoratorMP
{
	private WorldGenerator dirtGen;
	private WorldGenerator deshGen;
	private WorldGenerator ironGen;
	private WorldGenerator chondriteGen;
	private WorldGenerator tinGen;
	private WorldGenerator copperGen;

	public BiomeDecoratorPhobos()
	{
		this.dirtGen = new WorldGenMinableMeta(DeimosBlocks.deimos_block, 32, 1, true, DeimosBlocks.deimos_block, 2);
		this.deshGen = new WorldGenMinableMeta(DeimosBlocks.deimos_block, 8, 7, true, DeimosBlocks.deimos_block, 2);
		this.ironGen = new WorldGenMinableMeta(DeimosBlocks.deimos_block, 8, 6, true, DeimosBlocks.deimos_block, 2);
		this.tinGen = new WorldGenMinableMeta(DeimosBlocks.deimos_block, 8, 4, true, DeimosBlocks.deimos_block, 2);
		this.copperGen = new WorldGenMinableMeta(DeimosBlocks.deimos_block, 8, 5, true, DeimosBlocks.deimos_block, 2);
		this.chondriteGen = new WorldGenMinableMeta(MPBlocks.chondrite_rock, 32, 0, true, DeimosBlocks.deimos_block, 2);
	}

	@Override
	protected void generateOres()
	{
		this.generateOre(16, this.ironGen, 0, 64);
		this.generateOre(16, this.chondriteGen, 0, 128);
		this.generateOre(16, this.tinGen, 0, 64);
		this.generateOre(16, this.copperGen, 0, 64);
		this.generateOre(16, this.deshGen, 20, 48);
		this.generateOre(32, this.dirtGen, 0, 255);
	}
}