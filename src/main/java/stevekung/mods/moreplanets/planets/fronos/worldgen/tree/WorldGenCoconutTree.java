/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.worldgen.tree;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import stevekung.mods.moreplanets.common.blocks.IFronosGrass;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;

public class WorldGenCoconutTree extends WorldGenAbstractTree
{
    private int strengthRand;
    private int bMax;
    private double offset;

    public WorldGenCoconutTree(int strengthRand, int bMax, double offset)
    {
        super(false);
        this.strengthRand = strengthRand;
        this.bMax = bMax;
        this.offset = offset;
    }

    @Override
    public boolean generate(World world, Random random, BlockPos pos)
    {
        Block block = world.getBlockState(pos.down()).getBlock();

        if (block != Blocks.grass && block != Blocks.dirt && !(block instanceof IFronosGrass) && block != FronosBlocks.fronos_dirt)
        {
            return false;
        }
        else
        {
            for (int var7 = -2; var7 <= 2; ++var7)
            {
                for (int var8 = -2; var8 <= 2; ++var8)
                {
                    if (world.isAirBlock(pos.add(pos.getX() + var7, pos.getY() - 1, pos.getZ() + var8)) && world.isAirBlock(pos.add(pos.getX() + var7, pos.getY() - 2, pos.getZ() + var8)) && !world.isAirBlock(pos.add(pos.getX() + var7, pos.getY(), pos.getZ() + var8)))
                    {
                        return false;
                    }
                }
            }

            double strength = random.nextInt(this.strengthRand) / 100D;
            double xoff = 0;
            double yoff = 0;
            int r = random.nextInt(4);

            if (r == 0)
            {
                xoff = strength;
            }
            else if (r == 1)
            {
                xoff = -strength;
            }
            else if (r == 2)
            {
                yoff = strength;
            }
            else
            {
                yoff = -strength;
            }

            int h = 1;
            //this.func_175905_a(world, pos.down(), FronosBlocks.fronos_dirt, 0); TODO

            for (int b = 0; b < this.bMax; b++)
            {
                this.buildBlock(world, new BlockPos(pos.getX() + (int) Math.floor(xoff), pos.getY() + h, pos.getZ() + (int) Math.floor(yoff)).down(), FronosBlocks.fronos_log, 0);

                if (b == this.bMax - 1)
                {
                    this.generateTop(world, new BlockPos(pos.getX() + (int) Math.floor(xoff), pos.getY() + h, pos.getZ() + (int) Math.floor(yoff)));
                }
                else
                {
                    h++;
                    xoff *= this.offset;
                    yoff *= this.offset;
                }
            }
            return true;
        }
    }

    public void generateTop(World world, BlockPos pos)
    {
        this.buildBlock(world, pos.getX() + 2, pos.getY() - 1, pos.getZ(), FronosBlocks.fronos_colorized_leaves, 0);
        this.buildBlock(world, pos.getX() - 2, pos.getY() - 1, pos.getZ(), FronosBlocks.fronos_colorized_leaves, 0);
        this.buildBlock(world, pos.getX(), pos.getY() - 1, pos.getZ() + 2, FronosBlocks.fronos_colorized_leaves, 0);
        this.buildBlock(world, pos.getX(), pos.getY() - 1, pos.getZ() - 2, FronosBlocks.fronos_colorized_leaves, 0);

        this.buildBlock(world, pos.getX() + 1, pos.getY(), pos.getZ(), FronosBlocks.fronos_colorized_leaves, 0);
        this.buildBlock(world, pos.getX() - 1, pos.getY(), pos.getZ(), FronosBlocks.fronos_colorized_leaves, 0);
        this.buildBlock(world, pos.getX(), pos.getY(), pos.getZ() + 1, FronosBlocks.fronos_colorized_leaves, 0);
        this.buildBlock(world, pos.getX(), pos.getY(), pos.getZ() - 1, FronosBlocks.fronos_colorized_leaves, 0);
        this.buildBlock(world, pos.getX() + 2, pos.getY(), pos.getZ() + 2, FronosBlocks.fronos_colorized_leaves, 0);
        this.buildBlock(world, pos.getX() - 2, pos.getY(), pos.getZ() - 2, FronosBlocks.fronos_colorized_leaves, 0);
        this.buildBlock(world, pos.getX() + 2, pos.getY(), pos.getZ() - 2, FronosBlocks.fronos_colorized_leaves, 0);
        this.buildBlock(world, pos.getX() - 2, pos.getY(), pos.getZ() + 2, FronosBlocks.fronos_colorized_leaves, 0);

        this.buildBlock(world, pos.getX() + 1, pos.getY() + 1, pos.getZ() - 1, FronosBlocks.fronos_colorized_leaves, 0);
        this.buildBlock(world, pos.getX() - 1, pos.getY() + 1, pos.getZ() + 1, FronosBlocks.fronos_colorized_leaves, 0);
        this.buildBlock(world, pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1, FronosBlocks.fronos_colorized_leaves, 0);
        this.buildBlock(world, pos.getX() - 1, pos.getY() + 1, pos.getZ() - 1, FronosBlocks.fronos_colorized_leaves, 0);
        this.buildBlock(world, pos.getX(), pos.getY() + 1, pos.getZ(), FronosBlocks.fronos_colorized_leaves, 0);

        this.buildBlock(world, pos.getX() + 2, pos.getY() + 2, pos.getZ(), FronosBlocks.fronos_colorized_leaves, 0);
        this.buildBlock(world, pos.getX() - 2, pos.getY() + 2, pos.getZ(), FronosBlocks.fronos_colorized_leaves, 0);
        this.buildBlock(world, pos.getX(), pos.getY() + 2, pos.getZ() + 2, FronosBlocks.fronos_colorized_leaves, 0);
        this.buildBlock(world, pos.getX(), pos.getY() + 2, pos.getZ() - 2, FronosBlocks.fronos_colorized_leaves, 0);
    }

    public void buildBlock(World world, BlockPos pos, Block block, int meta)
    {
        if (world.isAirBlock(new BlockPos(pos)) || world.getBlockState(new BlockPos(pos)).getBlock().isLeaves(world, new BlockPos(pos)))
        {
            this.func_175905_a(world, new BlockPos(pos), block, meta);
        }
    }

    public void buildBlock(World world, int x, int y, int z, Block block, int meta)
    {
        if (world.isAirBlock(new BlockPos(x, y, z)) || world.getBlockState(new BlockPos(x, y, z)).getBlock().isLeaves(world, new BlockPos(x, y, z)))
        {
            this.func_175905_a(world, new BlockPos(x, y, z), block, meta);
        }
    }
}