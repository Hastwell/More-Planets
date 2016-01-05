/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.pluto.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.blocks.fluid.FluidMP;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockMultiVariant;
import stevekung.mods.moreplanets.common.util.VariantsName;
import stevekung.mods.moreplanets.planets.pluto.fluids.BlockFluidMethane;
import stevekung.mods.moreplanets.planets.pluto.fluids.BlockFluidNitrogen;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class PlutoBlocks
{
    public static Block pluto_block;
    public static Block xeonium_glowstone;
    public static Block xeonium_torch;
    public static Block frozen_methane_block;
    public static Block frozen_nitrogen_block;
    public static Block pluto_ancient_chest;
    public static Block pluto_treasure_chest;
    public static Block pluto_heart_crystal;
    public static Block space_potato_block;
    public static Block liquid_methane;
    public static Block liquid_nitrogen;

    public static Fluid liquid_methane_fluid;
    public static Fluid liquid_nitrogen_fluid;

    public static void init()
    {
        // Init
        PlutoBlocks.pluto_block = new BlockPluto("pluto_block");
        PlutoBlocks.xeonium_glowstone = new BlockXeoniumGlowstone("xeonium_glowstone");
        PlutoBlocks.xeonium_torch = new BlockXeoniumTorch("xeonium_torch");
        PlutoBlocks.frozen_methane_block = new BlockFrozenMethane("frozen_methane_block");
        PlutoBlocks.frozen_nitrogen_block = new BlockFrozenNitrogen("frozen_nitrogen_block");
        PlutoBlocks.pluto_ancient_chest = new BlockPlutoAncientChest("pluto_ancient_chest");
        PlutoBlocks.pluto_treasure_chest = new BlockPlutoTreasureChest("pluto_treasure_chest");
        PlutoBlocks.pluto_heart_crystal = new BlockPlutoHeartCrystal("pluto_heart_crystal_block");
        PlutoBlocks.space_potato_block = new BlockSpacePotato("space_potato_block");

        PlutoBlocks.liquid_methane_fluid = new FluidMP("liquid_methane_fluid", "moreplanets:blocks/liquid_gas_still", "moreplanets:blocks/liquid_gas_flowing").setBlock(PlutoBlocks.liquid_methane).setViscosity(3000);
        PlutoBlocks.liquid_nitrogen_fluid = new FluidMP("liquid_nitrogen_fluid").setBlock(PlutoBlocks.liquid_nitrogen).setViscosity(3000);
        FluidRegistry.registerFluid(PlutoBlocks.liquid_methane_fluid);
        FluidRegistry.registerFluid(PlutoBlocks.liquid_nitrogen_fluid);
        PlutoBlocks.liquid_methane = new BlockFluidMethane("liquid_methane_fluid");
        PlutoBlocks.liquid_nitrogen = new BlockFluidNitrogen("liquid_nitrogen_fluid");

        // Register
        CommonRegisterHelper.registerBlock(PlutoBlocks.pluto_block, ItemBlockMultiVariant.class, new VariantsName("surface_rock", "sub_surface_rock", "rock", "cobblestone", "meteoric_iron_ore", "frozen_iron_ore", "iron_ore", "xeonium_ore", "dungeon_brick", "surface_rock_brown", "surface_rock_light_brown"));
        CommonRegisterHelper.registerBlock(PlutoBlocks.xeonium_glowstone);
        CommonRegisterHelper.registerBlock(PlutoBlocks.frozen_methane_block);
        CommonRegisterHelper.registerBlock(PlutoBlocks.frozen_nitrogen_block);
        CommonRegisterHelper.registerBlock(PlutoBlocks.pluto_ancient_chest);
        CommonRegisterHelper.registerBlock(PlutoBlocks.pluto_treasure_chest);
        CommonRegisterHelper.registerBlock(PlutoBlocks.pluto_heart_crystal);
        CommonRegisterHelper.registerBlock(PlutoBlocks.xeonium_torch);
        CommonRegisterHelper.registerBlock(PlutoBlocks.liquid_methane);
        CommonRegisterHelper.registerBlock(PlutoBlocks.liquid_nitrogen);
        CommonRegisterHelper.registerBlock(PlutoBlocks.space_potato_block);

        // Set harvest level
        CommonRegisterHelper.setBlockHarvestLevel(PlutoBlocks.frozen_methane_block, "pickaxe", 1);
        CommonRegisterHelper.setBlockHarvestLevel(PlutoBlocks.frozen_nitrogen_block, "pickaxe", 1);
        CommonRegisterHelper.setBlockHarvestLevel(PlutoBlocks.pluto_heart_crystal, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(PlutoBlocks.pluto_ancient_chest, "axe", 0);

        // Register ore dictionary
        OreDictionary.registerOre("oreMeteor", new ItemStack(PlutoBlocks.pluto_block, 1, 4));
        OreDictionary.registerOre("oreFrozenIron", new ItemStack(PlutoBlocks.pluto_block, 1, 5));
        OreDictionary.registerOre("oreIron", new ItemStack(PlutoBlocks.pluto_block, 1, 6));
        OreDictionary.registerOre("oreXeonium", new ItemStack(PlutoBlocks.pluto_block, 1, 7));
    }
}