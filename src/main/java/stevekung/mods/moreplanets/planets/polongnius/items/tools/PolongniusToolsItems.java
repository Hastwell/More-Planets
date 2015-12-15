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
import stevekung.mods.moreplanets.common.items.tools.ItemAxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemHoeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemPickaxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemShovelMP;
import stevekung.mods.moreplanets.common.items.tools.ItemSwordMP;
import stevekung.mods.moreplanets.planets.polongnius.items.PolongniusItems;
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
        PolongniusToolsItems.polongnius_meteoric_iron_pickaxe = new ItemPickaxeMP("polongnius_meteoric_iron_pickaxe", PolongniusToolsItems.polongnius_meteoric_iron, PolongniusItems.polongnius_item, 6);
        PolongniusToolsItems.polongnius_meteoric_iron_axe = new ItemAxeMP("polongnius_meteoric_iron_axe", PolongniusToolsItems.polongnius_meteoric_iron, PolongniusItems.polongnius_item, 6);
        PolongniusToolsItems.polongnius_meteoric_iron_hoe = new ItemHoeMP("polongnius_meteoric_iron_hoe", PolongniusToolsItems.polongnius_meteoric_iron, PolongniusItems.polongnius_item, 6);
        PolongniusToolsItems.polongnius_meteoric_iron_shovel = new ItemShovelMP("polongnius_meteoric_iron_shovel", PolongniusToolsItems.polongnius_meteoric_iron, PolongniusItems.polongnius_item, 6);
        PolongniusToolsItems.polongnius_meteoric_iron_sword = new ItemSwordMP("polongnius_meteoric_iron_sword", PolongniusToolsItems.polongnius_meteoric_iron, PolongniusItems.polongnius_item, 6);
        PolongniusToolsItems.palladium_pickaxe = new ItemPickaxeMP("palladium_pickaxe", PolongniusToolsItems.palladium, PolongniusItems.polongnius_item, 7);
        PolongniusToolsItems.palladium_axe = new ItemAxeMP("palladium_axe", PolongniusToolsItems.palladium, PolongniusItems.polongnius_item, 7);
        PolongniusToolsItems.palladium_hoe = new ItemHoeMP("palladium_hoe", PolongniusToolsItems.palladium, PolongniusItems.polongnius_item, 7);
        PolongniusToolsItems.palladium_shovel = new ItemShovelMP("palladium_shovel", PolongniusToolsItems.palladium, PolongniusItems.polongnius_item, 7);
        PolongniusToolsItems.palladium_sword = new ItemSwordMP("palladium_sword", PolongniusToolsItems.palladium, PolongniusItems.polongnius_item, 7);
        PolongniusToolsItems.purple_crystal_pickaxe = new ItemPickaxeMP("purple_crystal_pickaxe", PolongniusToolsItems.purple_crystal, PolongniusItems.polongnius_item, 1);
        PolongniusToolsItems.purple_crystal_axe = new ItemAxeMP("purple_crystal_axe", PolongniusToolsItems.purple_crystal, PolongniusItems.polongnius_item, 1);
        PolongniusToolsItems.purple_crystal_hoe = new ItemHoeMP("purple_crystal_hoe", PolongniusToolsItems.purple_crystal, PolongniusItems.polongnius_item, 1);
        PolongniusToolsItems.purple_crystal_shovel = new ItemShovelMP("purple_crystal_shovel", PolongniusToolsItems.purple_crystal, PolongniusItems.polongnius_item, 1);
        PolongniusToolsItems.purple_crystal_sword = new ItemSwordMP("purple_crystal_sword", PolongniusToolsItems.purple_crystal, PolongniusItems.polongnius_item, 1);

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