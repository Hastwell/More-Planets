package stevekung.mods.moreplanets.asteroids.darkasteroids.entities;

import java.util.UUID;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class EntityEvolvedDarkCreeper extends EntityCreeper implements IEntityBreathable
{
    private float sizeXBase = -1.0F;
    private float sizeYBase;
    private int teleportDelay;
    private static UUID babySpeedBoostUUID = UUID.fromString("ef67a435-32a4-4efd-b218-e7431438b109");
    private static AttributeModifier babySpeedBoostModifier = new AttributeModifier(babySpeedBoostUUID, "Baby speed boost evolved creeper", 0.5D, 1);

    public EntityEvolvedDarkCreeper(World world)
    {
        super(world);
        this.setSize(0.6F, 1.8F);
    }

    @Override
    public boolean isAIEnabled()
    {
        return false;
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
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
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
    protected void dropRareDrop(int par1)
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

    @Override
    protected Entity findPlayerToAttack()
    {
        EntityPlayer player = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);

        if (player != null)
        {
            if (this.shouldAttackPlayer(player))
            {
                return player;
            }
        }
        return null;
    }

    @Override
    public void onLivingUpdate()
    {
        /*if (this.entityToAttack == null)
        {
            this.setCreeperState(-1);
        }
        else if (this.getDistanceSqToEntity(this.entityToAttack) > 49.0D)
        {
            this.setCreeperState(-1);
        }
        else if (!this.getEntitySenses().canSee(this.entityToAttack))
        {
            this.setCreeperState(-1);
        }
        else */if (this.entityToAttack != null && this.getDistanceSqToEntity(this.entityToAttack) < 9.0D)
        {
            this.func_146079_cb();
        }

        for (int k = 0; k < 2; ++k)
        {
            this.worldObj.spawnParticle("portal", this.posX + (this.rand.nextDouble() - 0.5D) * this.width, this.posY + this.rand.nextDouble() * this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
        }
        if (this.entityToAttack != null)
        {
            this.faceEntity(this.entityToAttack, 100.0F, 100.0F);
        }
        if (!this.worldObj.isRemote && this.isEntityAlive())
        {
            if (this.entityToAttack != null)
            {
                if (this.entityToAttack instanceof EntityPlayer && this.shouldAttackPlayer((EntityPlayer)this.entityToAttack))
                {
                    if (this.entityToAttack.getDistanceSqToEntity(this) < 16.0D)
                    {
                        this.teleportRandomly();
                    }
                    this.teleportDelay = 0;
                }
                else if (this.entityToAttack.getDistanceSqToEntity(this) > 256.0D && this.teleportDelay++ >= 30 && this.teleportToEntity(this.entityToAttack))
                {
                    this.teleportDelay = 0;
                }
            }
            else
            {
                this.teleportDelay = 0;
            }
        }
        super.onLivingUpdate();
    }

    protected boolean teleportRandomly()
    {
        double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
        double d1 = this.posY + (this.rand.nextInt(64) - 32);
        double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
        return this.teleportTo(d0, d1, d2);
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
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posY);
        int k = MathHelper.floor_double(this.posZ);

        if (this.worldObj.blockExists(i, j, k))
        {
            boolean flag1 = false;

            while (!flag1 && j > 0)
            {
                Block block = this.worldObj.getBlock(i, j - 1, k);

                if (block.getMaterial().blocksMovement())
                {
                    flag1 = true;
                }
                else
                {
                    --this.posY;
                    --j;
                }
            }

            if (flag1)
            {
                this.setPosition(this.posX, this.posY, this.posZ);

                if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox))
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

            for (int l = 0; l < short1; ++l)
            {
                double d6 = l / (short1 - 1.0D);
                float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
                float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
                float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
                double d7 = d3 + (this.posX - d3) * d6 + (this.rand.nextDouble() - 0.5D) * this.width * 2.0D;
                double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble() * this.height;
                double d9 = d5 + (this.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5D) * this.width * 2.0D;
                this.worldObj.spawnParticle("portal", d7, d8, d9, f, f1, f2);
            }
            this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
            this.playSound("mob.endermen.portal", 1.0F, 1.0F);
            return true;
        }
    }

    protected boolean teleportToEntity(Entity entity)
    {
        Vec3 vec3 = Vec3.createVectorHelper(this.posX - entity.posX, this.boundingBox.minY + this.height / 2.0F - entity.posY + entity.getEyeHeight(), this.posZ - entity.posZ);
        vec3 = vec3.normalize();
        double d0 = 16.0D;
        double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.xCoord * d0;
        double d2 = this.posY + (this.rand.nextInt(16) - 8) - vec3.yCoord * d0;
        double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.zCoord * d0;
        return this.teleportTo(d1, d2, d3);
    }

    private boolean shouldAttackPlayer(EntityPlayer player)
    {
        Vec3 vec3 = player.getLook(0.85F).normalize();
        Vec3 vec31 = Vec3.createVectorHelper(this.posX - player.posX, this.boundingBox.minY + this.height / 2.0F - (player.posY + player.getEyeHeight()), this.posZ - player.posZ);
        double d0 = vec31.lengthVector();
        vec31 = vec31.normalize();
        double d1 = vec3.dotProduct(vec31);
        return d1 > 1.0D - 0.025D / d0 && player.canEntityBeSeen(this);
    }
}