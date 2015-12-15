/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.io.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import stevekung.mods.moreplanets.common.items.ItemBucketMP;
import stevekung.mods.moreplanets.moons.io.blocks.IoBlocks;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class IoItems
{
    public static Item io_lava_bucket;
    public static Item black_io_lava_bucket;
    public static Item red_liquid_sulfur_bucket;
    public static Item yellow_liquid_sulfur_bucket;
    public static Item orange_liquid_sulfur_bucket;
    public static Item brown_liquid_sulfur_bucket;

    public static void init()
    {
        // Init
        IoItems.io_lava_bucket = new ItemBucketMP("io_lava_bucket", IoBlocks.io_lava, null);
        IoItems.black_io_lava_bucket = new ItemBucketMP("black_io_lava_bucket", IoBlocks.black_io_lava, null);
        IoItems.red_liquid_sulfur_bucket = new ItemBucketMP("red_liquid_sulfur_bucket", IoBlocks.red_liquid_sulfur, null);
        IoItems.yellow_liquid_sulfur_bucket = new ItemBucketMP("yellow_liquid_sulfur_bucket", IoBlocks.yellow_liquid_sulfur, null);
        IoItems.orange_liquid_sulfur_bucket = new ItemBucketMP("orange_liquid_sulfur_bucket", IoBlocks.orange_liquid_sulfur, null);
        IoItems.brown_liquid_sulfur_bucket = new ItemBucketMP("brown_liquid_sulfur_bucket", IoBlocks.brown_liquid_sulfur, null);

        // Register
        CommonRegisterHelper.registerItem(IoItems.io_lava_bucket);
        CommonRegisterHelper.registerItem(IoItems.black_io_lava_bucket);
        CommonRegisterHelper.registerItem(IoItems.red_liquid_sulfur_bucket);
        CommonRegisterHelper.registerItem(IoItems.yellow_liquid_sulfur_bucket);
        CommonRegisterHelper.registerItem(IoItems.orange_liquid_sulfur_bucket);
        CommonRegisterHelper.registerItem(IoItems.brown_liquid_sulfur_bucket);

        // Register fluid container
        CommonRegisterHelper.registerFluidContainer(IoBlocks.io_lava_fluid, new ItemStack(IoItems.io_lava_bucket), new ItemStack(Items.bucket));
        CommonRegisterHelper.registerFluidContainer(IoBlocks.black_io_lava_fluid, new ItemStack(IoItems.black_io_lava_bucket), new ItemStack(Items.bucket));
        CommonRegisterHelper.registerFluidContainer(IoBlocks.red_liquid_sulfur_fluid, new ItemStack(IoItems.red_liquid_sulfur_bucket), new ItemStack(Items.bucket));
        CommonRegisterHelper.registerFluidContainer(IoBlocks.yellow_liquid_sulfur_fluid, new ItemStack(IoItems.yellow_liquid_sulfur_bucket), new ItemStack(Items.bucket));
        CommonRegisterHelper.registerFluidContainer(IoBlocks.orange_liquid_sulfur_fluid, new ItemStack(IoItems.orange_liquid_sulfur_bucket), new ItemStack(Items.bucket));
        CommonRegisterHelper.registerFluidContainer(IoBlocks.brown_liquid_sulfur_fluid, new ItemStack(IoItems.brown_liquid_sulfur_bucket), new ItemStack(Items.bucket));
    }
}