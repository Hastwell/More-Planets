/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.asteroids.darkasteroids.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.blocks.BlockPlanetTileMP;

public class BlockDarkAsteroid extends BlockPlanetTileMP/* implements IDetectableResource*/
{
	public static PropertyEnum VARIANT = PropertyEnum.create("variant", BlockType.class);

	public BlockDarkAsteroid(String name)
	{
		super(Material.rock);
		this.setHardness(3.0F);
		this.setResistance(15.0F);
		this.setUnlocalizedName(name);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		int meta = this.getMetaFromState(state);

		if (meta == 6)
		{
			return GCItems.meteoricIronRaw;
		}
		if (meta == 7)
		{
			return GCItems.basicItem;
		}
		if (meta == 8)
		{
			return Items.diamond;
		}
		if (meta == 9)
		{
			return Items.emerald;
		}
		if (meta == 10)
		{
			return Items.dye;
		}
		return Item.getItemFromBlock(this);
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		if (this.getMetaFromState(state) == 4)
		{
			List<ItemStack> ret = new ArrayList<ItemStack>();
			Random rand = world instanceof World ? ((World)world).rand : RANDOM;
			int count = this.quantityDropped(state, fortune, rand);

			for (int i = 0; i < count; i++)
			{
				ret.add(new ItemStack(AsteroidsItems.basicItem, 1, 3));
			}
			for (int i = 0; i < count; i++)
			{
				ret.add(new ItemStack(AsteroidsItems.basicItem, 1, 4));
			}
			this.dropXpOnBlockBreak((World) world, pos, MathHelper.getRandomIntegerInRange(rand, 3, 5));
			return ret;
		}
		else
		{
			return super.getDrops(world, pos, state, fortune);
		}
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		int meta = this.getMetaFromState(state);

		if (meta == 6 || meta == 8 || meta == 9)
		{
			return 0;
		}
		if (meta == 7)
		{
			return 2;
		}
		if (meta == 10)
		{
			return 4;
		}
		return meta;
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random rand)
	{
		int meta = this.getMetaFromState(state);

		if (meta == 4)
		{
			if (fortune >= 1)
			{
				return rand.nextFloat() < fortune * 0.29F - 0.25F ? 2 : 1;
			}
		}
		if (meta == 10)
		{
			if (fortune > 0)
			{
				int j = rand.nextInt(fortune + 2) - 1;

				if (j < 0)
				{
					j = 0;
				}
				return 4 + rand.nextInt(5) * (j + 1);
			}
			else
			{
				return 4 + rand.nextInt(5);
			}
		}
		return super.quantityDropped(state, fortune, rand);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	{
		for (int i = 0; i < 11; ++i)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}

	/*@Override
	public boolean isValueable(int meta)
	{
		return meta >= 3;
	}*/

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player)
	{
		return new ItemStack(this, 1, this.getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player)
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

	public static enum BlockType implements IStringSerializable
	{
		dark_asteroid_rock_1,
		dark_asteroid_rock_2,
		dark_asteroid_rock_3,
		dark_asteroid_aluminum_ore,
		dark_asteroid_ilmenite_ore,
		dark_asteroid_iron_ore,
		dark_asteroid_meteoric_iron_ore,
		dark_asteroid_silicon_ore,
		dark_asteroid_diamond_ore,
		dark_asteroid_emerald_ore,
		dark_asteroid_lapis_ore;

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