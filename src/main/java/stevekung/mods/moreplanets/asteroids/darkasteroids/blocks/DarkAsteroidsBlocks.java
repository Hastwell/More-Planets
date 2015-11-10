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
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockDirtMP;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockSingleLeaves;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class DarkAsteroidsBlocks
{
	public static Block dark_asteroid_rock;
	public static Block dark_asteroid_quicksand;
	public static Block alphere_ore;
	public static Block alien_grass;
	public static Block alien_dirt;
	public static Block alien_farmland;
	public static Block alien_log;
	public static Block alien_leaves;
	public static Block alien_glowstone;
	public static Block dark_air;

	public static void init()
	{
		// Init
		DarkAsteroidsBlocks.dark_asteroid_rock = new BlockDarkAsteroid("dark_asteroid_rock");
		DarkAsteroidsBlocks.dark_asteroid_quicksand = new BlockDarkAsteroidQuicksand("dark_asteroid_quicksand");
		DarkAsteroidsBlocks.alphere_ore = new BlockAlphereOre("alphere_ore");
		DarkAsteroidsBlocks.alien_grass = new BlockAlienGrass("alien_grass");
		DarkAsteroidsBlocks.alien_dirt = new BlockAlienDirt("alien_dirt");
		DarkAsteroidsBlocks.alien_farmland = new BlockAlienFarmland("alien_farmland");
		DarkAsteroidsBlocks.alien_log = new BlockAlienLog("alien_log");
		DarkAsteroidsBlocks.alien_leaves = new BlockAlienLeaves("alien_leaves");
		DarkAsteroidsBlocks.alien_glowstone = new BlockAlienGlowstone("alien_glowstone");
		DarkAsteroidsBlocks.dark_air = new BlockDarkAir("dark_air");

		// Register
		CommonRegisterHelper.registerBlock(DarkAsteroidsBlocks.dark_asteroid_rock, ItemBlockDarkAsteroids.class);
		CommonRegisterHelper.registerBlock(DarkAsteroidsBlocks.alphere_ore);
		CommonRegisterHelper.registerBlock(DarkAsteroidsBlocks.dark_asteroid_quicksand);
		CommonRegisterHelper.registerBlock(DarkAsteroidsBlocks.alien_grass);
		CommonRegisterHelper.registerBlock(DarkAsteroidsBlocks.alien_dirt, ItemBlockDirtMP.class);
		CommonRegisterHelper.registerBlock(DarkAsteroidsBlocks.alien_farmland);
		CommonRegisterHelper.registerBlock(DarkAsteroidsBlocks.alien_log);
		CommonRegisterHelper.registerBlock(DarkAsteroidsBlocks.alien_leaves, ItemBlockSingleLeaves.class);
		CommonRegisterHelper.registerBlock(DarkAsteroidsBlocks.alien_glowstone);
		CommonRegisterHelper.registerBlock(DarkAsteroidsBlocks.dark_air);

		// Set harvest level
		DarkAsteroidsBlocks.dark_asteroid_rock.setHarvestLevel("pickaxe", 0);
		DarkAsteroidsBlocks.alphere_ore.setHarvestLevel("pickaxe", 0);
		DarkAsteroidsBlocks.dark_asteroid_quicksand.setHarvestLevel("shovel", 0);
		DarkAsteroidsBlocks.alien_grass.setHarvestLevel("shovel", 0);
		DarkAsteroidsBlocks.alien_dirt.setHarvestLevel("shovel", 0);
		DarkAsteroidsBlocks.alien_farmland.setHarvestLevel("shovel", 0);
		DarkAsteroidsBlocks.alien_log.setHarvestLevel("axe", 0);

		// Register ore dictionary
		OreDictionary.registerOre("oreAluminum", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_rock, 1, 3));
		OreDictionary.registerOre("oreAluminium", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_rock, 1, 3));
		OreDictionary.registerOre("oreIlmenite", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_rock, 1, 4));
		OreDictionary.registerOre("oreIron", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_rock, 1, 5));
		OreDictionary.registerOre("oreMeteor", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_rock, 1, 6));
		OreDictionary.registerOre("oreSilicon", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_rock, 1, 7));
		OreDictionary.registerOre("oreDiamond", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_rock, 1, 8));
		OreDictionary.registerOre("oreEmerald", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_rock, 1, 9));
		OreDictionary.registerOre("oreLapis", new ItemStack(DarkAsteroidsBlocks.dark_asteroid_rock, 1, 10));
	}
}