/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.items.ItemBaseMP;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;

public class ItemPearl extends ItemBaseMP
{
	public ItemPearl(String name)
	{
		super();
		this.setUnlocalizedName(name);
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float par8, float par9, float par10)
	{
		Block block = world.getBlockState(pos).getBlock();

		if (player.canPlayerEdit(pos, side, itemStack) && block == FronosBlocks.fronos_grass)
		{
			if (itemStack.getItemDamage() == 0)
			{
				if (world.isRemote)
				{
					return true;
				}
				else
				{
					world.setBlockState(pos, FronosBlocks.golden_grass.getDefaultState());

					if (world.rand.nextInt(2) == 0)
					{
						world.setBlockState(pos.up(), FronosBlocks.fronos_tall_grass.getStateFromMeta(world.rand.nextInt(3) + 12), 3);
					}
					--itemStack.stackSize;
				}
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isBeaconPayment(ItemStack itemStack)
	{
		return itemStack.getItem() != null && itemStack.getItem() == this && itemStack.getItemDamage() == 1;
	}

	@Override
	protected String[] getItemVariantsName()
	{
		return new String[] { "cream_pearl", "cavern_pearl" };
	}
}