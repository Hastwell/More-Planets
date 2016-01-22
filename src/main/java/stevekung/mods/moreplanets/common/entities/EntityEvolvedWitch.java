/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.entities;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.asteroids.darkasteroids.blocks.DarkAsteroidBlocks;
import stevekung.mods.moreplanets.asteroids.darkasteroids.dimension.WorldProviderDarkAsteroids;

public class EntityEvolvedWitch extends EntityMob implements IRangedAttackMob, IEntityBreathable
{
    private UUID field_110184_bp = UUID.fromString("8CD17E52-A79A-43D3-A529-90FDE04B181E");
    private AttributeModifier field_110185_bq = new AttributeModifier(this.field_110184_bp, "Drinking speed penalty", -0.25D, 0).setSaved(false);
    private Item[] witchDrops = new Item[] {Items.glowstone_dust, Items.sugar, Items.redstone, Items.spider_eye, Items.glass_bottle, Items.gunpowder, Items.stick, Items.stick};
    private int witchAttackTimer;

    public EntityEvolvedWitch(World world)
    {
        super(world);
        this.setSize(0.6F, 1.95F);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0D, 60, 10.0F));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataWatcher().addObject(21, Byte.valueOf((byte)0));
    }

    @Override
    protected String getLivingSound()
    {
        return "moreplanets:mob.witch.idle";
    }

    @Override
    protected String getHurtSound()
    {
        return "moreplanets:mob.witch.hurt";
    }

    @Override
    protected String getDeathSound()
    {
        return "moreplanets:mob.witch.death";
    }

    public void setAggressive(boolean p_82197_1_)
    {
        this.getDataWatcher().updateObject(21, Byte.valueOf((byte)(p_82197_1_ ? 1 : 0)));
    }

    public boolean getAggressive()
    {
        return this.getDataWatcher().getWatchableObjectByte(21) == 1;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(26.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }

    @Override
    public void onLivingUpdate()
    {
        if (!this.worldObj.isRemote)
        {
            if (this.getAggressive())
            {
                if (this.witchAttackTimer-- <= 0)
                {
                    this.setAggressive(false);
                    ItemStack itemstack = this.getHeldItem();
                    this.setCurrentItemOrArmor(0, (ItemStack)null);

                    if (itemstack != null && itemstack.getItem() == Items.potionitem)
                    {
                        List list = Items.potionitem.getEffects(itemstack);

                        if (list != null)
                        {
                            Iterator iterator = list.iterator();

                            while (iterator.hasNext())
                            {
                                PotionEffect potioneffect = (PotionEffect)iterator.next();
                                this.addPotionEffect(new PotionEffect(potioneffect));
                            }
                        }
                    }
                    this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).removeModifier(this.field_110185_bq);
                }
            }
            else
            {
                short short1 = -1;

                if (this.rand.nextFloat() < 0.15F && this.isInsideOfMaterial(Material.water) && !this.isPotionActive(Potion.waterBreathing))
                {
                    short1 = 8237;
                }
                else if (this.rand.nextFloat() < 0.15F && this.isBurning() && !this.isPotionActive(Potion.fireResistance))
                {
                    short1 = 16307;
                }
                else if (this.rand.nextFloat() < 0.05F && this.getHealth() < this.getMaxHealth())
                {
                    short1 = 16341;
                }
                else if (this.rand.nextFloat() < 0.25F && this.getAttackTarget() != null && !this.isPotionActive(Potion.moveSpeed) && this.getAttackTarget().getDistanceSqToEntity(this) > 121.0D)
                {
                    short1 = 16274;
                }
                else if (this.rand.nextFloat() < 0.25F && this.getAttackTarget() != null && !this.isPotionActive(Potion.moveSpeed) && this.getAttackTarget().getDistanceSqToEntity(this) > 121.0D)
                {
                    short1 = 16274;
                }

                if (short1 > -1)
                {
                    this.playSound("moreplanets:mob.witch.drink", this.getSoundVolume(), this.getSoundPitch());
                    this.setCurrentItemOrArmor(0, new ItemStack(Items.potionitem, 1, short1));
                    this.witchAttackTimer = this.getHeldItem().getMaxItemUseDuration();
                    this.setAggressive(true);
                    IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
                    iattributeinstance.removeModifier(this.field_110185_bq);
                    iattributeinstance.applyModifier(this.field_110185_bq);
                }
            }

            if (this.rand.nextFloat() < 7.5E-4F)
            {
                this.worldObj.setEntityState(this, (byte)15);
            }
        }
        super.onLivingUpdate();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 15)
        {
            for (int i = 0; i < this.rand.nextInt(35) + 10; ++i)
            {
                this.worldObj.spawnParticle(EnumParticleTypes.SPELL_WITCH, this.posX + this.rand.nextGaussian() * 0.12999999523162842D, this.getEntityBoundingBox().maxY + 0.5D + this.rand.nextGaussian() * 0.12999999523162842D, this.posZ + this.rand.nextGaussian() * 0.12999999523162842D, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        }
        else
        {
            super.handleStatusUpdate(id);
        }
    }

    @Override
    protected float applyPotionDamageCalculations(DamageSource p_70672_1_, float p_70672_2_)
    {
        p_70672_2_ = super.applyPotionDamageCalculations(p_70672_1_, p_70672_2_);

        if (p_70672_1_.getEntity() == this)
        {
            p_70672_2_ = 0.0F;
        }
        if (p_70672_1_.isMagicDamage())
        {
            p_70672_2_ = (float)(p_70672_2_ * 0.15D);
        }
        return p_70672_2_;
    }

    @Override
    protected void dropFewItems(boolean drop, int fortune)
    {
        int j = this.rand.nextInt(3) + 1;

        for (int k = 0; k < j; ++k)
        {
            int l = this.rand.nextInt(3);
            Item item = this.witchDrops[this.rand.nextInt(this.witchDrops.length)];

            if (fortune > 0)
            {
                l += this.rand.nextInt(fortune + 1);
            }

            for (int i1 = 0; i1 < l; ++i1)
            {
                this.dropItem(item, 1);
            }
        }
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase living, float p_82196_2_)
    {
        if (!this.getAggressive())
        {
            EntityPotion entitypotion = new EntityPotion(this.worldObj, this, 32732);
            double d0 = living.posY + living.getEyeHeight() - 1.100000023841858D;
            entitypotion.rotationPitch -= -20.0F;
            double d1 = living.posX + living.motionX - this.posX;
            double d2 = d0 - this.posY;
            double d3 = living.posZ + living.motionZ - this.posZ;
            float f1 = MathHelper.sqrt_double(d1 * d1 + d3 * d3);

            if (f1 >= 8.0F && !living.isPotionActive(Potion.moveSlowdown))
            {
                entitypotion.setPotionDamage(32698);
            }
            else if (living.getHealth() >= 8.0F && !living.isPotionActive(Potion.poison))
            {
                entitypotion.setPotionDamage(32660);
            }
            else if (f1 <= 3.0F && !living.isPotionActive(Potion.weakness) && this.rand.nextFloat() < 0.25F)
            {
                entitypotion.setPotionDamage(32696);
            }
            this.playSound("moreplanets:mob.witch.throw", this.getSoundVolume(), this.getSoundPitch());
            entitypotion.setThrowableHeading(d1, d2 + f1 * 0.2F, d3, 0.75F, 8.0F);
            this.worldObj.spawnEntityInWorld(entitypotion);
        }
    }

    @Override
    protected float getSoundVolume()
    {
        return 0.6F;
    }

    @Override
    public float getEyeHeight()
    {
        return 1.62F;
    }

    @Override
    public boolean canBreath()
    {
        return true;
    }

    @Override
    protected void addRandomDrop()
    {
        switch (this.rand.nextInt(10))
        {
        case 0:
        case 1:
        case 9:
            //Dehydrated carrot
            this.entityDropItem(new ItemStack(GCItems.basicItem, 1, 16), 0.0F);
            break;
        case 2:
        case 3:
            this.entityDropItem(new ItemStack(this.worldObj.provider instanceof WorldProviderDarkAsteroids ? DarkAsteroidBlocks.dark_asteroid_rock : Blocks.glowstone, 1, 8), 0.0F);
            break;
        case 4:
        case 5:
            this.entityDropItem(new ItemStack(GCItems.basicItem, 1, 20), 0.0F);
            break;
        case 6:
            //Oxygen tank half empty or less
            this.entityDropItem(new ItemStack(GCItems.oxTankHeavy, 1, 901 + this.rand.nextInt(900)), 0.0F);
            break;
        case 7:
            this.dropItem(GCItems.oxMask, 1);
            break;
        case 8:
            this.dropItem(GCItems.oxygenVent, 1);
            break;
        }
    }
}