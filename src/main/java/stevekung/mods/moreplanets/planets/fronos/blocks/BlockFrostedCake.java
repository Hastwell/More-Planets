/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.blocks.BlockBaseMP;

public class BlockFrostedCake extends BlockBaseMP
{
    public static PropertyEnum VARIANT = PropertyEnum.create("variant", BlockType.class);

    public BlockFrostedCake(String name)
    {
        super(Material.cake);
        this.setStepSound(soundTypeCloth);
        this.setHardness(0.55F);
        this.setTickRandomly(false);//TODO Make cake growing work -.-
        this.setDefaultState(this.getDefaultState().withProperty(VARIANT, BlockType.cake_bread_block));
        this.setUnlocalizedName(name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        for (int i = 0; i < 7; ++i)
        {
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        int meta = this.getMetaFromState(state);

        if (meta == 3 || meta == 4)
        {
            return 0;
        }
        if (meta == 5)
        {
            return 1;
        }
        if (meta == 6)
        {
            return 2;
        }
        return meta;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitVecX, float hitVecY, float hitVecZ)
    {
        int meta = 0;

        if (this.getMetaFromState(state) == 0 || this.getMetaFromState(state) == 3 || this.getMetaFromState(state) == 4)
        {
            meta = 0;
        }
        else if (this.getMetaFromState(state) == 1 || this.getMetaFromState(state) == 5)
        {
            meta = 1;
        }
        else if (this.getMetaFromState(state) == 2 || this.getMetaFromState(state) == 6)
        {
            meta = 2;
        }

        if (player.getCurrentEquippedItem() != null)
        {
            if (player.getCurrentEquippedItem().getDisplayName().toLowerCase().contains("hoe"))
            {
                Block farmland = FronosBlocks.cake_farmland;

                world.playSoundEffect(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, farmland.stepSound.getStepSound(), (farmland.stepSound.getVolume() + 1.0F) / 2.0F, farmland.stepSound.getFrequency() * 0.8F);

                if (!world.isRemote)
                {
                    world.setBlockState(pos, farmland.getStateFromMeta(meta), 2);
                }
                player.getCurrentEquippedItem().damageItem(1, player);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if (!world.isRemote)
        {
            if (world.getLightFromNeighbors(pos.up()) < 4 && world.getBlockLightOpacity(pos.up()) > 2)
            {
                if (state == state.withProperty(VARIANT, BlockType.frosted_white_cake_block) || state == state.withProperty(VARIANT, BlockType.frosted_pink_cake_block))
                {
                    world.setBlockState(pos, this.getStateFromMeta(0));
                }
            }
            else if (world.getLightFromNeighbors(pos.up()) >= 9)
            {
                for (int i = 0; i < 4; ++i)
                {
                    BlockPos pos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                    if (world.getBlockState(pos1) == state.withProperty(VARIANT, BlockType.cake_bread_block))
                    {
                        if (world.getLightFromNeighbors(pos1.up()) >= 4 && world.getBlockState(pos1.up()).getBlock().getLightOpacity() <= 2)
                        {
                            world.setBlockState(pos1, this.getStateFromMeta(3));
                        }
                    }
                    else if (world.getBlockState(pos1) == state.withProperty(VARIANT, BlockType.white_cake_bread_block))
                    {
                        if (world.getLightFromNeighbors(pos1.up()) >= 4 && world.getBlockState(pos1.up()).getBlock().getLightOpacity() <= 2)
                        {
                            world.setBlockState(pos1, this.getStateFromMeta(5));
                        }
                    }
                }
            }
        }
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

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(this, 1, this.getMetaFromState(world.getBlockState(pos)));
    }

    public static enum BlockType implements IStringSerializable
    {
        cake_bread_block,
        white_cake_bread_block,
        chocolate_cake_bread_block,
        frosted_white_cake_block,
        frosted_pink_cake_block,
        frosted_white_cake_block2,
        frosted_chocolate_cake_block;

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