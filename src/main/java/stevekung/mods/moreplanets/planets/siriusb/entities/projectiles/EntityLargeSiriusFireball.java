/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.planets.siriusb.world.SiriusExplosion;

public class EntityLargeSiriusFireball extends EntityFireball
{
    public EntityLargeSiriusFireball(World world)
    {
        super(world);
    }

    public EntityLargeSiriusFireball(World world, EntityLivingBase living, double x, double y, double z)
    {
        super(world, living, x, y, z);
    }

    @Override
    protected void onImpact(MovingObjectPosition moving)
    {
        if (!this.worldObj.isRemote)
        {
            if (moving.entityHit != null)
            {
                moving.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 6.0F);
                this.applyEnchantments(this.shootingEntity, moving.entityHit);
            }
            this.explode();
            this.setDead();
        }
    }

    private void explode()
    {
        boolean gamerule = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
        SiriusExplosion explosion = new SiriusExplosion(this.worldObj, this, this.posX, this.posY, this.posZ, 4.0F, gamerule, gamerule);
        explosion.doExplosionA();
        explosion.doExplosionB(true);
    }
}