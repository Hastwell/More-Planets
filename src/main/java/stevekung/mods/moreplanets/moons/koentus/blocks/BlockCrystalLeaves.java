/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.koentus.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.blocks.BlockLeavesMP;
import stevekung.mods.moreplanets.moons.koentus.items.KoentusItems;
import stevekung.mods.stevecore.BlockStateHelper;

public class BlockCrystalLeaves extends BlockLeavesMP
{
    public BlockCrystalLeaves(String name)
    {
        super();
        this.setDefaultState(this.getDefaultState().withProperty(BlockStateHelper.CHECK_DECAY, true).withProperty(BlockStateHelper.DECAYABLE, true));
        this.setUnlocalizedName(name);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(KoentusBlocks.crystal_sapling);
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] { BlockStateHelper.DECAYABLE, BlockStateHelper.CHECK_DECAY });
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
    protected void dropFruit(World world, BlockPos pos, IBlockState state, int chance)
    {
        if (world.rand.nextInt(chance) == 0)
        {
            Block.spawnAsEntity(world, pos, new ItemStack(KoentusItems.crystal_apple));
        }
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | 1;

        if (!((Boolean)state.getValue(BlockStateHelper.DECAYABLE)).booleanValue())
        {
            i |= 4;
        }
        if (((Boolean)state.getValue(BlockStateHelper.CHECK_DECAY)).booleanValue())
        {
            i |= 8;
        }
        return i;
    }
}