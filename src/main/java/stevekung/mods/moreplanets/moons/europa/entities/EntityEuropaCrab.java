/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.europa.entities;

import java.util.Iterator;
import java.util.List;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.entities.IEntityLivingPlanet;
import stevekung.mods.moreplanets.common.util.EnumDimensionType;
import stevekung.mods.moreplanets.common.util.WorldUtilMP;
import stevekung.mods.moreplanets.core.init.MPPotions;
import stevekung.mods.moreplanets.moons.europa.dimension.WorldProviderEuropa;

import com.google.common.base.Predicate;

public class EntityEuropaCrab extends EntityAnimal implements IEntityBreathable, IEntityLivingPlanet
{
    public EntityEuropaCrab(World world)
    {
        super(world);
        this.setSize(0.8F, 0.3F);
        this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
        this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(4, new EntityAITempt(this, 1.1D, Items.carrot, false));
        this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.setCrabType(this.rand.nextInt(3));
    }

    @Override
    public void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(18, Byte.valueOf((byte)0));
    }

    @Override
    public boolean canBreatheUnderwater()
    {
        return true;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(12.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
    }

    @Override
    protected String getLivingSound()
    {
        return null;
    }

    @Override
    protected String getHurtSound()
    {
        return "moreplanets:mob.crab";
    }

    @Override
    protected String getDeathSound()
    {
        return "moreplanets:mob.crab";
    }

    @Override
    protected void playStepSound(BlockPos pos, Block block)
    {
        this.playSound("mob.chicken.step", 0.15F, 1.0F);
    }

    @Override
    protected void dropFewItems(boolean drop, int fortune)
    {
        int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + fortune);

        for (int k = 0; k < j; ++k)
        {
            if (this.isBurning())
            {
                this.dropItem(Items.cooked_porkchop, 1);
            }
            else
            {
                this.dropItem(Items.porkchop, 1);
            }
        }
    }

    @Override
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemStack = player.inventory.getCurrentItem();

        if (itemStack == null && player.isSneaking())//TODO
        {
            if (this.getCrabType() == 2)
            {
                if (!this.worldObj.isRemote)
                {
                    EntityItem item = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(Items.diamond));
                    this.worldObj.spawnEntityInWorld(item);
                }
                this.setDead();
            }
            return true;
        }
        return super.interact(player);
    }

    @Override
    public EntityEuropaCrab createChild(EntityAgeable entity)
    {
        return new EntityEuropaCrab(this.worldObj);
    }

    @Override
    public boolean isBreedingItem(ItemStack itemStack)
    {
        return itemStack != null && itemStack.getItem() == Items.carrot;
    }

    @Override
    public boolean getCanSpawnHere()
    {
        if (WorldUtilMP.isSpaceWorld(this.worldObj, new WorldProviderEuropa()))
        {
            return this.posY > 45.0D && this.posY < 63.0D && this.worldObj.checkNoEntityCollision(this.getEntityBoundingBox());
        }
        return false;
    }

    @Override
    public boolean canBreath()
    {
        return true;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
        nbt.setInteger("CrabType", this.getCrabType());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
        this.setCrabType(nbt.getInteger("CrabType"));
    }

    public int getCrabType()
    {
        return this.dataWatcher.getWatchableObjectByte(18);
    }

    public void setCrabType(int type)
    {
        this.dataWatcher.updateObject(18, Byte.valueOf((byte)type));
    }

    @Override
    public EnumDimensionType canLivingInDimension()
    {
        return EnumDimensionType.NULL;
    }

    @Override
    protected void updateAITasks()
    {
        super.updateAITasks();

        if (this.getCrabType() == 3)
        {
            if (this.ticksExisted % 128 == 0)
            {
                Potion potion = MPPotions.chemical;
                List list = this.worldObj.getPlayers(EntityPlayerMP.class, new Predicate()
                {
                    public boolean func_179913_a(EntityPlayerMP player)
                    {
                        return EntityEuropaCrab.this.getDistanceSqToEntity(player) < 16.0D && player.theItemInWorldManager.func_180239_c();
                    }
                    @Override
                    public boolean apply(Object player)
                    {
                        return this.func_179913_a((EntityPlayerMP)player);
                    }
                });
                Iterator iterator = list.iterator();

                while (iterator.hasNext())
                {
                    EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();

                    if (!entityplayermp.isPotionActive(potion))
                    {
                        entityplayermp.addPotionEffect(new PotionEffect(potion.id, 64, 0));
                    }
                }
            }
        }
    }

    @Override
    public IEntityLivingData func_180482_a(DifficultyInstance diff, IEntityLivingData data)
    {
        if (this.worldObj.rand.nextInt(100) == 0)
        {
            EntityEuropaCrab crab = new EntityEuropaCrab(this.worldObj);
            crab.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
            crab.func_180482_a(diff, (IEntityLivingData)null);
            crab.setCrabType(3);
            this.worldObj.spawnEntityInWorld(crab);
        }
        return data;
    }
}