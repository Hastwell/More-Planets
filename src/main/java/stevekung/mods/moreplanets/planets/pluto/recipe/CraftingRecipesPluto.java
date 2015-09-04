/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.pluto.recipe;

import micdoodle8.mods.galacticraft.core.items.GCItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import stevekung.mods.moreplanets.planets.diona.items.DionaItems;
import stevekung.mods.moreplanets.planets.kapteynb.items.KapteynBItems;
import stevekung.mods.moreplanets.planets.mercury.items.MercuryItems;
import stevekung.mods.moreplanets.planets.pluto.blocks.PlutoBlocks;
import stevekung.mods.moreplanets.planets.pluto.items.PlutoItems;

public class CraftingRecipesPluto
{
	public static void loadRecipes()
	{
		CraftingRecipesPluto.addBlockRecipes();
		CraftingRecipesPluto.addItemRecipes();
		CraftingRecipesPluto.addBlockSmelting();
		CraftingRecipesPluto.addItemSmelting();
	}

	private static void addBlockRecipes()
	{
		// Blocks
		GameRegistry.addRecipe(new ItemStack(PlutoBlocks.xeonium_torch, 4), new Object[] { "X", "S", 'X', new ItemStack(PlutoItems.pluto_item, 1, 0), 'S', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(PlutoBlocks.xeonium_glowstone), new Object[] { "DD", "DD", 'D', new ItemStack(PlutoItems.xeonium_dust) });
	}

	private static void addItemRecipes()
	{
		// Items
		GameRegistry.addRecipe(new ItemStack(MercuryItems.mercury_item, 1, 7), new Object[] { "MCM", "CAC", "MCM", 'M', new ItemStack(MercuryItems.mercury_item, 1, 5), 'C', new ItemStack(MercuryItems.mercury_item, 1, 6), 'A', new ItemStack(GCItems.basicItem, 1, 14) });
		GameRegistry.addRecipe(new ItemStack(MercuryItems.mercury_item, 1, 6), new Object[] { "PRP", "RDR", "PRP", 'P', new ItemStack(MercuryItems.mercury_item, 1, 4), 'R', new ItemStack(Items.redstone), 'D', new ItemStack(Items.diamond) });
		GameRegistry.addRecipe(new ItemStack(MercuryItems.mercury_item, 1, 6), new Object[] { "PRP", "RDR", "PRP", 'P', new ItemStack(MercuryItems.mercury_item, 1, 5), 'R', new ItemStack(Items.redstone), 'D', new ItemStack(Items.diamond) });
		GameRegistry.addRecipe(new ItemStack(PlutoItems.gravity_boots), new Object[] { "P P", "G G", 'P', new ItemStack(MercuryItems.mercury_item, 1, 4), 'G', new ItemStack(MercuryItems.mercury_item, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(PlutoItems.gravity_boots), new Object[] { "P P", "G G", 'P', new ItemStack(MercuryItems.mercury_item, 1, 5), 'G', new ItemStack(MercuryItems.mercury_item, 1, 7) });
		GameRegistry.addRecipe(new ItemStack(DionaItems.laser_ammo, 8, 4), new Object[] { " E", "I ", 'I', new ItemStack(Items.iron_ingot), 'E', new ItemStack(KapteynBItems.kapteyn_b_item, 1, 5) });
		GameRegistry.addShapelessRecipe(new ItemStack(PlutoItems.xeonium_dust, 4), new ItemStack(PlutoItems.pluto_item, 1, 0) );
	}

	private static void addBlockSmelting()
	{
		GameRegistry.addSmelting(new ItemStack(PlutoBlocks.pluto_block, 1, 3), new ItemStack(PlutoBlocks.pluto_block, 1, 2), 0.4F);
	}

	private static void addItemSmelting()
	{
		GameRegistry.addSmelting(new ItemStack(PlutoBlocks.pluto_block, 1, 4), new ItemStack(GCItems.meteoricIronIngot), 0.8F);
		GameRegistry.addSmelting(new ItemStack(PlutoBlocks.pluto_block, 1, 5), new ItemStack(KapteynBItems.kapteyn_b_item, 1, 0), 0.8F);
		GameRegistry.addSmelting(new ItemStack(PlutoBlocks.pluto_block, 1, 6), new ItemStack(Items.iron_ingot), 0.8F);
		GameRegistry.addSmelting(new ItemStack(PlutoBlocks.pluto_block, 1, 7), new ItemStack(PlutoItems.pluto_item, 1, 0), 0.8F);
		GameRegistry.addSmelting(new ItemStack(PlutoItems.space_potato, 1, 0), new ItemStack(PlutoItems.space_potato, 1, 1), 0.5F);
	}
}