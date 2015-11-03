/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.core.init.MPBlocks;

public class BlockCheeseGlassPane extends BlockPane
{
	public BlockCheeseGlassPane(String name)
	{
		super(Material.glass, false);
		this.setStepSound(soundTypeGlass);
		this.setUnlocalizedName(name);
		this.setHardness(0.3F);
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return MorePlanetsCore.mpBlocksTab;
	}

	@Override
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.TRANSLUCENT;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, BlockPos pos)
	{
		float f = 0.4375F;
		float f1 = 0.5625F;
		float f2 = 0.4375F;
		float f3 = 0.5625F;
		boolean flag = this.canGlassPaneConnectToBlock(world.getBlockState(pos.north()).getBlock());
		boolean flag1 = this.canGlassPaneConnectToBlock(world.getBlockState(pos.south()).getBlock());
		boolean flag2 = this.canGlassPaneConnectToBlock(world.getBlockState(pos.west()).getBlock());
		boolean flag3 = this.canGlassPaneConnectToBlock(world.getBlockState(pos.east()).getBlock());

		if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1))
		{
			if (flag2)
			{
				f = 0.0F;
			}
			else if (flag3)
			{
				f1 = 1.0F;
			}
		}
		else
		{
			f = 0.0F;
			f1 = 1.0F;
		}

		if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1))
		{
			if (flag)
			{
				f2 = 0.0F;
			}
			else if (flag1)
			{
				f3 = 1.0F;
			}
		}
		else
		{
			f2 = 0.0F;
			f3 = 1.0F;
		}
		this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
	}

	private boolean canGlassPaneConnectToBlock(Block block)
	{
		return this.canPaneConnectToBlock(block) || block == MPBlocks.tinted_glass || block == FronosBlocks.cheese_glass;
	}

	@Override
	public boolean canPaneConnectTo(IBlockAccess world, BlockPos pos, EnumFacing facing)
	{
		BlockPos off = pos.offset(facing);
		Block block = world.getBlockState(off).getBlock();
		return block == MPBlocks.tinted_glass || block == FronosBlocks.cheese_glass || super.canPaneConnectTo(world, pos, facing);
	}
}