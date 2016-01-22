/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.entities;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.client.EnumParticleTypesMP;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;

public class EntityJellySlime extends EntitySlime implements IMob
{
    private boolean wasOnGround;

    public EntityJellySlime(World world)
    {
        super(world);
        this.setJellySlimeType(this.rand.nextInt(8));
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(17, Byte.valueOf((byte)0));
    }

    @Override
    public void setSlimeSize(int size)
    {
        this.dataWatcher.updateObject(16, Byte.valueOf((byte)size));
        this.setSize(0.51000005F * size, 0.51000005F * size);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(size * size);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2F + 0.1F * size);
        this.setHealth(this.getMaxHealth());
        this.experienceValue = size;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
        nbt.setInteger("Size", this.getSlimeSize() - 1);
        nbt.setBoolean("WasOnGround", this.wasOnGround);
        nbt.setInteger("SlimeType", this.getJellySlimeType());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
        int i = nbt.getInteger("Size");

        if (i < 0)
        {
            i = 0;
        }
        this.setSlimeSize(i + 1);
        this.setJellySlimeType(nbt.getInteger("SlimeType"));
        this.wasOnGround = nbt.getBoolean("WasOnGround");
    }

    @Override
    public void onUpdate()
    {
        if (!this.worldObj.isRemote && this.worldObj.getDifficulty() == EnumDifficulty.PEACEFUL && this.getSlimeSize() > 0)
        {
            this.isDead = true;
        }

        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
        this.prevSquishFactor = this.squishFactor;
        super.onUpdate();

        if (this.onGround && !this.wasOnGround)
        {
            int i = this.getSlimeSize();

            for (int j = 0; j < i * 8; ++j)
            {
                float f = this.rand.nextFloat() * (float)Math.PI * 2.0F;
                float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
                float f2 = MathHelper.sin(f) * i * 0.5F * f1;
                float f3 = MathHelper.cos(f) * i * 0.5F * f1;
                double d0 = this.posX + f2;
                double d1 = this.posZ + f3;
                EnumParticleTypesMP type = null;

                switch (this.getJellySlimeType())
                {
                case 0:
                    type = EnumParticleTypesMP.GRAPE_JELLY;
                    break;
                case 1:
                    type = EnumParticleTypesMP.RASPBERRY_JELLY;
                    break;
                case 2:
                    type = EnumParticleTypesMP.STRAWBERRY_JELLY;
                    break;
                case 3:
                    type = EnumParticleTypesMP.BERRY_JELLY;
                    break;
                case 4:
                    type = EnumParticleTypesMP.LIME_JELLY;
                    break;
                case 5:
                    type = EnumParticleTypesMP.ORANGE_JELLY;
                    break;
                case 6:
                    type = EnumParticleTypesMP.GREEN_JELLY;
                    break;
                case 7:
                    type = EnumParticleTypesMP.LEMON_JELLY;
                    break;
                }
                MorePlanetsCore.proxy.spawnParticle(type, d0, this.getEntityBoundingBox().minY, d1);
            }

            if (this.makesSoundOnLand())
            {
                this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            }
            this.squishAmount = -0.5F;
        }
        else if (!this.onGround && this.wasOnGround)
        {
            this.squishAmount = 1.0F;
        }
        this.wasOnGround = this.onGround;
        this.alterSquishAmount();
    }

    @Override
    public void setDead()
    {
        int i = this.getSlimeSize();

        if (!this.worldObj.isRemote && i > 1 && this.getHealth() <= 0.0F)
        {
            int j = 2 + this.rand.nextInt(3);

            for (int k = 0; k < j; ++k)
            {
                float f = (k % 2 - 0.5F) * i / 4.0F;
                float f1 = (k / 2 - 0.5F) * i / 4.0F;
                EntityJellySlime entityslime = new EntityJellySlime(this.worldObj);

                if (this.hasCustomName())
                {
                    entityslime.setCustomNameTag(this.getCustomNameTag());
                }

                if (this.isNoDespawnRequired())
                {
                    entityslime.enablePersistence();
                }
                entityslime.setJellySlimeType(this.getJellySlimeType());
                entityslime.setSlimeSize(i / 2);
                entityslime.setLocationAndAngles(this.posX + f, this.posY + 0.5D, this.posZ + f1, this.rand.nextFloat() * 360.0F, 0.0F);
                this.worldObj.spawnEntityInWorld(entityslime);
            }
        }
        this.isDead = true;
    }

    public int getJellySlimeType()
    {
        return this.dataWatcher.getWatchableObjectByte(17);
    }

    public void setJellySlimeType(int type)
    {
        this.dataWatcher.updateObject(17, Byte.valueOf((byte)type));
    }

    @Override
    protected void dropFewItems(boolean drop, int fortune)
    {
        if (this.getSlimeSize() == 1)
        {
            int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + fortune);

            for (int i = 0; i < j; ++i)
            {
                this.entityDropItem(new ItemStack(FronosItems.jelly, 1, this.getJellySlimeType()), 0.0F);
            }
        }
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance diff, IEntityLivingData data)
    {
        int i = this.rand.nextInt(2);

        if (i < 2 && this.rand.nextFloat() < 0.5F * diff.getClampedAdditionalDifficulty())
        {
            ++i;
        }
        int j = 1 << i;
        this.setSlimeSize(j);
        return data;
    }

    @Override
    protected boolean spawnCustomParticles()
    {
        return true;
    }
}