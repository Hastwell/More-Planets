/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.world.gen.biome;

import stevekung.mods.moreplanets.common.config.ConfigManagerMP;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockFrostedCake;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;

public class BiomeGenCandyLand extends BiomeGenBaseFronos
{
	public BiomeGenCandyLand()
	{
		super(ConfigManagerMP.idCandyLandBiome);
		this.enableRain = true;
		this.enableSnow = true;
		this.topBlock = FronosBlocks.frosted_cake.getDefaultState().withProperty(BlockFrostedCake.VARIANT, BlockFrostedCake.BlockType.frosted_white_cake_block);
		this.fillerBlock = FronosBlocks.frosted_cake.getDefaultState();
		this.stoneBlock = FronosBlocks.fronos_block.getDefaultState();
		this.getBiomeDecorator().reedsPerChunk = -999;
		this.getBiomeDecorator().normalSandPerChunk = -999;
		this.getBiomeDecorator().fronosSandPerChunk = -999;
		this.getBiomeDecorator().whiteSandPerChunk = -999;
		this.getBiomeDecorator().cheeseSandPerChunk = -999;
		this.getBiomeDecorator().gravelPerChunk = -999;
		this.getBiomeDecorator().clayPerChunk = -999;
		this.getBiomeDecorator().lakesPerChunk = -999;
		this.getBiomeDecorator().coralPerChunk = -999;
		this.getBiomeDecorator().spaceShellPerChunk = -999;
		this.getBiomeDecorator().candyFlowerPerChunk = 48;
		this.getBiomeDecorator().candyCanePerChunk = 32;
	}
}