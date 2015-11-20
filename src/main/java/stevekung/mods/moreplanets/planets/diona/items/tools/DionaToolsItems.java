/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import stevekung.mods.moreplanets.common.items.tools.ItemAxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemHoeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemPickaxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemShovelMP;
import stevekung.mods.moreplanets.common.items.tools.ItemSwordMP;
import stevekung.mods.moreplanets.planets.diona.items.DionaItems;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class DionaToolsItems
{
	public static Item quontonium_sword;
	public static Item quontonium_shovel;
	public static Item quontonium_pickaxe;
	public static Item quontonium_axe;
	public static Item quontonium_hoe;
	public static Item fronisium_sword;
	public static Item fronisium_shovel;
	public static Item fronisium_pickaxe;
	public static Item fronisium_axe;
	public static Item fronisium_hoe;

	// Name,HarvestLevel,MaxUse,Efficiency,Damage,Enchantability
	public static ToolMaterial quontonium = EnumHelper.addToolMaterial("quontonium", 4, 1648, 9.5F, 3.5F, 8);
	public static ToolMaterial fronisium = EnumHelper.addToolMaterial("fronisium", 4, 1680, 9.5F, 3.75F, 8);

	public static void init()
	{
		// Init
		DionaToolsItems.quontonium_sword = new ItemSwordMP("quontonium_sword", DionaToolsItems.quontonium, DionaItems.diona_item, 2);
		DionaToolsItems.quontonium_shovel = new ItemShovelMP("quontonium_shovel", DionaToolsItems.quontonium, DionaItems.diona_item, 2);
		DionaToolsItems.quontonium_pickaxe = new ItemPickaxeMP("quontonium_pickaxe", DionaToolsItems.quontonium, DionaItems.diona_item, 2);
		DionaToolsItems.quontonium_axe = new ItemAxeMP("quontonium_axe", DionaToolsItems.quontonium, DionaItems.diona_item, 2);
		DionaToolsItems.quontonium_hoe = new ItemHoeMP("quontonium_hoe", DionaToolsItems.quontonium, DionaItems.diona_item, 2);
		DionaToolsItems.fronisium_sword = new ItemSwordMP("fronisium_sword", fronisium, DionaItems.diona_item, 3);
		DionaToolsItems.fronisium_shovel = new ItemShovelMP("fronisium_shovel", fronisium, DionaItems.diona_item, 3);
		DionaToolsItems.fronisium_pickaxe = new ItemPickaxeMP("fronisium_pickaxe", fronisium, DionaItems.diona_item, 3);
		DionaToolsItems.fronisium_axe = new ItemAxeMP("fronisium_axe", fronisium, DionaItems.diona_item, 3);
		DionaToolsItems.fronisium_hoe = new ItemHoeMP("fronisium_hoe", fronisium, DionaItems.diona_item, 3);

		// Register
		CommonRegisterHelper.registerItem(DionaToolsItems.quontonium_sword);
		CommonRegisterHelper.registerItem(DionaToolsItems.quontonium_shovel);
		CommonRegisterHelper.registerItem(DionaToolsItems.quontonium_pickaxe);
		CommonRegisterHelper.registerItem(DionaToolsItems.quontonium_axe);
		CommonRegisterHelper.registerItem(DionaToolsItems.quontonium_hoe);
		CommonRegisterHelper.registerItem(DionaToolsItems.fronisium_sword);
		CommonRegisterHelper.registerItem(DionaToolsItems.fronisium_shovel);
		CommonRegisterHelper.registerItem(DionaToolsItems.fronisium_pickaxe);
		CommonRegisterHelper.registerItem(DionaToolsItems.fronisium_axe);
		CommonRegisterHelper.registerItem(DionaToolsItems.fronisium_hoe);

		// Set harvest level
		CommonRegisterHelper.setToolHarvestLevel(DionaToolsItems.quontonium_shovel, "shovel", 3);
		CommonRegisterHelper.setToolHarvestLevel(DionaToolsItems.quontonium_pickaxe, "pickaxe", 3);
		CommonRegisterHelper.setToolHarvestLevel(DionaToolsItems.quontonium_axe, "axe", 3);
		CommonRegisterHelper.setToolHarvestLevel(DionaToolsItems.fronisium_shovel, "shovel", 3);
		CommonRegisterHelper.setToolHarvestLevel(DionaToolsItems.fronisium_pickaxe, "pickaxe", 3);
		CommonRegisterHelper.setToolHarvestLevel(DionaToolsItems.fronisium_axe, "axe", 3);
	}
}