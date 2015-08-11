/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.blocks.BlockBaseMP;

public class BlockEuropaGeyser extends BlockBaseMP
{
	public static PropertyEnum VARIANT = PropertyEnum.create("variant", BlockType.class);

	public BlockEuropaGeyser(String name)
	{
		super(Material.rock);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setUnlocalizedName(name);
		this.setDefaultState(this.getDefaultState().withProperty(VARIANT, BlockType.europa_underwater_geyser));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		if (!World.doesBlockHaveSolidTopSurface(world, pos.up()))
		{
			if (state == state.withProperty(VARIANT, BlockType.europa_underwater_geyser))
			{
				for (int i = 0; i < 20; i++)
				{
					world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, pos.getX() + 0.5F, pos.getY() + 0.5F + rand.nextFloat(), pos.getZ() + 0.5F, 0.0D + rand.nextDouble() - rand.nextDouble(), 0.0D + rand.nextFloat() + rand.nextInt(2), 0.0D + rand.nextDouble() - rand.nextDouble());
				}
			}
			else if (state == state.withProperty(VARIANT, BlockType.europa_underwater_smoke_geyser))
			{
				for (int i = 0; i < 20; i++)
				{
					world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, pos.getX() + 0.5F, pos.getY() + 0.5F + rand.nextFloat(), pos.getZ() + 0.5F, 0.0D, 0.0D + rand.nextFloat() + rand.nextInt(2), 0.0D);
					world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, pos.getX() + 0.5F, pos.getY() + 0.5F + rand.nextFloat(), pos.getZ() + 0.5F, 0.0D, 0.0D, 0.0D);
				}
			}
		}
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
		return Item.getItemFromBlock(EuropaBlocks.europa_geyser);
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return this.getMetaFromState(state);
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
		europa_underwater_geyser,
		europa_underwater_smoke_geyser;

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