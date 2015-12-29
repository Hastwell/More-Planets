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
import stevekung.mods.moreplanets.common.items.tools.ItemElectricAxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricHoeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricPickaxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricShovelMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricSwordMP;
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
        SiriusBToolsItems.sulfur_pickaxe = new ItemElectricPickaxeMP("sulfur_pickaxe", SiriusBToolsItems.sulfur, 30000.0F, null);
        SiriusBToolsItems.sulfur_axe = new ItemElectricAxeMP("sulfur_axe", SiriusBToolsItems.sulfur, 30000.0F, null);
        SiriusBToolsItems.sulfur_hoe = new ItemElectricHoeMP("sulfur_hoe", SiriusBToolsItems.sulfur, 30000.0F, null);
        SiriusBToolsItems.sulfur_shovel = new ItemElectricShovelMP("sulfur_shovel", SiriusBToolsItems.sulfur, 30000.0F, null);
        SiriusBToolsItems.sulfur_sword = new ItemElectricSwordMP("sulfur_sword", SiriusBToolsItems.sulfur, 30000.0F, null);

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