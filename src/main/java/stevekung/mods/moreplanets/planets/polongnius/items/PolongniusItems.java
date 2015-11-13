/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.items.ItemBucketMP;
import stevekung.mods.moreplanets.common.items.ItemMorePlanets;
import stevekung.mods.moreplanets.planets.polongnius.blocks.PolongniusBlocks;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class PolongniusItems
{
	public static Item polongnius_item;
	public static Item purple_crystal_solar_module;
	public static Item cheese_food;
	public static Item polongnius_dungeon_key;
	public static Item cheese_slimeball;
	public static Item tier_5_rocket;
	public static Item tier_6_rocket_module;
	public static Item tier_5_rocket_schematic;
	public static Item cheese_of_milk_bucket;
	public static Item polongnius_meteor_chunk;

	public static void init()
	{
		// Init
		PolongniusItems.polongnius_item = new ItemPolongnius("polongnius_item");
		PolongniusItems.purple_crystal_solar_module = new ItemPurpleCrystalSolarModule("purple_crystal_solar_module");
		PolongniusItems.cheese_food = new ItemCheeseFood("cheese_food");
		PolongniusItems.polongnius_dungeon_key = new ItemPolongniusDungeonKey("polongnius_dungeon_key");
		PolongniusItems.cheese_slimeball = new ItemMorePlanets("cheese_slimeball");
		PolongniusItems.tier_5_rocket = new ItemTier5Rocket("tier_5_rocket");
		PolongniusItems.tier_6_rocket_module = new ItemTier6RocketModule("tier_6_rocket_module");
		PolongniusItems.tier_5_rocket_schematic = new ItemTier5RocketSchematic("tier_5_rocket_schematic");
		PolongniusItems.cheese_of_milk_bucket = new ItemBucketMP("cheese_of_milk_bucket", PolongniusBlocks.cheese_of_milk, null);
		PolongniusItems.polongnius_meteor_chunk = new ItemPolongniusMeteorChunk("polongnius_meteor_chunk");

		// Register
		CommonRegisterHelper.registerItem(PolongniusItems.polongnius_item);
		CommonRegisterHelper.registerItem(PolongniusItems.purple_crystal_solar_module);
		CommonRegisterHelper.registerItem(PolongniusItems.tier_5_rocket_schematic);
		CommonRegisterHelper.registerItem(PolongniusItems.tier_6_rocket_module);
		CommonRegisterHelper.registerItem(PolongniusItems.cheese_slimeball);
		CommonRegisterHelper.registerItem(PolongniusItems.cheese_food);
		CommonRegisterHelper.registerItem(PolongniusItems.cheese_of_milk_bucket);
		CommonRegisterHelper.registerItem(PolongniusItems.tier_5_rocket);
		CommonRegisterHelper.registerItem(PolongniusItems.polongnius_meteor_chunk);
		CommonRegisterHelper.registerItem(PolongniusItems.polongnius_dungeon_key);

		// Register ore dictionary
		OreDictionary.registerOre("slimeball", PolongniusItems.cheese_slimeball);
		OreDictionary.registerOre("ingotPolongniusMeteoricIron", new ItemStack(PolongniusItems.polongnius_item, 1, 4));
		OreDictionary.registerOre("ingotPalladium", new ItemStack(PolongniusItems.polongnius_item, 1, 5));
		OreDictionary.registerOre("compressedPolongniusMeteoricIron", new ItemStack(PolongniusItems.polongnius_item, 1, 6));
		OreDictionary.registerOre("compressedPalladium", new ItemStack(PolongniusItems.polongnius_item, 1, 7));

		// Register fluid container
		CommonRegisterHelper.registerFluidContainer(PolongniusBlocks.cheese_of_milk_fluid, new ItemStack(PolongniusItems.cheese_of_milk_bucket), new ItemStack(Items.bucket));
	}
}