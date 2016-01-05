/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.entities.projectiles;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.planets.siriusb.blocks.SiriusBBlocks;

public class EntitySmallSiriusFireball extends EntityFireball
{
    public EntitySmallSiriusFireball(World world)
    {
        super(world);
        this.setSize(0.3125F, 0.3125F);
    }

    public EntitySmallSiriusFireball(World world, EntityLivingBase living, double x, double y, double z)
    {
        super(world, living, x, y, z);
        this.setSize(0.3125F, 0.3125F);
    }

    public EntitySmallSiriusFireball(World world, double x, double y, double z, double moX, double moY, double moZ)
    {
        super(world, x, y, z, moX, moY, moZ);
        this.setSize(0.3125F, 0.3125F);
    }

    @Override
    protected void onImpact(MovingObjectPosition movingObject)
    {
        if (!this.worldObj.isRemote)
        {
            boolean flag;

            if (movingObject.entityHit != null)
            {
                flag = movingObject.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 5.0F);

                if (flag)
                {
                    this.applyEnchantments(this.shootingEntity, movingObject.entityHit);

                    if (!movingObject.entityHit.isImmuneToFire())
                    {
                        movingObject.entityHit.setFire(5);
                    }
                }
            }
            else
            {
                flag = true;

                if (this.shootingEntity != null && this.shootingEntity instanceof EntityLiving)
                {
                    flag = this.worldObj.getGameRules().getBoolean("mobGriefing");
                }

                if (flag)
                {
                    BlockPos blockpos = movingObject.getBlockPos().offset(movingObject.sideHit);

                    if (this.worldObj.isAirBlock(blockpos))
                    {
                        this.worldObj.setBlockState(blockpos, SiriusBBlocks.sirius_fire.getDefaultState());
                    }
                }
            }
            this.setDead();
        }
    }

    @Override
    public boolean canBeCollidedWith()
    {
        return false;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        return false;
    }
}