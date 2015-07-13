/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.blocks;

import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.blocks.BlockTreasureChestMP;
import stevekung.mods.moreplanets.planets.venus.tileentities.TileEntityVenusTreasureChest;

public class BlockVenusTreasureChest extends BlockTreasureChestMP
{
	public BlockVenusTreasureChest(String name)
	{
		super();
		this.setUnlocalizedName(name);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return true;
		}
		else
		{
			ILockableContainer ilockablecontainer = this.getLockableContainer(world, pos);

			if (ilockablecontainer != null)
			{
				player.displayGUIChest(ilockablecontainer);
			}
			return true;
		}
	}

	public ILockableContainer getLockableContainer(World world, BlockPos pos)
	{
		TileEntity tileentity = world.getTileEntity(pos);

		if (!(tileentity instanceof TileEntityVenusTreasureChest))
		{
			return null;
		}
		else
		{
			Object object = tileentity;

			if (this.cannotOpenChest(world, pos))
			{
				return null;
			}
			else
			{
				Iterator iterator = EnumFacing.Plane.HORIZONTAL.iterator();

				while (iterator.hasNext())
				{
					EnumFacing enumfacing = (EnumFacing)iterator.next();
					BlockPos blockpos1 = pos.offset(enumfacing);
					Block block = world.getBlockState(blockpos1).getBlock();

					if (block == this)
					{
						if (this.cannotOpenChest(world, blockpos1))
						{
							return null;
						}
					}
				}
				return (ILockableContainer)object;
			}
		}
	}

	@Override
	public int getComparatorInputOverride(World world, BlockPos pos)
	{
		return Container.calcRedstoneFromInventory(this.getLockableContainer(world, pos));
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntityVenusTreasureChest();
	}
}