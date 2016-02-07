/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.core.blocks.BlockDoorMP;
import stevekung.mods.moreplanets.core.blocks.BlockDoorMP.DoorType;
import stevekung.mods.moreplanets.core.blocks.BlockFenceGateMP;
import stevekung.mods.moreplanets.core.blocks.BlockStairsMP;
import stevekung.mods.moreplanets.core.blocks.BlockStairsMP.StairsCategory;
import stevekung.mods.moreplanets.core.itemblocks.ItemBlockDirtMP;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockCandyCane.CandyCategory;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockColorizedLeaves.LeafCategory;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockFronosLeaves.FronosLeafCategory;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockFronosLog.LogCategory;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockFronosSandstoneSlab.FronosSlabCategory;
import stevekung.mods.moreplanets.planets.fronos.fluids.BlockFluidCaramel;
import stevekung.mods.moreplanets.planets.fronos.fluids.BlockFluidCoconutMilk;
import stevekung.mods.moreplanets.planets.fronos.fluids.BlockFluidMineralWater;
import stevekung.mods.moreplanets.planets.fronos.fluids.BlockFluidOvantine;
import stevekung.mods.moreplanets.planets.fronos.fluids.BlockFluidTea;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockCandyCane;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockCandyFlower;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockChocolateCreamLayer;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockCream;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockDandelion;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosCloud;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosColorizedLeaves;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosCoral;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosFence;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosFlower;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosLeaves;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosLog;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosSand;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosSandstone;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosSandstoneSlab;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosSapling;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosStone;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosStone1;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosTallGrass;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosWoodenPlanks;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFrostedCake;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockGolemCreamHead;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockJelly;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockLemonCreamLayer;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockOrangeCreamLayer;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockOreFronos;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockPoppy;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockSpaceShell;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockStrawberryCreamLayer;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockTeaCreamLayer;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockVanillaCreamLayer;
import stevekung.mods.stevecore.RegisterHelper;

public class FronosBlocks
{
    public static Block fronos_grass;
    public static Block plains_grass;
    public static Block pink_grass;
    public static Block purple_grass;
    public static Block golden_grass;
    public static Block fronos_dirt;
    public static Block fronos_block;
    public static Block fronos_block_1;
    public static Block mossy_fronos_cobblestone;
    public static Block jelly_ore;
    public static Block ore_block;
    public static Block frosted_cake;
    public static Block jelly_block;
    public static Block cookie_block;
    public static Block ovantine_block;
    public static Block chocolate_block;
    public static Block caramel_block;
    public static Block cloud_block;
    public static Block candy_cane1;
    public static Block candy_cane2;
    public static Block cream_block;
    public static Block vanilla_cream_layer;
    public static Block chocolate_cream_layer;
    public static Block strawberry_cream_layer;
    public static Block orange_cream_layer;
    public static Block tea_cream_layer;
    public static Block lemon_cream_layer;
    public static Block fronos_sand;
    public static Block cheese_glass;
    public static Block cheese_glass_pane;
    public static Block fronos_log;
    public static Block fronos_wooden_planks;
    public static Block fronos_colorized_leaves;
    public static Block fronos_leaves;
    public static Block fronos_cobblestone_stairs;
    public static Block fronos_stone_brick_stairs;
    public static Block cracked_fronos_stone_brick_stairs;
    public static Block fronos_dungeon_brick_stairs;
    public static Block coconut_wood_stairs;
    public static Block maple_wood_stairs;
    public static Block fronos_fence;
    public static Block coconut_fence_gate;
    public static Block maple_fence_gate;
    public static Block fronos_treasure_chest;
    public static Block fronos_ancient_chest;
    public static Block candy_extractor_idle;
    public static Block mineral_water_generator;
    public static Block candy_extractor_active;
    public static Block fronos_farmland;
    public static Block strawberry_crops;
    public static Block golden_crops;
    public static Block coconut;
    public static Block cream_golem_head;
    public static Block cake_bread;
    public static Block white_cake_bread;
    public static Block chocolate_cake_bread;
    public static Block pink_cake;
    public static Block white_cake;
    public static Block chocolate_cake;
    public static Block space_shell;
    public static Block space_oyster_open;
    public static Block cavern_oyster_open;
    public static Block space_oyster_close;
    public static Block cavern_oyster_close;
    public static Block jelly_slime_egg;
    public static BlockSapling fronos_sapling;
    public static Block fronos_tall_grass;
    public static Block fronos_flower;
    public static Block dandelion;
    public static Block poppy;
    public static Block candy_flower;
    public static Block coral;
    public static Block cheese_web;
    public static Block glass_gem_corn1;
    public static Block glass_gem_corn2;
    public static Block glass_gem_corn3;
    public static Block maple_ivy;
    public static Block pink_candy_torch;
    public static Block orange_candy_torch;
    public static Block green_candy_torch;
    public static Block yellow_candy_torch;
    public static Block light_blue_candy_torch;
    public static Block blue_candy_torch;
    public static Block red_candy_torch;
    public static Block purple_candy_torch;
    public static Block cup;
    public static Block mineral_water_cup;
    public static Block ovantine_cup;
    public static Block coconut_milk_cup;
    public static Block cheese_of_milk_cup;
    public static Block tea_cup;
    public static Block caramel_cup;
    public static Block coconut_door;
    public static Block maple_door;
    public static Block coconut_milk;
    public static Block mineral_water;
    public static Block ovantine;
    public static Block tea;
    public static Block caramel;
    public static Block fronos_sandstone;
    public static Block half_fronos_sandstone_slab;
    public static Block double_fronos_sandstone_slab;
    public static Block fronos_sandstone_stairs;
    public static Block white_sandstone_stairs;
    public static Block cheese_sandstone_stairs;
    public static Block huge_sky_mushroom;
    public static Block cake_farmland;

