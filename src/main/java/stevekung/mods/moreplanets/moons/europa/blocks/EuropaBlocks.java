/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import stevekung.mods.moreplanets.common.blocks.BlockBaseMP;
import stevekung.mods.moreplanets.common.blocks.fluid.FluidMP;
import stevekung.mods.moreplanets.moons.europa.fluids.BlockFluidEuropaWater;
import stevekung.mods.moreplanets.moons.europa.itemblocks.ItemBlockEuropaGeyser;
import stevekung.mods.moreplanets.moons.europa.itemblocks.ItemBlockEuropaIce;
import stevekung.mods.moreplanets.moons.europa.itemblocks.ItemBlockEuropaPrismarine;
import stevekung.mods.moreplanets.moons.europa.itemblocks.ItemBlockEuropaSnowLayer;
import stevekung.mods.stevecore.RegisterHelper;

public class EuropaBlocks
{
	public static Block europa_ice;
	public static Block packed_europa_ice;
	public static Block europa_snow_block;
	public static Block europa_snow_layer;
	public static Block europa_prismarine;
	public static Block europa_sea_lantern;
	public static Block europa_ice_slush;
	public static Block europa_salt;
	public static Block europa_underwater_geyser;
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
		EuropaBlocks.europa_snow_layer = new BlockEuropaSnowLayer("europa_snow_layer");
		EuropaBlocks.europa_prismarine = new BlockEuropaPrismarine("europa_prismarine");
		EuropaBlocks.europa_sea_lantern = new BlockEuropaSeaLantern("europa_sea_lantern");
		EuropaBlocks.europa_ice_slush = new BlockEuropaIceSlush("europa_ice_slush");
		EuropaBlocks.europa_salt = new BlockBaseMP("europa_salt", Material.rock).setHardness(1.5F);
		EuropaBlocks.europa_underwater_geyser = new BlockEuropaUnderwaterGeyser("europa_underwater_geyser");

		EuropaBlocks.europa_water_fluid = new FluidMP("europa_water_fluid").setBlock(EuropaBlocks.europa_water);
		FluidRegistry.registerFluid(EuropaBlocks.europa_water_fluid);
		EuropaBlocks.europa_water = new BlockFluidEuropaWater("europa_water_fluid");
	}

	private static void setHarvestLevels()
	{
		EuropaBlocks.europa_snow_block.setHarvestLevel("shovel", 0);
		EuropaBlocks.europa_snow_layer.setHarvestLevel("shovel", 0);
		EuropaBlocks.europa_prismarine.setHarvestLevel("pickaxe", 0);
		EuropaBlocks.europa_ice_slush.setHarvestLevel("shovel", 0);
		EuropaBlocks.europa_salt.setHarvestLevel("pickaxe", 0);
		EuropaBlocks.europa_underwater_geyser.setHarvestLevel("pickaxe", 0);
	}

	private static void registerBlocks()
	{
		RegisterHelper.registerBlock(EuropaBlocks.europa_ice, ItemBlockEuropaIce.class);
		RegisterHelper.registerBlock(EuropaBlocks.packed_europa_ice);
		RegisterHelper.registerBlock(EuropaBlocks.europa_snow_block);
		RegisterHelper.registerBlock(EuropaBlocks.europa_ice_slush);
		RegisterHelper.registerBlock(EuropaBlocks.europa_salt);
		RegisterHelper.registerBlock(EuropaBlocks.europa_underwater_geyser, ItemBlockEuropaGeyser.class);
		RegisterHelper.registerBlock(EuropaBlocks.europa_prismarine, ItemBlockEuropaPrismarine.class);
		RegisterHelper.registerBlock(EuropaBlocks.europa_sea_lantern);
		RegisterHelper.registerBlock(EuropaBlocks.europa_snow_layer, ItemBlockEuropaSnowLayer.class);
		RegisterHelper.registerBlock(EuropaBlocks.europa_water);
	}
}