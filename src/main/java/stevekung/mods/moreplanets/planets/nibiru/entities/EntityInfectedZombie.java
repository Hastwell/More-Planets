/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.nibiru.entities;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.entities.IEntityLivingPlanet;
import stevekung.mods.moreplanets.common.util.EnumDimensionType;
import stevekung.mods.moreplanets.core.init.MPPotions;

public class EntityInfectedZombie extends EntityZombie implements IEntityBreathable, IEntityLivingPlanet
{
    public EntityInfectedZombie(World world)
    {
        super(world);
    }

    @Override
    public boolean canBreath()
    {
        return true;
    }

    @Override
    public void setDead()
    {
        if (!this.worldObj.isRemote && !this.isChild())
        {
            if (this.rand.nextInt(4) == 0)
            {
                EntityGiantWorm worm = new EntityGiantWorm(this.worldObj);
                worm.setLocationAndAngles(this.posX, this.posY + this.rand.nextInt(2), this.posZ, 360.0F, 0.0F);
                this.worldObj.spawnEntityInWorld(worm);
            }
            else
            {
                EntityInfectedWorm worm = new EntityInfectedWorm(this.worldObj);
                worm.setLocationAndAngles(this.posX, this.posY + this.rand.nextInt(2), this.posZ, 360.0F, 0.0F);
                this.worldObj.spawnEntityInWorld(worm);
            }
        }
        super.setDead();
    }

    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        if (super.attackEntityAsMob(entity))
        {
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(MPPotions.infected_gas.id, 20, 0));
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(ConfigManagerCore.hardMode ? 5.0D : 3.0D);
    }

    public IAttribute getReinforcementsAttribute()
    {
        return EntityZombie.reinforcementChance;
    }

    @Override
    public EnumDimensionType canLivingInDimension()
    {
        return EnumDimensionType.NIBIRU;
    }
}