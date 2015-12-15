/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.client.EnumParticleTypesMP;
import stevekung.mods.moreplanets.core.MorePlanetsCore;

public class EntityCreamBall extends EntityThrowable
{
    public EntityCreamBall(World world)
    {
        super(world);
    }

    public EntityCreamBall(World world, EntityLivingBase living, int type)
    {
        super(world, living);
        this.setCreamBallType(type);
    }

    @Override
    protected void onImpact(MovingObjectPosition moving)
    {
        if (moving.entityHit != null)
        {
            moving.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0);

            if (moving.entityHit instanceof EntityLivingBase)
            {
                EntityLivingBase living = (EntityLivingBase) moving.entityHit;

                switch (this.getCreamBallType())
                {
                case 0:
                    living.addPotionEffect(new PotionEffect(Potion.jump.id, 100, 2));
                    living.addPotionEffect(new PotionEffect(Potion.regeneration.id, 250, 2));
                    break;
                case 1:
                    living.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 2));
                    living.addPotionEffect(new PotionEffect(Potion.regeneration.id, 250, 2));
                    break;
                case 2:
                    living.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 160, 2));
                    living.addPotionEffect(new PotionEffect(Potion.regeneration.id, 250, 2));
                    break;
                case 3:
                    living.addPotionEffect(new PotionEffect(Potion.invisibility.id, 120, 0));
                    living.addPotionEffect(new PotionEffect(Potion.regeneration.id, 250, 2));
                    break;
                case 4:
                    living.addPotionEffect(new PotionEffect(Potion.resistance.id, 120, 2));
                    living.addPotionEffect(new PotionEffect(Potion.regeneration.id, 260, 2));
                    break;
                case 5:
                    living.addPotionEffect(new PotionEffect(Potion.confusion.id, 120, 2));
                    living.addPotionEffect(new PotionEffect(Potion.regeneration.id, 260, 2));
                    break;
                }
            }
        }

        for (int i = 0; i < 8; ++i)
        {
            EnumParticleTypesMP particle = null;

            switch (this.getCreamBallType())
            {
            case 0:
                particle = EnumParticleTypesMP.VANILLA_CREAM_BALL;
                break;
            case 1:
                particle = EnumParticleTypesMP.CHOCOLATE_CREAM_BALL;
                break;
            case 2:
                particle = EnumParticleTypesMP.STRAWBERRY_CREAM_BALL;
                break;
            case 3:
                particle = EnumParticleTypesMP.ORANGE_CREAM_BALL;
                break;
            case 4:
                particle = EnumParticleTypesMP.TEA_CREAM_BALL;
                break;
            case 5:
                particle = EnumParticleTypesMP.LEMON_CREAM_BALL;
                break;
            }
            MorePlanetsCore.proxy.spawnParticle(particle, this.posX, this.posY, this.posZ);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
        nbt.setInteger("CreamType", this.getCreamBallType());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
        this.setCreamBallType(nbt.getInteger("CreamType"));
    }

    @Override
    protected void entityInit()
    {
        this.dataWatcher.addObject(16, Byte.valueOf((byte)1));
    }

    public int getCreamBallType()
    {
        return this.dataWatcher.getWatchableObjectByte(16);
    }

    public void setCreamBallType(int type)
    {
        this.dataWatcher.updateObject(16, Byte.valueOf((byte)type));
    }
}