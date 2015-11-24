/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import stevekung.mods.moreplanets.common.items.ItemFoodMP2;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;

public class ItemGlassGemCorn extends ItemFoodMP2 implements IPlantable
{
	public ItemGlassGemCorn(String name)
	{
		super();
		this.setUnlocalizedName(name);
	}

	@Override
	public int getHealAmount(ItemStack itemStack)
	{
		return 4;
	}

	@Override
	public float getSaturationModifier(ItemStack itemStack)
	{
		return 0.25F;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos)
	{
		return FronosBlocks.glass_gem_corn.getDefaultState();
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
	{
		return EnumPlantType.Crop;
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (side != EnumFacing.UP)
		{
			return false;
		}
		else if (!player.canPlayerEdit(pos.offset(side), side, itemStack))
		{
			return false;
		}
		else if (world.getBlockState(pos).getBlock().canSustainPlant(world, pos, EnumFacing.UP, this) && world.isAirBlock(pos.up()))
		{
			world.setBlockState(pos.up(), FronosBlocks.glass_gem_corn.getDefaultState());
			world.playSoundEffect(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, FronosBlocks.glass_gem_corn.stepSound.getPlaceSound(), (FronosBlocks.glass_gem_corn.stepSound.getVolume() + 1.0F) / 2.0F, FronosBlocks.glass_gem_corn.stepSound.getFrequency() * 0.8F);
			--itemStack.stackSize;
			return true;
		}
		else
		{
			return false;
		}
	}
}