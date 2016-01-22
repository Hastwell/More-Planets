/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.blocks.ICustomBlockProperty;
import stevekung.mods.moreplanets.common.entities.ai.EntityAITemptMP;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;

public class EntityTomato extends EntityAnimal
{
    public int timeUntilToDropTomato;

    public EntityTomato(World par1World)
    {
        super(par1World);
        this.setSize(1.0F, 1.5F);
        this.timeUntilToDropTomato = this.rand.nextInt(2000) + 2000;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITemptMP(this, 1.1D, new ItemStack(FronosItems.candy_food, 1, 0), false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
    }

    @Override
    public float getEyeHeight()
    {
        if (this.isChild())
        {
            return this.height - 0.35F;
        }
        return this.height - 0.7F;
    }

    @Override
    public boolean getCanSpawnHere()
    {
        return this.worldObj.getBlockState(this.getPosition().down()).getBlock() instanceof ICustomBlockProperty && ((ICustomBlockProperty)this.worldObj.getBlockState(this.getPosition().down()).getBlock()).getProperty() == 0;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.15D);
    }

    @Override
    protected String getLivingSound()
    {
        return "moreplanets:mob.fronos.say";
    }

    @Override
    protected String getHurtSound()
    {
        return "moreplanets:mob.fronos.hurt";
    }

    @Override
    protected String getDeathSound()
    {
        return "moreplanets:mob.fronos.death";
    }

    @Override
    protected float getSoundVolume()
    {
        return 0.5F;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.isChild() && !this.worldObj.isRemote && --this.timeUntilToDropTomato <= 0)
        {
            this.playSound("mob.chicken.plop", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.entityDropItem(new ItemStack(FronosItems.fronos_food, 1, 1), 0.0F);
            this.timeUntilToDropTomato = this.rand.nextInt(2000) + 2000;
        }
    }

    @Override
    protected int getExperiencePoints(EntityPlayer player)
    {
        return 1 + this.worldObj.rand.nextInt(6);
    }

    @Override
    protected void dropFewItems(boolean drop, int fortune)
    {
        int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + fortune);

        for (int k = 0; k < j; ++k)
        {
            this.entityDropItem(new ItemStack(FronosItems.fronos_food, 1, 1), 0.0F);
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack itemStack)
    {
        return itemStack != null && itemStack.getItem() == FronosItems.candy_food && itemStack.getItemDamage() == 1;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable age)
    {
        return new EntityTomato(this.worldObj);
    }
}