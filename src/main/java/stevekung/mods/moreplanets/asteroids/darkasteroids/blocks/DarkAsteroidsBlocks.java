/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.asteroids.darkasteroids.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.asteroids.darkasteroids.blocks.BlockAlienLeaves.AlienLeafCategory;
import stevekung.mods.moreplanets.asteroids.darkasteroids.blocks.BlockAlienLog.AlienLogCategory;
import stevekung.mods.moreplanets.asteroids.darkasteroids.itemblocks.ItemBlockAlienLeaves;
import stevekung.mods.moreplanets.asteroids.darkasteroids.itemblocks.ItemBlockDarkAsteroids;
import stevekung.mods.moreplanets.core.itemblocks.ItemBlockDirtMP;
import stevekung.mods.stevecore.RegisterHelper;

public class DarkAsteroidsBlocks
{
    public static Block dark_asteroid_block;
    public static Block dark_asteroid_quicksand;
    public static Block alphere_ore;
    public static Block alien_grass;
    public static Block alien_dirt;
    public static Block alien_farmland;
    public static Block alien_log;
    public static Block alien_planks;
    public static Block alien_leaves;
    public static BlockSapling alien_sapling;
    public static Block alien_glowstone;
    public static Block dark_air;

    public static void init()
    {
        // Init
        DarkAsteroidsBlocks.dark_asteroid_block = new BlockDarkAsteroids("dark_asteroid_block");
        DarkAsteroidsBlocks.dark_asteroid_quicksand = new BlockDarkAsteroidsQuicksand("dark_asteroid_quicksand");
        DarkAsteroidsBlocks.alphere_ore = new BlockAlphereOre("alphere_ore");
        DarkAsteroidsBlocks.alien_grass = new BlockAlienGrass("alien_grass");
        DarkAsteroidsBlocks.alien_dirt = new BlockAlienDirt("alien_dirt");
        DarkAsteroidsBlocks.alien_farmland = new BlockAlienFarmland("alien_farmland");
        DarkAsteroidsBlocks.alien_log = new BlockAlienLog("alien_log", AlienLogCategory.CAT1);
        DarkAsteroidsBlocks.alien_planks = new BlockAlienPlanks("alien_planks");
        DarkAsteroidsBlocks.alien_leaves = new BlockAlienLeaves("alien_leaves", AlienLeafCategory.CAT1);
        DarkAsteroidsBlocks.alien_sapling = new BlockAlienSapling("alien_sapling");
        DarkAsteroidsBlocks.alien_glowstone = new BlockAlienGlowstone("alien_glowstone");
        DarkAsteroidsBlocks.dark_air = new BlockDarkAir("dark_air");

        // Register
        RegisterHelper.registerBlock(DarkAsteroidsBlocks.dark_asteroid_block, ItemBlockDarkAsteroids.class);
        RegisterHelper.registerBlock(DarkAsteroidsBlocks.alphere_ore);
        RegisterHelper.registerBlock(DarkAsteroidsBlocks.dark_asteroid_quicksand);
        RegisterHelper.registerBlock(DarkAsteroidsBlocks.alien_grass);
        RegisterHelper.registerBlock(DarkAsteroidsBlocks.alien_dirt, ItemBlockDirtMP.class);
        RegisterHelper.registerBlock(DarkAsteroidsBlocks.alien_log);
        RegisterHelper.registerBlock(DarkAsteroidsBlocks.alien_planks);
        RegisterHelper.registerBlock(DarkAsteroidsBlocks.alien_glowstone);
        RegisterHelper.registerBlock(DarkAsteroidsBlocks.alien_leaves, ItemBlockAlienLeaves.class);
        RegisterHelper.registerBlock(DarkAsteroidsBlocks.alien_sapling);
        RegisterHelper.registerBlock(DarkAsteroidsBlocks.alien_farmland);
        RegisterHelper.registerBlock(DarkAsteroidsBlocks.dark_air);

        // Set harvest level
        DarkAsteroidsBlocks.dark_asteroid_block.setHarvestLevel("pickaxe", 0);
        DarkAsteroidsBlocks.alphere_ore.setHarvestLevel("pickaxe", 0);
        DarkAsteroidsBlocks.dark_asteroid_quicksand.setHarvestLevel("shovel", 0);
        DarkAsteroidsBlocks.alien_grass.setHarvestLevel("shovel", 0);
        DarkAsteroidsBlocks.alien_dirt.setHarvestLevel("shovel", 0);
        DarkAsteroidsBlocks.alien_farmland.setHarvestLevel("shovel", 0);
        DarkAsteroidsBlocks.alien_log.setHarvestLevel("axe", 0);
        DarkAsteroidsBlocks.alien_planks.setHarvestLevel("axe", 0);

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