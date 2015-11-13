/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.asteroids.darkasteroids.client;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityAlienSplashFX extends EntityFX
{
	public EntityAlienSplashFX(World world, double x, double y, double z, double moX, double moY, double moZ)
	{
		super(world, x, y, z, moX, moY, moZ);
		this.motionX *= 0.30000001192092896D;
		this.motionY = Math.random() * 0.20000000298023224D + 0.10000000149011612D;
		this.motionZ *= 0.30000001192092896D;
		this.particleRed = 0.1F;
		this.particleGreen = 0.1F;
		this.particleBlue = 0.1F;
		this.setParticleTextureIndex(19 + this.rand.nextInt(4));
		this.setSize(0.01F, 0.01F);
		this.particleGravity = 0.06F;
		this.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
	}

	@Override
	public void onUpdate()
	{
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.motionY -= this.particleGravity;
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;

		if (this.particleMaxAge-- <= 0)
		{
			this.setDead();
		}

		if (this.onGround)
		{
			if (Math.random() < 0.5D)
			{
				this.setDead();
			}
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
		}

		BlockPos blockpos = new BlockPos(this);
		IBlockState iblockstate = this.worldObj.getBlockState(blockpos);
		Block block = iblockstate.getBlock();
		block.setBlockBoundsBasedOnState(this.worldObj, blockpos);
		Material material = iblockstate.getBlock().getMaterial();

		if (material.isLiquid() || material.isSolid())
		{
			double d0 = 0.0D;

			if (iblockstate.getBlock() instanceof BlockLiquid)
			{
				d0 = 1.0F - BlockLiquid.getLiquidHeightPercent(((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue());
			}
			else
			{
				d0 = block.getBlockBoundsMaxY();
			}

			double d1 = MathHelper.floor_double(this.posY) + d0;

			if (this.posY < d1)
			{
				this.setDead();
			}
		}
	}
}