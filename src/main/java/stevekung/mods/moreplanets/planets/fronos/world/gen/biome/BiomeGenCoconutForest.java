/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.world.gen.biome;

import stevekung.mods.moreplanets.common.config.ConfigManagerMP;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;

public class BiomeGenCoconutForest extends BiomeGenBaseFronos
{
	public BiomeGenCoconutForest()
	{
		super(ConfigManagerMP.idCoconutForestBiome);
		this.enableRain = true;
		this.enableSnow = true;
		this.topBlock = FronosBlocks.fronos_grass.getDefaultState();
		this.fillerBlock = FronosBlocks.fronos_dirt.getDefaultState();
		this.stoneBlock = FronosBlocks.fronos_block.getDefaultState();
		this.getBiomeDecorator().fronosTallGrassPerChunk = 200;
		this.getBiomeDecorator().coconutTreePerChunk = 64;
		this.getBiomeDecorator().deadBushPerChunk = 5;
		this.getBiomeDecorator().reedsPerChunk = 200;
		this.getBiomeDecorator().normalSandPerChunk = 3;
		this.getBiomeDecorator().fronosSandPerChunk = 2;
		this.getBiomeDecorator().whiteSandPerChunk = 2;
		this.getBiomeDecorator().cheeseSandPerChunk = 1;
		this.getBiomeDecorator().gravelPerChunk = 1;
		this.getBiomeDecorator().clayPerChunk = 1;
		this.getBiomeDecorator().lakesPerChunk = 1;
		this.getBiomeDecorator().littleSunFlowerPerChunk = 12;
		this.getBiomeDecorator().dandelionPerChunk = 6;
		this.getBiomeDecorator().poppyPerChunk = 8;
		this.getBiomeDecorator().waterlilyPerChunk = 5;
		this.getBiomeDecorator().redMapleTreePerChunk = -999;
		this.getBiomeDecorator().yellowMapleTreePerChunk = -999;
		this.getBiomeDecorator().purpleMapleTreePerChunk = -999;
	}
}