/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import stevekung.mods.moreplanets.common.blocks.BlockBreakableMP;
import stevekung.mods.moreplanets.core.init.MPPotions;
import stevekung.mods.moreplanets.planets.kapteynb.items.armor.KapteynBArmorItems;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityUraniumWaste;

public class BlockUraniumWaste extends BlockBreakableMP implements IShearable, ITileEntityProvider
{
    public BlockUraniumWaste(String name)
    {
        super(Material.plants);
        this.setUnlocalizedName(name);
        this.setStepSound(soundTypeGrass);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.05F, 1.0F);
    }

    @Override
    public int getLightValue(IBlockAccess world, BlockPos pos)
    {
        return 8;
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random rand)
    {
        return 0;
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        return true;
    }

    @Override
    public boolean isReplaceable(World world, BlockPos pos)
    {
        return true;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean isFullCube()
    {
        return false;
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos)
    {
        Block block = world.getBlockState(pos.down()).getBlock();

        if (block == null)
        {
            return false;
        }
        if (!block.isLeaves(world, pos.down()) && !block.isOpaqueCube())
        {
            return false;
        }
        return world.getBlockState(pos.down()).getBlock().getMaterial().blocksMovement();
    }

    @Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity tile)
    {
        super.harvestBlock(world, player, pos, state, tile);
        ItemStack equippedItem = player.getCurrentEquippedItem();

        if (equippedItem != null)
        {
            if (equippedItem.getItem() != Items.shears)
            {
                player.addPotionEffect(new PotionEffect(MPPotions.chemical.id, 100));
            }
        }
        else
        {
            player.addPotionEffect(new PotionEffect(MPPotions.chemical.id, 100));
        }
    }

    @Override
    public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block block)
    {
        this.checkForDrop(world, pos, state);
    }

    private boolean checkForDrop(World world, BlockPos pos, IBlockState state)
    {
        if (!this.canBlockStay(world, pos))
        {
            world.setBlockToAir(pos);
            return false;
        }
        else
        {
            return true;
        }
    }

    private boolean canBlockStay(World world, BlockPos pos)
    {
        return !world.isAirBlock(pos.down());
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
    {
        TileEntity tile = world.getTileEntity(pos);

        if (tile instanceof TileEntityUraniumWaste)
        {
            TileEntityUraniumWaste waste = (TileEntityUraniumWaste)tile;

            if (waste.radiationLevel <= 0)
            {
                return;
            }
            else if (waste.radiationLevel > 0)
            {
                if (entity instanceof EntityLivingBase)
                {
                    if (entity instanceof EntityPlayer)
                    {
                        InventoryPlayer inventory = ((EntityPlayer)entity).inventory;

                        if (!(inventory.armorInventory[0] != null && inventory.armorInventory[0].getItem() == KapteynBArmorItems.uranium_boots))
                        {
                            ((EntityPlayer)entity).addPotionEffect(new PotionEffect(MPPotions.chemical.id, 60));
                        }
                    }
                    else
                    {
                        ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MPPotions.chemical.id, 60));
                    }
                }
            }
        }
    }

    @Override
    public boolean isShearable(ItemStack itemStack, IBlockAccess world, BlockPos pos)
    {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack itemStack, IBlockAccess world, BlockPos pos, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, this.getMetaFromState(world.getBlockState(pos))));
        return ret;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityUraniumWaste();
    }
}