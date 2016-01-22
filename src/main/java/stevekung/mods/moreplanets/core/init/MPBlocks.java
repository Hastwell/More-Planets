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
import stevekung.mods.moreplanets.asteroids.darkasteroids.blocks.DarkAsteroidBlocks;
import stevekung.mods.moreplanets.common.blocks.other.BlockChondriteRock;
import stevekung.mods.moreplanets.common.blocks.other.BlockDoubleDungeonBrickSlab1;
import stevekung.mods.moreplanets.common.blocks.other.BlockDoubleDungeonBrickSlab2;
import stevekung.mods.moreplanets.common.blocks.other.BlockDoubleStoneSlab1;
import stevekung.mods.moreplanets.common.blocks.other.BlockDoubleStoneSlab2;
import stevekung.mods.moreplanets.common.blocks.other.BlockDoubleWoodenSlab1;
import stevekung.mods.moreplanets.common.blocks.other.BlockDummy;
import stevekung.mods.moreplanets.common.blocks.other.BlockDungeonBrickSlab1;
import stevekung.mods.moreplanets.common.blocks.other.BlockDungeonBrickSlab2;
import stevekung.mods.moreplanets.common.blocks.other.BlockDungeonBrickWall;
import stevekung.mods.moreplanets.common.blocks.other.BlockDungeonSpawner;
import stevekung.mods.moreplanets.common.blocks.other.BlockPolishedSpaceDecoration;
import stevekung.mods.moreplanets.common.blocks.other.BlockSpaceMossyCobblestone;
import stevekung.mods.moreplanets.common.blocks.other.BlockSpaceWall;
import stevekung.mods.moreplanets.common.blocks.other.BlockStoneSlab1;
import stevekung.mods.moreplanets.common.blocks.other.BlockStoneSlab2;
import stevekung.mods.moreplanets.common.blocks.other.BlockTintedGlass;
import stevekung.mods.moreplanets.common.blocks.other.BlockTintedGlassPane;
import stevekung.mods.moreplanets.common.blocks.other.BlockWoodenSlab1;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockColoredMP;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockDungeonBrickSlab1;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockDungeonBrickSlab2;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockMultiVariant;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockStoneSlab1MP;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockStoneSlab2MP;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockWoodenSlab1MP;
import stevekung.mods.moreplanets.common.util.MPLog;
import stevekung.mods.moreplanets.common.util.VariantsName;
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
import stevekung.mods.stevecore.CommonRegisterHelper;

public class MPBlocks
{
    public static Block half_stone_slab_1;
    public static Block double_stone_slab_1;
    public static Block half_stone_slab_2;
    public static Block double_stone_slab_2;
    public static Block half_wooden_slab_1;
    public static Block double_wooden_slab_1;
    public static Block half_dungeon_brick_slab_1;
    public static Block double_dungeon_brick_slab_1;
    public static Block half_dungeon_brick_slab_2;
    public static Block double_dungeon_brick_slab_2;

    public static Block stone_wall;
    public static Block dungeon_brick_wall;

    public static Block dummy_block;
    public static Block dungeon_spawner;
    public static Block chondrite_rock;
    public static Block tinted_glass;
    public static Block tinted_glass_pane;
    public static Block polished_space_decoration;
    public static Block space_mossy_cobblestone;

    public static ArrayList<Block> highlightBlockList = new ArrayList();
    public static ArrayList<Block> hideBlockList = new ArrayList();

