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
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.client.EnumParticleTypesMP;
import stevekung.mods.moreplanets.common.blocks.BlockBushMP;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;

public class BlockFronosTallGrass extends BlockBushMP
{
	public static PropertyEnum VARIANT = PropertyEnum.create("variant", BlockType.class);

	public BlockFronosTallGrass(String name)
	{
		super();
		this.setDefaultState(this.getDefaultState().withProperty(VARIANT, BlockType.short_fronos_grass));
		this.setUnlocalizedName(name);
	}

	@Override
	public int getLightValue(IBlockAccess world, BlockPos pos)
	{
		int meta = this.getMetaFromState(world.getBlockState(pos));

		if (meta >= 13)
		{
			return 10;
		}
		return 0;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, BlockPos pos)
	{
		int meta = this.getMetaFromState(world.getBlockState(pos));

		switch (meta)
		{
		case 0:
		case 3:
		case 6:
		case 9:
		case 12:
			this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.5F, 0.9F);
			break;
		default:
			this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.8F, 0.9F);
			break;
		}
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		List<ItemStack> ret = new ArrayList<ItemStack>();
		ItemStack item = ForgeHooks.getGrassSeed(RANDOM);
		int meta = this.getMetaFromState(state);

		if (meta >= 12)
		{
			if (RANDOM.nextInt(15) == 0)
			{
				ret.add(new ItemStack(FronosItems.golden_seeds, 1));
			}
		}
		else
		{
			if (RANDOM.nextInt(8) != 0)
			{
				return ret;
			}
			if (item != null)
			{
				ret.add(item);
			}
		}
		return ret;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	{
		for (int i = 0; i < 15; ++i)
		{
			list.add(new ItemStack(this, 1, i));
		}
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
		int meta = this.getMetaFromState(world.getBlockState(pos));

		if (state.getBlock() != this)
		{
			return super.canBlockStay(world, pos, state);
		}
		if (meta >= 0 && meta <= 2)
		{
			return block.getBlock() == FronosBlocks.fronos_grass || block.getBlock() == FronosBlocks.fronos_dirt;
		}
		if (meta >= 3 && meta <= 5)
		{
			return block.getBlock() == FronosBlocks.pink_grass || block.getBlock() == FronosBlocks.fronos_dirt;
		}
		if (meta >= 6 && meta <= 8)
		{
			return block.getBlock() == FronosBlocks.purple_grass || block.getBlock() == FronosBlocks.fronos_dirt;
		}
		if (meta >= 9 && meta <= 11)
		{
			return block.getBlock() == FronosBlocks.plains_grass || block.getBlock() == FronosBlocks.fronos_dirt;
		}
		if (meta >= 12 && meta <= 14)
		{
			return block.getBlock() == FronosBlocks.golden_grass || block.getBlock() == FronosBlocks.fronos_dirt;
		}
		return super.canBlockStay(world, pos, state);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		int meta = this.getMetaFromState(state);

		if (meta >= 12)
		{
			if (rand.nextInt(1) == 0)
			{
				MorePlanetsCore.proxy.spawnParticle(EnumParticleTypesMP.GOLDEN_SMOKE, pos.getX() + rand.nextFloat(), pos.getY() + rand.nextFloat(), pos.getZ() + rand.nextFloat());
			}
		}
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return this.getMetaFromState(state);
	}

	@Override
	public boolean isReplaceable(World world, BlockPos pos)
	{
		return true;
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
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
	{
		return EnumPlantType.getPlantType("Fronos");
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos)
	{
		return FronosBlocks.fronos_tall_grass.getDefaultState();
	}

	public static enum BlockType implements IStringSerializable
	{
		short_fronos_grass,
		medium_fronos_grass,
		tall_fronos_grass,
		short_pink_grass,
		medium_pink_grass,
		tall_pink_grass,
		short_purple_grass,
		medium_purple_grass,
		tall_purple_grass,
		short_plains_grass,
		medium_plains_grass,
		tall_plains_grass,
		short_golden_grass,
		medium_golden_grass,
		tall_golden_grass;

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