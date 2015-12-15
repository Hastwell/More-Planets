/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import stevekung.mods.moreplanets.common.blocks.BlockFarmlandMP;

public class BlockCakeFarmland extends BlockFarmlandMP
{
    public static PropertyEnum VARIANT = PropertyEnum.create("variant", BlockType.class);

    public BlockCakeFarmland(String name)
    {
        super();
        this.setStepSound(soundTypeCloth);
        this.setHardness(0.55F);
        this.setDefaultState(this.getDefaultState().withProperty(VARIANT, BlockType.cake_farmland_dry));
        this.setUnlocalizedName(name);
    }

    @Override
    public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing facing, IPlantable plant)
    {
        return true;
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if (!this.hasWater(world, pos) && !world.canLightningStrike(pos.up()))
        {
            int meta = this.getMetaFromState(state);

            if (meta == 3)
            {
                world.setBlockState(pos, state.withProperty(VARIANT, BlockType.cake_farmland_dry), 2);
            }
            else if (meta == 4)
            {
                world.setBlockState(pos, state.withProperty(VARIANT, BlockType.white_cake_farmland_dry), 2);
            }
            else if (meta == 5)
            {
                world.setBlockState(pos, state.withProperty(VARIANT, BlockType.chocolate_cake_farmland_dry), 2);
            }
            else if (!this.hasCrops(world, pos))
            {
                if (this.getMetaFromState(state) == 0 || this.getMetaFromState(state) == 3)
                {
                    meta = 0;
                }
                else if (this.getMetaFromState(state) == 1 || this.getMetaFromState(state) == 4)
                {
                    meta = 1;
                }
                else if (this.getMetaFromState(state) == 2 || this.getMetaFromState(state) == 5)
                {
                    meta = 2;
                }
                world.setBlockState(pos, FronosBlocks.frosted_cake.getStateFromMeta(meta));
            }
        }
        else
        {
            int meta = this.getMetaFromState(state);

            if (meta == 0)
            {
                world.setBlockState(pos, state.withProperty(VARIANT, BlockType.cake_farmland_wet), 2);
            }
            else if (meta == 1)
            {
                world.setBlockState(pos, state.withProperty(VARIANT, BlockType.white_cake_farmland_wet), 2);
            }
            else if (meta == 2)
            {
                world.setBlockState(pos, state.withProperty(VARIANT, BlockType.chocolate_cake_farmland_wet), 2);
            }
        }
    }

    @Override
    public void onFallenUpon(World world, BlockPos pos, Entity entity, float fallDistance)
    {
        if (entity instanceof EntityLivingBase)
        {
            if (!world.isRemote && world.rand.nextFloat() < fallDistance - 0.5F)
            {
                IBlockState state = world.getBlockState(pos);
                int meta = 0;

                if (!(entity instanceof EntityPlayer) && !world.getGameRules().getGameRuleBooleanValue("mobGriefing"))
                {
                    return;
                }
                if (this.getMetaFromState(state) == 0 || this.getMetaFromState(state) == 3)
                {
                    meta = 0;
                }
                else if (this.getMetaFromState(state) == 1 || this.getMetaFromState(state) == 4)
                {
                    meta = 1;
                }
                else if (this.getMetaFromState(state) == 2 || this.getMetaFromState(state) == 5)
                {
                    meta = 2;
                }
                world.setBlockState(pos, FronosBlocks.frosted_cake.getStateFromMeta(meta));
            }
            entity.fall(fallDistance, 1.0F);
        }
    }

    @Override
    public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block block)
    {
        int meta = 0;

        if (this.getMetaFromState(state) == 0 || this.getMetaFromState(state) == 3)
        {
            meta = 0;
        }
        else if (this.getMetaFromState(state) == 1 || this.getMetaFromState(state) == 4)
        {
            meta = 1;
        }
        else if (this.getMetaFromState(state) == 2 || this.getMetaFromState(state) == 5)
        {
            meta = 2;
        }

        if (world.getBlockState(pos.up()).getBlock().getMaterial().isSolid())
        {
            world.setBlockState(pos, FronosBlocks.frosted_cake.getStateFromMeta(meta), 3);
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(FronosBlocks.frosted_cake);
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        int meta = this.getMetaFromState(state);

        if (meta == 0 || meta == 3)
        {
            meta = 0;
        }
        else if (meta == 1 || meta == 4)
        {
            meta = 1;
        }
        else if (meta == 2 || meta == 5)
        {
            meta = 2;
        }
        return meta;
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition moving, World world, BlockPos pos, EntityPlayer player)
    {
        int meta = 0;
        IBlockState state = world.getBlockState(pos);

        if (this.getMetaFromState(state) == 0 || this.getMetaFromState(state) == 3)
        {
            meta = 0;
        }
        else if (this.getMetaFromState(state) == 1 || this.getMetaFromState(state) == 4)
        {
            meta = 1;
        }
        else if (this.getMetaFromState(state) == 2 || this.getMetaFromState(state) == 5)
        {
            meta = 2;
        }
        return new ItemStack(FronosBlocks.frosted_cake, 1, meta);
    }

    @Override
    public CreativeTabs getCreativeTabToDisplayOn()
    {
        return null;
    }

    @Override
    public boolean isFertile(World world, BlockPos pos)
    {
        return this.getMetaFromState(world.getBlockState(pos)) >= 3;
    }

    @Override
    public boolean isSideSolid(IBlockAccess world, BlockPos pos, EnumFacing facing)
    {
        return facing != EnumFacing.DOWN && facing != EnumFacing.UP;
    }

    @Override
    protected Block getDirtBlock()
    {
        return FronosBlocks.frosted_cake;
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] { VARIANT });
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockType.values()[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockType)state.getValue(VARIANT)).ordinal();
    }

    public static enum BlockType implements IStringSerializable
    {
        cake_farmland_dry,
        white_cake_farmland_dry,
        chocolate_cake_farmland_dry,
        cake_farmland_wet,
        white_cake_farmland_wet,
        chocolate_cake_farmland_wet;

        @Override
        public String toString()
        {
            return this.getName();
        }

        @Override
        public String getName()
        {
            return this.name();
        }
    }
}