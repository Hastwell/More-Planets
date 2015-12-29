/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.blocks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.BlockAir;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.blocks.BlockLeavesMP;
import stevekung.mods.stevecore.BlockStateHelper;

public class BlockFronosColorizedLeaves extends BlockLeavesMP
{
    public BlockFronosColorizedLeaves(String name)
    {
        super();
        this.setDefaultState(this.getDefaultState().withProperty(BlockStateHelper.CHECK_DECAY, true).withProperty(BlockStateHelper.DECAYABLE, true));
        this.setUnlocalizedName(name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return -16733696;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderColor(IBlockState state)
    {
        return -16733696;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess world, BlockPos pos, int pass)
    {
        return -16733696;
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        super.updateTick(world, pos, state, rand);

        if (rand.nextInt(100) == 0)
        {
            int i = 6;
            Iterator iterator = BlockPos.getAllInBoxMutable(pos.add(-8, -8, -8), pos.add(8, 8, 8)).iterator();

            while (iterator.hasNext())
            {
                BlockPos blockpos1 = (BlockPos)iterator.next();

                if (world.getBlockState(blockpos1).getBlock() == FronosBlocks.coconut_block)
                {
                    --i;

                    if (i <= 0)
                    {
                        return;
                    }
                }
            }
            if (world.getBlockState(pos.down()).getBlock() instanceof BlockAir)
            {
                world.setBlockState(pos.down(), FronosBlocks.coconut_block.getDefaultState(), 3);
            }
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(FronosBlocks.fronos_sapling);
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] { BlockStateHelper.CHECK_DECAY, BlockStateHelper.DECAYABLE });
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(BlockStateHelper.DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(BlockStateHelper.CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack itemStack, IBlockAccess world, BlockPos pos, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, 0));
        return ret;
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | 1;

        if (!state.getValue(BlockStateHelper.DECAYABLE).booleanValue())
        {
            i |= 4;
        }
        if (state.getValue(BlockStateHelper.CHECK_DECAY).booleanValue())
        {
            i |= 8;
        }
        return i;
    }
}