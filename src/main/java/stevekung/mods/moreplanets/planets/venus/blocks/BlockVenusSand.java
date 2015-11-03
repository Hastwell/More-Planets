/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.blocks;

import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.core.MorePlanetsCore;

public class BlockVenusSand extends BlockFalling implements ITerraformableBlock
{
	public BlockVenusSand(String name)
	{
		super(Material.sand);
		this.setStepSound(soundTypeSand);
		this.setHardness(0.55F);
		this.setUnlocalizedName(name);
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return MorePlanetsCore.mpBlocksTab;
	}

	@Override
	public boolean isTerraformable(World world, BlockPos pos)
	{
		return true && !world.getBlockState(pos.up()).getBlock().isOpaqueCube();
	}
}