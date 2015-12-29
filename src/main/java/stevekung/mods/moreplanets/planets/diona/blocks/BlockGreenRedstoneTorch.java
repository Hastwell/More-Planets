package stevekung.mods.moreplanets.planets.diona.blocks;

import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.client.EnumParticleTypesMP;
import stevekung.mods.moreplanets.core.MorePlanetsCore;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class BlockGreenRedstoneTorch extends BlockTorch
{
    public BlockGreenRedstoneTorch(String name, boolean isOn)
    {
        this.isOn = isOn;
        this.setUnlocalizedName(name);
        this.setTickRandomly(true);
        this.setStepSound(soundTypeWood);
    }

    private Map toggles = Maps.newHashMap();
    private boolean isOn;

    private boolean isBurnedOut(World world, BlockPos pos, boolean off)
    {
        if (!this.toggles.containsKey(world))
        {
            this.toggles.put(world, Lists.newArrayList());
        }

        List list = (List)this.toggles.get(world);

        if (off)
        {
            list.add(new Toggle(pos, world.getTotalWorldTime()));
        }

        int i = 0;

        for (int j = 0; j < list.size(); ++j)
        {
            Toggle toggle = (Toggle)list.get(j);

            if (toggle.pos.equals(pos))
            {
                ++i;

                if (i >= 8)
                {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public CreativeTabs getCreativeTabToDisplayOn()
    {
        return this.isOn ? MorePlanetsCore.mpBlocksTab : null;
    }

    @Override
    public int tickRate(World world)
    {
        return 2;
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
        if (this.isOn)
        {
            EnumFacing[] aenumfacing = EnumFacing.values();
            int i = aenumfacing.length;

            for (int j = 0; j < i; ++j)
            {
                EnumFacing enumfacing = aenumfacing[j];
                world.notifyNeighborsOfStateChange(pos.offset(enumfacing), this);
            }
        }
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        if (this.isOn)
        {
            EnumFacing[] aenumfacing = EnumFacing.values();
            int i = aenumfacing.length;

            for (int j = 0; j < i; ++j)
            {
                EnumFacing enumfacing = aenumfacing[j];
                world.notifyNeighborsOfStateChange(pos.offset(enumfacing), this);
            }
        }
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess world, BlockPos pos, IBlockState state, EnumFacing side)
    {
        return this.isOn && state.getValue(FACING) != side ? 15 : 0;
    }

    private boolean shouldBeOff(World world, BlockPos pos, IBlockState state)
    {
        EnumFacing enumfacing = state.getValue(FACING).getOpposite();
        return world.isSidePowered(pos.offset(enumfacing), enumfacing);
    }

    @Override
    public void randomTick(World world, BlockPos pos, IBlockState state, Random rand) {}

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        boolean flag = this.shouldBeOff(world, pos, state);
        List list = (List)this.toggles.get(world);

        while (list != null && !list.isEmpty() && world.getTotalWorldTime() - ((Toggle)list.get(0)).time > 60L)
        {
            list.remove(0);
        }

        if (this.isOn)
        {
            if (flag)
            {
                world.setBlockState(pos, DionaBlocks.green_redstone_torch_off.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);

                if (this.isBurnedOut(world, pos, true))
                {
                    world.playSoundEffect(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

                    for (int i = 0; i < 5; ++i)
                    {
                        double d0 = pos.getX() + rand.nextDouble() * 0.6D + 0.2D;
                        double d1 = pos.getY() + rand.nextDouble() * 0.6D + 0.2D;
                        double d2 = pos.getZ() + rand.nextDouble() * 0.6D + 0.2D;
                        world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
                    }
                    world.scheduleUpdate(pos, world.getBlockState(pos).getBlock(), 160);
                }
            }
        }
        else if (!flag && !this.isBurnedOut(world, pos, false))
        {
            world.setBlockState(pos, DionaBlocks.green_redstone_torch.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
        }
    }

    @Override
    public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        if (!this.onNeighborChangeInternal(world, pos, state))
        {
            if (this.isOn == this.shouldBeOff(world, pos, state))
            {
                world.scheduleUpdate(pos, this, this.tickRate(world));
            }
        }
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess world, BlockPos pos, IBlockState state, EnumFacing side)
    {
        return side == EnumFacing.DOWN ? this.isProvidingWeakPower(world, pos, state, side) : 0;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(DionaBlocks.green_redstone_torch);
    }

    @Override
    public boolean canProvidePower()
    {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if (this.isOn)
        {
            EnumFacing enumfacing = state.getValue(FACING);
            double d0 = pos.getX() + 0.5D;
            double d1 = pos.getY() + 0.7D;
            double d2 = pos.getZ() + 0.5D;
            double d3 = 0.22D;
            double d4 = 0.27D;

            if (enumfacing.getAxis().isHorizontal())
            {
                EnumFacing enumfacing1 = enumfacing.getOpposite();
                MorePlanetsCore.proxy.spawnParticle(EnumParticleTypesMP.GREEN_SMOKE, d0 + d4 * enumfacing1.getFrontOffsetX(), d1 + d3, d2 + d4 * enumfacing1.getFrontOffsetZ());
            }
            else
            {
                MorePlanetsCore.proxy.spawnParticle(EnumParticleTypesMP.GREEN_SMOKE, d0, d1, d2);
            }
        }
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition moving, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(DionaBlocks.green_redstone_torch);
    }

    @Override
    public boolean isAssociatedBlock(Block block)
    {
        return block == DionaBlocks.green_redstone_torch_off || block == DionaBlocks.green_redstone_torch;
    }

    static class Toggle
    {
        BlockPos pos;
        long time;

        public Toggle(BlockPos pos, long time)
        {
            this.pos = pos;
            this.time = time;
        }
    }
}