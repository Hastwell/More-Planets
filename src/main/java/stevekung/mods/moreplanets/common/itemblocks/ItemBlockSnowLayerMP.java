/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.blocks.BlockSnowLayerMP;
import stevekung.mods.stevecore.BlockStateHelper;

public class ItemBlockSnowLayerMP extends ItemBlockMorePlanets
{
    private BlockSnowLayerMP snow;

    public ItemBlockSnowLayerMP(Block block, BlockSnowLayerMP snow)
    {
        super(block);
        this.snow = snow;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (itemStack.stackSize == 0)
        {
            return false;
        }
        else if (!player.canPlayerEdit(pos, side, itemStack))
        {
            return false;
        }
        else
        {
            IBlockState state = world.getBlockState(pos);
            Block block = state.getBlock();
            BlockPos blockpos = pos;

            if ((side != EnumFacing.UP || block != this.snow) && !block.isReplaceable(world, pos))
            {
                blockpos = pos.offset(side);
                state = world.getBlockState(blockpos);
                block = state.getBlock();
            }

            if (block == this.snow)
            {
                int i = state.getValue(BlockStateHelper.LAYERS).intValue();

                if (i <= 7)
                {
                    IBlockState state1 = state.withProperty(BlockStateHelper.LAYERS, Integer.valueOf(i + 1));
                    AxisAlignedBB axisalignedbb = this.snow.getCollisionBoundingBox(world, blockpos, state1);

                    if (world.checkNoEntityCollision(axisalignedbb) && world.setBlockState(blockpos, state1, 2))
                    {
                        world.playSoundEffect(blockpos.getX() + 0.5F, blockpos.getY() + 0.5F, blockpos.getZ() + 0.5F, this.snow.stepSound.getPlaceSound(), (this.snow.stepSound.getVolume() + 1.0F) / 2.0F, this.snow.stepSound.getFrequency() * 0.8F);
                        --itemStack.stackSize;
                        return true;
                    }
                }
            }
            return super.onItemUse(itemStack, player, world, blockpos, side, hitX, hitY, hitZ);
        }
    }

    @Override
    public boolean canPlaceBlockOnSide(World world, BlockPos pos, EnumFacing side, EntityPlayer player, ItemStack stack)
    {
        IBlockState state = world.getBlockState(pos);
        return state.getBlock() != this.snow || state.getValue(BlockStateHelper.LAYERS) > 7 ? super.canPlaceBlockOnSide(world, pos, side, player, stack) : true;
    }
}