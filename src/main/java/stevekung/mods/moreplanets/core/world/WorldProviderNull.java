package stevekung.mods.moreplanets.core.world;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import stevekung.mods.moreplanets.core.MorePlanetsCore;
import stevekung.mods.moreplanets.core.dimension.WorldProviderMP;

public class WorldProviderNull extends WorldProviderMP
{
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
		return tier == 0;
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
	public CelestialBody getCelestialBody()
	{
		return MorePlanetsCore.jupiter;
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
}