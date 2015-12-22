/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.koentus.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.blocks.BlockBreakableMP;
import stevekung.mods.stevecore.BlockStateHelper;
import stevekung.mods.stevecore.BlockStateHelper.EnumAxis;
import stevekung.mods.stevecore.BlockStateHelper.SwitchEnumAxis;

public class BlockCrystalSegment extends BlockBreakableMP
{
    public BlockCrystalSegment(String name)
    {
        super(Material.glass);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setStepSound(soundTypeGlass);
        this.setDefaultState(this.getDefaultState().withProperty(BlockStateHelper.AXIS, EnumAxis.Y));
        this.setUnlocalizedName(name);
    }

    @Override
    public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int metadata, EntityLivingBase entity)
    {
        return super.onBlockPlaced(world, pos, facing, hitX, hitY, hitZ, metadata, entity).withProperty(BlockStateHelper.AXIS, BlockStateHelper.EnumAxis.fromFacingAxis(facing.getAxis()));
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(World world, BlockPos pos)
    {
        this.setBlockBoundsBasedOnState(world, pos);
        return super.getSelectedBoundingBox(world, pos);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world, BlockPos pos, IBlockState state)
    {
        this.setBlockBoundsBasedOnState(world, pos);
        return super.getCollisionBoundingBox(world, pos, state);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, BlockPos pos)
    {
        if (world.getBlockState(pos).getBlock() != this)
        {
            return;
        }

        float width = 0.25F;
        float min = (1.0F - width) / 2F;
        float max = 1.0F - min;

        switch (SwitchEnumAxis.AXIS_LOOKUP[((EnumAxis)world.getBlockState(pos).getValue(BlockStateHelper.AXIS)).ordinal()])
        {
        case 0:
            this.setBlockBounds(min, 0F, min, max, 1.0F, max);
            break;
        case 1:
            this.setBlockBounds(0F, min, min, 1.0F, max, max);
            break;
        case 2:
            this.setBlockBounds(min, min, 0F, max, max, 1.0F);
            break;
        default:
            this.setBlockBounds(min, 0F, min, max, 1.0F, max);
            break;
        }
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
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] { BlockStateHelper.AXIS });
    }

    @Override
    public int quantityDropped(Random rand)
    {
        return 0;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState state = this.getDefaultState();

        switch (meta & 12)
        {
        case 0:
            state = state.withProperty(BlockStateHelper.AXIS, EnumAxis.Y);
            break;
        case 4:
            state = state.withProperty(BlockStateHelper.AXIS, EnumAxis.X);
            break;
        case 8:
            state = state.withProperty(BlockStateHelper.AXIS, EnumAxis.Z);
            break;
        default:
            state = state.withProperty(BlockStateHelper.AXIS, EnumAxis.NONE);
        }
        return state;
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        byte b = 0;
        int i = b;

        switch (SwitchEnumAxis.AXIS_LOOKUP[((EnumAxis)state.getValue(BlockStateHelper.AXIS)).ordinal()])
        {
        case 1:
            i |= 4;
            break;
        case 2:
            i |= 8;
            break;
        case 3:
            i |= 12;
        }
        return i;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess world, BlockPos pos, EnumFacing side)
    {
        return true;
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }
}