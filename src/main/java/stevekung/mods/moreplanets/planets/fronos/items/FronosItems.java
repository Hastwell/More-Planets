/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.blocks.BlockDoorMP.DoorType;
import stevekung.mods.moreplanets.common.items.ItemBucketMP;
import stevekung.mods.moreplanets.common.items.ItemDoorMP;
import stevekung.mods.moreplanets.common.items.ItemMorePlanets;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class FronosItems
{
	public static Item fronos_food;
	public static Item strawberry_seed;
	public static Item bearry_egg;
	public static Item cream_ball;
	public static Item pearl;
	public static Item fronos_dungeon_key;
	public static Item candy_cane;
	public static Item coconut_milk_bucket;
	public static Item mineral_water_bucket;
	public static Item ovaltine_bucket;
	public static Item tea_bucket;
	public static Item caramel_bucket;
	public static Item jelly;
	public static Item candy_food;
	public static Item fronos_fruits;
	public static Item candy_bow;
	public static Item poison_arrow;
	public static Item golden_seeds;
	public static Item glass_gem_corn;
	public static Item cup;
	public static Item cream_golem;
	public static Item fronos_item;
	public static Item tier_7_rocket;
	public static Item coconut_door;
	public static Item maple_door;
	public static Item tier_7_rocket_schematic;
	public static Item fruits_juice;
	public static Item tier_8_rocket_module;

	public static void init()
	{
		// Init
		FronosItems.fronos_food = new ItemFronosFood("fronos_food");
		FronosItems.strawberry_seed = new ItemStrawberrySeed("strawberry_seed");
		FronosItems.bearry_egg = new ItemBearryEgg("bearry_egg");
		FronosItems.cream_ball = new ItemCreamBall("cream_ball");
		FronosItems.pearl = new ItemPearl("pearl");
		FronosItems.fronos_dungeon_key = new ItemFronosDungeonKey("fronos_dungeon_key");
		FronosItems.candy_cane = new ItemCandyCane("candy_cane");
		FronosItems.coconut_milk_bucket = new ItemBucketMP("coconut_milk_bucket", FronosBlocks.coconut_milk, null);
		FronosItems.mineral_water_bucket = new ItemBucketMP("mineral_water_bucket", FronosBlocks.mineral_water, null);
		FronosItems.ovaltine_bucket = new ItemBucketMP("ovaltine_bucket", FronosBlocks.ovaltine, null);
		FronosItems.tea_bucket = new ItemBucketMP("tea_bucket", FronosBlocks.tea, null);
		FronosItems.caramel_bucket = new ItemBucketMP("caramel_bucket", FronosBlocks.caramel, null);
		FronosItems.jelly = new ItemJelly("jelly");
		FronosItems.candy_food = new ItemCandyFood("candy_food");
		FronosItems.fronos_fruits = new ItemFruits("fronos_fruits");
		FronosItems.candy_bow = new ItemCandyBow("candy_bow");
		FronosItems.poison_arrow = new ItemMorePlanets("poison_arrow");
		FronosItems.golden_seeds = new ItemGoldenSeeds("golden_seeds");
		FronosItems.glass_gem_corn = new ItemGlassGemCorn("glass_gem_corn_item");
		FronosItems.cup = new ItemCup("cup");
		FronosItems.cream_golem = new ItemCreamGolem("cream_golem");
		FronosItems.fronos_item = new ItemFronos("fronos_item");
		FronosItems.tier_7_rocket = new ItemTier7Rocket("tier_7_rocket");
		FronosItems.tier_7_rocket_schematic = new ItemTier7RocketSchematic("tier_7_rocket_schematic");
		FronosItems.coconut_door = new ItemDoorMP("coconut_door", DoorType.COCONUT);
		FronosItems.maple_door = new ItemDoorMP("maple_door", DoorType.MAPLE);
		FronosItems.fruits_juice = new ItemFruitsJuice("fruits_juice");
		FronosItems.tier_8_rocket_module = new ItemTier8RocketModule("tier_8_rocket_module");

		// Register
		CommonRegisterHelper.registerItem(FronosItems.fronos_food);
		CommonRegisterHelper.registerItem(FronosItems.candy_food);
		CommonRegisterHelper.registerItem(FronosItems.candy_cane);
		CommonRegisterHelper.registerItem(FronosItems.fronos_fruits);
		CommonRegisterHelper.registerItem(FronosItems.glass_gem_corn);
		CommonRegisterHelper.registerItem(FronosItems.jelly);
		CommonRegisterHelper.registerItem(FronosItems.fruits_juice);
		CommonRegisterHelper.registerItem(FronosItems.cream_ball);
		CommonRegisterHelper.registerItem(FronosItems.strawberry_seed);
		CommonRegisterHelper.registerItem(FronosItems.golden_seeds);
		CommonRegisterHelper.registerItem(FronosItems.pearl);
		CommonRegisterHelper.registerItem(FronosItems.poison_arrow);
		CommonRegisterHelper.registerItem(FronosItems.bearry_egg);
		CommonRegisterHelper.registerItem(FronosItems.cream_golem);
		CommonRegisterHelper.registerItem(FronosItems.fronos_item);
		CommonRegisterHelper.registerItem(FronosItems.tier_7_rocket_schematic);
		CommonRegisterHelper.registerItem(FronosItems.tier_8_rocket_module);
		CommonRegisterHelper.registerItem(FronosItems.candy_bow);
		CommonRegisterHelper.registerItem(FronosItems.coconut_milk_bucket);
		CommonRegisterHelper.registerItem(FronosItems.mineral_water_bucket);
		CommonRegisterHelper.registerItem(FronosItems.ovaltine_bucket);
		CommonRegisterHelper.registerItem(FronosItems.tea_bucket);
		CommonRegisterHelper.registerItem(FronosItems.caramel_bucket);
		CommonRegisterHelper.registerItem(FronosItems.coconut_door);
		CommonRegisterHelper.registerItem(FronosItems.maple_door);
		CommonRegisterHelper.registerItem(FronosItems.cup);
		CommonRegisterHelper.registerItem(FronosItems.tier_7_rocket);
		CommonRegisterHelper.registerItem(FronosItems.fronos_dungeon_key);

		// Register ore dictionary
		OreDictionary.registerOre("blackDiamond", new ItemStack(FronosItems.fronos_item, 1, 2));
		OreDictionary.registerOre("gemDiamond", new ItemStack(FronosItems.fronos_item, 1, 2));
		OreDictionary.registerOre("ingotIridium", new ItemStack(FronosItems.fronos_item, 1, 3));
		OreDictionary.registerOre("compressedBlackDiamond", new ItemStack(FronosItems.fronos_item, 1, 4));
		OreDictionary.registerOre("compressedIridium", new ItemStack(FronosItems.fronos_item, 1, 5));

		OreDictionary.registerOre("candy", new ItemStack(FronosItems.candy_cane, 1, 0));
		OreDictionary.registerOre("candy", new ItemStack(FronosItems.candy_cane, 1, 1));
		OreDictionary.registerOre("candy", new ItemStack(FronosItems.candy_cane, 1, 2));
		OreDictionary.registerOre("candy", new ItemStack(FronosItems.candy_cane, 1, 3));
		OreDictionary.registerOre("candy", new ItemStack(FronosItems.candy_cane, 1, 4));
		OreDictionary.registerOre("candy", new ItemStack(FronosItems.candy_cane, 1, 5));
		OreDictionary.registerOre("candy", new ItemStack(FronosItems.candy_cane, 1, 6));
		OreDictionary.registerOre("candy", new ItemStack(FronosItems.candy_cane, 1, 7));

		// Register fluid container
		CommonRegisterHelper.registerFluidContainer(FronosBlocks.coconut_milk_fluid, new ItemStack(FronosItems.coconut_milk_bucket), new ItemStack(Items.bucket));
		CommonRegisterHelper.registerFluidContainer(FronosBlocks.mineral_water_fluid, new ItemStack(FronosItems.mineral_water_bucket), new ItemStack(Items.bucket));
		CommonRegisterHelper.registerFluidContainer(FronosBlocks.ovaltine_fluid, new ItemStack(FronosItems.ovaltine_bucket), new ItemStack(Items.bucket));
		CommonRegisterHelper.registerFluidContainer(FronosBlocks.tea_fluid, new ItemStack(FronosItems.tea_bucket), new ItemStack(Items.bucket));
		CommonRegisterHelper.registerFluidContainer(FronosBlocks.caramel_fluid, new ItemStack(FronosItems.caramel_bucket), new ItemStack(Items.bucket));
	}
}