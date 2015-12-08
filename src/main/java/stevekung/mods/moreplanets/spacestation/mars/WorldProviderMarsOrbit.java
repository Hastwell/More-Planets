/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.spacestation.mars;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.core.dimension.WorldProviderOrbit;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.world.IUltraVioletLevel;
import stevekung.mods.moreplanets.core.init.MPPlanets;

public class WorldProviderMarsOrbit extends WorldProviderOrbit implements IUltraVioletLevel
{
	public int spaceStationDimensionID;
	private float angularVelocityRadians = 0F;
	private float skyAngularVelocity = (float) (this.angularVelocityRadians * 180 / Math.PI);

	@Override
	public void setDimension(int id)
	{
		this.spaceStationDimensionID = id;
		super.setDimension(id);
	}

	@Override
	public long getDayLength()
	{
		return 0;
	}

	@Override
	public float calculateCelestialAngle(long par1, float par3)
	{
		return 0.1975F;
	}

	@Override
	public CelestialBody getCelestialBody()
	{
		return MPPlanets.marsSpaceStation;
	}

	@Override
	public Class<? extends IChunkProvider> getChunkProviderClass()
	{
		return ChunkProviderMarsOrbit.class;
	}

	@Override
	public String getDimensionName()
	{
		return "Mars Space Station " + this.spaceStationDimensionID;
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
	public double getYCoordinateToTeleport()
	{
		return 1200;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier)
	{
		return tier > 2;
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
		this.angularVelocityRadians = angle;
		this.skyAngularVelocity = angle * 180F / 3.1415927F;

		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
		{
			this.updateSkyProviderSpinRate();
		}
	}

	@SideOnly(Side.CLIENT)
	private void updateSkyProviderSpinRate()
	{
		IRenderHandler sky = this.getSkyRenderer();

		if (sky instanceof SkyProviderMarsOrbit)
		{
			((SkyProviderMarsOrbit)sky).spinDeltaPerTick = this.skyAngularVelocity;
		}
	}

	@Override
	public void setSpinRate(float angle, boolean firing)
	{
		super.setSpinRate(angle, firing);
		this.angularVelocityRadians = angle;
		this.skyAngularVelocity = angle * 180F / 3.1415927F;
		IRenderHandler sky = this.getSkyRenderer();

		if (sky instanceof SkyProviderMarsOrbit)
		{
			((SkyProviderMarsOrbit)sky).spinDeltaPerTick = this.skyAngularVelocity;
		}
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

	@Override
	public double getUltraVioletEnergyMultiplie()
	{
		return 6.0D;
	}
}