package stevekung.mods.moreplanets.common.todo;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityBlackHole extends Entity
{
    private double mass;
    private double radius = this.mass / 888.8888888888889;

    public EntityBlackHole(World world)
    {
        super(world);
    }

    @Override
    public void onUpdate()
    {
        List<Entity> entitiesAround = this.worldObj.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.fromBounds(this.posX - 24 - this.radius, this.posY - 24 - this.radius, this.posZ - 24 - this.radius, this.posX + 24 + this.radius, this.posY + 24 + this.radius, this.posZ + 24 + this.radius));

        for (Entity e : entitiesAround)
        {
            if (e instanceof EntityPlayer && ((EntityPlayer)e).capabilities.isCreativeMode)
            {
            }
            else if (e instanceof EntityBlackHole && e != this)
            {
                this.mass += ((EntityBlackHole) e).mass;
                this.worldObj.removeEntity(e);
            }
            else
            {
                double motionX = this.posX - e.posX;
                double motionY = this.posY - e.posY;
                double motionZ = this.posZ - e.posZ;

                e.motionX = motionX * 0.05F;
                e.motionY = motionY * 0.05F;
                e.motionZ = motionZ * 0.05F;

                for (int i = -2; i <= 2; i++)
                {
                    if (e.posX >= this.posX + i && e.posY >= this.posY + i && e.posZ >= this.posZ + i)
                    {
                        List<Entity> dm = this.worldObj.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.fromBounds(this.posX + 2.25D, this.posY + 2.25D, this.posZ + 2.25D, this.posX - 2.25D, this.posY - 2.25D, this.posZ - 2.25D));

                        for (Entity edm : dm)
                        {
                            if (e instanceof EntityBlackHole && e != this)
                            {
                                this.worldObj.removeEntity(edm);
                            }
                            edm.attackEntityFrom(DamageSource.generic, 7.5F);
                        }
                    }
                }
            }

        }

        if (this.mass >= 80000)
        {
            if (!this.worldObj.isRemote)
            {
                this.worldObj.removeEntity(this);
            }
        }
        super.onUpdate();
    }

    @Override
    protected void entityInit() {}

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbt)
    {
        this.mass = nbt.getDouble("Mass");
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbt)
    {
        nbt.setDouble("Mass", this.mass);
    }
}