/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.core.init.MPBlocks;

public class BlockDoubleStoneSlab2MP extends BlockStoneSlab2MP
{
	public BlockDoubleStoneSlab2MP(String name, Material material)
	{
		super(material);
		this.setUnlocalizedName(name);
	}

	@Override
	public float getBlockHardness(World world, BlockPos pos)
	{
		int meta = this.getMetaFromState(world.getBlockState(pos));
		float hardness = this.blockHardness;

		switch (meta & 7)
		{
		case 1:
		case 2:
		case 3:
			hardness = 1.5F;
			break;
		case 4:
			hardness = 2.5F;
			break;
		default:
			hardness = 2.0F;
			break;
		}
		return hardness;
	}

	@Override
	public boolean isDouble()
	{
		return true;
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return null;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(MPBlocks.half_stone_slab_2);
	}

	@Override
	public int quantityDropped(Random rand)
	{
		return 2;
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return this.getMetaFromState(state) & 7;
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition moving, World world, BlockPos pos, EntityPlayer player)
	{
		return new ItemStack(MPBlocks.half_stone_slab_2, 1, this.getMetaFromState(world.getBlockState(pos)) & 7);
	}
}