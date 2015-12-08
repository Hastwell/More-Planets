/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.blocks.BlockStairsMP;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockMultiVariant;
import stevekung.mods.moreplanets.common.util.VariantsName;
import stevekung.mods.moreplanets.planets.venus.itemblocks.ItemBlockVenusSandstoneSlab;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class VenusBlocks
{
	public static Block venus_block;
	public static Block venus_redstone_ore;
	public static Block venus_redstone_ore_active;
	public static Block venus_smoke_geyser;
	public static Block venus_magma_rock;
	public static Block venus_sand;
	public static Block venusian_blaze_egg;
	public static Block sulfur_torch;
	public static Block venus_ancient_chest;
	public static Block venus_sandstone;
	public static Block half_venus_sandstone_slab;
	public static Block double_venus_sandstone_slab;
	public static Block venus_sandstone_stairs;

	public static void init()
	{
		// Init
		VenusBlocks.venus_block = new BlockVenus("venus_block");
		VenusBlocks.venus_redstone_ore = new BlockVenusRedstoneOre("venus_redstone_ore", false);
		VenusBlocks.venus_redstone_ore_active = new BlockVenusRedstoneOre("venus_redstone_ore_active", true);
		VenusBlocks.venus_smoke_geyser = new BlockVenusSmokeGeyser("venus_smoke_geyser");
		VenusBlocks.venus_sand = new BlockVenusSand("venus_sand");
		VenusBlocks.venus_magma_rock = new BlockVenusMagmaRock("venus_magma_rock");
		VenusBlocks.venusian_blaze_egg = new BlockVenusianBlazeEgg("venusian_blaze_egg");
		VenusBlocks.sulfur_torch = new BlockSulfurTorch("sulfur_torch");
		VenusBlocks.venus_ancient_chest = new BlockVenusAncientChest("venus_ancient_chest");
		VenusBlocks.venus_sandstone = new BlockVenusSandstone("venus_sandstone");
		VenusBlocks.half_venus_sandstone_slab = new BlockVenusSandstoneSlab("half_venus_sandstone_slab", Material.rock);
		VenusBlocks.double_venus_sandstone_slab = new BlockDoubleVenusSandstoneSlab("double_venus_sandstone_slab", Material.rock);
		VenusBlocks.venus_sandstone_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "venus_sandstone_stairs", 0.8F);

		// Register
		CommonRegisterHelper.registerBlock(VenusBlocks.venus_block, ItemBlockMultiVariant.class, new VariantsName("surface", "sub_surface", "rock", "cobblestone", "sulfur_ore", "lead_ore", "tin_ore", "copper_ore", "coal_ore", "iron_ore", "gold_ore", "lead_block", "stone_brick", "cracked_stone_brick", "dungeon_brick"));
		CommonRegisterHelper.registerBlock(VenusBlocks.venus_redstone_ore);
		CommonRegisterHelper.registerBlock(VenusBlocks.venus_redstone_ore_active);
		CommonRegisterHelper.registerBlock(VenusBlocks.venus_smoke_geyser);
		CommonRegisterHelper.registerBlock(VenusBlocks.venus_magma_rock);
		CommonRegisterHelper.registerBlock(VenusBlocks.venus_sand);
		CommonRegisterHelper.registerBlock(VenusBlocks.venus_sandstone, ItemBlockMultiVariant.class, new VariantsName("venus_sandstone", "chiseled_venus_sandstone", "smooth_venus_sandstone"));
		CommonRegisterHelper.registerBlock(VenusBlocks.half_venus_sandstone_slab, ItemBlockVenusSandstoneSlab.class, VenusBlocks.half_venus_sandstone_slab, VenusBlocks.double_venus_sandstone_slab);
		CommonRegisterHelper.registerBlock(VenusBlocks.double_venus_sandstone_slab, ItemBlockVenusSandstoneSlab.class, VenusBlocks.half_venus_sandstone_slab, VenusBlocks.double_venus_sandstone_slab);
		CommonRegisterHelper.registerBlock(VenusBlocks.venus_sandstone_stairs);
		CommonRegisterHelper.registerBlock(VenusBlocks.sulfur_torch);
		CommonRegisterHelper.registerBlock(VenusBlocks.venusian_blaze_egg);
		CommonRegisterHelper.registerBlock(VenusBlocks.venus_ancient_chest);

		// Set harvest level
		CommonRegisterHelper.setBlockHarvestLevel(VenusBlocks.venus_sandstone, "pickaxe", 0);
		CommonRegisterHelper.setBlockHarvestLevel(VenusBlocks.half_venus_sandstone_slab, "pickaxe", 0);
		CommonRegisterHelper.setBlockHarvestLevel(VenusBlocks.double_venus_sandstone_slab, "pickaxe", 0);
		CommonRegisterHelper.setBlockHarvestLevel(VenusBlocks.venus_sandstone_stairs, "pickaxe", 0);
		CommonRegisterHelper.setBlockHarvestLevel(VenusBlocks.venus_block, "pickaxe", 0);
		CommonRegisterHelper.setBlockHarvestLevel(VenusBlocks.venus_magma_rock, "pickaxe", 0);
		CommonRegisterHelper.setBlockHarvestLevel(VenusBlocks.venus_smoke_geyser, "pickaxe", 0);
		CommonRegisterHelper.setBlockHarvestLevel(VenusBlocks.venus_redstone_ore, "pickaxe", 2);
		CommonRegisterHelper.setBlockHarvestLevel(VenusBlocks.venus_redstone_ore_active, "pickaxe", 2);
		CommonRegisterHelper.setBlockHarvestLevel(VenusBlocks.venus_sand, "shovel", 0);
		CommonRegisterHelper.setBlockHarvestLevel(VenusBlocks.venus_ancient_chest, "axe", 0);


		// Register ore dictionary
		OreDictionary.registerOre("oreSulfur", new ItemStack(VenusBlocks.venus_block, 1, 4));
		OreDictionary.registerOre("oreLead", new ItemStack(VenusBlocks.venus_block, 1, 5));
		OreDictionary.registerOre("oreTin", new ItemStack(VenusBlocks.venus_block, 1, 6));
		OreDictionary.registerOre("oreCopper", new ItemStack(VenusBlocks.venus_block, 1, 7));
		OreDictionary.registerOre("oreCoal", new ItemStack(VenusBlocks.venus_block, 1, 8));
		OreDictionary.registerOre("oreIron", new ItemStack(VenusBlocks.venus_block, 1, 9));
		OreDictionary.registerOre("oreGold", new ItemStack(VenusBlocks.venus_block, 1, 10));
		OreDictionary.registerOre("oreRedstone", new ItemStack(VenusBlocks.venus_redstone_ore, 1, 0));
		OreDictionary.registerOre("blockLead", new ItemStack(VenusBlocks.venus_block, 1, 11));
		OreDictionary.registerOre("sand", VenusBlocks.venus_sand);
	}
}