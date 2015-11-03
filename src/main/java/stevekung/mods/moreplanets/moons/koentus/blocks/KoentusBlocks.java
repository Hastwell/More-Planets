/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.koentus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.blocks.BlockBaseMP;
import stevekung.mods.moreplanets.common.blocks.BlockDoorMP;
import stevekung.mods.moreplanets.common.blocks.BlockDoorMP.DoorType;
import stevekung.mods.moreplanets.common.blocks.BlockFenceGateMP;
import stevekung.mods.moreplanets.common.blocks.BlockStairsMP;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockColoredMP;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockDirtMP;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockSingleLeaves;
import stevekung.mods.moreplanets.moons.koentus.itemblocks.ItemBlockCrystalLog;
import stevekung.mods.moreplanets.moons.koentus.itemblocks.ItemBlockKoentus;
import stevekung.mods.moreplanets.moons.koentus.itemblocks.ItemBlockKoentusIce;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class KoentusBlocks
{
	public static Block koentus_block;
	public static Block koentus_ice;
	public static Block koentus_cobblestone_stairs;
	public static Block koentus_dungeon_brick_stairs;
	public static Block eledos_egg;
	public static Block white_crystal_torch;
	public static Block fallen_koentus_meteor;
	public static Block koentus_ancient_stone_stairs;
	public static Block koentus_ancient_stone_brick_stairs;
	public static Block koentus_ancient_chest;
	public static Block glowing_ice_stone;
	public static Block crystal_segment;
	public static Block crystal_dirt;
	public static Block crystal_planks;
	public static Block crystal_log;
	public static Block crystal_sapling;
	public static Block crystal_leaves;
	public static Block crystal_fence;
	public static Block crystal_fence_gate;
	public static Block crystal_farmland;
	public static Block crystal_wood_stairs;
	public static Block crystal_door_block;
	public static Block crystal_cocoa;

	public static void init()
	{
		// Init
		KoentusBlocks.koentus_block = new BlockKoentus("koentus_block");
		KoentusBlocks.koentus_ice = new BlockKoentusIce("koentus_ice");
		KoentusBlocks.koentus_cobblestone_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "koentus_cobblestone_stairs", 3.25F);
		KoentusBlocks.koentus_dungeon_brick_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "koentus_dungeon_brick_stairs", 4.0F);
		KoentusBlocks.fallen_koentus_meteor = new BlockFallenKoentusMeteor("fallen_koentus_meteor");
		KoentusBlocks.eledos_egg = new BlockEledosEgg("eledos_egg");
		KoentusBlocks.white_crystal_torch = new BlockWhiteCrystalTorch("white_crystal_torch");
		KoentusBlocks.koentus_ancient_stone_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "koentus_ancient_stone_stairs", 2.5F);
		KoentusBlocks.koentus_ancient_stone_brick_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "koentus_ancient_stone_brick_stairs", 2.5F);
		KoentusBlocks.koentus_ancient_chest = new BlockKoentusAncientChest("koentus_ancient_chest");
		KoentusBlocks.glowing_ice_stone = new BlockGlowingIceStone("glowing_ice_stone");
		KoentusBlocks.crystal_segment = new BlockCrystalSegment("crystal_segment");
		KoentusBlocks.crystal_dirt = new BlockCrystalDirt("crystal_dirt");
		KoentusBlocks.crystal_planks = new BlockBaseMP("crystal_planks", Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood);
		KoentusBlocks.crystal_log = new BlockCrystalLog("crystal_log");
		KoentusBlocks.crystal_sapling = new BlockCrystalSapling("crystal_sapling");
		KoentusBlocks.crystal_leaves = new BlockCrystalLeaves("crystal_leaves");
		KoentusBlocks.crystal_fence = new BlockCrystalFence("crystal_fence");
		KoentusBlocks.crystal_fence_gate = new BlockFenceGateMP("crystal_fence_gate");
		KoentusBlocks.crystal_farmland = new BlockCrystalFarmland("crystal_farmland");
		KoentusBlocks.crystal_wood_stairs = new BlockStairsMP(Blocks.planks.getDefaultState(), "crystal_wood_stairs", "wood", null, 2.0F);
		KoentusBlocks.crystal_door_block = new BlockDoorMP("crystal_door_block", DoorType.CRYSTAL);
		KoentusBlocks.crystal_cocoa = new BlockCrystalCocoa("crystal_cocoa_block");

		// Register
		CommonRegisterHelper.registerBlock(KoentusBlocks.koentus_block, ItemBlockKoentus.class);
		CommonRegisterHelper.registerBlock(KoentusBlocks.crystal_dirt, ItemBlockDirtMP.class);
		CommonRegisterHelper.registerBlock(KoentusBlocks.crystal_log, ItemBlockCrystalLog.class);
		CommonRegisterHelper.registerBlock(KoentusBlocks.crystal_planks);
		CommonRegisterHelper.registerBlock(KoentusBlocks.crystal_leaves, ItemBlockSingleLeaves.class);
		CommonRegisterHelper.registerBlock(KoentusBlocks.koentus_ice, ItemBlockKoentusIce.class);
		CommonRegisterHelper.registerBlock(KoentusBlocks.glowing_ice_stone, ItemBlockColoredMP.class);
		CommonRegisterHelper.registerBlock(KoentusBlocks.crystal_wood_stairs);
		CommonRegisterHelper.registerBlock(KoentusBlocks.koentus_cobblestone_stairs);
		CommonRegisterHelper.registerBlock(KoentusBlocks.koentus_dungeon_brick_stairs);
		CommonRegisterHelper.registerBlock(KoentusBlocks.koentus_ancient_stone_stairs);
		CommonRegisterHelper.registerBlock(KoentusBlocks.koentus_ancient_stone_brick_stairs);
		CommonRegisterHelper.registerBlock(KoentusBlocks.koentus_ancient_chest);
		CommonRegisterHelper.registerBlock(KoentusBlocks.crystal_fence);
		CommonRegisterHelper.registerBlock(KoentusBlocks.crystal_fence_gate);
		CommonRegisterHelper.registerBlock(KoentusBlocks.crystal_farmland);
		CommonRegisterHelper.registerBlock(KoentusBlocks.eledos_egg);
		CommonRegisterHelper.registerBlock(KoentusBlocks.fallen_koentus_meteor);
		CommonRegisterHelper.registerBlock(KoentusBlocks.crystal_segment);
		CommonRegisterHelper.registerBlock(KoentusBlocks.white_crystal_torch);
		CommonRegisterHelper.registerBlock(KoentusBlocks.crystal_sapling);
		CommonRegisterHelper.registerBlock(KoentusBlocks.crystal_door_block);
		CommonRegisterHelper.registerBlock(KoentusBlocks.crystal_cocoa);

		// Set harvest level
		KoentusBlocks.koentus_block.setHarvestLevel("pickaxe", 0);
		KoentusBlocks.fallen_koentus_meteor.setHarvestLevel("pickaxe", 2);
		KoentusBlocks.eledos_egg.setHarvestLevel("pickaxe", 0);
		KoentusBlocks.crystal_segment.setHarvestLevel("pickaxe", 0);
		KoentusBlocks.koentus_ancient_chest.setHarvestLevel("axe", 0);
		KoentusBlocks.crystal_log.setHarvestLevel("axe", 0);
		KoentusBlocks.crystal_fence.setHarvestLevel("axe", 0);
		KoentusBlocks.crystal_fence_gate.setHarvestLevel("axe", 0);
		KoentusBlocks.crystal_planks.setHarvestLevel("axe", 0);
		KoentusBlocks.crystal_wood_stairs.setHarvestLevel("axe", 0);
		KoentusBlocks.crystal_door_block.setHarvestLevel("axe", 0);
		KoentusBlocks.crystal_dirt.setHarvestLevel("shovel", 0);
		KoentusBlocks.crystal_farmland.setHarvestLevel("shovel", 0);
		KoentusBlocks.koentus_cobblestone_stairs.setHarvestLevel("pickaxe", 0);
		KoentusBlocks.koentus_dungeon_brick_stairs.setHarvestLevel("pickaxe", 0);
		KoentusBlocks.koentus_ancient_stone_stairs.setHarvestLevel("pickaxe", 0);
		KoentusBlocks.koentus_ancient_stone_brick_stairs.setHarvestLevel("pickaxe", 0);

		// Set fire burn
		CommonRegisterHelper.setFireBurn(KoentusBlocks.crystal_planks, 5, 20);
		CommonRegisterHelper.setFireBurn(KoentusBlocks.crystal_wood_stairs, 5, 20);
		CommonRegisterHelper.setFireBurn(KoentusBlocks.crystal_fence, 5, 20);
		CommonRegisterHelper.setFireBurn(KoentusBlocks.crystal_fence_gate, 5, 20);
		CommonRegisterHelper.setFireBurn(KoentusBlocks.crystal_log, 5, 5);
		CommonRegisterHelper.setFireBurn(KoentusBlocks.crystal_sapling, 60, 100);
		CommonRegisterHelper.setFireBurn(KoentusBlocks.crystal_leaves, 30, 60);

		// Register ore dictionary
		OreDictionary.registerOre("oreTin", new ItemStack(KoentusBlocks.koentus_block, 1, 4));
		OreDictionary.registerOre("oreCopper", new ItemStack(KoentusBlocks.koentus_block, 1, 5));
		OreDictionary.registerOre("oreWhiteCrystal", new ItemStack(KoentusBlocks.koentus_block, 1, 6));
		OreDictionary.registerOre("oreEMP", new ItemStack(KoentusBlocks.koentus_block, 1, 7));
		OreDictionary.registerOre("oreBecterialFossil", new ItemStack(KoentusBlocks.koentus_block, 1, 8));

		OreDictionary.registerOre("plankWood", new ItemStack(KoentusBlocks.crystal_planks, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("stairWood", new ItemStack(KoentusBlocks.crystal_wood_stairs));
		OreDictionary.registerOre("treeSapling", new ItemStack(KoentusBlocks.crystal_sapling, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("treeLeaves", new ItemStack(KoentusBlocks.crystal_leaves, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("logWood", new ItemStack(KoentusBlocks.crystal_log, 1, OreDictionary.WILDCARD_VALUE));

		OreDictionary.registerOre("blockWhiteCrystal", new ItemStack(KoentusBlocks.koentus_block, 1, 9));
		OreDictionary.registerOre("blockEMP", new ItemStack(KoentusBlocks.koentus_block, 1, 10));
	}
}