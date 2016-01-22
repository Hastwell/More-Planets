/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.blocks;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.client.EnumParticleTypesMP;
import stevekung.mods.moreplanets.common.blocks.BlockBushMP;
import stevekung.mods.moreplanets.common.blocks.ICustomBlockProperty;
import stevekung.mods.moreplanets.common.util.DamageSourceMP;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.core.init.MPBlocks;
import stevekung.mods.moreplanets.planets.fronos.world.gen.feature.WorldGenBigSkyMushroom;

public class BlockFronosFlower extends BlockBushMP implements IGrowable
{
    public static PropertyEnum VARIANT = PropertyEnum.create("variant", BlockType.class);

    public BlockFronosFlower(String name)
    {
        super();
        float var4 = 0.2F;
        this.setDefaultState(this.getDefaultState().withProperty(VARIANT, BlockType.pink_butter_cup));
        this.setUnlocalizedName(name);
        this.setBlockBounds(0.5F - var4, 0.0F, 0.5F - var4, 0.5F + var4, var4 * 3.0F, 0.5F + var4);
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if (this.getMetaFromState(state) == 4)
        {
            if (rand.nextInt(25) == 0)
            {
                int i = 5;
                Iterator iterator = BlockPos.getAllInBoxMutable(pos.add(-4, -1, -4), pos.add(4, 1, 4)).iterator();

                while (iterator.hasNext())
                {
                    BlockPos blockpos1 = (BlockPos)iterator.next();

                    if (world.getBlockState(blockpos1).getBlock() == this && this.getMetaFromState(state) == 4)
                    {
                        --i;

                        if (i <= 0)
                        {
                            return;
                        }
                    }
                }

                BlockPos blockpos2 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);

                for (int j = 0; j < 4; ++j)
                {
                    if (world.isAirBlock(blockpos2) && this.canPlaceBlockOn(world.getBlockState(blockpos2.down()).getBlock()))
                    {
                        pos = blockpos2;
                    }
                    blockpos2 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
                }
                if (world.isAirBlock(blockpos2) && this.canPlaceBlockOn(world.getBlockState(blockpos2.down()).getBlock()))
                {
                    world.setBlockState(blockpos2, this.getDefaultState().withProperty(VARIANT, BlockType.sky_mushroom), 2);
                }
            }
        }
    }

    @Override
    public int getLightValue(IBlockAccess world, BlockPos pos)
    {
        BlockType type = (BlockType)world.getBlockState(pos).getValue(VARIANT);

        if (type == BlockType.yellow_milk_cap || type == BlockType.purple_spike_flower)
        {
            return 4;
        }
        else if (type == BlockType.blue_poison_mushroom)
        {
            return 2;
        }
        return 0;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, BlockPos pos)
    {
        BlockType type = (BlockType)world.getBlockState(pos).getValue(VARIANT);

        switch (type)
        {
        case yellow_milk_cap:
            this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.5F, 0.7F);
            break;
        case little_sun_flower:
            this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.8F, 0.7F);
            break;
        case purple_spike_flower:
            this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.75F, 0.8F);
            break;
        case jungle_iris:
            this.setBlockBounds(0.15F, 0.0F, 0.15F, 0.85F, 0.95F, 0.85F);
            break;
        case sky_mushroom:
        case blue_poison_mushroom:
            this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.45F, 0.7F);
            break;
        case white_moss:
            this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 0.95F, 0.7F);
            break;
        default:
            this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.8F, 0.9F);
            break;
        }
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
    {
        BlockType type = (BlockType)state.getValue(VARIANT);

        if (entity instanceof EntityLivingBase)
        {
            if (type == BlockType.purple_spike_flower)
            {
                if (entity instanceof EntityPlayer)
                {
                    EntityPlayer player = (EntityPlayer) entity;
                    InventoryPlayer inventory = ((EntityPlayer)entity).inventory;
                    boolean boots = inventory.armorInventory[0] != null && inventory.armorInventory[0].getItem() instanceof ItemArmor && ((ItemArmor)inventory.armorInventory[0].getItem()).armorType == 3;
                    boolean leggings = inventory.armorInventory[1] != null && inventory.armorInventory[1].getItem() instanceof ItemArmor && ((ItemArmor)inventory.armorInventory[1].getItem()).armorType == 2;
                    boolean full = leggings && boots;

                    if (!full)
                    {
                        player.attackEntityFrom(DamageSourceMP.purple_spike, (int) (4.0D * 0.15 + 1.0D));
                    }
                }
                else
                {
                    ((EntityLivingBase)entity).attackEntityFrom(DamageSourceMP.purple_spike, (int) (4.0D * 0.15 + 1.0D));
                }
            }
            else if (type == BlockType.blue_poison_mushroom)
            {
                if (entity instanceof EntityPlayer)
                {
                    EntityPlayer player = (EntityPlayer) entity;
                    InventoryPlayer inventory = ((EntityPlayer)entity).inventory;
                    boolean boots = inventory.armorInventory[0] != null && inventory.armorInventory[0].getItem() instanceof ItemArmor && ((ItemArmor)inventory.armorInventory[0].getItem()).armorType == 3;
                    boolean leggings = inventory.armorInventory[1] != null && inventory.armorInventory[1].getItem() instanceof ItemArmor && ((ItemArmor)inventory.armorInventory[1].getItem()).armorType == 2;
                    boolean full = leggings && boots;

                    if (player.capabilities.isCreativeMode)
                    {
                        return;
                    }
                    if (!full)
                    {
                        player.addPotionEffect(new PotionEffect(Potion.poison.id, 120));
                    }
                }
                else
                {
                    ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 120));
                }
            }
        }
    }

    @Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity tile)
    {
        super.harvestBlock(world, player, pos, state, tile);
        BlockType type = (BlockType)state.getValue(VARIANT);
        ItemStack equippedItem = player.getCurrentEquippedItem();

        if (equippedItem != null)
        {
            if (equippedItem.getItem() != Items.shears)
            {
                if (type == BlockType.purple_spike_flower)
                {
                    player.attackEntityFrom(DamageSourceMP.purple_spike, (int) (4.0D * 0.15 + 1.0D));
                }
                else if (type == BlockType.blue_poison_mushroom)
                {
                    player.addPotionEffect(new PotionEffect(Potion.poison.id, 100));
                }
            }
        }
        else
        {
            if (type == BlockType.purple_spike_flower)
            {
                player.attackEntityFrom(DamageSourceMP.purple_spike, (int) (4.0D * 0.15 + 1.0D));
            }
            else if (type == BlockType.blue_poison_mushroom)
            {
                player.addPotionEffect(new PotionEffect(Potion.poison.id, 100));
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        BlockType type = (BlockType)state.getValue(VARIANT);

        if (type == BlockType.purple_spike_flower)
        {
            if (rand.nextInt(1) == 0)
            {
                MorePlanetsCore.proxy.spawnParticle(EnumParticleTypesMP.PURPLE_SPIKE, pos.getX() + rand.nextFloat(), pos.getY() + rand.nextFloat(), pos.getZ() + rand.nextFloat());
            }
        }
        else if (type == BlockType.jungle_iris)
        {
            if (rand.nextInt(5) == 0)
            {
                for (int i = 0; i < 1; i++)
                {
                    double d0 = rand.nextGaussian() * 0.02D;
                    double d1 = rand.nextGaussian() * 0.02D;
                    double d2 = rand.nextGaussian() * 0.02D;
                    MorePlanetsCore.proxy.spawnParticle(EnumParticleTypesMP.JUNGLE_IRIS, pos.getX() + rand.nextFloat(), pos.getY() + rand.nextFloat() * 1.0D, pos.getZ() + rand.nextFloat(), d0, d1, d2);
                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        for (int i = 0; i < 9; ++i)
        {
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return this.getMetaFromState(state);
    }

    @Override
    public boolean canPlaceBlockOn(Block ground)
    {
        return ground instanceof ICustomBlockProperty && ((ICustomBlockProperty)ground).getProperty() == 0 || ground == FronosBlocks.fronos_dirt || ground == FronosBlocks.fronos_sand || ground == FronosBlocks.fronos_block || ground == MPBlocks.space_mossy_cobblestone || ground == FronosBlocks.jelly_ore;
    }

    @Override
    public boolean canBlockStay(World world, BlockPos pos, IBlockState state)
    {
        IBlockState ground = world.getBlockState(pos.down());
        int meta = this.getMetaFromState(world.getBlockState(pos));

        if (state.getBlock() != this)
        {
            return super.canBlockStay(world, pos, state);
        }
        if (meta >= 0 && meta <= 3 || meta == 5 || meta == 6)
        {
            return ground.getBlock() instanceof ICustomBlockProperty && ((ICustomBlockProperty)ground.getBlock()).getProperty() == 0 || ground.getBlock() == FronosBlocks.fronos_dirt;
        }
        if (meta == 4)
        {
            return ground.getBlock() == FronosBlocks.fronos_block || ground.getBlock() == FronosBlocks.jelly_ore || ground.getBlock() == MPBlocks.space_mossy_cobblestone;
        }
        if (meta == 7)
        {
            return ground.getBlock() == FronosBlocks.fronos_block || ground.getBlock() instanceof ICustomBlockProperty && ((ICustomBlockProperty)ground.getBlock()).getProperty() == 0 || ground.getBlock() == FronosBlocks.fronos_dirt || ground.getBlock() == FronosBlocks.jelly_ore || ground.getBlock() == MPBlocks.space_mossy_cobblestone;
        }
        if (meta == 8)
        {
            return ground == FronosBlocks.fronos_sand.getDefaultState().withProperty(BlockFronosSand.VARIANT, BlockFronosSand.BlockType.white_sand);
        }
        return super.canBlockStay(world, pos, state);
    }

    @Override
    public boolean isReplaceable(World world, BlockPos pos)
    {
        return false;
    }

    @Override
    public boolean canGrow(World world, BlockPos pos, IBlockState state, boolean isClient)
    {
        return this.getMetaFromState(state) == 4 ? true : false;
    }

    @Override
    public boolean canUseBonemeal(World world, Random rand, BlockPos pos, IBlockState state)
    {
        return this.getMetaFromState(state) == 4 ? rand.nextFloat() < 0.4D : false;
    }

    @Override
    public void grow(World world, Random rand, BlockPos pos, IBlockState state)
    {
        if (this.getMetaFromState(state) == 4)
        {
            this.generateBigMushroom(world, pos, state, rand);
        }
    }

    private boolean generateBigMushroom(World world, BlockPos pos, IBlockState state, Random rand)
    {
        world.setBlockToAir(pos);
        WorldGenBigSkyMushroom worldgenbigmushroom = new WorldGenBigSkyMushroom();

        if (worldgenbigmushroom != null && worldgenbigmushroom.generate(world, rand, pos))
        {
            return true;
        }
        else
        {
            world.setBlockState(pos, state.withProperty(VARIANT, BlockType.sky_mushroom), 3);
            return false;
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
        pink_butter_cup,
        orange_butterfly_flower,
        yellow_milk_cap,
        little_sun_flower,
        sky_mushroom,
        purple_spike_flower,
        jungle_iris,
        blue_poison_mushroom,
        white_moss;

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