/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core.init;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import stevekung.mods.moreplanets.core.blocks.BlockDungeonBrickSlab;
import stevekung.mods.moreplanets.core.blocks.BlockDungeonBrickSlab.DungeonSlabCategory;
import stevekung.mods.moreplanets.core.blocks.BlockDungeonBrickWall;
import stevekung.mods.moreplanets.core.blocks.BlockSlabMP;
import stevekung.mods.moreplanets.core.blocks.BlockSlabMP.SlabCategory;
import stevekung.mods.moreplanets.core.blocks.BlockTintedGlass;
import stevekung.mods.moreplanets.core.blocks.BlockTintedGlassPane;
import stevekung.mods.moreplanets.core.blocks.BlockWallMP;
import stevekung.mods.moreplanets.core.blocks.base.BlockChondrite;
import stevekung.mods.moreplanets.core.itemblocks.ItemBlockChondrite;
import stevekung.mods.moreplanets.core.itemblocks.ItemBlockDungeonBrickSlab;
import stevekung.mods.moreplanets.core.itemblocks.ItemBlockDungeonBrickWall;
import stevekung.mods.moreplanets.core.itemblocks.ItemBlockSlabMP;
import stevekung.mods.moreplanets.core.itemblocks.ItemBlockTintedGlassPane;
import stevekung.mods.moreplanets.core.itemblocks.ItemBlockWallMP;
import stevekung.mods.moreplanets.moons.deimos.blocks.DeimosBlocks;
import stevekung.mods.moreplanets.moons.europa.blocks.EuropaBlocks;
import stevekung.mods.moreplanets.moons.io.blocks.IoBlocks;
import stevekung.mods.moreplanets.moons.koentus.blocks.KoentusBlocks;
import stevekung.mods.moreplanets.moons.phobos.blocks.PhobosBlocks;
import stevekung.mods.moreplanets.planets.diona.blocks.DionaBlocks;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.KapteynBBlocks;
import stevekung.mods.moreplanets.planets.mercury.blocks.MercuryBlocks;
import stevekung.mods.moreplanets.planets.nibiru.blocks.NibiruBlocks;
import stevekung.mods.moreplanets.planets.pluto.blocks.PlutoBlocks;
import stevekung.mods.moreplanets.planets.polongnius.blocks.PolongniusBlocks;
import stevekung.mods.moreplanets.planets.siriusb.blocks.SiriusBBlocks;
import stevekung.mods.moreplanets.planets.venus.blocks.VenusBlocks;
import stevekung.mods.stevecore.RegisterHelper;

public class MPBlocks
{
	public static Block stone_slab_full;
	public static Block stone_slab_half;
	public static Block stone_slab_full2;
	public static Block stone_slab_half2;
	public static Block wooden_slab_full;
	public static Block wooden_slab_half;
	public static Block dungeon_brick_slab_full;
	public static Block dungeon_brick_slab_half;
	public static Block chondrite_block;
	public static Block tinted_glass;
	public static Block tinted_glass_pane;

	public static Block stone_wall;
	public static Block dungeon_brick_wall;

	public static ArrayList<Block> highlightBlockList = new ArrayList();
	public static ArrayList<Block> hideBlockList = new ArrayList();

	public static void init()
	{
		MPBlocks.initBlocks();
		MPBlocks.initSlabBlocks();
		MPBlocks.setHarvestLevels();
		MPBlocks.registerBlocks();
		MPBlocks.setFireBurn();

		DionaBlocks.init();
		PolongniusBlocks.init();
		NibiruBlocks.init();
		KoentusBlocks.init();
		FronosBlocks.init();
		KapteynBBlocks.init();
		SiriusBBlocks.init();

		MercuryBlocks.init();
		VenusBlocks.init();
		PlutoBlocks.init();
		PhobosBlocks.init();
		DeimosBlocks.init();
		IoBlocks.init();
		EuropaBlocks.init();

		MPBlocks.initNEI();
	}

	private static void initBlocks()
	{
		MPBlocks.stone_wall = new BlockWallMP("mp_wall");
		MPBlocks.dungeon_brick_wall = new BlockDungeonBrickWall("mp_dungeon_brick_wall");
		MPBlocks.chondrite_block = new BlockChondrite("chondrite_block");
		MPBlocks.tinted_glass = new BlockTintedGlass("tinted_glass");
		MPBlocks.tinted_glass_pane = new BlockTintedGlassPane("tinted_glass_pane");
	}

