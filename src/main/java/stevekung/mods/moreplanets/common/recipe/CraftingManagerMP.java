/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.recipe;

import java.util.HashMap;

import micdoodle8.mods.galacticraft.api.recipe.CircuitFabricatorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.recipe.RecipeManagerGC;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import stevekung.mods.moreplanets.common.config.ConfigManagerMP;
import stevekung.mods.moreplanets.core.init.MPBlocks;
import stevekung.mods.moreplanets.core.init.MPItems;
import stevekung.mods.moreplanets.moons.deimos.blocks.DeimosBlocks;
import stevekung.mods.moreplanets.moons.europa.blocks.EuropaBlocks;
import stevekung.mods.moreplanets.moons.europa.items.EuropaItems;
import stevekung.mods.moreplanets.moons.io.blocks.IoBlocks;
import stevekung.mods.moreplanets.moons.koentus.blocks.KoentusBlocks;
import stevekung.mods.moreplanets.moons.koentus.items.KoentusItems;
import stevekung.mods.moreplanets.moons.koentus.items.armor.KoentusArmorItems;
import stevekung.mods.moreplanets.moons.koentus.items.tools.KoentusToolsItems;
import stevekung.mods.moreplanets.moons.phobos.blocks.PhobosBlocks;
import stevekung.mods.moreplanets.planets.diona.blocks.DionaBlocks;
import stevekung.mods.moreplanets.planets.diona.items.DionaItems;
import stevekung.mods.moreplanets.planets.diona.items.armor.DionaArmorItems;
import stevekung.mods.moreplanets.planets.diona.items.tools.DionaToolsItems;
import stevekung.mods.moreplanets.planets.diona.recipe.Tier4RocketRecipes;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;
import stevekung.mods.moreplanets.planets.fronos.items.armor.FronosArmorItems;
import stevekung.mods.moreplanets.planets.fronos.items.tools.FronosToolsItems;
import stevekung.mods.moreplanets.planets.fronos.recipe.Tier7RocketRecipes;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.KapteynBBlocks;
import stevekung.mods.moreplanets.planets.kapteynb.items.KapteynBItems;
import stevekung.mods.moreplanets.planets.kapteynb.items.armor.KapteynBArmorItems;
import stevekung.mods.moreplanets.planets.kapteynb.items.tools.KapteynBToolsItems;
import stevekung.mods.moreplanets.planets.kapteynb.recipe.Tier8RocketRecipes;
import stevekung.mods.moreplanets.planets.mercury.blocks.MercuryBlocks;
import stevekung.mods.moreplanets.planets.mercury.items.MercuryItems;
import stevekung.mods.moreplanets.planets.nibiru.blocks.NibiruBlocks;
import stevekung.mods.moreplanets.planets.nibiru.items.NibiruItems;
import stevekung.mods.moreplanets.planets.nibiru.items.armor.NibiruArmorItems;
import stevekung.mods.moreplanets.planets.nibiru.items.tools.NibiruToolsItems;
import stevekung.mods.moreplanets.planets.nibiru.recipe.Tier6RocketRecipes;
import stevekung.mods.moreplanets.planets.pluto.blocks.PlutoBlocks;
import stevekung.mods.moreplanets.planets.pluto.items.PlutoItems;
import stevekung.mods.moreplanets.planets.polongnius.blocks.PolongniusBlocks;
import stevekung.mods.moreplanets.planets.polongnius.items.PolongniusItems;
import stevekung.mods.moreplanets.planets.polongnius.items.armor.PolongniusArmorItems;
import stevekung.mods.moreplanets.planets.polongnius.items.tools.PolongniusToolsItems;
import stevekung.mods.moreplanets.planets.polongnius.recipe.Tier5RocketRecipes;
import stevekung.mods.moreplanets.planets.siriusb.blocks.SiriusBBlocks;
import stevekung.mods.moreplanets.planets.siriusb.items.SiriusBItems;
import stevekung.mods.moreplanets.planets.siriusb.items.armor.SiriusBArmorItems;
import stevekung.mods.moreplanets.planets.siriusb.items.tools.SiriusBToolsItems;
import stevekung.mods.moreplanets.planets.venus.blocks.VenusBlocks;
import stevekung.mods.moreplanets.planets.venus.items.VenusItems;

public class CraftingManagerMP
{
	public static void init()
	{
		CraftingManagerMP.registerNormalRecipes();
		CraftingManagerMP.registerSlabRecipes();
		CraftingManagerMP.registerStairsRecipes();
		CraftingManagerMP.registerWallRecipes();
		CraftingManagerMP.registerArmorsToolsRecipes();

		CraftingManagerMP.registerTier4RocketRecipe();
		CraftingManagerMP.registerTier5RocketRecipe();
		CraftingManagerMP.registerTier6RocketRecipe();
		CraftingManagerMP.registerTier7RocketRecipe();
		CraftingManagerMP.registerTier8RocketRecipe();
	}

