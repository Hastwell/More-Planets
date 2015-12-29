/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.blocks.BlockBaseMP;

public class BlockHugeSkyMushroom extends BlockBaseMP
{
    public static PropertyEnum VARIANT = PropertyEnum.create("variant", BlockHugeSkyMushroom.EnumType.class);

    public BlockHugeSkyMushroom(String name)
    {
        super(Material.wood);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockHugeSkyMushroom.EnumType.ALL_OUTSIDE));
        this.setHardness(0.2F);
        this.setStepSound(soundTypeWood);
        this.setUnlocalizedName(name);
    }

    @Override
    public CreativeTabs getCreativeTabToDisplayOn()
    {
        return null;
    }

    @Override
    public int quantityDropped(Random rand)
    {
        return Math.max(0, rand.nextInt(10) - 7);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(FronosBlocks.fronos_flower);
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return 4;
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState();
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition moving, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(FronosBlocks.fronos_flower, 1, 4);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockHugeSkyMushroom.EnumType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockHugeSkyMushroom.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {VARIANT});
    }

    @Override
    public boolean rotateBlock(World world, BlockPos pos, EnumFacing facing)
    {
        IBlockState state = world.getBlockState(pos);

        for (IProperty prop : state.getProperties().keySet())
        {
            if (prop.getName().equals("variant"))
            {
                world.setBlockState(pos, state.cycleProperty(prop));
                return true;
            }
        }
        return false;
    }

    public static enum EnumType implements IStringSerializable
    {
        NORTH_WEST(1, "north_west"),
        NORTH(2, "north"),
        NORTH_EAST(3, "north_east"),
        WEST(4, "west"),
        CENTER(5, "center"),
        EAST(6, "east"),
        SOUTH_WEST(7, "south_west"),
        SOUTH(8, "south"),
        SOUTH_EAST(9, "south_east"),
        STEM(10, "stem"),
        ALL_INSIDE(0, "all_inside"),
        ALL_OUTSIDE(14, "all_outside"),
        ALL_STEM(15, "all_stem");
        private static EnumType[] META_LOOKUP = new EnumType[16];
        private int meta;
        private String name;

        private EnumType(int meta, String name)
        {
            this.meta = meta;
            this.name = name;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        @Override
        public String toString()
        {
            return this.name;
        }

        public static EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }
            EnumType enumtype = META_LOOKUP[meta];
            return enumtype == null ? META_LOOKUP[0] : enumtype;
        }

        @Override
        public String getName()
        {
            return this.name;
        }

        static
        {
            EnumType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
                EnumType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
    }
}