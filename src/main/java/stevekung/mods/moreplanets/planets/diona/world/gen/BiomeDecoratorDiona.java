/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.world.gen;

import micdoodle8.mods.galacticraft.core.world.gen.WorldGenMinableMeta;
import net.minecraft.world.gen.feature.WorldGenerator;
import stevekung.mods.moreplanets.common.world.biome.BiomeDecoratorMP;
import stevekung.mods.moreplanets.planets.diona.blocks.DionaBlocks;

public class BiomeDecoratorDiona extends BiomeDecoratorMP
{
	private WorldGenerator dirtGen;
	private WorldGenerator quontoniumGen;
	private WorldGenerator fronisiumGen;
	private WorldGenerator aluminumGen;
	private WorldGenerator siliconGen;
	private WorldGenerator tinGen;
	private WorldGenerator copperGen;

	public BiomeDecoratorDiona()
	{
		this.dirtGen = new WorldGenMinableMeta(DionaBlocks.diona_block, 32, 1, true, DionaBlocks.diona_block, 2);
		this.quontoniumGen = new WorldGenMinableMeta(DionaBlocks.diona_block, 8, 4, true, DionaBlocks.diona_block, 2);
		this.fronisiumGen = new WorldGenMinableMeta(DionaBlocks.diona_block, 8, 5, true, DionaBlocks.diona_block, 2);
		this.tinGen = new WorldGenMinableMeta(DionaBlocks.diona_block, 8, 6, true, DionaBlocks.diona_block, 2);
		this.copperGen = new WorldGenMinableMeta(DionaBlocks.diona_block, 8, 7, true, DionaBlocks.diona_block, 2);
		this.siliconGen = new WorldGenMinableMeta(DionaBlocks.diona_block, 4, 8, true, DionaBlocks.diona_block, 2);
		this.aluminumGen = new WorldGenMinableMeta(DionaBlocks.diona_block, 8, 9, true, DionaBlocks.diona_block, 2);
	}

	@Override
	protected void generateOres()
	{
		this.generateOre(10, this.fronisiumGen, 0, 48);
		this.generateOre(12, this.aluminumGen, 0, 48);
		this.generateOre(16, this.tinGen, 0, 64);
		this.generateOre(16, this.copperGen, 0, 64);
		this.generateOre(24, this.quontoniumGen, 0, 64);
		this.generateOre(12, this.siliconGen, 0, 24);
		this.generateOre(32, this.dirtGen, 0, 255);
	}
}