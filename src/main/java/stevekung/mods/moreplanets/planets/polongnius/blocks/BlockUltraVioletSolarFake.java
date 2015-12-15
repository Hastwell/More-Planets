/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.blocks;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.block.IPartialSealableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.blocks.BlockContainerMP;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityUltraVioletFake;

public class BlockUltraVioletSolarFake extends BlockContainerMP implements IPartialSealableBlock, ITileEntityProvider
{
    public BlockUltraVioletSolarFake(String name)
    {
        super(Material.iron);
        this.setUnlocalizedName(name);
        this.setStepSound(Block.soundTypeMetal);
        this.setResistance(1000000000000000.0F);
    }

    @Override
    public CreativeTabs getCreativeTabToDisplayOn()
    {
        return null;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean canDropFromExplosion(Explosion explosion)
    {
        return false;
    }

    @Override
    public float getBlockHardness(World world, BlockPos pos)
    {
        TileEntity tileEntity = world.getTileEntity(pos);

        if (tileEntity != null)
        {
            BlockPos mainBlockPosition = ((TileEntityUltraVioletFake) tileEntity).mainBlockPosition;

            if (mainBlockPosition != null)
            {
                return world.getBlockState(mainBlockPosition).getBlock().getBlockHardness(world, mainBlockPosition);
            }
        }
        return this.blockHardness;
    }

    @Override
    public boolean isSealed(World world, BlockPos pos, EnumFacing side)
    {
        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        TileEntity tileEntity = world.getTileEntity(pos);

        if (tileEntity instanceof TileEntityUltraVioletFake)
        {
            ((TileEntityUltraVioletFake) tileEntity).onBlockRemoval();
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float par7, float par8, float par9)
    {
        TileEntityUltraVioletFake tileEntity = (TileEntityUltraVioletFake)world.getTileEntity(pos);
        return tileEntity.onBlockActivated(player);
    }

    @Override
    public int quantityDropped(Random rand)
    {
        return 0;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isFullCube()
    {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityUltraVioletFake();
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition moving, World world, BlockPos pos)
    {
        TileEntity tileEntity = world.getTileEntity(pos);

        if (tileEntity instanceof TileEntityUltraVioletFake)
        {
            BlockPos mainBlockPosition = ((TileEntityUltraVioletFake) tileEntity).mainBlockPosition;

            if (mainBlockPosition != null)
            {
                Block mainBlock = world.getBlockState(mainBlockPosition).getBlock();

                if (Blocks.air != mainBlock)
                {
                    return mainBlock.getPickBlock(moving, world, mainBlockPosition);
                }
            }
        }
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean addHitEffects(World world, MovingObjectPosition moving, EffectRenderer effect)
    {
        BlockPos pos = moving.getBlockPos();
        TileEntity tileEntity = world.getTileEntity(pos);

        if (tileEntity instanceof TileEntityUltraVioletFake)
        {
            if (((TileEntityUltraVioletFake) tileEntity).mainBlockPosition != null)
            {
                effect.addBlockHitEffects(((TileEntityUltraVioletFake) tileEntity).mainBlockPosition, moving);
            }
        }
        return super.addHitEffects(world, moving, effect);
    }

    public void makeFakeBlock(World worldObj, BlockPos pos, BlockPos mainBlock, int meta)
    {
        worldObj.setBlockState(pos, this.getDefaultState(), 3);
        ((TileEntityUltraVioletFake) worldObj.getTileEntity(pos)).setMainBlock(mainBlock);
    }
}