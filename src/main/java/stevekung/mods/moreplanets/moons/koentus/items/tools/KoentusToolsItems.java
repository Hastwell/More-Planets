/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.koentus.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricAxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricHoeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricPickaxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricShovelMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricSwordMP;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class KoentusToolsItems
{
    public static Item white_crystal_pickaxe;
    public static Item white_crystal_axe;
    public static Item white_crystal_hoe;
    public static Item white_crystal_shovel;
    public static Item white_crystal_sword;
    public static Item koentus_meteoric_iron_pickaxe;
    public static Item koentus_meteoric_iron_axe;
    public static Item koentus_meteoric_iron_hoe;
    public static Item koentus_meteoric_iron_shovel;
    public static Item koentus_meteoric_iron_sword;

    // Name,HarvestLevel,MaxUse,Efficiency,Damage,Enchantability
    public static ToolMaterial white_crystal = EnumHelper.addToolMaterial("white_crystal", 4, 1612, 9.25F, 3.25F, 8);
    public static ToolMaterial koentus_meteoric_iron = EnumHelper.addToolMaterial("koentus_meteoric_iron", 4, 1654, 9.5F, 3.75F, 8);

    public static void init()
    {
        // Init
        KoentusToolsItems.white_crystal_pickaxe = new ItemElectricPickaxeMP("white_crystal_pickaxe", KoentusToolsItems.white_crystal, 18500.0F, null);
        KoentusToolsItems.white_crystal_axe = new ItemElectricAxeMP("white_crystal_axe", KoentusToolsItems.white_crystal, 18500.0F, null);
        KoentusToolsItems.white_crystal_hoe = new ItemElectricHoeMP("white_crystal_hoe", KoentusToolsItems.white_crystal, 18500.0F, null);
        KoentusToolsItems.white_crystal_shovel = new ItemElectricShovelMP("white_crystal_shovel", KoentusToolsItems.white_crystal, 18500.0F, null);
        KoentusToolsItems.white_crystal_sword = new ItemElectricSwordMP("white_crystal_sword", KoentusToolsItems.white_crystal, 18500.0F, null);
        KoentusToolsItems.koentus_meteoric_iron_pickaxe = new ItemElectricPickaxeMP("koentus_meteoric_iron_pickaxe", KoentusToolsItems.koentus_meteoric_iron, 18000.0F, null);
        KoentusToolsItems.koentus_meteoric_iron_axe = new ItemElectricAxeMP("koentus_meteoric_iron_axe", KoentusToolsItems.koentus_meteoric_iron, 18000.0F, null);
        KoentusToolsItems.koentus_meteoric_iron_hoe = new ItemElectricHoeMP("koentus_meteoric_iron_hoe", KoentusToolsItems.koentus_meteoric_iron, 18000.0F, null);
        KoentusToolsItems.koentus_meteoric_iron_shovel = new ItemElectricShovelMP("koentus_meteoric_iron_shovel", KoentusToolsItems.koentus_meteoric_iron, 18000.0F, null);
        KoentusToolsItems.koentus_meteoric_iron_sword = new ItemElectricSwordMP("koentus_meteoric_iron_sword", KoentusToolsItems.koentus_meteoric_iron, 18000.0F, null);

        // Register
        CommonRegisterHelper.registerItem(KoentusToolsItems.white_crystal_sword);
        CommonRegisterHelper.registerItem(KoentusToolsItems.white_crystal_shovel);
        CommonRegisterHelper.registerItem(KoentusToolsItems.white_crystal_pickaxe);
        CommonRegisterHelper.registerItem(KoentusToolsItems.white_crystal_axe);
        CommonRegisterHelper.registerItem(KoentusToolsItems.white_crystal_hoe);
        CommonRegisterHelper.registerItem(KoentusToolsItems.koentus_meteoric_iron_sword);
        CommonRegisterHelper.registerItem(KoentusToolsItems.koentus_meteoric_iron_shovel);
        CommonRegisterHelper.registerItem(KoentusToolsItems.koentus_meteoric_iron_pickaxe);
        CommonRegisterHelper.registerItem(KoentusToolsItems.koentus_meteoric_iron_axe);
        CommonRegisterHelper.registerItem(KoentusToolsItems.koentus_meteoric_iron_hoe);

        // Set harvest level
        CommonRegisterHelper.setToolHarvestLevel(KoentusToolsItems.white_crystal_pickaxe, "pickaxe", 3);
        CommonRegisterHelper.setToolHarvestLevel(KoentusToolsItems.white_crystal_axe, "axe", 3);
        CommonRegisterHelper.setToolHarvestLevel(KoentusToolsItems.white_crystal_shovel, "shovel", 3);
        CommonRegisterHelper.setToolHarvestLevel(KoentusToolsItems.koentus_meteoric_iron_pickaxe, "pickaxe", 3);
        CommonRegisterHelper.setToolHarvestLevel(KoentusToolsItems.koentus_meteoric_iron_axe, "axe", 3);
        CommonRegisterHelper.setToolHarvestLevel(KoentusToolsItems.koentus_meteoric_iron_shovel, "shovel", 3);
    }
}