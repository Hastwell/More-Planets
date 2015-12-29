/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.nibiru.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.blocks.BlockLeavesMP;
import stevekung.mods.moreplanets.planets.nibiru.items.NibiruItems;
import stevekung.mods.stevecore.BlockStateHelper;

public class BlockNibiruLeaves extends BlockLeavesMP
{
    public static PropertyEnum VARIANT = PropertyEnum.create("variant", BlockType.class);

    public BlockNibiruLeaves(String name)
    {
        super();
        this.setDefaultState(this.getDefaultState().withProperty(VARIANT, BlockType.ancient_dark_leaves));
        this.setUnlocalizedName(name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        for (int i = 0; i < 2; ++i)
        {
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(NibiruBlocks.nibiru_sapling);
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        if (state == state.withProperty(VARIANT, BlockType.orange_leaves))
        {
            return 1;
        }
        return 0;
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] { VARIANT, BlockStateHelper.DECAYABLE, BlockStateHelper.CHECK_DECAY });
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, this.getWoodType(meta)).withProperty(BlockStateHelper.DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(BlockStateHelper.CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
    }

    public BlockType getWoodType(int meta)
    {
        return BlockType.byMetadata((meta & 3) % 4);
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack itemStack, IBlockAccess world, BlockPos pos, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, ((BlockType)world.getBlockState(pos).getValue(VARIANT)).getMetadata()));
        return ret;
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | ((BlockType)state.getValue(VARIANT)).ordinal();

        if (!state.getValue(BlockStateHelper.DECAYABLE).booleanValue())
        {
            i |= 4;
        }
        if (state.getValue(BlockStateHelper.CHECK_DECAY).booleanValue())
        {
            i |= 8;
        }
        return i;
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition moving, World world, BlockPos pos)
    {
        return new ItemStack(this, 1, this.getMetaFromState(world.getBlockState(pos)) & 3);
    }

    @Override
    protected void dropFruit(World world, BlockPos pos, IBlockState state, int chance)
    {
        if (state == state.withProperty(VARIANT, BlockType.ancient_dark_leaves) && world.rand.nextInt(chance) == 0)
        {
            Block.spawnAsEntity(world, pos, new ItemStack(NibiruItems.space_fruits));
        }
        else if (state == state.withProperty(VARIANT, BlockType.orange_leaves) && world.rand.nextInt(chance) == 0)
        {
            Block.spawnAsEntity(world, pos, new ItemStack(NibiruItems.space_fruits, 1, 1));
        }
    }

    public static enum BlockType implements IStringSerializable
    {
        ancient_dark_leaves(0),
        orange_leaves(1);

        private int meta;
        private static BlockType[] META_LOOKUP = new BlockType[values().length];

        private BlockType(int meta)
        {
            this.meta = meta;
        }

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

        public int getMetadata()
        {
            return this.meta;
        }

        public static BlockType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }
            return META_LOOKUP[meta];
        }

        static
        {
            BlockType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
                BlockType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
    }
}