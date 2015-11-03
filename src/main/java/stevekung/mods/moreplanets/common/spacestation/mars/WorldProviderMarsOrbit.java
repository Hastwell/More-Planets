package stevekung.mods.moreplanets.common.spacestation.mars;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.dimension.WorldProviderOrbit;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.core.MorePlanetsCore;

public class WorldProviderMarsOrbit extends WorldProviderOrbit
{
	public int spaceStationDimensionID;
	@Override
	public void setDimension(int id)
	{
		this.spaceStationDimensionID = id;
		super.setDimension(id);
	}

	@Override
	public CelestialBody getCelestialBody()
	{
		return MorePlanetsCore.marsSpaceStation;
	}

	@Override
	public Vector3 getFogColor()
	{
		return new Vector3(0, 0, 0);
	}

	@Override
	public Vector3 getSkyColor()
	{
		return new Vector3(0, 0, 0);
	}

	@Override
	public boolean canRainOrSnow()
	{
		return false;
	}

	@Override
	public boolean hasSunset()
	{
		return false;
	}

	@Override
	public long getDayLength()
	{
		return 24000L;
	}

	@Override
	public boolean shouldForceRespawn()
	{
		return !ConfigManagerCore.forceOverworldRespawn;
	}

	@Override
	public Class<? extends IChunkProvider> getChunkProviderClass()
	{
		return ChunkProviderMarsOrbit.class;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1)
	{
		float var2 = this.worldObj.getCelestialAngle(par1);
		float var3 = 1.0F - (MathHelper.cos(var2 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);

		if (var3 < 0.0F)
		{
			var3 = 0.0F;
		}
		if (var3 > 1.0F)
		{
			var3 = 1.0F;
		}
		return var3 * var3 * 0.5F + 0.3F;
	}

	@Override
	public boolean isSkyColored()
	{
		return false;
	}

	@Override
	public double getHorizon()
	{
		return 44.0D;
	}

	@Override
	public int getAverageGroundLevel()
	{
		return 44;
	}

	@Override
	public boolean isSurfaceWorld()
	{
		return true;
	}

	@Override
	public boolean canCoordinateBeSpawn(int x, int z)
	{
		return true;
	}

	@Override
	public String getDimensionName()
	{
		return "Space Station " + this.spaceStationDimensionID;
	}

	@Override
	public boolean canSnowAt(BlockPos pos, boolean checkLight)
	{
		return false;
	}

	@Override
	public float getGravity()
	{
		return 0.075F;//0.073F;
	}

	@Override
	public boolean hasBreathableAtmosphere()
	{
		return false;
	}

	@Override
	public double getMeteorFrequency()
	{
		return 0;
	}

	@Override
	public double getFuelUsageMultiplier()
	{
		return 0.5D;
	}

	@Override
	public String getPlanetToOrbit()
	{
		return "planet.mars";
	}

	@Override
	public int getYCoordToTeleportToPlanet()
	{
		return 30;
	}

	@Override
	public String getSaveFolder()
	{
		return "DIM_SPACESTATION" + this.spaceStationDimensionID;
	}

	@Override
	public double getSolarEnergyMultiplier()
	{
		return ConfigManagerCore.spaceStationEnergyScalar - 2.0D;//TODO
	}

	@Override
	public double getYCoordinateToTeleport()
	{
		return 1200;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier)
	{
		return tier > 0;
	}

	@Override
	public float getFallDamageModifier()
	{
		return 0.4F;
	}

	@Override
	public float getSoundVolReductionAmount()
	{
		return 50.0F;
	}

	/**
	 * Sets the spin rate for the dimension in radians per tick For example,
	 * 0.031415 would be 1/200 revolution per tick So that would be 1 revolution
	 * every 10 seconds
	 */
	@Override
	public void setSpinRate(float angle)
	{
		super.setSpinRate(angle);
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
		{
			this.updateSkyProviderSpinRate();
		}
	}

	@SideOnly(Side.CLIENT)
	private void updateSkyProviderSpinRate()
	{
		this.getSkyRenderer();

		/*if (sky instanceof SkyProviderJupiterOrbit)
		{
			((SkyProviderJupiterOrbit) sky).spinDeltaPerTick = this.skyAngularVelocity;
		}*/
	}

	@Override
	public void setSpinRate(float angle, boolean firing)
	{
		super.setSpinRate(angle, firing);
		this.getSkyRenderer();

		/*if (sky instanceof SkyProviderJupiterOrbit)
		{
			((SkyProviderJupiterOrbit) sky).spinDeltaPerTick = this.skyAngularVelocity;
		}*/
		this.thrustersFiring = firing;
	}

	@Override
	public float getThermalLevelModifier()
	{
		return 0;
	}

	@Override
	public float getWindLevel()
	{
		return 0.1F;
	}
}