    // Fluids
    public static Fluid coconut_milk_fluid;
    public static Fluid mineral_water_fluid;
    public static Fluid ovantine_fluid;
    public static Fluid tea_fluid;
    public static Fluid caramel_fluid;

    public static void init()
    {
        FronosBlocks.initBlocks();
        FronosBlocks.setHarvestLevels();
        FronosBlocks.registerBlocks();
        FronosBlocks.setFireBurn();
    }

    private static void initBlocks()
    {
        FronosBlocks.fronos_grass = new BlockFronosGrass("fronos_grass");
        FronosBlocks.plains_grass = new BlockPlainsGrass("plains_grass");
        FronosBlocks.pink_grass = new BlockPinkGrass("pink_grass");
        FronosBlocks.purple_grass = new BlockPurpleGrass("purple_grass");
        FronosBlocks.golden_grass = new BlockGoldenGrass("golden_grass");
        FronosBlocks.fronos_dirt = new BlockFronosDirt("fronos_dirt");
        FronosBlocks.fronos_block = new BlockFronosStone("fronos_block");
        FronosBlocks.fronos_block_1 = new BlockFronosStone1("fronos_block1");
        FronosBlocks.mossy_fronos_cobblestone = new BlockMossyFronosCobblestone("mossy_fronos_cobblestone");
        FronosBlocks.jelly_ore = new BlockJellyOre("fronos_ore");
        FronosBlocks.ore_block = new BlockOreFronos("fronos_ore_block");
        FronosBlocks.frosted_cake = new BlockFrostedCake("frosted_cake_block");
        FronosBlocks.jelly_block = new BlockJelly("jelly_block");
        FronosBlocks.cookie_block = new BlockCookie("cookie_block");
        FronosBlocks.ovantine_block = new BlockOvantine("ovantine_block");
        FronosBlocks.chocolate_block = new BlockChocolate("chocolate_block");
        FronosBlocks.caramel_block = new BlockCaramel("caramel_block");
        FronosBlocks.cloud_block = new BlockFronosCloud("fronos_cloud");
        FronosBlocks.candy_cane1 = new BlockCandyCane("candy_cane1", CandyCategory.CAT1);
        FronosBlocks.candy_cane2 = new BlockCandyCane("candy_cane2", CandyCategory.CAT2);
        FronosBlocks.cream_block = new BlockCream("cream_block");
        FronosBlocks.vanilla_cream_layer = new BlockVanillaCreamLayer("vanilla_cream_layer");
        FronosBlocks.chocolate_cream_layer = new BlockChocolateCreamLayer("chocolate_cream_layer");
        FronosBlocks.strawberry_cream_layer = new BlockStrawberryCreamLayer("strawberry_cream_layer");
        FronosBlocks.orange_cream_layer = new BlockOrangeCreamLayer("orange_cream_layer");
        FronosBlocks.tea_cream_layer = new BlockTeaCreamLayer("tea_cream_layer");
        FronosBlocks.lemon_cream_layer = new BlockLemonCreamLayer("lemon_cream_layer");
        FronosBlocks.fronos_sand = new BlockFronosSand("fronos_sand");
        FronosBlocks.cheese_glass = new BlockCheeseGlass("cheese_glass");
        FronosBlocks.cheese_glass_pane = new BlockCheeseGlassPane("cheese_glass_pane");
        FronosBlocks.fronos_log = new BlockFronosLog("fronos_log", LogCategory.CAT1);
        FronosBlocks.fronos_wooden_planks = new BlockFronosWoodenPlanks("fronos_wooden_planks");
        FronosBlocks.fronos_colorized_leaves = new BlockColorizedLeaves("fronos_leaves", LeafCategory.CAT1);
        FronosBlocks.fronos_leaves = new BlockFronosLeaves("fronos_leaves2", FronosLeafCategory.CAT1);
        FronosBlocks.fronos_cobblestone_stairs = new BlockStairsMP("fronos_cobblestone_stairs", 1.75F, StairsCategory.FRONOS_COBBLESTONE, Blocks.stone);
        FronosBlocks.fronos_stone_brick_stairs = new BlockStairsMP("fronos_stone_brick_stairs", 2.25F, StairsCategory.FRONOS_STONE_BRICK, Blocks.stone);
        FronosBlocks.cracked_fronos_stone_brick_stairs = new BlockStairsMP("fronos_cracked_stone_brick_stairs", 2.25F, StairsCategory.FRONOS_CRACK_BRICK, Blocks.stone);
        FronosBlocks.fronos_dungeon_brick_stairs = new BlockStairsMP("fronos_dungeon_brick_stairs", 4.0F, StairsCategory.FRONOS_BRICK, Blocks.stone);
        FronosBlocks.coconut_wood_stairs = new BlockStairsMP("coconut_wood_stairs", 2.0F, StairsCategory.COCONUT_WOOD, Blocks.log);
        FronosBlocks.maple_wood_stairs = new BlockStairsMP("red_maple_wood_stairs", 2.0F, StairsCategory.RED_MAPLE_WOOD, Blocks.log);
        FronosBlocks.fronos_fence = new BlockFronosFence("fronos_fence");
        FronosBlocks.coconut_fence_gate = new BlockFenceGateMP("coconut_fence_gate", "fronos:coconut_wood_planks");
        FronosBlocks.maple_fence_gate = new BlockFenceGateMP("red_maple_fence_gate", "fronos:maple_wood_planks");
        FronosBlocks.fronos_treasure_chest = new BlockT7FronosTreasureChest("fronos_treasure_chest");
        FronosBlocks.fronos_ancient_chest = new BlockFronosAncientChest("fronos_ancient_chest");
        FronosBlocks.candy_extractor_idle = new BlockCandyExtractor("candy_extractor_idle", false);
        FronosBlocks.mineral_water_generator = new BlockMineralWaterGenerator("mineral_water_generator");
        FronosBlocks.candy_extractor_active = new BlockCandyExtractor("candy_extractor_active", true);
        FronosBlocks.fronos_farmland = new BlockFronosFarmland("fronos_farmland");
        FronosBlocks.strawberry_crops = new BlockStrawberryCrops("strawberry_crops");
        FronosBlocks.golden_crops = new BlockGoldenCrops("golden_wheat");
        FronosBlocks.coconut = new BlockCoconut("coconut_block");
        FronosBlocks.cream_golem_head = new BlockGolemCreamHead("cream_head");
        FronosBlocks.cake_bread = new BlockCakeBread("cake_bread");
        FronosBlocks.white_cake_bread = new BlockWhiteCakeBread("white_cake_bread");
        FronosBlocks.chocolate_cake_bread = new BlockChocolateCakeBread("chocolate_cake_bread");
        FronosBlocks.pink_cake = new BlockPinkCake("pink_cake");
        FronosBlocks.white_cake = new BlockWhiteCake("white_cake");
        FronosBlocks.chocolate_cake = new BlockChocolateCake("chocolate_cake");
        FronosBlocks.space_shell = new BlockSpaceShell("space_shell");
        FronosBlocks.space_oyster_open = new BlockSpaceOysterOpen("space_oyster_open");
        FronosBlocks.cavern_oyster_open = new BlockCavernOysterOpen("cavern_oyster_open");
        FronosBlocks.space_oyster_close = new BlockSpaceOysterClose("space_oyster_close");
        FronosBlocks.cavern_oyster_close = new BlockCavernOysterClose("cavern_oyster_close");
        FronosBlocks.jelly_slime_egg = new BlockJellySlimeEgg("jelly_slime_egg");
        FronosBlocks.fronos_sapling = new BlockFronosSapling("fronos_sapling");
        FronosBlocks.fronos_tall_grass = new BlockFronosTallGrass("fronos_tallgrass");
        FronosBlocks.fronos_flower = new BlockFronosFlower("fronos_flower");
        FronosBlocks.dandelion = new BlockDandelion("fronos_dandelion");
        FronosBlocks.poppy = new BlockPoppy("fronos_poppy");
        FronosBlocks.candy_flower = new BlockCandyFlower("candy_flower");
        FronosBlocks.coral = new BlockFronosCoral("fronos_coral");
        FronosBlocks.cheese_web = new BlockCheeseWeb("cheese_web");
        FronosBlocks.glass_gem_corn1 = new BlockGlassGemCorn1("glass_gem_corn1");
        FronosBlocks.glass_gem_corn2 = new BlockGlassGemCorn2("glass_gem_corn2");
        FronosBlocks.glass_gem_corn3 = new BlockGlassGemCorn3("glass_gem_corn3");
        FronosBlocks.maple_ivy = new BlockMapleIvy("maple_ivy");
        FronosBlocks.pink_candy_torch = new BlockCandyTorch("pink_candy_torch", "fronos:pink_candy_torch");
        FronosBlocks.orange_candy_torch = new BlockCandyTorch("orange_candy_torch", "fronos:orange_candy_torch");
        FronosBlocks.green_candy_torch = new BlockCandyTorch("green_candy_torch", "fronos:green_candy_torch");
        FronosBlocks.yellow_candy_torch = new BlockCandyTorch("yellow_candy_torch", "fronos:yellow_candy_torch");
        FronosBlocks.light_blue_candy_torch = new BlockCandyTorch("light_blue_candy_torch", "fronos:light_blue_candy_torch");
        FronosBlocks.blue_candy_torch = new BlockCandyTorch("blue_candy_torch", "fronos:blue_candy_torch");
        FronosBlocks.red_candy_torch = new BlockCandyTorch("red_candy_torch", "fronos:red_candy_torch");
        FronosBlocks.purple_candy_torch = new BlockCandyTorch("purple_candy_torch", "fronos:purple_candy_torch");
        FronosBlocks.cup = new BlockCup("cup_block");
        FronosBlocks.mineral_water_cup = new BlockMineralWaterCup("mineral_water_cup");
        FronosBlocks.ovantine_cup = new BlockOvantineCup("ovantine_cup");
        FronosBlocks.coconut_milk_cup = new BlockCoconutMilkCup("coconut_milk_cup");
        FronosBlocks.cheese_of_milk_cup = new BlockCheeseOfMilkCup("cheese_of_milk_cup");
        FronosBlocks.tea_cup = new BlockTeaCup("tea_cup");
        FronosBlocks.caramel_cup = new BlockCaramelCup("caramel_cup");
        FronosBlocks.coconut_door = new BlockDoorMP("coconut_door_block", "fronos:coconut", DoorType.COCONUT);
        FronosBlocks.maple_door = new BlockDoorMP("red_maple_door_block", "fronos:maple", DoorType.MAPLE);
        FronosBlocks.fronos_sandstone = new BlockFronosSandstone("fronos_sandstone");
        FronosBlocks.half_fronos_sandstone_slab = new BlockFronosSandstoneSlab("half_fronos_sandstone_slab", false, Material.rock, FronosSlabCategory.WOOD1);
        FronosBlocks.double_fronos_sandstone_slab = new BlockFronosSandstoneSlab("double_fronos_sandstone_slab", true, Material.rock, FronosSlabCategory.WOOD1);
        FronosBlocks.fronos_sandstone_stairs = new BlockStairsMP("fronos_sandstone_stairs", 0.8F, StairsCategory.fronos_sandstone, Blocks.stone);
        FronosBlocks.white_sandstone_stairs = new BlockStairsMP("white_sandstone_stairs", 0.8F, StairsCategory.white_sandstone, Blocks.stone);
        FronosBlocks.cheese_sandstone_stairs = new BlockStairsMP("cheese_sandstone_stairs", 0.8F, StairsCategory.cheese_sandstone, Blocks.stone);
        FronosBlocks.huge_sky_mushroom = new BlockHugeSkyMushroom("huge_sky_mushroom");
        FronosBlocks.cake_farmland = new BlockCakeFarmland("cake_farmland");

        FronosBlocks.coconut_milk_fluid = new Fluid("coconut_milk_fluid").setBlock(FronosBlocks.coconut_milk).setViscosity(2000);
        FronosBlocks.mineral_water_fluid = new Fluid("mineral_water_fluid").setBlock(FronosBlocks.mineral_water);
        FronosBlocks.ovantine_fluid = new Fluid("ovantine_fluid").setBlock(FronosBlocks.ovantine).setViscosity(2000);
        FronosBlocks.tea_fluid = new Fluid("tea_fluid").setBlock(FronosBlocks.tea).setViscosity(2000);
        FronosBlocks.caramel_fluid = new Fluid("caramel_fluid").setBlock(FronosBlocks.caramel).setViscosity(3000);
        RegisterHelper.registerFluid(FronosBlocks.coconut_milk_fluid);
        RegisterHelper.registerFluid(FronosBlocks.mineral_water_fluid);
        RegisterHelper.registerFluid(FronosBlocks.ovantine_fluid);
        RegisterHelper.registerFluid(FronosBlocks.tea_fluid);
        RegisterHelper.registerFluid(FronosBlocks.caramel_fluid);
        FronosBlocks.coconut_milk = new BlockFluidCoconutMilk("coconut_milk_fluid");
        FronosBlocks.mineral_water = new BlockFluidMineralWater("mineral_water_fluid");
        FronosBlocks.ovantine = new BlockFluidOvantine("ovantine_fluid");
        FronosBlocks.tea = new BlockFluidTea("tea_fluid");
        FronosBlocks.caramel = new BlockFluidCaramel("caramel_fluid");
    }

