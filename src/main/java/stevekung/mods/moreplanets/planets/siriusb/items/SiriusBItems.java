/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.items.ItemBucketMP;
import stevekung.mods.moreplanets.common.items.ItemDungeonKeyMP;
import stevekung.mods.moreplanets.common.items.ItemMorePlanets;
import stevekung.mods.moreplanets.common.items.ItemMultiVariant;
import stevekung.mods.moreplanets.common.util.VariantsName;
import stevekung.mods.moreplanets.planets.siriusb.blocks.SiriusBBlocks;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class SiriusBItems
{
    public static Item sirius_b_item;
    public static Item sirius_b_dungeon_key;
    public static Item sirius_fire_charge;
    public static Item sirius_lava_bucket;
    public static Item sirius_glowstone_dust;
    public static Item sirius_magma_cream;

    public static void init()
    {
        // Init
        SiriusBItems.sirius_b_item = new ItemMultiVariant("sirius_b_item", new VariantsName("small_diamond_pieces", "large_diamond_pieces", "sulfur_dust", "sulfur_ingot", "compressed_sulfur", "sulfur_stick"));
        SiriusBItems.sirius_b_dungeon_key = new ItemDungeonKeyMP("sirius_b_dungeon_key", 8);
        SiriusBItems.sirius_fire_charge = new ItemSiriusFireCharge("sirius_fire_charge");
        SiriusBItems.sirius_lava_bucket = new ItemBucketMP("sirius_lava_bucket", SiriusBBlocks.sirius_lava, null);
        SiriusBItems.sirius_glowstone_dust = new ItemMorePlanets("sirius_glowstone_dust");
        SiriusBItems.sirius_magma_cream = new ItemMorePlanets("sirius_magma_cream");

        // Register
        CommonRegisterHelper.registerItem(SiriusBItems.sirius_b_item);
        CommonRegisterHelper.registerItem(SiriusBItems.sirius_glowstone_dust);
        CommonRegisterHelper.registerItem(SiriusBItems.sirius_fire_charge);
        CommonRegisterHelper.registerItem(SiriusBItems.sirius_magma_cream);
        CommonRegisterHelper.registerItem(SiriusBItems.sirius_lava_bucket);
        CommonRegisterHelper.registerItem(SiriusBItems.sirius_b_dungeon_key);

        // Register ore dictionary
        OreDictionary.registerOre("ingotSulfur", new ItemStack(SiriusBItems.sirius_b_item, 1, 0));
        OreDictionary.registerOre("compressedSulfur", new ItemStack(SiriusBItems.sirius_b_item, 1, 1));

        // Register fluid container
        CommonRegisterHelper.registerFluidContainer(SiriusBBlocks.sirius_lava_fluid, new ItemStack(SiriusBItems.sirius_lava_bucket), new ItemStack(Items.bucket));
    }
}