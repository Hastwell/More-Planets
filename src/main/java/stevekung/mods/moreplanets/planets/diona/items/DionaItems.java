/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class DionaItems
{
	public static Item diona_item;
	public static Item tier_4_rocket_schematic;
	public static Item tier_4_rocket_module;
	public static Item laser_gun;
	public static Item laser_ammo;
	public static Item tier_4_rocket;
	public static Item diona_dungeon_key;

	public static void init()
	{
		// Init
		DionaItems.diona_item = new ItemDiona("diona_item");
		DionaItems.tier_4_rocket_schematic = new ItemTier4RocketSchematic("tier_4_rocket_schematic");
		DionaItems.tier_4_rocket_module = new ItemTier4RocketModule("tier_4_rocket_module");
		DionaItems.laser_gun = new ItemLaserGun("laser_gun");
		DionaItems.laser_ammo = new ItemLaserAmmo("laser_ammo");
		DionaItems.tier_4_rocket = new ItemTier4Rocket("tier_4_rocket");
		DionaItems.diona_dungeon_key = new ItemDionaDungeonKey("diona_dungeon_key");

		// Register
		CommonRegisterHelper.registerItem(DionaItems.diona_item);
		CommonRegisterHelper.registerItem(DionaItems.tier_4_rocket_schematic);
		CommonRegisterHelper.registerItem(DionaItems.tier_4_rocket_module);
		CommonRegisterHelper.registerItem(DionaItems.laser_gun);
		CommonRegisterHelper.registerItem(DionaItems.laser_ammo);
		CommonRegisterHelper.registerItem(DionaItems.tier_4_rocket);
		CommonRegisterHelper.registerItem(DionaItems.diona_dungeon_key);

		// Register ore dictionary
		OreDictionary.registerOre("ingotQuontonium", new ItemStack(DionaItems.diona_item, 1, 0));
		OreDictionary.registerOre("ingotFronisium", new ItemStack(DionaItems.diona_item, 1, 1));
		OreDictionary.registerOre("compressedQuontonium", new ItemStack(DionaItems.diona_item, 1, 2));
		OreDictionary.registerOre("compressedFronisium", new ItemStack(DionaItems.diona_item, 1, 3));
	}
}