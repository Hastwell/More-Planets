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
import net.minecraft.block.material.Material;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.entities.IEntityLivingPlanet;
import stevekung.mods.moreplanets.common.util.EnumDimensionType;
import stevekung.mods.moreplanets.core.init.MPPotions;

import com.google.common.base.Predicate;

public class EntityEuropaSquid extends EntityWaterMob implements IEntityBreathable, IEntityLivingPlanet
{
    public float squidPitch;
    public float prevSquidPitch;
    public float squidYaw;
    public float prevSquidYaw;
    public float squidRotation;
    public float prevSquidRotation;
    public float tentacleAngle;
    public float lastTentacleAngle;
    private float randomMotionSpeed;
    private float rotationVelocity;
    private float field_70871_bB;
    private float randomMotionVecX;
    private float randomMotionVecY;
    private float randomMotionVecZ;

    public EntityEuropaSquid(World world)
    {
        super(world);
        this.setSize(0.95F, 0.95F);
        this.rand.setSeed(1 + this.getEntityId());
        this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
        this.tasks.addTask(0, new AIMoveRandom());
        this.setSquidType(0);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(12.0D);
    }

    @Override
    public float getEyeHeight()
    {
        return this.height * 0.5F;
    }

    @Override
    protected String getLivingSound()
    {
        return null;
    }

    @Override
    protected String getHurtSound()
    {
        return null;
    }

    @Override
    protected String getDeathSound()
    {
        return null;
    }

    @Override
    protected Item getDropItem()
    {
        return null;
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }

    @Override
    protected void dropFewItems(boolean drop, int fortune)
    {
        int j = this.rand.nextInt(3 + fortune) + 1;

        for (int k = 0; k < j; ++k)
        {
            this.entityDropItem(new ItemStack(Items.dye, 1, EnumDyeColor.BLACK.getDyeDamage()), 0.0F);
        }
    }

    @Override
    public boolean isInWater()
    {
        return this.worldObj.handleMaterialAcceleration(this.getEntityBoundingBox().expand(0.0D, -0.6000000238418579D, 0.0D), Material.water, this);
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        this.prevSquidPitch = this.squidPitch;
        this.prevSquidYaw = this.squidYaw;
        this.prevSquidRotation = this.squidRotation;
        this.lastTentacleAngle = this.tentacleAngle;
        this.squidRotation += this.rotationVelocity;

        if (this.squidRotation > Math.PI * 2D)
        {
            if (this.worldObj.isRemote)
            {
                this.squidRotation = (float)Math.PI * 2F;
            }
            else
            {
                this.squidRotation = (float)(this.squidRotation - Math.PI * 2D);

                if (this.rand.nextInt(10) == 0)
                {
                    this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
                }

                this.worldObj.setEntityState(this, (byte)19);
            }
        }

        if (this.inWater)
        {
            float f;

            if (this.squidRotation < (float)Math.PI)
            {
                f = this.squidRotation / (float)Math.PI;
                this.tentacleAngle = MathHelper.sin(f * f * (float)Math.PI) * (float)Math.PI * 0.25F;

                if (f > 0.75D)
                {
                    this.randomMotionSpeed = 1.0F;
                    this.field_70871_bB = 1.0F;
                }
                else
                {
                    this.field_70871_bB *= 0.8F;
                }
            }
            else
            {
                this.tentacleAngle = 0.0F;
                this.randomMotionSpeed *= 0.9F;
                this.field_70871_bB *= 0.99F;
            }

            if (!this.worldObj.isRemote)
            {
                this.motionX = this.randomMotionVecX * this.randomMotionSpeed;
                this.motionY = this.randomMotionVecY * this.randomMotionSpeed;
                this.motionZ = this.randomMotionVecZ * this.randomMotionSpeed;
            }

            f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.renderYawOffset += (-((float)Math.atan2(this.motionX, this.motionZ)) * 180.0F / (float)Math.PI - this.renderYawOffset) * 0.1F;
            this.rotationYaw = this.renderYawOffset;
            this.squidYaw = (float)(this.squidYaw + Math.PI * this.field_70871_bB * 1.5D);
            this.squidPitch += (-((float)Math.atan2(f, this.motionY)) * 180.0F / (float)Math.PI - this.squidPitch) * 0.1F;
        }
        else
        {
            this.tentacleAngle = MathHelper.abs(MathHelper.sin(this.squidRotation)) * (float)Math.PI * 0.25F;

            if (!this.worldObj.isRemote)
            {
                this.motionX = 0.0D;
                this.motionY -= 0.08D;
                this.motionY *= 0.9800000190734863D;
                this.motionZ = 0.0D;
            }
            this.squidPitch = (float)(this.squidPitch + (-90.0F - this.squidPitch) * 0.02D);
        }
    }

