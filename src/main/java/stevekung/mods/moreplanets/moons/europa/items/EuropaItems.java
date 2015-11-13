/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import stevekung.mods.moreplanets.common.blocks.BlockDoorMP.DoorType;
import stevekung.mods.moreplanets.common.items.ItemBucketMP;
import stevekung.mods.moreplanets.common.items.ItemDoorMP;
import stevekung.mods.moreplanets.common.items.ItemMorePlanets;
import stevekung.mods.moreplanets.moons.europa.blocks.EuropaBlocks;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class EuropaItems
{
	public static Item europa_prismarine;
	public static Item europa_apple;
	public static Item europa_water_bucket;
	public static Item europa_door;
	public static Item europa_food;
	public static Item europa_gunpowder;

	public static void init()
	{
		// Init
		EuropaItems.europa_prismarine = new ItemEuropaPrismarine("europa_prismarine_item");
		EuropaItems.europa_apple = new ItemEuropaApple("europa_apple");
		EuropaItems.europa_water_bucket = new ItemBucketMP("europa_water_bucket", EuropaBlocks.europa_water, null);
		EuropaItems.europa_door = new ItemDoorMP("europa_door", DoorType.EUROPA);
		EuropaItems.europa_food = new ItemEuropaFood("europa_food");
		EuropaItems.europa_gunpowder = new ItemMorePlanets("europa_gunpowder");

		// Register
		CommonRegisterHelper.registerItem(EuropaItems.europa_prismarine);
		CommonRegisterHelper.registerItem(EuropaItems.europa_gunpowder);
		CommonRegisterHelper.registerItem(EuropaItems.europa_apple);
		CommonRegisterHelper.registerItem(EuropaItems.europa_food);
		CommonRegisterHelper.registerItem(EuropaItems.europa_water_bucket);
		CommonRegisterHelper.registerItem(EuropaItems.europa_door);

		// Register fluid container
		CommonRegisterHelper.registerFluidContainer(EuropaBlocks.europa_water_fluid, new ItemStack(EuropaItems.europa_water_bucket), new ItemStack(Items.bucket));
	}
}