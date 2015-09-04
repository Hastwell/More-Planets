/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.deimos.recipe;

import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import stevekung.mods.moreplanets.moons.deimos.blocks.DeimosBlocks;

public class CraftingRecipesDeimos
{
	public static void loadRecipes()
	{
		CraftingRecipesDeimos.addBlockRecipes();
		CraftingRecipesDeimos.addItemRecipes();
		CraftingRecipesDeimos.addBlockSmelting();
		CraftingRecipesDeimos.addItemSmelting();
	}

	private static void addBlockRecipes()
	{

	}

	private static void addItemRecipes()
	{

	}

	private static void addBlockSmelting()
	{
		GameRegistry.addSmelting(new ItemStack(DeimosBlocks.deimos_block, 1, 3), new ItemStack(DeimosBlocks.deimos_block, 1, 2), 0.5F);
	}

	private static void addItemSmelting()
	{
		GameRegistry.addSmelting(new ItemStack(DeimosBlocks.deimos_block, 1, 4), new ItemStack(GCItems.basicItem, 1, 4), 0.7F);
		GameRegistry.addSmelting(new ItemStack(DeimosBlocks.deimos_block, 1, 5), new ItemStack(GCItems.basicItem, 1, 3), 0.7F);
		GameRegistry.addSmelting(new ItemStack(DeimosBlocks.deimos_block, 1, 6), new ItemStack(Items.iron_ingot), 0.8F);
		GameRegistry.addSmelting(new ItemStack(DeimosBlocks.deimos_block, 1, 7), new ItemStack(MarsItems.marsItemBasic, 1, 2), 0.8F);
	}
}