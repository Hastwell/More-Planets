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
	public static Block dark_asteroid_block;
	public static Block dark_asteroid_quicksand;
	public static Block alphere_ore;
	public static Block dark_air;

	public static void init()
	{
		// Init
		DarkAsteroidsBlocks.dark_asteroid_block = new BlockDarkAsteroids("dark_asteroid_block");
		DarkAsteroidsBlocks.dark_asteroid_quicksand = new BlockDarkAsteroidsQuicksand("dark_asteroid_quicksand");
		DarkAsteroidsBlocks.alphere_ore = new BlockAlphereOre("alphere_ore");
		DarkAsteroidsBlocks.dark_air = new BlockDarkAir("dark_air");

		// Register
		RegisterHelper.registerBlock(DarkAsteroidsBlocks.dark_asteroid_block, ItemBlockDarkAsteroids.class);
		RegisterHelper.registerBlock(DarkAsteroidsBlocks.alphere_ore);
		RegisterHelper.registerBlock(DarkAsteroidsBlocks.dark_asteroid_quicksand);
		RegisterHelper.registerBlock(DarkAsteroidsBlocks.dark_air);

		// Set harvest level
		DarkAsteroidsBlocks.dark_asteroid_block.setHarvestLevel("pickaxe", 1);
		DarkAsteroidsBlocks.alphere_ore.setHarvestLevel("pickaxe", 1);
		DarkAsteroidsBlocks.dark_asteroid_quicksand.setHarvestLevel("shovel", 0);

		// Register ore dictionary
		OreDictionary.registerOre("oreAluminum", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_block, 1, 3));
		OreDictionary.registerOre("oreAluminium", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_block, 1, 3));
		OreDictionary.registerOre("oreIlmenite", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_block, 1, 4));
		OreDictionary.registerOre("oreIron", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_block, 1, 5));
		OreDictionary.registerOre("oreMeteor", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_block, 1, 6));
		OreDictionary.registerOre("oreSilicon", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_block, 1, 7));
		OreDictionary.registerOre("oreDiamond", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_block, 1, 8));
		OreDictionary.registerOre("oreEmerald", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_block, 1, 9));
		OreDictionary.registerOre("oreLapis", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_block, 1, 10));
	}
}