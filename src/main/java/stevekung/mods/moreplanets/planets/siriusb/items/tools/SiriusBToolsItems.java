/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import stevekung.mods.moreplanets.common.items.tools.ItemAxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemHoeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemPickaxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemShovelMP;
import stevekung.mods.moreplanets.common.items.tools.ItemSwordMP;
import stevekung.mods.moreplanets.planets.siriusb.items.SiriusBItems;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class SiriusBToolsItems
{
    public static Item sulfur_pickaxe;
    public static Item sulfur_axe;
    public static Item sulfur_hoe;
    public static Item sulfur_shovel;
    public static Item sulfur_sword;

    // Name,HarvestLevel,MaxUse,Efficiency,Damage,Enchantability
    public static ToolMaterial sulfur = EnumHelper.addToolMaterial("sulfur", 3, 1364, 9.75F, 4.0F, 8);

    public static void init()
    {
        // Init
        SiriusBToolsItems.sulfur_pickaxe = new ItemPickaxeMP("sulfur_pickaxe", SiriusBToolsItems.sulfur, SiriusBItems.sirius_b_item, 4);
        SiriusBToolsItems.sulfur_axe = new ItemAxeMP("sulfur_axe", SiriusBToolsItems.sulfur, SiriusBItems.sirius_b_item, 4);
        SiriusBToolsItems.sulfur_hoe = new ItemHoeMP("sulfur_hoe", SiriusBToolsItems.sulfur, SiriusBItems.sirius_b_item, 4);
        SiriusBToolsItems.sulfur_shovel = new ItemShovelMP("sulfur_shovel", SiriusBToolsItems.sulfur, SiriusBItems.sirius_b_item, 4);
        SiriusBToolsItems.sulfur_sword = new ItemSwordMP("sulfur_sword", SiriusBToolsItems.sulfur, SiriusBItems.sirius_b_item, 4);

        // Register
        CommonRegisterHelper.registerItem(SiriusBToolsItems.sulfur_sword);
        CommonRegisterHelper.registerItem(SiriusBToolsItems.sulfur_shovel);
        CommonRegisterHelper.registerItem(SiriusBToolsItems.sulfur_pickaxe);
        CommonRegisterHelper.registerItem(SiriusBToolsItems.sulfur_axe);
        CommonRegisterHelper.registerItem(SiriusBToolsItems.sulfur_hoe);

        // Set harvest level
        CommonRegisterHelper.setToolHarvestLevel(SiriusBToolsItems.sulfur_pickaxe, "pickaxe", 3);
        CommonRegisterHelper.setToolHarvestLevel(SiriusBToolsItems.sulfur_axe, "axe", 3);
        CommonRegisterHelper.setToolHarvestLevel(SiriusBToolsItems.sulfur_shovel, "shovel", 3);
    }
}