	private static void initSlabBlocks()
	{
		MPBlocks.stone_slab_half = new BlockSlabMP("mp_stone_half_slab1", false, Material.rock, SlabCategory.WOOD1);
		MPBlocks.stone_slab_full = new BlockSlabMP("mp_stone_double_slab1", true, Material.rock, SlabCategory.WOOD1);
		MPBlocks.stone_slab_half2 = new BlockSlabMP("mp_stone_half_slab2", false, Material.rock, SlabCategory.WOOD2);
		MPBlocks.stone_slab_full2 = new BlockSlabMP("mp_stone_double_slab2", true, Material.rock, SlabCategory.WOOD2);
		MPBlocks.wooden_slab_half = new BlockSlabMP("mp_wood_half_slab", false, Material.wood, SlabCategory.STONE);
		MPBlocks.wooden_slab_full = new BlockSlabMP("mp_wood_double_slab", true, Material.wood, SlabCategory.STONE);
		MPBlocks.dungeon_brick_slab_half = new BlockDungeonBrickSlab("dungeon_brick_half_slab1", false, Material.rock, DungeonSlabCategory.WOOD1);
		MPBlocks.dungeon_brick_slab_full = new BlockDungeonBrickSlab("dungeon_brick_double_slab1", true, Material.rock, DungeonSlabCategory.WOOD1);
	}

	private static void setHarvestLevels()
	{
		MPBlocks.stone_slab_full.setHarvestLevel("pickaxe", 1, 0);
		MPBlocks.stone_slab_full.setHarvestLevel("pickaxe", 1, 1);
		MPBlocks.stone_slab_full.setHarvestLevel("pickaxe", 1, 2);
		MPBlocks.stone_slab_full.setHarvestLevel("pickaxe", 1, 3);
		MPBlocks.stone_slab_full.setHarvestLevel("pickaxe", 1, 4);
		MPBlocks.stone_slab_full.setHarvestLevel("pickaxe", 1, 5);
		MPBlocks.stone_slab_full.setHarvestLevel("pickaxe", 1, 6);
		MPBlocks.stone_slab_full.setHarvestLevel("pickaxe", 1, 7);

		MPBlocks.stone_slab_half.setHarvestLevel("pickaxe", 1, 0);
		MPBlocks.stone_slab_half.setHarvestLevel("pickaxe", 1, 1);
		MPBlocks.stone_slab_half.setHarvestLevel("pickaxe", 1, 2);
		MPBlocks.stone_slab_half.setHarvestLevel("pickaxe", 1, 3);
		MPBlocks.stone_slab_half.setHarvestLevel("pickaxe", 1, 4);
		MPBlocks.stone_slab_half.setHarvestLevel("pickaxe", 1, 5);
		MPBlocks.stone_slab_half.setHarvestLevel("pickaxe", 1, 6);
		MPBlocks.stone_slab_half.setHarvestLevel("pickaxe", 1, 7);

		MPBlocks.stone_slab_full2.setHarvestLevel("pickaxe", 1, 0);
		MPBlocks.stone_slab_full2.setHarvestLevel("pickaxe", 1, 1);
		MPBlocks.stone_slab_full2.setHarvestLevel("pickaxe", 1, 2);
		MPBlocks.stone_slab_full2.setHarvestLevel("pickaxe", 1, 3);
		MPBlocks.stone_slab_full2.setHarvestLevel("pickaxe", 1, 4);
		MPBlocks.stone_slab_full2.setHarvestLevel("pickaxe", 1, 5);

		MPBlocks.stone_slab_half2.setHarvestLevel("pickaxe", 1, 0);
		MPBlocks.stone_slab_half2.setHarvestLevel("pickaxe", 1, 1);
		MPBlocks.stone_slab_half2.setHarvestLevel("pickaxe", 1, 2);
		MPBlocks.stone_slab_half2.setHarvestLevel("pickaxe", 1, 3);
		MPBlocks.stone_slab_half2.setHarvestLevel("pickaxe", 1, 4);
		MPBlocks.stone_slab_half2.setHarvestLevel("pickaxe", 1, 5);

		MPBlocks.wooden_slab_full.setHarvestLevel("axe", 0);
		MPBlocks.wooden_slab_full.setHarvestLevel("axe", 0);

		MPBlocks.wooden_slab_half.setHarvestLevel("axe", 0);
		MPBlocks.wooden_slab_half.setHarvestLevel("axe", 0);

		MPBlocks.chondrite_block.setHarvestLevel("pickaxe", 1);
		MPBlocks.dungeon_brick_slab_half.setHarvestLevel("pickaxe", 1);
		MPBlocks.dungeon_brick_slab_full.setHarvestLevel("pickaxe", 1);

		MPBlocks.stone_wall.setHarvestLevel("pickaxe", 1, 0);
		MPBlocks.stone_wall.setHarvestLevel("pickaxe", 1, 1);
		MPBlocks.stone_wall.setHarvestLevel("pickaxe", 1, 2);
		MPBlocks.stone_wall.setHarvestLevel("pickaxe", 1, 3);
		MPBlocks.stone_wall.setHarvestLevel("pickaxe", 1, 4);
		MPBlocks.stone_wall.setHarvestLevel("pickaxe", 1, 5);
		MPBlocks.stone_wall.setHarvestLevel("pickaxe", 1, 6);
		MPBlocks.stone_wall.setHarvestLevel("pickaxe", 1, 7);
		MPBlocks.stone_wall.setHarvestLevel("pickaxe", 1, 8);
		MPBlocks.stone_wall.setHarvestLevel("pickaxe", 1, 9);
		MPBlocks.stone_wall.setHarvestLevel("pickaxe", 1, 10);
		MPBlocks.stone_wall.setHarvestLevel("pickaxe", 1, 11);
		MPBlocks.stone_wall.setHarvestLevel("pickaxe", 1, 12);
		MPBlocks.stone_wall.setHarvestLevel("pickaxe", 1, 13);

		MPBlocks.dungeon_brick_wall.setHarvestLevel("pickaxe", 1);
	}

