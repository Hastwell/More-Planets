/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricAxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricHoeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricPickaxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricShovelMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricSwordMP;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class PolongniusToolsItems
{
    public static Item polongnius_meteoric_iron_pickaxe;
    public static Item polongnius_meteoric_iron_axe;
    public static Item polongnius_meteoric_iron_hoe;
    public static Item polongnius_meteoric_iron_shovel;
    public static Item polongnius_meteoric_iron_sword;
    public static Item palladium_pickaxe;
    public static Item palladium_axe;
    public static Item palladium_hoe;
    public static Item palladium_shovel;
    public static Item palladium_sword;
    public static Item purple_crystal_pickaxe;
    public static Item purple_crystal_axe;
    public static Item purple_crystal_hoe;
    public static Item purple_crystal_shovel;
    public static Item purple_crystal_sword;

    // Name,HarvestLevel,MaxUse,Efficiency,Damage,Enchantability
    public static ToolMaterial polongnius_meteoric_iron = EnumHelper.addToolMaterial("polongnius_meteoric_iron", 4, 1686, 10.0F, 3.75F, 8);
    public static ToolMaterial palladium = EnumHelper.addToolMaterial("palladium", 4, 1694, 10.0F, 3.75F, 8);
    public static ToolMaterial purple_crystal = EnumHelper.addToolMaterial("purple_crystal", 4, 1572, 9.75F, 3.5F, 8);

    public static void init()
    {
        // Init
        PolongniusToolsItems.polongnius_meteoric_iron_pickaxe = new ItemElectricPickaxeMP("polongnius_meteoric_iron_pickaxe", PolongniusToolsItems.polongnius_meteoric_iron, 17500.0F, null);
        PolongniusToolsItems.polongnius_meteoric_iron_axe = new ItemElectricAxeMP("polongnius_meteoric_iron_axe", PolongniusToolsItems.polongnius_meteoric_iron, 17500.0F, null);
        PolongniusToolsItems.polongnius_meteoric_iron_hoe = new ItemElectricHoeMP("polongnius_meteoric_iron_hoe", PolongniusToolsItems.polongnius_meteoric_iron, 17500.0F, null);
        PolongniusToolsItems.polongnius_meteoric_iron_shovel = new ItemElectricShovelMP("polongnius_meteoric_iron_shovel", PolongniusToolsItems.polongnius_meteoric_iron, 17500.0F, null);
        PolongniusToolsItems.polongnius_meteoric_iron_sword = new ItemElectricSwordMP("polongnius_meteoric_iron_sword", PolongniusToolsItems.polongnius_meteoric_iron, 17500.0F, null);
        PolongniusToolsItems.palladium_pickaxe = new ItemElectricPickaxeMP("palladium_pickaxe", PolongniusToolsItems.palladium, 17500.0F, null);
        PolongniusToolsItems.palladium_axe = new ItemElectricAxeMP("palladium_axe", PolongniusToolsItems.palladium, 17500.0F, null);
        PolongniusToolsItems.palladium_hoe = new ItemElectricHoeMP("palladium_hoe", PolongniusToolsItems.palladium, 17500.0F, null);
        PolongniusToolsItems.palladium_shovel = new ItemElectricShovelMP("palladium_shovel", PolongniusToolsItems.palladium, 17500.0F, null);
        PolongniusToolsItems.palladium_sword = new ItemElectricSwordMP("palladium_sword", PolongniusToolsItems.palladium, 17500.0F, null);
        PolongniusToolsItems.purple_crystal_pickaxe = new ItemElectricPickaxeMP("purple_crystal_pickaxe", PolongniusToolsItems.purple_crystal, 18000.0F, null);
        PolongniusToolsItems.purple_crystal_axe = new ItemElectricAxeMP("purple_crystal_axe", PolongniusToolsItems.purple_crystal, 18000.0F, null);
        PolongniusToolsItems.purple_crystal_hoe = new ItemElectricHoeMP("purple_crystal_hoe", PolongniusToolsItems.purple_crystal, 18000.0F, null);
        PolongniusToolsItems.purple_crystal_shovel = new ItemElectricShovelMP("purple_crystal_shovel", PolongniusToolsItems.purple_crystal, 18000.0F, null);
        PolongniusToolsItems.purple_crystal_sword = new ItemElectricSwordMP("purple_crystal_sword", PolongniusToolsItems.purple_crystal, 18000.0F, null);

        // Register
        CommonRegisterHelper.registerItem(PolongniusToolsItems.polongnius_meteoric_iron_sword);
        CommonRegisterHelper.registerItem(PolongniusToolsItems.polongnius_meteoric_iron_shovel);
        CommonRegisterHelper.registerItem(PolongniusToolsItems.polongnius_meteoric_iron_pickaxe);
        CommonRegisterHelper.registerItem(PolongniusToolsItems.polongnius_meteoric_iron_axe);
        CommonRegisterHelper.registerItem(PolongniusToolsItems.polongnius_meteoric_iron_hoe);
        CommonRegisterHelper.registerItem(PolongniusToolsItems.palladium_sword);
        CommonRegisterHelper.registerItem(PolongniusToolsItems.palladium_shovel);
        CommonRegisterHelper.registerItem(PolongniusToolsItems.palladium_pickaxe);
        CommonRegisterHelper.registerItem(PolongniusToolsItems.palladium_axe);
        CommonRegisterHelper.registerItem(PolongniusToolsItems.palladium_hoe);
        CommonRegisterHelper.registerItem(PolongniusToolsItems.purple_crystal_sword);
        CommonRegisterHelper.registerItem(PolongniusToolsItems.purple_crystal_shovel);
        CommonRegisterHelper.registerItem(PolongniusToolsItems.purple_crystal_pickaxe);
        CommonRegisterHelper.registerItem(PolongniusToolsItems.purple_crystal_axe);
        CommonRegisterHelper.registerItem(PolongniusToolsItems.purple_crystal_hoe);

        // Set harvest level
        CommonRegisterHelper.setToolHarvestLevel(PolongniusToolsItems.polongnius_meteoric_iron_pickaxe, "pickaxe", 3);
        CommonRegisterHelper.setToolHarvestLevel(PolongniusToolsItems.polongnius_meteoric_iron_axe, "axe", 3);
        CommonRegisterHelper.setToolHarvestLevel(PolongniusToolsItems.polongnius_meteoric_iron_shovel, "shovel", 3);
        CommonRegisterHelper.setToolHarvestLevel(PolongniusToolsItems.palladium_pickaxe, "pickaxe", 3);
        CommonRegisterHelper.setToolHarvestLevel(PolongniusToolsItems.palladium_axe, "axe", 3);
        CommonRegisterHelper.setToolHarvestLevel(PolongniusToolsItems.palladium_shovel, "shovel", 3);
        CommonRegisterHelper.setToolHarvestLevel(PolongniusToolsItems.purple_crystal_pickaxe, "pickaxe", 3);
        CommonRegisterHelper.setToolHarvestLevel(PolongniusToolsItems.purple_crystal_axe, "axe", 3);
        CommonRegisterHelper.setToolHarvestLevel(PolongniusToolsItems.purple_crystal_shovel, "shovel", 3);
    }
}