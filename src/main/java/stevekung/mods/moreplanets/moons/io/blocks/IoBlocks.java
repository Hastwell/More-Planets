/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.io.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import stevekung.mods.moreplanets.common.blocks.fluid.FluidMP;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockMultiVariant;
import stevekung.mods.moreplanets.common.util.VariantsName;
import stevekung.mods.moreplanets.moons.io.fluids.BlockFluidBlackIoLava;
import stevekung.mods.moreplanets.moons.io.fluids.BlockFluidBrownLiquidSulfur;
import stevekung.mods.moreplanets.moons.io.fluids.BlockFluidIoLava;
import stevekung.mods.moreplanets.moons.io.fluids.BlockFluidOrangeLiquidSulfur;
import stevekung.mods.moreplanets.moons.io.fluids.BlockFluidRedLiquidSulfur;
import stevekung.mods.moreplanets.moons.io.fluids.BlockFluidYellowLiquidSulfur;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class IoBlocks
{
	public static Block io_block;
	public static Block io_magma_rock;
	public static Block red_liquid_sulfur;
	public static Block yellow_liquid_sulfur;
	public static Block orange_liquid_sulfur;
	public static Block brown_liquid_sulfur;
	public static Block io_lava;
	public static Block black_io_lava;

	public static Fluid red_liquid_sulfur_fluid;
	public static Fluid yellow_liquid_sulfur_fluid;
	public static Fluid orange_liquid_sulfur_fluid;
	public static Fluid brown_liquid_sulfur_fluid;
	public static Fluid io_lava_fluid;
	public static Fluid black_io_lava_fluid;

	public static void init()
	{
		// Init
		IoBlocks.io_block = new BlockIo("io_block");
		IoBlocks.io_magma_rock = new BlockIoMagmaRock("io_magma_rock");

		IoBlocks.io_lava_fluid = new FluidMP("io_lava", "blocks/lava_still", "blocks/lava_flow").setBlock(IoBlocks.io_lava).setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
		IoBlocks.black_io_lava_fluid = new FluidMP("black_io_lava").setBlock(IoBlocks.black_io_lava).setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
		IoBlocks.red_liquid_sulfur_fluid = new FluidMP("red_liquid_sulfur").setBlock(IoBlocks.red_liquid_sulfur).setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
		IoBlocks.yellow_liquid_sulfur_fluid = new FluidMP("yellow_liquid_sulfur").setBlock(IoBlocks.yellow_liquid_sulfur).setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
		IoBlocks.orange_liquid_sulfur_fluid = new FluidMP("orange_liquid_sulfur").setBlock(IoBlocks.orange_liquid_sulfur).setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
		IoBlocks.brown_liquid_sulfur_fluid = new FluidMP("brown_liquid_sulfur").setBlock(IoBlocks.brown_liquid_sulfur).setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
		FluidRegistry.registerFluid(IoBlocks.io_lava_fluid);
		FluidRegistry.registerFluid(IoBlocks.black_io_lava_fluid);
		FluidRegistry.registerFluid(IoBlocks.red_liquid_sulfur_fluid);
		FluidRegistry.registerFluid(IoBlocks.yellow_liquid_sulfur_fluid);
		FluidRegistry.registerFluid(IoBlocks.orange_liquid_sulfur_fluid);
		FluidRegistry.registerFluid(IoBlocks.brown_liquid_sulfur_fluid);
		IoBlocks.io_lava = new BlockFluidIoLava("io_lava");
		IoBlocks.black_io_lava = new BlockFluidBlackIoLava("black_io_lava");
		IoBlocks.red_liquid_sulfur = new BlockFluidRedLiquidSulfur("red_liquid_sulfur");
		IoBlocks.yellow_liquid_sulfur = new BlockFluidYellowLiquidSulfur("yellow_liquid_sulfur");
		IoBlocks.orange_liquid_sulfur = new BlockFluidOrangeLiquidSulfur("orange_liquid_sulfur");
		IoBlocks.brown_liquid_sulfur = new BlockFluidBrownLiquidSulfur("brown_liquid_sulfur");

		// Register
		CommonRegisterHelper.registerBlock(IoBlocks.io_block, ItemBlockMultiVariant.class, new VariantsName("surface_rock", "sub_surface_rock", "rock", "cobblestone", "sulfur_ore", "ash_stone", "ash_cobblestone", "silicate_rock", "dungeon_brick"));
		CommonRegisterHelper.registerBlock(IoBlocks.io_magma_rock, ItemBlockMultiVariant.class, new VariantsName("magma_rock", "sulfur_rock"));
		CommonRegisterHelper.registerBlock(IoBlocks.io_lava);
		CommonRegisterHelper.registerBlock(IoBlocks.black_io_lava);
		CommonRegisterHelper.registerBlock(IoBlocks.red_liquid_sulfur);
		CommonRegisterHelper.registerBlock(IoBlocks.yellow_liquid_sulfur);
		CommonRegisterHelper.registerBlock(IoBlocks.orange_liquid_sulfur);
		CommonRegisterHelper.registerBlock(IoBlocks.brown_liquid_sulfur);

		// Set harvest level
		CommonRegisterHelper.setBlockHarvestLevel(IoBlocks.io_block, "pickaxe", 0);
		CommonRegisterHelper.setBlockHarvestLevel(IoBlocks.io_magma_rock, "pickaxe", 0);
	}
}