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
import stevekung.mods.moreplanets.moons.io.blocks.IoBlocks;
import stevekung.mods.stevecore.RegisterHelper;

public class IoItems
{
	public static Item io_lava_bucket;
	public static Item io_black_lava_bucket;
	public static Item liquid_red_sulfur_bucket;
	public static Item liquid_yellow_sulfur_bucket;
	public static Item liquid_orange_sulfur_bucket;
	public static Item liquid_brown_sulfur_bucket;

	public static void init()
	{
		IoItems.initItems();
		IoItems.registerItems();
		IoItems.registerFluidContainer();
	}

	private static void initItems()
	{
		IoItems.io_lava_bucket = new ItemIoLavaBucket("io_lava_bucket");
		IoItems.io_black_lava_bucket = new ItemIoBlackLavaBucket("io_black_lava_bucket");
		IoItems.liquid_red_sulfur_bucket = new ItemLiquidRedSulfurBucket("liquid_red_sulfur_bucket");
		IoItems.liquid_yellow_sulfur_bucket = new ItemLiquidYellowSulfurBucket("liquid_yellow_sulfur_bucket");
		IoItems.liquid_orange_sulfur_bucket = new ItemLiquidOrangeSulfurBucket("liquid_orange_sulfur_bucket");
		IoItems.liquid_brown_sulfur_bucket = new ItemLiquidBrownSulfurBucket("liquid_brown_sulfur_bucket");
	}

	private static void registerItems()
	{
		RegisterHelper.registerItem(IoItems.io_lava_bucket);
		RegisterHelper.registerItem(IoItems.io_black_lava_bucket);
		RegisterHelper.registerItem(IoItems.liquid_red_sulfur_bucket);
		RegisterHelper.registerItem(IoItems.liquid_yellow_sulfur_bucket);
		RegisterHelper.registerItem(IoItems.liquid_orange_sulfur_bucket);
		RegisterHelper.registerItem(IoItems.liquid_brown_sulfur_bucket);
	}

	private static void registerFluidContainer()
	{
		RegisterHelper.registerFluidContainer(IoBlocks.io_lava_fluid, new ItemStack(IoItems.io_lava_bucket), new ItemStack(Items.bucket));
		RegisterHelper.registerFluidContainer(IoBlocks.io_black_lava_fluid, new ItemStack(IoItems.io_black_lava_bucket), new ItemStack(Items.bucket));
		RegisterHelper.registerFluidContainer(IoBlocks.liquid_red_sulfur_fluid, new ItemStack(IoItems.liquid_red_sulfur_bucket), new ItemStack(Items.bucket));
		RegisterHelper.registerFluidContainer(IoBlocks.liquid_yellow_sulfur_fluid, new ItemStack(IoItems.liquid_yellow_sulfur_bucket), new ItemStack(Items.bucket));
		RegisterHelper.registerFluidContainer(IoBlocks.liquid_orange_sulfur_fluid, new ItemStack(IoItems.liquid_orange_sulfur_bucket), new ItemStack(Items.bucket));
		RegisterHelper.registerFluidContainer(IoBlocks.liquid_brown_sulfur_fluid, new ItemStack(IoItems.liquid_brown_sulfur_bucket), new ItemStack(Items.bucket));
	}
}