/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.pluto.items.tools;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;
import stevekung.mods.moreplanets.common.items.tools.IToolEffect;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricAxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricHoeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricPickaxeMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricShovelMP;
import stevekung.mods.moreplanets.common.items.tools.ItemElectricSwordMP;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class PlutoToolsItems
{
    public static Item xeonium_pickaxe;
    public static Item xeonium_axe;
    public static Item xeonium_hoe;
    public static Item xeonium_shovel;
    public static Item xeonium_sword;

    // Name,HarvestLevel,MaxUse,Efficiency,Damage,Enchantability
    public static ToolMaterial xeonium = EnumHelper.addToolMaterial("xeonium", 4, 0, 11.0F, 5.0F, 8);

    public static void init()
    {
        // Init
        PlutoToolsItems.xeonium_pickaxe = new ItemElectricPickaxeMP("xeonium_pickaxe", PlutoToolsItems.xeonium, 35000.0F, new IToolEffect()
        {
            @Override
            public void addEffect(EntityLivingBase living)
            {
                living.addPotionEffect(new PotionEffect(Potion.confusion.id, 200));
            }
        });
        PlutoToolsItems.xeonium_axe = new ItemElectricAxeMP("xeonium_axe", PlutoToolsItems.xeonium, 35000.0F, new IToolEffect()
        {
            @Override
            public void addEffect(EntityLivingBase living)
            {
                living.addPotionEffect(new PotionEffect(Potion.confusion.id, 200));
            }
        });
        PlutoToolsItems.xeonium_hoe = new ItemElectricHoeMP("xeonium_hoe", PlutoToolsItems.xeonium, 35000.0F, new IToolEffect()
        {
            @Override
            public void addEffect(EntityLivingBase living)
            {
                living.addPotionEffect(new PotionEffect(Potion.confusion.id, 200));
            }
        });
        PlutoToolsItems.xeonium_shovel = new ItemElectricShovelMP("xeonium_shovel", PlutoToolsItems.xeonium, 35000.0F, new IToolEffect()
        {
            @Override
            public void addEffect(EntityLivingBase living)
            {
                living.addPotionEffect(new PotionEffect(Potion.confusion.id, 200));
            }
        });
        PlutoToolsItems.xeonium_sword = new ItemElectricSwordMP("xeonium_sword", PlutoToolsItems.xeonium, 35000.0F, new IToolEffect()
        {
            @Override
            public void addEffect(EntityLivingBase living)
            {
                living.addPotionEffect(new PotionEffect(Potion.confusion.id, 200));
            }
        });

        // Register
        CommonRegisterHelper.registerItem(PlutoToolsItems.xeonium_sword);
        CommonRegisterHelper.registerItem(PlutoToolsItems.xeonium_shovel);
        CommonRegisterHelper.registerItem(PlutoToolsItems.xeonium_pickaxe);
        CommonRegisterHelper.registerItem(PlutoToolsItems.xeonium_axe);
        CommonRegisterHelper.registerItem(PlutoToolsItems.xeonium_hoe);

        // Set harvest level
        CommonRegisterHelper.setToolHarvestLevel(PlutoToolsItems.xeonium_pickaxe, "pickaxe", 3);
        CommonRegisterHelper.setToolHarvestLevel(PlutoToolsItems.xeonium_axe, "axe", 3);
        CommonRegisterHelper.setToolHarvestLevel(PlutoToolsItems.xeonium_shovel, "shovel", 3);
    }
}