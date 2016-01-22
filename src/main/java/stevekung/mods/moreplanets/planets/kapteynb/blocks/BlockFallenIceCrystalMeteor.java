/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.blocks.BlockBaseMP;
import stevekung.mods.moreplanets.planets.kapteynb.items.KapteynBItems;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityIceCrystalMeteor;

public class BlockFallenIceCrystalMeteor extends BlockBaseMP implements ITileEntityProvider
{
    public static PropertyBool IMMUNE = PropertyBool.create("immune_to_explosion");

    public BlockFallenIceCrystalMeteor(String name)
    {
        super(Material.glass);
        this.setBlockBounds(0.186F, 0.186F, 0.186F, 0.814F, 0.814F, 0.814F);
        this.setHardness(1.0F);
        this.setResistance(5.0F);
        this.setStepSound(soundTypeGlass);
        this.setDefaultState(this.getDefaultState().withProperty(IMMUNE, false));
        this.setUnlocalizedName(name);
    }

    @Override
    public void dropBlockAsItemWithChance(World world, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(world, pos, state, chance, fortune);

        if (this.getItemDropped(state, world.rand, fortune) != Item.getItemFromBlock(this))
        {
            this.dropXpOnBlockBreak(world, pos, MathHelper.getRandomIntegerInRange(world.rand, 3, 5));
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
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        return true;
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random rand)
    {
        return 1 + rand.nextInt(1);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return KapteynBItems.kapteyn_b_item;
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return 5;
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
        world.scheduleUpdate(pos, this, this.tickRate(world));
    }

    @Override
    public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block block)
    {
        world.scheduleUpdate(pos, this, this.tickRate(world));
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if (!world.isRemote)
        {
            this.tryToFall(world, pos, state);
        }
    }

    private void tryToFall(World world, BlockPos pos, IBlockState state)
    {
        if (this.canFallBelow(world, pos.down()) && pos.getY() >= 0)
        {
            world.setBlockState(pos, Blocks.air.getDefaultState(), 3);
            BlockPos blockpos1;

            for (blockpos1 = pos.down(); this.canFallBelow(world, blockpos1) && blockpos1.getY() > 0; blockpos1 = blockpos1.down()) {}

            if (blockpos1.getY() >= 0)
            {
                world.setBlockState(blockpos1.up(), state, 3);
            }
        }
    }

    private boolean canFallBelow(World world, BlockPos pos)
    {
        Block block = world.getBlockState(pos).getBlock();

        if (block.getMaterial() == Material.air)
        {
            return true;
        }
        else if (block == Blocks.fire)
        {
            return true;
        }
        else
        {
            return block.getMaterial() == Material.water ? true : block.getMaterial() == Material.lava;
        }
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess world, BlockPos pos, EnumFacing side)
    {
        return true;
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(this, 1, 0);
    }

    @Override
    public float getExplosionResistance(World world, BlockPos pos, Entity entity, Explosion explosion)
    {
        if (this.getMetaFromState(world.getBlockState(pos)) == 1)
        {
            return 100.0F;
        }
        return super.getExplosionResistance(world, pos, entity, explosion);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityIceCrystalMeteor();
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] { IMMUNE });
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(IMMUNE, Boolean.valueOf((meta & 1) == 1));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(IMMUNE).booleanValue() ? 1 : 0;
    }
}