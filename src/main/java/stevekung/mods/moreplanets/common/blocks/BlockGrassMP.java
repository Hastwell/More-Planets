/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.blocks;

import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;

public abstract class BlockGrassMP extends BlockBaseMP implements ITerraformableBlock
{
	public BlockGrassMP()
	{
		super(Material.grass);
		this.setTickRandomly(true);
		this.setStepSound(soundTypeGrass);
		this.setHardness(0.6F);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitVecX, float hitVecY, float hitVecZ)
	{
		if (player.getCurrentEquippedItem() != null)
		{
			if (player.getCurrentEquippedItem().getDisplayName().toLowerCase().contains("hoe"))
			{
				Block farmland = this.getFarmlandBlock();

				world.playSoundEffect(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, farmland.stepSound.getStepSound(), (farmland.stepSound.getVolume() + 1.0F) / 2.0F, farmland.stepSound.getFrequency() * 0.8F);

				if (!world.isRemote)
				{
					world.setBlockState(pos, farmland.getDefaultState(), 2);
				}
				player.getCurrentEquippedItem().damageItem(1, player);
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
	public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing side, IPlantable plant)
	{
		Block block = plant.getPlant(world, pos).getBlock();

		if (world.getBlockState(pos).getBlock() instanceof IFronosGrass)
		{
			return block == FronosBlocks.fronos_sapling || block == FronosBlocks.fronos_coral || block == FronosBlocks.fronos_dandelion || block == FronosBlocks.fronos_flower || block == FronosBlocks.fronos_poppy || block == FronosBlocks.fronos_tall_grass;
		}
		return super.canSustainPlant(world, pos, side, plant);
	}

	@Override
	public boolean isTerraformable(World world, BlockPos pos)
	{
		return true && !world.getBlockState(pos).getBlock().isOpaqueCube();
	}

	protected abstract Block getFarmlandBlock();
}