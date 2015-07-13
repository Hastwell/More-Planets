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
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.blocks.BlockFlowerMP;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.core.proxy.ClientProxyMP.ParticleTypesMP;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;

public class BlockFronosTallGrass extends BlockFlowerMP
{
	public static PropertyEnum VARIANT = PropertyEnum.create("variant", BlockType.class);

	public BlockFronosTallGrass(String name)
	{
		super();
		this.setDefaultState(this.getDefaultState().withProperty(VARIANT, BlockType.fronos_short_grass));
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
	public boolean canBlockStay(World world, BlockPos pos, IBlockState state)
	{
		/*Block blockTemp = world.getBlockState(pos).getBlock();

		if (!(blockTemp instanceof BlockFronosTallGrass))
		{
			return false;
		}*/

		int meta = ((BlockType)world.getBlockState(pos).getValue(VARIANT)).getMeta();
		Block block = world.getBlockState(pos.down()).getBlock();

		if (meta >= 0 && meta <= 2)
		{
			return block == FronosBlocks.fronos_grass || block == FronosBlocks.fronos_dirt;
		}
		if (meta >= 3 && meta <= 5)
		{
			return block == FronosBlocks.pink_grass || block == FronosBlocks.fronos_dirt;
		}
		if (meta >= 5 && meta <= 8)
		{
			return block == FronosBlocks.purple_grass || block == FronosBlocks.fronos_dirt;
		}
		if (meta >= 8 && meta <= 11)
		{
			return block == FronosBlocks.plains_grass || block == FronosBlocks.fronos_dirt;
		}
		if (meta >= 12 && meta <= 14)
		{
			return block == FronosBlocks.golden_grass || block == FronosBlocks.fronos_dirt;
		}
		return false;
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
				MorePlanetsCore.proxy.spawnParticle(ParticleTypesMP.GOLDEN_SMOKE, pos.getX() + rand.nextFloat(), pos.getY() + rand.nextFloat(), pos.getZ() + rand.nextFloat());
			}
		}
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		BlockType type = (BlockType)state.getValue(VARIANT);

		if (!world.isRemote)
		{
			if (rand.nextInt(1500) == 0)
			{
				if (type == BlockType.golden_short_grass)
				{
					world.setBlockState(pos, FronosBlocks.fronos_tall_grass.getDefaultState().withProperty(VARIANT, BlockType.fronos_short_grass), 3);
				}
				else if (type == BlockType.golden_short_grass)
				{
					world.setBlockState(pos, FronosBlocks.fronos_tall_grass.getDefaultState().withProperty(VARIANT, BlockType.fronos_medium_grass), 3);
				}
				else if (type == BlockType.golden_tall_grass)
				{
					world.setBlockState(pos, FronosBlocks.fronos_tall_grass.getDefaultState().withProperty(VARIANT, BlockType.fronos_tall_grass), 3);
				}
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
		return this.getDefaultState().withProperty(VARIANT, BlockType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((BlockType)state.getValue(VARIANT)).getMeta();
	}

	/*public static enum BlockType implements IStringSerializable
	{
		fronos_short_grass,
		fronos_medium_grass,
		fronos_tall_grass,
		pink_short_grass,
		pink_medium_grass,
		pink_tall_grass,
		purple_short_grass,
		purple_medium_grass,
		purple_tall_grass,
		plains_short_grass,
		plains_medium_grass,
		plains_tall_grass,
		golden_short_grass,
		golden_medium_grass,
		golden_tall_grass;

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
	}*/

	public static enum BlockType implements IStringSerializable
	{
		fronos_short_grass(0),
		fronos_medium_grass(1),
		fronos_tall_grass(2),
		pink_short_grass(3),
		pink_medium_grass(4),
		pink_tall_grass(5),
		purple_short_grass(6),
		purple_medium_grass(7),
		purple_tall_grass(8),
		plains_short_grass(9),
		plains_medium_grass(10),
		plains_tall_grass(11),
		golden_short_grass(12),
		golden_medium_grass(13),
		golden_tall_grass(14);

		private static BlockType[] META_LOOKUP = new BlockType[values().length];
		private int meta;

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

		public int getMeta()
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

			for (int i = 0; i < var1; ++i)
			{
				BlockType var3 = var0[i];
				META_LOOKUP[var3.getMeta()] = var3;
			}
		}
	}
}