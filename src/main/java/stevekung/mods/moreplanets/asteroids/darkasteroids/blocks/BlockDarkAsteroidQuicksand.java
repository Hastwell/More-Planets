/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.asteroids.darkasteroids.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.blocks.BlockBaseMP;

public class BlockDarkAsteroidQuicksand extends BlockBaseMP
{
	public BlockDarkAsteroidQuicksand(String name)
	{
		super(Material.sand);
		this.setHardness(0.5F);
		this.setStepSound(soundTypeSand);
		this.setUnlocalizedName(name);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World world, BlockPos pos, IBlockState state)
	{
		return null;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return true;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
	{
		entity.setInWeb();
	}
}