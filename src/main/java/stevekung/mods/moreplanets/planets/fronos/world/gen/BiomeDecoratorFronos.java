/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.world.gen;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import stevekung.mods.moreplanets.common.world.biome.BiomeDecoratorMP;
import stevekung.mods.moreplanets.common.world.gen.feature.WorldGenLiquidLakes;
import stevekung.mods.moreplanets.common.world.gen.feature.WorldGenTreeMP;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockCavernOyster;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockDandelion;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockFronosCloud;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockFronosFlower;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockFronosSand;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockFronosTallGrass;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockFrostedCake;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockPoppy;
import stevekung.mods.moreplanets.planets.fronos.blocks.BlockSpaceOyster;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenCandyCane1;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenCandyCane2;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenCandyFlower;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenCavernOyster;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenClayFronos;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenCloud;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenFronosCoral;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenFronosDungeons;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenFronosFlowers;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenFronosMelon;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenFronosPumpkin;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenFronosSand;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenFronosTallGrass;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenFrostedCake;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenMapleIvy;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenSpaceOyster;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenSpaceShell;
import stevekung.mods.moreplanets.planets.fronos.worldgen.tree.WorldGenCoconutTree;
import stevekung.mods.stevecore.BlockStateHelper;

public class BiomeDecoratorFronos extends BiomeDecoratorMP
{
    public int waterlilyPerChunk;
    public int frostedCakePerChunk;
    public int pinkButterCupPerChunk;
    public int orangeFlowerPerChunk;
    public int goldMilkCapPerChunk;
    public int littleSunFlowerPerChunk;
    public int skyMushroomPerChunk;
    public int purpleSpikeFlowerPerChunk;
    public int jungleIrisPerChunk;
    public int bluePoisonMushroomPerChunk;
    public int whiteMossPerChunk;
    public int candyFlowerPerChunk;
    public int coralPerChunk;
    public int oysterPerChunk;
    public int oysterClosePerChunk;
    public int spaceShellPerChunk;
    public int mapleIvyPerChunk;
    public int candyCanePerChunk;
    public int coconutTreePerChunk;
    public int redMapleTreePerChunk;
    public int yellowMapleTreePerChunk;
    public int purpleMapleTreePerChunk;
    public int dandelionPerChunk;
    public int poppyPerChunk;
    public int deadBushPerChunk;
    public int reedsPerChunk;
    public int clayPerChunk;
    public int fronosTallGrassPerChunk;
    public int pinkTallGrassPerChunk;
    public int purpleTallGrassPerChunk;
    public int plainsTallGrassPerChunk;
    public int goldenTallGrassPerChunk;
    public int normalSandPerChunk;
    public int fronosSandPerChunk;
    public int whiteSandPerChunk;
    public int cheeseSandPerChunk;
    public int gravelPerChunk;
    public int lakesPerChunk;
    public int dungeonSpawnerPerChunk;
    public int strawberryCloudPerChunk;
    public int rainbowCloudPerChunk;

