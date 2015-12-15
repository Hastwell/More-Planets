/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.items;

import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.items.ItemDungeonKeyMP;
import stevekung.mods.moreplanets.common.items.ItemInformation;
import stevekung.mods.moreplanets.common.items.ItemMultiVariant;
import stevekung.mods.moreplanets.common.items.ItemMultiVariantInfo;
import stevekung.mods.moreplanets.common.util.ItemDescription;
import stevekung.mods.moreplanets.common.util.VariantsName;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class DionaItems
{
    public static Item diona_item;
    public static Item tier_4_rocket_schematic;
    public static Item tier_4_rocket_module;
    public static Item laser_gun;
    public static Item laser_ammo;
    public static Item tier_4_rocket;
    public static Item diona_dungeon_key;

    public static void init()
    {
        // Init
        DionaItems.diona_item = new ItemMultiVariantInfo("diona_item", new VariantsName(new ItemDescription()
        {
            @Override
            public void addDescription(ItemStack itemStack, List list, boolean useLShift)
            {
                if (itemStack.getItemDamage() == 4)
                {
                    list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("desc.tier5.name"));
                }
            }
        }, "quontonium_ingot", "fronisium_ingot", "compressed_quontonium", "compressed_fronisium", "tier_5_heavy_duty_plate", "quontonium_stick", "fronisium_stick"));
        DionaItems.tier_4_rocket_schematic = new ItemInformation("tier_4_rocket_schematic", new VariantsName(new ItemDescription()
        {
            @Override
            public void addDescription(ItemStack itemStack, List list, boolean useLShift)
            {
                list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("schematic.tier4.rocket.name"));
            }
        }));
        DionaItems.tier_4_rocket_module = new ItemMultiVariantInfo("tier_4_rocket_module", new VariantsName(new ItemDescription()
        {
            @Override
            public void addDescription(ItemStack itemStack, List list, boolean useLShift)
            {
                if (itemStack.getItemDamage() == 1)
                {
                    list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("desc.tier4.name"));
                }
            }
        }, "tier_4_nose_cone", "tier_4_heavy_duty_plate", "tier_4_rocket_engine", "tier_4_booster", "tier_5_rocket_engine", "tier_5_booster"));
        DionaItems.laser_gun = new ItemLaserGun("laser_gun");
        DionaItems.laser_ammo = new ItemMultiVariant("laser_ammo", new VariantsName(true, "normal_laser_ammo", "hyper_laser_ammo", "emp_laser_ammo", "uranium_laser_ammo", "icy_poison_laser_ammo"));
        DionaItems.tier_4_rocket = new ItemTier4Rocket("tier_4_rocket");
        DionaItems.diona_dungeon_key = new ItemDungeonKeyMP("diona_dungeon_key", 4);

        // Register
        CommonRegisterHelper.registerItem(DionaItems.diona_item);
        CommonRegisterHelper.registerItem(DionaItems.tier_4_rocket_schematic);
        CommonRegisterHelper.registerItem(DionaItems.tier_4_rocket_module);
        CommonRegisterHelper.registerItem(DionaItems.laser_gun);
        CommonRegisterHelper.registerItem(DionaItems.laser_ammo);
        CommonRegisterHelper.registerItem(DionaItems.tier_4_rocket);
        CommonRegisterHelper.registerItem(DionaItems.diona_dungeon_key);

        // Register ore dictionary
        OreDictionary.registerOre("ingotQuontonium", new ItemStack(DionaItems.diona_item, 1, 0));
        OreDictionary.registerOre("ingotFronisium", new ItemStack(DionaItems.diona_item, 1, 1));
        OreDictionary.registerOre("compressedQuontonium", new ItemStack(DionaItems.diona_item, 1, 2));
        OreDictionary.registerOre("compressedFronisium", new ItemStack(DionaItems.diona_item, 1, 3));
    }
}