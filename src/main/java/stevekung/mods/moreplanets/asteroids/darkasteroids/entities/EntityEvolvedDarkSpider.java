package stevekung.mods.moreplanets.asteroids.darkasteroids.entities;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import stevekung.mods.moreplanets.core.MorePlanetsCore;

public class EntityEvolvedDarkSpider extends EntitySpider implements IEntityBreathable
{
    public EntityEvolvedDarkSpider(World par1World)
    {
        super(par1World);
        this.setSize(1.4F, 0.9F);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(ConfigManagerCore.hardMode ? 1.2F : 1.0F);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(ConfigManagerCore.hardMode ? 4.0D : 2.0D);
    }

    @Override
    public boolean canBreath()
    {
        return true;
    }

    @Override
    protected boolean isAIEnabled()
    {
        return false;
    }

    @Override
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData data)
    {
        if (this.worldObj.rand.nextInt(100) == 0)
        {
            EntityEvolvedDarkSkeleton skeleton = new EntityEvolvedDarkSkeleton(this.worldObj);
            skeleton.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
            skeleton.onSpawnWithEgg(null);
            this.worldObj.spawnEntityInWorld(skeleton);
            skeleton.mountEntity(this);
        }
        if (data == null)
        {
            data = new EntityEvolvedDarkSpider.GroupData();

            if (this.worldObj.difficultySetting == EnumDifficulty.HARD && this.worldObj.rand.nextFloat() < 0.1F * this.worldObj.func_147462_b(this.posX, this.posY, this.posZ))
            {
                ((EntityEvolvedDarkSpider.GroupData)data).func_111104_a(this.worldObj.rand);
            }
        }
        if (data instanceof EntityEvolvedDarkSpider.GroupData)
        {
            int i = ((EntityEvolvedDarkSpider.GroupData)data).field_111105_a;

            if (i > 0 && Potion.potionTypes[i] != null)
            {
                this.addPotionEffect(new PotionEffect(i, Integer.MAX_VALUE));
            }
        }
        return data;
    }

    @Override
    protected void jump()
    {
        this.motionY = 0.52D / WorldUtil.getGravityFactor(this);

        if (this.motionY < 0.26D)
        {
            this.motionY = 0.26D;
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
    protected void dropRareDrop(int p_70600_1_)
    {
        switch (this.rand.nextInt(10))
        {
        case 0:
        case 1:
        case 9:
            break;
        case 2:
        case 3:
            this.dropItem(GCItems.cheeseCurd, 1);
            break;
        case 4:
        case 5:
            this.dropItem(Items.fermented_spider_eye, 1);
            break;
        case 6:
            //Oxygen tank half empty or less
            this.entityDropItem(new ItemStack(GCItems.oxTankMedium, 1, 901 + this.rand.nextInt(900)), 0.0F);
            break;
        case 7:
            this.dropItem(GCItems.oxygenGear, 1);
            break;
        case 8:
            this.dropItem(GCItems.oxygenConcentrator, 1);
            break;
        }
    }

    @Override
    public void onLivingUpdate()
    {
        if (this.getHealth() < this.getMaxHealth() / 2)
        {
            for (int k = 0; k < 2; ++k)
            {
                MorePlanetsCore.proxy.spawnMotionParticle("darkPortal", this.posX + (this.rand.nextDouble() - 0.5D) * this.width, this.posY + this.rand.nextDouble() * this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
            }
        }
        super.onLivingUpdate();
    }

    @Override
    public boolean attackEntityFrom(DamageSource damage, float damageAmount)
    {
        if (this.isEntityInvulnerable())
        {
            return false;
        }
        else
        {
            if (this.getHealth() < this.getMaxHealth() / 2)
            {
                Entity entity = damage.getEntity();

                if (entity instanceof EntityPlayer)
                {
                    if (this.rand.nextInt(5) == 0)
                    {
                        this.teleportRandomly();
                    }
                }
            }
            return super.attackEntityFrom(damage, damageAmount);
        }
    }

    private boolean teleportRandomly()
    {
        double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
        double d1 = this.posY + (this.rand.nextInt(64) - 32);
        double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
        return this.teleportTo(d0, d1, d2);
    }

    private boolean teleportTo(double x, double y, double z)
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
                MorePlanetsCore.proxy.spawnMotionParticle("darkPortal", d7, d8, d9, f, f1, f2);
            }
            this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
            this.playSound("mob.endermen.portal", 1.0F, 1.0F);
            return true;
        }
    }
}