	private static void setFireBurn()
	{
		RegisterHelper.setFireBurn(MPBlocks.wooden_slab_half, 5, 20);
		RegisterHelper.setFireBurn(MPBlocks.wooden_slab_full, 5, 20);
	}

	private static void registerBlocks()
	{
		RegisterHelper.registerBlock(MPBlocks.chondrite_block, ItemBlockChondrite.class);
		RegisterHelper.registerBlock(MPBlocks.tinted_glass, ItemBlockTintedGlassPane.class);
		RegisterHelper.registerBlock(MPBlocks.tinted_glass_pane, ItemBlockTintedGlassPane.class);
		RegisterHelper.registerBlock(MPBlocks.stone_wall, ItemBlockWallMP.class);
		RegisterHelper.registerBlock(MPBlocks.dungeon_brick_wall, ItemBlockDungeonBrickWall.class);
		RegisterHelper.registerBlock(stone_slab_half, ItemBlockSlabMP.class, stone_slab_half, stone_slab_full);
		RegisterHelper.registerBlock(stone_slab_full, ItemBlockSlabMP.class, stone_slab_half, stone_slab_full);
		RegisterHelper.registerBlock(stone_slab_half2, ItemBlockSlabMP.class, stone_slab_half2, stone_slab_full2);
		RegisterHelper.registerBlock(stone_slab_full2, ItemBlockSlabMP.class, stone_slab_half2, stone_slab_full2);
		RegisterHelper.registerBlock(wooden_slab_half, ItemBlockSlabMP.class, wooden_slab_half, wooden_slab_full);
		RegisterHelper.registerBlock(wooden_slab_full, ItemBlockSlabMP.class, wooden_slab_half, wooden_slab_full);
		RegisterHelper.registerBlock(dungeon_brick_slab_half, ItemBlockDungeonBrickSlab.class, dungeon_brick_slab_half, dungeon_brick_slab_full);
		RegisterHelper.registerBlock(dungeon_brick_slab_full, ItemBlockDungeonBrickSlab.class, dungeon_brick_slab_half, dungeon_brick_slab_full);
	}

