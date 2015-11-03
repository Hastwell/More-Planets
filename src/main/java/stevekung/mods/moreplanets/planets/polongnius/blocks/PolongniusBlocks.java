/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.blocks;

import micdoodle8.mods.galacticraft.core.items.ItemBlockDesc;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.blocks.BlockStairsMP;
import stevekung.mods.moreplanets.common.blocks.fluid.FluidMP;
import stevekung.mods.moreplanets.planets.polongnius.fluids.BlockFluidCheeseOfMilk;
import stevekung.mods.moreplanets.planets.polongnius.itemblocks.ItemBlockPolongnius;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class PolongniusBlocks
{
	public static Block polongnius_block;
	public static Block polongnius_treasure_chest;
	public static Block fallen_polongnius_meteor;
	public static Block flonium_torch;
	public static Block cheese_of_milk_cake;
	public static Block ultra_violet_solar_panel;
	public static Block polongnius_cobblestone_stairs;
	public static Block polongnius_dungeon_brick_stairs;
	public static Block cheese_of_milk;
	public static Block polongnius_ancient_chest;
	public static Block cheese_slime_block;
	public static Block cheese_slime_egg;
	public static Block ultra_violet_solar_fake;
	public static Block cheese_gas_block;

	public static Fluid cheese_of_milk_fluid;

	public static void init()
	{
		// Init
		PolongniusBlocks.polongnius_block = new BlockPolongnius("polongnius_block");
		PolongniusBlocks.polongnius_treasure_chest = new BlockPolongniusTreasureChest("polongnius_treasure_chest");
		PolongniusBlocks.fallen_polongnius_meteor = new BlockFallenPolongniusMeteor("fallen_polongnius_meteor");
		PolongniusBlocks.cheese_of_milk_cake = new BlockCheeseOfMilkCake("cheese_of_milk_cake");
		PolongniusBlocks.flonium_torch = new BlockFloniumTorch("flonium_torch");
		PolongniusBlocks.ultra_violet_solar_panel = new BlockUltraVioletSolarPanel("ultra_violet_solar_panel");
		PolongniusBlocks.polongnius_cobblestone_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "polongnius_cobblestone_stairs", 3.0F);
		PolongniusBlocks.polongnius_dungeon_brick_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "polongnius_dungeon_brick_stairs", 4.0F);
		PolongniusBlocks.polongnius_ancient_chest = new BlockPolongniusAncientChest("polongnius_ancient_chest");
		PolongniusBlocks.cheese_slime_block = new BlockCheeseSlime("cheese_slime_block");
		PolongniusBlocks.cheese_slime_egg = new BlockCheeseSlimeEgg("cheese_slime_egg");
		PolongniusBlocks.ultra_violet_solar_fake = new BlockUltraVioletSolarFake("ultra_violet_solar_fake");
		PolongniusBlocks.cheese_gas_block = new BlockCheeseGas("cheese_gas_block");

		PolongniusBlocks.cheese_of_milk_fluid = new FluidMP("cheese_of_milk_fluid").setBlock(PolongniusBlocks.cheese_of_milk).setViscosity(2000);
		FluidRegistry.registerFluid(PolongniusBlocks.cheese_of_milk_fluid);
		PolongniusBlocks.cheese_of_milk = new BlockFluidCheeseOfMilk("cheese_of_milk_fluid");

		// Register
		CommonRegisterHelper.registerBlock(PolongniusBlocks.polongnius_block, ItemBlockPolongnius.class);
		CommonRegisterHelper.registerBlock(PolongniusBlocks.cheese_gas_block);
		CommonRegisterHelper.registerBlock(PolongniusBlocks.cheese_slime_block);
		CommonRegisterHelper.registerBlock(PolongniusBlocks.ultra_violet_solar_panel, ItemBlockDesc.class);
		CommonRegisterHelper.registerBlock(PolongniusBlocks.polongnius_treasure_chest);
		CommonRegisterHelper.registerBlock(PolongniusBlocks.polongnius_ancient_chest);
		CommonRegisterHelper.registerBlock(PolongniusBlocks.polongnius_cobblestone_stairs);
		CommonRegisterHelper.registerBlock(PolongniusBlocks.polongnius_dungeon_brick_stairs);
		CommonRegisterHelper.registerBlock(PolongniusBlocks.fallen_polongnius_meteor);
		CommonRegisterHelper.registerBlock(PolongniusBlocks.cheese_slime_egg);
		CommonRegisterHelper.registerBlock(PolongniusBlocks.cheese_of_milk_cake);
		CommonRegisterHelper.registerBlock(PolongniusBlocks.flonium_torch);
		CommonRegisterHelper.registerBlock(PolongniusBlocks.cheese_of_milk);
		CommonRegisterHelper.registerBlock(PolongniusBlocks.ultra_violet_solar_fake);

		// Set harvest level
		((BlockPolongnius)PolongniusBlocks.polongnius_block).setHarvestLevel("shovel", 0, 0);
		((BlockPolongnius)PolongniusBlocks.polongnius_block).setHarvestLevel("shovel", 0, 1);
		((BlockPolongnius)PolongniusBlocks.polongnius_block).setHarvestLevel("pickaxe", 0, 2);
		((BlockPolongnius)PolongniusBlocks.polongnius_block).setHarvestLevel("pickaxe", 0, 3);
		((BlockPolongnius)PolongniusBlocks.polongnius_block).setHarvestLevel("pickaxe", 0, 4);
		((BlockPolongnius)PolongniusBlocks.polongnius_block).setHarvestLevel("pickaxe", 0, 5);
		((BlockPolongnius)PolongniusBlocks.polongnius_block).setHarvestLevel("pickaxe", 0, 6);
		((BlockPolongnius)PolongniusBlocks.polongnius_block).setHarvestLevel("pickaxe", 0, 7);
		((BlockPolongnius)PolongniusBlocks.polongnius_block).setHarvestLevel("pickaxe", 0, 8);
		((BlockPolongnius)PolongniusBlocks.polongnius_block).setHarvestLevel("pickaxe", 0, 9);
		((BlockPolongnius)PolongniusBlocks.polongnius_block).setHarvestLevel("pickaxe", 0, 10);
		((BlockPolongnius)PolongniusBlocks.polongnius_block).setHarvestLevel("pickaxe", 0, 11);
		((BlockPolongnius)PolongniusBlocks.polongnius_block).setHarvestLevel("pickaxe", 0, 12);
		((BlockPolongnius)PolongniusBlocks.polongnius_block).setHarvestLevel("pickaxe", 0, 13);
		((BlockPolongnius)PolongniusBlocks.polongnius_block).setHarvestLevel("pickaxe", 0, 14);
		((BlockPolongnius)PolongniusBlocks.polongnius_block).setHarvestLevel("pickaxe", 0, 15);
		PolongniusBlocks.polongnius_cobblestone_stairs.setHarvestLevel("pickaxe", 0);
		PolongniusBlocks.polongnius_dungeon_brick_stairs.setHarvestLevel("pickaxe", 0);
		PolongniusBlocks.fallen_polongnius_meteor.setHarvestLevel("pickaxe", 2);
		PolongniusBlocks.ultra_violet_solar_panel.setHarvestLevel("pickaxe", 0);
		PolongniusBlocks.polongnius_ancient_chest.setHarvestLevel("axe", 0);

		// Register ore dictionary
		OreDictionary.registerOre("oreCopper", new ItemStack(PolongniusBlocks.polongnius_block, 1, 4));
		OreDictionary.registerOre("oreTin", new ItemStack(PolongniusBlocks.polongnius_block, 1, 5));
		OreDictionary.registerOre("oreIron", new ItemStack(PolongniusBlocks.polongnius_block, 1, 6));
		OreDictionary.registerOre("orePalladium", new ItemStack(PolongniusBlocks.polongnius_block, 1, 7));
		OreDictionary.registerOre("oreFlonium", new ItemStack(PolongniusBlocks.polongnius_block, 1, 8));
		OreDictionary.registerOre("orePurpleCrystal", new ItemStack(PolongniusBlocks.polongnius_block, 1, 8));

		OreDictionary.registerOre("blockPolongniusMeteor", new ItemStack(PolongniusBlocks.polongnius_block, 1, 10));
		OreDictionary.registerOre("blockPurpleCrystal", new ItemStack(PolongniusBlocks.polongnius_block, 1, 11));
		OreDictionary.registerOre("blockPalladium", new ItemStack(PolongniusBlocks.polongnius_block, 1, 12));
	}
}