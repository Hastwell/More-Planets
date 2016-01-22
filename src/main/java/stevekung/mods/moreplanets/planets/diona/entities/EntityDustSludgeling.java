/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.entities;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import micdoodle8.mods.galacticraft.planets.mars.entities.EntitySlimeling;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.planets.diona.blocks.BlockDiona;
import stevekung.mods.moreplanets.planets.diona.blocks.DionaBlocks;

public class EntityDustSludgeling extends EntityMob implements IEntityBreathable
{
    public EntityDustSludgeling(World world)
    {
        super(world);
        this.setSize(0.2F, 0.2F);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 0.25F, true));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityEvolvedZombie.class, false, true));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityEvolvedSkeleton.class, false, true));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityEvolvedSpider.class, false, true));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityEvolvedCreeper.class, false, true));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntitySlimeling.class, false));
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
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(7.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8000000238418579D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }

    @Override
    protected String getLivingSound()
    {
        return "mob.silverfish.say";
    }

    @Override
    protected String getHurtSound()
    {
        return "mob.silverfish.hit";
    }

    @Override
    protected String getDeathSound()
    {
        return "mob.silverfish.kill";
    }

    @Override
    public float getEyeHeight()
    {
        return 0.1F;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block block)
    {
        this.worldObj.playSoundAtEntity(this, "mob.silverfish.step", 1.0F, 1.0F);
    }

    @Override
    public void onUpdate()
    {
        this.renderYawOffset = this.rotationYaw;
        super.onUpdate();
    }

    @Override
    public void onLivingUpdate()
    {
        if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(2) == 0)
        {
            int x = MathHelper.floor_double(this.posX);
            int y = MathHelper.floor_double(this.posY - 0.20000000298023224D);
            int z = MathHelper.floor_double(this.posZ);
            IBlockState block = this.worldObj.getBlockState(new BlockPos(x, y, z));

            if (block == DionaBlocks.diona_block.getDefaultState().withProperty(BlockDiona.VARIANT, BlockDiona.BlockType.diona_surface_rock))
            {
                this.worldObj.spawnParticle(EnumParticleTypes.BLOCK_CRACK, this.posX + (this.rand.nextFloat() - 0.5D) * this.width, this.getEntityBoundingBox().minY + 0.1D, this.posZ + (this.rand.nextFloat() - 0.5D) * this.width, 4.0D * (this.rand.nextFloat() - 0.5D), 0.5D, (this.rand.nextFloat() - 0.5D) * 4.0D, new int[] {Block.getStateId(DionaBlocks.diona_block.getDefaultState().withProperty(BlockDiona.VARIANT, BlockDiona.BlockType.diona_surface_rock))});
            }
            else if (block == DionaBlocks.diona_block.getDefaultState().withProperty(BlockDiona.VARIANT, BlockDiona.BlockType.diona_sub_surface_rock))
            {
                this.worldObj.spawnParticle(EnumParticleTypes.BLOCK_CRACK, this.posX + (this.rand.nextFloat() - 0.5D) * this.width, this.getEntityBoundingBox().minY + 0.1D, this.posZ + (this.rand.nextFloat() - 0.5D) * this.width, 4.0D * (this.rand.nextFloat() - 0.5D), 0.5D, (this.rand.nextFloat() - 0.5D) * 4.0D, new int[] {Block.getStateId(DionaBlocks.diona_block.getDefaultState().withProperty(BlockDiona.VARIANT, BlockDiona.BlockType.diona_sub_surface_rock))});
            }
        }
        super.onLivingUpdate();
    }

    @Override
    protected boolean isValidLightLevel()
    {
        return true;
    }

    @Override
    public boolean getCanSpawnHere()
    {
        if (super.getCanSpawnHere())
        {
            EntityPlayer player = this.worldObj.getClosestPlayerToEntity(this, 5.0D);
            return player == null;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean canBreath()
    {
        return true;
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.ARTHROPOD;
    }
}