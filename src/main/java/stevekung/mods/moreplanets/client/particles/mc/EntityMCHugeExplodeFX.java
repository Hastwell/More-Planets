package stevekung.mods.moreplanets.client.particles.mc;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.client.EnumParticleTypesMP;
import stevekung.mods.moreplanets.core.MorePlanetsCore;

@SideOnly(Side.CLIENT)
public class EntityMCHugeExplodeFX extends EntityFX
{
	private int timeSinceStart;
	private int maximumTime = 8;

	public EntityMCHugeExplodeFX(World world, double x, double y, double z)
	{
		super(world, x, y, z, 0.0D, 0.0D, 0.0D);
	}

	@Override
	public void onUpdate()
	{
		for (int i = 0; i < 6; ++i)
		{
			double d0 = this.posX + (this.rand.nextDouble() - this.rand.nextDouble()) * 4.0D;
			double d1 = this.posY + (this.rand.nextDouble() - this.rand.nextDouble()) * 4.0D;
			double d2 = this.posZ + (this.rand.nextDouble() - this.rand.nextDouble()) * 4.0D;
			MorePlanetsCore.proxy.spawnParticle(EnumParticleTypesMP.MC_EXPLOSION_LARGE, d0, d1, d2, (float)this.timeSinceStart / (float)this.maximumTime, 0.0D, 0.0D);
		}

		++this.timeSinceStart;

		if (this.timeSinceStart == this.maximumTime)
		{
			this.setDead();
		}
	}

	@Override
	public int getFXLayer()
	{
		return 1;
	}
}