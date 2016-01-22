/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.asteroids.darkasteroids.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.blocks.BlockBaseMP;
import stevekung.mods.moreplanets.common.blocks.BlockFenceGateMP;
import stevekung.mods.moreplanets.common.blocks.BlockFenceMP;
import stevekung.mods.moreplanets.common.blocks.BlockStairsMP;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockMultiVariant;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockSingleLeaves;
import stevekung.mods.moreplanets.common.util.VariantsName;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class DarkAsteroidBlocks
{
    public static Block dark_asteroid_rock;
    public static Block dark_asteroid_quicksand;
    public static Block alphere_ore;
    public static Block alien_grass;
    public static Block alien_dirt;
    public static Block alien_farmland;
    public static Block alien_log;
    public static Block alien_planks;
    public static Block alien_leaves;
    public static Block alien_sapling;
    public static Block alien_glowstone;
    public static Block alien_vine;
    public static Block dark_air;
    public static Block alien_wood_stairs;
    public static Block alien_fence;
    public static Block alien_fence_gate;

    public static void init()
    {
        // Init
        DarkAsteroidBlocks.dark_asteroid_rock = new BlockDarkAsteroid("dark_asteroid_rock");
        DarkAsteroidBlocks.dark_asteroid_quicksand = new BlockDarkAsteroidQuicksand("dark_asteroid_quicksand");
        DarkAsteroidBlocks.alphere_ore = new BlockAlphereOre("alphere_ore");
        DarkAsteroidBlocks.alien_grass = new BlockAlienGrass("alien_grass");
        DarkAsteroidBlocks.alien_dirt = new BlockAlienDirt("alien_dirt");
        DarkAsteroidBlocks.alien_farmland = new BlockAlienFarmland("alien_farmland");
        DarkAsteroidBlocks.alien_log = new BlockAlienLog("alien_log");
        DarkAsteroidBlocks.alien_planks = new BlockBaseMP("alien_planks", Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood);
        DarkAsteroidBlocks.alien_leaves = new BlockAlienLeaves("alien_leaves");
        DarkAsteroidBlocks.alien_sapling = new BlockAlienSapling("alien_sapling");
        DarkAsteroidBlocks.alien_glowstone = new BlockAlienGlowstone("alien_glowstone");
        DarkAsteroidBlocks.alien_vine = new BlockAlienVine("alien_vine");
        DarkAsteroidBlocks.dark_air = new BlockDarkAir("dark_air");
        DarkAsteroidBlocks.alien_wood_stairs = new BlockStairsMP(Blocks.planks, "alien_wood_stairs", "wood", null, 2.0F);
        DarkAsteroidBlocks.alien_fence = new BlockFenceMP("alien_fence");
        DarkAsteroidBlocks.alien_fence_gate = new BlockFenceGateMP("alien_fence_gate");

        // Register
        CommonRegisterHelper.registerBlock(DarkAsteroidBlocks.dark_asteroid_rock, ItemBlockMultiVariant.class, new VariantsName("rock", "rock", "rock", "aluminum_ore", "ilmenite_ore", "iron_ore", "meteoric_iron_ore", "silicon_ore", "diamond_ore", "emerald_ore", "lapis_ore"));
        CommonRegisterHelper.registerBlock(DarkAsteroidBlocks.alphere_ore);
        CommonRegisterHelper.registerBlock(DarkAsteroidBlocks.dark_asteroid_quicksand);
        CommonRegisterHelper.registerBlock(DarkAsteroidBlocks.alien_grass);
        CommonRegisterHelper.registerBlock(DarkAsteroidBlocks.alien_dirt, ItemBlockMultiVariant.class, new VariantsName("dirt", "coarse"));
        CommonRegisterHelper.registerBlock(DarkAsteroidBlocks.alien_log);
        CommonRegisterHelper.registerBlock(DarkAsteroidBlocks.alien_planks);
        CommonRegisterHelper.registerBlock(DarkAsteroidBlocks.alien_glowstone);
        CommonRegisterHelper.registerBlock(DarkAsteroidBlocks.alien_leaves, ItemBlockSingleLeaves.class);
        CommonRegisterHelper.registerBlock(DarkAsteroidBlocks.alien_wood_stairs);
        CommonRegisterHelper.registerBlock(DarkAsteroidBlocks.alien_fence);
        CommonRegisterHelper.registerBlock(DarkAsteroidBlocks.alien_fence_gate);
        CommonRegisterHelper.registerBlock(DarkAsteroidBlocks.alien_sapling);
        CommonRegisterHelper.registerBlock(DarkAsteroidBlocks.alien_vine);
        CommonRegisterHelper.registerBlock(DarkAsteroidBlocks.alien_farmland);
        CommonRegisterHelper.registerBlock(DarkAsteroidBlocks.dark_air);

        // Set harvest level
        CommonRegisterHelper.setBlockHarvestLevel(DarkAsteroidBlocks.alphere_ore, "pickaxe", 2);
        CommonRegisterHelper.setBlockHarvestLevel(DarkAsteroidBlocks.dark_asteroid_quicksand, "shovel", 0);
        CommonRegisterHelper.setBlockHarvestLevel(DarkAsteroidBlocks.alien_grass, "shovel", 0);
        CommonRegisterHelper.setBlockHarvestLevel(DarkAsteroidBlocks.alien_dirt, "shovel", 0);
        CommonRegisterHelper.setBlockHarvestLevel(DarkAsteroidBlocks.alien_farmland, "shovel", 0);
        CommonRegisterHelper.setBlockHarvestLevel(DarkAsteroidBlocks.alien_log, "axe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(DarkAsteroidBlocks.alien_planks, "axe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(DarkAsteroidBlocks.alien_wood_stairs, "axe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(DarkAsteroidBlocks.alien_fence, "axe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(DarkAsteroidBlocks.alien_fence_gate, "axe", 0);

        // Set fire burn
        CommonRegisterHelper.setFireBurn(DarkAsteroidBlocks.alien_sapling, 60, 100);
        CommonRegisterHelper.setFireBurn(DarkAsteroidBlocks.alien_log, 5, 5);
        CommonRegisterHelper.setFireBurn(DarkAsteroidBlocks.alien_planks, 5, 20);
        CommonRegisterHelper.setFireBurn(DarkAsteroidBlocks.alien_vine, 15, 100);
        CommonRegisterHelper.setFireBurn(DarkAsteroidBlocks.alien_fence, 5, 20);
        CommonRegisterHelper.setFireBurn(DarkAsteroidBlocks.alien_fence_gate, 5, 20);
        CommonRegisterHelper.setFireBurn(DarkAsteroidBlocks.alien_wood_stairs, 5, 20);
        CommonRegisterHelper.setFireBurn(DarkAsteroidBlocks.alien_leaves, 30, 60);

        // Register ore dictionary
        OreDictionary.registerOre("oreAluminum", new ItemStack(DarkAsteroidBlocks.dark_asteroid_rock, 1, 3));
        OreDictionary.registerOre("oreAluminium", new ItemStack(DarkAsteroidBlocks.dark_asteroid_rock, 1, 3));
        OreDictionary.registerOre("oreIlmenite", new ItemStack(DarkAsteroidBlocks.dark_asteroid_rock, 1, 4));
        OreDictionary.registerOre("oreIron", new ItemStack(DarkAsteroidBlocks.dark_asteroid_rock, 1, 5));
        OreDictionary.registerOre("oreMeteor", new ItemStack(DarkAsteroidBlocks.dark_asteroid_rock, 1, 6));
        OreDictionary.registerOre("oreSilicon", new ItemStack(DarkAsteroidBlocks.dark_asteroid_rock, 1, 7));
        OreDictionary.registerOre("oreDiamond", new ItemStack(DarkAsteroidBlocks.dark_asteroid_rock, 1, 8));
        OreDictionary.registerOre("oreEmerald", new ItemStack(DarkAsteroidBlocks.dark_asteroid_rock, 1, 9));
        OreDictionary.registerOre("oreLapis", new ItemStack(DarkAsteroidBlocks.dark_asteroid_rock, 1, 10));
        OreDictionary.registerOre("plankWood", new ItemStack(DarkAsteroidBlocks.alien_planks, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("stairWood", new ItemStack(DarkAsteroidBlocks.alien_wood_stairs));
        OreDictionary.registerOre("treeSapling", new ItemStack(DarkAsteroidBlocks.alien_sapling, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("treeLeaves", new ItemStack(DarkAsteroidBlocks.alien_leaves, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("logWood", new ItemStack(DarkAsteroidBlocks.alien_log, 1, OreDictionary.WILDCARD_VALUE));
    }
}