    @Override
    public void moveEntityWithHeading(float strafe, float forward)
    {
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
    }

    @Override
    public boolean getCanSpawnHere()
    {
        return this.posY > 16.0D && this.posY < 64.0D && super.getCanSpawnHere();
    }

    @Override
    protected void updateAITasks()
    {
        super.updateAITasks();

        if (this.getSquidType() == 1)
        {
            if (this.ticksExisted % 128 == 0)
            {
                Potion potion = MPPotions.chemical;
                List list = this.worldObj.getPlayers(EntityPlayerMP.class, new Predicate()
                {
                    public boolean func_179913_a(EntityPlayerMP player)
                    {
                        return EntityEuropaSquid.this.getDistanceSqToEntity(player) < 16.0D && player.theItemInWorldManager.func_180239_c();
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
    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte health)
    {
        if (health == 19)
        {
            this.squidRotation = 0.0F;
        }
        else
        {
            super.handleHealthUpdate(health);
        }
    }

    public void func_175568_b(float x, float y, float z)
    {
        this.randomMotionVecX = x;
        this.randomMotionVecY = y;
        this.randomMotionVecZ = z;
    }

    public boolean func_175567_n()
    {
        return this.randomMotionVecX != 0.0F || this.randomMotionVecY != 0.0F || this.randomMotionVecZ != 0.0F;
    }

    @Override
    public IEntityLivingData func_180482_a(DifficultyInstance diff, IEntityLivingData data)
    {
        if (this.worldObj.rand.nextInt(100) == 0)
        {
            EntityEuropaSquid squid = new EntityEuropaSquid(this.worldObj);
            squid.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
            squid.func_180482_a(diff, (IEntityLivingData)null);
            squid.setSquidType(1);
            this.worldObj.spawnEntityInWorld(squid);
        }
        return data;
    }

    @Override
    public void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(18, Byte.valueOf((byte)0));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
        nbt.setInteger("SquidType", this.getSquidType());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
        this.setSquidType(nbt.getInteger("SquidType"));
    }

    public int getSquidType()
    {
        return this.dataWatcher.getWatchableObjectByte(18);
    }

    public void setSquidType(int type)
    {
        this.dataWatcher.updateObject(18, Byte.valueOf((byte)type));
    }

    @Override
    public boolean canBreath()
    {
        return true;
    }

    @Override
    public EnumDimensionType canLivingInDimension()
    {
        return EnumDimensionType.NULL;
    }

    class AIMoveRandom extends EntityAIBase
    {
        private EntityEuropaSquid squid = EntityEuropaSquid.this;

        @Override
        public boolean shouldExecute()
        {
            return true;
        }

        @Override
        public void updateTask()
        {
            int i = this.squid.getAge();

            if (i > 100)
            {
                this.squid.func_175568_b(0.0F, 0.0F, 0.0F);
            }
            else if (this.squid.getRNG().nextInt(50) == 0 || !this.squid.inWater || !this.squid.func_175567_n())
            {
                float f = this.squid.getRNG().nextFloat() * (float)Math.PI * 2.0F;
                float f1 = MathHelper.cos(f) * 0.2F;
                float f2 = -0.1F + this.squid.getRNG().nextFloat() * 0.2F;
                float f3 = MathHelper.sin(f) * 0.2F;
                this.squid.func_175568_b(f1, f2, f3);
            }
        }
    }
}