package stevekung.mods.moreplanets.asteroids.darkasteroids.entities;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAICreeperSwell;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class EntityEvolvedDarkCreeper extends EntityCreeper implements IEntityBreathable
{
    private float sizeXBase = -1.0F;
    private float sizeYBase;
    private static UUID babySpeedBoostUUID = UUID.fromString("ef67a435-32a4-4efd-b218-e7431438b109");
    private static AttributeModifier babySpeedBoostModifier = new AttributeModifier(babySpeedBoostUUID, "Baby speed boost evolved creeper", 0.5D, 1);

    public EntityEvolvedDarkCreeper(World world)
    {
        super(world);
        this.tasks.taskEntries.clear();
        this.targetTasks.taskEntries.clear();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAICreeperSwell(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(7, new EntityAIWander(this, 0.8D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new AIFindPlayer());
        //this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.setSize(0.6F, 1.8F);
    }

    private boolean shouldAttackPlayer(EntityPlayer player)
    {
        /*Vec3 vec3 = player.getLook(1.0F).normalize();
        Vec3 vec31 = new Vec3(this.posX - player.posX, this.getEntityBoundingBox().minY + this.height / 2.0F - (player.posY + player.getEyeHeight()), this.posZ - player.posZ);
        double d0 = vec31.lengthVector();
        vec31 = vec31.normalize();
        double d1 = vec3.dotProduct(vec31);*/
        return true;
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataWatcher().addObject(12, Byte.valueOf((byte) 0));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
        //this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0F);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);

        if (this.isChild())
        {
            nbt.setBoolean("IsBaby", true);
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);

        if (nbt.getBoolean("IsBaby"))
        {
            this.setChild(true);
        }
    }

    @Override
    public boolean canBreath()
    {
        return true;
    }

    public void setChildSize(boolean isChild)
    {
        this.setCreeperScale(isChild ? 0.5F : 1.0F);
    }

    @Override
    protected void setSize(float sizeX, float sizeY)
    {
        boolean flag = this.sizeXBase > 0.0F && this.sizeYBase > 0.0F;
        this.sizeXBase = sizeX;
        this.sizeYBase = sizeY;

        if (!flag)
        {
            this.setCreeperScale(1.0F);
        }
    }

    protected void setCreeperScale(float scale)
    {
        super.setSize(this.sizeXBase * scale, this.sizeYBase * scale);
    }

    @Override
    public boolean isChild()
    {
        return this.getDataWatcher().getWatchableObjectByte(12) == 1;
    }

    @Override
    protected int getExperiencePoints(EntityPlayer player)
    {
        if (this.isChild())
        {
            this.experienceValue = this.experienceValue * 5 / 2;
        }
        return super.getExperiencePoints(player);
    }

    public void setChild(boolean isChild)
    {
        this.getDataWatcher().updateObject(12, Byte.valueOf((byte) (isChild ? 1 : 0)));

        if (this.worldObj != null && !this.worldObj.isRemote)
        {
            IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
            iattributeinstance.removeModifier(babySpeedBoostModifier);

            if (isChild)
            {
                iattributeinstance.applyModifier(babySpeedBoostModifier);
            }
        }
        this.setChildSize(isChild);
    }

    @Override
    protected void jump()
    {
        this.motionY = 0.45D / WorldUtil.getGravityFactor(this);

        if (this.motionY < 0.22D)
        {
            this.motionY = 0.22D;
        }
        if (this.isPotionActive(Potion.jump))
        {
            this.motionY += (this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F;
        }
        if (this.isSprinting())
        {
            float f = this.rotationYaw * 0.017453292F;
            this.motionX -= MathHelper.sin(f) * 0.2F;
            this.motionZ += MathHelper.cos(f) * 0.2F;
        }
        this.isAirBorne = true;
        ForgeHooks.onLivingJump(this);
    }

    @Override
    protected void addRandomArmor()
    {
        switch (this.rand.nextInt(10))
        {
        case 0:
        case 1:
        case 9:
        case 2:
        case 3:
            break;
        case 4:
        case 5:
            this.entityDropItem(new ItemStack(Blocks.sand), 0.0F);
            break;
        case 6:
            //Oxygen tank half empty or less
            this.entityDropItem(new ItemStack(GCItems.oxTankMedium, 1, 901 + this.rand.nextInt(900)), 0.0F);
            break;
        case 7:
            this.dropItem(GCItems.oxygenGear, 1);
            break;
        case 8:
            this.entityDropItem(new ItemStack(Blocks.ice), 0.0F);
            break;
        }
    }

    protected boolean teleportRandomly()
    {
        double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
        double d1 = this.posY + (this.rand.nextInt(64) - 32);
        double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
        return this.teleportTo(d0, d1, d2);
    }

    protected boolean teleportToEntity(Entity entity)
    {
        Vec3 vec3 = new Vec3(this.posX - entity.posX, this.getEntityBoundingBox().minY + this.height / 2.0F - entity.posY + entity.getEyeHeight(), this.posZ - entity.posZ);
        vec3 = vec3.normalize();
        double d0 = 16.0D;
        double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.xCoord * d0;
        double d2 = this.posY + (this.rand.nextInt(16) - 8) - vec3.yCoord * d0;
        double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.zCoord * d0;
        return this.teleportTo(d1, d2, d3);
    }

    protected boolean teleportTo(double x, double y, double z)
    {
        double d3 = this.posX;
        double d4 = this.posY;
        double d5 = this.posZ;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        boolean flag = false;
        BlockPos blockpos = new BlockPos(this.posX, this.posY, this.posZ);

        if (this.worldObj.isBlockLoaded(blockpos))
        {
            boolean flag1 = false;

            while (!flag1 && blockpos.getY() > 0)
            {
                BlockPos blockpos1 = blockpos.down();
                Block block = this.worldObj.getBlockState(blockpos1).getBlock();

                if (block.getMaterial().blocksMovement())
                {
                    flag1 = true;
                }
                else
                {
                    --this.posY;
                    blockpos = blockpos1;
                }
            }

            if (flag1)
            {
                super.setPositionAndUpdate(this.posX, this.posY, this.posZ);

                if (this.worldObj.getCollidingBoundingBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.worldObj.isAnyLiquid(this.getEntityBoundingBox()))
                {
                    flag = true;
                }
            }
        }

        if (!flag)
        {
            this.setPosition(d3, d4, d5);
            return false;
        }
        else
        {
            short short1 = 128;

            for (int i = 0; i < short1; ++i)
            {
                double d9 = i / (short1 - 1.0D);
                float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
                float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
                float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
                double d6 = d3 + (this.posX - d3) * d9 + (this.rand.nextDouble() - 0.5D) * this.width * 2.0D;
                double d7 = d4 + (this.posY - d4) * d9 + this.rand.nextDouble() * this.height;
                double d8 = d5 + (this.posZ - d5) * d9 + (this.rand.nextDouble() - 0.5D) * this.width * 2.0D;
                this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, d6, d7, d8, f, f1, f2, new int[0]);
            }
            this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
            this.playSound("mob.endermen.portal", 1.0F, 1.0F);
            return true;
        }
    }

    class AIFindPlayer extends EntityAINearestAttackableTarget
    {
        private EntityPlayer player;
        private int field_179450_h;
        private EntityEvolvedDarkCreeper creeper = EntityEvolvedDarkCreeper.this;

        public AIFindPlayer()
        {
            super(EntityEvolvedDarkCreeper.this, EntityPlayer.class, true);
        }

        @Override
        public boolean shouldExecute()
        {
            double d0 = this.getTargetDistance();
            List list = this.taskOwner.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.taskOwner.getEntityBoundingBox().expand(d0, 4.0D, d0), this.targetEntitySelector);
            Collections.sort(list, this.theNearestAttackableTargetSorter);

            if (list.isEmpty())
            {
                return false;
            }
            else
            {
                this.player = (EntityPlayer)list.get(0);
                return true;
            }
        }

        @Override
        public void startExecuting()
        {
            this.field_179450_h = 5;
        }

        @Override
        public void resetTask()
        {
            this.player = null;
            super.resetTask();
        }

        @Override
        public boolean continueExecuting()
        {
            if (this.player != null)
            {
                if (!this.creeper.shouldAttackPlayer(this.player))
                {
                    return false;
                }
                else
                {
                    this.creeper.faceEntity(this.player, 10.0F, 10.0F);
                    return true;
                }
            }
            else
            {
                return super.continueExecuting();
            }
        }

        @Override
        public void updateTask()
        {
            if (this.player != null)
            {
                if (--this.field_179450_h <= 0)
                {
                    this.targetEntity = this.player;
                    this.player = null;
                    super.startExecuting();
                }
            }
            else
            {
                if (this.targetEntity != null)
                {
                    if (this.targetEntity instanceof EntityPlayer && this.creeper.shouldAttackPlayer((EntityPlayer)this.targetEntity))
                    {
                        if (this.targetEntity.getDistanceSqToEntity(this.creeper) > 128.0D)
                        {
                            this.creeper.teleportToEntity(this.targetEntity);
                        }
                    }
                }
                super.updateTask();
            }
        }
    }
}