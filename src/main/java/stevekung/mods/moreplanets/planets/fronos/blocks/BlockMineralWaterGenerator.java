/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.blocks;

import micdoodle8.mods.galacticraft.core.blocks.BlockTileGC;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.planets.fronos.tileentities.TileEntityMineralWaterGenerator;

public class BlockMineralWaterGenerator extends BlockTileGC
{
	public static PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public BlockMineralWaterGenerator(String name)
	{
		super(Material.iron);
		this.setHardness(2.0F);
		this.setStepSound(soundTypeMetal);
		this.setDefaultState(this.getDefaultState().withProperty(FACING, EnumFacing.NORTH));
		this.setUnlocalizedName(name);
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return MorePlanetsCore.mpBlocksTab;
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack itemStack)
	{
		world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}

	@Override
	public boolean onUseWrench(World world, BlockPos pos, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		world.setBlockState(pos, world.getBlockState(pos).withProperty(FACING, player.getHorizontalFacing().getOpposite()), 2);
		return true;
	}

	@Override
	public boolean onMachineActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			player.openGui(MorePlanetsCore.instance, -1, world, pos.getX(), pos.getY(), pos.getZ());
			return true;
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityMineralWaterGenerator();
	}
}