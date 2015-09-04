/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import stevekung.mods.moreplanets.moons.europa.blocks.fluids.BlockFluidEuropaWater;
import stevekung.mods.moreplanets.moons.europa.itemblocks.ItemBlockEuropaGeyser;
import stevekung.mods.moreplanets.moons.europa.itemblocks.ItemBlockEuropaIce;
import stevekung.mods.moreplanets.moons.europa.itemblocks.ItemBlockEuropaSnowLayer;
import stevekung.mods.stevecore.RegisterHelper;

public class EuropaBlocks
{
	public static Block europa_ice;
	public static Block packed_europa_ice;
	public static Block europa_snow_block;
	public static Block europa_ice_slush;
	public static Block europa_water_bomb;
	public static Block europa_salt;
	public static Block europa_geyser;
	public static Block europa_snow_layer;
	public static Block europa_water;

	// Fluid
	public static Fluid europa_water_fluid;

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
		EuropaBlocks.europa_ice_slush = new BlockEuropaIceSlush("europa_ice_slush");
		EuropaBlocks.europa_water_bomb = new BlockEuropaWaterBomb("europa_water_bomb");
		EuropaBlocks.europa_salt = new BlockEuropaSalt("europa_salt");
		EuropaBlocks.europa_geyser = new BlockEuropaGeyser("europa_geyser");
		EuropaBlocks.europa_snow_layer = new BlockEuropaSnowLayer("europa_snow_layer");

		EuropaBlocks.europa_water_fluid = new Fluid("europa_water_fluid").setBlock(EuropaBlocks.europa_water);
		FluidRegistry.registerFluid(EuropaBlocks.europa_water_fluid);
		EuropaBlocks.europa_water = new BlockFluidEuropaWater("europa_water_fluid");
	}

	public static void setHarvestLevels()
	{
		EuropaBlocks.europa_snow_block.setHarvestLevel("shovel", 0);
		EuropaBlocks.europa_ice_slush.setHarvestLevel("shovel", 0);
		EuropaBlocks.europa_salt.setHarvestLevel("pickaxe", 0);
		EuropaBlocks.europa_geyser.setHarvestLevel("pickaxe", 0);
		EuropaBlocks.europa_snow_layer.setHarvestLevel("shovel", 0);
	}

	private static void registerBlocks()
	{
		RegisterHelper.registerBlock(EuropaBlocks.europa_ice, ItemBlockEuropaIce.class);
		RegisterHelper.registerBlock(EuropaBlocks.packed_europa_ice);
		RegisterHelper.registerBlock(EuropaBlocks.europa_snow_block);
		RegisterHelper.registerBlock(EuropaBlocks.europa_ice_slush);
		RegisterHelper.registerBlock(EuropaBlocks.europa_salt);
		RegisterHelper.registerBlock(EuropaBlocks.europa_water_bomb);
		RegisterHelper.registerBlock(EuropaBlocks.europa_geyser, ItemBlockEuropaGeyser.class);
		RegisterHelper.registerBlock(EuropaBlocks.europa_snow_layer, ItemBlockEuropaSnowLayer.class);
		RegisterHelper.registerBlock(EuropaBlocks.europa_water);
	}
}