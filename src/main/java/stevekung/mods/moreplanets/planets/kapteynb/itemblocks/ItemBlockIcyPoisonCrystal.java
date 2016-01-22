/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockMorePlanets;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityIcyPoisonCrystal;

public class ItemBlockIcyPoisonCrystal extends ItemBlockMorePlanets
{
    public ItemBlockIcyPoisonCrystal(Block block)
    {
        super(block);
    }

    @Override
    public boolean placeBlockAt(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, IBlockState state)
    {
        if (super.placeBlockAt(itemStack, player, world, pos, facing, hitX, hitY, hitZ, state))
        {
            TileEntityIcyPoisonCrystal tile = (TileEntityIcyPoisonCrystal)world.getTileEntity(pos);
            tile.facing = facing.getIndex();
        }
        world.playSoundEffect(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, Block.soundTypeGlass.getPlaceSound(), (Block.soundTypeGlass.getVolume() + 1.0F) / 2.0F, Block.soundTypeGlass.getFrequency() * 0.8F);
        return super.placeBlockAt(itemStack, player, world, pos, facing, hitX, hitY, hitZ, state);
    }
}