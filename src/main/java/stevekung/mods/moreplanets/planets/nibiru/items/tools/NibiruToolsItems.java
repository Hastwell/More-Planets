/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.nibiru.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricAxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricHoeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricPickaxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricShovelMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricSwordMP;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class NibiruToolsItems
{
    public static Item red_gem_pickaxe;
    public static Item red_gem_axe;
    public static Item red_gem_hoe;
    public static Item red_gem_shovel;
    public static Item red_gem_sword;
    public static Item norium_pickaxe;
    public static Item norium_axe;
    public static Item norium_hoe;
    public static Item norium_shovel;
    public static Item norium_sword;

    // Name,HarvestLevel,MaxUse,Efficiency,Damage,Enchantability
    public static ToolMaterial red_gem = EnumHelper.addToolMaterial("red_gem", 4, 1716, 10.25F, 3.75F, 8);
    public static ToolMaterial norium = EnumHelper.addToolMaterial("norium", 4, 1712, 10.5F, 4.0F, 8);

    public static void init()
    {
        // Init
        NibiruToolsItems.red_gem_pickaxe = new ItemElectricPickaxeMP("red_gem_pickaxe", NibiruToolsItems.red_gem, 20000.0F, null);
        NibiruToolsItems.red_gem_axe = new ItemElectricAxeMP("red_gem_axe", NibiruToolsItems.red_gem, 20000.0F, null);
        NibiruToolsItems.red_gem_hoe = new ItemElectricHoeMP("red_gem_hoe", NibiruToolsItems.red_gem, 20000.0F, null);
        NibiruToolsItems.red_gem_shovel = new ItemElectricShovelMP("red_gem_shovel", NibiruToolsItems.red_gem, 20000.0F, null);
        NibiruToolsItems.red_gem_sword = new ItemElectricSwordMP("red_gem_sword", NibiruToolsItems.red_gem, 20000.0F, null);
        NibiruToolsItems.norium_pickaxe = new ItemElectricPickaxeMP("norium_pickaxe", NibiruToolsItems.norium, 20000.0F, null);
        NibiruToolsItems.norium_axe = new ItemElectricAxeMP("norium_axe", NibiruToolsItems.norium, 20000.0F, null);
        NibiruToolsItems.norium_hoe = new ItemElectricHoeMP("norium_hoe", NibiruToolsItems.norium, 20000.0F, null);
        NibiruToolsItems.norium_shovel = new ItemElectricShovelMP("norium_shovel", NibiruToolsItems.norium, 20000.0F, null);
        NibiruToolsItems.norium_sword = new ItemElectricSwordMP("norium_sword", NibiruToolsItems.norium, 20000.0F, null);

        // Register
        CommonRegisterHelper.registerItem(NibiruToolsItems.red_gem_sword);
        CommonRegisterHelper.registerItem(NibiruToolsItems.red_gem_shovel);
        CommonRegisterHelper.registerItem(NibiruToolsItems.red_gem_pickaxe);
        CommonRegisterHelper.registerItem(NibiruToolsItems.red_gem_axe);
        CommonRegisterHelper.registerItem(NibiruToolsItems.red_gem_hoe);
        CommonRegisterHelper.registerItem(NibiruToolsItems.norium_sword);
        CommonRegisterHelper.registerItem(NibiruToolsItems.norium_shovel);
        CommonRegisterHelper.registerItem(NibiruToolsItems.norium_pickaxe);
        CommonRegisterHelper.registerItem(NibiruToolsItems.norium_axe);
        CommonRegisterHelper.registerItem(NibiruToolsItems.norium_hoe);

        // Set harvest level
        CommonRegisterHelper.setToolHarvestLevel(NibiruToolsItems.red_gem_pickaxe, "pickaxe", 3);
        CommonRegisterHelper.setToolHarvestLevel(NibiruToolsItems.red_gem_axe, "axe", 3);
        CommonRegisterHelper.setToolHarvestLevel(NibiruToolsItems.red_gem_shovel, "shovel", 3);
        CommonRegisterHelper.setToolHarvestLevel(NibiruToolsItems.norium_pickaxe, "pickaxe", 3);
        CommonRegisterHelper.setToolHarvestLevel(NibiruToolsItems.norium_axe, "axe", 3);
        CommonRegisterHelper.setToolHarvestLevel(NibiruToolsItems.norium_shovel, "shovel", 3);
    }
}