    private static void setHarvestLevels()
    {
        FronosBlocks.fronos_grass.setHarvestLevel("shovel", 0);
        FronosBlocks.fronos_dirt.setHarvestLevel("shovel", 0);
        FronosBlocks.fronos_farmland.setHarvestLevel("shovel", 0);
        FronosBlocks.pink_grass.setHarvestLevel("shovel", 0);
        FronosBlocks.purple_grass.setHarvestLevel("shovel", 0);
        FronosBlocks.plains_grass.setHarvestLevel("shovel", 0);
        FronosBlocks.golden_grass.setHarvestLevel("shovel", 0);
        FronosBlocks.fronos_sand.setHarvestLevel("shovel", 0);
        FronosBlocks.cream_block.setHarvestLevel("shovel", 0);
        FronosBlocks.vanilla_cream_layer.setHarvestLevel("shovel", 0);
        FronosBlocks.chocolate_cream_layer.setHarvestLevel("shovel", 0);
        FronosBlocks.strawberry_cream_layer.setHarvestLevel("shovel", 0);
        FronosBlocks.orange_cream_layer.setHarvestLevel("shovel", 0);
        FronosBlocks.tea_cream_layer.setHarvestLevel("shovel", 0);
        FronosBlocks.lemon_cream_layer.setHarvestLevel("shovel", 0);
        FronosBlocks.ovantine_block.setHarvestLevel("shovel", 0);
        FronosBlocks.chocolate_block.setHarvestLevel("shovel", 0);
        FronosBlocks.cookie_block.setHarvestLevel("shovel", 0);
        FronosBlocks.frosted_cake.setHarvestLevel("shovel", 0);
        FronosBlocks.cream_golem_head.setHarvestLevel("shovel", 0);
        FronosBlocks.cake_farmland.setHarvestLevel("shovel", 0);
        FronosBlocks.fronos_block.setHarvestLevel("pickaxe", 0);
        FronosBlocks.fronos_block_1.setHarvestLevel("pickaxe", 0);
        FronosBlocks.jelly_ore.setHarvestLevel("pickaxe", 0);
        FronosBlocks.fronos_cobblestone_stairs.setHarvestLevel("pickaxe", 0);
        FronosBlocks.fronos_stone_brick_stairs.setHarvestLevel("pickaxe", 0);
        FronosBlocks.cracked_fronos_stone_brick_stairs.setHarvestLevel("pickaxe", 0);
        FronosBlocks.fronos_dungeon_brick_stairs.setHarvestLevel("pickaxe", 0);
        FronosBlocks.candy_extractor_idle.setHarvestLevel("pickaxe", 0);
        FronosBlocks.candy_extractor_active.setHarvestLevel("pickaxe", 0);
        FronosBlocks.mineral_water_generator.setHarvestLevel("pickaxe", 0);
        FronosBlocks.ore_block.setHarvestLevel("pickaxe", 0);
        FronosBlocks.mossy_fronos_cobblestone.setHarvestLevel("pickaxe", 0);
        FronosBlocks.space_oyster_open.setHarvestLevel("pickaxe", 0);
        FronosBlocks.space_oyster_close.setHarvestLevel("pickaxe", 0);
        FronosBlocks.cavern_oyster_open.setHarvestLevel("pickaxe", 0);
        FronosBlocks.cavern_oyster_close.setHarvestLevel("pickaxe", 0);
        FronosBlocks.fronos_sandstone.setHarvestLevel("pickaxe", 0);
        FronosBlocks.half_fronos_sandstone_slab.setHarvestLevel("pickaxe", 0);
        FronosBlocks.double_fronos_sandstone_slab.setHarvestLevel("pickaxe", 0);
        FronosBlocks.fronos_sandstone_stairs.setHarvestLevel("pickaxe", 0);
        FronosBlocks.white_sandstone_stairs.setHarvestLevel("pickaxe", 0);
        FronosBlocks.cheese_sandstone_stairs.setHarvestLevel("pickaxe", 0);
        FronosBlocks.fronos_log.setHarvestLevel("axe", 0);
        FronosBlocks.coconut.setHarvestLevel("axe", 0);
        FronosBlocks.fronos_wooden_planks.setHarvestLevel("axe", 0);
        FronosBlocks.coconut_wood_stairs.setHarvestLevel("axe", 0);
        FronosBlocks.maple_wood_stairs.setHarvestLevel("axe", 0);
        FronosBlocks.fronos_fence.setHarvestLevel("axe", 0);
        FronosBlocks.coconut_fence_gate.setHarvestLevel("axe", 0);
        FronosBlocks.maple_fence_gate.setHarvestLevel("axe", 0);
        FronosBlocks.fronos_ancient_chest.setHarvestLevel("axe", 0);
        FronosBlocks.huge_sky_mushroom.setHarvestLevel("axe", 0);
    }

