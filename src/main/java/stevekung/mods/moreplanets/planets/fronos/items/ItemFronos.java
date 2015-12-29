/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.items.ItemBaseMP;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;

public class ItemFronos extends ItemBaseMP
{
    public ItemFronos(String name)
    {
        super();
        this.setUnlocalizedName(name);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float par8, float par9, float par10)
    {
        Block block = world.getBlockState(pos).getBlock();

        if (player.canPlayerEdit(pos, side, itemStack) && block == FronosBlocks.coconut_block)
        {
            if (itemStack.getItemDamage() == 7)
            {
                if (world.isRemote)
                {
                    return true;
                }
                else
                {
                    if (world.rand.nextInt(10) == 0)
                    {
                        world.destroyBlock(pos, false);
                        world.setBlockState(pos, FronosBlocks.coconut_milk.getDefaultState());
                    }
                    world.playSoundEffect(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, FronosBlocks.coconut_block.stepSound.getPlaceSound(), (FronosBlocks.coconut_block.stepSound.getVolume() + 1.0F) / 2.0F, 1.2F);
                    --itemStack.stackSize;
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
        return false;
    }

    @Override
    protected String[] getItemVariantsName()
    {
        return new String[] { "mineral_crystal", "mineral_pieces", "black_diamond", "iridium_ingot", "compressed_black_diamond", "compressed_iridium", "golden_wheat", "fronos_rock_item", "strawberry_feather", "cheese_string" };
    }
}