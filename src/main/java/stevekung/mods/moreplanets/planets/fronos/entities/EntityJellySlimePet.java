/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.client.EnumParticleTypesMP;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;

public class EntityJellySlimePet extends EntityTameable
{
    public float squishAmount;
    public float squishFactor;
    public float prevSquishFactor;
    private boolean wasOnGround;

    public EntityJellySlimePet(World world)
    {
        super(world);
        this.setSize(0.51000005F, 0.51000005F);
        this.moveHelper = new SlimeMoveHelper();
        this.tasks.addTask(1, new AISlimeFloat());
        this.tasks.addTask(2, new AISlimeFollow());
        this.tasks.addTask(3, new AISlimeFaceRandom());
        this.tasks.addTask(4, new AISlimeHop());
        this.setJellySlimeType(this.rand.nextInt(8));
        this.setTamed(false);
    }

    @Override
    public int getMaxSpawnedInChunk()
    {
        return 2;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(18, Byte.valueOf((byte)0));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
        nbt.setBoolean("WasOnGround", this.wasOnGround);
        nbt.setInteger("SlimeType", this.getJellySlimeType());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
        this.wasOnGround = nbt.getBoolean("WasOnGround");
        this.setJellySlimeType(nbt.getInteger("SlimeType"));
    }

    public int getJellySlimeType()
    {
        return this.dataWatcher.getWatchableObjectByte(18);
    }

    public void setJellySlimeType(int type)
    {
        this.dataWatcher.updateObject(18, Byte.valueOf((byte)type));
    }

    @Override
    protected String getHurtSound()
    {
        return "mob.slime.small";
    }

    @Override
    protected String getDeathSound()
    {
        return "mob.slime.small";
    }

