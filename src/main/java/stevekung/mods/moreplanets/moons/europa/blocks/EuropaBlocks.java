/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.blocks.BlockBaseMP;
import stevekung.mods.moreplanets.common.blocks.BlockDoorMP;
import stevekung.mods.moreplanets.common.blocks.BlockDoorMP.DoorType;
import stevekung.mods.moreplanets.common.blocks.BlockFenceGateMP;
import stevekung.mods.moreplanets.common.blocks.BlockFenceMP;
import stevekung.mods.moreplanets.common.blocks.BlockSnowLayerMP;
import stevekung.mods.moreplanets.common.blocks.BlockStairsMP;
import stevekung.mods.moreplanets.common.blocks.fluid.FluidMP;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockInformation;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockMultiVariant;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockSingleLeaves;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockSnowLayerMP;
import stevekung.mods.moreplanets.common.util.ItemDescription;
import stevekung.mods.moreplanets.common.util.VariantsName;
import stevekung.mods.moreplanets.moons.europa.blocks.fluids.BlockFluidEuropaWater;
import stevekung.mods.moreplanets.moons.europa.itemblocks.ItemBlockEuropaLog;
import stevekung.mods.moreplanets.moons.europa.itemblocks.ItemBlockEuropaPrismarineSlab;
import stevekung.mods.moreplanets.moons.europa.itemblocks.ItemBlockEuropaSandstoneSlab;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class EuropaBlocks
{
    public static Block europa_ice;
    public static Block packed_europa_ice;
    public static Block europa_snow_block;
    public static Block europa_snow_layer;
    public static Block europa_prismarine;
    public static Block europa_sea_lantern;
    public static Block europa_ice_slush;
    public static Block europa_salt;
    public static Block europa_underwater_geyser;
    public static Block europa_water_bomb;
    public static Block europa_sapling;
    public static Block europa_log;
    public static Block europa_planks;
    public static Block europa_fence;
    public static Block europa_leaves;
    public static Block europa_water;
    public static Block europa_sand;
    public static Block europa_sandstone;
    public static Block half_europa_sandstone_slab;
    public static Block double_europa_sandstone_slab;
    public static Block europa_sandstone_stairs;
    public static Block europa_wood_stairs;
    public static Block europa_kelp;
    public static Block europa_fence_gate;
    public static Block europa_door_block;
    public static Block half_europa_prismarine_slab;
    public static Block double_europa_prismarine_slab;
    public static Block europa_prismarine_stairs;
    public static Block europa_prismarine_brick_stairs;
    public static Block dark_europa_prismarine_stairs;
    public static Block europa_sponge;

    public static Fluid europa_water_fluid;

    public static void init()
    {
        // Init
        EuropaBlocks.europa_ice = new BlockEuropaIce("europa_ice");
        EuropaBlocks.packed_europa_ice = new BlockPackedEuropaIce("packed_europa_ice");
        EuropaBlocks.europa_snow_block = new BlockEuropaSnowBlock("europa_snow_block");
        EuropaBlocks.europa_snow_layer = new BlockSnowLayerMP("europa_snow_layer", null, 0);
        EuropaBlocks.europa_prismarine = new BlockEuropaPrismarine("europa_prismarine");
        EuropaBlocks.europa_sea_lantern = new BlockEuropaSeaLantern("europa_sea_lantern");
        EuropaBlocks.europa_ice_slush = new BlockEuropaIceSlush("europa_ice_slush");
        EuropaBlocks.europa_salt = new BlockBaseMP("europa_salt", Material.rock).setHardness(1.5F);
        EuropaBlocks.europa_underwater_geyser = new BlockEuropaUnderwaterGeyser("europa_underwater_geyser");
        EuropaBlocks.europa_water_bomb = new BlockEuropaWaterBomb("europa_water_bomb");
        EuropaBlocks.europa_sapling = new BlockEuropaSapling("europa_sapling");
        EuropaBlocks.europa_log = new BlockEuropaLog("europa_log");
        EuropaBlocks.europa_leaves = new BlockEuropaLeaves("europa_leaves");
        EuropaBlocks.europa_planks = new BlockBaseMP("europa_planks", Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood);
        EuropaBlocks.europa_sand = new BlockEuropaSand("europa_sand");
        EuropaBlocks.europa_fence = new BlockFenceMP("europa_fence");
        EuropaBlocks.europa_sandstone = new BlockEuropaSandstone("europa_sandstone");
        EuropaBlocks.half_europa_sandstone_slab = new BlockEuropaSandstoneSlab("half_europa_sandstone_slab", Material.rock);
        EuropaBlocks.double_europa_sandstone_slab = new BlockDoubleEuropaSandstoneSlab("double_europa_sandstone_slab", Material.rock);
        EuropaBlocks.europa_sandstone_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "europa_sandstone_stairs", 0.8F);
        EuropaBlocks.europa_wood_stairs = new BlockStairsMP(Blocks.planks.getDefaultState(), "europa_wood_stairs", "wood", null, 2.0F);
        EuropaBlocks.europa_kelp = new BlockEuropaKelp("europa_kelp");
        EuropaBlocks.europa_fence_gate = new BlockFenceGateMP("europa_fence_gate");
        EuropaBlocks.europa_door_block = new BlockDoorMP("europa_door_block", DoorType.EUROPA);
        EuropaBlocks.half_europa_prismarine_slab = new BlockEuropaPrismarineSlab("half_europa_prismarine_slab", Material.rock);
        EuropaBlocks.double_europa_prismarine_slab = new BlockDoubleEuropaPrismarineSlab("double_europa_prismarine_slab", Material.rock);
        EuropaBlocks.europa_prismarine_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "europa_prismarine_stairs", 1.5F);
        EuropaBlocks.europa_prismarine_brick_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "europa_prismarine_brick_stairs", 1.5F);
        EuropaBlocks.dark_europa_prismarine_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "dark_europa_prismarine_stairs", 1.5F);
        EuropaBlocks.europa_sponge = new BlockEuropaSponge("europa_sponge");

        EuropaBlocks.europa_water_fluid = new FluidMP("europa_water_fluid").setBlock(EuropaBlocks.europa_water);
        FluidRegistry.registerFluid(EuropaBlocks.europa_water_fluid);
        EuropaBlocks.europa_water = new BlockFluidEuropaWater("europa_water_fluid");

        // Register
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_ice, ItemBlockMultiVariant.class, new VariantsName("ice", "dirty", "dense"));
        CommonRegisterHelper.registerBlock(EuropaBlocks.packed_europa_ice);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_snow_block);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_ice_slush);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_salt);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_underwater_geyser, ItemBlockMultiVariant.class, new VariantsName("default", "smoke"));
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_prismarine, ItemBlockMultiVariant.class, new VariantsName("prismarine", "prismarine_bricks", "dark_prismarine"));
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_sea_lantern);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_water_bomb);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_log, ItemBlockEuropaLog.class);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_planks);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_leaves, ItemBlockSingleLeaves.class);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_sponge, ItemBlockMultiVariant.class, new VariantsName("default", "wet"));
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_sand);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_sandstone, ItemBlockMultiVariant.class, new VariantsName("europa_sandstone", "chiseled_europa_sandstone", "smooth_europa_sandstone"));
        CommonRegisterHelper.registerBlock(EuropaBlocks.half_europa_sandstone_slab, ItemBlockEuropaSandstoneSlab.class, EuropaBlocks.half_europa_sandstone_slab, EuropaBlocks.double_europa_sandstone_slab);
        CommonRegisterHelper.registerBlock(EuropaBlocks.half_europa_prismarine_slab, ItemBlockEuropaPrismarineSlab.class, EuropaBlocks.half_europa_prismarine_slab, EuropaBlocks.double_europa_prismarine_slab);
        CommonRegisterHelper.registerBlock(EuropaBlocks.double_europa_sandstone_slab, ItemBlockEuropaSandstoneSlab.class, EuropaBlocks.half_europa_sandstone_slab, EuropaBlocks.double_europa_sandstone_slab);
        CommonRegisterHelper.registerBlock(EuropaBlocks.double_europa_prismarine_slab, ItemBlockEuropaPrismarineSlab.class, EuropaBlocks.half_europa_prismarine_slab, EuropaBlocks.double_europa_prismarine_slab);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_sandstone_stairs);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_prismarine_stairs);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_prismarine_brick_stairs);
        CommonRegisterHelper.registerBlock(EuropaBlocks.dark_europa_prismarine_stairs);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_wood_stairs);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_fence);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_fence_gate);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_snow_layer, ItemBlockSnowLayerMP.class, EuropaBlocks.europa_snow_layer);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_sapling, ItemBlockInformation.class, new VariantsName(new ItemDescription()
        {
            @Override
            public void addDescription(ItemStack itemStack, List list, boolean useLShift)
            {
                if (useLShift)
                {
                    list.add(EnumChatFormatting.GRAY + "Can be placed under an Europa Ice and Packed Europa Ice");
                    list.add(EnumChatFormatting.RED + "Note : When planted under an Europa Ice it need to grow manually");
                }
                else
                {
                    list.add("Press LSHIFT for more info");
                }
            }
        }));
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_kelp);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_water);
        CommonRegisterHelper.registerBlock(EuropaBlocks.europa_door_block);

        // Set harvest level
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.europa_snow_block, "shovel", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.europa_snow_layer, "shovel", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.europa_ice_slush, "shovel", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.europa_sand, "shovel", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.europa_prismarine, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.europa_salt, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.europa_underwater_geyser, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.half_europa_sandstone_slab, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.double_europa_sandstone_slab, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.europa_sandstone_stairs, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.europa_prismarine_stairs, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.europa_prismarine_brick_stairs, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.dark_europa_prismarine_stairs, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.half_europa_prismarine_slab, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.double_europa_prismarine_slab, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.europa_wood_stairs, "axe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.europa_log, "axe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.europa_planks, "axe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.europa_fence, "axe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.europa_fence_gate, "axe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(EuropaBlocks.europa_door_block, "axe", 0);

        // Set fire burn
        CommonRegisterHelper.setFireBurn(EuropaBlocks.europa_sapling, 60, 100);
        CommonRegisterHelper.setFireBurn(EuropaBlocks.europa_log, 5, 5);
        CommonRegisterHelper.setFireBurn(EuropaBlocks.europa_planks, 5, 20);
        CommonRegisterHelper.setFireBurn(EuropaBlocks.europa_fence, 5, 20);
        CommonRegisterHelper.setFireBurn(EuropaBlocks.europa_fence_gate, 5, 20);
        CommonRegisterHelper.setFireBurn(EuropaBlocks.europa_wood_stairs, 5, 20);
        CommonRegisterHelper.setFireBurn(EuropaBlocks.europa_leaves, 30, 60);

        // Register ore dictionary
        OreDictionary.registerOre("plankWood", new ItemStack(EuropaBlocks.europa_planks, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("stairWood", new ItemStack(EuropaBlocks.europa_wood_stairs));
        OreDictionary.registerOre("treeSapling", new ItemStack(EuropaBlocks.europa_sapling, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("treeLeaves", new ItemStack(EuropaBlocks.europa_leaves, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("logWood", new ItemStack(EuropaBlocks.europa_log, 1, OreDictionary.WILDCARD_VALUE));
    }
}