	private static void initNEI()
	{
		highlightBlockList.add(MPBlocks.stone_slab_full);
		highlightBlockList.add(MPBlocks.stone_slab_full2);
		highlightBlockList.add(MPBlocks.wooden_slab_full);
		highlightBlockList.add(MPBlocks.dungeon_brick_slab_full);
		highlightBlockList.add(DionaBlocks.diona_block);
		highlightBlockList.add(PolongniusBlocks.polongnius_block);
		highlightBlockList.add(NibiruBlocks.nibiru_block);
		highlightBlockList.add(NibiruBlocks.ancient_dark_leaves);
		highlightBlockList.add(NibiruBlocks.orange_leaves);
		highlightBlockList.add(KoentusBlocks.koentus_block);
		highlightBlockList.add(KoentusBlocks.koentus_ice);
		highlightBlockList.add(FronosBlocks.fronos_block);
		highlightBlockList.add(FronosBlocks.frosted_cake);
		highlightBlockList.add(FronosBlocks.fronos_tall_grass);
		highlightBlockList.add(KapteynBBlocks.kapteyn_b_block);
		highlightBlockList.add(KapteynBBlocks.kapteyn_b_ice);
		highlightBlockList.add(KapteynBBlocks.uranium_waste);
		highlightBlockList.add(SiriusBBlocks.sirius_b_block);
		highlightBlockList.add(MercuryBlocks.mercury_block);
		highlightBlockList.add(VenusBlocks.venus_block);
		highlightBlockList.add(VenusBlocks.venus_redstone_ore_active);
		highlightBlockList.add(PlutoBlocks.pluto_block);

		hideBlockList.add(MPBlocks.stone_slab_full);
		hideBlockList.add(MPBlocks.stone_slab_full2);
		hideBlockList.add(MPBlocks.wooden_slab_full);
		hideBlockList.add(MPBlocks.dungeon_brick_slab_full);
		hideBlockList.add(PolongniusBlocks.ultra_violet_solar_fake);
		hideBlockList.add(PolongniusBlocks.cheese_of_milk);
		hideBlockList.add(NibiruBlocks.ancient_dark_door);
		hideBlockList.add(NibiruBlocks.orange_door);
		hideBlockList.add(NibiruBlocks.infected_farmland);
		hideBlockList.add(FronosBlocks.fronos_farmland);
		hideBlockList.add(FronosBlocks.candy_extractor_active);
		hideBlockList.add(FronosBlocks.strawberry_crops);
		hideBlockList.add(FronosBlocks.golden_crops);
		hideBlockList.add(FronosBlocks.glass_gem_corn1);
		hideBlockList.add(FronosBlocks.glass_gem_corn2);
		hideBlockList.add(FronosBlocks.glass_gem_corn3);
		hideBlockList.add(FronosBlocks.coconut_door);
		hideBlockList.add(FronosBlocks.maple_door);
		hideBlockList.add(FronosBlocks.coconut_milk);
		hideBlockList.add(FronosBlocks.mineral_water);
		hideBlockList.add(FronosBlocks.ovantine);
		hideBlockList.add(FronosBlocks.tea);
		hideBlockList.add(FronosBlocks.caramel);
		hideBlockList.add(FronosBlocks.cup);
		hideBlockList.add(FronosBlocks.mineral_water_cup);
		hideBlockList.add(FronosBlocks.cheese_of_milk_cup);
		hideBlockList.add(FronosBlocks.ovantine_cup);
		hideBlockList.add(FronosBlocks.coconut_milk_cup);
		hideBlockList.add(FronosBlocks.tea_cup);
		hideBlockList.add(FronosBlocks.caramel_cup);
		hideBlockList.add(KapteynBBlocks.frozen_water);
		hideBlockList.add(KapteynBBlocks.chest_temp);
		hideBlockList.add(KoentusBlocks.crystal_door);
		hideBlockList.add(KoentusBlocks.crystal_farmland);
		hideBlockList.add(SiriusBBlocks.sirius_lava);
		hideBlockList.add(SiriusBBlocks.sirius_fire);
		hideBlockList.add(SiriusBBlocks.sirius_redstone_lamp_on);
		hideBlockList.add(IoBlocks.io_lava);
		hideBlockList.add(IoBlocks.liquid_red_sulfur);
		hideBlockList.add(IoBlocks.liquid_yellow_sulfur);
		hideBlockList.add(IoBlocks.liquid_orange_sulfur);
		hideBlockList.add(IoBlocks.liquid_brown_sulfur);
		hideBlockList.add(IoBlocks.io_black_lava);
		hideBlockList.add(VenusBlocks.venus_redstone_ore_active);
		hideBlockList.add(PlutoBlocks.liquid_methane);
		hideBlockList.add(PlutoBlocks.liquid_nitrogen);
		hideBlockList.add(PlutoBlocks.space_potato_block);
		hideBlockList.add(MercuryBlocks.dirty_water);
		hideBlockList.add(EuropaBlocks.europa_water);
		hideBlockList.add(EuropaBlocks.europa_door);
		hideBlockList.add(EuropaBlocks.double_europa_sandstone_slab);
		hideBlockList.add(VenusBlocks.double_venus_sandstone_slab);
		hideBlockList.add(FronosBlocks.double_fronos_sandstone_slab);
	}
}