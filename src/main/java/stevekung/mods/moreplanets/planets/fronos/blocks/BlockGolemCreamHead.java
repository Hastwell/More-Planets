/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.blocks;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.client.EnumParticleTypesMP;
import stevekung.mods.moreplanets.common.blocks.BlockBaseMP;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.planets.fronos.entities.EntityCreamGolem;

public class BlockGolemCreamHead extends BlockBaseMP
{
    public static PropertyEnum VARIANT = PropertyEnum.create("variant", BlockType.class);

    public BlockGolemCreamHead(String name)
    {
        super(Material.plants);
        this.setHardness(0.4F);
        this.setTickRandomly(true);
        this.setBlockBounds(0.186F, 0.186F, 0.186F, 0.814F, 0.814F, 0.814F);
        this.setDefaultState(this.getDefaultState().withProperty(VARIANT, BlockType.vanilla_cream_head));
        this.setStepSound(soundTypeSnow);
        this.setUnlocalizedName(name);
    }

    @Override
    public boolean isFullCube()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return this.getMetaFromState(state);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        for (int i = 0; i < 6; i++)
        {
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
        EnumParticleTypesMP type = null;

        switch (this.getMetaFromState(world.getBlockState(pos)))
        {
        case 0:
            type = EnumParticleTypesMP.VANILLA_CREAM_BALL;
            break;
        case 1:
            type = EnumParticleTypesMP.CHOCOLATE_CREAM_BALL;
            break;
        case 2:
            type = EnumParticleTypesMP.STRAWBERRY_CREAM_BALL;
            break;
        case 3:
            type = EnumParticleTypesMP.ORANGE_CREAM_BALL;
            break;
        case 4:
            type = EnumParticleTypesMP.TEA_CREAM_BALL;
            break;
        case 5:
            type = EnumParticleTypesMP.LEMON_CREAM_BALL;
            break;
        }
        this.createCreamGolem(world, pos, this.getMetaFromState(world.getBlockState(pos)), type);
    }

    private void createCreamGolem(World world, BlockPos pos, int meta, EnumParticleTypesMP type)
    {
        if (this.getMetaFromState(world.getBlockState(pos)) == meta)
        {
            if (world.getBlockState(pos.down()) == FronosBlocks.cream_block.getStateFromMeta(meta) && world.getBlockState(pos.down(2)) == FronosBlocks.cream_block.getStateFromMeta(meta))
            {
                if (!world.isRemote)
                {
                    EntityCreamGolem golem = new EntityCreamGolem(world);
                    world.setBlockState(pos, Blocks.air.getDefaultState(), 2);
                    world.setBlockState(pos.down(), Blocks.air.getDefaultState(), 2);
                    world.setBlockState(pos.down(2), Blocks.air.getDefaultState(), 2);
                    golem.setLocationAndAngles(pos.getX() + 0.5D, pos.getY() - 1.95D, pos.getZ() + 0.5D, 0.0F, 0.0F);
                    golem.setCreamGolemType(meta);
                    world.spawnEntityInWorld(golem);
                    world.notifyNeighborsRespectDebug(pos, Blocks.air);
                    world.notifyNeighborsRespectDebug(pos.down(), Blocks.air);
                    world.notifyNeighborsRespectDebug(pos.down(2), Blocks.air);
                }

                for (int i = 0; i < 120; ++i)
                {
                    MorePlanetsCore.proxy.spawnParticle(type, pos.getX() + world.rand.nextDouble(), pos.getY() + world.rand.nextDouble() - 1.5D, pos.getZ() + world.rand.nextDouble());
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

    public static enum BlockType implements IStringSerializable
    {
        vanilla_cream_head,
        chocolate_cream_head,
        strawberry_cream_head,
        orange_cream_head,
        tea_cream_head,
        lemon_cream_head;

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