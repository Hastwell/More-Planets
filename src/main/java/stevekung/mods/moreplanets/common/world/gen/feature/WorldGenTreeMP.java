/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.world.gen.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.BlockPos.MutableBlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import stevekung.mods.moreplanets.common.blocks.BlockSaplingMP;
import stevekung.mods.moreplanets.common.blocks.BlockVineMP;

public class WorldGenTreeMP extends WorldGenAbstractTree
{
    private Block wood;
    private int woodMeta;
    private Block leaves;
    private int leavesMeta;
    private Block sapling;
    private Block vine;
    private Block grass;
    private boolean grassBool;
    private Block dirt;
    private Block fruit;

    public WorldGenTreeMP(Block wood, Block leaves, int woodMeta, int leavesMeta, Block sapling, Block vine, Block grass, Block dirt, Block fruit)
    {
        super(false);
        this.wood = wood;
        this.woodMeta = woodMeta;
        this.leaves = leaves;
        this.leavesMeta = leavesMeta;
        this.sapling = sapling;
        this.vine = vine;
        this.grass = grass;
        this.dirt = dirt;
        this.fruit = fruit;
    }

    public WorldGenTreeMP(Block wood, Block leaves, int woodMeta, int leavesMeta, Block sapling, Block vine, boolean grass, Block dirt, Block fruit)
    {
        super(false);
        this.wood = wood;
        this.woodMeta = woodMeta;
        this.leaves = leaves;
        this.leavesMeta = leavesMeta;
        this.sapling = sapling;
        this.vine = vine;
        this.grassBool = grass;
        this.dirt = dirt;
        this.fruit = fruit;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        int i = rand.nextInt(3) + 5;
        boolean flag = true;

        if (pos.getY() >= 1 && pos.getY() + i + 1 <= 256)
        {
            for (int j = pos.getY(); j <= pos.getY() + 1 + i; ++j)
            {
                int k = 1;

                if (j == pos.getY())
                {
                    k = 0;
                }
                if (j >= pos.getY() + 1 + i - 2)
                {
                    k = 2;
                }

                MutableBlockPos mutableblockpos = new MutableBlockPos();

                for (int l = pos.getX() - k; l <= pos.getX() + k && flag; ++l)
                {
                    for (int i1 = pos.getZ() - k; i1 <= pos.getZ() + k && flag; ++i1)
                    {
                        if (j >= 0 && j < 256)
                        {
                            if (!this.isReplaceable(world, mutableblockpos.set(l, j, i1)))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                BlockPos down = pos.down();
                Block block1 = world.getBlockState(down).getBlock();
                boolean isSoil = block1.canSustainPlant(world, down, EnumFacing.UP, (BlockSaplingMP)this.sapling);

                if (isSoil && pos.getY() < 256 - i - 1)
                {
                    this.onPlantGrow(world, down);
                    int k2 = 3;
                    int l2 = 0;

                    for (int i3 = pos.getY() - k2 + i; i3 <= pos.getY() + i; ++i3)
                    {
                        int i4 = i3 - (pos.getY() + i);
                        int j1 = l2 + 1 - i4 / 2;

                        for (int k1 = pos.getX() - j1; k1 <= pos.getX() + j1; ++k1)
                        {
                            int l1 = k1 - pos.getX();

                            for (int i2 = pos.getZ() - j1; i2 <= pos.getZ() + j1; ++i2)
                            {
                                int j2 = i2 - pos.getZ();

                                if (Math.abs(l1) != j1 || Math.abs(j2) != j1 || rand.nextInt(2) != 0 && i4 != 0)
                                {
                                    BlockPos blockpos = new BlockPos(k1, i3, i2);
                                    Block block = world.getBlockState(blockpos).getBlock();

                                    if (block.isAir(world, blockpos) || block.isLeaves(world, blockpos) || block.getMaterial() == Material.vine)
                                    {
                                        this.setBlockAndNotifyAdequately(world, blockpos, this.leaves.getStateFromMeta(this.leavesMeta));
                                    }
                                }
                            }
                        }
                    }

                    for (int j3 = 0; j3 < i; ++j3)
                    {
                        BlockPos upN = pos.up(j3);
                        Block block2 = world.getBlockState(upN).getBlock();

                        if (block2.isAir(world, upN) || block2.isLeaves(world, upN) || block2.getMaterial() == Material.vine)
                        {
                            this.setBlockAndNotifyAdequately(world, pos.up(j3), this.wood.getStateFromMeta(this.woodMeta));

                            if (this.vine != null && j3 > 0)
                            {
                                if (rand.nextInt(3) > 0 && world.isAirBlock(pos.add(-1, j3, 0)))
                                {
                                    this.generateVine(world, pos.add(-1, j3, 0), BlockVineMP.EAST);
                                }
                                if (rand.nextInt(3) > 0 && world.isAirBlock(pos.add(1, j3, 0)))
                                {
                                    this.generateVine(world, pos.add(1, j3, 0), BlockVineMP.WEST);
                                }
                                if (rand.nextInt(3) > 0 && world.isAirBlock(pos.add(0, j3, -1)))
                                {
                                    this.generateVine(world, pos.add(0, j3, -1), BlockVineMP.SOUTH);
                                }
                                if (rand.nextInt(3) > 0 && world.isAirBlock(pos.add(0, j3, 1)))
                                {
                                    this.generateVine(world, pos.add(0, j3, 1), BlockVineMP.NORTH);
                                }
                            }
                        }
                    }

                    if (this.vine != null)
                    {
                        for (int k3 = pos.getY() - 3 + i; k3 <= pos.getY() + i; ++k3)
                        {
                            int j4 = k3 - (pos.getY() + i);
                            int k4 = 2 - j4 / 2;
                            BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();

                            for (int l4 = pos.getX() - k4; l4 <= pos.getX() + k4; ++l4)
                            {
                                for (int i5 = pos.getZ() - k4; i5 <= pos.getZ() + k4; ++i5)
                                {
                                    blockpos$mutableblockpos1.set(l4, k3, i5);

                                    if (world.getBlockState(blockpos$mutableblockpos1).getBlock().isLeaves(world,blockpos$mutableblockpos1))
                                    {
                                        BlockPos blockpos2 = blockpos$mutableblockpos1.west();
                                        BlockPos blockpos3 = blockpos$mutableblockpos1.east();
                                        BlockPos blockpos4 = blockpos$mutableblockpos1.north();
                                        BlockPos blockpos1 = blockpos$mutableblockpos1.south();

                                        if (rand.nextInt(4) == 0 && world.getBlockState(blockpos2).getBlock().isAir(world,blockpos2))
                                        {
                                            this.generateVineWithFacing(world, blockpos2, BlockVineMP.EAST);
                                        }
                                        if (rand.nextInt(4) == 0 && world.getBlockState(blockpos3).getBlock().isAir(world,blockpos3))
                                        {
                                            this.generateVineWithFacing(world, blockpos3, BlockVineMP.WEST);
                                        }
                                        if (rand.nextInt(4) == 0 && world.getBlockState(blockpos4).getBlock().isAir(world,blockpos4))
                                        {
                                            this.generateVineWithFacing(world, blockpos4, BlockVineMP.SOUTH);
                                        }
                                        if (rand.nextInt(4) == 0 && world.getBlockState(blockpos1).getBlock().isAir(world,blockpos1))
                                        {
                                            this.generateVineWithFacing(world, blockpos1, BlockVineMP.NORTH);
                                        }
                                    }
                                }
                            }
                        }
                        if (this.fruit != null)
                        {
                            if (rand.nextInt(5) == 0 && i > 5)
                            {
                                for (int l3 = 0; l3 < 2; ++l3)
                                {
                                    for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
                                    {
                                        if (rand.nextInt(4 - l3) == 0)
                                        {
                                            EnumFacing enumfacing1 = enumfacing.getOpposite();
                                            this.generateFruit(world, rand.nextInt(3), pos.add(enumfacing1.getFrontOffsetX(), i - 5 + l3, enumfacing1.getFrontOffsetZ()), enumfacing);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }

    private void onPlantGrow(World world, BlockPos pos)
    {
        if (world.getBlockState(pos).getBlock() == this.grass && this.grass != null && this.dirt != null)
        {
            world.setBlockState(pos, this.dirt.getDefaultState());
        }
        else if (this.grassBool && this.dirt != null)
        {
            world.setBlockState(pos, this.dirt.getDefaultState());
        }
        else if (world.getBlockState(pos).getBlock() == Blocks.grass)
        {
            world.setBlockState(pos, Blocks.dirt.getDefaultState());
        }
    }

    private void generateFruit(World world, int age, BlockPos pos, EnumFacing facing)
    {
        this.setBlockAndNotifyAdequately(world, pos, this.fruit.getDefaultState().withProperty(BlockCocoa.AGE, Integer.valueOf(age)).withProperty(BlockDirectional.FACING, facing));
    }

    private void generateVine(World world, BlockPos pos, PropertyBool facing)
    {
        this.setBlockAndNotifyAdequately(world, pos, this.vine.getDefaultState().withProperty(facing, Boolean.valueOf(true)));
    }

    private void generateVineWithFacing(World world, BlockPos pos, PropertyBool facing)
    {
        this.generateVine(world, pos, facing);
        int i = 4;

        for (pos = pos.down(); world.getBlockState(pos).getBlock().isAir(world, pos) && i > 0; --i)
        {
            this.generateVine(world, pos, facing);
            pos = pos.down();
        }
    }
}