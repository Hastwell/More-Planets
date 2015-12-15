/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.nibiru.items;

import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.blocks.BlockDoorMP.DoorType;
import stevekung.mods.moreplanets.common.items.ItemDoorMP;
import stevekung.mods.moreplanets.common.items.ItemDungeonKeyMP;
import stevekung.mods.moreplanets.common.items.ItemInformation;
import stevekung.mods.moreplanets.common.items.ItemMultiVariant;
import stevekung.mods.moreplanets.common.items.ItemMultiVariantInfo;
import stevekung.mods.moreplanets.common.util.ItemDescription;
import stevekung.mods.moreplanets.common.util.VariantsName;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class NibiruItems
{
    public static Item nibiru_item;
    public static Item space_fruits;
    public static Item nibiru_dungeon_key;
    public static Item power_crystal;
    public static Item tier_6_rocket;
    public static Item tier_7_rocket_module;
    public static Item tier_6_rocket_schematic;
    public static Item ancient_dark_door;
    public static Item orange_door;

    public static void init()
    {
        // Init
        NibiruItems.nibiru_item = new ItemMultiVariant("nibiru_item", new VariantsName("red_gem", "norium_ingot", "compressed_red_gem", "compressed_norium", "red_gem_stick", "norium_stick"));
        NibiruItems.space_fruits = new ItemSpaceFruits("space_fruits");
        NibiruItems.nibiru_dungeon_key = new ItemDungeonKeyMP("nibiru_dungeon_key", 6);
        NibiruItems.power_crystal = new ItemPowerCrystal("power_crystal");
        NibiruItems.tier_6_rocket = new ItemTier6Rocket("tier_6_rocket");
        NibiruItems.tier_7_rocket_module = new ItemMultiVariantInfo("tier_7_rocket_module", new VariantsName(new ItemDescription()
        {
            @Override
            public void addDescription(ItemStack itemStack, List list, boolean useLShift)
            {
                if (itemStack.getItemDamage() == 2)
                {
                    list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("desc.tier7.name"));
                }
            }
        }, "tier_7_rocket_engine", "tier_7_booster", "tier_7_heavy_duty_plate", "tier_7_rocket_fin", "tier_7_nose_cone"));
        NibiruItems.tier_6_rocket_schematic = new ItemInformation("tier_6_rocket_schematic", new VariantsName(new ItemDescription()
        {
            @Override
            public void addDescription(ItemStack itemStack, List list, boolean useLShift)
            {
                list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("schematic.tier6.rocket.name"));
            }
        }));
        NibiruItems.ancient_dark_door = new ItemDoorMP("ancient_dark_door", DoorType.ANCIENT_DARK);
        NibiruItems.orange_door = new ItemDoorMP("orange_door", DoorType.ORANGE);

        // Register
        CommonRegisterHelper.registerItem(NibiruItems.nibiru_item);
        CommonRegisterHelper.registerItem(NibiruItems.power_crystal);
        CommonRegisterHelper.registerItem(NibiruItems.tier_6_rocket_schematic);
        CommonRegisterHelper.registerItem(NibiruItems.tier_7_rocket_module);
        CommonRegisterHelper.registerItem(NibiruItems.ancient_dark_door);
        CommonRegisterHelper.registerItem(NibiruItems.orange_door);
        CommonRegisterHelper.registerItem(NibiruItems.space_fruits);
        CommonRegisterHelper.registerItem(NibiruItems.tier_6_rocket);
        CommonRegisterHelper.registerItem(NibiruItems.nibiru_dungeon_key);

        // Register ore dictionary
        OreDictionary.registerOre("ingotNorium", new ItemStack(NibiruItems.nibiru_item, 1, 1));
        OreDictionary.registerOre("compressedNorium", new ItemStack(NibiruItems.nibiru_item, 1, 3));
        OreDictionary.registerOre("compressedRedGem", new ItemStack(NibiruItems.nibiru_item, 1, 2));
    }
}