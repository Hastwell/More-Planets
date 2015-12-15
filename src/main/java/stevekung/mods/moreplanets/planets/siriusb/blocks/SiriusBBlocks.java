/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.blocks.BlockBaseMP;
import stevekung.mods.moreplanets.common.blocks.BlockStairsMP;
import stevekung.mods.moreplanets.common.blocks.fluid.FluidMP;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockMultiVariant;
import stevekung.mods.moreplanets.common.util.VariantsName;
import stevekung.mods.moreplanets.planets.siriusb.fluids.BlockFluidSiriusLava;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class SiriusBBlocks
{
    public static BlockSiriusFire sirius_fire;
    public static Block sirius_b_block;
    public static Block sirius_blaze_egg;
    public static Block sirius_b_treasure_chest;
    public static Block sirius_b_ancient_chest;
    public static Block sirius_obsidian;
    public static Block sirius_b_carbon_cobblestone_stairs;
    public static Block sirius_b_dungeon_brick_stairs;
    public static Block sirius_glowstone;
    public static Block sirius_redstone_lamp_off;
    public static Block sirius_redstone_lamp_on;
    public static Block sirius_lava;

    public static Fluid sirius_lava_fluid;

    public static void init()
    {
        // Init
        SiriusBBlocks.sirius_b_block = new BlockSiriusB("sirius_b_block");
        SiriusBBlocks.sirius_blaze_egg = new BlockSiriusBlazeEgg("sirius_blaze_egg");
        SiriusBBlocks.sirius_b_treasure_chest = new BlockSiriusBTreasureChest("sirius_b_treasure_chest");
        SiriusBBlocks.sirius_fire = new BlockSiriusFire("sirius_fire");
        SiriusBBlocks.sirius_b_ancient_chest = new BlockSiriusBAncientChest("sirius_b_ancient_chest");
        SiriusBBlocks.sirius_obsidian = new BlockBaseMP("sirius_obsidian", Material.rock).setHardness(70.0F).setResistance(5000.0F).setLightLevel(1.0F);
        SiriusBBlocks.sirius_b_carbon_cobblestone_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "sirius_b_carbon_cobblestone_stairs", null, "sirius", 2.5F);
        SiriusBBlocks.sirius_b_dungeon_brick_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "sirius_b_dungeon_brick_stairs", null, "sirius", 4.0F);
        SiriusBBlocks.sirius_glowstone = new BlockSiriusGlowstone("sirius_glowstone");
        SiriusBBlocks.sirius_redstone_lamp_off = new BlockSiriusRedstoneLamp("sirius_redstone_lamp", false);
        SiriusBBlocks.sirius_redstone_lamp_on = new BlockSiriusRedstoneLamp("sirius_redstone_lamp_on", true);

        SiriusBBlocks.sirius_lava_fluid = new FluidMP("sirius_lava").setBlock(SiriusBBlocks.sirius_lava).setLuminosity(15).setDensity(3000).setViscosity(6000).setTemperature(1300);
        FluidRegistry.registerFluid(SiriusBBlocks.sirius_lava_fluid);
        SiriusBBlocks.sirius_lava = new BlockFluidSiriusLava("sirius_lava");

        // Register
        CommonRegisterHelper.registerBlock(SiriusBBlocks.sirius_b_block, ItemBlockMultiVariant.class, new VariantsName("surface_carbon", "sub_surface_carbon", "carbon_stone", "carbon_cobblestone", "sulfur_ore", "diamond_ore", "glowstone_ore", "black_spot", "sulfur_block", "dungeon_brick"));
        CommonRegisterHelper.registerBlock(SiriusBBlocks.sirius_obsidian);
        CommonRegisterHelper.registerBlock(SiriusBBlocks.sirius_glowstone);
        CommonRegisterHelper.registerBlock(SiriusBBlocks.sirius_redstone_lamp_off);
        CommonRegisterHelper.registerBlock(SiriusBBlocks.sirius_redstone_lamp_on);
        CommonRegisterHelper.registerBlock(SiriusBBlocks.sirius_b_ancient_chest);
        CommonRegisterHelper.registerBlock(SiriusBBlocks.sirius_b_treasure_chest);
        CommonRegisterHelper.registerBlock(SiriusBBlocks.sirius_blaze_egg);
        CommonRegisterHelper.registerBlock(SiriusBBlocks.sirius_b_carbon_cobblestone_stairs);
        CommonRegisterHelper.registerBlock(SiriusBBlocks.sirius_b_dungeon_brick_stairs);
        CommonRegisterHelper.registerBlock(SiriusBBlocks.sirius_fire);
        CommonRegisterHelper.registerBlock(SiriusBBlocks.sirius_lava);

        // Set harvest level
        CommonRegisterHelper.setBlockHarvestLevel(SiriusBBlocks.sirius_obsidian, "pickaxe", 3);
        CommonRegisterHelper.setBlockHarvestLevel(SiriusBBlocks.sirius_b_block, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(SiriusBBlocks.sirius_b_carbon_cobblestone_stairs, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(SiriusBBlocks.sirius_b_dungeon_brick_stairs, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(SiriusBBlocks.sirius_b_ancient_chest, "axe", 0);

        // Register ore dictionary
        OreDictionary.registerOre("oreSulfur", new ItemStack(SiriusBBlocks.sirius_b_block, 1, 4));
        OreDictionary.registerOre("oreDiamond", new ItemStack(SiriusBBlocks.sirius_b_block, 1, 5));
        OreDictionary.registerOre("oreSiriusGlowstone", new ItemStack(SiriusBBlocks.sirius_b_block, 1, 6));
        OreDictionary.registerOre("blockSulfur", new ItemStack(SiriusBBlocks.sirius_b_block, 1, 8));
    }
}