/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.blocks;

import net.minecraft.block.Block;
import stevekung.mods.moreplanets.moons.europa.itemblocks.ItemBlockEuropaIce;
import stevekung.mods.stevecore.RegisterHelper;

public class EuropaBlocks
{
	public static Block europa_ice;
	public static Block packed_europa_ice;
	public static Block europa_snow_block;
	public static Block europa_snow_layer;

	public static void init()
	{
		EuropaBlocks.initBlocks();
		EuropaBlocks.setHarvestLevels();
		EuropaBlocks.registerBlocks();
	}

	private static void initBlocks()
	{
		EuropaBlocks.europa_ice = new BlockEuropaIce("europa_ice");
		EuropaBlocks.packed_europa_ice = new BlockPackedEuropaIce("packed_europa_ice");
		EuropaBlocks.europa_snow_block = new BlockEuropaSnowBlock("europa_snow_block");
		EuropaBlocks.europa_snow_layer = new BlockEuropaSnowLayer("europa_snow_layer");
	}

	public static void setHarvestLevels()
	{
		EuropaBlocks.europa_snow_block.setHarvestLevel("shovel", 0);
		EuropaBlocks.europa_snow_layer.setHarvestLevel("shovel", 0);
	}

	private static void registerBlocks()
	{
		RegisterHelper.registerBlock(EuropaBlocks.europa_ice, ItemBlockEuropaIce.class);
		RegisterHelper.registerBlock(EuropaBlocks.packed_europa_ice);
		RegisterHelper.registerBlock(EuropaBlocks.europa_snow_block);
		RegisterHelper.registerBlock(EuropaBlocks.europa_snow_layer);
	}
}