    @Override
    protected void genDecorations(BiomeGenBase biome)
    {
        int x;
        int y;
        int z;
        int i;
        BlockPos pos;

        // Clay
        for (i = 0; i < this.clayPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenClayFronos(4).generate(this.currentWorld, this.randomGenerator, this.currentWorld.getTopSolidOrLiquidBlock(this.field_180294_c.add(x, 0, z)));
        }

        // Sand
        for (i = 0; i < this.normalSandPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosSand(Blocks.sand.getDefaultState(), 6).generate(this.currentWorld, this.randomGenerator, this.currentWorld.getTopSolidOrLiquidBlock(this.field_180294_c.add(x, 0, z)));
        }
        for (i = 0; i < this.fronosSandPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosSand(FronosBlocks.fronos_sand.getDefaultState(), 4).generate(this.currentWorld, this.randomGenerator, this.currentWorld.getTopSolidOrLiquidBlock(this.field_180294_c.add(x, 0, z)));
        }
        for (i = 0; i < this.whiteSandPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosSand(FronosBlocks.fronos_sand.getDefaultState().withProperty(BlockFronosSand.VARIANT, BlockFronosSand.BlockType.white_sand), 6).generate(this.currentWorld, this.randomGenerator, this.currentWorld.getTopSolidOrLiquidBlock(this.field_180294_c.add(x, 0, z)));
        }
        for (i = 0; i < this.cheeseSandPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosSand(FronosBlocks.fronos_sand.getDefaultState().withProperty(BlockFronosSand.VARIANT, BlockFronosSand.BlockType.cheese_sand), 4).generate(this.currentWorld, this.randomGenerator, this.currentWorld.getTopSolidOrLiquidBlock(this.field_180294_c.add(x, 0, z)));
        }
        for (i = 0; i < this.gravelPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosSand(Blocks.gravel.getDefaultState(), 6).generate(this.currentWorld, this.randomGenerator, this.currentWorld.getTopSolidOrLiquidBlock(this.field_180294_c.add(x, 0, z)));
        }

        // Lake
        for (i = 0; i < this.lakesPerChunk; ++i)
        {
            if (this.randomGenerator.nextInt(1) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(this.randomGenerator.nextInt(240) + 8);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenLiquidLakes(Blocks.water, FronosBlocks.fronos_block, 0).generate(this.currentWorld, this.randomGenerator, pos);
            }
            if (this.randomGenerator.nextInt(8) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(this.randomGenerator.nextInt(240) + 8);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenLiquidLakes(FronosBlocks.mineral_water, FronosBlocks.fronos_block, 0).generate(this.currentWorld, this.randomGenerator, pos);
            }
            if (this.randomGenerator.nextInt(10) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(48 - 16) + 16;
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenLiquidLakes(FronosBlocks.caramel, FronosBlocks.fronos_block, 0).generate(this.currentWorld, this.randomGenerator, pos);
            }
        }

        for (i = 0; i < this.lakesPerChunk; ++i)
        {
            if (this.randomGenerator.nextInt(5) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(this.randomGenerator.nextInt(this.randomGenerator.nextInt(112) + 8) + 8);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenLiquidLakes(Blocks.lava, FronosBlocks.fronos_block, 0).generate(this.currentWorld, this.randomGenerator, pos);
            }
        }

        // Dandelion
        for (i = 0; i < this.dandelionPerChunk; ++i)
        {
            if (this.randomGenerator.nextInt(4) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(256);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenFronosFlowers(FronosBlocks.fronos_dandelion, BlockDandelion.VARIANT, BlockDandelion.BlockType.young_orange_dandelion).generate(this.currentWorld, this.randomGenerator, pos);
            }
            if (this.randomGenerator.nextInt(4) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(256);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenFronosFlowers(FronosBlocks.fronos_dandelion, BlockDandelion.VARIANT, BlockDandelion.BlockType.young_pink_dandelion).generate(this.currentWorld, this.randomGenerator, pos);
            }
            if (this.randomGenerator.nextInt(4) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(256);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenFronosFlowers(FronosBlocks.fronos_dandelion, BlockDandelion.VARIANT, BlockDandelion.BlockType.young_purple_dandelion).generate(this.currentWorld, this.randomGenerator, pos);
            }
            if (this.randomGenerator.nextInt(8) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(256);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenFronosFlowers(FronosBlocks.fronos_dandelion, BlockDandelion.VARIANT, BlockDandelion.BlockType.orange_dandelion).generate(this.currentWorld, this.randomGenerator, pos);
            }
            if (this.randomGenerator.nextInt(8) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(256);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenFronosFlowers(FronosBlocks.fronos_dandelion, BlockDandelion.VARIANT, BlockDandelion.BlockType.pink_dandelion).generate(this.currentWorld, this.randomGenerator, pos);
            }
            if (this.randomGenerator.nextInt(8) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(256);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenFronosFlowers(FronosBlocks.fronos_dandelion, BlockDandelion.VARIANT, BlockDandelion.BlockType.purple_dandelion).generate(this.currentWorld, this.randomGenerator, pos);
            }
        }

        // Poppy
        for (i = 0; i < this.poppyPerChunk; ++i)
        {
            if (this.randomGenerator.nextInt(8) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(256);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenFronosFlowers(FronosBlocks.fronos_poppy, BlockPoppy.VARIANT, BlockPoppy.BlockType.white_poppy).generate(this.currentWorld, this.randomGenerator, pos);
            }
            if (this.randomGenerator.nextInt(8) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(256);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenFronosFlowers(FronosBlocks.fronos_poppy, BlockPoppy.VARIANT, BlockPoppy.BlockType.orange_poppy).generate(this.currentWorld, this.randomGenerator, pos);
            }
            if (this.randomGenerator.nextInt(8) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(256);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenFronosFlowers(FronosBlocks.fronos_poppy, BlockPoppy.VARIANT, BlockPoppy.BlockType.purple_poppy).generate(this.currentWorld, this.randomGenerator, pos);
            }
        }

        // Candy Cane
        for (i = 0; i < this.candyCanePerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenCandyCane1().generate(this.currentWorld, this.randomGenerator, pos);
        }
        for (i = 0; i < this.candyCanePerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenCandyCane2().generate(this.currentWorld, this.randomGenerator, pos);
        }

        // Oyster
        for (i = 0; i < this.oysterPerChunk; ++i)
        {
            if (this.randomGenerator.nextInt(1) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(256);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenSpaceOyster(FronosBlocks.space_oyster.getDefaultState().withProperty(BlockSpaceOyster.OPEN, true).withProperty(BlockStateHelper.FACING, EnumFacing.Plane.HORIZONTAL.random(this.randomGenerator))).generate(this.currentWorld, this.randomGenerator, pos);
            }
            if (this.randomGenerator.nextInt(1000) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(32 - 16) + 16;
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenCavernOyster(FronosBlocks.cavern_oyster.getDefaultState().withProperty(BlockCavernOyster.OPEN, true).withProperty(BlockStateHelper.FACING, EnumFacing.Plane.HORIZONTAL.random(this.randomGenerator))).generate(this.currentWorld, this.randomGenerator, pos);
            }
        }
        for (i = 0; i < this.oysterClosePerChunk; ++i)
        {
            if (this.randomGenerator.nextInt(1) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(256);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenSpaceOyster(FronosBlocks.space_oyster.getDefaultState().withProperty(BlockSpaceOyster.OPEN, false).withProperty(BlockStateHelper.FACING, EnumFacing.Plane.HORIZONTAL.random(this.randomGenerator))).generate(this.currentWorld, this.randomGenerator, pos);
            }
            if (this.randomGenerator.nextInt(1000) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(32 - 16) + 16;
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenCavernOyster(FronosBlocks.cavern_oyster.getDefaultState().withProperty(BlockCavernOyster.OPEN, false).withProperty(BlockStateHelper.FACING, EnumFacing.Plane.HORIZONTAL.random(this.randomGenerator))).generate(this.currentWorld, this.randomGenerator, pos);
            }
        }

        // Tree
        for (i = 0; i < this.coconutTreePerChunk; ++i)
        {
            if (this.randomGenerator.nextInt(4) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(256);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenCoconutTree(35, 10, 1.3D).generate(this.currentWorld, this.randomGenerator, pos);
            }
        }

        int chance;
        chance = this.redMapleTreePerChunk;

        if (this.randomGenerator.nextInt(10) == 0)
        {
            ++chance;
        }

        for (i = 0; i < chance; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.currentWorld.getHorizon(this.field_180294_c.add(x, 0, z));
            WorldGenTreeMP tree = new WorldGenTreeMP(4, FronosBlocks.fronos_log, FronosBlocks.fronos_leaves, 1, 0, true, FronosBlocks.fronos_sapling, FronosBlocks.red_maple_ivy);
            tree.func_175904_e();
            tree.generate(this.currentWorld, this.randomGenerator, pos);
        }

        chance = this.yellowMapleTreePerChunk;

        for (i = 0; i < chance; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.currentWorld.getHorizon(this.field_180294_c.add(x, 0, z));
            WorldGenTreeMP tree = new WorldGenTreeMP(4, FronosBlocks.fronos_log, FronosBlocks.fronos_leaves, 1, 1, true, FronosBlocks.fronos_sapling, FronosBlocks.yellow_maple_ivy);
            tree.func_175904_e();
            tree.generate(this.currentWorld, this.randomGenerator, pos);
        }

        chance = this.purpleMapleTreePerChunk;

        for (i = 0; i < this.purpleMapleTreePerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.currentWorld.getHorizon(this.field_180294_c.add(x, 0, z));
            WorldGenTreeMP tree = new WorldGenTreeMP(4, FronosBlocks.fronos_log, FronosBlocks.fronos_leaves, 1, 2, true, FronosBlocks.fronos_sapling, FronosBlocks.purple_maple_ivy);
            tree.func_175904_e();
            tree.generate(this.currentWorld, this.randomGenerator, pos);
        }

        // Coral
        for (i = 0; i < this.coralPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenFronosCoral().generate(this.currentWorld, this.randomGenerator, pos);
        }

        // Tall Grass
        for (i = 0; i < this.fronosTallGrassPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosTallGrass(FronosBlocks.fronos_tall_grass, BlockFronosTallGrass.VARIANT, BlockFronosTallGrass.BlockType.short_fronos_grass).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(x, y, z));
        }
        for (i = 0; i < this.fronosTallGrassPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosTallGrass(FronosBlocks.fronos_tall_grass, BlockFronosTallGrass.VARIANT, BlockFronosTallGrass.BlockType.medium_fronos_grass).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(x, y, z));
        }
        for (i = 0; i < this.fronosTallGrassPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosTallGrass(FronosBlocks.fronos_tall_grass, BlockFronosTallGrass.VARIANT, BlockFronosTallGrass.BlockType.tall_fronos_grass).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(x, y, z));
        }
        for (i = 0; i < this.pinkTallGrassPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosTallGrass(FronosBlocks.fronos_tall_grass, BlockFronosTallGrass.VARIANT, BlockFronosTallGrass.BlockType.short_pink_grass).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(x, y, z));
        }
        for (i = 0; i < this.pinkTallGrassPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosTallGrass(FronosBlocks.fronos_tall_grass, BlockFronosTallGrass.VARIANT, BlockFronosTallGrass.BlockType.medium_pink_grass).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(x, y, z));
        }
        for (i = 0; i < this.pinkTallGrassPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosTallGrass(FronosBlocks.fronos_tall_grass, BlockFronosTallGrass.VARIANT, BlockFronosTallGrass.BlockType.tall_pink_grass).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(x, y, z));
        }
        for (i = 0; i < this.purpleTallGrassPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosTallGrass(FronosBlocks.fronos_tall_grass, BlockFronosTallGrass.VARIANT, BlockFronosTallGrass.BlockType.short_purple_grass).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(x, y, z));
        }
        for (i = 0; i < this.purpleTallGrassPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosTallGrass(FronosBlocks.fronos_tall_grass, BlockFronosTallGrass.VARIANT, BlockFronosTallGrass.BlockType.medium_purple_grass).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(x, y, z));
        }
        for (i = 0; i < this.purpleTallGrassPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosTallGrass(FronosBlocks.fronos_tall_grass, BlockFronosTallGrass.VARIANT, BlockFronosTallGrass.BlockType.tall_purple_grass).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(x, y, z));
        }
        for (i = 0; i < this.plainsTallGrassPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosTallGrass(FronosBlocks.fronos_tall_grass, BlockFronosTallGrass.VARIANT, BlockFronosTallGrass.BlockType.short_plains_grass).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(x, y, z));
        }
        for (i = 0; i < this.plainsTallGrassPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosTallGrass(FronosBlocks.fronos_tall_grass, BlockFronosTallGrass.VARIANT, BlockFronosTallGrass.BlockType.medium_plains_grass).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(x, y, z));
        }
        for (i = 0; i < this.plainsTallGrassPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosTallGrass(FronosBlocks.fronos_tall_grass, BlockFronosTallGrass.VARIANT, BlockFronosTallGrass.BlockType.tall_plains_grass).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(x, y, z));
        }
        for (i = 0; i < this.goldenTallGrassPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosTallGrass(FronosBlocks.fronos_tall_grass, BlockFronosTallGrass.VARIANT, BlockFronosTallGrass.BlockType.short_golden_grass).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(x, y, z));
        }
        for (i = 0; i < this.goldenTallGrassPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosTallGrass(FronosBlocks.fronos_tall_grass, BlockFronosTallGrass.VARIANT, BlockFronosTallGrass.BlockType.medium_golden_grass).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(x, y, z));
        }
        for (i = 0; i < this.goldenTallGrassPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenFronosTallGrass(FronosBlocks.fronos_tall_grass, BlockFronosTallGrass.VARIANT, BlockFronosTallGrass.BlockType.tall_golden_grass).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(x, y, z));
        }

        // Fronos Flower
        for (i = 0; i < this.pinkButterCupPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenFronosFlowers(FronosBlocks.fronos_flower, BlockFronosFlower.VARIANT, BlockFronosFlower.BlockType.pink_butter_cup).generate(this.currentWorld, this.randomGenerator, pos);
        }
        for (i = 0; i < this.orangeFlowerPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenFronosFlowers(FronosBlocks.fronos_flower, BlockFronosFlower.VARIANT, BlockFronosFlower.BlockType.orange_butterfly_flower).generate(this.currentWorld, this.randomGenerator, pos);
        }
        for (i = 0; i < this.goldMilkCapPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenFronosFlowers(FronosBlocks.fronos_flower, BlockFronosFlower.VARIANT, BlockFronosFlower.BlockType.yellow_milk_cap).generate(this.currentWorld, this.randomGenerator, pos);
        }
        for (i = 0; i < this.littleSunFlowerPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenFronosFlowers(FronosBlocks.fronos_flower, BlockFronosFlower.VARIANT, BlockFronosFlower.BlockType.little_sun_flower).generate(this.currentWorld, this.randomGenerator, pos);
        }
        for (i = 0; i < this.skyMushroomPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(48 - 16) + 16;
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenFronosFlowers(FronosBlocks.fronos_flower, BlockFronosFlower.VARIANT, BlockFronosFlower.BlockType.sky_mushroom).generate(this.currentWorld, this.randomGenerator, pos);
        }
        for (i = 0; i < this.purpleSpikeFlowerPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenFronosFlowers(FronosBlocks.fronos_flower, BlockFronosFlower.VARIANT, BlockFronosFlower.BlockType.purple_spike_flower).generate(this.currentWorld, this.randomGenerator, pos);
        }
        for (i = 0; i < this.jungleIrisPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenFronosFlowers(FronosBlocks.fronos_flower, BlockFronosFlower.VARIANT, BlockFronosFlower.BlockType.jungle_iris).generate(this.currentWorld, this.randomGenerator, pos);
        }
        for (i = 0; i < this.bluePoisonMushroomPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenFronosFlowers(FronosBlocks.fronos_flower, BlockFronosFlower.VARIANT, BlockFronosFlower.BlockType.blue_poison_mushroom).generate(this.currentWorld, this.randomGenerator, pos);
        }
        for (i = 0; i < this.whiteMossPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenFronosFlowers(FronosBlocks.fronos_flower, BlockFronosFlower.VARIANT, BlockFronosFlower.BlockType.white_moss).generate(this.currentWorld, this.randomGenerator, pos);
        }
        for (i = 0; i < this.candyFlowerPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenCandyFlower().generate(this.currentWorld, this.randomGenerator, pos);
        }

        // Frosted Cake
        for (i = 0; i < this.frostedCakePerChunk; ++i)
        {
            if (this.currentWorld.rand.nextInt(30) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(256);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenFrostedCake(FronosBlocks.frosted_cake.getDefaultState().withProperty(BlockFrostedCake.VARIANT, BlockFrostedCake.BlockType.frosted_white_cake_block)).generate(this.currentWorld, this.randomGenerator, pos);
            }
            if (this.currentWorld.rand.nextInt(30) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(256);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenFrostedCake(FronosBlocks.frosted_cake.getDefaultState().withProperty(BlockFrostedCake.VARIANT, BlockFrostedCake.BlockType.frosted_pink_cake_block)).generate(this.currentWorld, this.randomGenerator, pos);
            }
            if (this.currentWorld.rand.nextInt(30) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(256);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenFrostedCake(FronosBlocks.frosted_cake.getDefaultState().withProperty(BlockFrostedCake.VARIANT, BlockFrostedCake.BlockType.frosted_white_cake_block2)).generate(this.currentWorld, this.randomGenerator, pos);
            }
            if (this.currentWorld.rand.nextInt(30) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(256);
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenFrostedCake(FronosBlocks.frosted_cake.getDefaultState().withProperty(BlockFrostedCake.VARIANT, BlockFrostedCake.BlockType.frosted_chocolate_cake_block)).generate(this.currentWorld, this.randomGenerator, pos);
            }
        }

        // Space Shell
        for (i = 0; i < this.spaceShellPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenSpaceShell().generate(this.currentWorld, this.randomGenerator, pos);
        }

        // Dungeon Spawner
        for (i = 0; i < this.dungeonSpawnerPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(128);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenFronosDungeons().generate(this.currentWorld, this.randomGenerator, pos);
        }

        // Maple Ivy
        for (i = 0; i < this.mapleIvyPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            z = this.randomGenerator.nextInt(16) + 8;
            new WorldGenMapleIvy().generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(x, 128, z));
        }

        // Dead Bush
        for (i = 0; i < this.deadBushPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenDeadBush().generate(this.currentWorld, this.randomGenerator, pos);
        }

        // Sugar Cane
        for (i = 0; i < this.reedsPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenReed().generate(this.currentWorld, this.randomGenerator, pos);
        }

        // Cloud Block
        for (i = 0; i < this.strawberryCloudPerChunk; ++i)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(128 - 80) + 80;
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenCloud(FronosBlocks.cloud_block.getDefaultState()).generate(this.currentWorld, this.randomGenerator, pos);
        }
        for (i = 0; i < this.rainbowCloudPerChunk; ++i)
        {
            if (this.randomGenerator.nextInt(10) == 0)
            {
                x = this.randomGenerator.nextInt(16) + 8;
                y = this.randomGenerator.nextInt(128 - 80) + 80;
                z = this.randomGenerator.nextInt(16) + 8;
                pos = this.field_180294_c.add(x, y, z);
                new WorldGenCloud(FronosBlocks.cloud_block.getDefaultState().withProperty(BlockFronosCloud.VARIANT, BlockFronosCloud.BlockType.rainbow_cloud)).generate(this.currentWorld, this.randomGenerator, pos);
            }
        }

        // Pumpkin
        if (this.randomGenerator.nextInt(10) == 0)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenFronosPumpkin().generate(this.currentWorld, this.randomGenerator, pos);
        }

        // Melon
        if (this.randomGenerator.nextInt(15) == 0)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            y = this.randomGenerator.nextInt(256);
            z = this.randomGenerator.nextInt(16) + 8;
            pos = this.field_180294_c.add(x, y, z);
            new WorldGenFronosMelon().generate(this.currentWorld, this.randomGenerator, pos);
        }

        // Lilypad
        while (i < this.waterlilyPerChunk)
        {
            x = this.randomGenerator.nextInt(16) + 8;
            z = this.randomGenerator.nextInt(16) + 8;
            int i1 = this.nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(x, 0, z)).getY() * 2);
            pos = this.field_180294_c.add(x, i1, z);

            while (true)
            {
                if (pos.getY() > 0)
                {
                    BlockPos blockpos3 = pos.down();

                    if (this.currentWorld.isAirBlock(blockpos3))
                    {
                        pos = blockpos3;
                        continue;
                    }
                }

                new WorldGenWaterlily().generate(this.currentWorld, this.randomGenerator, pos);
                ++i;
                break;
            }
        }
    }

    private int nextInt(int i)
    {
        if (i <= 1)
        {
            return 0;
        }
        return this.randomGenerator.nextInt(i);
    }
}