	private static void registerNormalRecipes()
	{
		int quick = ConfigManagerCore.quickMode ? 2 : 1;

		// Blocks
		GameRegistry.addRecipe(new ItemStack(DionaBlocks.diona_block, 1, 10), new Object[] { "QQQ", "QQQ", "QQQ", 'Q', new ItemStack(DionaItems.diona_item, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(DionaBlocks.diona_block, 1, 11), new Object[] { "FFF", "FFF", "FFF", 'F', new ItemStack(DionaItems.diona_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(DionaBlocks.diona_block, 4, 12), new Object[] { "   ", " S ", " Q ", 'S', new ItemStack(Blocks.stone), 'Q', new ItemStack(DionaItems.diona_item, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(DionaBlocks.diona_block, 4, 13), new Object[] { "QQ", "QQ", 'Q', new ItemStack(DionaBlocks.diona_block, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(DionaBlocks.fronisium_tnt, 1), new Object[] { "GFG", "FGF", "GFG", 'G', new ItemStack(Items.gunpowder), 'F', new ItemStack(DionaItems.diona_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(DionaBlocks.diona_block, 1, 14), new Object[] { "Q", "Q", 'Q', new ItemStack(MPBlocks.half_stone_slab_1, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(PolongniusBlocks.polongnius_block, 1, 11), new Object[] { "MMM", "MMM", "MMM", 'M', new ItemStack(PolongniusItems.polongnius_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(PolongniusBlocks.polongnius_block, 1, 12), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(PolongniusItems.polongnius_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(PolongniusBlocks.polongnius_block, 1, 13), new Object[] { "PPP", "PPP", "PPP", 'P', new ItemStack(PolongniusItems.polongnius_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(PolongniusBlocks.cheese_slime_block), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(PolongniusItems.cheese_slimeball) });
		GameRegistry.addRecipe(new ItemStack(PolongniusBlocks.flonium_torch, 4), new Object[] { "F", "S", 'F', new ItemStack(PolongniusItems.polongnius_item, 1, 0), 'S', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(PolongniusBlocks.ultra_violet_solar_panel), new Object[] { "TST", "TPT", "AWA", 'S', new ItemStack(PolongniusItems.purple_crystal_solar_module, 1, 3), 'A', new ItemStack(GCBlocks.aluminumWire, 1, 1), 'T', new ItemStack(AsteroidsItems.basicItem, 1, 0), 'P', new ItemStack(GCItems.flagPole), 'W', new ItemStack(PolongniusItems.purple_crystal_solar_module, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(PolongniusBlocks.cheese_of_milk_cake), new Object[] { "CCC", "CMC", "CCC", 'C', new ItemStack(PolongniusItems.cheese_food, 1, 0), 'M', new ItemStack(Items.milk_bucket) });
		GameRegistry.addRecipe(new ItemStack(NibiruBlocks.power_crystal_generator), new Object[] { "AAA", "TFT", "TWT", 'A', new ItemStack(AsteroidsItems.basicItem, 1, 6), 'F', new ItemStack(Blocks.furnace), 'W', new ItemStack(GCBlocks.aluminumWire, 1, 1), 'T', new ItemStack(AsteroidsItems.basicItem, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(NibiruBlocks.ichorius_torch, 4), new Object[] { "I", "S", 'I', new ItemStack(NibiruItems.power_crystal), 'S', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(NibiruBlocks.nibiru_block, 1, 9), new Object[] { "III", "III", "III", 'I', new ItemStack(NibiruItems.power_crystal) });
		GameRegistry.addRecipe(new ItemStack(NibiruBlocks.nibiru_block, 1, 10), new Object[] { "NNN", "NNN", "NNN", 'N', new ItemStack(NibiruItems.nibiru_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(NibiruBlocks.nibiru_block, 1, 11), new Object[] { "GGG", "GGG", "GGG", 'G', new ItemStack(NibiruItems.nibiru_item, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(NibiruBlocks.nibiru_fence, 3, 0), new Object[] { "ASA", "ASA", 'A', new ItemStack(NibiruBlocks.nibiru_planks, 1, 0), 'S', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(NibiruBlocks.nibiru_fence, 3, 1), new Object[] { "OSO", "OSO", 'O', new ItemStack(NibiruBlocks.nibiru_planks, 1, 1), 'S', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(NibiruBlocks.ancient_dark_fence_gate), new Object[] { "SAS", "SAS", 'A', new ItemStack(NibiruBlocks.nibiru_planks, 1, 0), 'S', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(NibiruBlocks.orange_fence_gate), new Object[] { "SOS", "SOS", 'O', new ItemStack(NibiruBlocks.nibiru_planks, 1, 1), 'S', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(NibiruBlocks.infected_dirt, 4, 1), new Object[] { "DG", "GD", 'D', new ItemStack(NibiruBlocks.infected_dirt, 1, 0), 'G', new ItemStack(Blocks.gravel) });
		GameRegistry.addRecipe(new ItemStack(KoentusBlocks.koentus_block, 1, 9), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(KoentusItems.koentus_item, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(KoentusBlocks.koentus_block, 1, 10), new Object[] { "MMM", "MMM", "MMM", 'M', new ItemStack(KoentusItems.koentus_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(KoentusBlocks.koentus_block, 1, 13), new Object[] { "SS", "SS", 'S', new ItemStack(KoentusBlocks.koentus_block, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(KoentusBlocks.white_crystal_torch, 4), new Object[] { "W", "S", 'W', new ItemStack(KoentusItems.koentus_item, 1, 0), 'S', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(KoentusBlocks.crystal_fence, 3), new Object[] { "CSC", "CSC", 'S', new ItemStack(Items.stick), 'C', new ItemStack(KoentusBlocks.crystal_planks) });
		GameRegistry.addRecipe(new ItemStack(KoentusBlocks.crystal_fence_gate), new Object[] { "SAS", "SAS", 'A', new ItemStack(KoentusBlocks.crystal_planks), 'S', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(KoentusBlocks.koentus_block, 1, 11), new Object[] { "III", "III", "III" ,'I', new ItemStack(KoentusItems.koentus_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(KoentusBlocks.crystal_dirt, 4, 1), new Object[] { "DG", "GD", 'D', new ItemStack(KoentusBlocks.crystal_dirt, 1, 0), 'G', new ItemStack(Blocks.gravel) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.fronos_block, 4, 11), new Object[] { "SS", "SS", 'S', new ItemStack(FronosBlocks.fronos_block, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.cookie_block), new Object[] { "CC", "CC", 'C', new ItemStack(Items.cookie) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.cream_block, 1, 0), new Object[] { "VV", "VV", 'V', new ItemStack(FronosItems.cream_ball, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.cream_block, 1, 1), new Object[] { "CC", "CC", 'C', new ItemStack(FronosItems.cream_ball, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.cream_block, 1, 2), new Object[] { "SS", "SS", 'S', new ItemStack(FronosItems.cream_ball, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.cream_block, 1, 3), new Object[] { "OO", "OO", 'O', new ItemStack(FronosItems.cream_ball, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.cream_block, 1, 4), new Object[] { "TT", "TT", 'T', new ItemStack(FronosItems.cream_ball, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.cream_block, 1, 5), new Object[] { "LL", "LL", 'L', new ItemStack(FronosItems.cream_ball, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.vanilla_cream_layer, 6), new Object[] { "VVV", 'V', new ItemStack(FronosBlocks.cream_block, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.chocolate_cream_layer, 6), new Object[] { "CCC", 'C', new ItemStack(FronosBlocks.cream_block, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.strawberry_cream_layer, 6), new Object[] { "SSS", 'S', new ItemStack(FronosBlocks.cream_block, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.orange_cream_layer, 6), new Object[] { "OOO", 'O', new ItemStack(FronosBlocks.cream_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.tea_cream_layer, 6), new Object[] { "TTT", 'T', new ItemStack(FronosBlocks.cream_block, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.lemon_cream_layer, 6), new Object[] { "LLL", 'L', new ItemStack(FronosBlocks.cream_block, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.ovaltine_block), new Object[] { "OO", "OO", 'O', new ItemStack(FronosItems.candy_food, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.chocolate_block), new Object[] { "CC", "CC", 'C', new ItemStack(FronosItems.candy_food, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.pink_candy_torch, 4), new Object[] { "C", "S", 'C', new ItemStack(Items.coal), 'S', new ItemStack(FronosItems.candy_cane, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.orange_candy_torch, 4), new Object[] { "C", "S", 'C', new ItemStack(Items.coal), 'S', new ItemStack(FronosItems.candy_cane, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.green_candy_torch, 4), new Object[] { "C", "S", 'C', new ItemStack(Items.coal), 'S', new ItemStack(FronosItems.candy_cane, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.yellow_candy_torch, 4), new Object[] { "C", "S", 'C', new ItemStack(Items.coal), 'S', new ItemStack(FronosItems.candy_cane, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.light_blue_candy_torch, 4), new Object[] { "C", "S", 'C', new ItemStack(Items.coal), 'S', new ItemStack(FronosItems.candy_cane, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.blue_candy_torch, 4), new Object[] { "C", "S", 'C', new ItemStack(Items.coal), 'S', new ItemStack(FronosItems.candy_cane, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.red_candy_torch, 4), new Object[] { "C", "S", 'C', new ItemStack(Items.coal), 'S', new ItemStack(FronosItems.candy_cane, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.purple_candy_torch, 4), new Object[] { "C", "S", 'C', new ItemStack(Items.coal), 'S', new ItemStack(FronosItems.candy_cane, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.jelly_block, 1, 0), new Object[] { "CC", "CC", 'C', new ItemStack(FronosItems.jelly, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.jelly_block, 1, 1), new Object[] { "CC", "CC", 'C', new ItemStack(FronosItems.jelly, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.jelly_block, 1, 2), new Object[] { "CC", "CC", 'C', new ItemStack(FronosItems.jelly, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.jelly_block, 1, 3), new Object[] { "CC", "CC", 'C', new ItemStack(FronosItems.jelly, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.jelly_block, 1, 4), new Object[] { "CC", "CC", 'C', new ItemStack(FronosItems.jelly, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.jelly_block, 1, 5), new Object[] { "CC", "CC", 'C', new ItemStack(FronosItems.jelly, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.jelly_block, 1, 6), new Object[] { "CC", "CC", 'C', new ItemStack(FronosItems.jelly, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.jelly_block, 1, 7), new Object[] { "CC", "CC", 'C', new ItemStack(FronosItems.jelly, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.fronos_fence, 3, 0), new Object[] { "CSC", "CSC", 'S', new ItemStack(Items.stick), 'C', new ItemStack(FronosBlocks.fronos_planks, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.fronos_fence, 3, 1), new Object[] { "RSR", "RSR", 'S', new ItemStack(Items.stick), 'R', new ItemStack(FronosBlocks.fronos_planks, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.coconut_fence_gate), new Object[] { "SAS", "SAS", 'A', new ItemStack(FronosBlocks.fronos_planks, 1, 0), 'S', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.maple_fence_gate), new Object[] { "SOS", "SOS", 'O', new ItemStack(FronosBlocks.fronos_planks, 1, 1), 'S', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.fronos_block, 1, 13), new Object[] { "S", "S", 'S', new ItemStack(MPBlocks.half_stone_slab_2, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.cheese_glass_pane, 16), new Object[] { "CCC", "CCC", 'C', new ItemStack(FronosBlocks.cheese_glass) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.ore_block, 1, 0), new Object[] { "III", "III", "III", 'I', new ItemStack(FronosItems.fronos_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.ore_block, 1, 1), new Object[] { "DDD", "DDD", "DDD", 'D', new ItemStack(FronosItems.fronos_item, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.caramel_block), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(FronosItems.candy_food, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.fronos_dirt, 4, 1), new Object[] { "DG", "GD", 'D', new ItemStack(FronosBlocks.fronos_dirt, 1, 0), 'G', new ItemStack(Blocks.gravel) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.fronos_sandstone, 4, 0), new Object[] { "SS", "SS", 'S', new ItemStack(FronosBlocks.fronos_sand, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.fronos_sandstone, 4, 3), new Object[] { "SS", "SS", 'S', new ItemStack(FronosBlocks.fronos_sand, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.fronos_sandstone, 4, 6), new Object[] { "SS", "SS", 'S', new ItemStack(FronosBlocks.fronos_sand, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.fronos_sandstone, 4, 2), new Object[] { "SS", "SS", 'S', new ItemStack(FronosBlocks.fronos_sandstone, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.fronos_sandstone, 4, 5), new Object[] { "SS", "SS", 'S', new ItemStack(FronosBlocks.fronos_sandstone, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.fronos_sandstone, 4, 8), new Object[] { "SS", "SS", 'S', new ItemStack(FronosBlocks.fronos_sandstone, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.fronos_sandstone, 1, 1), new Object[] { "S", "S", 'S', new ItemStack(FronosBlocks.half_fronos_sandstone_slab, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.fronos_sandstone, 1, 4), new Object[] { "S", "S", 'S', new ItemStack(FronosBlocks.half_fronos_sandstone_slab, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.fronos_sandstone, 1, 7), new Object[] { "S", "S", 'S', new ItemStack(FronosBlocks.half_fronos_sandstone_slab, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 9), new Object[] { "NNN", "NNN", "NNN", 'N', new ItemStack(KapteynBItems.namerium_crystal) });
		GameRegistry.addRecipe(new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 10), new Object[] { "III", "III", "III", 'I', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 11), new Object[] { "UUU", "UUU", "UUU", 'U', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(KapteynBBlocks.uranium_bomb), new Object[] { "GUG", "UGU", "GUG", 'U', new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 11), 'G', new ItemStack(Items.gunpowder) });
		GameRegistry.addRecipe(new ItemStack(SiriusBBlocks.sirius_b_block, 1, 8), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(SiriusBItems.sirius_b_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(SiriusBBlocks.sirius_glowstone), new Object[] { "GG", "GG", 'G', new ItemStack(SiriusBItems.sirius_glowstone_dust) });
		GameRegistry.addRecipe(new ItemStack(SiriusBBlocks.sirius_redstone_lamp_off), new Object[] { " R ", "RGR", " R ", 'G', new ItemStack(SiriusBBlocks.sirius_glowstone), 'R', new ItemStack(Items.redstone) });
		GameRegistry.addRecipe(new ItemStack(MercuryBlocks.mercury_block, 1, 10), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MercuryItems.mercury_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.chondrite_rock, 4, 1), new Object[] { "CC", "CC", 'C', new ItemStack(MPBlocks.chondrite_rock, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(VenusBlocks.sulfur_torch, 4), new Object[] { "D", "S", 'D', new ItemStack(SiriusBItems.sirius_b_item, 1, 2), 'S', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(VenusBlocks.venus_block, 4, 12), new Object[] { "SS", "SS", 'S', new ItemStack(VenusBlocks.venus_block, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(VenusBlocks.venus_block, 1, 11), new Object[] { "AAA", "AAA", "AAA" ,'A', new ItemStack(VenusItems.venus_item, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(Blocks.tnt), new Object[] { "GSG", "SGS", "GSG" ,'G', new ItemStack(Items.gunpowder), 'S', new ItemStack(VenusBlocks.venus_sand) });
		GameRegistry.addRecipe(new ItemStack(VenusBlocks.venus_sandstone, 4, 0), new Object[] { "SS", "SS", 'S', new ItemStack(VenusBlocks.venus_sand) });
		GameRegistry.addRecipe(new ItemStack(VenusBlocks.venus_sandstone, 1, 1), new Object[] { "S", "S", 'S', new ItemStack(VenusBlocks.half_venus_sandstone_slab) });
		GameRegistry.addRecipe(new ItemStack(VenusBlocks.venus_sandstone, 4, 2), new Object[] { "SS", "SS", 'S', new ItemStack(VenusBlocks.venus_sandstone, 4, 0) });
		GameRegistry.addRecipe(new ItemStack(VenusBlocks.half_venus_sandstone_slab, 6), new Object[] { "SSS", 'S', VenusBlocks.venus_sandstone });
		GameRegistry.addRecipe(new ItemStack(PlutoBlocks.xeonium_torch, 4), new Object[] { "X", "S", 'X', new ItemStack(PlutoItems.pluto_item, 1, 0), 'S', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(PlutoBlocks.xeonium_glowstone), new Object[] { "DD", "DD", 'D', new ItemStack(PlutoItems.xeonium_dust) });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.europa_fence, 3), new Object[] { "CSC", "CSC", 'S', new ItemStack(Items.stick), 'C', new ItemStack(EuropaBlocks.europa_planks) });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.europa_fence_gate), new Object[] { "SAS", "SAS", 'A', new ItemStack(EuropaBlocks.europa_planks), 'S', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.europa_snow_layer, 6), new Object[] { "SSS", 'S', new ItemStack(EuropaBlocks.europa_snow_block) });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.europa_sandstone, 4, 0), new Object[] { "SS", "SS", 'S', new ItemStack(EuropaBlocks.europa_sand) });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.europa_sandstone, 1, 1), new Object[] { "S", "S", 'S', new ItemStack(EuropaBlocks.half_europa_sandstone_slab) });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.europa_sandstone, 4, 2), new Object[] { "SS", "SS", 'S', new ItemStack(EuropaBlocks.europa_sandstone, 4, 0) });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.europa_prismarine, 4, 0), new Object[] { "SS", "SS", 'S', new ItemStack(EuropaItems.europa_prismarine, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.europa_prismarine, 1, 1), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(EuropaItems.europa_prismarine, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.europa_prismarine, 1, 2), new Object[] { "SSS", "SIS", "SSS", 'S', new ItemStack(EuropaItems.europa_prismarine, 1, 0), 'I', new ItemStack(Items.dye, 1, EnumDyeColor.BLACK.getDyeDamage()) });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.europa_sea_lantern), new Object[] { "PSP", "SSS", "PSP", 'P', new ItemStack(EuropaItems.europa_prismarine, 1, 0), 'S', new ItemStack(EuropaItems.europa_prismarine, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.europa_water_bomb), new Object[] { "GSG", "SGS", "GSG", 'S', new ItemStack(EuropaBlocks.europa_sand), 'G', new ItemStack(EuropaItems.europa_gunpowder) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.tinted_glass, 8, 0), new Object[] {"III", "IDI", "III", 'I', new ItemStack(Blocks.glass), 'D', new ItemStack(MarsItems.marsItemBasic, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(MPBlocks.polished_space_decoration, 4, 0), new Object[] { "TT", "TT", 'T', new ItemStack(GCBlocks.basicBlock, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.polished_space_decoration, 8, 1), new Object[] { "TTT", "TAT", "TTT", 'T', new ItemStack(MPBlocks.polished_space_decoration, 1, 0), 'A', new ItemStack(GCItems.basicItem, 1, 8) });
		GameRegistry.addShapelessRecipe(new ItemStack(NibiruBlocks.nibiru_planks, 4, 0), new ItemStack(NibiruBlocks.nibiru_log, 1, 0) );
		GameRegistry.addShapelessRecipe(new ItemStack(NibiruBlocks.nibiru_planks, 4, 1), new ItemStack(NibiruBlocks.nibiru_log, 1, 1) );
		GameRegistry.addShapelessRecipe(new ItemStack(KoentusBlocks.crystal_planks, 4), new ItemStack(KoentusBlocks.crystal_log) );
		GameRegistry.addShapelessRecipe(new ItemStack(FronosBlocks.fronos_planks, 4, 0), new ItemStack(FronosBlocks.fronos_log, 1, 0) );
		GameRegistry.addShapelessRecipe(new ItemStack(FronosBlocks.fronos_planks, 4, 1), new ItemStack(FronosBlocks.fronos_log, 1, 1) );
		GameRegistry.addShapelessRecipe(new ItemStack(FronosBlocks.golem_cream_head, 2, 0), new ItemStack(FronosBlocks.cream_block, 1, 0) );
		GameRegistry.addShapelessRecipe(new ItemStack(FronosBlocks.golem_cream_head, 2, 1), new ItemStack(FronosBlocks.cream_block, 1, 1) );
		GameRegistry.addShapelessRecipe(new ItemStack(FronosBlocks.golem_cream_head, 2, 2), new ItemStack(FronosBlocks.cream_block, 1, 2) );
		GameRegistry.addShapelessRecipe(new ItemStack(FronosBlocks.golem_cream_head, 2, 3), new ItemStack(FronosBlocks.cream_block, 1, 3) );
		GameRegistry.addShapelessRecipe(new ItemStack(FronosBlocks.golem_cream_head, 2, 4), new ItemStack(FronosBlocks.cream_block, 1, 4) );
		GameRegistry.addShapelessRecipe(new ItemStack(FronosBlocks.golem_cream_head, 2, 5), new ItemStack(FronosBlocks.cream_block, 1, 5) );
		GameRegistry.addShapelessRecipe(new ItemStack(FronosBlocks.mossy_fronos_cobblestone), new ItemStack(FronosBlocks.fronos_block, 1, 1), new ItemStack(Blocks.vine) );
		GameRegistry.addShapelessRecipe(new ItemStack(EuropaBlocks.europa_planks, 4), new ItemStack(EuropaBlocks.europa_log) );
		RecipeUtil.addRecipe(new ItemStack(FronosBlocks.half_fronos_sandstone_slab, 6, 0), new Object[] { "SSS", 'S', "fronosSandstone" });
		RecipeUtil.addRecipe(new ItemStack(FronosBlocks.half_fronos_sandstone_slab, 6, 1), new Object[] { "SSS", 'S', "whiteSandstone" });
		RecipeUtil.addRecipe(new ItemStack(FronosBlocks.half_fronos_sandstone_slab, 6, 2), new Object[] { "SSS", 'S', "cheeseSandstone" });

		for (int i = 0; i < 16; ++i)
		{
			GameRegistry.addRecipe(new ItemStack(KoentusBlocks.glowing_ice_stone, 8, 15 - i), new Object[] {"III", "IDI", "III", 'I', new ItemStack(KoentusBlocks.koentus_ice, 1, 1), 'D', new ItemStack(Items.dye, 1, i)});

			if (i != 15)
			{
				GameRegistry.addRecipe(new ItemStack(MPBlocks.tinted_glass, 8, 15 - i), new Object[] {"III", "IDI", "III", 'I', new ItemStack(MPBlocks.tinted_glass, 1, 0), 'D', new ItemStack(Items.dye, 1, i)});
			}
			GameRegistry.addRecipe(new ItemStack(MPBlocks.tinted_glass_pane, 16, i), new Object[] {"GGG", "GGG", 'G', new ItemStack(MPBlocks.tinted_glass, 1, i)});
		}

		// Items
		GameRegistry.addRecipe(new ItemStack(DionaItems.diona_item, 1, 8), new Object[] { "RRR", "WWW", "BBB", 'R', new ItemStack(DionaItems.diona_item, 1, 5), 'W', new ItemStack(DionaItems.diona_item, 1, 6), 'B', new ItemStack(DionaItems.diona_item, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.diona_item, 1, 9), new Object[] { "BBB", "WWW", "RRR", 'R', new ItemStack(DionaItems.diona_item, 1, 5), 'W', new ItemStack(DionaItems.diona_item, 1, 6), 'B', new ItemStack(DionaItems.diona_item, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.diona_item, 2, 5), new Object[] { "Q", "Q", 'Q', new ItemStack(DionaItems.diona_item, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.diona_item, 2, 6), new Object[] { "F", "F", 'F', new ItemStack(DionaItems.diona_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.tier_4_rocket_module, 1, 3), new Object[] { "DMD", "DCD", "TAT", 'M', new ItemStack(Blocks.diamond_block), 'D', new ItemStack(AsteroidsItems.basicItem, 1, 6), 'C', new ItemStack(GCItems.fuelCanister, 1, 1), 'T', new ItemStack(DionaItems.tier_4_rocket_module, 1, 1), 'A', new ItemStack(GCItems.oxygenVent) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.tier_4_rocket_module, 1, 2), new Object[] { "BS ", "TCT", "TAT", 'B', new ItemStack(Blocks.stone_button), 'S', new ItemStack(Items.flint_and_steel), 'T', new ItemStack(DionaItems.tier_4_rocket_module, 1, 1), 'A', new ItemStack(GCItems.oxygenVent), 'C', new ItemStack(GCItems.canister, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.tier_4_rocket_module, 1, 2), new Object[] { " SB", "TCT", "TAT", 'B', new ItemStack(Blocks.stone_button), 'S', new ItemStack(Items.flint_and_steel), 'T', new ItemStack(DionaItems.tier_4_rocket_module, 1, 1), 'A', new ItemStack(GCItems.oxygenVent), 'C', new ItemStack(GCItems.canister, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.tier_4_rocket_module, 1, 4), new Object[] { " T ", " D ", "D D", 'T', new ItemStack(DionaItems.diona_item, 1, 12), 'D', new ItemStack(DionaItems.tier_4_rocket_module, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.laser_ammo, 8, 0), new Object[] { " R", "I ", 'I', new ItemStack(Items.iron_ingot), 'R', new ItemStack(Items.redstone) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.laser_ammo, 8, 1), new Object[] { " P", "I ", 'I', new ItemStack(Items.iron_ingot), 'P', new ItemStack(PolongniusItems.polongnius_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.laser_ammo, 8, 2), new Object[] { " E", "I ", 'I', new ItemStack(Items.iron_ingot), 'E', new ItemStack(KoentusItems.koentus_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.laser_ammo, 12, 3), new Object[] { " U", "I ", 'I', new ItemStack(Items.iron_ingot), 'U', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.laser_gun), new Object[] { "C  ", " DT", "  D", 'C', new ItemStack(AsteroidsItems.basicItem, 1, 8), 'D', new ItemStack(MarsItems.marsItemBasic, 1, 5), 'T', new ItemStack(AsteroidsItems.basicItem, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.diona_item, 1, 7), new Object[] { "G", "T", 'T', new ItemStack(Blocks.redstone_torch), 'G', new ItemStack(Items.dye, 1, 10) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.tier_4_rocket_module, 1, 5), new Object[] { "BS ", "TCT", "TAT", 'B', new ItemStack(Blocks.stone_button), 'S', new ItemStack(Items.flint_and_steel), 'T', new ItemStack(DionaItems.diona_item, 1, 4), 'A', new ItemStack(GCItems.oxygenVent), 'C', new ItemStack(GCItems.canister, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.tier_4_rocket_module, 1, 5), new Object[] { " SB", "TCT", "TAT", 'B', new ItemStack(Blocks.stone_button), 'S', new ItemStack(Items.flint_and_steel), 'T', new ItemStack(DionaItems.diona_item, 1, 4), 'A', new ItemStack(GCItems.oxygenVent), 'C', new ItemStack(GCItems.canister, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.tier_4_rocket_module, 1, 6), new Object[] { "DMD", "DCD", "TAT", 'M', new ItemStack(DionaBlocks.diona_block, 1, 10), 'D', new ItemStack(DionaItems.diona_item, 1, 2), 'C', new ItemStack(GCItems.fuelCanister, 1, 1), 'T', new ItemStack(DionaItems.diona_item, 1, 4), 'A', new ItemStack(GCItems.oxygenVent) });
		GameRegistry.addRecipe(new ItemStack(PolongniusItems.polongnius_item, 2, 8), new Object[] { "M", "M", 'M', new ItemStack(PolongniusItems.polongnius_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(PolongniusItems.polongnius_item, 2, 9), new Object[] { "P", "P", 'P', new ItemStack(PolongniusItems.polongnius_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(PolongniusItems.purple_crystal_solar_module, 2, 2), new Object[] { "GGG", "WWW", "AAA", 'G', new ItemStack(Blocks.glass), 'W', new ItemStack(PolongniusItems.purple_crystal_solar_module, 1, 1), 'A', new ItemStack(GCBlocks.aluminumWire, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(PolongniusItems.purple_crystal_solar_module, 1, 3), new Object[] { "SSS", "AAA", "SSS", 'S', new ItemStack(PolongniusItems.purple_crystal_solar_module, 1, 2), 'A', new ItemStack(GCBlocks.aluminumWire, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 0), new Object[] { " SB", "TCT", "TAT", 'B', new ItemStack(Blocks.stone_button), 'S', new ItemStack(Items.flint_and_steel), 'T', new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 2), 'A', new ItemStack(GCItems.oxygenVent), 'C', new ItemStack(GCItems.canister, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 0), new Object[] { "BS ", "TCT", "TAT", 'B', new ItemStack(Blocks.stone_button), 'S', new ItemStack(Items.flint_and_steel), 'T', new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 2), 'A', new ItemStack(GCItems.oxygenVent), 'C', new ItemStack(GCItems.canister, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 1), new Object[] { "DQD", "DCD", "POP", 'Q', new ItemStack(PolongniusBlocks.polongnius_block, 1, 11), 'P', new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 2), 'C', new ItemStack(GCItems.fuelCanister, 1, 1), 'D', new ItemStack(PolongniusItems.polongnius_item, 1, 7), 'O', new ItemStack(GCItems.oxygenVent) });
		GameRegistry.addRecipe(new ItemStack(NibiruItems.nibiru_item, 2, 4), new Object[] { "M", "M", 'M', new ItemStack(NibiruItems.nibiru_item, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(NibiruItems.nibiru_item, 2, 5), new Object[] { "P", "P", 'P', new ItemStack(NibiruItems.nibiru_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(NibiruItems.space_fruits, 1, 2), new Object[] { "O", "B", 'O', new ItemStack(NibiruItems.space_fruits, 1, 1), 'B', new ItemStack(Items.potionitem, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 0), new Object[] { " SB", "TCT", "TAT", 'B', new ItemStack(Blocks.stone_button), 'S', new ItemStack(Items.flint_and_steel), 'T', new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2), 'A', new ItemStack(GCItems.oxygenVent), 'C', new ItemStack(GCItems.canister, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 0), new Object[] { "BS ", "TCT", "TAT", 'B', new ItemStack(Blocks.stone_button), 'S', new ItemStack(Items.flint_and_steel), 'T', new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2), 'A', new ItemStack(GCItems.oxygenVent), 'C', new ItemStack(GCItems.canister, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 1), new Object[] { "PDP", "PCP", "NON", 'D', new ItemStack(NibiruBlocks.nibiru_block, 1, 10), 'P', new ItemStack(NibiruItems.nibiru_item, 1, 2), 'C', new ItemStack(GCItems.fuelCanister, 1, 1), 'N', new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2), 'O', new ItemStack(GCItems.oxygenVent) });
		GameRegistry.addRecipe(new ItemStack(NibiruItems.ancient_dark_door, 3), new Object[] { "AA", "AA", "AA", 'A', new ItemStack(NibiruBlocks.nibiru_planks, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(NibiruItems.orange_door, 3), new Object[] { "OO", "OO", "OO", 'O', new ItemStack(NibiruBlocks.nibiru_planks, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 4), new Object[] { " Y ", " X ", "X X", 'X', new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2), 'Y', new ItemStack(DionaItems.diona_item, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(NibiruItems.tier_7_rocket_module, 1, 3), new Object[] { " Y ", "XYX", "X X", 'X', new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2), 'Y', new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(KoentusItems.crystal_door, 3), new Object[] { "CC ", "CC ", "CC ", 'C', new ItemStack(KoentusBlocks.crystal_planks) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.bearry_egg), new Object[] { "S", "E", 'S', new ItemStack(FronosItems.fronos_food, 1, 0), 'E', new ItemStack(Items.egg) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.fronos_food, 1, 4), new Object[] { "V", "B", 'V', new ItemStack(FronosItems.cream_ball, 1, 0), 'B', new ItemStack(Items.bowl) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.fronos_food, 1, 5), new Object[] { "C", "B", 'C', new ItemStack(FronosItems.cream_ball, 1, 1), 'B', new ItemStack(Items.bowl) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.fronos_food, 1, 6), new Object[] { "S", "B", 'S', new ItemStack(FronosItems.cream_ball, 1, 2), 'B', new ItemStack(Items.bowl) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.fronos_food, 1, 7), new Object[] { "S", "B", 'S', new ItemStack(FronosBlocks.cloud_block), 'B', new ItemStack(Items.bowl) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.fronos_food, 1, 8), new Object[] { "O", "B", 'O', new ItemStack(FronosItems.cream_ball, 1, 3), 'B', new ItemStack(Items.bowl) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.fronos_food, 1, 9), new Object[] { "WWW", 'W', new ItemStack(FronosItems.fronos_item, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.fronos_food, 1, 11), new Object[] { "T", "B", 'T', new ItemStack(FronosItems.cream_ball, 1, 4), 'B', new ItemStack(Items.bowl) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.fronos_food, 1, 15), new Object[] { "L", "B", 'L', new ItemStack(FronosItems.cream_ball, 1, 5), 'B', new ItemStack(Items.bowl) });
		GameRegistry.addRecipe(new ItemStack(Items.cookie, 4), new Object[] { "C", 'C', new ItemStack(FronosBlocks.cookie_block) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.cup, 4), new Object[] { "C C", "CWC", "CCC", 'C', new ItemStack(Blocks.stained_hardened_clay, 1, 0), 'W', new ItemStack(Items.dye, 1, EnumDyeColor.WHITE.getDyeDamage()) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.cream_golem, 1, 0), new Object[] { "H", "C", "C", 'H', new ItemStack(FronosBlocks.golem_cream_head, 1, 0), 'C', new ItemStack(FronosBlocks.cream_block, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.cream_golem, 1, 1), new Object[] { "H", "C", "C", 'H', new ItemStack(FronosBlocks.golem_cream_head, 1, 1), 'C', new ItemStack(FronosBlocks.cream_block, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.cream_golem, 1, 2), new Object[] { "H", "C", "C", 'H', new ItemStack(FronosBlocks.golem_cream_head, 1, 2), 'C', new ItemStack(FronosBlocks.cream_block, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.cream_golem, 1, 3), new Object[] { "H", "C", "C", 'H', new ItemStack(FronosBlocks.golem_cream_head, 1, 3), 'C', new ItemStack(FronosBlocks.cream_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.cream_golem, 1, 4), new Object[] { "H", "C", "C", 'H', new ItemStack(FronosBlocks.golem_cream_head, 1, 4), 'C', new ItemStack(FronosBlocks.cream_block, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.cream_golem, 1, 5), new Object[] { "H", "C", "C", 'H', new ItemStack(FronosBlocks.golem_cream_head, 1, 5), 'C', new ItemStack(FronosBlocks.cream_block, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.coconut_door, 3), new Object[] { "CC", "CC", "CC", 'C', new ItemStack(FronosBlocks.fronos_planks, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.maple_door, 3), new Object[] { "MM", "MM", "MM", 'M', new ItemStack(FronosBlocks.fronos_planks, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.fruits_juice, 1, 0), new Object[] { "S", "W", 'S', new ItemStack(FronosItems.fronos_food, 1, 0), 'W', new ItemStack(Items.potionitem, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.fruits_juice, 1, 1), new Object[] { "B", "W", 'B', new ItemStack(FronosItems.fronos_food, 1, 1), 'W', new ItemStack(Items.potionitem, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.fruits_juice, 1, 2), new Object[] { "K", "W", 'K', new ItemStack(FronosItems.fronos_fruits, 1, 0), 'W', new ItemStack(Items.potionitem, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.fruits_juice, 1, 3), new Object[] { "L", "W", 'L', new ItemStack(FronosItems.fronos_fruits, 1, 1), 'W', new ItemStack(Items.potionitem, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.tier_8_rocket_module, 1, 0), new Object[] { " SB", "TCT", "TAT", 'B', new ItemStack(Blocks.stone_button), 'S', new ItemStack(Items.flint_and_steel), 'T', new ItemStack(FronosItems.tier_8_rocket_module, 1, 2), 'A', new ItemStack(GCItems.oxygenVent), 'C', new ItemStack(GCItems.canister, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.tier_8_rocket_module, 1, 0), new Object[] { "BS ", "TCT", "TAT", 'B', new ItemStack(Blocks.stone_button), 'S', new ItemStack(Items.flint_and_steel), 'T', new ItemStack(FronosItems.tier_8_rocket_module, 1, 2), 'A', new ItemStack(GCItems.oxygenVent), 'C', new ItemStack(GCItems.canister, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.tier_8_rocket_module, 1, 1), new Object[] { "PDP", "PCP", "NON", 'D', new ItemStack(FronosBlocks.ore_block, 1, 0), 'P', new ItemStack(FronosItems.fronos_item, 1, 4), 'C', new ItemStack(GCItems.fuelCanister, 1, 1), 'N', new ItemStack(FronosItems.tier_8_rocket_module, 1, 2), 'O', new ItemStack(GCItems.oxygenVent) });
		GameRegistry.addRecipe(new ItemStack(FronosItems.fronos_food, 1, 14), new Object[] { "R", "B", 'R', new ItemStack(FronosBlocks.cloud_block, 1, 1), 'B', new ItemStack(Items.bowl) });
		GameRegistry.addRecipe(new ItemStack(KapteynBItems.uranium_battery, 1, 99), new Object[] { " I ", "IUI", "IGI", 'I', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 2), 'U', new ItemStack(Items.redstone), 'G', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(KapteynBItems.kapteyn_b_item, 2, 4), new Object[] { "I", "I", 'I', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(KapteynBItems.kapteyn_b_item, 2, 3), new Object[] { "U", "U", 'U', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(SiriusBItems.sirius_b_item, 1, 1), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(SiriusBItems.sirius_b_item, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(Items.diamond), new Object[] { "LLL", "LLL", "LLL", 'L', new ItemStack(SiriusBItems.sirius_b_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(SiriusBItems.sirius_b_item, 2, 5), new Object[] { "S", "S", 'S', new ItemStack(SiriusBItems.sirius_b_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(VenusItems.sulfur_battery, 1, 99), new Object[] { " I ", "IUI", "IGI", 'I', new ItemStack(GCItems.basicItem, 1, 7), 'U', new ItemStack(Items.redstone), 'G', new ItemStack(SiriusBItems.sirius_b_item, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(MercuryItems.mercury_item, 1, 7), new Object[] { "MCM", "CAC", "MCM", 'M', new ItemStack(MercuryItems.mercury_item, 1, 5), 'C', new ItemStack(MercuryItems.mercury_item, 1, 6), 'A', new ItemStack(GCItems.basicItem, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(MercuryItems.mercury_item, 1, 6), new Object[] { "PRP", "RDR", "PRP", 'P', new ItemStack(MercuryItems.mercury_item, 1, 4), 'R', new ItemStack(Items.redstone), 'D', new ItemStack(Items.diamond) });
		GameRegistry.addRecipe(new ItemStack(MercuryItems.mercury_item, 1, 6), new Object[] { "PRP", "RDR", "PRP", 'P', new ItemStack(MercuryItems.mercury_item, 1, 5), 'R', new ItemStack(Items.redstone), 'D', new ItemStack(Items.diamond) });
		GameRegistry.addRecipe(new ItemStack(PlutoItems.gravity_boots), new Object[] { "P P", "G G", 'P', new ItemStack(MercuryItems.mercury_item, 1, 4), 'G', new ItemStack(MercuryItems.mercury_item, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(PlutoItems.gravity_boots), new Object[] { "P P", "G G", 'P', new ItemStack(MercuryItems.mercury_item, 1, 5), 'G', new ItemStack(MercuryItems.mercury_item, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.laser_ammo, 8, 4), new Object[] { " E", "I ", 'I', new ItemStack(Items.iron_ingot), 'E', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(EuropaItems.europa_door, 3), new Object[] { "EE", "EE", "EE", 'E', new ItemStack(EuropaBlocks.europa_planks) });
		GameRegistry.addRecipe(new ItemStack(MPItems.tier_2_thermal_padding, 1, 0), new Object[] { "XXX", "X X", 'X', new ItemStack(MPItems.desh_thermal_cloth) });
		GameRegistry.addRecipe(new ItemStack(MPItems.tier_2_thermal_padding, 1, 1), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(MPItems.desh_thermal_cloth) });
		GameRegistry.addRecipe(new ItemStack(MPItems.tier_2_thermal_padding, 1, 2), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(MPItems.desh_thermal_cloth) });
		GameRegistry.addRecipe(new ItemStack(MPItems.tier_2_thermal_padding, 1, 3), new Object[] { "X X", "X X", 'X', new ItemStack(MPItems.desh_thermal_cloth) });
		GameRegistry.addRecipe(new ItemStack(MPItems.desh_thermal_cloth), new Object[] { " X ", "XRX", " X ", 'X', new ItemStack(MarsItems.marsItemBasic, 1, 5), 'R', Items.redstone });
		GameRegistry.addShapelessRecipe(new ItemStack(DionaItems.diona_item, 9, 0), new ItemStack(DionaBlocks.diona_block, 1, 10) );
		GameRegistry.addShapelessRecipe(new ItemStack(DionaItems.diona_item, 9, 1), new ItemStack(DionaBlocks.diona_block, 1, 11) );
		GameRegistry.addShapelessRecipe(new ItemStack(PolongniusItems.polongnius_meteor_chunk, 3), new ItemStack(PolongniusItems.polongnius_item, 1, 2) );
		GameRegistry.addShapelessRecipe(new ItemStack(PolongniusItems.polongnius_item, 9, 4), new ItemStack(PolongniusBlocks.polongnius_block, 1, 11) );
		GameRegistry.addShapelessRecipe(new ItemStack(PolongniusItems.polongnius_item, 9, 1), new ItemStack(PolongniusBlocks.polongnius_block, 1, 12) );
		GameRegistry.addShapelessRecipe(new ItemStack(PolongniusItems.polongnius_item, 9, 5), new ItemStack(PolongniusBlocks.polongnius_block, 1, 13) );
		GameRegistry.addShapelessRecipe(new ItemStack(PolongniusItems.cheese_slimeball, 9), new ItemStack(PolongniusBlocks.cheese_slime_block) );
		GameRegistry.addShapelessRecipe(new ItemStack(NibiruItems.power_crystal, 9), new ItemStack(NibiruBlocks.nibiru_block, 1, 9) );
		GameRegistry.addShapelessRecipe(new ItemStack(NibiruItems.nibiru_item, 9, 1), new ItemStack(NibiruBlocks.nibiru_block, 1, 10) );
		GameRegistry.addShapelessRecipe(new ItemStack(NibiruItems.nibiru_item, 9, 0), new ItemStack(NibiruBlocks.nibiru_block, 1, 11) );
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, EnumDyeColor.ORANGE.getDyeDamage()), new ItemStack(NibiruBlocks.infected_orange_rose_bush));
		GameRegistry.addShapelessRecipe(new ItemStack(KoentusItems.koentus_item, 9, 0), new ItemStack(KoentusBlocks.koentus_block, 1, 9) );
		GameRegistry.addShapelessRecipe(new ItemStack(KoentusItems.koentus_item, 9, 1), new ItemStack(KoentusBlocks.koentus_block, 1, 10) );
		GameRegistry.addShapelessRecipe(new ItemStack(KoentusItems.koentus_item, 9, 4), new ItemStack(KoentusBlocks.koentus_block, 1, 12) );
		GameRegistry.addShapelessRecipe(new ItemStack(KoentusItems.koentus_meteor_chunk, 3), new ItemStack(KoentusItems.koentus_item, 1, 3) );
		GameRegistry.addShapelessRecipe(new ItemStack(FronosItems.strawberry_seed), new ItemStack(FronosItems.fronos_food, 1, 0) );
		GameRegistry.addShapelessRecipe(new ItemStack(FronosItems.fronos_item, 4, 7), new ItemStack(FronosBlocks.fronos_block, 1, 1) );
		GameRegistry.addShapelessRecipe(new ItemStack(FronosItems.fronos_item, 2, 1), new ItemStack(FronosItems.fronos_item, 1, 0) );
		GameRegistry.addShapelessRecipe(new ItemStack(FronosItems.fronos_food, 1, 12), new ItemStack(FronosItems.fronos_food, 1, 0), new ItemStack(FronosItems.fronos_food, 1, 1), new ItemStack(Items.bowl));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 14), new ItemStack(FronosBlocks.fronos_dandelion, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 9), new ItemStack(FronosBlocks.fronos_dandelion, 1, 4));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 5), new ItemStack(FronosBlocks.fronos_dandelion, 1, 5));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 9), new ItemStack(FronosBlocks.fronos_flower, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 14), new ItemStack(FronosBlocks.fronos_flower, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 11), new ItemStack(FronosBlocks.fronos_flower, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(FronosItems.fronos_food, 2, 10), new ItemStack(FronosBlocks.fronos_flower, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 12), new ItemStack(FronosBlocks.fronos_flower, 1, 4));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 5), new ItemStack(FronosBlocks.fronos_flower, 1, 5));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 7), new ItemStack(FronosBlocks.fronos_poppy, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 14), new ItemStack(FronosBlocks.fronos_poppy, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 5), new ItemStack(FronosBlocks.fronos_poppy, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(FronosItems.candy_food, 9, 2), new ItemStack(FronosBlocks.caramel_block));
		GameRegistry.addShapelessRecipe(new ItemStack(FronosItems.fronos_item, 9, 2), new ItemStack(FronosBlocks.ore_block, 1, 1) );
		GameRegistry.addShapelessRecipe(new ItemStack(FronosItems.fronos_item, 9, 3), new ItemStack(FronosBlocks.ore_block, 1, 0) );
		GameRegistry.addShapelessRecipe(new ItemStack(FronosItems.fronos_food, 1, 13), new ItemStack(FronosBlocks.fronos_flower, 1, 4), new ItemStack(Items.bowl), new ItemStack(Blocks.brown_mushroom) );
		GameRegistry.addShapelessRecipe(new ItemStack(KapteynBItems.namerium_crystal, 9), new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 9) );
		GameRegistry.addShapelessRecipe(new ItemStack(KapteynBItems.kapteyn_b_item, 9, 0), new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 10) );
		GameRegistry.addShapelessRecipe(new ItemStack(KapteynBItems.kapteyn_b_item, 9, 1), new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 11) );
		GameRegistry.addShapelessRecipe(new ItemStack(SiriusBItems.sirius_b_item, 9, 3), new ItemStack(SiriusBBlocks.sirius_b_block, 1, 8) );
		GameRegistry.addShapelessRecipe(new ItemStack(VenusItems.venus_item, 9, 0), new ItemStack(VenusBlocks.venus_block, 1, 11) );
		GameRegistry.addShapelessRecipe(new ItemStack(PlutoItems.xeonium_dust, 4), new ItemStack(PlutoItems.pluto_item, 1, 0) );

		for (int i = 0; i < 8; ++i)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(FronosItems.candy_cane, 1, i), new ItemStack(FronosBlocks.candy_flower, 1, i) );
		}

		// Block smelting
		GameRegistry.addSmelting(new ItemStack(DionaBlocks.diona_block, 1, 3), new ItemStack(DionaBlocks.diona_block, 1, 2), 0.4F);
		GameRegistry.addSmelting(new ItemStack(PolongniusBlocks.polongnius_block, 1, 3), new ItemStack(PolongniusBlocks.polongnius_block, 1, 2), 0.4F);
		GameRegistry.addSmelting(new ItemStack(PolongniusBlocks.polongnius_block, 1, 14), new ItemStack(PolongniusBlocks.polongnius_block, 1, 15), 0.3F);
		GameRegistry.addSmelting(new ItemStack(NibiruBlocks.nibiru_block, 1, 3), new ItemStack(NibiruBlocks.nibiru_block, 1, 2), 0.4F);
		GameRegistry.addSmelting(new ItemStack(KoentusBlocks.koentus_block, 1, 3), new ItemStack(KoentusBlocks.koentus_block, 1, 2), 0.5F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.fronos_block, 1, 1), new ItemStack(FronosBlocks.fronos_block, 1, 0), 0.4F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.fronos_sand, 1, 0), new ItemStack(Blocks.stained_glass, 1, 3), 0.45F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.fronos_sand, 1, 1), new ItemStack(Blocks.stained_glass, 1, 0), 0.45F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.fronos_sand, 1, 2), new ItemStack(FronosBlocks.cheese_glass), 0.5F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.fronos_block, 1, 11), new ItemStack(FronosBlocks.fronos_block, 1, 12), 0.45F);
		GameRegistry.addSmelting(new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 3), new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 2), 0.5F);
		GameRegistry.addSmelting(new ItemStack(SiriusBBlocks.sirius_b_block, 1, 3), new ItemStack(SiriusBBlocks.sirius_b_block, 1, 2), 0.5F);
		GameRegistry.addSmelting(new ItemStack(MercuryBlocks.mercury_block, 1, 3), new ItemStack(MercuryBlocks.mercury_block, 1, 2), 0.4F);
		GameRegistry.addSmelting(new ItemStack(VenusBlocks.venus_block, 1, 3), new ItemStack(VenusBlocks.venus_block, 1, 2), 0.4F);
		GameRegistry.addSmelting(new ItemStack(VenusBlocks.venus_block, 1, 12), new ItemStack(VenusBlocks.venus_block, 1, 13), 0.4F);
		GameRegistry.addSmelting(new ItemStack(VenusBlocks.venus_sand), new ItemStack(Blocks.glass), 0.5F);
		GameRegistry.addSmelting(new ItemStack(PlutoBlocks.pluto_block, 1, 3), new ItemStack(PlutoBlocks.pluto_block, 1, 2), 0.4F);
		GameRegistry.addSmelting(new ItemStack(PhobosBlocks.phobos_block, 1, 3), new ItemStack(PhobosBlocks.phobos_block, 1, 2), 0.5F);
		GameRegistry.addSmelting(new ItemStack(DeimosBlocks.deimos_block, 1, 3), new ItemStack(DeimosBlocks.deimos_block, 1, 2), 0.5F);
		GameRegistry.addSmelting(new ItemStack(IoBlocks.io_block, 1, 3), new ItemStack(IoBlocks.io_block, 1, 2), 0.5F);
		GameRegistry.addSmelting(new ItemStack(IoBlocks.io_block, 1, 6), new ItemStack(IoBlocks.io_block, 1, 5), 0.5F);
		GameRegistry.addSmelting(new ItemStack(EuropaBlocks.europa_sand), new ItemStack(Blocks.stained_glass, 1, 9), 0.3F);
		GameRegistry.addSmelting(new ItemStack(EuropaBlocks.europa_sponge, 1, 1), new ItemStack(EuropaBlocks.europa_sponge, 1, 0), 0.45F);

		// Item smelting
		GameRegistry.addSmelting(new ItemStack(DionaBlocks.diona_block, 1, 4), new ItemStack(DionaItems.diona_item, 1, 0), 0.8F);
		GameRegistry.addSmelting(new ItemStack(DionaBlocks.diona_block, 1, 5), new ItemStack(DionaItems.diona_item, 1, 1), 0.8F);
		GameRegistry.addSmelting(new ItemStack(DionaBlocks.diona_block, 1, 6), new ItemStack(GCItems.basicItem, 1, 4), 0.8F);
		GameRegistry.addSmelting(new ItemStack(DionaBlocks.diona_block, 1, 7), new ItemStack(GCItems.basicItem, 1, 3), 0.8F);
		GameRegistry.addSmelting(new ItemStack(DionaBlocks.diona_block, 1, 8), new ItemStack(GCItems.basicItem, 1, 2), 0.6F);
		GameRegistry.addSmelting(new ItemStack(DionaBlocks.diona_block, 1, 9), new ItemStack(GCItems.basicItem, 1, 5), 0.8F);
		GameRegistry.addSmelting(new ItemStack(PolongniusBlocks.polongnius_block, 1, 4), new ItemStack(GCItems.basicItem, 1, 3), 0.7F);
		GameRegistry.addSmelting(new ItemStack(PolongniusBlocks.polongnius_block, 1, 5), new ItemStack(GCItems.basicItem, 1, 4), 0.7F);
		GameRegistry.addSmelting(new ItemStack(PolongniusBlocks.polongnius_block, 1, 6), new ItemStack(Items.iron_ingot), 0.7F);
		GameRegistry.addSmelting(new ItemStack(PolongniusBlocks.polongnius_block, 1, 7), new ItemStack(PolongniusItems.polongnius_item, 1, 5), 0.7F);
		GameRegistry.addSmelting(new ItemStack(PolongniusBlocks.polongnius_block, 1, 8), new ItemStack(PolongniusItems.polongnius_item, 1, 0), 0.7F);
		GameRegistry.addSmelting(new ItemStack(PolongniusBlocks.polongnius_block, 1, 9), new ItemStack(PolongniusItems.polongnius_item, 1, 1), 0.6F);
		GameRegistry.addSmelting(new ItemStack(PolongniusBlocks.polongnius_block, 1, 10), new ItemStack(PolongniusItems.cheese_food, 1, 0), 0.6F);
		GameRegistry.addSmelting(new ItemStack(PolongniusItems.polongnius_item, 1, 3), new ItemStack(PolongniusItems.polongnius_item, 1, 5), 0.7F);
		GameRegistry.addSmelting(new ItemStack(PolongniusBlocks.fallen_polongnius_meteor), new ItemStack(PolongniusItems.polongnius_item, 1, 4), 0.7F);
		GameRegistry.addSmelting(new ItemStack(PolongniusItems.polongnius_item, 1, 2), new ItemStack(PolongniusItems.polongnius_item, 1, 4), 0.7F);
		GameRegistry.addSmelting(new ItemStack(PolongniusItems.cheese_food, 1, 1), new ItemStack(PolongniusItems.cheese_food, 1, 2), 0.6F);
		GameRegistry.addSmelting(new ItemStack(NibiruBlocks.nibiru_block, 1, 4), new ItemStack(NibiruItems.power_crystal), 0.8F);
		GameRegistry.addSmelting(new ItemStack(NibiruBlocks.nibiru_block, 1, 5), new ItemStack(NibiruItems.nibiru_item, 1, 1), 0.8F);
		GameRegistry.addSmelting(new ItemStack(NibiruBlocks.nibiru_block, 1, 6), new ItemStack(Items.diamond), 0.8F);
		GameRegistry.addSmelting(new ItemStack(NibiruBlocks.nibiru_block, 1, 7), new ItemStack(Items.coal), 0.65F);
		GameRegistry.addSmelting(new ItemStack(NibiruBlocks.nibiru_block, 1, 8), new ItemStack(NibiruItems.nibiru_item, 1, 0), 0.8F);
		GameRegistry.addSmelting(new ItemStack(KoentusBlocks.koentus_block, 1, 4), new ItemStack(GCItems.basicItem, 1, 4), 0.8F);
		GameRegistry.addSmelting(new ItemStack(KoentusBlocks.koentus_block, 1, 5), new ItemStack(GCItems.basicItem, 1, 3), 0.8F);
		GameRegistry.addSmelting(new ItemStack(KoentusBlocks.koentus_block, 1, 6), new ItemStack(KoentusItems.koentus_item, 1, 0), 0.8F);
		GameRegistry.addSmelting(new ItemStack(KoentusBlocks.koentus_block, 1, 7), new ItemStack(KoentusItems.koentus_item, 1, 1), 0.8F);
		GameRegistry.addSmelting(new ItemStack(KoentusBlocks.koentus_block, 1, 8), new ItemStack(KoentusItems.koentus_item, 1, 2), 0.8F);
		GameRegistry.addSmelting(new ItemStack(KoentusBlocks.fallen_koentus_meteor), new ItemStack(KoentusItems.koentus_item, 1, 4), 0.8F);
		GameRegistry.addSmelting(new ItemStack(KoentusItems.koentus_item, 1, 3), new ItemStack(KoentusItems.koentus_item, 1, 4), 0.8F);
		GameRegistry.addSmelting(new ItemStack(FronosItems.fronos_food, 1, 2), new ItemStack(FronosItems.fronos_food, 1, 3), 0.5F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.jelly_ore, 1, 0), new ItemStack(FronosItems.jelly, 1, 0), 0.4F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.jelly_ore, 1, 1), new ItemStack(FronosItems.jelly, 1, 1), 0.4F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.jelly_ore, 1, 2), new ItemStack(FronosItems.jelly, 1, 2), 0.4F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.jelly_ore, 1, 3), new ItemStack(FronosItems.jelly, 1, 3), 0.4F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.jelly_ore, 1, 4), new ItemStack(FronosItems.jelly, 1, 4), 0.4F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.jelly_ore, 1, 5), new ItemStack(FronosItems.jelly, 1, 5), 0.4F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.jelly_ore, 1, 6), new ItemStack(FronosItems.jelly, 1, 6), 0.4F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.jelly_ore, 1, 7), new ItemStack(FronosItems.jelly, 1, 7), 0.4F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.fronos_block, 1, 2), new ItemStack(Items.iron_ingot), 0.8F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.fronos_block, 1, 3), new ItemStack(Items.coal), 0.8F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.fronos_block, 1, 4), new ItemStack(GCItems.basicItem, 1, 5), 0.8F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.fronos_block, 1, 5), new ItemStack(GCItems.basicItem, 1, 4), 0.8F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.fronos_block, 1, 6), new ItemStack(GCItems.basicItem, 1, 3), 0.8F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.fronos_block, 1, 7), new ItemStack(Items.dye, 1, 4), 0.8F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.fronos_block, 1, 8), new ItemStack(FronosItems.fronos_item, 1, 0), 0.8F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.fronos_block, 1, 9), new ItemStack(FronosItems.fronos_item, 1, 2), 0.8F);
		GameRegistry.addSmelting(new ItemStack(FronosBlocks.fronos_block, 1, 10), new ItemStack(FronosItems.fronos_item, 1, 3), 0.8F);
		GameRegistry.addSmelting(new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 4), new ItemStack(KapteynBItems.namerium_crystal, 1, 0), 0.8F);
		GameRegistry.addSmelting(new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 5), new ItemStack(KapteynBItems.kapteyn_b_item, 1, 0), 0.8F);
		GameRegistry.addSmelting(new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 6), new ItemStack(KapteynBItems.kapteyn_b_item, 1, 1), 0.8F);
		GameRegistry.addSmelting(new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 7), new ItemStack(GCItems.basicItem, 1, 4), 0.8F);
		GameRegistry.addSmelting(new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 8), new ItemStack(GCItems.basicItem, 1, 3), 0.8F);
		GameRegistry.addSmelting(new ItemStack(KapteynBBlocks.kapteyn_b_redstone_ore), new ItemStack(Items.redstone), 0.8F);
		GameRegistry.addSmelting(new ItemStack(SiriusBItems.sirius_b_item, 1, 2), new ItemStack(SiriusBItems.sirius_b_item, 1, 3), 0.7F);
		GameRegistry.addSmelting(new ItemStack(SiriusBBlocks.sirius_b_block, 1, 4), new ItemStack(SiriusBItems.sirius_b_item, 1, 3), 0.7F);
		GameRegistry.addSmelting(new ItemStack(SiriusBBlocks.sirius_b_block, 1, 5), new ItemStack(Items.diamond), 0.7F);
		GameRegistry.addSmelting(new ItemStack(SiriusBBlocks.sirius_b_block, 1, 6), new ItemStack(SiriusBItems.sirius_glowstone_dust), 0.8F);
		GameRegistry.addSmelting(new ItemStack(MercuryBlocks.mercury_block, 1, 4), new ItemStack(GCItems.basicItem, 1, 4), 0.75F);
		GameRegistry.addSmelting(new ItemStack(MercuryBlocks.mercury_block, 1, 5), new ItemStack(GCItems.basicItem, 1, 3), 0.75F);
		GameRegistry.addSmelting(new ItemStack(MercuryBlocks.mercury_block, 1, 6), new ItemStack(GCItems.basicItem, 1, 5), 0.75F);
		GameRegistry.addSmelting(new ItemStack(MercuryBlocks.mercury_block, 1, 7), new ItemStack(Items.iron_ingot), 0.75F);
		GameRegistry.addSmelting(new ItemStack(MercuryBlocks.mercury_block, 1, 8), new ItemStack(MercuryItems.mercury_item, 1, 3), 0.75F);
		GameRegistry.addSmelting(new ItemStack(MercuryBlocks.metallic_rock), new ItemStack(MercuryItems.mercury_item, 1, 2), 0.75F);
		GameRegistry.addSmelting(new ItemStack(MercuryItems.mercury_item, 1, 0), new ItemStack(MercuryItems.mercury_item, 1, 2), 0.75F);
		GameRegistry.addSmelting(new ItemStack(MercuryItems.mercury_item, 1, 1), new ItemStack(MercuryItems.mercury_item, 1, 3), 0.75F);
		GameRegistry.addSmelting(new ItemStack(MPBlocks.chondrite_rock, 1, 0), new ItemStack(MPBlocks.chondrite_rock, 1, 2), 0.4F);
		GameRegistry.addSmelting(new ItemStack(VenusBlocks.venus_block, 1, 4), new ItemStack(SiriusBItems.sirius_b_item, 1, 3), 0.8F);
		GameRegistry.addSmelting(new ItemStack(VenusBlocks.venus_block, 1, 5), new ItemStack(VenusItems.venus_item, 1, 0), 0.8F);
		GameRegistry.addSmelting(new ItemStack(VenusBlocks.venus_block, 1, 6), new ItemStack(GCItems.basicItem, 1, 4), 0.8F);
		GameRegistry.addSmelting(new ItemStack(VenusBlocks.venus_block, 1, 7), new ItemStack(GCItems.basicItem, 1, 3), 0.8F);
		GameRegistry.addSmelting(new ItemStack(VenusBlocks.venus_block, 1, 8), new ItemStack(Items.coal), 0.8F);
		GameRegistry.addSmelting(new ItemStack(VenusBlocks.venus_block, 1, 9), new ItemStack(Items.iron_ingot), 0.8F);
		GameRegistry.addSmelting(new ItemStack(VenusBlocks.venus_block, 1, 10), new ItemStack(Items.gold_ingot), 0.8F);
		GameRegistry.addSmelting(new ItemStack(VenusBlocks.venus_redstone_ore), new ItemStack(Items.redstone), 0.7F);
		GameRegistry.addSmelting(new ItemStack(PlutoBlocks.pluto_block, 1, 4), new ItemStack(GCItems.meteoricIronIngot), 0.8F);
		GameRegistry.addSmelting(new ItemStack(PlutoBlocks.pluto_block, 1, 5), new ItemStack(KapteynBItems.kapteyn_b_item, 1, 0), 0.8F);
		GameRegistry.addSmelting(new ItemStack(PlutoBlocks.pluto_block, 1, 6), new ItemStack(Items.iron_ingot), 0.8F);
		GameRegistry.addSmelting(new ItemStack(PlutoBlocks.pluto_block, 1, 7), new ItemStack(PlutoItems.pluto_item, 1, 0), 0.8F);
		GameRegistry.addSmelting(new ItemStack(PlutoItems.space_potato, 1, 0), new ItemStack(PlutoItems.space_potato, 1, 1), 0.5F);
		GameRegistry.addSmelting(new ItemStack(PhobosBlocks.phobos_block, 1, 4), new ItemStack(GCItems.basicItem, 1, 4), 0.7F);
		GameRegistry.addSmelting(new ItemStack(PhobosBlocks.phobos_block, 1, 5), new ItemStack(GCItems.basicItem, 1, 3), 0.7F);
		GameRegistry.addSmelting(new ItemStack(PhobosBlocks.phobos_block, 1, 6), new ItemStack(Items.iron_ingot), 0.8F);
		GameRegistry.addSmelting(new ItemStack(PhobosBlocks.phobos_block, 1, 7), new ItemStack(MarsItems.marsItemBasic, 1, 2), 0.8F);
		GameRegistry.addSmelting(new ItemStack(DeimosBlocks.deimos_block, 1, 4), new ItemStack(GCItems.basicItem, 1, 4), 0.7F);
		GameRegistry.addSmelting(new ItemStack(DeimosBlocks.deimos_block, 1, 5), new ItemStack(GCItems.basicItem, 1, 3), 0.7F);
		GameRegistry.addSmelting(new ItemStack(DeimosBlocks.deimos_block, 1, 6), new ItemStack(Items.iron_ingot), 0.8F);
		GameRegistry.addSmelting(new ItemStack(DeimosBlocks.deimos_block, 1, 7), new ItemStack(MarsItems.marsItemBasic, 1, 2), 0.8F);
		GameRegistry.addSmelting(new ItemStack(IoBlocks.io_block, 1, 4), new ItemStack(SiriusBItems.sirius_b_item, 1, 3), 0.7F);

		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.candy_cane1, 1, 0), new ItemStack(FronosItems.candy_cane, 4, 0), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.candy_cane1, 1, 1), new ItemStack(FronosItems.candy_cane, 4, 1), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.candy_cane1, 1, 2), new ItemStack(FronosItems.candy_cane, 4, 2), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.candy_cane1, 1, 3), new ItemStack(FronosItems.candy_cane, 4, 3), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.candy_cane2, 1, 0), new ItemStack(FronosItems.candy_cane, 4, 4), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.candy_cane2, 1, 1), new ItemStack(FronosItems.candy_cane, 4, 5), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.candy_cane2, 1, 2), new ItemStack(FronosItems.candy_cane, 4, 6), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.candy_cane2, 1, 3), new ItemStack(FronosItems.candy_cane, 4, 7), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.frosted_cake, 1, 0), new ItemStack(FronosBlocks.cake_bread), 0.6F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.frosted_cake, 1, 1), new ItemStack(FronosBlocks.white_cake_bread), 0.6F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.frosted_cake, 1, 2), new ItemStack(FronosBlocks.chocolate_cake_bread), 0.6F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.frosted_cake, 1, 3), new ItemStack(Items.cake), 0.6F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.frosted_cake, 1, 4), new ItemStack(FronosBlocks.pink_cake), 0.6F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.frosted_cake, 1, 5), new ItemStack(FronosBlocks.white_cake), 0.6F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.frosted_cake, 1, 6), new ItemStack(FronosBlocks.chocolate_cake), 0.6F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.jelly_block, 1, 0), new ItemStack(FronosItems.jelly, 4, 0), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.jelly_block, 1, 1), new ItemStack(FronosItems.jelly, 4, 1), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.jelly_block, 1, 2), new ItemStack(FronosItems.jelly, 4, 2), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.jelly_block, 1, 3), new ItemStack(FronosItems.jelly, 4, 3), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.jelly_block, 1, 4), new ItemStack(FronosItems.jelly, 4, 4), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.jelly_block, 1, 5), new ItemStack(FronosItems.jelly, 4, 5), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.jelly_block, 1, 6), new ItemStack(FronosItems.jelly, 4, 6), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.jelly_slime_egg, 1, 0), new ItemStack(FronosItems.jelly, 4, 0), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.jelly_slime_egg, 1, 1), new ItemStack(FronosItems.jelly, 4, 1), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.jelly_slime_egg, 1, 2), new ItemStack(FronosItems.jelly, 4, 2), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.jelly_slime_egg, 1, 3), new ItemStack(FronosItems.jelly, 4, 3), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.jelly_slime_egg, 1, 4), new ItemStack(FronosItems.jelly, 4, 4), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.jelly_slime_egg, 1, 5), new ItemStack(FronosItems.jelly, 4, 5), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.jelly_slime_egg, 1, 6), new ItemStack(FronosItems.jelly, 4, 6), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.jelly_slime_egg, 1, 7), new ItemStack(FronosItems.jelly, 4, 7), 0.4F);
		CandyExtractorRecipes.instance().addExtractingRecipe(new ItemStack(FronosBlocks.chocolate_block), new ItemStack(FronosItems.candy_food, 4, 1), 0.8F);

		CompressorRecipes.addShapelessRecipe(new ItemStack(DionaItems.diona_item, quick, 2), new ItemStack(DionaItems.diona_item, 1, 0), new ItemStack(DionaItems.diona_item, 1, 0));
		CompressorRecipes.addShapelessRecipe(new ItemStack(DionaItems.diona_item, quick, 3), new ItemStack(DionaItems.diona_item, 1, 1), new ItemStack(DionaItems.diona_item, 1, 1));
		CompressorRecipes.addShapelessRecipe(new ItemStack(DionaItems.tier_4_rocket_module, quick, 1), new ItemStack(AsteroidsItems.basicItem, 1, 0), new ItemStack(AsteroidsItems.basicItem, 1, 6));
		CompressorRecipes.addShapelessRecipe(new ItemStack(DionaItems.diona_item, quick, 4), new ItemStack(DionaItems.tier_4_rocket_module, 1, 1), new ItemStack(DionaItems.diona_item, 1, 3), new ItemStack(DionaItems.diona_item, 1, 2));
		CompressorRecipes.addShapelessRecipe(new ItemStack(PolongniusItems.polongnius_item, quick, 6), new ItemStack(PolongniusItems.polongnius_item, 1, 4), new ItemStack(PolongniusItems.polongnius_item, 1, 4));
		CompressorRecipes.addShapelessRecipe(new ItemStack(PolongniusItems.polongnius_item, quick, 7), new ItemStack(PolongniusItems.polongnius_item, 1, 5), new ItemStack(PolongniusItems.polongnius_item, 1, 5));
		CompressorRecipes.addShapelessRecipe(new ItemStack(PolongniusItems.tier_6_rocket_module, quick, 2), new ItemStack(PolongniusItems.polongnius_item, 1, 7), new ItemStack(PolongniusItems.polongnius_item, 1, 6), new ItemStack(DionaItems.diona_item, 1, 4));
		CompressorRecipes.addShapelessRecipe(new ItemStack(NibiruItems.nibiru_item, quick, 2), new ItemStack(NibiruItems.nibiru_item, 1, 0), new ItemStack(NibiruItems.nibiru_item, 1, 0));
		CompressorRecipes.addShapelessRecipe(new ItemStack(NibiruItems.nibiru_item, quick, 3), new ItemStack(NibiruItems.nibiru_item, 1, 1), new ItemStack(NibiruItems.nibiru_item, 1, 1));
		CompressorRecipes.addShapelessRecipe(new ItemStack(NibiruItems.tier_7_rocket_module, quick, 2), new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 2), new ItemStack(NibiruItems.nibiru_item, 1, 3), new ItemStack(NibiruItems.nibiru_item, 1, 2));
		CompressorRecipes.addShapelessRecipe(new ItemStack(KoentusItems.koentus_item, quick, 5), new ItemStack(KoentusItems.koentus_item, 1, 0), new ItemStack(KoentusItems.koentus_item, 1, 0));
		CompressorRecipes.addShapelessRecipe(new ItemStack(KoentusItems.koentus_item, quick, 6), new ItemStack(KoentusItems.koentus_item, 1, 4), new ItemStack(KoentusItems.koentus_item, 1, 4));
		CompressorRecipes.addShapelessRecipe(new ItemStack(FronosItems.fronos_item, quick, 4), new ItemStack(FronosItems.fronos_item, 1, 2), new ItemStack(FronosItems.fronos_item, 1, 2));
		CompressorRecipes.addShapelessRecipe(new ItemStack(FronosItems.fronos_item, quick, 5), new ItemStack(FronosItems.fronos_item, 1, 3), new ItemStack(FronosItems.fronos_item, 1, 3));
		CompressorRecipes.addShapelessRecipe(new ItemStack(FronosItems.tier_8_rocket_module, quick, 2), new ItemStack(FronosItems.fronos_item, 1, 4), new ItemStack(FronosItems.fronos_item, 1, 5), new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2));
		CompressorRecipes.addShapelessRecipe(new ItemStack(KapteynBItems.kapteyn_b_item, quick, 2), new ItemStack(KapteynBItems.kapteyn_b_item, 1, 0), new ItemStack(KapteynBItems.kapteyn_b_item, 1, 0));
		CompressorRecipes.addShapelessRecipe(new ItemStack(SiriusBItems.sirius_b_item, quick, 0), new ItemStack(SiriusBBlocks.sirius_b_block, 9, 3));
		CompressorRecipes.addShapelessRecipe(new ItemStack(SiriusBItems.sirius_b_item, quick, 4), new ItemStack(SiriusBItems.sirius_b_item, 1, 3), new ItemStack(SiriusBItems.sirius_b_item, 1, 3));
		CompressorRecipes.addShapelessRecipe(new ItemStack(MercuryItems.mercury_item, quick, 4), new ItemStack(MercuryItems.mercury_item, 1, 2), new ItemStack(MercuryItems.mercury_item, 1, 2));
		CompressorRecipes.addShapelessRecipe(new ItemStack(MercuryItems.mercury_item, quick, 5), new ItemStack(MercuryItems.mercury_item, 1, 3), new ItemStack(MercuryItems.mercury_item, 1, 3));

		CircuitFabricatorRecipes.addRecipe(new ItemStack(PolongniusItems.purple_crystal_solar_module, quick, 0), new ItemStack[] { new ItemStack(PolongniusItems.polongnius_item, 1, 1), new ItemStack(GCItems.basicItem, 1, 2), new ItemStack(GCItems.basicItem, 1, 2), new ItemStack(Items.redstone), new ItemStack(Items.repeater) });
		CircuitFabricatorRecipes.addRecipe(new ItemStack(PolongniusItems.purple_crystal_solar_module, 9, 1), new ItemStack[] { new ItemStack(Items.diamond), new ItemStack(GCItems.basicItem, 1, 2), new ItemStack(GCItems.basicItem, 1, 2), new ItemStack(Items.redstone), new ItemStack(PolongniusItems.polongnius_item, 1, 1) });

		BrewingRecipeRegistry.addRecipe(new ItemStack(Items.potionitem, 1, 16), new ItemStack(SiriusBItems.sirius_magma_cream), new ItemStack(Items.potionitem, 1, 8195));
	}

	private static void registerSlabRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_stone_slab_1, 6, 0), new Object[] { "XXX", 'X', new ItemStack(DionaBlocks.diona_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_stone_slab_1, 6, 1), new Object[] { "XXX", 'X', new ItemStack(DionaBlocks.diona_block, 1, 13) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_stone_slab_1, 6, 2), new Object[] { "XXX", 'X', new ItemStack(DionaBlocks.diona_block, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_dungeon_brick_slab_1, 6, 0), new Object[] { "XXX", 'X', new ItemStack(DionaBlocks.diona_block, 1, 15) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_stone_slab_1, 6, 3), new Object[] { "XXX", 'X', new ItemStack(PolongniusBlocks.polongnius_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_dungeon_brick_slab_1, 6, 1), new Object[] { "XXX", 'X', new ItemStack(PolongniusBlocks.polongnius_block, 1, 15) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_stone_slab_1, 6, 4), new Object[] { "XXX", 'X', new ItemStack(NibiruBlocks.nibiru_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_dungeon_brick_slab_1, 6, 2), new Object[] { "XXX", 'X', new ItemStack(NibiruBlocks.nibiru_block, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_wooden_slab_1, 6, 0), new Object[] { "XXX", 'X', new ItemStack(NibiruBlocks.nibiru_planks, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_wooden_slab_1, 6, 1), new Object[] { "XXX", 'X', new ItemStack(NibiruBlocks.nibiru_planks, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_stone_slab_1, 6, 5), new Object[] { "XXX", 'X', new ItemStack(KoentusBlocks.koentus_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_stone_slab_1, 6, 6), new Object[] { "XXX", 'X', new ItemStack(KoentusBlocks.koentus_block, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_stone_slab_1, 6, 7), new Object[] { "XXX", 'X', new ItemStack(KoentusBlocks.koentus_block, 1, 13) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_wooden_slab_1, 6, 2), new Object[] { "CCC", 'C', new ItemStack(KoentusBlocks.crystal_planks) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_dungeon_brick_slab_1, 6, 3), new Object[] { "XXX", 'X', new ItemStack(KoentusBlocks.koentus_block, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_wooden_slab_1, 6, 3), new Object[] { "CCC", 'C', new ItemStack(FronosBlocks.fronos_planks, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_wooden_slab_1, 6, 4), new Object[] { "RRR", 'R', new ItemStack(FronosBlocks.fronos_planks, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_stone_slab_2, 6, 0), new Object[] { "SSS", 'S', new ItemStack(FronosBlocks.fronos_block, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_stone_slab_2, 6, 1), new Object[] { "SSS", 'S', new ItemStack(FronosBlocks.fronos_block, 1, 11) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_stone_slab_2, 6, 2), new Object[] { "SSS", 'S', new ItemStack(FronosBlocks.fronos_block, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_dungeon_brick_slab_1, 6, 4), new Object[] { "SSS", 'S', new ItemStack(FronosBlocks.fronos_block, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_stone_slab_2, 6, 3), new Object[] { "CCC", 'C', new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_dungeon_brick_slab_1, 6, 5), new Object[] { "CCC", 'C', new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_stone_slab_2, 6, 4), new Object[] { "CCC", 'C', new ItemStack(SiriusBBlocks.sirius_b_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_dungeon_brick_slab_1, 6, 6), new Object[] { "CCC", 'C', new ItemStack(SiriusBBlocks.sirius_b_block, 1, 9) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_stone_slab_2, 6, 5), new Object[] { "XXX", 'X', new ItemStack(MercuryBlocks.mercury_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_dungeon_brick_slab_1, 6, 7), new Object[] { "XXX", 'X', new ItemStack(MercuryBlocks.mercury_block, 1, 11) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_wooden_slab_1, 6, 5), new Object[] { "CCC", 'C', new ItemStack(EuropaBlocks.europa_planks) });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.half_europa_sandstone_slab, 6), new Object[] { "SSS", 'S', EuropaBlocks.europa_sandstone });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.half_europa_prismarine_slab, 6, 0), new Object[] { "PPP", 'P', new ItemStack(EuropaBlocks.europa_prismarine, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.half_europa_prismarine_slab, 6, 1), new Object[] { "PPP", 'P', new ItemStack(EuropaBlocks.europa_prismarine, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.half_europa_prismarine_slab, 6, 2), new Object[] { "PPP", 'P', new ItemStack(EuropaBlocks.europa_prismarine, 1, 2) });
	}

	private static void registerStairsRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(DionaBlocks.diona_cobblestone_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(DionaBlocks.diona_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(DionaBlocks.quontonium_brick_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(DionaBlocks.diona_block, 1, 13) });
		GameRegistry.addRecipe(new ItemStack(DionaBlocks.chiseled_quontonium_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(DionaBlocks.diona_block, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(DionaBlocks.diona_dungeon_brick_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(DionaBlocks.diona_block, 1, 15) });
		GameRegistry.addRecipe(new ItemStack(PolongniusBlocks.polongnius_cobblestone_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(PolongniusBlocks.polongnius_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(PolongniusBlocks.polongnius_dungeon_brick_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(PolongniusBlocks.polongnius_block, 1, 15) });
		GameRegistry.addRecipe(new ItemStack(NibiruBlocks.nibiru_cobblestone_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(NibiruBlocks.nibiru_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(NibiruBlocks.nibiru_dungeon_brick_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(NibiruBlocks.nibiru_block, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(NibiruBlocks.ancient_dark_wood_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(NibiruBlocks.nibiru_planks, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(NibiruBlocks.orange_wood_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(NibiruBlocks.nibiru_planks, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(KoentusBlocks.koentus_cobblestone_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(KoentusBlocks.koentus_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(KoentusBlocks.koentus_dungeon_brick_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(KoentusBlocks.koentus_block, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(KoentusBlocks.koentus_ancient_stone_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(KoentusBlocks.koentus_block, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(KoentusBlocks.koentus_ancient_stone_brick_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(KoentusBlocks.koentus_block, 1, 13) });
		GameRegistry.addRecipe(new ItemStack(KoentusBlocks.crystal_wood_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(KoentusBlocks.crystal_planks) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.coconut_wood_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(FronosBlocks.fronos_planks, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.maple_wood_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(FronosBlocks.fronos_planks, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.fronos_cobblestone_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(FronosBlocks.fronos_block, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.fronos_stone_brick_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(FronosBlocks.fronos_block, 1, 11) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.cracked_fronos_stone_brick_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(FronosBlocks.fronos_block, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(FronosBlocks.fronos_dungeon_brick_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(FronosBlocks.fronos_block, 1, 14) });
		RecipeUtil.addRecipe(new ItemStack(FronosBlocks.fronos_sandstone_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', "fronosSandstone" });
		RecipeUtil.addRecipe(new ItemStack(FronosBlocks.white_sandstone_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', "whiteSandstone" });
		RecipeUtil.addRecipe(new ItemStack(FronosBlocks.cheese_sandstone_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', "cheeseSandstone" });
		GameRegistry.addRecipe(new ItemStack(KapteynBBlocks.kapteyn_b_cracked_ice_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(KapteynBBlocks.kapteyn_b_dungeon_brick_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(SiriusBBlocks.sirius_b_carbon_cobblestone_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(SiriusBBlocks.sirius_b_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(SiriusBBlocks.sirius_b_dungeon_brick_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(SiriusBBlocks.sirius_b_block, 1, 9) });
		GameRegistry.addRecipe(new ItemStack(MercuryBlocks.mercury_cobblestone_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(MercuryBlocks.mercury_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MercuryBlocks.mercury_dungeon_brick_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(MercuryBlocks.mercury_block, 1, 11) });
		GameRegistry.addRecipe(new ItemStack(VenusBlocks.venus_sandstone_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', VenusBlocks.venus_sandstone });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.europa_wood_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(EuropaBlocks.europa_planks) });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.europa_sandstone_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', EuropaBlocks.europa_sandstone });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.europa_prismarine_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(EuropaBlocks.europa_prismarine, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.europa_prismarine_brick_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(EuropaBlocks.europa_prismarine, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(EuropaBlocks.dark_europa_prismarine_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(EuropaBlocks.europa_prismarine, 1, 2) });
	}

	private static void registerWallRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(MPBlocks.stone_wall, 6, 0), new Object[] { "XXX", "XXX", 'X', new ItemStack(DionaBlocks.diona_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.stone_wall, 6, 1), new Object[] { "XXX", "XXX", 'X', new ItemStack(DionaBlocks.diona_block, 1, 13) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.stone_wall, 6, 2), new Object[] { "XXX", "XXX", 'X', new ItemStack(DionaBlocks.diona_block, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.dungeon_brick_wall, 6, 0), new Object[] { "XXX", "XXX", 'X', new ItemStack(DionaBlocks.diona_block, 1, 15) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.stone_wall, 6, 3), new Object[] { "XXX", "XXX", 'X', new ItemStack(PolongniusBlocks.polongnius_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.dungeon_brick_wall, 6, 1), new Object[] { "XXX", "XXX", 'X', new ItemStack(PolongniusBlocks.polongnius_block, 1, 15) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.stone_wall, 6, 4), new Object[] { "XXX", "XXX", 'X', new ItemStack(NibiruBlocks.nibiru_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.dungeon_brick_wall, 6, 2), new Object[] { "XXX", "XXX", 'X', new ItemStack(NibiruBlocks.nibiru_block, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.stone_wall, 6, 5), new Object[] { "XXX", "XXX", 'X', new ItemStack(KoentusBlocks.koentus_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.stone_wall, 6, 6), new Object[] { "XXX", "XXX", 'X', new ItemStack(KoentusBlocks.koentus_block, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.stone_wall, 6, 7), new Object[] { "XXX", "XXX", 'X', new ItemStack(KoentusBlocks.koentus_block, 1, 13) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.dungeon_brick_wall, 6, 3), new Object[] { "XXX", "XXX", 'X', new ItemStack(KoentusBlocks.koentus_block, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.stone_wall, 6, 8), new Object[] { "CCC", "CCC", 'C', new ItemStack(FronosBlocks.fronos_block, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.stone_wall, 6, 9), new Object[] { "CCC", "CCC", 'C', new ItemStack(FronosBlocks.fronos_block, 1, 11) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.stone_wall, 6, 10), new Object[] { "CCC", "CCC", 'C', new ItemStack(FronosBlocks.fronos_block, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.dungeon_brick_wall, 6, 4), new Object[] { "CCC", "CCC", 'C', new ItemStack(FronosBlocks.fronos_block, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.stone_wall, 6, 11), new Object[] { "CCC", "CCC", 'C', new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.dungeon_brick_wall, 6, 5), new Object[] { "CCC", "CCC", 'C', new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 12) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.stone_wall, 6, 12), new Object[] { "CCC", "CCC", 'C', new ItemStack(SiriusBBlocks.sirius_b_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.dungeon_brick_wall, 6, 6), new Object[] { "CCC", "CCC", 'C', new ItemStack(SiriusBBlocks.sirius_b_block, 1, 9) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.stone_wall, 6, 13), new Object[] { "XXX", "XXX", 'X', new ItemStack(MercuryBlocks.mercury_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.dungeon_brick_wall, 6, 7), new Object[] { "XXX", "XXX", 'X', new ItemStack(MercuryBlocks.mercury_block, 1, 11) });
	}

	private static void registerArmorsToolsRecipes()
	{
		// Armors
		GameRegistry.addRecipe(new ItemStack(DionaArmorItems.quontonium_helmet), new Object[] { "XXX", "X X", 'X', new ItemStack(DionaItems.diona_item, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(DionaArmorItems.quontonium_chestplate), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(DionaItems.diona_item, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(DionaArmorItems.quontonium_leggings), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(DionaItems.diona_item, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(DionaArmorItems.quontonium_boots), new Object[] { "X X", "X X", 'X', new ItemStack(DionaItems.diona_item, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(DionaArmorItems.fronisium_helmet), new Object[] { "XXX", "X X", 'X', new ItemStack(DionaItems.diona_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(DionaArmorItems.fronisium_chestplate), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(DionaItems.diona_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(DionaArmorItems.fronisium_leggings), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(DionaItems.diona_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(DionaArmorItems.fronisium_boots), new Object[] { "X X", "X X", 'X', new ItemStack(DionaItems.diona_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(DionaArmorItems.breathable_quontonium_helmet), new Object[] { "XXX", "XXX", 'O', new ItemStack(GCItems.oxMask), 'X', new ItemStack(DionaItems.diona_item, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(DionaArmorItems.breathable_fronisium_helmet), new Object[] { "FFF", "FOF", 'O', new ItemStack(GCItems.oxMask), 'F', new ItemStack(DionaItems.diona_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.cheese_leather_helmet), new Object[] { "XXX", "X X", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 10) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.cheese_leather_chestplate), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 10) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.cheese_leather_leggings), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 10) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.cheese_leather_boots), new Object[] { "X X", "X X", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 10) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.polongnius_meteoric_iron_helmet), new Object[] { "XXX", "X X", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.polongnius_meteoric_iron_chestplate), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.polongnius_meteoric_iron_leggings), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.polongnius_meteoric_iron_boots), new Object[] { "X X", "X X", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.palladium_helmet), new Object[] { "XXX", "X X", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.palladium_chestplate), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.palladium_leggings), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.palladium_boots), new Object[] { "X X", "X X", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.purple_crystal_helmet), new Object[] { "XXX", "X X", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.purple_crystal_chestplate), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.purple_crystal_leggings), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.purple_crystal_boots), new Object[] { "X X", "X X", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.breathable_polongnius_meteoric_iron_helmet), new Object[] { "MMM", "MOM", 'O', new ItemStack(GCItems.oxMask), 'M', new ItemStack(PolongniusItems.polongnius_item, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(PolongniusArmorItems.breathable_palladium_helmet), new Object[] { "PPP", "POP", 'O', new ItemStack(GCItems.oxMask), 'P', new ItemStack(PolongniusItems.polongnius_item, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(NibiruArmorItems.red_gem_helmet), new Object[] { "XXX", "X X", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(NibiruArmorItems.red_gem_chestplate), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(NibiruArmorItems.red_gem_leggings), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(NibiruArmorItems.red_gem_boots), new Object[] { "X X", "X X", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(NibiruArmorItems.norium_helmet), new Object[] { "XXX", "X X", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(NibiruArmorItems.norium_chestplate), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(NibiruArmorItems.norium_leggings), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(NibiruArmorItems.norium_boots), new Object[] { "X X", "X X", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(NibiruArmorItems.breathable_red_gem_helmet), new Object[] { "RRR", "ROR", 'R', new ItemStack(NibiruItems.nibiru_item, 1, 2), 'O', new ItemStack(GCItems.oxMask) });
		GameRegistry.addRecipe(new ItemStack(NibiruArmorItems.breathable_norium_helmet), new Object[] { "NNN", "NON", 'N', new ItemStack(NibiruItems.nibiru_item, 1, 3), 'O', new ItemStack(GCItems.oxMask) });
		GameRegistry.addRecipe(new ItemStack(KoentusArmorItems.koentus_meteoric_iron_helmet), new Object[] { "XXX", "X X", 'X', new ItemStack(KoentusItems.koentus_item, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(KoentusArmorItems.koentus_meteoric_iron_chestplate), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(KoentusItems.koentus_item, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(KoentusArmorItems.koentus_meteoric_iron_leggings), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(KoentusItems.koentus_item, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(KoentusArmorItems.koentus_meteoric_iron_boots), new Object[] { "X X", "X X", 'X', new ItemStack(KoentusItems.koentus_item, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(KoentusArmorItems.white_crystal_helmet), new Object[] { "XXX", "X X", 'X', new ItemStack(KoentusItems.koentus_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(KoentusArmorItems.white_crystal_chestplate), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(KoentusItems.koentus_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(KoentusArmorItems.white_crystal_leggings), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(KoentusItems.koentus_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(KoentusArmorItems.white_crystal_boots), new Object[] { "X X", "X X", 'X', new ItemStack(KoentusItems.koentus_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(KoentusArmorItems.breathable_koentus_meteoric_iron_helmet), new Object[] { "XXX", "XOX", 'X', new ItemStack(KoentusItems.koentus_item, 1, 6), 'O', new ItemStack(GCItems.oxMask) });
		GameRegistry.addRecipe(new ItemStack(KoentusArmorItems.breathable_white_crystal_helmet), new Object[] { "XXX", "XOX", 'X', new ItemStack(KoentusItems.koentus_item, 1, 5), 'O', new ItemStack(GCItems.oxMask) });
		GameRegistry.addRecipe(new ItemStack(FronosArmorItems.black_diamond_helmet), new Object[] { "XXX", "X X", 'X', new ItemStack(FronosItems.fronos_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(FronosArmorItems.black_diamond_chestplate), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(FronosItems.fronos_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(FronosArmorItems.black_diamond_leggings), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(FronosItems.fronos_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(FronosArmorItems.black_diamond_boots), new Object[] { "X X", "X X", 'X', new ItemStack(FronosItems.fronos_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(FronosArmorItems.iridium_helmet), new Object[] { "XXX", "X X", 'X', new ItemStack(FronosItems.fronos_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(FronosArmorItems.iridium_chestplate), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(FronosItems.fronos_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(FronosArmorItems.iridium_leggings), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(FronosItems.fronos_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(FronosArmorItems.iridium_boots), new Object[] { "X X", "X X", 'X', new ItemStack(FronosItems.fronos_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(FronosArmorItems.breathable_black_diamond_helmet), new Object[] { "DDD", "DOD", 'D', new ItemStack(FronosItems.fronos_item, 1, 4), 'O', new ItemStack(GCItems.oxMask) });
		GameRegistry.addRecipe(new ItemStack(FronosArmorItems.breathable_iridium_helmet), new Object[] { "III", "IOI", 'I', new ItemStack(FronosItems.fronos_item, 1, 5), 'O', new ItemStack(GCItems.oxMask) });
		GameRegistry.addRecipe(new ItemStack(KapteynBArmorItems.uranium_helmet), new Object[] { "XXX", "X X", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(KapteynBArmorItems.uranium_chestplate), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(KapteynBArmorItems.uranium_leggings), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(KapteynBArmorItems.uranium_boots), new Object[] { "X X", "X X", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(KapteynBArmorItems.frozen_iron_helmet), new Object[] { "XXX", "X X", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(KapteynBArmorItems.frozen_iron_chestplate), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(KapteynBArmorItems.frozen_iron_leggings), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(KapteynBArmorItems.frozen_iron_boots), new Object[] { "X X", "X X", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(KapteynBArmorItems.breathable_uranium_helmet), new Object[] { "XXX", "XOX", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 1), 'O', new ItemStack(GCItems.oxMask) });
		GameRegistry.addRecipe(new ItemStack(KapteynBArmorItems.breathable_frozen_iron_helmet), new Object[] { "XXX", "XOX", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 2), 'O', new ItemStack(GCItems.oxMask) });
		GameRegistry.addRecipe(new ItemStack(SiriusBArmorItems.sulfur_helmet, 1, 0), new Object[] { "XXX", "X X", 'X', new ItemStack(SiriusBItems.sirius_b_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(SiriusBArmorItems.sulfur_chestplate, 1, 0), new Object[] { "X X", "XXX", "XXX", 'X', new ItemStack(SiriusBItems.sirius_b_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(SiriusBArmorItems.sulfur_leggings, 1, 0), new Object[] { "XXX", "X X", "X X", 'X', new ItemStack(SiriusBItems.sirius_b_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(SiriusBArmorItems.sulfur_boots, 1, 0), new Object[] { "X X", "X X", 'X', new ItemStack(SiriusBItems.sirius_b_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(SiriusBArmorItems.breathable_sulfur_helmet), new Object[] { "PPP", "POP", 'O', new ItemStack(GCItems.oxMask), 'P', new ItemStack(SiriusBItems.sirius_b_item, 1, 4) });

		// Tools
		GameRegistry.addRecipe(new ItemStack(DionaToolsItems.quontonium_hoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(DionaItems.diona_item, 1, 2), 'Y', new ItemStack(DionaItems.diona_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(DionaToolsItems.quontonium_axe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(DionaItems.diona_item, 1, 2), 'Y', new ItemStack(DionaItems.diona_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(DionaToolsItems.quontonium_pickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(DionaItems.diona_item, 1, 2), 'Y', new ItemStack(DionaItems.diona_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(DionaToolsItems.quontonium_sword), new Object[] { "X", "X", "Y", 'X', new ItemStack(DionaItems.diona_item, 1, 2), 'Y', new ItemStack(DionaItems.diona_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(DionaToolsItems.quontonium_shovel), new Object[] { "X", "Y", "Y", 'X', new ItemStack(DionaItems.diona_item, 1, 2), 'Y', new ItemStack(DionaItems.diona_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(DionaToolsItems.fronisium_hoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(DionaItems.diona_item, 1, 3), 'Y', new ItemStack(DionaItems.diona_item, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(DionaToolsItems.fronisium_axe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(DionaItems.diona_item, 1, 3), 'Y', new ItemStack(DionaItems.diona_item, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(DionaToolsItems.fronisium_pickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(DionaItems.diona_item, 1, 3), 'Y', new ItemStack(DionaItems.diona_item, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(DionaToolsItems.fronisium_sword), new Object[] { "X", "X", "Y", 'X', new ItemStack(DionaItems.diona_item, 1, 3), 'Y', new ItemStack(DionaItems.diona_item, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(DionaToolsItems.fronisium_shovel), new Object[] { "X", "Y", "Y", 'X', new ItemStack(DionaItems.diona_item, 1, 3), 'Y', new ItemStack(DionaItems.diona_item, 1, 6) });
		GameRegistry.addRecipe(new ItemStack(PolongniusToolsItems.polongnius_meteoric_iron_hoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 6), 'Y', new ItemStack(PolongniusItems.polongnius_item, 1, 8) });
		GameRegistry.addRecipe(new ItemStack(PolongniusToolsItems.polongnius_meteoric_iron_axe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 6), 'Y', new ItemStack(PolongniusItems.polongnius_item, 1, 8) });
		GameRegistry.addRecipe(new ItemStack(PolongniusToolsItems.polongnius_meteoric_iron_pickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 6), 'Y', new ItemStack(PolongniusItems.polongnius_item, 1, 8) });
		GameRegistry.addRecipe(new ItemStack(PolongniusToolsItems.polongnius_meteoric_iron_sword), new Object[] { "X", "X", "Y", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 6), 'Y', new ItemStack(PolongniusItems.polongnius_item, 1, 8) });
		GameRegistry.addRecipe(new ItemStack(PolongniusToolsItems.polongnius_meteoric_iron_shovel), new Object[] { "X", "Y", "Y", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 6), 'Y', new ItemStack(PolongniusItems.polongnius_item, 1, 8) });
		GameRegistry.addRecipe(new ItemStack(PolongniusToolsItems.palladium_hoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 7), 'Y', new ItemStack(PolongniusItems.polongnius_item, 1, 9) });
		GameRegistry.addRecipe(new ItemStack(PolongniusToolsItems.palladium_axe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 7), 'Y', new ItemStack(PolongniusItems.polongnius_item, 1, 9) });
		GameRegistry.addRecipe(new ItemStack(PolongniusToolsItems.palladium_pickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 7), 'Y', new ItemStack(PolongniusItems.polongnius_item, 1, 9) });
		GameRegistry.addRecipe(new ItemStack(PolongniusToolsItems.palladium_sword), new Object[] { "X", "X", "Y", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 7), 'Y', new ItemStack(PolongniusItems.polongnius_item, 1, 9) });
		GameRegistry.addRecipe(new ItemStack(PolongniusToolsItems.palladium_shovel), new Object[] { "X", "Y", "Y", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 7), 'Y', new ItemStack(PolongniusItems.polongnius_item, 1, 9) });
		GameRegistry.addRecipe(new ItemStack(PolongniusToolsItems.purple_crystal_hoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 1), 'Y', new ItemStack(PolongniusItems.polongnius_item, 1, 9) });
		GameRegistry.addRecipe(new ItemStack(PolongniusToolsItems.purple_crystal_axe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 1), 'Y', new ItemStack(PolongniusItems.polongnius_item, 1, 9) });
		GameRegistry.addRecipe(new ItemStack(PolongniusToolsItems.purple_crystal_pickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 1), 'Y', new ItemStack(PolongniusItems.polongnius_item, 1, 9) });
		GameRegistry.addRecipe(new ItemStack(PolongniusToolsItems.purple_crystal_sword), new Object[] { "X", "X", "Y", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 1), 'Y', new ItemStack(PolongniusItems.polongnius_item, 1, 9) });
		GameRegistry.addRecipe(new ItemStack(PolongniusToolsItems.purple_crystal_shovel), new Object[] { "X", "Y", "Y", 'X', new ItemStack(PolongniusItems.polongnius_item, 1, 1), 'Y', new ItemStack(PolongniusItems.polongnius_item, 1, 9) });
		GameRegistry.addRecipe(new ItemStack(NibiruToolsItems.red_gem_hoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 2), 'Y', new ItemStack(NibiruItems.nibiru_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(NibiruToolsItems.red_gem_axe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 2), 'Y', new ItemStack(NibiruItems.nibiru_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(NibiruToolsItems.red_gem_pickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 2), 'Y', new ItemStack(NibiruItems.nibiru_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(NibiruToolsItems.red_gem_sword), new Object[] { "X", "X", "Y", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 2), 'Y', new ItemStack(NibiruItems.nibiru_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(NibiruToolsItems.red_gem_shovel), new Object[] { "X", "Y", "Y", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 2), 'Y', new ItemStack(NibiruItems.nibiru_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(NibiruToolsItems.norium_hoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 3), 'Y', new ItemStack(NibiruItems.nibiru_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(NibiruToolsItems.norium_axe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 3), 'Y', new ItemStack(NibiruItems.nibiru_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(NibiruToolsItems.norium_pickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 3), 'Y', new ItemStack(NibiruItems.nibiru_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(NibiruToolsItems.norium_sword), new Object[] { "X", "X", "Y", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 3), 'Y', new ItemStack(NibiruItems.nibiru_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(NibiruToolsItems.norium_shovel), new Object[] { "X", "Y", "Y", 'X', new ItemStack(NibiruItems.nibiru_item, 1, 3), 'Y', new ItemStack(NibiruItems.nibiru_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(KoentusToolsItems.koentus_meteoric_iron_hoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(KoentusItems.koentus_item, 1, 6), 'Y', new ItemStack(DionaItems.diona_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(KoentusToolsItems.koentus_meteoric_iron_axe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(KoentusItems.koentus_item, 1, 6), 'Y', new ItemStack(DionaItems.diona_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(KoentusToolsItems.koentus_meteoric_iron_pickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(KoentusItems.koentus_item, 1, 6), 'Y', new ItemStack(DionaItems.diona_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(KoentusToolsItems.koentus_meteoric_iron_sword), new Object[] { "X", "X", "Y", 'X', new ItemStack(KoentusItems.koentus_item, 1, 6), 'Y', new ItemStack(DionaItems.diona_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(KoentusToolsItems.koentus_meteoric_iron_shovel), new Object[] { "X", "Y", "Y", 'X', new ItemStack(KoentusItems.koentus_item, 1, 6), 'Y', new ItemStack(DionaItems.diona_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(KoentusToolsItems.white_crystal_hoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(KoentusItems.koentus_item, 1, 5), 'Y', new ItemStack(DionaItems.diona_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(KoentusToolsItems.white_crystal_axe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(KoentusItems.koentus_item, 1, 5), 'Y', new ItemStack(DionaItems.diona_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(KoentusToolsItems.white_crystal_pickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(KoentusItems.koentus_item, 1, 5), 'Y', new ItemStack(DionaItems.diona_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(KoentusToolsItems.white_crystal_sword), new Object[] { "X", "X", "Y", 'X', new ItemStack(KoentusItems.koentus_item, 1, 5), 'Y', new ItemStack(DionaItems.diona_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(KoentusToolsItems.white_crystal_shovel), new Object[] { "X", "Y", "Y", 'X', new ItemStack(KoentusItems.koentus_item, 1, 5), 'Y', new ItemStack(DionaItems.diona_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(FronosToolsItems.black_diamond_hoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(FronosItems.fronos_item, 1, 4), 'Y', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(FronosToolsItems.black_diamond_axe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(FronosItems.fronos_item, 1, 4), 'Y', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(FronosToolsItems.black_diamond_pickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(FronosItems.fronos_item, 1, 4), 'Y', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(FronosToolsItems.black_diamond_sword), new Object[] { "X", "X", "Y", 'X', new ItemStack(FronosItems.fronos_item, 1, 4), 'Y', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(FronosToolsItems.black_diamond_shovel), new Object[] { "X", "Y", "Y", 'X', new ItemStack(FronosItems.fronos_item, 1, 4), 'Y', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(FronosToolsItems.iridium_hoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(FronosItems.fronos_item, 1, 5), 'Y', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(FronosToolsItems.iridium_axe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(FronosItems.fronos_item, 1, 5), 'Y', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(FronosToolsItems.iridium_pickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(FronosItems.fronos_item, 1, 5), 'Y', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(FronosToolsItems.iridium_sword), new Object[] { "X", "X", "Y", 'X', new ItemStack(FronosItems.fronos_item, 1, 5), 'Y', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(FronosToolsItems.iridium_shovel), new Object[] { "X", "Y", "Y", 'X', new ItemStack(FronosItems.fronos_item, 1, 5), 'Y', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(FronosToolsItems.fronos_rock_hoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(FronosBlocks.fronos_block, 1, 1), 'Y', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(FronosToolsItems.fronos_rock_axe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(FronosBlocks.fronos_block, 1, 1), 'Y', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(FronosToolsItems.fronos_rock_pickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(FronosBlocks.fronos_block, 1, 1), 'Y', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(FronosToolsItems.fronos_rock_sword), new Object[] { "X", "X", "Y", 'X', new ItemStack(FronosBlocks.fronos_block, 1, 1), 'Y', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(FronosToolsItems.fronos_rock_shovel), new Object[] { "X", "Y", "Y", 'X', new ItemStack(FronosBlocks.fronos_block, 1, 1), 'Y', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(KapteynBToolsItems.uranium_hoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 1), 'Y', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(KapteynBToolsItems.uranium_axe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 1), 'Y', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(KapteynBToolsItems.uranium_pickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 1), 'Y', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(KapteynBToolsItems.uranium_sword), new Object[] { "X", "X", "Y", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 1), 'Y', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(KapteynBToolsItems.uranium_shovel), new Object[] { "X", "Y", "Y", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 1), 'Y', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(KapteynBToolsItems.frozen_iron_hoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 2), 'Y', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(KapteynBToolsItems.frozen_iron_axe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 2), 'Y', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(KapteynBToolsItems.frozen_iron_pickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 2), 'Y', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(KapteynBToolsItems.frozen_iron_sword), new Object[] { "X", "X", "Y", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 2), 'Y', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(KapteynBToolsItems.frozen_iron_shovel), new Object[] { "X", "Y", "Y", 'X', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 2), 'Y', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 4) });
		GameRegistry.addRecipe(new ItemStack(SiriusBToolsItems.sulfur_hoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(SiriusBItems.sirius_b_item, 1, 4), 'Y', new ItemStack(SiriusBItems.sirius_b_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(SiriusBToolsItems.sulfur_axe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(SiriusBItems.sirius_b_item, 1, 4), 'Y', new ItemStack(SiriusBItems.sirius_b_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(SiriusBToolsItems.sulfur_pickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(SiriusBItems.sirius_b_item, 1, 4), 'Y', new ItemStack(SiriusBItems.sirius_b_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(SiriusBToolsItems.sulfur_sword), new Object[] { "X", "X", "Y", 'X', new ItemStack(SiriusBItems.sirius_b_item, 1, 4), 'Y', new ItemStack(SiriusBItems.sirius_b_item, 1, 5) });
		GameRegistry.addRecipe(new ItemStack(SiriusBToolsItems.sulfur_shovel), new Object[] { "X", "Y", "Y", 'X', new ItemStack(SiriusBItems.sirius_b_item, 1, 4), 'Y', new ItemStack(SiriusBItems.sirius_b_item, 1, 5) });

		if (ConfigManagerMP.disableMultipleCandyCaneRecipe)
		{
			GameRegistry.addRecipe(new ItemStack(FronosItems.candy_bow), new Object[] { " CS", "C S", " CS", 'C', new ItemStack(FronosItems.candy_cane, 1, 0), 'S', new ItemStack(FronosItems.fronos_item, 1, 9) });
			GameRegistry.addRecipe(new ItemStack(FronosItems.poison_arrow, 4), new Object[] { "P", "C", "S", 'C', new ItemStack(FronosItems.candy_cane, 1, 0), 'S', new ItemStack(FronosBlocks.cloud_block), 'P', new ItemStack(FronosBlocks.fronos_flower, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(FronosItems.poison_arrow, 4), new Object[] { "P", "C", "S", 'C', new ItemStack(FronosItems.candy_cane, 1, 0), 'S', new ItemStack(FronosBlocks.cloud_block), 'P', new ItemStack(FronosBlocks.fronos_flower, 1, 7) });
			GameRegistry.addRecipe(new ItemStack(FronosItems.poison_arrow, 4), new Object[] { "P", "C", "S", 'C', new ItemStack(FronosItems.candy_cane, 1, 0), 'S', new ItemStack(FronosItems.fronos_item, 1, 8), 'P', new ItemStack(FronosBlocks.fronos_flower, 1, 5) });
			GameRegistry.addRecipe(new ItemStack(FronosItems.poison_arrow, 4), new Object[] { "P", "C", "S", 'C', new ItemStack(FronosItems.candy_cane, 1, 0), 'S', new ItemStack(FronosItems.fronos_item, 1, 8), 'P', new ItemStack(FronosBlocks.fronos_flower, 1, 7) });

			GameRegistry.addRecipe(new ItemStack(FronosToolsItems.candy_hoe), new Object[] { "XX", " Y", " Y", 'X', new ItemStack(FronosBlocks.candy_cane1, 1, 0), 'Y', new ItemStack(FronosItems.candy_cane, 1, 0) });
			GameRegistry.addRecipe(new ItemStack(FronosToolsItems.candy_axe), new Object[] { "XX", "XY", " Y", 'X', new ItemStack(FronosBlocks.candy_cane1, 1, 0), 'Y', new ItemStack(FronosItems.candy_cane, 1, 0) });
			GameRegistry.addRecipe(new ItemStack(FronosToolsItems.candy_pickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', new ItemStack(FronosBlocks.candy_cane1, 1, 0), 'Y', new ItemStack(FronosItems.candy_cane, 1, 0) });
			GameRegistry.addRecipe(new ItemStack(FronosToolsItems.candy_sword), new Object[] { "X", "X", "Y", 'X', new ItemStack(FronosBlocks.candy_cane1, 1, 0), 'Y', new ItemStack(FronosItems.candy_cane, 1, 0) });
			GameRegistry.addRecipe(new ItemStack(FronosToolsItems.candy_shovel), new Object[] { "X", "Y", "Y", 'X', new ItemStack(FronosBlocks.candy_cane1, 1, 0), 'Y', new ItemStack(FronosItems.candy_cane, 1, 0) });
		}
		else
		{
			RecipeUtil.addRecipe(new ItemStack(FronosItems.candy_bow), new Object[] { " CS", "C S", " CS", 'C', "candy", 'S', new ItemStack(FronosItems.fronos_item, 1, 9) });
			RecipeUtil.addRecipe(new ItemStack(FronosItems.poison_arrow, 4), new Object[] { "P", "C", "S", 'C', "candy", 'S', new ItemStack(FronosBlocks.cloud_block), 'P', new ItemStack(FronosBlocks.fronos_flower, 1, 5) });
			RecipeUtil.addRecipe(new ItemStack(FronosItems.poison_arrow, 4), new Object[] { "P", "C", "S", 'C', "candy", 'S', new ItemStack(FronosBlocks.cloud_block), 'P', new ItemStack(FronosBlocks.fronos_flower, 1, 7) });
			RecipeUtil.addRecipe(new ItemStack(FronosItems.poison_arrow, 4), new Object[] { "P", "C", "S", 'C', "candy", 'S', new ItemStack(FronosItems.fronos_item, 1, 8), 'P', new ItemStack(FronosBlocks.fronos_flower, 1, 5) });
			RecipeUtil.addRecipe(new ItemStack(FronosItems.poison_arrow, 4), new Object[] { "P", "C", "S", 'C', "candy", 'S', new ItemStack(FronosItems.fronos_item, 1, 8), 'P', new ItemStack(FronosBlocks.fronos_flower, 1, 7) });

			RecipeUtil.addRecipe(new ItemStack(FronosToolsItems.candy_hoe), new Object[] { "XX", " Y", " Y", 'X', "candyCane", 'Y', "candy" });
			RecipeUtil.addRecipe(new ItemStack(FronosToolsItems.candy_axe), new Object[] { "XX", "XY", " Y", 'X', "candyCane", 'Y', "candy" });
			RecipeUtil.addRecipe(new ItemStack(FronosToolsItems.candy_pickaxe), new Object[] { "XXX", " Y ", " Y ", 'X', "candyCane", 'Y', "candy" });
			RecipeUtil.addRecipe(new ItemStack(FronosToolsItems.candy_sword), new Object[] { "X", "X", "Y", 'X', "candyCane", 'Y', "candy" });
			RecipeUtil.addRecipe(new ItemStack(FronosToolsItems.candy_shovel), new Object[] { "X", "Y", "Y", 'X', "candyCane", 'Y', "candy" });
		}
	}

	private static void registerTier4RocketRecipe()
	{
		HashMap<Integer, ItemStack> input = new HashMap<Integer, ItemStack>();
		input.put(1, new ItemStack(DionaItems.tier_4_rocket_module, 1, 0));
		input.put(2, new ItemStack(DionaItems.tier_4_rocket_module, 1, 1));
		input.put(3, new ItemStack(DionaItems.tier_4_rocket_module, 1, 1));
		input.put(4, new ItemStack(DionaItems.tier_4_rocket_module, 1, 1));
		input.put(5, new ItemStack(DionaItems.tier_4_rocket_module, 1, 1));
		input.put(6, new ItemStack(DionaItems.tier_4_rocket_module, 1, 1));
		input.put(7, new ItemStack(DionaItems.tier_4_rocket_module, 1, 1));
		input.put(8, new ItemStack(DionaItems.tier_4_rocket_module, 1, 1));
		input.put(9, new ItemStack(DionaItems.tier_4_rocket_module, 1, 1));
		input.put(10, new ItemStack(DionaItems.tier_4_rocket_module, 1, 1));
		input.put(11, new ItemStack(DionaItems.tier_4_rocket_module, 1, 1));
		input.put(12, new ItemStack(DionaItems.tier_4_rocket_module, 1, 3));
		input.put(13, new ItemStack(AsteroidsItems.basicItem, 1, 2));
		input.put(14, new ItemStack(AsteroidsItems.basicItem, 1, 2));
		input.put(15, new ItemStack(DionaItems.tier_4_rocket_module, 1, 2));
		input.put(16, new ItemStack(DionaItems.tier_4_rocket_module, 1, 3));
		input.put(17, new ItemStack(AsteroidsItems.basicItem, 1, 2));
		input.put(18, new ItemStack(AsteroidsItems.basicItem, 1, 2));
		input.put(19, null);
		input.put(20, null);
		input.put(21, null);
		Tier4RocketRecipes.addTier4RocketRecipe(new ItemStack(DionaItems.tier_4_rocket, 1, 0), input);

		HashMap<Integer, ItemStack> input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, null);
		input2.put(21, null);
		Tier4RocketRecipes.addTier4RocketRecipe(new ItemStack(DionaItems.tier_4_rocket, 1, 1), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, null);
		Tier4RocketRecipes.addTier4RocketRecipe(new ItemStack(DionaItems.tier_4_rocket, 1, 1), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, null);
		input2.put(21, new ItemStack(Blocks.chest));
		Tier4RocketRecipes.addTier4RocketRecipe(new ItemStack(DionaItems.tier_4_rocket, 1, 1), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, null);
		Tier4RocketRecipes.addTier4RocketRecipe(new ItemStack(DionaItems.tier_4_rocket, 1, 2), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, null);
		input2.put(21, new ItemStack(Blocks.chest));
		Tier4RocketRecipes.addTier4RocketRecipe(new ItemStack(DionaItems.tier_4_rocket, 1, 2), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, new ItemStack(Blocks.chest));
		Tier4RocketRecipes.addTier4RocketRecipe(new ItemStack(DionaItems.tier_4_rocket, 1, 2), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, new ItemStack(Blocks.chest));
		Tier4RocketRecipes.addTier4RocketRecipe(new ItemStack(DionaItems.tier_4_rocket, 1, 3), input2);
	}

	private static void registerTier5RocketRecipe()
	{
		HashMap<Integer, ItemStack> input = new HashMap<Integer, ItemStack>();
		input.put(1, new ItemStack(DionaItems.tier_4_rocket_module, 1, 0));
		input.put(2, new ItemStack(DionaItems.diona_item, 1, 4));
		input.put(3, new ItemStack(DionaItems.diona_item, 1, 4));
		input.put(4, new ItemStack(DionaItems.diona_item, 1, 4));
		input.put(5, new ItemStack(DionaItems.diona_item, 1, 4));
		input.put(6, new ItemStack(DionaItems.diona_item, 1, 4));
		input.put(7, new ItemStack(DionaItems.diona_item, 1, 4));
		input.put(8, new ItemStack(DionaItems.diona_item, 1, 4));
		input.put(9, new ItemStack(DionaItems.diona_item, 1, 4));
		input.put(10, new ItemStack(DionaItems.diona_item, 1, 4));
		input.put(11, new ItemStack(DionaItems.diona_item, 1, 4));
		input.put(12, new ItemStack(DionaItems.tier_4_rocket_module, 1, 6));
		input.put(13, new ItemStack(AsteroidsItems.basicItem, 1, 2));
		input.put(14, new ItemStack(AsteroidsItems.basicItem, 1, 2));
		input.put(15, new ItemStack(DionaItems.tier_4_rocket_module, 1, 5));
		input.put(16, new ItemStack(DionaItems.tier_4_rocket_module, 1, 6));
		input.put(17, new ItemStack(AsteroidsItems.basicItem, 1, 2));
		input.put(18, new ItemStack(AsteroidsItems.basicItem, 1, 2));
		input.put(19, null);
		input.put(20, null);
		input.put(21, null);
		Tier5RocketRecipes.addTier5RocketBenchRecipe(new ItemStack(PolongniusItems.tier_5_rocket, 1, 0), input);

		HashMap<Integer, ItemStack> input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, null);
		input2.put(21, null);
		Tier5RocketRecipes.addTier5RocketBenchRecipe(new ItemStack(PolongniusItems.tier_5_rocket, 1, 1), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, null);
		Tier5RocketRecipes.addTier5RocketBenchRecipe(new ItemStack(PolongniusItems.tier_5_rocket, 1, 1), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, null);
		input2.put(21, new ItemStack(Blocks.chest));
		Tier5RocketRecipes.addTier5RocketBenchRecipe(new ItemStack(PolongniusItems.tier_5_rocket, 1, 1), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, null);
		Tier5RocketRecipes.addTier5RocketBenchRecipe(new ItemStack(PolongniusItems.tier_5_rocket, 1, 2), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, null);
		input2.put(21, new ItemStack(Blocks.chest));
		Tier5RocketRecipes.addTier5RocketBenchRecipe(new ItemStack(PolongniusItems.tier_5_rocket, 1, 2), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, new ItemStack(Blocks.chest));
		Tier5RocketRecipes.addTier5RocketBenchRecipe(new ItemStack(PolongniusItems.tier_5_rocket, 1, 2), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, new ItemStack(Blocks.chest));
		Tier5RocketRecipes.addTier5RocketBenchRecipe(new ItemStack(PolongniusItems.tier_5_rocket, 1, 3), input2);
	}

	private static void registerTier6RocketRecipe()
	{
		HashMap<Integer, ItemStack> input = new HashMap<Integer, ItemStack>();
		input.put(1, new ItemStack(DionaItems.tier_4_rocket_module, 1, 0));
		input.put(2, new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 2));
		input.put(3, new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 2));
		input.put(4, new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 2));
		input.put(5, new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 2));
		input.put(6, new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 2));
		input.put(7, new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 2));
		input.put(8, new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 2));
		input.put(9, new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 2));
		input.put(10, new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 2));
		input.put(11, new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 2));
		input.put(12, new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 1));
		input.put(13, new ItemStack(AsteroidsItems.basicItem, 1, 2));
		input.put(14, new ItemStack(AsteroidsItems.basicItem, 1, 2));
		input.put(15, new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 0));
		input.put(16, new ItemStack(PolongniusItems.tier_6_rocket_module, 1, 1));
		input.put(17, new ItemStack(AsteroidsItems.basicItem, 1, 2));
		input.put(18, new ItemStack(AsteroidsItems.basicItem, 1, 2));
		input.put(19, null);
		input.put(20, null);
		input.put(21, null);
		Tier6RocketRecipes.addTier6RocketBenchRecipe(new ItemStack(NibiruItems.tier_6_rocket, 1, 0), input);

		HashMap<Integer, ItemStack> input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, null);
		input2.put(21, null);
		Tier6RocketRecipes.addTier6RocketBenchRecipe(new ItemStack(NibiruItems.tier_6_rocket, 1, 1), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, null);
		Tier6RocketRecipes.addTier6RocketBenchRecipe(new ItemStack(NibiruItems.tier_6_rocket, 1, 1), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, null);
		input2.put(21, new ItemStack(Blocks.chest));
		Tier6RocketRecipes.addTier6RocketBenchRecipe(new ItemStack(NibiruItems.tier_6_rocket, 1, 1), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, null);
		Tier6RocketRecipes.addTier6RocketBenchRecipe(new ItemStack(NibiruItems.tier_6_rocket, 1, 2), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, null);
		input2.put(21, new ItemStack(Blocks.chest));
		Tier6RocketRecipes.addTier6RocketBenchRecipe(new ItemStack(NibiruItems.tier_6_rocket, 1, 2), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, new ItemStack(Blocks.chest));
		Tier6RocketRecipes.addTier6RocketBenchRecipe(new ItemStack(NibiruItems.tier_6_rocket, 1, 2), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, new ItemStack(Blocks.chest));
		Tier6RocketRecipes.addTier6RocketBenchRecipe(new ItemStack(NibiruItems.tier_6_rocket, 1, 3), input2);
	}

	private static void registerTier7RocketRecipe()
	{
		HashMap<Integer, ItemStack> input = new HashMap<Integer, ItemStack>();
		input.put(1, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 4));
		input.put(2, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2));
		input.put(3, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2));
		input.put(4, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2));
		input.put(5, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2));
		input.put(6, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2));
		input.put(7, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2));
		input.put(8, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2));
		input.put(9, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2));
		input.put(10, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2));
		input.put(11, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 2));//Plate
		input.put(12, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 1));//Booster
		input.put(13, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 3));
		input.put(14, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 3));
		input.put(15, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 0));//Engine
		input.put(16, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 1));
		input.put(17, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 3));
		input.put(18, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 3));
		input.put(19, null);
		input.put(20, null);
		input.put(21, null);
		Tier7RocketRecipes.addTier7RocketRecipe(new ItemStack(FronosItems.tier_7_rocket, 1, 0), input);

		HashMap<Integer, ItemStack> input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, null);
		input2.put(21, null);
		Tier7RocketRecipes.addTier7RocketRecipe(new ItemStack(FronosItems.tier_7_rocket, 1, 1), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, null);
		Tier7RocketRecipes.addTier7RocketRecipe(new ItemStack(FronosItems.tier_7_rocket, 1, 1), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, null);
		input2.put(21, new ItemStack(Blocks.chest));
		Tier7RocketRecipes.addTier7RocketRecipe(new ItemStack(FronosItems.tier_7_rocket, 1, 1), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, null);
		Tier7RocketRecipes.addTier7RocketRecipe(new ItemStack(FronosItems.tier_7_rocket, 1, 2), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, null);
		input2.put(21, new ItemStack(Blocks.chest));
		Tier7RocketRecipes.addTier7RocketRecipe(new ItemStack(FronosItems.tier_7_rocket, 1, 2), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, new ItemStack(Blocks.chest));
		Tier7RocketRecipes.addTier7RocketRecipe(new ItemStack(FronosItems.tier_7_rocket, 1, 2), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, new ItemStack(Blocks.chest));
		Tier7RocketRecipes.addTier7RocketRecipe(new ItemStack(FronosItems.tier_7_rocket, 1, 3), input2);
	}

	private static void registerTier8RocketRecipe()
	{
		HashMap<Integer, ItemStack> input = new HashMap<Integer, ItemStack>();
		input.put(1, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 4));//Nose Cone
		input.put(2, new ItemStack(FronosItems.tier_8_rocket_module, 1, 2));
		input.put(3, new ItemStack(FronosItems.tier_8_rocket_module, 1, 2));
		input.put(4, new ItemStack(FronosItems.tier_8_rocket_module, 1, 2));
		input.put(5, new ItemStack(FronosItems.tier_8_rocket_module, 1, 2));
		input.put(6, new ItemStack(FronosItems.tier_8_rocket_module, 1, 2));
		input.put(7, new ItemStack(FronosItems.tier_8_rocket_module, 1, 2));
		input.put(8, new ItemStack(FronosItems.tier_8_rocket_module, 1, 2));
		input.put(9, new ItemStack(FronosItems.tier_8_rocket_module, 1, 2));
		input.put(10, new ItemStack(FronosItems.tier_8_rocket_module, 1, 2));
		input.put(11, new ItemStack(FronosItems.tier_8_rocket_module, 1, 2));//Plate
		input.put(12, new ItemStack(FronosItems.tier_8_rocket_module, 1, 1));//Booster
		input.put(13, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 3));
		input.put(14, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 3));
		input.put(15, new ItemStack(FronosItems.tier_8_rocket_module, 1, 0));//Engine
		input.put(16, new ItemStack(FronosItems.tier_8_rocket_module, 1, 1));
		input.put(17, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 3));
		input.put(18, new ItemStack(NibiruItems.tier_7_rocket_module, 1, 3));
		input.put(19, null);
		input.put(20, null);
		input.put(21, null);
		Tier8RocketRecipes.addTier8RocketRecipe(new ItemStack(KapteynBItems.tier_8_rocket, 1, 0), input);

		HashMap<Integer, ItemStack> input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, null);
		input2.put(21, null);
		Tier8RocketRecipes.addTier8RocketRecipe(new ItemStack(KapteynBItems.tier_8_rocket, 1, 1), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, null);
		Tier8RocketRecipes.addTier8RocketRecipe(new ItemStack(KapteynBItems.tier_8_rocket, 1, 1), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, null);
		input2.put(21, new ItemStack(Blocks.chest));
		Tier8RocketRecipes.addTier8RocketRecipe(new ItemStack(KapteynBItems.tier_8_rocket, 1, 1), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, null);
		Tier8RocketRecipes.addTier8RocketRecipe(new ItemStack(KapteynBItems.tier_8_rocket, 1, 2), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, null);
		input2.put(21, new ItemStack(Blocks.chest));
		Tier8RocketRecipes.addTier8RocketRecipe(new ItemStack(KapteynBItems.tier_8_rocket, 1, 2), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, null);
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, new ItemStack(Blocks.chest));
		Tier8RocketRecipes.addTier8RocketRecipe(new ItemStack(KapteynBItems.tier_8_rocket, 1, 2), input2);

		input2 = new HashMap<Integer, ItemStack>(input);
		input2.put(19, new ItemStack(Blocks.chest));
		input2.put(20, new ItemStack(Blocks.chest));
		input2.put(21, new ItemStack(Blocks.chest));
		Tier8RocketRecipes.addTier8RocketRecipe(new ItemStack(KapteynBItems.tier_8_rocket, 1, 3), input2);
	}

	public static HashMap<Object, Integer> getMarsSpaceStationRecipe()
	{
		HashMap<Object, Integer> inputMap = new HashMap<Object, Integer>();
		inputMap.put("ingotTin", 64);
		inputMap.put(RecipeManagerGC.aluminumIngots, 24);
		inputMap.put("waferAdvanced", 3);
		inputMap.put("ingotIron", 48);
		return inputMap;
	}

	public static HashMap<Object, Integer> getJupiterSpaceStationRecipe()
	{
		HashMap<Object, Integer> inputMap = new HashMap<Object, Integer>();
		inputMap.put("ingotTin", 80);
		inputMap.put(RecipeManagerGC.aluminumIngots, 48);
		inputMap.put("waferAdvanced", 10);
		inputMap.put("ingotIron", 32);
		inputMap.put("ingotDesh", 16);
		return inputMap;
	}
}