    private static void setFireBurn()
    {
        RegisterHelper.setFireBurn(FronosBlocks.fronos_wooden_planks, 5, 20);
        RegisterHelper.setFireBurn(FronosBlocks.fronos_leaves, 30, 60);
        RegisterHelper.setFireBurn(FronosBlocks.fronos_colorized_leaves, 30, 60);
        RegisterHelper.setFireBurn(FronosBlocks.candy_cane1, 5, 20);
        RegisterHelper.setFireBurn(FronosBlocks.candy_cane2, 5, 20);
        RegisterHelper.setFireBurn(FronosBlocks.coconut_wood_stairs, 5, 20);
        RegisterHelper.setFireBurn(FronosBlocks.fronos_fence, 5, 20);
        RegisterHelper.setFireBurn(FronosBlocks.coconut_fence_gate, 5, 20);
        RegisterHelper.setFireBurn(FronosBlocks.maple_wood_stairs, 5, 20);
        RegisterHelper.setFireBurn(FronosBlocks.maple_fence_gate, 5, 20);
        RegisterHelper.setFireBurn(FronosBlocks.coconut, 5, 20);
        RegisterHelper.setFireBurn(FronosBlocks.fronos_tall_grass, 60, 100);
        RegisterHelper.setFireBurn(FronosBlocks.fronos_sapling, 60, 100);
        RegisterHelper.setFireBurn(FronosBlocks.fronos_flower, 60, 100);
        RegisterHelper.setFireBurn(FronosBlocks.dandelion, 60, 100);
        RegisterHelper.setFireBurn(FronosBlocks.candy_flower, 60, 100);
        RegisterHelper.setFireBurn(FronosBlocks.poppy, 60, 100);
        RegisterHelper.setFireBurn(FronosBlocks.maple_ivy, 15, 100);
        RegisterHelper.setFireBurn(FronosBlocks.fronos_log, 5, 5);
    }

