/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.client.EnumParticleTypesMP;
import stevekung.mods.moreplanets.common.blocks.BlockOysterMP;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;
import stevekung.mods.stevecore.BlockStateHelper;

public class BlockSpaceOyster extends BlockOysterMP
{
    public static PropertyBool OPEN = PropertyBool.create("open");

    public BlockSpaceOyster(String name)
    {
        super();
        this.setDefaultState(this.getDefaultState().withProperty(BlockStateHelper.FACING, EnumFacing.NORTH).withProperty(OPEN, false));
        this.setUnlocalizedName(name);
    }

    @Override
    public int getLightValue(IBlockAccess world, BlockPos pos)
    {
        return 4;
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if (!world.isRemote)
        {
            if (state == state.withProperty(OPEN, false))
            {
                if (world.isDaytime() || world.getLightFromNeighbors(pos.up()) >= 9)
                {
                    if (world.rand.nextInt(10) == 0)
                    {
                        world.setBlockState(pos, this.getDefaultState().withProperty(BlockStateHelper.FACING, EnumFacing.getFront(((EnumFacing)state.getValue(BlockStateHelper.FACING)).getIndex())).withProperty(OPEN, true), 3);
                    }
                    if (world.getBlockState(pos.down()) == Blocks.sand || world.getBlockState(pos.down()) == FronosBlocks.golden_grass || world.getBlockState(pos.down()) == FronosBlocks.fronos_sand.getDefaultState().withProperty(BlockFronosSand.VARIANT, BlockFronosSand.BlockType.white_sand))
                    {
                        world.setBlockState(pos, this.getDefaultState().withProperty(BlockStateHelper.FACING, EnumFacing.getFront(((EnumFacing)state.getValue(BlockStateHelper.FACING)).getIndex())).withProperty(OPEN, true), 3);
                    }
                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if (state == state.withProperty(OPEN, true))
        {
            if (rand.nextInt(1) == 0)
            {
                MorePlanetsCore.proxy.spawnParticle(EnumParticleTypesMP.GOLDEN_DUST, pos.getX() + rand.nextFloat(), pos.getY() + 0.15F, pos.getZ() + rand.nextFloat());
            }
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float par7, float par8, float par9)
    {
        if (state == state.withProperty(OPEN, true))
        {
            world.setBlockState(pos, this.getDefaultState().withProperty(BlockStateHelper.FACING, EnumFacing.getFront(((EnumFacing)state.getValue(BlockStateHelper.FACING)).getIndex())).withProperty(OPEN, false), 3);
            EntityItem entityitem = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(FronosItems.pearl, 1, 0));

            if (!world.isRemote && world.rand.nextInt(20) == 0)
            {
                world.spawnEntityInWorld(entityitem);
            }
            return true;
        }
        return false;
    }

    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        List<ItemStack> ret = new ArrayList<ItemStack>();
        Random rand = world instanceof World ? ((World)world).rand : RANDOM;
        ret.add(new ItemStack(this, 1, 0));

        if (state == state.withProperty(OPEN, true))
        {
            if (rand.nextInt(20) == 0)
            {
                ret.add(new ItemStack(FronosItems.pearl, 1, 0));
            }
        }
        return ret;
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return 0;
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(this, 1, 0);
    }

    @Override
    public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(BlockStateHelper.FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | ((EnumFacing)state.getValue(BlockStateHelper.FACING)).getOpposite().getIndex();

        if (!((Boolean)state.getValue(OPEN)).booleanValue())
        {
            i |= 8;
        }
        return i;
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] { BlockStateHelper.FACING, OPEN });
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(BlockStateHelper.FACING, EnumFacing.getHorizontal(meta)).withProperty(OPEN, (meta & 8) != 8);
    }
}