/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.moons.europa.world.EuropaWaterExplosion;

public class EntityEuropaWaterBomb extends EntityTNTPrimed
{
    public EntityEuropaWaterBomb(World world)
    {
        super(world);
        this.fuse = 80;
    }

    public EntityEuropaWaterBomb(World world, double x, double y, double z, EntityLivingBase entityLiving)
    {
        this(world);
        this.setPosition(x, y, z);
        float f = (float)(Math.random() * Math.PI * 2.0D);
        this.motionX = -((float)Math.sin(f)) * 0.02F;
        this.motionY = 0.20000000298023224D;
        this.motionZ = -((float)Math.cos(f)) * 0.02F;
        this.fuse = 80;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }

    @Override
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= 0.03999999910593033D;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863D;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= 0.9800000190734863D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
            this.motionY *= -0.5D;
        }

        if (this.fuse-- <= 0)
        {
            this.setDead();

            if (!this.worldObj.isRemote)
            {
                this.explode();
            }
        }
        else
        {
            this.handleWaterMovement();
            this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
            this.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, this.posX, this.posY + 1.0D, this.posZ, 0.0D, 0.35D, 0.0D);
        }
    }

    private void explode()
    {
        float f = 4.0F;
        EuropaWaterExplosion explosion = new EuropaWaterExplosion(this.worldObj, this, this.posX, this.posY, this.posZ, f, true);
        explosion.doExplosionA();
        explosion.doExplosionB(true);
    }
}