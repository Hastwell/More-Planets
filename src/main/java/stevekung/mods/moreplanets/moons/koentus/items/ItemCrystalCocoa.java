package stevekung.mods.moreplanets.moons.koentus.items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.items.ItemMorePlanets;
import stevekung.mods.moreplanets.moons.koentus.blocks.KoentusBlocks;

public class ItemCrystalCocoa extends ItemMorePlanets
{
	public ItemCrystalCocoa(String name)
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
			IBlockState iblockstate = world.getBlockState(pos);
			Block block = iblockstate.getBlock();

			if (block == KoentusBlocks.crystal_log)
			{
				if (side == EnumFacing.DOWN)
				{
					return false;
				}
				if (side == EnumFacing.UP)
				{
					return false;
				}

				pos = pos.offset(side);

				if (world.isAirBlock(pos))
				{
					IBlockState iblockstate1 = KoentusBlocks.crystal_cocoa.onBlockPlaced(world, pos, side, hitX, hitY, hitZ, 0, player);
					world.setBlockState(pos, iblockstate1, 2);

					if (!player.capabilities.isCreativeMode)
					{
						--itemStack.stackSize;
					}
					return true;
				}
				return false;
			}
			return false;
		}
	}
}