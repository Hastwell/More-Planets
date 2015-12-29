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
import stevekung.mods.moreplanets.common.items.tools.ItemElectricAxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricHoeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricPickaxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricShovelMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricSwordMP;
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
        DionaToolsItems.quontonium_sword = new ItemElectricSwordMP("quontonium_sword", DionaToolsItems.quontonium, 15000.0F, null);
        DionaToolsItems.quontonium_shovel = new ItemElectricShovelMP("quontonium_shovel", DionaToolsItems.quontonium, 15000.0F, null);
        DionaToolsItems.quontonium_pickaxe = new ItemElectricPickaxeMP("quontonium_pickaxe", DionaToolsItems.quontonium, 15000.0F, null);
        DionaToolsItems.quontonium_axe = new ItemElectricAxeMP("quontonium_axe", DionaToolsItems.quontonium, 15000.0F, null);
        DionaToolsItems.quontonium_hoe = new ItemElectricHoeMP("quontonium_hoe", DionaToolsItems.quontonium, 15000.0F, null);
        DionaToolsItems.fronisium_sword = new ItemElectricSwordMP("fronisium_sword", DionaToolsItems.fronisium, 15000.0F, null);
        DionaToolsItems.fronisium_shovel = new ItemElectricShovelMP("fronisium_shovel", DionaToolsItems.fronisium, 15000.0F, null);
        DionaToolsItems.fronisium_pickaxe = new ItemElectricPickaxeMP("fronisium_pickaxe", DionaToolsItems.fronisium, 15000.0F, null);
        DionaToolsItems.fronisium_axe = new ItemElectricAxeMP("fronisium_axe", DionaToolsItems.fronisium, 15000.0F, null);
        DionaToolsItems.fronisium_hoe = new ItemElectricHoeMP("fronisium_hoe", DionaToolsItems.fronisium, 15000.0F, null);

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