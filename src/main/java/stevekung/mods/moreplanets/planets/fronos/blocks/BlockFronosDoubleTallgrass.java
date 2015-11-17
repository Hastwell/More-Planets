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

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.client.EnumParticleTypesMP;
import stevekung.mods.moreplanets.common.blocks.BlockBushMP;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;

public class BlockFronosDoubleTallgrass extends BlockBushMP implements IShearable
{
	public static PropertyEnum VARIANT = PropertyEnum.create("variant", BlockFronosDoubleTallgrass.EnumPlantType.class);
	public static PropertyEnum HALF = PropertyEnum.create("half", BlockFronosDoubleTallgrass.EnumBlockHalf.class);

	public BlockFronosDoubleTallgrass(String name)
	{
		super(Material.vine);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockFronosDoubleTallgrass.EnumPlantType.fronos_double_tallgrass).withProperty(HALF, BlockFronosDoubleTallgrass.EnumBlockHalf.LOWER));
		this.setHardness(0.0F);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		this.setStepSound(soundTypeGrass);
		this.setUnlocalizedName(name);
	}

	private BlockFronosDoubleTallgrass.EnumPlantType getVariant(IBlockAccess world, BlockPos pos)
	{
		IBlockState iblockstate = world.getBlockState(pos);

		if (iblockstate.getBlock() == this)
		{
			iblockstate = this.getActualState(iblockstate, world, pos);
			return (BlockFronosDoubleTallgrass.EnumPlantType)iblockstate.getValue(VARIANT);
		}
		else
		{
			return BlockFronosDoubleTallgrass.EnumPlantType.fronos_double_tallgrass;
		}
	}

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos)
	{
		return super.canPlaceBlockAt(world, pos) && world.isAirBlock(pos.up());
	}

	@Override
	public boolean isReplaceable(World world, BlockPos pos)
	{
		IBlockState iblockstate = world.getBlockState(pos);

		if (iblockstate.getBlock() != this)
		{
			return true;
		}
		else
		{
			return true;
		}
	}

	@Override
	protected void checkAndDropBlock(World world, BlockPos pos, IBlockState state)
	{
		if (!this.canBlockStay(world, pos, state))
		{
			boolean flag = state.getValue(HALF) == EnumBlockHalf.UPPER;
			BlockPos blockpos1 = flag ? pos : pos.up();
			BlockPos blockpos2 = flag ? pos.down() : pos;
			Object object = flag ? this : world.getBlockState(blockpos1).getBlock();
			Object object1 = flag ? world.getBlockState(blockpos2).getBlock() : this;

			if (!flag)
			{
				this.dropBlockAsItem(world, pos, state, 0);
			}

			if (object == this)
			{
				world.setBlockState(blockpos1, Blocks.air.getDefaultState(), 3);
			}

			if (object1 == this)
			{
				world.setBlockState(blockpos2, Blocks.air.getDefaultState(), 3);
			}
		}
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		if (state.getValue(HALF) == EnumBlockHalf.UPPER)
		{
			return null;
		}
		else
		{
			EnumPlantType type = (EnumPlantType)state.getValue(VARIANT);

			if (type == EnumPlantType.golden_double_tallgrass)
			{
				return rand.nextInt(8) == 0 ? FronosItems.golden_seeds : null;
			}
			return rand.nextInt(8) == 0 ? Items.wheat_seeds : null;
		}
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return state.getValue(HALF) != EnumBlockHalf.UPPER && state.getValue(VARIANT) == EnumPlantType.fronos_double_tallgrass ? state.getValue(VARIANT) == EnumPlantType.golden_double_tallgrass ? 0 : ((EnumPlantType)state.getValue(VARIANT)).getMeta() : 0;
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		world.setBlockState(pos.up(), this.getDefaultState().withProperty(HALF, BlockFronosDoubleTallgrass.EnumBlockHalf.UPPER), 2);
	}

	@Override
	protected boolean canPlaceBlockOn(Block ground)
	{
		return ground == FronosBlocks.fronos_grass || ground == FronosBlocks.pink_grass || ground == FronosBlocks.purple_grass || ground == FronosBlocks.plains_grass || ground == FronosBlocks.golden_grass || ground == FronosBlocks.fronos_dirt;
	}

	@Override
	public boolean canBlockStay(World world, BlockPos pos, IBlockState state)
	{
		IBlockState block = world.getBlockState(pos.down());
		EnumPlantType type = (EnumPlantType)world.getBlockState(pos).getValue(VARIANT);

		if (state.getBlock() != this)
		{
			return super.canBlockStay(world, pos, state);
		}
		if (state.getValue(HALF) == EnumBlockHalf.UPPER)
		{
			return world.getBlockState(pos.down()).getBlock() == this;
		}
		if (type == EnumPlantType.fronos_double_tallgrass)
		{
			return block.getBlock() == FronosBlocks.fronos_grass || block.getBlock() == FronosBlocks.fronos_dirt;
		}
		if (type == EnumPlantType.pink_double_tallgrass)
		{
			return block.getBlock() == FronosBlocks.pink_grass || block.getBlock() == FronosBlocks.fronos_dirt;
		}
		if (type == EnumPlantType.purple_double_tallgrass)
		{
			return block.getBlock() == FronosBlocks.purple_grass || block.getBlock() == FronosBlocks.fronos_dirt;
		}
		if (type == EnumPlantType.plains_double_tallgrass)
		{
			return block.getBlock() == FronosBlocks.plains_grass || block.getBlock() == FronosBlocks.fronos_dirt;
		}
		if (type == EnumPlantType.golden_double_tallgrass)
		{
			return block.getBlock() == FronosBlocks.golden_grass || block.getBlock() == FronosBlocks.fronos_dirt;
		}
		else
		{
			IBlockState iblockstate1 = world.getBlockState(pos.up());
			return iblockstate1.getBlock() == this && super.canBlockStay(world, pos, iblockstate1);
		}
	}

	@Override
	public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		if (state.getValue(HALF) == BlockFronosDoubleTallgrass.EnumBlockHalf.UPPER)
		{
			if (world.getBlockState(pos.down()).getBlock() == this)
			{
				if (!player.capabilities.isCreativeMode)
				{
					IBlockState iblockstate1 = world.getBlockState(pos.down());
					world.destroyBlock(pos.down(), true);

					if (!world.isRemote)
					{
						if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Items.shears)
						{
							this.onHarvest(world, pos, iblockstate1, player);
							world.setBlockToAir(pos.down());
						}
						else
						{
							world.destroyBlock(pos.down(), true);
						}
					}
					else
					{
						world.setBlockToAir(pos.down());
					}
				}
				else
				{
					world.setBlockToAir(pos.down());
				}
			}
		}
		else if (player.capabilities.isCreativeMode && world.getBlockState(pos.up()).getBlock() == this)
		{
			world.setBlockState(pos.up(), Blocks.air.getDefaultState(), 2);
		}
		super.onBlockHarvested(world, pos, state, player);
	}

	private boolean onHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		BlockFronosDoubleTallgrass.EnumPlantType[] aenumplanttype = BlockFronosDoubleTallgrass.EnumPlantType.values();
		int i = aenumplanttype.length;

		for (int j = 0; j < i; ++j)
		{
			BlockFronosDoubleTallgrass.EnumPlantType enumplanttype = aenumplanttype[j];
			list.add(new ItemStack(itemIn, 1, enumplanttype.getMeta()));
		}
	}

	@Override
	public int getDamageValue(World world, BlockPos pos)
	{
		return this.getVariant(world, pos).getMeta();
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return (meta & 8) > 0 ? this.getDefaultState().withProperty(HALF, BlockFronosDoubleTallgrass.EnumBlockHalf.UPPER) : this.getDefaultState().withProperty(HALF, BlockFronosDoubleTallgrass.EnumBlockHalf.LOWER).withProperty(VARIANT, BlockFronosDoubleTallgrass.EnumPlantType.byMetadata(meta & 7));
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos)
	{
		if (state.getValue(HALF) == BlockFronosDoubleTallgrass.EnumBlockHalf.UPPER)
		{
			IBlockState iblockstate1 = world.getBlockState(pos.down());

			if (iblockstate1.getBlock() == this)
			{
				state = state.withProperty(VARIANT, iblockstate1.getValue(VARIANT));
			}
		}
		return state;
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(HALF) == BlockFronosDoubleTallgrass.EnumBlockHalf.UPPER ? 8 : ((BlockFronosDoubleTallgrass.EnumPlantType)state.getValue(VARIANT)).getMeta();
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] {HALF, VARIANT});
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Block.EnumOffsetType getOffsetType()
	{
		return Block.EnumOffsetType.XZ;
	}

	@Override
	public boolean isShearable(ItemStack itemStack, IBlockAccess world, BlockPos pos)
	{
		IBlockState state = world.getBlockState(pos);
		return state.getValue(HALF) == EnumBlockHalf.LOWER;
	}

	@Override
	public List<ItemStack> onSheared(ItemStack itemStack, IBlockAccess world, BlockPos pos, int fortune)
	{
		List<ItemStack> ret = new ArrayList<ItemStack>();
		EnumPlantType type = (EnumPlantType)world.getBlockState(pos).getValue(VARIANT);

		if (type == EnumPlantType.fronos_double_tallgrass)
		{
			ret.add(new ItemStack(FronosBlocks.fronos_tall_grass, 2, 2));
		}
		if (type == EnumPlantType.pink_double_tallgrass)
		{
			ret.add(new ItemStack(FronosBlocks.fronos_tall_grass, 2, 5));
		}
		if (type == EnumPlantType.purple_double_tallgrass)
		{
			ret.add(new ItemStack(FronosBlocks.fronos_tall_grass, 2, 8));
		}
		if (type == EnumPlantType.plains_double_tallgrass)
		{
			ret.add(new ItemStack(FronosBlocks.fronos_tall_grass, 2, 11));
		}
		if (type == EnumPlantType.golden_double_tallgrass)
		{
			ret.add(new ItemStack(FronosBlocks.fronos_tall_grass, 2, 14));
		}
		return ret;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		EnumPlantType type = (EnumPlantType)world.getBlockState(pos).getValue(VARIANT);

		if (type == EnumPlantType.golden_double_tallgrass && state.getValue(HALF) == EnumBlockHalf.LOWER)
		{
			if (rand.nextInt(1) == 0)
			{
				MorePlanetsCore.proxy.spawnParticle(EnumParticleTypesMP.GOLDEN_SMOKE, pos.getX() + rand.nextFloat(), pos.getY() + rand.nextFloat(), pos.getZ() + rand.nextFloat());
				MorePlanetsCore.proxy.spawnParticle(EnumParticleTypesMP.GOLDEN_SMOKE, pos.getX() + rand.nextFloat(), pos.getY() + 1.0D + rand.nextFloat(), pos.getZ() + rand.nextFloat());
			}
		}
	}

	@Override
	public boolean removedByPlayer(World world, BlockPos pos, EntityPlayer player, boolean willHarvest)
	{
		IBlockState state = world.getBlockState(pos);

		if (state.getBlock() ==  this && state.getValue(HALF) == EnumBlockHalf.LOWER && world.getBlockState(pos.up()).getBlock() == this)
		{
			world.setBlockToAir(pos.up());
		}
		return world.setBlockToAir(pos);
	}

	static enum EnumBlockHalf implements IStringSerializable
	{
		UPPER,
		LOWER;

		@Override
		public String toString()
		{
			return this.getName();
		}

		@Override
		public String getName()
		{
			return this == UPPER ? "upper" : "lower";
		}
	}

	public static enum EnumPlantType implements IStringSerializable
	{
		fronos_double_tallgrass(0),
		pink_double_tallgrass(1),
		purple_double_tallgrass(2),
		plains_double_tallgrass(3),
		golden_double_tallgrass(4);
		private static EnumPlantType[] META_LOOKUP = new EnumPlantType[values().length];
		private final int meta;

		private EnumPlantType(int meta)
		{
			this.meta = meta;
		}

		public int getMeta()
		{
			return this.meta;
		}

		@Override
		public String toString()
		{
			return this.getName();
		}

		public static EnumPlantType byMetadata(int meta)
		{
			if (meta < 0 || meta >= META_LOOKUP.length)
			{
				meta = 0;
			}
			return META_LOOKUP[meta];
		}

		@Override
		public String getName()
		{
			return this.name();
		}

		static
		{
			EnumPlantType[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2)
			{
				EnumPlantType var3 = var0[var2];
				META_LOOKUP[var3.getMeta()] = var3;
			}
		}
	}
}