    private static void registerBlocks()
    {
        RegisterHelper.registerBlock(FronosBlocks.fronos_grass);
        RegisterHelper.registerBlock(FronosBlocks.plains_grass);
        RegisterHelper.registerBlock(FronosBlocks.pink_grass);
        RegisterHelper.registerBlock(FronosBlocks.purple_grass);
        RegisterHelper.registerBlock(FronosBlocks.golden_grass);
        RegisterHelper.registerBlock(FronosBlocks.fronos_dirt, ItemBlockDirtMP.class);
        RegisterHelper.registerBlock(FronosBlocks.fronos_block, ItemBlockFronosStone.class);
        RegisterHelper.registerBlock(FronosBlocks.fronos_block_1, ItemBlockFronosStone1.class);
        RegisterHelper.registerBlock(FronosBlocks.mossy_fronos_cobblestone);
        RegisterHelper.registerBlock(FronosBlocks.jelly_ore, ItemBlockJelly.class);
        RegisterHelper.registerBlock(FronosBlocks.ore_block, ItemBlockOreFronos.class);
        RegisterHelper.registerBlock(FronosBlocks.frosted_cake, ItemBlockFrostedCake.class);
        RegisterHelper.registerBlock(FronosBlocks.jelly_block, ItemBlockJelly.class);
        RegisterHelper.registerBlock(FronosBlocks.cookie_block);
        RegisterHelper.registerBlock(FronosBlocks.ovantine_block);
        RegisterHelper.registerBlock(FronosBlocks.chocolate_block);
        RegisterHelper.registerBlock(FronosBlocks.caramel_block);
        RegisterHelper.registerBlock(FronosBlocks.cloud_block, ItemBlockFronosCloud.class);
        RegisterHelper.registerBlock(FronosBlocks.candy_cane1, ItemBlockCandyCane.class);
        RegisterHelper.registerBlock(FronosBlocks.candy_cane2, ItemBlockCandyCane.class);
        RegisterHelper.registerBlock(FronosBlocks.cream_block, ItemBlockCream.class);
        RegisterHelper.registerBlock(FronosBlocks.vanilla_cream_layer, ItemBlockVanillaCreamLayer.class);
        RegisterHelper.registerBlock(FronosBlocks.chocolate_cream_layer, ItemBlockChocolateCreamLayer.class);
        RegisterHelper.registerBlock(FronosBlocks.strawberry_cream_layer, ItemBlockStrawberryCreamLayer.class);
        RegisterHelper.registerBlock(FronosBlocks.orange_cream_layer, ItemBlockOrangeCreamLayer.class);
        RegisterHelper.registerBlock(FronosBlocks.tea_cream_layer, ItemBlockTeaCreamLayer.class);
        RegisterHelper.registerBlock(FronosBlocks.lemon_cream_layer, ItemBlockLemonCreamLayer.class);
        RegisterHelper.registerBlock(FronosBlocks.fronos_sand, ItemBlockFronosSand.class);
        RegisterHelper.registerBlock(FronosBlocks.fronos_sandstone, ItemBlockFronosSandstone.class);
        RegisterHelper.registerBlock(FronosBlocks.half_fronos_sandstone_slab, ItemBlockFronosSandstoneSlab.class, FronosBlocks.half_fronos_sandstone_slab, FronosBlocks.double_fronos_sandstone_slab);
        RegisterHelper.registerBlock(FronosBlocks.double_fronos_sandstone_slab, ItemBlockFronosSandstoneSlab.class, FronosBlocks.half_fronos_sandstone_slab, FronosBlocks.double_fronos_sandstone_slab);
        RegisterHelper.registerBlock(FronosBlocks.cheese_glass);
        RegisterHelper.registerBlock(FronosBlocks.cheese_glass_pane);
        RegisterHelper.registerBlock(FronosBlocks.fronos_log, ItemBlockFronosLog.class);
        RegisterHelper.registerBlock(FronosBlocks.fronos_wooden_planks, ItemBlockFronosWoodenPlanks.class);
        RegisterHelper.registerBlock(FronosBlocks.fronos_colorized_leaves, ItemBlockFronosColorizedLeaves.class);
        RegisterHelper.registerBlock(FronosBlocks.fronos_leaves, ItemBlockFronosLeaves.class);
        RegisterHelper.registerBlock(FronosBlocks.fronos_cobblestone_stairs);
        RegisterHelper.registerBlock(FronosBlocks.fronos_stone_brick_stairs);
        RegisterHelper.registerBlock(FronosBlocks.cracked_fronos_stone_brick_stairs);
        RegisterHelper.registerBlock(FronosBlocks.fronos_dungeon_brick_stairs);
        RegisterHelper.registerBlock(FronosBlocks.fronos_sandstone_stairs);
        RegisterHelper.registerBlock(FronosBlocks.white_sandstone_stairs);
        RegisterHelper.registerBlock(FronosBlocks.cheese_sandstone_stairs);
        RegisterHelper.registerBlock(FronosBlocks.coconut_wood_stairs);
        RegisterHelper.registerBlock(FronosBlocks.maple_wood_stairs);
        RegisterHelper.registerBlock(FronosBlocks.fronos_fence, ItemBlockFronosFence.class);
        RegisterHelper.registerBlock(FronosBlocks.coconut_fence_gate);
        RegisterHelper.registerBlock(FronosBlocks.maple_fence_gate);
        RegisterHelper.registerBlock(FronosBlocks.fronos_treasure_chest);
        RegisterHelper.registerBlock(FronosBlocks.fronos_ancient_chest);
        RegisterHelper.registerBlock(FronosBlocks.candy_extractor_idle);
        RegisterHelper.registerBlock(FronosBlocks.mineral_water_generator);
        RegisterHelper.registerBlock(FronosBlocks.candy_extractor_active);
        RegisterHelper.registerBlock(FronosBlocks.fronos_farmland);
        RegisterHelper.registerBlock(FronosBlocks.strawberry_crops);
        RegisterHelper.registerBlock(FronosBlocks.golden_crops);
        RegisterHelper.registerBlock(FronosBlocks.coconut);
        RegisterHelper.registerBlock(FronosBlocks.cream_golem_head, ItemBlockGolemCreamHead.class);
        RegisterHelper.registerBlock(FronosBlocks.cake_bread);
        RegisterHelper.registerBlock(FronosBlocks.white_cake_bread);
        RegisterHelper.registerBlock(FronosBlocks.chocolate_cake_bread);
        RegisterHelper.registerBlock(FronosBlocks.pink_cake);
        RegisterHelper.registerBlock(FronosBlocks.white_cake);
        RegisterHelper.registerBlock(FronosBlocks.chocolate_cake);
        RegisterHelper.registerBlock(FronosBlocks.space_shell, ItemBlockSpaceShell.class);
        RegisterHelper.registerBlock(FronosBlocks.space_oyster_open);
        RegisterHelper.registerBlock(FronosBlocks.cavern_oyster_open);
        RegisterHelper.registerBlock(FronosBlocks.space_oyster_close);
        RegisterHelper.registerBlock(FronosBlocks.cavern_oyster_close);
        RegisterHelper.registerBlock(FronosBlocks.jelly_slime_egg, ItemBlockJelly.class);
        RegisterHelper.registerBlock(FronosBlocks.fronos_sapling, ItemBlockFronosSapling.class);
        RegisterHelper.registerBlock(FronosBlocks.fronos_tall_grass, ItemBlockFronosTallGrass.class);
        RegisterHelper.registerBlock(FronosBlocks.fronos_flower, ItemBlockFronosFlower.class);
        RegisterHelper.registerBlock(FronosBlocks.dandelion, ItemBlockDandelion.class);
        RegisterHelper.registerBlock(FronosBlocks.poppy, ItemBlockPoppy.class);
        RegisterHelper.registerBlock(FronosBlocks.candy_flower, ItemBlockCandyFlower.class);
        RegisterHelper.registerBlock(FronosBlocks.coral, ItemBlockFronosCoral.class);
        RegisterHelper.registerBlock(FronosBlocks.cheese_web);
        RegisterHelper.registerBlock(FronosBlocks.glass_gem_corn1);
        RegisterHelper.registerBlock(FronosBlocks.glass_gem_corn2);
        RegisterHelper.registerBlock(FronosBlocks.glass_gem_corn3);
        RegisterHelper.registerBlock(FronosBlocks.maple_ivy);
        RegisterHelper.registerBlock(FronosBlocks.pink_candy_torch);
        RegisterHelper.registerBlock(FronosBlocks.orange_candy_torch);
        RegisterHelper.registerBlock(FronosBlocks.green_candy_torch);
        RegisterHelper.registerBlock(FronosBlocks.yellow_candy_torch);
        RegisterHelper.registerBlock(FronosBlocks.light_blue_candy_torch);
        RegisterHelper.registerBlock(FronosBlocks.blue_candy_torch);
        RegisterHelper.registerBlock(FronosBlocks.red_candy_torch);
        RegisterHelper.registerBlock(FronosBlocks.purple_candy_torch);
        RegisterHelper.registerBlock(FronosBlocks.cup);
        RegisterHelper.registerBlock(FronosBlocks.mineral_water_cup);
        RegisterHelper.registerBlock(FronosBlocks.ovantine_cup);
        RegisterHelper.registerBlock(FronosBlocks.coconut_milk_cup);
        RegisterHelper.registerBlock(FronosBlocks.cheese_of_milk_cup);
        RegisterHelper.registerBlock(FronosBlocks.tea_cup);
        RegisterHelper.registerBlock(FronosBlocks.caramel_cup);
        RegisterHelper.registerBlock(FronosBlocks.coconut_door);
        RegisterHelper.registerBlock(FronosBlocks.maple_door);
        RegisterHelper.registerBlock(FronosBlocks.coconut_milk);
        RegisterHelper.registerBlock(FronosBlocks.mineral_water);
        RegisterHelper.registerBlock(FronosBlocks.ovantine);
        RegisterHelper.registerBlock(FronosBlocks.tea);
        RegisterHelper.registerBlock(FronosBlocks.caramel);
        RegisterHelper.registerBlock(FronosBlocks.huge_sky_mushroom);
        RegisterHelper.registerBlock(FronosBlocks.cake_farmland);

        OreDictionary.registerOre("oreIron", new ItemStack(FronosBlocks.fronos_block, 1, 2));
        OreDictionary.registerOre("oreCoal", new ItemStack(FronosBlocks.fronos_block, 1, 3));
        OreDictionary.registerOre("oreAluminum", new ItemStack(FronosBlocks.fronos_block, 1, 4));
        OreDictionary.registerOre("oreAluminium", new ItemStack(FronosBlocks.fronos_block, 1, 4));
        OreDictionary.registerOre("oreTin", new ItemStack(FronosBlocks.fronos_block, 1, 5));
        OreDictionary.registerOre("oreCopper", new ItemStack(FronosBlocks.fronos_block, 1, 6));
        OreDictionary.registerOre("oreLapis", new ItemStack(FronosBlocks.fronos_block, 1, 7));
        OreDictionary.registerOre("oreMineral", new ItemStack(FronosBlocks.fronos_block, 1, 8));
        OreDictionary.registerOre("oreBlackDiamond", new ItemStack(FronosBlocks.fronos_block, 1, 9));
        OreDictionary.registerOre("oreIridium", new ItemStack(FronosBlocks.fronos_block, 1, 10));
        OreDictionary.registerOre("oreGold", new ItemStack(FronosBlocks.fronos_block_1, 1, 0));
        OreDictionary.registerOre("oreDiamond", new ItemStack(FronosBlocks.fronos_block_1, 1, 1));
        OreDictionary.registerOre("oreEmerald", new ItemStack(FronosBlocks.fronos_block_1, 1, 2));
        OreDictionary.registerOre("oreSilicon", new ItemStack(FronosBlocks.fronos_block_1, 1, 3));
        OreDictionary.registerOre("oreJelly", FronosBlocks.jelly_ore);
        OreDictionary.registerOre("cobblestone", new ItemStack(FronosBlocks.fronos_block, 1, 1));
        OreDictionary.registerOre("blockIridium", new ItemStack(FronosBlocks.ore_block, 1, 0));
        OreDictionary.registerOre("blockBlackDiamond", new ItemStack(FronosBlocks.ore_block, 1, 1));
    }
}