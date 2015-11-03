/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.mercury.blocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.blocks.BlockStairsMP;
import stevekung.mods.moreplanets.common.blocks.fluid.FluidMP;
import stevekung.mods.moreplanets.planets.mercury.fluids.BlockFluidDirtyWater;
import stevekung.mods.moreplanets.planets.mercury.itemblocks.ItemBlockMercury;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class MercuryBlocks
{
	public static Block mercury_block;
	public static Block mercury_ice;
	public static Block metallic_rock;
	public static Block mercury_ancient_chest;
	public static Block mercury_cobblestone_stairs;
	public static Block mercury_dungeon_brick_stairs;
	public static Block dirty_water;

	public static Fluid dirty_water_fluid;

	public static void init()
	{
		// Init
		MercuryBlocks.mercury_block = new BlockMercury("mercury_block");
		MercuryBlocks.mercury_ice = new BlockMercuryIce("mercury_ice");
		MercuryBlocks.metallic_rock = new BlockMetallicRock("metallic_rock");
		MercuryBlocks.mercury_cobblestone_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "mercury_cobblestone_stairs", 2.5F);
		MercuryBlocks.mercury_dungeon_brick_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "mercury_dungeon_brick_stairs", 4.0F);
		MercuryBlocks.mercury_ancient_chest = new BlockMercuryAncientChest("mercury_ancient_chest");

		MercuryBlocks.dirty_water_fluid = new FluidMP("dirty_water_fluid").setBlock(MercuryBlocks.dirty_water);
		FluidRegistry.registerFluid(MercuryBlocks.dirty_water_fluid);
		MercuryBlocks.dirty_water = new BlockFluidDirtyWater("dirty_water_fluid");

		// Register
		CommonRegisterHelper.registerBlock(MercuryBlocks.mercury_block, ItemBlockMercury.class);
		CommonRegisterHelper.registerBlock(MercuryBlocks.metallic_rock);
		CommonRegisterHelper.registerBlock(MercuryBlocks.mercury_ice);
		CommonRegisterHelper.registerBlock(MercuryBlocks.mercury_cobblestone_stairs);
		CommonRegisterHelper.registerBlock(MercuryBlocks.mercury_dungeon_brick_stairs);
		CommonRegisterHelper.registerBlock(MercuryBlocks.mercury_ancient_chest);
		CommonRegisterHelper.registerBlock(MercuryBlocks.dirty_water);

		// Set harvest level
		MercuryBlocks.mercury_block.setHarvestLevel("pickaxe", 0);
		MercuryBlocks.metallic_rock.setHarvestLevel("pickaxe", 2);
		MercuryBlocks.mercury_cobblestone_stairs.setHarvestLevel("pickaxe", 0);
		MercuryBlocks.mercury_dungeon_brick_stairs.setHarvestLevel("pickaxe", 0);
		MercuryBlocks.mercury_ancient_chest.setHarvestLevel("axe", 0);

		// Register ore dictionary
		OreDictionary.registerOre("oreTin", new ItemStack(MercuryBlocks.mercury_block, 1, 4));
		OreDictionary.registerOre("oreCopper", new ItemStack(MercuryBlocks.mercury_block, 1, 5));
		OreDictionary.registerOre("oreAluminum", new ItemStack(MercuryBlocks.mercury_block, 1, 6));
		OreDictionary.registerOre("oreAluminium", new ItemStack(MercuryBlocks.mercury_block, 1, 6));
		OreDictionary.registerOre("oreIron", new ItemStack(MercuryBlocks.mercury_block, 1, 7));
		OreDictionary.registerOre("oreMetalMeteor", new ItemStack(MercuryBlocks.mercury_block, 1, 8));
		OreDictionary.registerOre("oreMetallic", new ItemStack(MercuryBlocks.metallic_rock, 1, 0));

		OreDictionary.registerOre("blockMetalMeteor", new ItemStack(MercuryBlocks.mercury_block, 1, 10));
	}
}