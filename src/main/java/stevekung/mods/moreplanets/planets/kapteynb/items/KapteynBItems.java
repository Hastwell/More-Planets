/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.items;

import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.items.ItemBucketMP;
import stevekung.mods.moreplanets.common.items.ItemDungeonKeyMP;
import stevekung.mods.moreplanets.common.items.ItemInformation;
import stevekung.mods.moreplanets.common.util.ItemDescription;
import stevekung.mods.moreplanets.common.util.VariantsName;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.KapteynBBlocks;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class KapteynBItems
{
    public static Item kapteyn_b_item;
    public static Item kapteyn_b_dungeon_key;
    public static Item uranium_battery;
    public static Item frozen_water_bucket;
    public static Item namerium_crystal;
    public static Item tier_8_rocket;
    public static Item tier_8_rocket_schematic;

    public static void init()
    {
        // Init
        KapteynBItems.kapteyn_b_item = new ItemKapteynB("kapteyn_b_item");
        KapteynBItems.kapteyn_b_dungeon_key = new ItemDungeonKeyMP("kapteyn_b_dungeon_key", 8);
        KapteynBItems.uranium_battery = new ItemUraniumBattery("uranium_battery");
        KapteynBItems.frozen_water_bucket = new ItemBucketMP("frozen_water_bucket", KapteynBBlocks.frozen_water, null);
        KapteynBItems.namerium_crystal = new ItemNameriumCrystal("namerium_crystal");
        KapteynBItems.tier_8_rocket = new ItemTier8Rocket("tier_8_rocket");
        KapteynBItems.tier_8_rocket_schematic = new ItemInformation("tier_8_rocket_schematic", new VariantsName(new ItemDescription()
        {
            @Override
            public void addDescription(ItemStack itemStack, List list, boolean useLShift)
            {
                list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("schematic.tier8.rocket.name"));
            }
        }));

        // Register
        CommonRegisterHelper.registerItem(KapteynBItems.kapteyn_b_item);
        CommonRegisterHelper.registerItem(KapteynBItems.namerium_crystal);
        CommonRegisterHelper.registerItem(KapteynBItems.kapteyn_b_dungeon_key);
        CommonRegisterHelper.registerItem(KapteynBItems.uranium_battery);
        CommonRegisterHelper.registerItem(KapteynBItems.frozen_water_bucket);
        CommonRegisterHelper.registerItem(KapteynBItems.tier_8_rocket);
        CommonRegisterHelper.registerItem(KapteynBItems.tier_8_rocket_schematic);

        // Register ore dictionary
        OreDictionary.registerOre("ingotFrozenIron", new ItemStack(KapteynBItems.kapteyn_b_item, 1, 0));
        OreDictionary.registerOre("uranium", new ItemStack(KapteynBItems.kapteyn_b_item, 1, 1));
        OreDictionary.registerOre("compressedFrozenIron", new ItemStack(KapteynBItems.kapteyn_b_item, 1, 2));

        // Register fluid container
        CommonRegisterHelper.registerFluidContainer(KapteynBBlocks.frozen_water_fluid, new ItemStack(KapteynBItems.frozen_water_bucket), new ItemStack(Items.bucket));
    }
}