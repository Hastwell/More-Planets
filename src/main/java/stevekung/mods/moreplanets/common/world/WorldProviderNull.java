/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.world;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import stevekung.mods.moreplanets.common.dimension.WorldProviderMP;
import stevekung.mods.moreplanets.common.util.MPLog;

public class WorldProviderNull extends WorldProviderMP
{
	private static String name;

	public static void setName(String name)
	{
		WorldProviderNull.name = name;
		MPLog.debug("Get setName %s", WorldProviderNull.name);
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
	public long getDayLength()
	{
		return 24000L;
	}

	@Override
	public Class<? extends IChunkProvider> getChunkProviderClass()
	{
		return ChunkProviderNull.class;
	}

	@Override
	public Class<? extends WorldChunkManager> getWorldChunkManagerClass()
	{
		return null;
	}

	@Override
	public double getSolarEnergyMultiplier()
	{
		return 0.0D;
	}

	@Override
	public float getGravity()
	{
		return 0.0F;
	}

	@Override
	public double getMeteorFrequency()
	{
		return 0.0D;
	}

	@Override
	public boolean canSpaceshipTierPass(int tier)
	{
		return false;
	}

	@Override
	public float getFallDamageModifier()
	{
		return 0.0F;
	}

	@Override
	public float getSoundVolReductionAmount()
	{
		return 0.0F;
	}

	@Override
	public String getDimensionName()
	{
		return WorldProviderNull.name;
	}

	@Override
	public String getSaveFolder()
	{
		return "DIM-" + WorldProviderNull.name.toUpperCase();
	}

	@Override
	public String getWelcomeMessage()
	{
		return "Entering " + WorldProviderNull.name;
	}

	@Override
	public String getDepartMessage()
	{
		return "Leaving " + WorldProviderNull.name;
	}

	@Override
	public CelestialBody getCelestialBody()
	{
		return null;
	}

	@Override
	public boolean isGasPresent(IAtmosphericGas gas)
	{
		return false;
	}

	@Override
	public float getSolarSize()
	{
		return 1.0F;
	}

	@Override
	public boolean hasBreathableAtmosphere()
	{
		return false;
	}

	@Override
	public float getThermalLevelModifier()
	{
		return 0.0F;
	}

	@Override
	public float getWindLevel()
	{
		return 0.0F;
	}

	@Override
	public double getUltraVioletEnergyMultiplie()
	{
		return 0.0D;
	}

	@Override
	public String getInternalNameSuffix()
	{
		return "_" + WorldProviderNull.name.toLowerCase();
	}
}