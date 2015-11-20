/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class KapteynBToolsItems
{
	public static Item frozen_iron_pickaxe;
	public static Item frozen_iron_axe;
	public static Item frozen_iron_hoe;
	public static Item frozen_iron_shovel;
	public static Item frozen_iron_sword;
	public static Item uranium_pickaxe;
	public static Item uranium_axe;
	public static Item uranium_hoe;
	public static Item uranium_shovel;
	public static Item uranium_sword;
	public static Item ice_crystal_pickaxe;
	public static Item ice_crystal_axe;
	public static Item ice_crystal_hoe;
	public static Item ice_crystal_shovel;
	public static Item ice_crystal_sword;

	// Name,HarvestLevel,MaxUse,Efficiency,Damage,Enchantability
	public static ToolMaterial frozen_iron = EnumHelper.addToolMaterial("frozen_iron", 4, 1254, 9.75F, 4.75F, 8);
	public static ToolMaterial uranium = EnumHelper.addToolMaterial("uranium", 4, 1764, 11.0F, 5.0F, 8);
	public static ToolMaterial ice_crystal = EnumHelper.addToolMaterial("ice_crystal", 4, 1824, 12.0F, 5.5F, 8);

	public static void init()
	{
		// Init
		KapteynBToolsItems.frozen_iron_pickaxe = new ItemFrozenIronPickaxe("frozen_iron_pickaxe", KapteynBToolsItems.frozen_iron);
		KapteynBToolsItems.frozen_iron_axe = new ItemFrozenIronAxe("frozen_iron_axe", KapteynBToolsItems.frozen_iron);
		KapteynBToolsItems.frozen_iron_hoe = new ItemFrozenIronHoe("frozen_iron_hoe", KapteynBToolsItems.frozen_iron);
		KapteynBToolsItems.frozen_iron_shovel = new ItemFrozenIronShovel("frozen_iron_shovel", KapteynBToolsItems.frozen_iron);
		KapteynBToolsItems.frozen_iron_sword = new ItemFrozenIronSword("frozen_iron_sword", KapteynBToolsItems.frozen_iron);
		KapteynBToolsItems.uranium_pickaxe = new ItemUraniumPickaxe("uranium_pickaxe", KapteynBToolsItems.uranium);
		KapteynBToolsItems.uranium_axe = new ItemUraniumAxe("uranium_axe", KapteynBToolsItems.uranium);
		KapteynBToolsItems.uranium_hoe = new ItemUraniumHoe("uranium_hoe", KapteynBToolsItems.uranium);
		KapteynBToolsItems.uranium_shovel = new ItemUraniumShovel("uranium_shovel", KapteynBToolsItems.uranium);
		KapteynBToolsItems.uranium_sword = new ItemUraniumSword("uranium_sword", KapteynBToolsItems.uranium);
		KapteynBToolsItems.ice_crystal_pickaxe = new ItemIceCrystalPickaxe("ice_crystal_pickaxe", KapteynBToolsItems.ice_crystal);
		KapteynBToolsItems.ice_crystal_axe = new ItemIceCrystalAxe("ice_crystal_axe", KapteynBToolsItems.ice_crystal);
		KapteynBToolsItems.ice_crystal_hoe = new ItemIceCrystalHoe("ice_crystal_hoe", KapteynBToolsItems.ice_crystal);
		KapteynBToolsItems.ice_crystal_shovel = new ItemIceCrystalShovel("ice_crystal_shovel", KapteynBToolsItems.ice_crystal);
		KapteynBToolsItems.ice_crystal_sword = new ItemIceCrystalSword("ice_crystal_sword", KapteynBToolsItems.ice_crystal);

		// Register
		CommonRegisterHelper.registerItem(KapteynBToolsItems.frozen_iron_sword);
		CommonRegisterHelper.registerItem(KapteynBToolsItems.frozen_iron_shovel);
		CommonRegisterHelper.registerItem(KapteynBToolsItems.frozen_iron_pickaxe);
		CommonRegisterHelper.registerItem(KapteynBToolsItems.frozen_iron_axe);
		CommonRegisterHelper.registerItem(KapteynBToolsItems.frozen_iron_hoe);
		CommonRegisterHelper.registerItem(KapteynBToolsItems.uranium_sword);
		CommonRegisterHelper.registerItem(KapteynBToolsItems.uranium_shovel);
		CommonRegisterHelper.registerItem(KapteynBToolsItems.uranium_pickaxe);
		CommonRegisterHelper.registerItem(KapteynBToolsItems.uranium_axe);
		CommonRegisterHelper.registerItem(KapteynBToolsItems.uranium_hoe);
		CommonRegisterHelper.registerItem(KapteynBToolsItems.ice_crystal_sword);
		CommonRegisterHelper.registerItem(KapteynBToolsItems.ice_crystal_shovel);
		CommonRegisterHelper.registerItem(KapteynBToolsItems.ice_crystal_pickaxe);
		CommonRegisterHelper.registerItem(KapteynBToolsItems.ice_crystal_axe);
		CommonRegisterHelper.registerItem(KapteynBToolsItems.ice_crystal_hoe);

		// Set harvest level
		CommonRegisterHelper.setToolHarvestLevel(KapteynBToolsItems.frozen_iron_pickaxe, "pickaxe", 3);
		CommonRegisterHelper.setToolHarvestLevel(KapteynBToolsItems.frozen_iron_axe, "axe", 3);
		CommonRegisterHelper.setToolHarvestLevel(KapteynBToolsItems.frozen_iron_shovel, "shovel", 3);
		CommonRegisterHelper.setToolHarvestLevel(KapteynBToolsItems.uranium_pickaxe, "pickaxe", 3);
		CommonRegisterHelper.setToolHarvestLevel(KapteynBToolsItems.uranium_axe, "axe", 3);
		CommonRegisterHelper.setToolHarvestLevel(KapteynBToolsItems.uranium_shovel, "shovel", 3);
		CommonRegisterHelper.setToolHarvestLevel(KapteynBToolsItems.ice_crystal_pickaxe, "pickaxe", 3);
		CommonRegisterHelper.setToolHarvestLevel(KapteynBToolsItems.ice_crystal_axe, "axe", 3);
		CommonRegisterHelper.setToolHarvestLevel(KapteynBToolsItems.ice_crystal_shovel, "shovel", 3);
	}
}