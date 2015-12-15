/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.asteroids.darkasteroids.blocks;

import java.util.Random;

import net.minecraft.block.BlockAir;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDarkAir extends BlockAir
{
    public BlockDarkAir(String name)
    {
        this.setResistance(100000.0F);
        this.setHardness(0.0F);
        this.setUnlocalizedName(name);
    }

    @Override
    public boolean canReplace(World world, BlockPos pos, EnumFacing facing, ItemStack stack)
    {
        return true;
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos)
    {
        return true;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public int getMobilityFlag()
    {
        return 1;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return null;
    }

    @Override
    public int getLightValue(IBlockAccess world, BlockPos pos)
    {
        return 5 - this.getMetaFromState(world.getBlockState(pos));
    }
}