    public static void init()
    {
        // Init
        MPBlocks.stone_wall = new BlockSpaceWall("stone_wall");
        MPBlocks.dungeon_brick_wall = new BlockDungeonBrickWall("dungeon_brick_wall");

        MPBlocks.half_stone_slab_1 = new BlockStoneSlab1("half_stone_slab_1", Material.rock);
        MPBlocks.double_stone_slab_1 = new BlockDoubleStoneSlab1("double_stone_slab_1", Material.rock);
        MPBlocks.half_stone_slab_2 = new BlockStoneSlab2("half_stone_slab_2", Material.rock);
        MPBlocks.double_stone_slab_2 = new BlockDoubleStoneSlab2("double_stone_slab_2", Material.rock);
        MPBlocks.half_wooden_slab_1 = new BlockWoodenSlab1("half_wooden_slab_1", Material.wood);
        MPBlocks.double_wooden_slab_1 = new BlockDoubleWoodenSlab1("double_wooden_slab_1", Material.wood);
        MPBlocks.half_dungeon_brick_slab_1 = new BlockDungeonBrickSlab1("half_dungeon_brick_slab_1", Material.rock);
        MPBlocks.double_dungeon_brick_slab_1 = new BlockDoubleDungeonBrickSlab1("double_dungeon_brick_slab_1", Material.rock);
        MPBlocks.half_dungeon_brick_slab_2 = new BlockDungeonBrickSlab2("half_dungeon_brick_slab_2", Material.rock);
        MPBlocks.double_dungeon_brick_slab_2 = new BlockDoubleDungeonBrickSlab2("double_dungeon_brick_slab_2", Material.rock);

        MPBlocks.dummy_block = new BlockDummy("dummy_block");
        MPBlocks.dungeon_spawner = new BlockDungeonSpawner("dungeon_spawner_mp");
        MPBlocks.chondrite_rock = new BlockChondriteRock("chondrite_rock");
        MPBlocks.tinted_glass = new BlockTintedGlass("tinted_glass");
        MPBlocks.tinted_glass_pane = new BlockTintedGlassPane("tinted_glass_pane");
        MPBlocks.polished_space_decoration = new BlockPolishedSpaceDecoration("polished_space_decoration");
        MPBlocks.space_mossy_cobblestone = new BlockSpaceMossyCobblestone("space_mossy_cobblestone");

        // Register
        CommonRegisterHelper.registerBlock(MPBlocks.stone_wall, ItemBlockMultiVariant.class, new VariantsName("diona_cobblestone", "quontonium_brick", "chiseled_quontonium", "polongnius_cobblestone", "nibiru_cobblestone", "koentus_cobblestone", "koentus_ancient_stone", "koentus_ancient_stone_brick", "fronos_cobblestone", "fronos_stone_brick", "cracked_fronos_stone_brick", "kapteyn_b_cracked_ice", "sirius_b_carbon_cobblestone", "mercury_cobblestone", "venus_cobblestone", "pluto_cobblestone"));
        CommonRegisterHelper.registerBlock(MPBlocks.dungeon_brick_wall, ItemBlockMultiVariant.class, new VariantsName("diona_dungeon_brick", "polongnius_dungeon_brick", "nibiru_dungeon_brick", "koentus_dungeon_brick", "fronos_dungeon_brick", "kapteyn_b_dungeon_brick", "sirius_dungeon_brick", "mercury_dungeon_brick", "venus_dungeon_brick", "pluto_dungeon_brick"));
        CommonRegisterHelper.registerBlock(MPBlocks.half_stone_slab_1, ItemBlockStoneSlab1MP.class, MPBlocks.half_stone_slab_1, MPBlocks.double_stone_slab_1);
        CommonRegisterHelper.registerBlock(MPBlocks.double_stone_slab_1, ItemBlockStoneSlab1MP.class, MPBlocks.half_stone_slab_1, MPBlocks.double_stone_slab_1);
        CommonRegisterHelper.registerBlock(MPBlocks.half_stone_slab_2, ItemBlockStoneSlab2MP.class, MPBlocks.half_stone_slab_2, MPBlocks.double_stone_slab_2);
        CommonRegisterHelper.registerBlock(MPBlocks.double_stone_slab_2, ItemBlockStoneSlab2MP.class, MPBlocks.half_stone_slab_2, MPBlocks.double_stone_slab_2);
        CommonRegisterHelper.registerBlock(MPBlocks.half_wooden_slab_1, ItemBlockWoodenSlab1MP.class, MPBlocks.half_wooden_slab_1, MPBlocks.double_wooden_slab_1);
        CommonRegisterHelper.registerBlock(MPBlocks.double_wooden_slab_1, ItemBlockWoodenSlab1MP.class, MPBlocks.half_wooden_slab_1, MPBlocks.double_wooden_slab_1);
        CommonRegisterHelper.registerBlock(MPBlocks.half_dungeon_brick_slab_1, ItemBlockDungeonBrickSlab1.class, MPBlocks.half_dungeon_brick_slab_1, MPBlocks.double_dungeon_brick_slab_1);
        CommonRegisterHelper.registerBlock(MPBlocks.double_dungeon_brick_slab_1, ItemBlockDungeonBrickSlab1.class, MPBlocks.half_dungeon_brick_slab_1, MPBlocks.double_dungeon_brick_slab_1);
        CommonRegisterHelper.registerBlock(MPBlocks.half_dungeon_brick_slab_2, ItemBlockDungeonBrickSlab2.class, MPBlocks.half_dungeon_brick_slab_2, MPBlocks.double_dungeon_brick_slab_2);
        CommonRegisterHelper.registerBlock(MPBlocks.double_dungeon_brick_slab_2, ItemBlockDungeonBrickSlab2.class, MPBlocks.half_dungeon_brick_slab_2, MPBlocks.double_dungeon_brick_slab_2);
        CommonRegisterHelper.registerBlock(MPBlocks.chondrite_rock, ItemBlockMultiVariant.class, new VariantsName("rock", "polished", "stone_brick"));
        CommonRegisterHelper.registerBlock(MPBlocks.polished_space_decoration, ItemBlockMultiVariant.class, new VariantsName("tin", "aluminum"));
        CommonRegisterHelper.registerBlock(MPBlocks.space_mossy_cobblestone, ItemBlockMultiVariant.class, new VariantsName("diona", "polongnius", "nibiru", "koentus", "fronos", "kapteynb", "siriusb", "venus", "mercury", "pluto", "martian"));
        CommonRegisterHelper.registerBlock(MPBlocks.tinted_glass, ItemBlockColoredMP.class);
        CommonRegisterHelper.registerBlock(MPBlocks.tinted_glass_pane, ItemBlockColoredMP.class);
        CommonRegisterHelper.registerBlock(MPBlocks.dummy_block);
        CommonRegisterHelper.registerBlock(MPBlocks.dungeon_spawner);

        // Init planets block
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
        DarkAsteroidBlocks.init();

        // Set harvest level
        CommonRegisterHelper.setBlockHarvestLevel(MPBlocks.half_stone_slab_1, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(MPBlocks.half_stone_slab_2, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(MPBlocks.double_stone_slab_1, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(MPBlocks.double_stone_slab_2, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(MPBlocks.half_wooden_slab_1, "axe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(MPBlocks.double_wooden_slab_1, "axe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(MPBlocks.half_dungeon_brick_slab_1, "pickaxe", 1);
        CommonRegisterHelper.setBlockHarvestLevel(MPBlocks.double_dungeon_brick_slab_1, "pickaxe", 1);
        CommonRegisterHelper.setBlockHarvestLevel(MPBlocks.half_dungeon_brick_slab_2, "pickaxe", 1);
        CommonRegisterHelper.setBlockHarvestLevel(MPBlocks.double_dungeon_brick_slab_2, "pickaxe", 1);
        CommonRegisterHelper.setBlockHarvestLevel(MPBlocks.stone_wall, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(MPBlocks.dungeon_brick_wall, "pickaxe", 1);
        CommonRegisterHelper.setBlockHarvestLevel(MPBlocks.chondrite_rock, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(MPBlocks.polished_space_decoration, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(MPBlocks.space_mossy_cobblestone, "pickaxe", 0);

        // Set fire burn
        CommonRegisterHelper.setFireBurn(MPBlocks.half_wooden_slab_1, 5, 20);
        CommonRegisterHelper.setFireBurn(MPBlocks.double_wooden_slab_1, 5, 20);

        highlightBlockList.add(MPBlocks.double_stone_slab_1);
        highlightBlockList.add(MPBlocks.double_stone_slab_2);
        highlightBlockList.add(MPBlocks.double_wooden_slab_1);
        highlightBlockList.add(MPBlocks.double_dungeon_brick_slab_1);
        highlightBlockList.add(MPBlocks.double_dungeon_brick_slab_2);
        highlightBlockList.add(DionaBlocks.diona_block);
        highlightBlockList.add(PolongniusBlocks.polongnius_block);
        highlightBlockList.add(PolongniusBlocks.ultra_violet_solar_fake);
        highlightBlockList.add(NibiruBlocks.nibiru_block);
        highlightBlockList.add(NibiruBlocks.nibiru_leaves);
        highlightBlockList.add(NibiruBlocks.infected_farmland);
        highlightBlockList.add(NibiruBlocks.ancient_dark_door_block);
        highlightBlockList.add(NibiruBlocks.orange_door_block);
        highlightBlockList.add(KoentusBlocks.koentus_block);
        highlightBlockList.add(KoentusBlocks.koentus_ice);
        highlightBlockList.add(KoentusBlocks.crystal_farmland);
        highlightBlockList.add(KoentusBlocks.crystal_door_block);
        highlightBlockList.add(FronosBlocks.fronos_block);
        highlightBlockList.add(FronosBlocks.frosted_cake);
        highlightBlockList.add(FronosBlocks.fronos_tall_grass);
        highlightBlockList.add(FronosBlocks.golden_crops);
        highlightBlockList.add(FronosBlocks.fronos_sandstone);
        highlightBlockList.add(FronosBlocks.fronos_farmland);
        highlightBlockList.add(FronosBlocks.coconut_door_block);
        highlightBlockList.add(FronosBlocks.maple_door_block);
        highlightBlockList.add(KapteynBBlocks.kapteyn_b_block);
        highlightBlockList.add(KapteynBBlocks.icy_poison_crystal);
        highlightBlockList.add(KapteynBBlocks.kapteyn_b_ice);
        highlightBlockList.add(KapteynBBlocks.uranium_waste);
        highlightBlockList.add(KapteynBBlocks.fallen_ice_crystal_meteor);
        highlightBlockList.add(SiriusBBlocks.sirius_b_block);
        highlightBlockList.add(MercuryBlocks.mercury_block);
        highlightBlockList.add(VenusBlocks.venus_block);
        highlightBlockList.add(VenusBlocks.venus_redstone_ore_active);
        highlightBlockList.add(PlutoBlocks.pluto_block);
        highlightBlockList.add(EuropaBlocks.europa_sea_lantern);
        highlightBlockList.add(DeimosBlocks.deimos_block);
        highlightBlockList.add(PhobosBlocks.phobos_block);
        highlightBlockList.add(IoBlocks.io_block);
        highlightBlockList.add(DarkAsteroidBlocks.dark_asteroid_rock);
        highlightBlockList.add(KoentusBlocks.crystal_cocoa);
        highlightBlockList.add(DarkAsteroidBlocks.alien_farmland);
        highlightBlockList.add(DionaBlocks.green_redstone_torch_off);
        highlightBlockList.add(PolongniusBlocks.fallen_polongnius_meteor);
        highlightBlockList.add(FronosBlocks.sky_mushroom_block);
        highlightBlockList.add(EuropaBlocks.europa_door_block);
        highlightBlockList.add(FronosBlocks.fronos_block1);
        highlightBlockList.add(FronosBlocks.cake_farmland);

        hideBlockList.add(MPBlocks.dungeon_spawner);
        hideBlockList.add(MPBlocks.double_stone_slab_1);
        hideBlockList.add(MPBlocks.double_stone_slab_2);
        hideBlockList.add(MPBlocks.double_wooden_slab_1);
        hideBlockList.add(MPBlocks.double_dungeon_brick_slab_1);
        hideBlockList.add(MPBlocks.double_dungeon_brick_slab_2);
        hideBlockList.add(MPBlocks.dummy_block);
        hideBlockList.add(KoentusBlocks.crystal_door_block);
        hideBlockList.add(KoentusBlocks.crystal_farmland);
        hideBlockList.add(KoentusBlocks.crystal_cocoa);
        hideBlockList.add(PolongniusBlocks.ultra_violet_solar_fake);
        hideBlockList.add(PolongniusBlocks.cheese_of_milk);
        hideBlockList.add(NibiruBlocks.ancient_dark_door_block);
        hideBlockList.add(NibiruBlocks.orange_door_block);
        hideBlockList.add(NibiruBlocks.infected_farmland);
        hideBlockList.add(FronosBlocks.fronos_farmland);
        hideBlockList.add(FronosBlocks.candy_extractor_active);
        hideBlockList.add(FronosBlocks.strawberry_bush);
        hideBlockList.add(FronosBlocks.golden_crops);
        hideBlockList.add(FronosBlocks.glass_gem_corn);
        hideBlockList.add(FronosBlocks.coconut_door_block);
        hideBlockList.add(FronosBlocks.maple_door_block);
        hideBlockList.add(FronosBlocks.coconut_milk);
        hideBlockList.add(FronosBlocks.mineral_water);
        hideBlockList.add(FronosBlocks.ovaltine);
        hideBlockList.add(FronosBlocks.tea);
        hideBlockList.add(FronosBlocks.caramel);
        hideBlockList.add(FronosBlocks.cup);
        hideBlockList.add(FronosBlocks.mineral_water_cup);
        hideBlockList.add(FronosBlocks.cheese_of_milk_cup);
        hideBlockList.add(FronosBlocks.ovaltine_cup);
        hideBlockList.add(FronosBlocks.coconut_milk_cup);
        hideBlockList.add(FronosBlocks.tea_cup);
        hideBlockList.add(FronosBlocks.caramel_cup);
        hideBlockList.add(FronosBlocks.double_fronos_sandstone_slab);
        hideBlockList.add(FronosBlocks.sky_mushroom_block);
        hideBlockList.add(KapteynBBlocks.frozen_water);
        hideBlockList.add(KapteynBBlocks.kapteyn_b_redstone_ore_active);
        hideBlockList.add(SiriusBBlocks.sirius_lava);
        hideBlockList.add(SiriusBBlocks.sirius_fire);
        hideBlockList.add(SiriusBBlocks.sirius_redstone_lamp_on);
        hideBlockList.add(IoBlocks.io_lava);
        hideBlockList.add(IoBlocks.red_liquid_sulfur);
        hideBlockList.add(IoBlocks.yellow_liquid_sulfur);
        hideBlockList.add(IoBlocks.orange_liquid_sulfur);
        hideBlockList.add(IoBlocks.brown_liquid_sulfur);
        hideBlockList.add(IoBlocks.black_io_lava);
        hideBlockList.add(MercuryBlocks.dirty_water);
        hideBlockList.add(VenusBlocks.venus_redstone_ore_active);
        hideBlockList.add(VenusBlocks.double_venus_sandstone_slab);
        hideBlockList.add(PlutoBlocks.liquid_methane);
        hideBlockList.add(PlutoBlocks.liquid_nitrogen);
        hideBlockList.add(PlutoBlocks.space_potato_block);
        hideBlockList.add(EuropaBlocks.europa_water);
        hideBlockList.add(EuropaBlocks.europa_door_block);
        hideBlockList.add(EuropaBlocks.double_europa_sandstone_slab);
        hideBlockList.add(EuropaBlocks.double_europa_prismarine_slab);
        hideBlockList.add(DarkAsteroidBlocks.dark_air);
        hideBlockList.add(DionaBlocks.green_redstone_torch_off);
        hideBlockList.add(DarkAsteroidBlocks.alien_farmland);
        hideBlockList.add(FronosBlocks.cake_farmland);

        MPLog.debug("Register Blocks");
    }
}