/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.nibiru.blocks;

import micdoodle8.mods.galacticraft.core.items.ItemBlockDesc;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.blocks.BlockDoorMP;
import stevekung.mods.moreplanets.common.blocks.BlockDoorMP.DoorType;
import stevekung.mods.moreplanets.common.blocks.BlockFenceGateMP;
import stevekung.mods.moreplanets.common.blocks.BlockStairsMP;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockDirtMP;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockSingleLeaves;
import stevekung.mods.moreplanets.core.init.MPBlocks;
import stevekung.mods.moreplanets.planets.nibiru.itemblocks.ItemBlockNibiru;
import stevekung.mods.moreplanets.planets.nibiru.itemblocks.ItemBlockNibiruFence;
import stevekung.mods.moreplanets.planets.nibiru.itemblocks.ItemBlockNibiruLog;
import stevekung.mods.moreplanets.planets.nibiru.itemblocks.ItemBlockNibiruSapling;
import stevekung.mods.moreplanets.planets.nibiru.itemblocks.ItemBlockNibiruWoodPlanks;
import stevekung.mods.moreplanets.planets.nibiru.itemblocks.ItemBlockOilRock;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class NibiruBlocks
{
	public static Block nibiru_block;
	public static Block nibiru_cobblestone_stairs;
	public static Block ancient_dark_wood_stairs;
	public static Block nibiru_treasure_chest;
	public static Block nibiru_ancient_chest;
	public static Block nibiru_sapling;
	public static Block helium_block;
	public static Block infected_worm_egg_rock;
	public static Block infected_zombie_egg;
	public static Block ancient_dark_leaves;
	public static Block nibiru_log;
	public static Block nibiru_planks;
	public static Block power_crystal_generator;
	public static Block ichorius_torch;
	public static Block orange_leaves;
	public static Block orange_wood_stairs;
	public static Block infected_grass;
	public static Block infected_dirt;
	public static Block oil_rock;
	public static Block infected_vine;
	public static Block nibiru_dungeon_brick_stairs;
	public static Block infected_farmland;
	public static Block nibiru_fence;
	public static Block infected_orange_rose_bush;
	public static Block ancient_dark_fence_gate;
	public static Block orange_fence_gate;
	public static Block infected_cavernous_vine;
	public static Block ancient_dark_door;
	public static Block orange_door;

	public static void init()
	{
		// Init
		NibiruBlocks.nibiru_block = new BlockNibiru("nibiru_block");
		NibiruBlocks.nibiru_treasure_chest = new BlockNibiruTreasureChest("nibiru_treasure_chest");
		NibiruBlocks.nibiru_ancient_chest = new BlockNibiruAncientChest("nibiru_ancient_chest");
		NibiruBlocks.nibiru_sapling = new BlockNibiruSapling("nibiru_sapling");
		NibiruBlocks.helium_block = new BlockHelium("helium_block");
		NibiruBlocks.infected_worm_egg_rock = new BlockInfectedWormEggRock("infected_worm_egg_rock");
		NibiruBlocks.infected_zombie_egg = new BlockInfectedZombieEgg("infected_zombie_egg");
		NibiruBlocks.ancient_dark_leaves = new BlockAncientDarkLeaves("ancient_dark_leaves");
		NibiruBlocks.nibiru_log = new BlockNibiruLog("nibiru_log");
		NibiruBlocks.nibiru_planks = new BlockNibiruPlanks("nibiru_planks");
		NibiruBlocks.power_crystal_generator = new BlockPowerCrystalGenerator("power_crystal_generator");
		NibiruBlocks.ichorius_torch = new BlockIchoriusTorch("ichorius_torch");
		NibiruBlocks.ancient_dark_wood_stairs = new BlockStairsMP(Blocks.planks.getDefaultState(), "ancient_dark_wood_stairs", "wood", null, 2.0F);
		NibiruBlocks.nibiru_cobblestone_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "nibiru_cobblestone_stairs", 4.25F);
		NibiruBlocks.orange_leaves = new BlockOrangeLeaves("orange_leaves");
		NibiruBlocks.orange_wood_stairs = new BlockStairsMP(Blocks.planks.getDefaultState(), "orange_wood_stairs", "wood", null, 2.0F);
		NibiruBlocks.infected_grass = new BlockInfectedGrass("infected_grass");
		NibiruBlocks.infected_dirt = new BlockInfectedDirt("infected_dirt");
		NibiruBlocks.oil_rock = new BlockOilRock("oil_rock");
		NibiruBlocks.infected_vine = new BlockInfectedVine("infected_vine");
		NibiruBlocks.infected_orange_rose_bush = new BlockInfectedOrangeRoseBush("infected_orange_rose_bush");
		NibiruBlocks.nibiru_dungeon_brick_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "nibiru_dungeon_brick_stairs", 4.0F);
		NibiruBlocks.infected_farmland = new BlockInfectedFarmland("infected_farmland");
		NibiruBlocks.nibiru_fence = new BlockNibiruFence("nibiru_fence");
		NibiruBlocks.ancient_dark_fence_gate = new BlockFenceGateMP("ancient_dark_fence_gate");
		NibiruBlocks.orange_fence_gate = new BlockFenceGateMP("orange_fence_gate");
		NibiruBlocks.infected_cavernous_vine = new BlockInfectedCavernousVine("infected_cavernous_vine");
		NibiruBlocks.ancient_dark_door = new BlockDoorMP("ancient_dark_door_block", DoorType.ANCIENT_DARK);
		NibiruBlocks.orange_door = new BlockDoorMP("orange_door_block", DoorType.ORANGE);

		// Register
		CommonRegisterHelper.registerBlock(NibiruBlocks.nibiru_block, ItemBlockNibiru.class);
		CommonRegisterHelper.registerBlock(NibiruBlocks.infected_grass);
		CommonRegisterHelper.registerBlock(NibiruBlocks.infected_dirt, ItemBlockDirtMP.class);
		CommonRegisterHelper.registerBlock(NibiruBlocks.oil_rock, ItemBlockOilRock.class);
		CommonRegisterHelper.registerBlock(NibiruBlocks.helium_block);
		CommonRegisterHelper.registerBlock(NibiruBlocks.infected_worm_egg_rock);
		CommonRegisterHelper.registerBlock(NibiruBlocks.nibiru_log, ItemBlockNibiruLog.class);
		CommonRegisterHelper.registerBlock(NibiruBlocks.nibiru_planks, ItemBlockNibiruWoodPlanks.class);
		CommonRegisterHelper.registerBlock(NibiruBlocks.ancient_dark_leaves, ItemBlockSingleLeaves.class);
		CommonRegisterHelper.registerBlock(NibiruBlocks.orange_leaves, ItemBlockSingleLeaves.class);
		CommonRegisterHelper.registerBlock(NibiruBlocks.ancient_dark_wood_stairs);
		CommonRegisterHelper.registerBlock(NibiruBlocks.orange_wood_stairs);
		CommonRegisterHelper.registerBlock(NibiruBlocks.nibiru_cobblestone_stairs);
		CommonRegisterHelper.registerBlock(NibiruBlocks.nibiru_dungeon_brick_stairs);
		CommonRegisterHelper.registerBlock(NibiruBlocks.power_crystal_generator, ItemBlockDesc.class);
		CommonRegisterHelper.registerBlock(NibiruBlocks.nibiru_fence, ItemBlockNibiruFence.class);
		CommonRegisterHelper.registerBlock(NibiruBlocks.ancient_dark_fence_gate);
		CommonRegisterHelper.registerBlock(NibiruBlocks.orange_fence_gate);
		CommonRegisterHelper.registerBlock(NibiruBlocks.nibiru_treasure_chest);
		CommonRegisterHelper.registerBlock(NibiruBlocks.nibiru_ancient_chest);
		CommonRegisterHelper.registerBlock(NibiruBlocks.infected_zombie_egg);
		CommonRegisterHelper.registerBlock(NibiruBlocks.nibiru_sapling, ItemBlockNibiruSapling.class);
		CommonRegisterHelper.registerBlock(NibiruBlocks.infected_vine);
		CommonRegisterHelper.registerBlock(NibiruBlocks.infected_orange_rose_bush);
		CommonRegisterHelper.registerBlock(NibiruBlocks.infected_cavernous_vine);
		CommonRegisterHelper.registerBlock(NibiruBlocks.ichorius_torch);
		CommonRegisterHelper.registerBlock(NibiruBlocks.infected_farmland);
		CommonRegisterHelper.registerBlock(NibiruBlocks.ancient_dark_door);
		CommonRegisterHelper.registerBlock(NibiruBlocks.orange_door);

		// Set harvest level
		NibiruBlocks.ancient_dark_wood_stairs.setHarvestLevel("axe", 0);
		NibiruBlocks.nibiru_ancient_chest.setHarvestLevel("axe", 0);
		NibiruBlocks.nibiru_log.setHarvestLevel("axe", 0);
		NibiruBlocks.nibiru_planks.setHarvestLevel("axe", 0);
		NibiruBlocks.orange_wood_stairs.setHarvestLevel("axe", 0);
		NibiruBlocks.nibiru_fence.setHarvestLevel("axe", 0);
		NibiruBlocks.ancient_dark_fence_gate.setHarvestLevel("axe", 0);
		NibiruBlocks.orange_fence_gate.setHarvestLevel("axe", 0);
		NibiruBlocks.ancient_dark_door.setHarvestLevel("axe", 0);
		NibiruBlocks.orange_door.setHarvestLevel("axe", 0);
		NibiruBlocks.infected_grass.setHarvestLevel("shovel", 0);
		NibiruBlocks.infected_dirt.setHarvestLevel("shovel", 0);
		NibiruBlocks.infected_farmland.setHarvestLevel("shovel", 0);
		NibiruBlocks.nibiru_block.setHarvestLevel("pickaxe", 0);
		NibiruBlocks.nibiru_cobblestone_stairs.setHarvestLevel("pickaxe", 0);
		NibiruBlocks.nibiru_dungeon_brick_stairs.setHarvestLevel("pickaxe", 0);
		NibiruBlocks.oil_rock.setHarvestLevel("pickaxe", 0);
		NibiruBlocks.infected_worm_egg_rock.setHarvestLevel("pickaxe", 0);
		NibiruBlocks.power_crystal_generator.setHarvestLevel("pickaxe", 2);

		// Set fire burn
		CommonRegisterHelper.setFireBurn(NibiruBlocks.ancient_dark_leaves, 30, 60);
		CommonRegisterHelper.setFireBurn(NibiruBlocks.orange_leaves, 30, 60);
		CommonRegisterHelper.setFireBurn(NibiruBlocks.nibiru_planks, 5, 20);
		CommonRegisterHelper.setFireBurn(NibiruBlocks.ancient_dark_wood_stairs, 5, 20);
		CommonRegisterHelper.setFireBurn(NibiruBlocks.nibiru_fence, 5, 20);
		CommonRegisterHelper.setFireBurn(NibiruBlocks.ancient_dark_fence_gate, 5, 20);
		CommonRegisterHelper.setFireBurn(NibiruBlocks.orange_fence_gate, 5, 20);
		CommonRegisterHelper.setFireBurn(NibiruBlocks.orange_wood_stairs, 5, 20);
		CommonRegisterHelper.setFireBurn(NibiruBlocks.nibiru_sapling, 60, 100);
		CommonRegisterHelper.setFireBurn(NibiruBlocks.infected_vine, 15, 100);
		CommonRegisterHelper.setFireBurn(NibiruBlocks.infected_orange_rose_bush, 15, 100);
		CommonRegisterHelper.setFireBurn(NibiruBlocks.nibiru_log, 5, 5);

		// Register ore dictionary
		OreDictionary.registerOre("oreIchorius", new ItemStack(NibiruBlocks.nibiru_block, 1, 4));
		OreDictionary.registerOre("oreNorium", new ItemStack(NibiruBlocks.nibiru_block, 1, 5));
		OreDictionary.registerOre("oreDiamond", new ItemStack(NibiruBlocks.nibiru_block, 1, 6));
		OreDictionary.registerOre("oreCoal", new ItemStack(NibiruBlocks.nibiru_block, 1, 7));
		OreDictionary.registerOre("oreRedGem", new ItemStack(NibiruBlocks.nibiru_block, 1, 8));
		OreDictionary.registerOre("oreOil", new ItemStack(NibiruBlocks.oil_rock, 1, 0));
		OreDictionary.registerOre("oreOil", new ItemStack(NibiruBlocks.oil_rock, 1, 1));

		OreDictionary.registerOre("plankWood", new ItemStack(NibiruBlocks.nibiru_planks, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("slabWood", new ItemStack(MPBlocks.half_wooden_slab_1, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("stairWood", new ItemStack(NibiruBlocks.ancient_dark_wood_stairs));
		OreDictionary.registerOre("stairWood", new ItemStack(NibiruBlocks.orange_wood_stairs));
		OreDictionary.registerOre("treeSapling", new ItemStack(NibiruBlocks.nibiru_sapling, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("treeLeaves", new ItemStack(NibiruBlocks.ancient_dark_leaves, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("treeLeaves", new ItemStack(NibiruBlocks.orange_leaves, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("logWood", new ItemStack(NibiruBlocks.nibiru_log, 1, OreDictionary.WILDCARD_VALUE));

		OreDictionary.registerOre("blockIchorius", new ItemStack(NibiruBlocks.nibiru_block, 1, 9));
		OreDictionary.registerOre("blockNorium", new ItemStack(NibiruBlocks.nibiru_block, 1, 10));
		OreDictionary.registerOre("blockRedGem", new ItemStack(NibiruBlocks.nibiru_block, 1, 11));
	}
}