    @Override
    public void onUpdate()
    {
        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
        this.prevSquishFactor = this.squishFactor;
        super.onUpdate();

        if (this.onGround && !this.wasOnGround)
        {
            for (int j = 0; j < 1 * 8; ++j)
            {
                float f = this.rand.nextFloat() * (float)Math.PI * 2.0F;
                float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
                float f2 = MathHelper.sin(f) * 1 * 0.5F * f1;
                float f3 = MathHelper.cos(f) * 1 * 0.5F * f1;
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
            this.squishAmount = -0.5F;
        }
        else if (!this.onGround && this.wasOnGround)
        {
            this.squishAmount = 1.0F;
        }
        this.wasOnGround = this.onGround;
        this.alterSquishAmount();
    }

    protected void alterSquishAmount()
    {
        this.squishAmount *= 0.6F;
    }

    @Override
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemStack = player.inventory.getCurrentItem();

        if (this.isTamed())
        {
            if (itemStack != null)
            {
                if (itemStack.getItem() == FronosItems.candy_food && itemStack.getItemDamage() == 1)
                {
                    if (this.getHealth() < this.getMaxHealth())
                    {
                        if (!player.capabilities.isCreativeMode)
                        {
                            --itemStack.stackSize;
                        }

                        this.heal(5.0F);

                        if (itemStack.stackSize <= 0)
                        {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
                        }
                        for (int i = 0; i < 7; ++i)
                        {
                            double d0 = this.rand.nextGaussian() * 0.02D;
                            double d1 = this.rand.nextGaussian() * 0.02D;
                            double d2 = this.rand.nextGaussian() * 0.02D;
                            this.worldObj.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, this.posX + this.rand.nextFloat() * this.width * 2.0F - this.width, this.posY + 0.5D + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0F - this.width, d0, d1, d2, new int[0]);
                        }
                        return true;
                    }
                }
            }
        }
        else if (itemStack != null && itemStack.getItem() == FronosItems.cup && (itemStack.getItemDamage() == 2 || itemStack.getItemDamage() == 6))
        {
            if (!player.capabilities.isCreativeMode)
            {
                --itemStack.stackSize;
                player.inventory.addItemStackToInventory(new ItemStack(FronosItems.cup, 1, 0));
            }
            if (itemStack.stackSize <= 0)
            {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
            }

            if (!this.worldObj.isRemote)
            {
                if (this.rand.nextInt(3) == 0)
                {
                    this.setTamed(true);
                    this.setHealth(20.0F);
                    this.setOwnerId(player.getUniqueID().toString());
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte)7);
                }
                else
                {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState(this, (byte)6);
                }
            }
            return true;
        }
        return super.interact(player);
    }

    @Override
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    @Override
    public boolean isBreedingItem(ItemStack itemStack)
    {
        return false;
    }

    @Override
    protected void dropFewItems(boolean drop, int fortune)
    {
        int jelly = this.getOwner() != null ? 9 : 3;
        int count = this.rand.nextInt(jelly) + 1 + this.rand.nextInt(1 + fortune);

        for (int i = 0; i < count; ++i)
        {
            this.entityDropItem(new ItemStack(FronosItems.jelly, 1, this.getJellySlimeType()), 0.0F);
        }
    }

    @Override
    public float getEyeHeight()
    {
        return 0.625F * this.height;
    }

    @Override
    public void setTamed(boolean tamed)
    {
        super.setTamed(tamed);

        if (tamed)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        }
        else
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1.0D);
        }
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable)
    {
        return null;
    }

    @Override
    public int getVerticalFaceSpeed()
    {
        return 0;
    }

    @Override
    protected void jump()
    {
        if (this.getOwner() != null && this.getDistanceSqToEntity(this.getOwner()) >= 125.0D)
        {
            this.stepHeight = 2.0F;
            this.addPotionEffect(new PotionEffect(Potion.resistance.id, 48, 5, false, false));
        }
        this.motionY = 0.41999998688697815D;
        this.isAirBorne = true;
    }

    @Override
    public boolean allowLeashing()
    {
        return this.isTamed();
    }

    protected int getJumpDelay()
    {
        return this.rand.nextInt(20) + 10;
    }

    protected String getJumpSound()
    {
        return "mob.slime.small";
    }

    class SlimeMoveHelper extends EntityMoveHelper
    {
        private float field_179922_g;
        private int field_179924_h;
        private EntityJellySlimePet field_179925_i = EntityJellySlimePet.this;
        private boolean field_179923_j;

        public SlimeMoveHelper()
        {
            super(EntityJellySlimePet.this);
        }

        public void func_179920_a(float p_179920_1_, boolean p_179920_2_)
        {
            this.field_179922_g = p_179920_1_;
            this.field_179923_j = p_179920_2_;
        }

        public void func_179921_a(double p_179921_1_)
        {
            this.speed = p_179921_1_;
            this.update = true;
        }

        @Override
        public void onUpdateMoveHelper()
        {
            this.entity.rotationYaw = this.limitAngle(this.entity.rotationYaw, this.field_179922_g, 30.0F);
            this.entity.rotationYawHead = this.entity.rotationYaw;
            this.entity.renderYawOffset = this.entity.rotationYaw;

            if (!this.update)
            {
                this.entity.setMoveForward(0.0F);
            }
            else
            {
                this.update = false;

                if (this.entity.onGround)
                {
                    this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue()));

                    if (this.field_179924_h-- <= 0)
                    {
                        this.field_179924_h = this.field_179925_i.getJumpDelay();

                        if (this.field_179923_j)
                        {
                            this.field_179924_h /= 3;
                        }

                        Entity owner = this.field_179925_i.getOwner();

                        if (owner == null)
                        {
                            this.field_179925_i.getJumpHelper().setJumping();
                            this.field_179925_i.playSound(this.field_179925_i.getJumpSound(), this.field_179925_i.getSoundVolume(), ((this.field_179925_i.getRNG().nextFloat() - this.field_179925_i.getRNG().nextFloat()) * 0.2F + 1.0F) * 0.8F);
                        }
                        else
                        {
                            if (this.field_179925_i.getDistanceSqToEntity(owner) >= 0.0D && this.field_179925_i.getDistanceSqToEntity(owner) <= 16.0D)
                            {
                                this.entity.setAIMoveSpeed(0.0F);
                                return;
                            }
                            else if (this.field_179925_i.getDistanceSqToEntity(owner) >= 125.0D)
                            {
                                this.entity.setAIMoveSpeed(2.0F);
                            }
                            this.field_179925_i.getJumpHelper().setJumping();
                            this.field_179925_i.playSound(this.field_179925_i.getJumpSound(), this.field_179925_i.getSoundVolume(), ((this.field_179925_i.getRNG().nextFloat() - this.field_179925_i.getRNG().nextFloat()) * 0.2F + 1.0F) * 0.8F);
                        }
                    }
                    else
                    {
                        this.field_179925_i.moveStrafing = this.field_179925_i.moveForward = 0.0F;
                        this.entity.setAIMoveSpeed(0.0F);
                    }
                }
                else
                {
                    this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue()));
                }
            }
        }
    }

    class AISlimeFloat extends EntityAIBase
    {
        private EntityJellySlimePet field_179457_a = EntityJellySlimePet.this;

        public AISlimeFloat()
        {
            this.setMutexBits(5);
            ((PathNavigateGround)EntityJellySlimePet.this.getNavigator()).setCanSwim(true);
        }

        @Override
        public boolean shouldExecute()
        {
            return this.field_179457_a.isInWater() || this.field_179457_a.isInLava();
        }

        @Override
        public void updateTask()
        {
            if (this.field_179457_a.getRNG().nextFloat() < 0.8F)
            {
                this.field_179457_a.getJumpHelper().setJumping();
            }
            ((SlimeMoveHelper)this.field_179457_a.getMoveHelper()).func_179921_a(1.0D);
        }
    }

    class AISlimeFollow extends EntityAIBase
    {
        private EntityJellySlimePet field_179466_a = EntityJellySlimePet.this;
        private int field_179465_b;

        public AISlimeFollow()
        {
            this.setMutexBits(2);
        }

        @Override
        public boolean shouldExecute()
        {
            Entity entitylivingbase = this.field_179466_a.getOwner();
            return entitylivingbase == null ? false : entitylivingbase.isEntityAlive();
        }

        @Override
        public void startExecuting()
        {
            this.field_179465_b = 300;
            super.startExecuting();
        }

        @Override
        public boolean continueExecuting()
        {
            Entity entitylivingbase = this.field_179466_a.getOwner();
            return entitylivingbase == null ? false : !entitylivingbase.isEntityAlive() ? false : --this.field_179465_b > 0;
        }

        @Override
        public void updateTask()
        {
            this.field_179466_a.faceEntity(this.field_179466_a.getOwner(), 10.0F, 10.0F);
            ((SlimeMoveHelper)this.field_179466_a.getMoveHelper()).func_179920_a(this.field_179466_a.rotationYaw, false);
        }
    }

    class AISlimeHop extends EntityAIBase
    {
        private EntityJellySlimePet field_179458_a = EntityJellySlimePet.this;

        public AISlimeHop()
        {
            this.setMutexBits(5);
        }

        @Override
        public boolean shouldExecute()
        {
            return true;
        }

        @Override
        public void updateTask()
        {
            ((SlimeMoveHelper)this.field_179458_a.getMoveHelper()).func_179921_a(1.0D);
        }
    }

    class AISlimeFaceRandom extends EntityAIBase
    {
        private EntityJellySlimePet field_179461_a = EntityJellySlimePet.this;
        private float field_179459_b;
        private int field_179460_c;

        public AISlimeFaceRandom()
        {
            this.setMutexBits(2);
        }

        @Override
        public boolean shouldExecute()
        {
            return this.field_179461_a.getAttackTarget() == null && (this.field_179461_a.onGround || this.field_179461_a.isInWater() || this.field_179461_a.isInLava());
        }

        @Override
        public void updateTask()
        {
            if (--this.field_179460_c <= 0)
            {
                this.field_179460_c = 40 + this.field_179461_a.getRNG().nextInt(60);
                this.field_179459_b = this.field_179461_a.getRNG().nextInt(360);
            }
            ((SlimeMoveHelper)this.field_179461_a.getMoveHelper()).func_179920_a(this.field_179459_b, false);
        }
    }
}