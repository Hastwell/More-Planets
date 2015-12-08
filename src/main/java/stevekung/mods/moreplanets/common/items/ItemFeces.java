/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.items;

import java.util.List;

import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFeces extends ItemMorePlanets
{
	private static int DECOMPOSE = 1800 * 20;

	public ItemFeces(String name)
	{
		super();
		this.setUnlocalizedName(name);
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (!player.canPlayerEdit(pos.offset(side), side, itemStack))
		{
			return false;
		}
		else
		{
			if (this.applyBonemeal(itemStack, world, pos, player))
			{
				if (!world.isRemote)
				{
					world.playAuxSFX(2005, pos, 0);
				}
				return true;
			}
			return false;
		}
	}

	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int slot, boolean selected)
	{
		if (!world.isRemote)
		{
			if (itemStack.hasTagCompound())
			{
				float time = itemStack.getTagCompound().getFloat("Decompose");

				if (time >= 0.5F)
				{
					time -= 1.0F;
					itemStack.getTagCompound().setFloat("Decompose", time);
				}
			}
			else
			{
				itemStack.setTagCompound(new NBTTagCompound());
				itemStack.getTagCompound().setFloat("Decompose", DECOMPOSE);
			}
		}
	}

	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player)
	{
		if (!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());
		}
		itemStack.getTagCompound().setFloat("Decompose", DECOMPOSE);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced)
	{
		float time = 0.0F;

		if (itemStack.hasTagCompound())
		{
			float time1 = itemStack.getTagCompound().getFloat("Decompose");
			time = Math.round(time1 / 10.0F) / 2.0F;
		}
		else
		{
			time = 1800.0F;
		}
		list.add(StatCollector.translateToLocal("desc.decompose.name") + " " + (int)time + StatCollector.translateToLocal("gui.seconds"));
	}

	private boolean applyBonemeal(ItemStack itemStack, World world, BlockPos target, EntityPlayer player)
	{
		IBlockState iblockstate = world.getBlockState(target);
		int hook = ForgeEventFactory.onApplyBonemeal(player, world, target, iblockstate, itemStack);

		if (hook != 0)
		{
			return hook > 0;
		}

		if (iblockstate.getBlock() instanceof IGrowable)
		{
			IGrowable igrowable = (IGrowable)iblockstate.getBlock();

			if (igrowable.canGrow(world, target, iblockstate, world.isRemote))
			{
				if (!world.isRemote)
				{
					if (igrowable.canUseBonemeal(world, world.rand, target, iblockstate))
					{
						igrowable.grow(world, world.rand, target, iblockstate);
					}
					if (itemStack.getTagCompound().getFloat("Decompose") == 0.0F)
					{
						--itemStack.stackSize;
					}
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean onEntityItemUpdate(EntityItem item)
	{
		if (item.getEntityItem().hasTagCompound())
		{
			float time = item.getEntityItem().getTagCompound().getFloat("Decompose");

			if (time >= 0.5F)
			{
				time -= 1.0F;
				item.getEntityItem().getTagCompound().setFloat("Decompose", time);
			}
		}
		else
		{
			item.getEntityItem().setTagCompound(new NBTTagCompound());
			item.getEntityItem().getTagCompound().setFloat("Decompose", DECOMPOSE);
		}
		return false;
	}

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged)
	{
		return slotChanged;
	}
}