/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.mercury.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.items.ItemBucketMP;
import stevekung.mods.moreplanets.common.items.ItemMultiVariant;
import stevekung.mods.moreplanets.common.util.VariantsName;
import stevekung.mods.moreplanets.planets.mercury.blocks.MercuryBlocks;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class MercuryItems
{
    public static Item mercury_item;
    public static Item dirty_water_bucket;

    public static void init()
    {
        // Init
        MercuryItems.mercury_item = new ItemMultiVariant("mercury_item", new VariantsName("metallic_shard", "raw_metal_meteoric_iron", "metallic_ingot", "metal_meteoric_iron_ingot", "compressed_metallic", "compressed_metal_meteoric_iron", "gravity_core", "gravity_controller"));
        MercuryItems.dirty_water_bucket = new ItemBucketMP("dirty_water_bucket", MercuryBlocks.dirty_water, null);

        // Register
        CommonRegisterHelper.registerItem(MercuryItems.mercury_item);
        CommonRegisterHelper.registerItem(MercuryItems.dirty_water_bucket);

        // Register ore dictionary
        OreDictionary.registerOre("ingotMetallic", new ItemStack(MercuryItems.mercury_item, 1, 2));
        OreDictionary.registerOre("ingotMetalMeteoricIron", new ItemStack(MercuryItems.mercury_item, 1, 3));
        OreDictionary.registerOre("compressedMetallic", new ItemStack(MercuryItems.mercury_item, 1, 4));
        OreDictionary.registerOre("compressedMetalMeteoricIron", new ItemStack(MercuryItems.mercury_item, 1, 5));

        // Register fluid container
        CommonRegisterHelper.registerFluidContainer(MercuryBlocks.dirty_water_fluid, new ItemStack(MercuryItems.dirty_water_bucket), new ItemStack(Items.bucket));
    }
}