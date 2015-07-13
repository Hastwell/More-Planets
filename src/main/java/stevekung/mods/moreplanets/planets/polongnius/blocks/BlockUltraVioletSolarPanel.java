/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.polongnius.blocks;

import micdoodle8.mods.galacticraft.api.block.IPartialSealableBlock;
import micdoodle8.mods.galacticraft.core.blocks.BlockTileGC;
import micdoodle8.mods.galacticraft.core.energy.tile.TileBaseUniversalElectrical;
import micdoodle8.mods.galacticraft.core.items.ItemBlockDesc.IBlockShiftDesc;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityUltraVioletSolarPanel;

public class BlockUltraVioletSolarPanel extends BlockTileGC implements IPartialSealableBlock, IBlockShiftDesc
{
	public static PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public BlockUltraVioletSolarPanel(String name)
	{
		super(Material.iron);
		this.setHardness(2.0F);
		this.setStepSound(soundTypeMetal);
		this.setDefaultState(this.getDefaultState().withProperty(FACING, EnumFacing.NORTH));
		this.setUnlocalizedName(name);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean isFullCube()
	{
		return true;
	}

	@Override
	public int getRenderType()
	{
		return 3;
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return MorePlanetsCore.mpBlocksTab;
	}

	@Override
	public boolean canPlaceBlockOnSide(World world, BlockPos pos, EnumFacing side)
	{
		for (int y = 1; y <= 2; y++)
		{
			for (int x = -1; x <= 1; x++)
			{
				for (int z = -1; z <= 1; z++)
				{
					Block block = world.getBlockState(new BlockPos(pos.getX() + (y == 2 ? x : 0), pos.getY() + y, pos.getZ() + (y == 2 ? z : 0))).getBlock();

					if (block.getMaterial() != Material.air && !block.isReplaceable(world, new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z)))
					{
						return false;
					}
				}
			}
		}
		return world.getBlockState(pos.up()).getBlock() != PolongniusBlocks.ultra_violet_solar_fake;
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack itemStack)
	{
		world.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);

		TileEntity tile = world.getTileEntity(pos);

		if (tile instanceof TileEntityUltraVioletSolarPanel)
		{
			((TileEntityUltraVioletSolarPanel)tile).onCreate(world, pos);
		}
	}

	@Override
	public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		TileEntity tile = world.getTileEntity(pos);

		if (tile instanceof TileEntityUltraVioletSolarPanel)
		{
			((TileEntityUltraVioletSolarPanel)tile).onDestroy(tile);
		}
		super.breakBlock(world, pos, state);
	}

	@Override
	public boolean onUseWrench(World world, BlockPos pos, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		world.setBlockState(pos, world.getBlockState(pos).withProperty(FACING, player.getHorizontalFacing().getOpposite()), 2);

		TileEntity tile = world.getTileEntity(pos);

		if (tile instanceof TileBaseUniversalElectrical)
		{
			((TileBaseUniversalElectrical)tile).updateFacing();
		}
		return true;
	}

	@Override
	public boolean onMachineActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entityPlayer, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		entityPlayer.openGui(MorePlanetsCore.instance, -1, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntityUltraVioletSolarPanel(5);
	}

	@Override
	public boolean isSealed(World world, BlockPos pos, EnumFacing side)
	{
		return true;
	}

	@Override
	public String getShiftDescription(int meta)
	{
		return StatCollector.translateToLocal(this.getUnlocalizedName() + ".desc");
	}

	@Override
	public boolean showDescription(int meta)
	{
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IBlockState getStateForEntityRender(IBlockState state)
	{
		return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		EnumFacing enumfacing = EnumFacing.getFront(meta);

		if (enumfacing.getAxis() == EnumFacing.Axis.Y)
		{
			enumfacing = EnumFacing.NORTH;
		}
		return this.getDefaultState().withProperty(FACING, enumfacing);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] {FACING});
	}
}