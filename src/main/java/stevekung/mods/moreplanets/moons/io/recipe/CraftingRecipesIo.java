/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.io.recipe;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import stevekung.mods.moreplanets.moons.io.blocks.IoBlocks;
import stevekung.mods.moreplanets.planets.siriusb.items.SiriusBItems;

public class CraftingRecipesIo
{
	public static void loadRecipes()
	{
		CraftingRecipesIo.addBlockRecipes();
		CraftingRecipesIo.addItemRecipes();
		CraftingRecipesIo.addBlockSmelting();
		CraftingRecipesIo.addItemSmelting();
	}

	private static void addBlockRecipes()
	{

	}

	private static void addItemRecipes()
	{

	}

	private static void addBlockSmelting()
	{
		GameRegistry.addSmelting(new ItemStack(IoBlocks.io_block, 1, 3), new ItemStack(IoBlocks.io_block, 1, 2), 0.5F);
		GameRegistry.addSmelting(new ItemStack(IoBlocks.io_block, 1, 6), new ItemStack(IoBlocks.io_block, 1, 5), 0.5F);
	}

	private static void addItemSmelting()
	{
		GameRegistry.addSmelting(new ItemStack(IoBlocks.io_block, 1, 4), new ItemStack(SiriusBItems.sirius_b_item, 1, 3), 0.7F);
	}
}