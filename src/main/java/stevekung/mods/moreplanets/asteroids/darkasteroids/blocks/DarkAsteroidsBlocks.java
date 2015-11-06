/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.asteroids.darkasteroids.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.asteroids.darkasteroids.itemblocks.ItemBlockDarkAsteroids;
import stevekung.mods.stevecore.RegisterHelper;

public class DarkAsteroidsBlocks
{
	public static Block dark_asteroids_block;
	public static Block dark_asteroids_quicksand;

	public static void init()
	{
		// Init
		DarkAsteroidsBlocks.dark_asteroids_block = new BlockDarkAsteroids("dark_asteroids_block");
		DarkAsteroidsBlocks.dark_asteroids_quicksand = new BlockDarkAsteroidsQuicksand("dark_asteroids_quicksand");

		// Register
		RegisterHelper.registerBlock(DarkAsteroidsBlocks.dark_asteroids_block, ItemBlockDarkAsteroids.class);
		RegisterHelper.registerBlock(DarkAsteroidsBlocks.dark_asteroids_quicksand);

		// Set harvest level
		DarkAsteroidsBlocks.dark_asteroids_block.setHarvestLevel("pickaxe", 1);
		DarkAsteroidsBlocks.dark_asteroids_quicksand.setHarvestLevel("shovel", 0);

		// Register ore dictionary
		OreDictionary.registerOre("oreTin", new ItemStack(DarkAsteroidsBlocks.dark_asteroids_block, 1, 4));
		OreDictionary.registerOre("oreCopper", new ItemStack(DarkAsteroidsBlocks.dark_asteroids_block, 1, 5));
		OreDictionary.registerOre("oreIron", new ItemStack(DarkAsteroidsBlocks.dark_asteroids_block, 1, 6));
		OreDictionary.registerOre("oreDesh", new ItemStack(DarkAsteroidsBlocks.dark_asteroids_block, 1, 7));
	}
}