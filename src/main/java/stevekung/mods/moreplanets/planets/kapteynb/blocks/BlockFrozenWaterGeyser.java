/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.blocks;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.blocks.BlockBaseMP;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.core.proxy.ClientProxyMP.ParticleTypesMP;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityFrozenWaterGeyser;

public class BlockFrozenWaterGeyser extends BlockBaseMP implements ITerraformableBlock, ITileEntityProvider
{
	public BlockFrozenWaterGeyser(String name)
	{
		super(Material.rock);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setUnlocalizedName(name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		for (int i = 0; i < 5; i++)
		{
			if (!World.doesBlockHaveSolidTopSurface(world, pos.up()))
			{
				MorePlanetsCore.proxy.spawnMotionParticle(ParticleTypesMP.FROZEN_WATER_GEYSER, pos.getX() + 0.5F, pos.getY() + 0.5F + rand.nextFloat(), pos.getZ() + 0.5F, 0.0D, 0.0D + rand.nextFloat(), 0.0D);
			}
		}
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(KapteynBBlocks.kapteyn_b_block);
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return 0;
	}

	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		return true;
	}

	@Override
	public boolean isTerraformable(World world, BlockPos pos)
	{
		return true && !world.getBlockState(pos.up()).getBlock().isOpaqueCube();
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntityFrozenWaterGeyser();
	}

	@Override
	public int getRenderType()
	{
		return 3;
	}
}