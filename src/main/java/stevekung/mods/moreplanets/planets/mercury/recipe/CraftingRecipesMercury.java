/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.mercury.recipe;

import micdoodle8.mods.galacticraft.core.items.GCItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import stevekung.mods.moreplanets.core.init.MPBlocks;
import stevekung.mods.moreplanets.planets.mercury.blocks.MercuryBlocks;
import stevekung.mods.moreplanets.planets.mercury.items.MercuryItems;

public class CraftingRecipesMercury
{
	public static void loadRecipes()
	{
		CraftingRecipesMercury.addBlockRecipes();
		CraftingRecipesMercury.addItemRecipes();
		CraftingRecipesMercury.addBlockSmelting();
		CraftingRecipesMercury.addItemSmelting();
	}

	private static void addBlockRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(MercuryBlocks.mercury_block, 1, 10), new Object[] { "CCC", "CCC", "CCC", 'C', new ItemStack(MercuryItems.mercury_item, 1, 3) });

		// Mercury Cobblestone Stairs
		GameRegistry.addRecipe(new ItemStack(MercuryBlocks.mercury_cobblestone_stairs, 4), new Object[] { "  X", " XX", "XXX", 'X', new ItemStack(MercuryBlocks.mercury_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MercuryBlocks.mercury_cobblestone_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(MercuryBlocks.mercury_block, 1, 3) });

		// Mercury Dungeon Brick Stairs
		GameRegistry.addRecipe(new ItemStack(MercuryBlocks.mercury_dungeon_brick_stairs, 4), new Object[] { "  X", " XX", "XXX", 'X', new ItemStack(MercuryBlocks.mercury_block, 1, 11) });
		GameRegistry.addRecipe(new ItemStack(MercuryBlocks.mercury_dungeon_brick_stairs, 4), new Object[] { "X  ", "XX ", "XXX", 'X', new ItemStack(MercuryBlocks.mercury_block, 1, 11) });

		// Slabs
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_stone_slab_2, 6, 5), new Object[] { "XXX", 'X', new ItemStack(MercuryBlocks.mercury_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.half_dungeon_brick_slab_1, 6, 7), new Object[] { "XXX", 'X', new ItemStack(MercuryBlocks.mercury_block, 1, 11) });

		// Walls
		GameRegistry.addRecipe(new ItemStack(MPBlocks.stone_wall, 6, 13), new Object[] { "XXX", "XXX", 'X', new ItemStack(MercuryBlocks.mercury_block, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(MPBlocks.dungeon_brick_wall, 6, 7), new Object[] { "XXX", "XXX", 'X', new ItemStack(MercuryBlocks.mercury_block, 1, 11) });
	}

	private static void addItemRecipes()
	{

	}

	private static void addBlockSmelting()
	{
		GameRegistry.addSmelting(new ItemStack(MercuryBlocks.mercury_block, 1, 3), new ItemStack(MercuryBlocks.mercury_block, 1, 2), 0.4F);
	}

	private static void addItemSmelting()
	{
		GameRegistry.addSmelting(new ItemStack(MercuryBlocks.mercury_block, 1, 4), new ItemStack(GCItems.basicItem, 1, 4), 0.75F);
		GameRegistry.addSmelting(new ItemStack(MercuryBlocks.mercury_block, 1, 5), new ItemStack(GCItems.basicItem, 1, 3), 0.75F);
		GameRegistry.addSmelting(new ItemStack(MercuryBlocks.mercury_block, 1, 6), new ItemStack(GCItems.basicItem, 1, 5), 0.75F);
		GameRegistry.addSmelting(new ItemStack(MercuryBlocks.mercury_block, 1, 7), new ItemStack(Items.iron_ingot), 0.75F);
		GameRegistry.addSmelting(new ItemStack(MercuryBlocks.mercury_block, 1, 8), new ItemStack(MercuryItems.mercury_item, 1, 3), 0.75F);
		GameRegistry.addSmelting(new ItemStack(MercuryBlocks.metallic_rock), new ItemStack(MercuryItems.mercury_item, 1, 2), 0.75F);
		GameRegistry.addSmelting(new ItemStack(MercuryItems.mercury_item, 1, 0), new ItemStack(MercuryItems.mercury_item, 1, 2), 0.75F);
		GameRegistry.addSmelting(new ItemStack(MercuryItems.mercury_item, 1, 1), new ItemStack(MercuryItems.mercury_item, 1, 3), 0.75F);
	}
}