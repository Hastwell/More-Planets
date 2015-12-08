/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.nibiru.blocks;

import java.util.List;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.blocks.BlockLogMP;
import stevekung.mods.stevecore.BlockStateHelper;
import stevekung.mods.stevecore.BlockStateHelper.EnumAxis;
import stevekung.mods.stevecore.BlockStateHelper.SwitchEnumAxis;

public class BlockNibiruLog extends BlockLogMP
{
	public static PropertyEnum VARIANT = PropertyEnum.create("variant", BlockType.class);

	public BlockNibiruLog(String name)
	{
		this.setUnlocalizedName(name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockType.ancient_dark_wood).withProperty(BlockStateHelper.AXIS, EnumAxis.Y));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < 2; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		IBlockState state = this.getDefaultState().withProperty(VARIANT, BlockType.byMetadata(meta & 3));

		switch (meta & 12)
		{
		case 0:
			state = state.withProperty(BlockStateHelper.AXIS, EnumAxis.Y);
			break;
		case 4:
			state = state.withProperty(BlockStateHelper.AXIS, EnumAxis.X);
			break;
		case 8:
			state = state.withProperty(BlockStateHelper.AXIS, EnumAxis.Z);
			break;
		default:
			state = state.withProperty(BlockStateHelper.AXIS, EnumAxis.NONE);
		}
		return state;
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		byte b = 0;
		int i = b | ((BlockType)state.getValue(VARIANT)).getMetadata();

		switch (SwitchEnumAxis.AXIS_LOOKUP[((EnumAxis)state.getValue(BlockStateHelper.AXIS)).ordinal()])
		{
		case 1:
			i |= 4;
			break;
		case 2:
			i |= 8;
			break;
		case 3:
			i |= 12;
		}
		return i;
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { VARIANT, BlockStateHelper.AXIS });
	}

	@Override
	protected ItemStack createStackedBlock(IBlockState state)
	{
		return new ItemStack(this, 1, ((BlockType)state.getValue(VARIANT)).getMetadata());
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return ((BlockType)state.getValue(VARIANT)).getMetadata();
	}

	public static enum BlockType implements IStringSerializable
	{
		ancient_dark_wood(0, "ancient_dark_wood"),
		orange_wood(1, "orange_wood");

		int meta;
		private String unlocalizedName;
		private static BlockType[] META_LOOKUP = new BlockType[values().length];

		private BlockType(int meta, String unlocalizedName)
		{
			this.meta = meta;
			this.unlocalizedName = unlocalizedName;
		}

		public int getMetadata()
		{
			return this.meta;
		}

		public String getUnlocalizedName()
		{
			return this.unlocalizedName;
		}

		public static BlockType byMetadata(int meta)
		{
			if (meta < 0 || meta >= META_LOOKUP.length)
			{
				meta = 0;
			}
			return META_LOOKUP[meta];
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

		static
		{
			BlockType[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2)
			{
				BlockType var3 = var0[var2];
				META_LOOKUP[var3.getMetadata()] = var3;
			}
		}
	}
}